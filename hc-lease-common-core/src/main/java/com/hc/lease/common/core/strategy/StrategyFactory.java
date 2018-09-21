package com.hc.lease.common.core.strategy;

import com.hc.lease.common.core.constant.AccountBankCardSignStrategyType;
import com.hc.lease.common.core.constant.AccountStrategyType;
import com.hc.lease.common.core.constant.OrganizationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
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

        strategyMap.put(AccountStrategyType.TYPE_0.value() + "LeaseAccount", "com.hc.lease.account.strategy.impl.LeaseAccountCreditServiceStrategy");//个人类型用户/承租人
        strategyMap.put(AccountStrategyType.TYPE_1.value() + "LeaseAccount", "com.hc.lease.account.strategy.impl.LeaseAccountCompanyServiceStrategy");//注册公司类型用户/承租人

        strategyMap.put(AccountBankCardSignStrategyType.TYPE_0.value() + "LeaseAccountBankCardSign", "com.hc.lease.account.strategy.impl.LeaseAccountBankCardSignStrategy");//系统承租人签约
        strategyMap.put(AccountBankCardSignStrategyType.TYPE_1.value() + "LeaseAccountBankCardSign", "com.hc.lease.account.strategy.impl.LeaseAccountBankCardSignAddStrategy");//新增承租人签约

    }

    public Strategy creator(Object type) {
        Strategy strategy = null;
        try {
            //反射创建
            Class c = Class.forName((String) strategyMap.get(type));
            strategy = (Strategy) c.newInstance();
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
