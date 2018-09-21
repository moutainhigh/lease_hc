package com.hc.lease.postlending.strategy.impl;

import com.aipg.quickpay.AllinpayIdTypeEnum;
import com.allinpay.data.QuickData;
import com.allinpay.model.QuickReturnMessage;
import com.allinpay.util.CheckCode;
import com.allinpay.util.QuickCodeEnum;
import com.hc.lease.common.allinpay.adapter.TranxAdapter;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.PayWay;
import com.hc.lease.common.core.constant.PaymentLogStatus;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.model.LeaseManualDeductiStatusLog;
import com.hc.lease.postlending.model.LeaseManualDeductionsData;
import com.hc.lease.postlending.model.LeaseManualDeductionsPayLog;
import com.hc.lease.postlending.model.LeaseManualDeductionsStatist;
import com.hc.lease.postlending.service.api.LeaseManualDeductiStatusLogService;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsDataService;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsPayLogService;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsStatistService;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.FindNeedPayVo;
import com.hc.lease.postlending.vo.TransManualDeductionsBody;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 手动扣款/提交支付
 * 没有合同
 * <p>
 * Created by tong on 2018/7/9
 */
public class ManualDeductionsPayStrategy implements Strategy {

    LeaseManualDeductionsStatistService leaseManualDeductionsStatistService = (LeaseManualDeductionsStatistService) SpringContextHolder.getBean("leaseManualDeductionsStatistService");
    LeaseManualDeductionsDataService leaseManualDeductionsDataService = (LeaseManualDeductionsDataService) SpringContextHolder.getBean("leaseManualDeductionsDataService");
    LeaseManualDeductionsPayLogService leaseManualDeductionsPayLogService = (LeaseManualDeductionsPayLogService) SpringContextHolder.getBean("leaseManualDeductionsPayLogService");
    LeaseManualDeductiStatusLogService leaseManualDeductiStatusLogService = (LeaseManualDeductiStatusLogService) SpringContextHolder.getBean("leaseManualDeductiStatusLogService");

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {

        Context context = (Context) object;
        TranxAdapter tranxAdapter = (TranxAdapter) SpringContextHolder.getBean("tranxAdapter");
        TransManualDeductionsBody transManualDeductionsBody = (TransManualDeductionsBody) object1;
        FindNeedPayVo findNeedPayVo = (FindNeedPayVo) object2;
        QuickReturnMessage quickReturnMessage = null;
        if (transManualDeductionsBody.getPayStatus().equals(0)) {//扣款中或者已扣款无需再处理扣款

            //拼接协议支付接口参数
            QuickData data = new QuickData();
            data.setAccountName(findNeedPayVo.getBankAccountName());//银行户名
            data.setAgrmno(findNeedPayVo.getAgrmNo());//协议号
            data.setAccountNo(findNeedPayVo.getBackCardNumber());//银行卡号
            data.setIdType(AllinpayIdTypeEnum.ID_TYPE_0.getCode());//开户证件类型
            BigDecimal totlePriceF = findNeedPayVo.getTotalPrice().multiply(new BigDecimal(100));//因为通联的金额用 分 做单位
            data.setAmount(String.valueOf(totlePriceF.intValue()));//金额
            data.setTel(findNeedPayVo.getBankPhone());//电话
            data.setId(findNeedPayVo.getIdCard());//身份证号
            data.setBankCode(findNeedPayVo.getBankCode());//银行代码
            //拼接协议支付接口参数
            quickReturnMessage = tranxAdapter.pay(data);//提交通联协议支付交易
            if (quickReturnMessage != null) {
                Integer paymentResult = CheckCode.checkPayPaymentResult(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode());
                String paymentResultMsg = quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetErrmsg() : quickReturnMessage.getAipgrspErrmsg();
                String retCode = quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetRetCode() : quickReturnMessage.getAipgrspRetCode();
                String errMsg = quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetErrmsg() : quickReturnMessage.getAipgrspErrmsg();
                Integer status = CheckCode.checkPayStatus(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode());
                String reqSn = quickReturnMessage.getReqSn();
                String repTime = quickReturnMessage.getRepTime();
                dualManualDeductions(findNeedPayVo, transManualDeductionsBody, paymentResult, paymentResultMsg, retCode, errMsg, status, reqSn, repTime);
            }

        } else {

            Integer paymentResult = 3;
            String paymentResultMsg = "合同已经操作过通联扣款或线下缴款登记";
            String retCode = null;
            String errMsg = null;
            Integer status = 2;
            String reqSn = null;
            String repTime = null;
            dualManualDeductions(findNeedPayVo, transManualDeductionsBody, paymentResult, paymentResultMsg, retCode, errMsg, status, reqSn, repTime);

        }

        ResultHashMap resultHashMap = new ResultHashMap(true, quickReturnMessage, GMExceptionConstant.MANUAL_ALLINPAY_SEND_SUCCESS);
        return resultHashMap;
    }

