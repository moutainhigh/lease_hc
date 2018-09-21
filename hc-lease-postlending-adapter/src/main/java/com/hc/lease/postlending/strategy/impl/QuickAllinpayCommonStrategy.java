package com.hc.lease.postlending.strategy.impl;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.PostlendingPaymentParameVo;
import com.hc.lease.postlending.vo.TransBodyInstallVo;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 处理单人综合扣款、通联批扣
 * 通联协议支付
 * 公共处理
 * <p>
 * Created by tong on 2018/5/18.
 */
public class QuickAllinpayCommonStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        Context context = (Context) object;

        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) object2;
        PostlendingPaymentParameVo postlendingPaymentParameVo = (PostlendingPaymentParameVo) object1;
        Map<String, TransBodyInstallVo> transBodyInstallAll = postlendingPaymentParameVo.getBatchMapAll();//需要扣款的数据汇总

        if (transBodyInstallAll != null) {

            Date newDate = DateTime.now().toDate();
            newDate = DateUtil.getDateY_M_D_HMS(newDate);
            for (String key : transBodyInstallAll.keySet()) {
                TransBodyInstallVo transBodyInstallVo = transBodyInstallAll.get(key);

                /////////////////////////处理属于扣款承租人银行卡的款项/////////////////////////
                List<BatchPostlendingPaymentVo> needBatchPostlendingPaymentList = dualNeedBatchPostlendingPaymentList(batchPostlendingPaymentList, key);
                /////////////////////////处理属于扣款承租人银行卡的款项/////////////////////////

                transBodyInstallVo.setCreateTime(newDate);
                transBodyInstallVo.setUpdateTime(newDate);
                transBodyInstallVo.setCreateBy(postlendingPaymentParameVo.getCreateBy());
                transBodyInstallVo.setUpdateBy(postlendingPaymentParameVo.getUpdateBy());
                transBodyInstallVo.setBatchNumber(postlendingPaymentParameVo.getBatchNumber());//批次号/批扣流水
                transBodyInstallVo.setSingleOrBatch(postlendingPaymentParameVo.getSingleOrBatch());//单笔或批量/0:单笔; 1:批量
                transBodyInstallVo.setAllinpayStatusLogType(postlendingPaymentParameVo.getAllinpayStatusLogType());
                transBodyInstallVo.setControllerSource(postlendingPaymentParameVo.getControllerSource());//操作来源 0:单笔; 1:批量;2:手动批扣

                if (transBodyInstallVo.getAmount().compareTo(transBodyInstallVo.getAllinpayPriceLimit()) == 1) {//银行卡扣款金额超限额
                    transBodyInstallVo.setIsSpilt(1);//是否有拆单/0:是; 1:否
                    context.deal(context, JDBCTpye.JDBC_INSERT + "SplitQuickAllinpay", transBodyInstallVo, needBatchPostlendingPaymentList, null, dubboTreaceParames);
                } else {
                    transBodyInstallVo.setIsSpilt(0);//是否有拆单/0:是; 1:否
                    context.deal(context, JDBCTpye.JDBC_INSERT + "QuickAllinpay", transBodyInstallVo, needBatchPostlendingPaymentList, null, dubboTreaceParames);
                }

            }
        }
        ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.SPLIT_ALLINPAY_SEND_SUCCESS);
        return resultHashMap;
    }

    /**
     * 处理属于同一个还款计划明细的款项
     *
     * @param batchPostlendingPaymentList 扣款款项
     * @param key                         合同主键和还款计划明细主键组合做Map的键
     * @return
     */
    public List<BatchPostlendingPaymentVo> dualNeedBatchPostlendingPaymentList(List<BatchPostlendingPaymentVo> batchPostlendingPaymentList, String key) {
        List<BatchPostlendingPaymentVo> needBatchPostlendingPaymentList = new ArrayList<BatchPostlendingPaymentVo>();
        for (int i = 0; i < batchPostlendingPaymentList.size(); i++) {
            BatchPostlendingPaymentVo batchPostlendingPaymentVo = batchPostlendingPaymentList.get(i);
            String makeKey = batchPostlendingPaymentVo.getContractId() + "-" + batchPostlendingPaymentVo.getRepaymentId();
            if (makeKey.equals(key)) {
                needBatchPostlendingPaymentList.add(batchPostlendingPaymentVo);
            }
        }
        return needBatchPostlendingPaymentList;
    }

}