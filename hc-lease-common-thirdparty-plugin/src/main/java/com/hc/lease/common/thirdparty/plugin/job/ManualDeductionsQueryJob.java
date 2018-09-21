package com.hc.lease.common.thirdparty.plugin.job;

import com.allinpay.model.QuickReturnMessage;
import com.allinpay.util.CheckCode;
import com.google.common.collect.Maps;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.*;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.*;
import com.hc.lease.postlending.model.*;
import com.hc.lease.postlending.vo.FindQueryTradeVo;
import com.hc.lease.postlending.vo.TransBody;
import com.hc.lease.postlending.vo.TransManualDeductionsBody;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 定时器 定时轮询通联超额 手动扣款 交易结果
 * Created by tong on 2018/7/9
 */
@Lazy(false)
@Component("manualDeductionsQueryJob")
public class ManualDeductionsQueryJob {

    private Logger logger = LoggerFactory.getLogger(ManualDeductionsQueryJob.class);

    @Autowired
    MonthlyPaymentAdapter monthlyPaymentAdapter;

    @Autowired
    LeaseManualDeductionsStatistAdapter leaseManualDeductionsStatistAdapter;

    @Autowired
    LeaseManualDeductionsDataAdapter leaseManualDeductionsDataAdapter;

    @Autowired
    LeaseManualDeductionsPayLogAdapter leaseManualDeductionsPayLogAdapter;

    @Autowired
    LeaseManualDeductioQueryLogAdapter leaseManualDeductioQueryLogAdapter;

    @Autowired
    LeaseManualDeductiStatusLogAdapter leaseManualDeductiStatusLogAdapter;

