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
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import com.hc.lease.postlending.vo.FindQueryTradeNewSplitVo;
import com.hc.lease.postlending.vo.TransBody;
import com.hc.lease.postlending.vo.TransSplitBody;
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
 * 定时器 定时轮询通联超额拆分交易结果 / 并处理更新交易状态
 * Created by tong on 2018/6/21
 */
@Lazy(false)
@Component("postlendingSplitJob")
public class PostlendingSplitJob {

    private Logger logger = LoggerFactory.getLogger(PostlendingSplitJob.class);

    @Autowired
    MonthlyPaymentAdapter monthlyPaymentAdapter;

    //每日10点触发一次  轮询通联交易结果
    @Scheduled(cron = "${job.queryTradeNewSplit.corn}")
    public void postlendingJobQueryTradeNewSplit() throws GMException {
        logger.trace("======定时器  定时轮询通联超额拆分交易结果 / 并处理更新交易状态=====");
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job.PostlendingSplitJob");//接口名称
        dubboTreaceParames.setTreaceMethodName("postlendingJobQueryTradeNewSplit");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        ResultHashMap resultHashMap = monthlyPaymentAdapter.findQueryTradeNewSplit(null, dubboTreaceParames);// 需要轮询通联 的 交易流水/状态为扣款中

        List leaseAllinpaySplitList = (List) resultHashMap.get("result");// 需要轮询通联 的 交易流水/状态为扣款中
        if (leaseAllinpaySplitList != null) {
            if (leaseAllinpaySplitList.size() > 0) {
                TransSplitBody transSplitBody = new TransSplitBody();
                for (int i = 0; i < leaseAllinpaySplitList.size(); i++) {
                    FindQueryTradeNewSplitVo findQueryTradeNewSplitVo = (FindQueryTradeNewSplitVo) leaseAllinpaySplitList.get(i);
                    Long repaymentId = findQueryTradeNewSplitVo.getRepaymentId();
                    Long contractId = findQueryTradeNewSplitVo.getContractId();
                    Integer paymentResult = findQueryTradeNewSplitVo.getPaymentResult();
                    String reqSn = findQueryTradeNewSplitVo.getReqSn();
                    String sn = findQueryTradeNewSplitVo.getSn();
                    Long allinpaySplitLogId = findQueryTradeNewSplitVo.getAllinpaySplitLogId();
                    Long allinpaySplitId = findQueryTradeNewSplitVo.getId();
                    Integer singleOrBatch = findQueryTradeNewSplitVo.getSingleOrBatch();
                    Integer payWay = findQueryTradeNewSplitVo.getPayWay();

                    //支付状态 为 1扣款中
                    if (paymentResult.equals(PaymentResult.TYPE_1)) {
                        transSplitBody.setReqSn(reqSn);
                        transSplitBody.setSn(sn);
                        transSplitBody.setRepaymentId(repaymentId);
                        transSplitBody.setContractId(contractId);
                        transSplitBody.setAllinpaySplitId(allinpaySplitId);
                        transSplitBody.setAllinpaySplitLogId(allinpaySplitLogId);
                        transSplitBody.setSingleOrBatch(singleOrBatch);
                        transSplitBody.setPayWay(payWay);
                        if (payWay.equals(PayWay.ALLIPAY))
                            queryTradeNew(transSplitBody, dubboTreaceParames);//交易查询/轮询/通联代扣
                        if (payWay.equals(PayWay.ALLIPAY_QUICK))
                            search(transSplitBody, dubboTreaceParames);//交易查询/轮询/通联协议支付
                    }
                }

                //monthlyPaymentAdapter.dualAllinpaySendSmsInfoInstall(dubboTreaceParames);//扣款发送短信提醒

            }
        }

    }

