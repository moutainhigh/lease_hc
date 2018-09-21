package com.hc.lease.postlending.strategy.impl;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.ContractStatus;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.service.api.LeaseContractService;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchStrategyVo;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 处理单人综合扣款、通联批扣
 * 支付公共处理
 * Created by tong on 2018/6/28
 */
public class DualAllPayWayCommonStrategy implements Strategy {
    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        Context context = (Context) object;
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) object2;
        BatchStrategyVo batchStrategyVo = (BatchStrategyVo) object1;
        LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService = (LeaseSchemeRepaymentStatusService) SpringContextHolder.getBean("leaseSchemeRepaymentStatusService");
        LeaseContractService leaseContractService = (LeaseContractService) SpringContextHolder.getBean("leaseContractService");
        for (int i = 0; i < batchPostlendingPaymentList.size(); i++) {
            BatchPostlendingPaymentVo batchPostlendingPaymentVo = batchPostlendingPaymentList.get(i);
            batchStrategyVo.setType(batchPostlendingPaymentVo.getType());//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款; 7:其他款项
            batchStrategyVo.setAccountId(batchPostlendingPaymentVo.getAccountId());
            context.deal(context, batchStrategyVo.getType() + JDBCTpye.JDBC_INSERT + "AllPayWayCommon", batchStrategyVo, batchPostlendingPaymentVo, null, dubboTreaceParames);

            //更新 合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
            Map<String, Object> paramsMap = Maps.newHashMap();
            paramsMap.put("id", batchPostlendingPaymentVo.getId());
            paramsMap.put("contractId", batchPostlendingPaymentVo.getContractId());
            Boolean contractStatus = leaseSchemeRepaymentStatusService.findByContractidAndStatus(paramsMap, dubboTreaceParames);//合同是否未还款完毕
            LeaseContract leaseContract = leaseContractService.selectByPrimaryKey(batchPostlendingPaymentVo.getContractId());
            //挂靠中则不用修改状态
            if (leaseContract.getStatus() != ContractStatus.STATUS_1) {
                //合同是否未还款完毕
                if (contractStatus) {
                    leaseContract.setId(batchPostlendingPaymentVo.getContractId());
                    leaseContract.setStatus(ContractStatus.STATUS_2);//合同状态 0:还款中 1:挂靠中 2:已结束 3:未开始还款 4:提前还款
                    leaseContract.setBackStatus(ContractStatus.STATUS_2);//合同状态 0:还款中 1:挂靠中 2:已结束 3:未开始还款 4:提前还款
                    leaseContractService.updateByPrimaryKeySelective(leaseContract);
                } else {
                    leaseContract.setStatus(ContractStatus.STATUS_0);//合同状态 0:还款中 1:挂靠中 2:已结束 3:未开始还款 4:提前还款
                    leaseContract.setBackStatus(ContractStatus.STATUS_0);//合同状态 0:还款中 1:挂靠中 2:已结束 3:未开始还款 4:提前还款
                    leaseContractService.updateByPrimaryKeySelective(leaseContract);
                }
            }
            //更新 合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
        }
        return true;
    }
}