    //每日10点触发一次  轮询通联交易结果
    @Scheduled(cron = "${job.manualDeductionsQueryJob.corn}")
    public void manualDeductionsQueryJob() throws GMException {
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job.ManualDeductionsQueryJob");//接口名称
        dubboTreaceParames.setTreaceMethodName("manualDeductionsQueryJob");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        List<FindQueryTradeVo> findQueryTradeVoList = leaseManualDeductionsDataAdapter.findQueryTrade(null, dubboTreaceParames);// 需要轮询通联 的 交易流水/状态为扣款中

        if (findQueryTradeVoList != null) {
            if (findQueryTradeVoList.size() > 0) {
                TransManualDeductionsBody transManualDeductionsBody = new TransManualDeductionsBody();
                for (int i = 0; i < findQueryTradeVoList.size(); i++) {
                    FindQueryTradeVo findQueryTradeVo = findQueryTradeVoList.get(i);
                    logger.trace("======ManualDeductionsQueryJob=findQueryTradeVo=====" + findQueryTradeVo);
                    Long statistId = findQueryTradeVo.getStatistId();
                    Long repaymentId = findQueryTradeVo.getRepaymentId();
                    Long contractId = findQueryTradeVo.getContractId();
                    Integer paymentResult = findQueryTradeVo.getPaymentResult();
                    String reqSn = findQueryTradeVo.getReqSn();
                    String sn = findQueryTradeVo.getSn();
                    Long payLogId = findQueryTradeVo.getPayLogId();
                    Long dataId = findQueryTradeVo.getId();
                    Integer payWay = findQueryTradeVo.getPayWay();
                    BigDecimal totalPrice = findQueryTradeVo.getTotalPrice();

                    //支付状态 为 1扣款中
                    if (paymentResult.equals(PaymentResult.TYPE_1)) {
                        transManualDeductionsBody.setReqSn(reqSn);
                        transManualDeductionsBody.setSn(sn);
                        transManualDeductionsBody.setRepaymentId(repaymentId);
                        transManualDeductionsBody.setContractId(contractId);
                        transManualDeductionsBody.setDataId(dataId);
                        transManualDeductionsBody.setPayLogId(payLogId);
                        transManualDeductionsBody.setPayWay(payWay);
                        transManualDeductionsBody.setStatistId(statistId);
                        transManualDeductionsBody.setTotalPrice(totalPrice);
                        logger.trace("=ManualDeductionsQueryJob=====transManualDeductionsBody=====" + transManualDeductionsBody);
                        search(transManualDeductionsBody, dubboTreaceParames);//交易查询/轮询/通联协议支付
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
    public void search(TransManualDeductionsBody transManualDeductionsBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put(DubboTreactid.traceId.value(), DubboTreactid.MonthlyPaymentController_queryTradeNew.value() + System.currentTimeMillis());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        TransBody transBody = new TransBody();
        transBody.setReqSn(transManualDeductionsBody.getReqSn());
        ResultHashMap resultHashMap = monthlyPaymentAdapter.search(transBody, dubboTreaceParames);//处理通联平台查询
        QuickReturnMessage quickReturnMessage = (QuickReturnMessage) resultHashMap.get("result");
        quickReturnMessage.setReqSn(transManualDeductionsBody.getReqSn());
        quickReturnMessage.setSn(transManualDeductionsBody.getSn());
        quickReturnMessage.setRepaymentId(transManualDeductionsBody.getRepaymentId());
        quickReturnMessage.setContractId(transManualDeductionsBody.getContractId());
        quickReturnMessage.setDataId(transManualDeductionsBody.getDataId());
        quickReturnMessage.setPayLogId(transManualDeductionsBody.getPayLogId());
        quickReturnMessage.setStatistId(transManualDeductionsBody.getStatistId());
        quickReturnMessage.setTotalPrice(transManualDeductionsBody.getTotalPrice());
        changeManualDeductionsQuickStatus(quickReturnMessage, dubboTreaceParames);
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 还款记录 状态
     * 通联协议支付
     *
     * @throws GMException
     */
    public void changeManualDeductionsQuickStatus(QuickReturnMessage quickReturnMessage, DubboTreaceParames dubboTreaceParames) throws GMException {
        TransManualDeductionsBody transManualDeductionsBody = new TransManualDeductionsBody();
        transManualDeductionsBody.setAipgrspRetCode(quickReturnMessage.getAipgrspRetCode());
        transManualDeductionsBody.setAipgrspErrMsg(quickReturnMessage.getAipgrspErrmsg());
        transManualDeductionsBody.setReqSn(quickReturnMessage.getReqSn());
        List<com.allinpay.param.query.QTDetail> qTDetailList = quickReturnMessage.getQueryDetails();
        if (qTDetailList != null) {
            if (qTDetailList.size() > 0) {
                for (int i = 0; i < qTDetailList.size(); i++) {
                    com.allinpay.param.query.QTDetail qTDetail = qTDetailList.get(i);
                    String BATCHID = qTDetail.getBATCHID();
                    if (BATCHID.equals(transManualDeductionsBody.getReqSn())) {
                        ReturnMessage returnMessage = new ReturnMessage();
                        returnMessage.setReqSn(transManualDeductionsBody.getReqSn());
                        returnMessage.setSn(quickReturnMessage.getSn());
                        returnMessage.setRepaymentId(quickReturnMessage.getRepaymentId());
                        returnMessage.setContractId(quickReturnMessage.getContractId());
                        returnMessage.setDataId(quickReturnMessage.getDataId());
                        returnMessage.setPayLogId(quickReturnMessage.getPayLogId());
                        returnMessage.setStatistId(quickReturnMessage.getStatistId());
                        returnMessage.setTotalPrice(quickReturnMessage.getTotalPrice());
                        returnMessage.setRetCode(qTDetail.getRET_CODE());
                        returnMessage.setErrMsg(qTDetail.getERR_MSG());
                        returnMessage.setFinTime(qTDetail.getFINTIME());
                        dualManualDeductions(transManualDeductionsBody, returnMessage, dubboTreaceParames);
                    }
                }
            }
        }
    }

    public void dualManualDeductions(TransManualDeductionsBody transManualDeductionsBody, ReturnMessage returnMessage, DubboTreaceParames dubboTreaceParames) throws GMException {
        //更新 手动扣款提交的数据 状态
        LeaseManualDeductionsData leaseManualDeductionsData = new LeaseManualDeductionsData();
        leaseManualDeductionsData.setPaymentResult(RetCode.checkPaymentResult(transManualDeductionsBody.getAipgrspRetCode(), returnMessage.getRetCode()));
        leaseManualDeductionsData.setPaymentResultMsg(returnMessage.getErrMsg());
        leaseManualDeductionsData.setId(returnMessage.getDataId());
        int row1 = leaseManualDeductionsDataAdapter.updateByPrimaryKeySelective(leaseManualDeductionsData);
        //更新 手动扣款提交的数据 状态

        //手动扣款流水
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("reqSn", transManualDeductionsBody.getReqSn());
        paramsMap.put("dataId", returnMessage.getDataId());
        LeaseManualDeductionsPayLog leaseManualDeductionsPayLog = leaseManualDeductionsPayLogAdapter.findByReqSn(paramsMap);
        //手动扣款流水

        Integer checkStatus = CheckCode.checkPayStatus(transManualDeductionsBody.getAipgrspRetCode(), returnMessage.getRetCode());

        //更新 手动扣款统计 提交支付状态
        Integer successNumber = checkStatus.equals(PaymentLogStatus.STATUS_1) ? 1 : 0;//成功数量
        Integer failNumber = checkStatus.equals(PaymentLogStatus.STATUS_2) ? 1 : 0;//失败数量
        BigDecimal receiptsPrice = checkStatus.equals(PaymentLogStatus.STATUS_1) ? returnMessage.getTotalPrice() : new BigDecimal(0);//实扣总额
        BigDecimal failPrice = checkStatus.equals(PaymentLogStatus.STATUS_2) ? returnMessage.getTotalPrice() : new BigDecimal(0);//失败总额
        LeaseManualDeductionsStatist leaseManualDeductionsStatist = new LeaseManualDeductionsStatist();
        leaseManualDeductionsStatist.setId(returnMessage.getStatistId());
        leaseManualDeductionsStatist.setSuccessNumber(successNumber);
        leaseManualDeductionsStatist.setFailNumber(failNumber);
        leaseManualDeductionsStatist.setReceiptsPrice(receiptsPrice);
        leaseManualDeductionsStatist.setFailPrice(failPrice);
        leaseManualDeductionsStatistAdapter.updateOnpay(leaseManualDeductionsStatist);
        //更新 手动扣款统计 提交支付状态

        //添加 通联轮询流水 状态
        LeaseManualDeductioQueryLog leaseManualDeductioQueryLog = new LeaseManualDeductioQueryLog();
        leaseManualDeductioQueryLog.setPayLogId(leaseManualDeductionsPayLog.getId());//代收流水主键id
        leaseManualDeductioQueryLog.setDataId(returnMessage.getDataId());
        leaseManualDeductioQueryLog.setStatus(checkStatus);//通联支付状态/0:已提交;1:成功;2:失败
        leaseManualDeductioQueryLog.setRetCode(returnMessage.getRetCode());//通联支付反馈状态码
        leaseManualDeductioQueryLog.setErrMsg(returnMessage.getErrMsg());//通联支付反馈状态描述
        leaseManualDeductioQueryLog.setBackTime(DateUtil.strToDate(returnMessage.getFinTime()));
        leaseManualDeductioQueryLog.setReqSn(returnMessage.getReqSn());//通联返回的 文件名/可用于通联流水查询
        leaseManualDeductioQueryLog.setSn(transManualDeductionsBody.getSn());
        leaseManualDeductioQueryLogAdapter.insertSelective(leaseManualDeductioQueryLog);
        //添加 通联轮询流水 状态

        //插入 代收状态流水 数据
        LeaseManualDeductiStatusLog laseManualDeductiStatusLog = new LeaseManualDeductiStatusLog();
        laseManualDeductiStatusLog.setPayLogId(leaseManualDeductionsPayLog.getId());//代收流水主键id
        laseManualDeductiStatusLog.setBackTime(DateUtil.stampToDate(returnMessage.getFinTime()));//通联支付反馈状态日期
        laseManualDeductiStatusLog.setCreateTime(DateTime.now().toDate());//
        laseManualDeductiStatusLog.setRetCode(returnMessage.getRetCode());//通联支付反馈状态码
        laseManualDeductiStatusLog.setErrMsg(returnMessage.getErrMsg());//通联支付反馈状态描述
        laseManualDeductiStatusLog.setPaymentResult(RetCode.checkPaymentResult(transManualDeductionsBody.getAipgrspRetCode(), returnMessage.getRetCode()));//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
        laseManualDeductiStatusLog.setPaymentResultMsg(returnMessage.getErrMsg());//状态结果描述  失败原因描述
        leaseManualDeductiStatusLogAdapter.insertSelective(laseManualDeductiStatusLog);

        //插入 代收状态流水 数据

    }

}