    /**
     * 交易查询/轮询/通联平台查询
     * 超额拆分交易
     * 通联代扣
     *
     * @throws GMException
     */
    public void queryTradeNew(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put(DubboTreactid.traceId.value(), DubboTreactid.MonthlyPaymentController_queryTradeNewSplit.value() + System.currentTimeMillis());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        TransBody transBody = new TransBody();
        transBody.setReqSn(transSplitBody.getReqSn());
        ResultHashMap resultHashMap = monthlyPaymentAdapter.queryTradeNew(transBody, dubboTreaceParames);//交易查询/轮询/通联平台查询
        ReturnMessage returnMessage = (ReturnMessage) resultHashMap.get("result");
        returnMessage.setReqSn(transSplitBody.getReqSn());
        returnMessage.setSn(transSplitBody.getSn());
        returnMessage.setRepaymentId(transSplitBody.getRepaymentId());
        returnMessage.setContractId(transSplitBody.getContractId());
        returnMessage.setAllinpaySplitId(transSplitBody.getAllinpaySplitId());
        returnMessage.setAllinpaySplitLogId(transSplitBody.getAllinpaySplitLogId());
        returnMessage.setSingleOrBatch(transSplitBody.getSingleOrBatch());
        changeSchemeRepaymentStatus(returnMessage, dubboTreaceParames);
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 还款记录 状态
     * <p>
     * 通联代扣
     *
     * @throws GMException
     */
    public void changeSchemeRepaymentStatus(ReturnMessage returnMessage, DubboTreaceParames dubboTreaceParames) throws GMException {
        TransSplitBody transSplitBody = new TransSplitBody();
        transSplitBody.setAipgrspRetCode(returnMessage.getAipgrspRetCode());
        transSplitBody.setAipgrspErrMsg(returnMessage.getAipgrspErrmsg());
        transSplitBody.setReqSn(returnMessage.getReqSn());

        List<QTDetail> qTDetailList = returnMessage.getQueryDetails();
        if (qTDetailList != null) {
            if (qTDetailList.size() > 0) {
                for (int i = 0; i < qTDetailList.size(); i++) {
                    QTDetail qTDetail = qTDetailList.get(i);
                    String QT_SN = qTDetail.getSN();
                    String BATCHID = qTDetail.getBATCHID();
                    if (BATCHID.equals(transSplitBody.getReqSn())) {
                        returnMessage.setRetCode(qTDetail.getRET_CODE());
                        returnMessage.setErrMsg(qTDetail.getERR_MSG());
                        returnMessage.setFinTime(qTDetail.getFINTIME());
                        //如果是批扣
                        if (returnMessage.getSingleOrBatch() == 1) {
                            if (QT_SN.equals(returnMessage.getSn())) {
                                dealChangeSchemeRepaymentStatus(transSplitBody, returnMessage, monthlyPaymentAdapter, dubboTreaceParames);
                            }
                        } else {
                            dealChangeSchemeRepaymentStatus(transSplitBody, returnMessage, monthlyPaymentAdapter, dubboTreaceParames);
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
    public void search(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put(DubboTreactid.traceId.value(), DubboTreactid.MonthlyPaymentController_queryTradeNew.value() + System.currentTimeMillis());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        TransBody transBody = new TransBody();
        transBody.setReqSn(transSplitBody.getReqSn());
        ResultHashMap resultHashMap = monthlyPaymentAdapter.search(transBody, dubboTreaceParames);//处理通联平台查询
        QuickReturnMessage quickReturnMessage = (QuickReturnMessage) resultHashMap.get("result");
        quickReturnMessage.setReqSn(transSplitBody.getReqSn());
        quickReturnMessage.setSn(transSplitBody.getSn());
        quickReturnMessage.setRepaymentId(transSplitBody.getRepaymentId());
        quickReturnMessage.setContractId(transSplitBody.getContractId());
        quickReturnMessage.setAllinpaySplitId(transSplitBody.getAllinpaySplitId());
        quickReturnMessage.setAllinpaySplitLogId(transSplitBody.getAllinpaySplitLogId());
        quickReturnMessage.setSingleOrBatch(transSplitBody.getSingleOrBatch());
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
        TransSplitBody transSplitBody = new TransSplitBody();
        transSplitBody.setAipgrspRetCode(quickReturnMessage.getAipgrspRetCode());
        transSplitBody.setAipgrspErrMsg(quickReturnMessage.getAipgrspErrmsg());
        transSplitBody.setReqSn(quickReturnMessage.getReqSn());
        List<com.allinpay.param.query.QTDetail> qTDetailList = quickReturnMessage.getQueryDetails();
        if (qTDetailList != null) {
            if (qTDetailList.size() > 0) {
                for (int i = 0; i < qTDetailList.size(); i++) {
                    com.allinpay.param.query.QTDetail qTDetail = qTDetailList.get(i);
                    String BATCHID = qTDetail.getBATCHID();
                    if (BATCHID.equals(transSplitBody.getReqSn())) {
                        ReturnMessage returnMessage = new ReturnMessage();
                        returnMessage.setReqSn(transSplitBody.getReqSn());
                        returnMessage.setSn(quickReturnMessage.getSn());
                        returnMessage.setRepaymentId(quickReturnMessage.getRepaymentId());
                        returnMessage.setContractId(quickReturnMessage.getContractId());
                        returnMessage.setAllinpaySplitId(quickReturnMessage.getAllinpaySplitId());
                        returnMessage.setType(quickReturnMessage.getType());
                        returnMessage.setOverdueType(quickReturnMessage.getOverdueType());
                        returnMessage.setAllinpaySplitLogId(quickReturnMessage.getAllinpaySplitLogId());
                        returnMessage.setSingleOrBatch(quickReturnMessage.getSingleOrBatch());
                        returnMessage.setRetCode(qTDetail.getRET_CODE());
                        returnMessage.setErrMsg(qTDetail.getERR_MSG());
                        returnMessage.setFinTime(qTDetail.getFINTIME());
                        dealChangeSchemeRepaymentStatus(transSplitBody, returnMessage, monthlyPaymentAdapter, dubboTreaceParames);
                    }
                }
            }
        }
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 统一入口
     *
     * @param transSplitBody
     * @param returnMessage
     * @param monthlyPaymentAdapter
     * @throws GMException
     */
    public void dealChangeSchemeRepaymentStatus(TransSplitBody transSplitBody, ReturnMessage returnMessage, MonthlyPaymentAdapter monthlyPaymentAdapter, DubboTreaceParames dubboTreaceParames) throws GMException {
        transSplitBody.setSn(returnMessage.getSn());//批量代收才有此参数
        transSplitBody.setRetCode(returnMessage.getRetCode());
        transSplitBody.setErrMsg(returnMessage.getErrMsg());
        transSplitBody.setFinTime(returnMessage.getFinTime());
        transSplitBody.setRepaymentId(returnMessage.getRepaymentId());
        transSplitBody.setContractId(returnMessage.getContractId());
        transSplitBody.setAllinpaySplitId(returnMessage.getAllinpaySplitId());
        transSplitBody.setAllinpaySplitLogId(returnMessage.getAllinpaySplitLogId());
        monthlyPaymentAdapter.changeSchemeRepaymentStatusSplit(transSplitBody, dubboTreaceParames);
    }

}
