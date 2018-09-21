package com.hc.lease.postlending.strategy.impl;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.model.LeaseAllinpayBatch;
import com.hc.lease.postlending.service.api.LeaseAllinpayBatchService;
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
 * 通联批扣
 * 支付公共中转处理
 * Created by tong on 2017/8/28.
 */
public class AllPayWayCommonBathStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        Context context = (Context) object;
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) object2;
        BatchStrategyVo batchStrategyVo = (BatchStrategyVo) object1;
        LeaseAllinpayBatchService leaseAllinpayBatchService = (LeaseAllinpayBatchService) SpringContextHolder.getBean("leaseAllinpayBatchService");

        ///////批量流水///////
        Map<String, Object> map = Maps.newHashMap();
        map.put("batchNumber", batchStrategyVo.getBatchNumber());
        LeaseAllinpayBatch leaseAllinpayBatch = leaseAllinpayBatchService.selectByBatchNumber(map);
        if (leaseAllinpayBatch != null) {
            leaseAllinpayBatch.setNumber(leaseAllinpayBatch.getNumber() + batchStrategyVo.getTotalItem());//总数量
            leaseAllinpayBatch.setFailNumber(leaseAllinpayBatch.getFailNumber() == null ? batchStrategyVo.getFailNumber() : leaseAllinpayBatch.getFailNumber() + batchStrategyVo.getFailNumber());//失败数量
            leaseAllinpayBatch.setSuccessNumber(leaseAllinpayBatch.getSuccessNumber() == null ? batchStrategyVo.getSuccessNumber() : leaseAllinpayBatch.getSuccessNumber() + batchStrategyVo.getSuccessNumber());//成功数量
            leaseAllinpayBatch.setReceiptsPrice(leaseAllinpayBatch.getReceiptsPrice() == null ? batchStrategyVo.getReceiptsPrice() : leaseAllinpayBatch.getReceiptsPrice().add(batchStrategyVo.getReceiptsPrice()));//实扣总额/成功总额
            leaseAllinpayBatch.setReceivablePrice(leaseAllinpayBatch.getReceivablePrice() == null ? batchStrategyVo.getReceivablePrice() : leaseAllinpayBatch.getReceivablePrice().add(batchStrategyVo.getReceivablePrice()));//应扣总额
            leaseAllinpayBatch.setFailPrice(leaseAllinpayBatch.getFailPrice() == null ? batchStrategyVo.getFailPrice() : leaseAllinpayBatch.getFailPrice().add(batchStrategyVo.getFailPrice()));//失败总额
            leaseAllinpayBatch.setBatchNumber(leaseAllinpayBatch.getBatchNumber());//批次号/批扣流水
            leaseAllinpayBatch.setUpdateBy(batchStrategyVo.getUpdateBy());
            leaseAllinpayBatch.setUpdateTime(batchStrategyVo.getUpdateTime());
            leaseAllinpayBatchService.updateByPrimaryKeySelective(leaseAllinpayBatch);
        } else {
            //添加通联批量代收批次统计
            leaseAllinpayBatch = new LeaseAllinpayBatch();
            leaseAllinpayBatch.setNumber(batchStrategyVo.getTotalItem());//总数量
            leaseAllinpayBatch.setFailNumber(batchStrategyVo.getFailNumber());//失败数量
            leaseAllinpayBatch.setSuccessNumber(batchStrategyVo.getSuccessNumber());//成功数量
            leaseAllinpayBatch.setReceiptsPrice(batchStrategyVo.getReceiptsPrice());//实扣总额/成功总额
            leaseAllinpayBatch.setReceivablePrice(batchStrategyVo.getReceivablePrice());//应扣总额
            leaseAllinpayBatch.setFailPrice(batchStrategyVo.getFailPrice());//失败总额
            leaseAllinpayBatch.setBatchNumber(batchStrategyVo.getBatchNumber());//批次号/批扣流水
            leaseAllinpayBatch.setCreateBy(batchStrategyVo.getCreateBy());
            leaseAllinpayBatch.setUpdateBy(batchStrategyVo.getUpdateBy());
            leaseAllinpayBatch.setCreateTime(batchStrategyVo.getCreateTime());
            leaseAllinpayBatch.setUpdateTime(batchStrategyVo.getUpdateTime());
            leaseAllinpayBatch = leaseAllinpayBatchService.insertSelective(leaseAllinpayBatch);
            //添加通联批量代收批次统计
        }
        ///////批量流水///////
        batchStrategyVo.setAllinpayBatchId(leaseAllinpayBatch.getId());//所属批量代收批次主键id

        context.deal(context, JDBCTpye.JDBC_INSERT + "DualAllPayWayCommon", batchStrategyVo, batchPostlendingPaymentList, null, dubboTreaceParames);//支付公共处理

        return true;
    }
}