package com.hc.lease.postlending.strategy.impl;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpaySplitBatch;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitBatchService;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.BatchStrategySplitVo;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 通联支付拆单
 * 批量协议支付
 * 公共处理
 * Created by tong on 2018/6/21
 */
public class SplitBatchCommonStrategy implements Strategy {
    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {

        Context context = (Context) object;

        BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = (BatchPostlendingPaymentSplitVo) object2;
        BatchStrategySplitVo batchStrategySplitVo = (BatchStrategySplitVo) object1;

        LeaseAllinpaySplitBatchService leaseAllinpaySplitBatchService = (LeaseAllinpaySplitBatchService) SpringContextHolder.getBean("leaseAllinpaySplitBatchService");

        ///////批量流水///////
        Map<String, Object> map = Maps.newHashMap();
        map.put("batchNumber", batchStrategySplitVo.getBatchNumber());
        LeaseAllinpaySplitBatch leaseAllinpaySplitBatch = leaseAllinpaySplitBatchService.selectByBatchNumber(map);
        if (leaseAllinpaySplitBatch != null) {
            leaseAllinpaySplitBatch.setNumber(leaseAllinpaySplitBatch.getNumber() + batchStrategySplitVo.getTotalItem());//总数量
            leaseAllinpaySplitBatch.setFailNumber(leaseAllinpaySplitBatch.getFailNumber() == null ? batchStrategySplitVo.getFailNumber() : leaseAllinpaySplitBatch.getFailNumber() + batchStrategySplitVo.getFailNumber());//失败数量
            leaseAllinpaySplitBatch.setSuccessNumber(leaseAllinpaySplitBatch.getSuccessNumber() == null ? batchStrategySplitVo.getSuccessNumber() : leaseAllinpaySplitBatch.getSuccessNumber() + batchStrategySplitVo.getSuccessNumber());//成功数量
            leaseAllinpaySplitBatch.setReceiptsPrice(leaseAllinpaySplitBatch.getReceiptsPrice() == null ? batchStrategySplitVo.getReceiptsPrice() : leaseAllinpaySplitBatch.getReceiptsPrice().add(batchStrategySplitVo.getReceiptsPrice()));//实扣总额/成功总额
            leaseAllinpaySplitBatch.setReceivablePrice(leaseAllinpaySplitBatch.getReceivablePrice() == null ? batchStrategySplitVo.getReceivablePrice() : leaseAllinpaySplitBatch.getReceivablePrice().add(batchStrategySplitVo.getReceivablePrice()));//应扣总额
            leaseAllinpaySplitBatch.setFailPrice(leaseAllinpaySplitBatch.getFailPrice() == null ? batchStrategySplitVo.getFailPrice() : leaseAllinpaySplitBatch.getFailPrice().add(batchStrategySplitVo.getFailPrice()));//失败总额
            leaseAllinpaySplitBatch.setBatchNumber(leaseAllinpaySplitBatch.getBatchNumber());//批次号/批扣流水
            leaseAllinpaySplitBatch.setUpdateBy(batchStrategySplitVo.getUpdateBy());
            leaseAllinpaySplitBatchService.updateByPrimaryKeySelective(leaseAllinpaySplitBatch);
        } else {
            //添加通联批量代收批次统计
            leaseAllinpaySplitBatch = new LeaseAllinpaySplitBatch();
            leaseAllinpaySplitBatch.setNumber(batchStrategySplitVo.getTotalItem());//总数量
            leaseAllinpaySplitBatch.setFailNumber(batchStrategySplitVo.getFailNumber());//失败数量
            leaseAllinpaySplitBatch.setSuccessNumber(batchStrategySplitVo.getSuccessNumber());//成功数量
            leaseAllinpaySplitBatch.setReceiptsPrice(batchStrategySplitVo.getReceiptsPrice());//实扣总额/成功总额
            leaseAllinpaySplitBatch.setReceivablePrice(batchStrategySplitVo.getReceivablePrice());//应扣总额
            leaseAllinpaySplitBatch.setFailPrice(batchStrategySplitVo.getFailPrice());//失败总额
            leaseAllinpaySplitBatch.setBatchNumber(batchStrategySplitVo.getBatchNumber());//批次号/批扣流水
            leaseAllinpaySplitBatch.setCreateBy(batchStrategySplitVo.getCreateBy());
            leaseAllinpaySplitBatch.setUpdateBy(batchStrategySplitVo.getUpdateBy());
            leaseAllinpaySplitBatch = leaseAllinpaySplitBatchService.insertSelective(leaseAllinpaySplitBatch);
            //添加通联批量代收批次统计
        }
        ///////批量流水///////

        batchStrategySplitVo.setAllinpayBatchId(leaseAllinpaySplitBatch.getId());//所属批量代收批次主键id
        batchStrategySplitVo.setAccountId(batchPostlendingPaymentSplitVo.getAccountId());
        context.deal(context, JDBCTpye.JDBC_INSERT + "SplitBatchStrategy", batchStrategySplitVo, batchPostlendingPaymentSplitVo, null, dubboTreaceParames);

        return true;
    }
}