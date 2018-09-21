package com.hc.lease.postlending.strategy;

import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.constant.StrategyType;
import com.hc.lease.postlending.vo.SingleOrBathType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 贷后代收
 * 策略模式 动态调取执行类
 * Created by tong on 2017/8/28.
 */
public class StrategyFactory {

    private Logger logger = LoggerFactory.getLogger(StrategyFactory.class);

    private static StrategyFactory factory = new StrategyFactory();

    private StrategyFactory() {
    }

    private static Map strategyMap = new HashMap();

    //新加时 注意 防止 strategyMap的键重复
    static {

        //根据通联轮询回来的处理结果，更新代收流水状态和更新支付状态汇总管理状态
        strategyMap.put(StrategyType.TYPE_0.value() + JDBCTpye.JDBC_UPDATE, "com.hc.lease.postlending.strategy.impl.PostlendingSchemeRepaymentUpdateStrategy");//月供
        strategyMap.put(StrategyType.TYPE_1.value() + JDBCTpye.JDBC_UPDATE, "com.hc.lease.postlending.strategy.impl.PostlendingContractLinkUpdateStrategy");//挂靠费
        strategyMap.put(StrategyType.TYPE_2.value() + JDBCTpye.JDBC_UPDATE, "com.hc.lease.postlending.strategy.impl.PostlendingOverdueUpdateStrategy");//逾期滞纳金
        strategyMap.put(StrategyType.TYPE_3.value() + JDBCTpye.JDBC_UPDATE, "com.hc.lease.postlending.strategy.impl.PostlendingContractAdvanceUpdateStrategy");//提前还款/剩余本金
        strategyMap.put(StrategyType.TYPE_4.value() + JDBCTpye.JDBC_UPDATE, "com.hc.lease.postlending.strategy.impl.PostlendingBalancePaymentUpdateStrategy");//尾款/还款到最后一期的尾款
        strategyMap.put(StrategyType.TYPE_5.value() + JDBCTpye.JDBC_UPDATE, "com.hc.lease.postlending.strategy.impl.PostlendingDefaultInterestUpdateStrategy");//提前还款/罚款
        strategyMap.put(StrategyType.TYPE_6.value() + JDBCTpye.JDBC_UPDATE, "com.hc.lease.postlending.strategy.impl.PostlendingBalancePaymentUpdateStrategy");//尾款/提前还款的尾款
        strategyMap.put(StrategyType.TYPE_7.value() + JDBCTpye.JDBC_UPDATE, "com.hc.lease.postlending.strategy.impl.PostlendingOtherUpdateStrategy");//其他款项
        //根据通联轮询回来的处理结果，更新代收流水状态和更新支付状态汇总管理状态

        //定时检测逾期的月租/挂靠费并插入逾期流水
        strategyMap.put(StrategyType.TYPE_0.value() + JDBCTpye.JDBC_OTHER, "com.hc.lease.postlending.strategy.impl.PostlendingCheckOverdueRepaymentStrategy");//定时检测逾期的月租并插入逾期流水
        strategyMap.put(StrategyType.TYPE_1.value() + JDBCTpye.JDBC_OTHER, "com.hc.lease.postlending.strategy.impl.PostlendingCheckOverdueContractLinkStrategy");//定时检测逾期的挂靠费并插入逾期流水
        //定时检测逾期的月租/挂靠费并插入逾期流水

        strategyMap.put(JDBCTpye.JDBC_INSERT + "DualAllPayWayCommon", "com.hc.lease.postlending.strategy.impl.DualAllPayWayCommonStrategy");//支付公共处理


        /////////////////////////////////////处理单人综合扣款、通联批扣/////////////////////////////////////
        //批扣的支付方式
        strategyMap.put(JDBCTpye.JDBC_INSERT + "PostlendingAllinpay", "com.hc.lease.postlending.strategy.impl.PostlendingAllinpayStrategy");//通联代扣
        strategyMap.put(JDBCTpye.JDBC_INSERT + "QuickAllinpayCommon", "com.hc.lease.postlending.strategy.impl.QuickAllinpayCommonStrategy");//通联协议支付/公共处理
        strategyMap.put(JDBCTpye.JDBC_INSERT + "QuickAllinpay", "com.hc.lease.postlending.strategy.impl.QuickAllinpayStrategy");//通联协议支付
        //批扣的支付方式
        //批扣的各种款项处理
        strategyMap.put(JDBCTpye.JDBC_INSERT + "AllPayWayCommon", "com.hc.lease.postlending.strategy.impl.AllPayWayCommonStrategy");//支付公共中转处理
        strategyMap.put(StrategyType.TYPE_0.value() + JDBCTpye.JDBC_INSERT + "AllPayWayCommon", "com.hc.lease.postlending.strategy.impl.AllPayWayCommonMonthStrategy");//通联批扣处理月租款项
        strategyMap.put(StrategyType.TYPE_1.value() + JDBCTpye.JDBC_INSERT + "AllPayWayCommon", "com.hc.lease.postlending.strategy.impl.AllPayWayCommonLinkStrategy");//通联批扣处理挂靠费款项
        strategyMap.put(StrategyType.TYPE_2.value() + JDBCTpye.JDBC_INSERT + "AllPayWayCommon", "com.hc.lease.postlending.strategy.impl.AllPayWayCommonOverdueStrategy");//通联批扣处理滞纳金款项
        strategyMap.put(StrategyType.TYPE_7.value() + JDBCTpye.JDBC_INSERT + "AllPayWayCommon", "com.hc.lease.postlending.strategy.impl.AllPayWayCommonOtherStrategy");//通联批扣处理其他款项
        //批扣的各种款项处理
        strategyMap.put(SingleOrBathType.TYPE_0.value() + JDBCTpye.JDBC_SINGLEORBATHTYPE + "AllPayWayCommon", "com.hc.lease.postlending.strategy.impl.AllPayWayCommonSingleStrategy");//单笔扣款
        strategyMap.put(SingleOrBathType.TYPE_1.value() + JDBCTpye.JDBC_SINGLEORBATHTYPE + "AllPayWayCommon", "com.hc.lease.postlending.strategy.impl.AllPayWayCommonBathStrategy");//批量扣款
        /////////////////////////////////////处理单人综合扣款、通联批扣/////////////////////////////////////


        /////////////////////////////////////通联支付超额拆分交易/////////////////////////////////////
        strategyMap.put(JDBCTpye.JDBC_INSERT + "SplitBatchAllinpayQuickStrategy", "com.hc.lease.postlending.strategy.impl.SplitBatchAllinpayQuickStrategy");//通联支付拆单 批量协议支付
        strategyMap.put(JDBCTpye.JDBC_INSERT + "SplitBatchCommonStrategy", "com.hc.lease.postlending.strategy.impl.SplitBatchCommonStrategy");//通联支付拆单 批量协议支付 公共处理
        strategyMap.put(JDBCTpye.JDBC_INSERT + "SplitBatchStrategy", "com.hc.lease.postlending.strategy.impl.SplitBatchStrategy");//通联支付拆单 批量协议支付
        strategyMap.put(JDBCTpye.JDBC_INSERT + "SplitAllinpayQuickStrategy", "com.hc.lease.postlending.strategy.impl.SplitAllinpayQuickStrategy");//通联支付拆单 单笔协议支付
        strategyMap.put(JDBCTpye.JDBC_INSERT + "SplitInsertStrategy", "com.hc.lease.postlending.strategy.impl.SplitInsertStrategy");//通联支付拆单 单笔协议支付
        strategyMap.put(JDBCTpye.JDBC_UPDATE + "SplitUpdateStrategy", "com.hc.lease.postlending.strategy.impl.SplitUpdateStrategy");//根据通联轮询回来的处理结果，更新代收流水状态和更新超额拆分交易明细状态
        strategyMap.put(JDBCTpye.JDBC_INSERT + "SplitQuickAllinpay", "com.hc.lease.postlending.strategy.impl.SplitQuickAllinpayStrategy");//超额拆分交易处理
        /////////////////////////////////////通联支付超额拆分交易/////////////////////////////////////

        /////////////////////////////////////手动扣款/////////////////////////////////////
        strategyMap.put(JDBCTpye.JDBC_INSERT + "ManualDeductionsPayCommon", "com.hc.lease.postlending.strategy.impl.ManualDeductionsPayCommonStrategy");//手动扣款/公共处理
        strategyMap.put(JDBCTpye.JDBC_INSERT + "ManualDeductionsPay", "com.hc.lease.postlending.strategy.impl.ManualDeductionsPayStrategy");//手动扣款/处理扣款
        strategyMap.put(JDBCTpye.JDBC_INSERT + "ManualDeductionsPayContract", "com.hc.lease.postlending.strategy.impl.ManualDeductionsPayContractStrategy");//手动扣款/有合同
        /////////////////////////////////////手动扣款/////////////////////////////////////

    }

    public Strategy creator(Object type) {
        Strategy strategy = null;
        try {
            //反射创建
            Class c = Class.forName((String) strategyMap.get(type));
            strategy = (Strategy) c.newInstance();
            logger.trace("strategy=---=" + strategy);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return strategy;
        //return (Strategy) strategyMap.get(type);
    }

    public static StrategyFactory getInstance() {
        return new StrategyFactory();
        //return factory;
    }
}
