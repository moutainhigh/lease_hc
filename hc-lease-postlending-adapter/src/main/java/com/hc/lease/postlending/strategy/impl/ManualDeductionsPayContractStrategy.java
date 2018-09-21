package com.hc.lease.postlending.strategy.impl;

import com.aipg.payresp.Ret_Detail;
import com.allinpay.util.CheckCode;
import com.allinpay.util.QuickCodeEnum;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.*;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchStrategyVo;
import com.hc.lease.postlending.vo.FindNeedPayVo;
import com.hc.lease.postlending.vo.TransManualDeductionsBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 手动扣款/提交支付
 * 有合同
 * 更新合同还款计划支付信息
 * <p>
 * Created by tong on 2018/7/11
 */
public class ManualDeductionsPayContractStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {

        Context context = (Context) object;
        TransManualDeductionsBody transManualDeductionsBody = (TransManualDeductionsBody) object1;
        FindNeedPayVo findNeedPayVo = (FindNeedPayVo) object2;
        List<BatchPostlendingPaymentVo> needBatchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) object3;

        //处理计算逾期
        needBatchPostlendingPaymentList = dualRealOverduePriceBatch(needBatchPostlendingPaymentList, findNeedPayVo, transManualDeductionsBody);

        List<Long> repaymentIds = new ArrayList<Long>();
        List<Long> contractIds = new ArrayList<Long>();
        repaymentIds.add(findNeedPayVo.getRepaymentId());
        contractIds.add(findNeedPayVo.getContractId());
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("repaymentIds", repaymentIds);
        paramsMap.put("contractIds", contractIds);

        //根据通联支付代收 返回的处理结果更新 数据库
        BatchStrategyVo batchStrategyVo = new BatchStrategyVo();
        batchStrategyVo.setTotalItem(needBatchPostlendingPaymentList.size());//总数量
        batchStrategyVo.setSingleOrBatch(0);//单笔或批量/0:单笔; 1:批量
        batchStrategyVo.setCreateTime(transManualDeductionsBody.getCreateTime());
        batchStrategyVo.setUpdateTime(transManualDeductionsBody.getUpdateTime());
        batchStrategyVo.setCreateBy(transManualDeductionsBody.getCreateBy());
        batchStrategyVo.setUpdateBy(transManualDeductionsBody.getUpdateBy());
        batchStrategyVo.setReqSn(transManualDeductionsBody.getReqSn());
        batchStrategyVo.setAipgrspRetCode(transManualDeductionsBody.getAipgrspRetCode());//通联返回的 头部 状态码
        batchStrategyVo.setAipgrspErrMsg(transManualDeductionsBody.getAipgrspErrMsg());//通联返回的 头部 状态结果描述
        batchStrategyVo.setRetCode(transManualDeductionsBody.getRnpaRetRetCode());//通联返回的 明细 状态码
        batchStrategyVo.setErrMsg(transManualDeductionsBody.getRnpaRetErrmsg());//通联返回的 明细 状态结果描述
        batchStrategyVo.setFinalErrMsg(transManualDeductionsBody.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? transManualDeductionsBody.getRnpaRetErrmsg() : transManualDeductionsBody.getAipgrspErrMsg());//如果头部返回成功状态则使用明细的状态结果描述
        batchStrategyVo.setFinalCode(transManualDeductionsBody.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? transManualDeductionsBody.getRnpaRetRetCode() : transManualDeductionsBody.getAipgrspRetCode());//如果头部返回成功状态则使用明细的状态码
        batchStrategyVo.setRetDetails(dualRetDetails(transManualDeductionsBody));//批量代收明细 操作结果状态
        batchStrategyVo.setPayWay(PayWay.ALLIPAY_QUICK);
        batchStrategyVo.setStatus(CheckCode.checkPayStatus(transManualDeductionsBody.getAipgrspRetCode(), transManualDeductionsBody.getRnpaRetRetCode()));//通联支付状态/0:已提交、扣款中;1:成功;2:失败
        batchStrategyVo.setAllinpayStatusLogType(AllinpayStatusLogType.TYPE_9);
        batchStrategyVo.setIsSpilt(transManualDeductionsBody.getIsSpilt());
        batchStrategyVo.setSn(transManualDeductionsBody.getSn());
        batchStrategyVo.setControllerSource(ControllerSourceType.TYPE_2);//操作来源 0:单笔; 1:批量;2:手动批扣

        context.deal(context, batchStrategyVo.getSingleOrBatch() + JDBCTpye.JDBC_SINGLEORBATHTYPE + "AllPayWayCommon", batchStrategyVo, needBatchPostlendingPaymentList, null, dubboTreaceParames);//支付公共处理

        ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.ALLINPAY_SEND_SUCCESS);
        return resultHashMap;
    }

    /**
     * 处理交易 通联返回的 明细
     * 如果通联返回的 头部 状态已经为失败状态 则需要手动处理 模拟通联返回的格式，因为通联没有返回这部分数据，但后面需用到这部分数据
     *
     * @param transManualDeductionsBody
     * @return
     */
    private List<Ret_Detail> dualRetDetails(TransManualDeductionsBody transManualDeductionsBody) {
        List<Ret_Detail> retDetails = new ArrayList<Ret_Detail>();
        Ret_Detail detail = new Ret_Detail();
        if (transManualDeductionsBody.getAipgrspRetCode().equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            detail.setRET_CODE(transManualDeductionsBody.getRnpaRetRetCode());
            detail.setERR_MSG(transManualDeductionsBody.getRnpaRetErrmsg());
        } else {
            detail.setRET_CODE(transManualDeductionsBody.getAipgrspRetCode());
            detail.setERR_MSG(transManualDeductionsBody.getAipgrspErrMsg());
        }
        detail.setSN(transManualDeductionsBody.getSn());
        retDetails.add(detail);
        return retDetails;
    }

    /**
     * 处理修改后的逾期天数，价格、SN
     *
     * @param needBatchPostlendingPaymentList 查询的数据
     * @param findNeedPayVo                   提交的数据
     * @param transManualDeductionsBody
     * @return
     * @throws GMException
     */
    public List<BatchPostlendingPaymentVo> dualRealOverduePriceBatch(List<BatchPostlendingPaymentVo> needBatchPostlendingPaymentList, FindNeedPayVo findNeedPayVo, TransManualDeductionsBody transManualDeductionsBody) throws GMException {
        if (needBatchPostlendingPaymentList != null) {
            if (needBatchPostlendingPaymentList.size() > 0) {
                for (int i = 0; i < needBatchPostlendingPaymentList.size(); i++) {
                    BatchPostlendingPaymentVo batchPostlendingPaymentVo = needBatchPostlendingPaymentList.get(i);
                    Integer realOverdueDay = findNeedPayVo.getOverdueDay() == null ? 0 : findNeedPayVo.getOverdueDay();
                    //用输入的逾期天数计算逾期金额
                    BigDecimal totalOverdue = batchPostlendingPaymentVo.getOverdueRate().multiply(new BigDecimal(realOverdueDay)).multiply(batchPostlendingPaymentVo.getMonthPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
                    //用输入的逾期天数计算逾期金额
                    batchPostlendingPaymentVo.setRealOverdueDay(realOverdueDay);
                    batchPostlendingPaymentVo.setRealPrice(totalOverdue);
                    batchPostlendingPaymentVo.setSn(transManualDeductionsBody.getSn());
                }
            }
        }
        return needBatchPostlendingPaymentList;
    }

}