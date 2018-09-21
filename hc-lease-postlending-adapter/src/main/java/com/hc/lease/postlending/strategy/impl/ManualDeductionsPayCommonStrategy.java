package com.hc.lease.postlending.strategy.impl;

import com.allinpay.model.QuickReturnMessage;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentService;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.FindNeedPayVo;
import com.hc.lease.postlending.vo.TransManualDeductionsBody;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 手动扣款/提交支付
 * 公共处理
 * <p>
 * Created by tong on 2018/7/9
 */
public class ManualDeductionsPayCommonStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {

        LeaseSchemeRepaymentService leaseSchemeRepaymentService = (LeaseSchemeRepaymentService) SpringContextHolder.getBean("leaseSchemeRepaymentService");

        Context context = (Context) object;
        TransManualDeductionsBody transManualDeductionsBody = (TransManualDeductionsBody) object1;
        FindNeedPayVo findNeedPayVo = (FindNeedPayVo) object2;
        ResultHashMap resultHashMap = null;
        if (findNeedPayVo != null) {

            if (findNeedPayVo.getIsExistContract().equals(1)) {//有合同的手动扣款

                //查询合同还款计划
                List<Long> repaymentIds = new ArrayList<Long>();
                List<Long> contractIds = new ArrayList<Long>();
                repaymentIds.add(findNeedPayVo.getRepaymentId());
                contractIds.add(findNeedPayVo.getContractId());
                Map<String, Object> paramsMap = Maps.newHashMap();
                paramsMap.put("repaymentIds", repaymentIds);
                paramsMap.put("contractIds", contractIds);
                List<BatchPostlendingPaymentVo> needBatchPostlendingPaymentList = leaseSchemeRepaymentService.findBatchPostlendingPaymentDual(paramsMap, dubboTreaceParames);//提交批扣查询需要处理的月供、滞纳金，代扣的数据
                Integer payStatus = 1;
                if (needBatchPostlendingPaymentList != null && needBatchPostlendingPaymentList.size() > 0) {
                    payStatus = 0;//是否已经扣款 0否 1是
                }
                //查询合同还款计划
                transManualDeductionsBody.setPayStatus(payStatus);
                resultHashMap = (ResultHashMap) context.deal(context, JDBCTpye.JDBC_INSERT + "ManualDeductionsPay", transManualDeductionsBody, findNeedPayVo, null, dubboTreaceParames);

                if (payStatus.equals(0)) {//扣款中或者已扣款无需再处理扣款
                    //通联支付有返回报文
                    if (resultHashMap.get("result") != null) {
                        QuickReturnMessage quickReturnMessage = (QuickReturnMessage) resultHashMap.get("result");
                        transManualDeductionsBody.setAipgrspRetCode(quickReturnMessage.getAipgrspRetCode());
                        transManualDeductionsBody.setAipgrspErrMsg(quickReturnMessage.getAipgrspErrmsg());
                        transManualDeductionsBody.setRnpaRetRetCode(quickReturnMessage.getRnpaRetRetCode());
                        transManualDeductionsBody.setRnpaRetErrmsg(quickReturnMessage.getRnpaRetErrmsg());
                        transManualDeductionsBody.setReqSn(quickReturnMessage.getReqSn());
                        resultHashMap = (ResultHashMap) context.deal(context, JDBCTpye.JDBC_INSERT + "ManualDeductionsPayContract", transManualDeductionsBody, findNeedPayVo, needBatchPostlendingPaymentList, dubboTreaceParames);
                    }
                }

            } else {//无合同的手动扣款
                transManualDeductionsBody.setPayStatus(0);
                resultHashMap = (ResultHashMap) context.deal(context, JDBCTpye.JDBC_INSERT + "ManualDeductionsPay", transManualDeductionsBody, findNeedPayVo, null, dubboTreaceParames);
            }

        }

        return resultHashMap;
    }

}