package com.hc.lease.postlending.strategy;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;

/**
 * 贷后代收
 * 策略模式 动态调取执行类
 * Created by tong on 2017/8/28.
 */
public class Context {
    private Strategy strategy;

    public Object deal(Object object, Object type, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        strategy = StrategyFactory.getInstance().creator(String.valueOf(type));
        return strategy.deal(object, object1, object2, object3, dubboTreaceParames);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
