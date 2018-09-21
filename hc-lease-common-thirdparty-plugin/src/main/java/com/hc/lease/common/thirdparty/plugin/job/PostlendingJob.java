package com.hc.lease.common.thirdparty.plugin.job;

import com.aipg.transquery.QTDetail;
import com.allinpay.model.QuickReturnMessage;
import com.google.common.collect.Maps;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.DubboTreactid;
import com.hc.lease.common.core.constant.PayWay;
import com.hc.lease.common.core.constant.PaymentResult;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.vo.FindQueryTradeNewVo;
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import com.hc.lease.postlending.vo.TransBody;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 定时器  定时轮询通联交易结果 / 并处理更新交易状态
 * Created by tong on 2017/6/30.
 */
@Lazy(false)
@Component("postlendingJob")
public class PostlendingJob {

    private Logger logger = LoggerFactory.getLogger(PostlendingJob.class);

    @Autowired
    MonthlyPaymentAdapter monthlyPaymentAdapter;

    //每5分钟触发一次  轮询通联交易结果
    @Scheduled(cron = "${job.queryTradeNew.corn}")
    public void postlendingJobQueryTradeNew() throws GMException {
        logger.trace("======定时器  定时轮询通联交易结果 / 并处理更新交易状态=====");
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job.PostlendingJob");//接口名称
        dubboTreaceParames.setTreaceMethodName("postlendingJobQueryTradeNew");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        ResultHashMap resultHashMap = monthlyPaymentAdapter.findQueryTradeNew(null, dubboTreaceParames);// 需要轮询通联 的 交易流水/状态为扣款中
        List leaseSchemeRepaymentStatusList = (List) resultHashMap.get("result");// 需要轮询通联 的 交易流水/状态为扣款中
        if (leaseSchemeRepaymentStatusList != null) {
            if (leaseSchemeRepaymentStatusList.size() > 0) {
                TransBody transBody = new TransBody();
                for (int i = 0; i < leaseSchemeRepaymentStatusList.size(); i++) {
                    FindQueryTradeNewVo findQueryTradeNewVo = (FindQueryTradeNewVo) leaseSchemeRepaymentStatusList.get(i);
                    Long repaymentId = findQueryTradeNewVo.getRepaymentId();
                    Long contractId = findQueryTradeNewVo.getContractId();
                    Integer paymentResult = findQueryTradeNewVo.getPaymentResult();
                    String reqSn = findQueryTradeNewVo.getReqSn();
                    String sn = findQueryTradeNewVo.getSn();
                    Integer type = findQueryTradeNewVo.getType();
                    Long allinpayLogId = findQueryTradeNewVo.getAllinpayLogId();
                    Integer overdueType = findQueryTradeNewVo.getOverdueType();
                    Long repaymentStatusId = findQueryTradeNewVo.getId();
                    Integer singleOrBatch = findQueryTradeNewVo.getSingleOrBatch();
                    Integer payWay = findQueryTradeNewVo.getPayWay();

                    //支付状态 为 1扣款中
                    if (paymentResult.equals(PaymentResult.TYPE_1)) {
                        transBody.setReqSn(reqSn);
                        transBody.setSn(sn);
                        transBody.setRepaymentId(repaymentId);
                        transBody.setContractId(contractId);
                        transBody.setRepaymentStatusId(repaymentStatusId);
                        transBody.setPayType(type);
                        transBody.setOverdueType(overdueType);
                        transBody.setAllinpayLogId(allinpayLogId);
                        transBody.setSingleOrBatch(singleOrBatch);
                        transBody.setPayWay(payWay);
                        if (payWay.equals(PayWay.ALLIPAY)) queryTradeNew(transBody, dubboTreaceParames);//交易查询/轮询/通联代扣
                        if (payWay.equals(PayWay.ALLIPAY_QUICK)) search(transBody, dubboTreaceParames);//交易查询/轮询/通联协议支付
                    }
                }

                //monthlyPaymentAdapter.dualAllinpaySendSmsInfoInstall(dubboTreaceParames);//扣款发送短信提醒

            }
        }

    }

