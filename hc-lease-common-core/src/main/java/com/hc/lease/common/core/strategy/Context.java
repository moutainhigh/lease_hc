package com.hc.lease.common.core.strategy;

import com.hc.lease.common.core.exception.GMException;

/**
 * 策略模式 动态调取执行类
 * Created by tong on 2017/8/28.
 */
public class Context {
    private Strategy strategy;

    public Object insert(Object object, Object type, Object object1, Object object2) throws GMException {
        strategy = StrategyFactory.getInstance().creator(String.valueOf(type));
        return strategy.insert(object, object1, object2);
    }

    public Object update(Object object, Object type, Object object1, Object object2) throws GMException {
        strategy = StrategyFactory.getInstance().creator(String.valueOf(type));
        return strategy.update(object, object1, object2);
    }

    public Object delete(Object object, Object type, Object object1, Object object2) throws GMException {
        strategy = StrategyFactory.getInstance().creator(String.valueOf(type));
        return strategy.delete(object, object1, object2);
    }

    public Object select(Object object, Object type, Object object1, Object object2) throws GMException {
        strategy = StrategyFactory.getInstance().creator(String.valueOf(type));
        return strategy.select(object, object1, object2);
    }

    public Object find(Object object, Object type, Object object1, Object object2) throws GMException {
        strategy = StrategyFactory.getInstance().creator(String.valueOf(type));
        return strategy.find(object, object1, object2);
    }

    public Object findAll(Object object, Object type, Object object1, Object object2) throws GMException {
        strategy = StrategyFactory.getInstance().creator(String.valueOf(type));
        return strategy.findAll(object, object1, object2);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