    /**
     * 处理数据库
     *
     * @param findNeedPayVo
     * @param transManualDeductionsBody
     * @param paymentResult
     * @param paymentResultMsg
     * @param retCode
     * @param errMsg
     * @param status
     * @param reqSn
     * @param repTime
     * @throws GMException
     */
    public void dualManualDeductions(FindNeedPayVo findNeedPayVo, TransManualDeductionsBody transManualDeductionsBody
            , Integer paymentResult, String paymentResultMsg, String retCode, String errMsg, Integer status, String reqSn, String repTime) throws GMException {

        //更新 手动扣款统计 提交支付状态
        Integer successNumber = status.equals(PaymentLogStatus.STATUS_1) ? 1 : 0;//成功数量
        Integer failNumber = status.equals(PaymentLogStatus.STATUS_2) ? 1 : 0;//失败数量
        BigDecimal receiptsPrice = status.equals(PaymentLogStatus.STATUS_1) ? findNeedPayVo.getTotalPrice() : new BigDecimal(0);//实扣总额
        BigDecimal failPrice = status.equals(PaymentLogStatus.STATUS_2) ? findNeedPayVo.getTotalPrice() : new BigDecimal(0);//失败总额
        LeaseManualDeductionsStatist leaseManualDeductionsStatist = new LeaseManualDeductionsStatist();
        leaseManualDeductionsStatist.setIsPay(1);//是否已提交支付 0否 1是
        leaseManualDeductionsStatist.setId(findNeedPayVo.getStatistId());
        leaseManualDeductionsStatist.setSuccessNumber(successNumber);//成功数量
        leaseManualDeductionsStatist.setFailNumber(failNumber);//失败数量
        leaseManualDeductionsStatist.setReceiptsPrice(receiptsPrice);//实扣总额
        leaseManualDeductionsStatist.setFailPrice(failPrice);//失败总额
        leaseManualDeductionsStatistService.updateOnpay(leaseManualDeductionsStatist);
        //更新 手动扣款统计 提交支付状态

        LeaseManualDeductionsData LeaseManualDeductionsData = new LeaseManualDeductionsData();
        LeaseManualDeductionsData.setSn(transManualDeductionsBody.getSn());
        LeaseManualDeductionsData.setPaymentResult(paymentResult);//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
        LeaseManualDeductionsData.setUpdateBy(transManualDeductionsBody.getCreateBy());
        LeaseManualDeductionsData.setUpdateTime(transManualDeductionsBody.getUpdateTime());
        LeaseManualDeductionsData.setPaymentResultMsg(paymentResultMsg);//通联返回的 明细 状态结果描述
        LeaseManualDeductionsData.setReqSn(reqSn);
        LeaseManualDeductionsData.setId(findNeedPayVo.getId());
        LeaseManualDeductionsData.setPayWay(PayWay.ALLIPAY_QUICK);
        leaseManualDeductionsDataService.updateByPrimaryKeySelective(LeaseManualDeductionsData);

        LeaseManualDeductionsPayLog leaseManualDeductionsPayLog = new LeaseManualDeductionsPayLog();
        leaseManualDeductionsPayLog.setBackTime(DateUtil.stampToDate(repTime));
        leaseManualDeductionsPayLog.setCreateBy(findNeedPayVo.getCreateBy());
        leaseManualDeductionsPayLog.setCreateTime(findNeedPayVo.getCreateTime());
        leaseManualDeductionsPayLog.setUpdateBy(findNeedPayVo.getCreateBy());
        leaseManualDeductionsPayLog.setUpdateTime(findNeedPayVo.getCreateTime());
        leaseManualDeductionsPayLog.setDataId(findNeedPayVo.getId());
        leaseManualDeductionsPayLog.setPayWay(PayWay.ALLIPAY_QUICK);
        leaseManualDeductionsPayLog.setReqSn(reqSn);
        leaseManualDeductionsPayLog.setRetCode(retCode);//如果头部返回成功状态则使用明细的状态码
        leaseManualDeductionsPayLog.setErrMsg(errMsg);//如果头部返回成功状态则使用明细的状态结果描述
        leaseManualDeductionsPayLog.setSn(transManualDeductionsBody.getSn());
        leaseManualDeductionsPayLog.setStatus(status);//通联支付状态/0:已提交、扣款中;1:成功;2:失败
        leaseManualDeductionsPayLog.setTotalPrice(findNeedPayVo.getTotalPrice());
        leaseManualDeductionsPayLog = leaseManualDeductionsPayLogService.insertSelective(leaseManualDeductionsPayLog);

        LeaseManualDeductiStatusLog leaseManualDeductiStatusLog = new LeaseManualDeductiStatusLog();
        leaseManualDeductiStatusLog.setBackTime(DateUtil.stampToDate(repTime));
        leaseManualDeductiStatusLog.setCreateTime(transManualDeductionsBody.getCreateTime());
        leaseManualDeductiStatusLog.setCreateBy(transManualDeductionsBody.getCreateBy());
        leaseManualDeductiStatusLog.setRetCode(retCode);
        leaseManualDeductiStatusLog.setErrMsg(errMsg);
        leaseManualDeductiStatusLog.setPayLogId(leaseManualDeductionsPayLog.getId());
        leaseManualDeductiStatusLog.setPaymentResult(paymentResult);
        leaseManualDeductiStatusLog.setPaymentResultMsg(paymentResultMsg);
        leaseManualDeductiStatusLog.setType(0);//状态流水 类型 0:提交手动扣款的结果;1:轮询手动扣款的结果
        leaseManualDeductiStatusLogService.insertSelective(leaseManualDeductiStatusLog);

    }

}