package com.hc.lease.account.adapter.api;

import com.hc.lease.account.vo.AccountBankCardSignStrategyCommonVo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.vo.StrategyVo;

import java.util.List;

/**
 * 通联协议支付 签约
 * 策略模式 公共处理
 * Created by tong on 2018/4/26.
 */
public interface LeaseAccountBankCardSignStrategyCommon {
    /**
     * @param accountBankCardSignStrategyCommonVo
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    Object common(AccountBankCardSignStrategyCommonVo accountBankCardSignStrategyCommonVo, DubboTreaceParames dubboTreaceParames) throws GMException;

}
