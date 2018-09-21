package com.hc.lease.postlending.strategy.impl;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.service.api.LeaseAllinpayBatchService;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchStrategyVo;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 处理单人综合扣款、通联批扣
 * 单人综合扣款
 * 支付公共中转处理
 * Created by tong on 2017/8/28.
 */
public class AllPayWayCommonSingleStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        Context context = (Context) object;
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) object2;
        BatchStrategyVo batchStrategyVo = (BatchStrategyVo) object1;
        LeaseAllinpayBatchService leaseAllinpayBatchService = (LeaseAllinpayBatchService) SpringContextHolder.getBean("leaseAllinpayBatchService");
        context.deal(context, JDBCTpye.JDBC_INSERT + "DualAllPayWayCommon", batchStrategyVo, batchPostlendingPaymentList, null, dubboTreaceParames);//支付公共处理
        return true;
    }
}