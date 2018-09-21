package com.hc.lease.account.strategy.impl;

import com.hc.lease.account.adapter.api.LeaseAccountBankCardSignStrategyCommon;
import com.hc.lease.account.vo.AccountBankCardSignStrategyCommonVo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.strategy.Strategy;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 策略模式
 * 协议支付签约
 * 系统承租人签约
 * Created by tong on 2017/11/3.
 */
public class LeaseAccountBankCardSignStrategy implements Strategy {

    @Override
    public Object insert(Object object, Object object1, Object object2) throws GMException {
        DubboTreaceParames dubboTreaceParames = (DubboTreaceParames) object2;
        AccountBankCardSignStrategyCommonVo accountBankCardSignStrategyCommonVo = (AccountBankCardSignStrategyCommonVo) object1;
        LeaseAccountBankCardSignStrategyCommon leaseAccountBankCardSignStrategyCommon = (LeaseAccountBankCardSignStrategyCommon) SpringContextHolder.getBean("leaseAccountBankCardSignStrategyCommon");
        leaseAccountBankCardSignStrategyCommon.common(accountBankCardSignStrategyCommonVo, dubboTreaceParames);
        return null;
    }

    @Override
    public Object update(Object object, Object object1, Object object2) throws GMException {
        return null;
    }

    @Override
    public Object delete(Object object, Object object1, Object object2) throws GMException {
        return null;
    }

    @Override
    public Object select(Object object, Object object1, Object object2) throws GMException {
        return null;
    }

    @Override
    public Object find(Object object, Object object1, Object object2) throws GMException {
        return null;
    }

    @Override
    public Object findAll(Object object, Object object1, Object object2) throws GMException {
        return null;
    }
}
