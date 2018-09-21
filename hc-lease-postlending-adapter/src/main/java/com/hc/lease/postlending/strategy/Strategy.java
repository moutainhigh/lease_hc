package com.hc.lease.postlending.strategy;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;

/**
 * 策略模式
 * Created by tong on 2017/8/28.
 */
public interface Strategy {
    Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException;
}