    /**
     * 交易查询/轮询/通联平台查询
     * 通联代扣
     *
     * @throws GMException
     */
    public void queryTradeNew(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put(DubboTreactid.traceId.value(), DubboTreactid.MonthlyPaymentController_queryTradeNew.value() + System.currentTimeMillis());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        ResultHashMap resultHashMap = monthlyPaymentAdapter.queryTradeNew(transBody, dubboTreaceParames);//交易查询/轮询/通联平台查询
        ReturnMessage returnMessage = (ReturnMessage) resultHashMap.get("result");
        returnMessage.setReqSn(transBody.getReqSn());
        returnMessage.setSn(transBody.getSn());
        returnMessage.setRepaymentId(transBody.getRepaymentId());
        returnMessage.setContractId(transBody.getContractId());
        returnMessage.setRepaymentStatusId(transBody.getRepaymentStatusId());
        returnMessage.setType(transBody.getPayType());
        returnMessage.setOverdueType(transBody.getOverdueType());
        returnMessage.setAllinpayLogId(transBody.getAllinpayLogId());
        returnMessage.setSingleOrBatch(transBody.getSingleOrBatch());
        changeSchemeRepaymentStatus(returnMessage, dubboTreaceParames);
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 还款记录 状态
     * 通联代扣
     *
     * @throws GMException
     */
    public void changeSchemeRepaymentStatus(ReturnMessage returnMessage, DubboTreaceParames dubboTreaceParames) throws GMException {
        TransBody transBody = new TransBody();
        transBody.setAipgrspRetCode(returnMessage.getAipgrspRetCode());
        transBody.setAipgrspErrMsg(returnMessage.getAipgrspErrmsg());
        transBody.setReqSn(returnMessage.getReqSn());
        transBody.setPayType(returnMessage.getType());
        transBody.setOverdueType(returnMessage.getOverdueType());

        List<QTDetail> qTDetailList = returnMessage.getQueryDetails();
        if (qTDetailList != null) {
            if (qTDetailList.size() > 0) {
                for (int i = 0; i < qTDetailList.size(); i++) {
                    QTDetail qTDetail = qTDetailList.get(i);
                    String QT_SN = qTDetail.getSN();
                    String BATCHID = qTDetail.getBATCHID();
                    if (BATCHID.equals(transBody.getReqSn())) {
                        returnMessage.setRetCode(qTDetail.getRET_CODE());
                        returnMessage.setErrMsg(qTDetail.getERR_MSG());
                        returnMessage.setFinTime(qTDetail.getFINTIME());
                        //如果是批扣
                        if (returnMessage.getSingleOrBatch() == 1) {
                            if (QT_SN.equals(returnMessage.getSn())) {
                                dealChangeSchemeRepaymentStatus(transBody, returnMessage, monthlyPaymentAdapter, dubboTreaceParames);
                            }
                        } else {
                            dealChangeSchemeRepaymentStatus(transBody, returnMessage, monthlyPaymentAdapter, dubboTreaceParames);
                        }
                    }
                }
            }
        }
    }

    /**
     * 交易查询/轮询/通联平台查询
     * 通联协议支付
     *
     * @throws GMException
     */
    public void search(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put(DubboTreactid.traceId.value(), DubboTreactid.MonthlyPaymentController_queryTradeNew.value() + System.currentTimeMillis());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        ResultHashMap resultHashMap = monthlyPaymentAdapter.search(transBody, dubboTreaceParames);//处理通联平台查询
        QuickReturnMessage quickReturnMessage = (QuickReturnMessage) resultHashMap.get("result");
        quickReturnMessage.setReqSn(transBody.getReqSn());
        quickReturnMessage.setSn(transBody.getSn());
        quickReturnMessage.setRepaymentId(transBody.getRepaymentId());
        quickReturnMessage.setContractId(transBody.getContractId());
        quickReturnMessage.setRepaymentStatusId(transBody.getRepaymentStatusId());
        quickReturnMessage.setType(transBody.getPayType());
        quickReturnMessage.setOverdueType(transBody.getOverdueType());
        quickReturnMessage.setAllinpayLogId(transBody.getAllinpayLogId());
        quickReturnMessage.setSingleOrBatch(transBody.getSingleOrBatch());
        changeSchemeRepaymentQuickStatus(quickReturnMessage, dubboTreaceParames);
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 还款记录 状态
     * 通联协议支付
     *
     * @throws GMException
     */
    public void changeSchemeRepaymentQuickStatus(QuickReturnMessage quickReturnMessage, DubboTreaceParames dubboTreaceParames) throws GMException {
        TransBody transBody = new TransBody();
        transBody.setAipgrspRetCode(quickReturnMessage.getAipgrspRetCode());
        transBody.setAipgrspErrMsg(quickReturnMessage.getAipgrspErrmsg());
        transBody.setReqSn(quickReturnMessage.getReqSn());
        transBody.setPayType(quickReturnMessage.getType());
        transBody.setOverdueType(quickReturnMessage.getOverdueType());
        List<com.allinpay.param.query.QTDetail> qTDetailList = quickReturnMessage.getQueryDetails();
        if (qTDetailList != null) {
            if (qTDetailList.size() > 0) {
                for (int i = 0; i < qTDetailList.size(); i++) {
                    com.allinpay.param.query.QTDetail qTDetail = qTDetailList.get(i);
                    String BATCHID = qTDetail.getBATCHID();
                    if (BATCHID.equals(transBody.getReqSn())) {
                        ReturnMessage returnMessage = new ReturnMessage();
                        returnMessage.setReqSn(transBody.getReqSn());
                        returnMessage.setSn(quickReturnMessage.getSn());
                        returnMessage.setRepaymentId(quickReturnMessage.getRepaymentId());
                        returnMessage.setContractId(quickReturnMessage.getContractId());
                        returnMessage.setRepaymentStatusId(quickReturnMessage.getRepaymentStatusId());
                        returnMessage.setType(quickReturnMessage.getType());
                        returnMessage.setOverdueType(quickReturnMessage.getOverdueType());
                        returnMessage.setAllinpayLogId(quickReturnMessage.getAllinpayLogId());
                        returnMessage.setSingleOrBatch(quickReturnMessage.getSingleOrBatch());
                        returnMessage.setRetCode(qTDetail.getRET_CODE());
                        returnMessage.setErrMsg(qTDetail.getERR_MSG());
                        returnMessage.setFinTime(qTDetail.getFINTIME());
                        dealChangeSchemeRepaymentStatus(transBody, returnMessage, monthlyPaymentAdapter, dubboTreaceParames);
                    }
                }
            }
        }
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 统一入口
     *
     * @param transBody
     * @param returnMessage
     * @param monthlyPaymentAdapter
     * @throws GMException
     */
    public void dealChangeSchemeRepaymentStatus(TransBody transBody, ReturnMessage returnMessage, MonthlyPaymentAdapter monthlyPaymentAdapter, DubboTreaceParames dubboTreaceParames) throws GMException {
        transBody.setSn(returnMessage.getSn());//批量代收才有此参数
        transBody.setRetCode(returnMessage.getRetCode());
        transBody.setErrMsg(returnMessage.getErrMsg());
        transBody.setFinTime(returnMessage.getFinTime());
        transBody.setRepaymentId(returnMessage.getRepaymentId());
        transBody.setContractId(returnMessage.getContractId());
        transBody.setRepaymentStatusId(returnMessage.getRepaymentStatusId());
        transBody.setAllinpayLogId(returnMessage.getAllinpayLogId());
        monthlyPaymentAdapter.changeSchemeRepaymentStatus(transBody, dubboTreaceParames);
    }

}
