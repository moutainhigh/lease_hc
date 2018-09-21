package com.hc.lease.common.core.strategy;

import com.hc.lease.common.core.exception.GMException;

/**
 * 策略模式
 * Created by tong on 2017/8/28.
 */
public interface Strategy {

    Object insert(Object object, Object object1, Object object2) throws GMException;

    Object update(Object object, Object object1, Object object2) throws GMException;

    Object delete(Object object, Object object1, Object object2) throws GMException;

    Object select(Object object, Object object1, Object object2) throws GMException;

    Object find(Object object, Object object1, Object object2) throws GMException;

    Object findAll(Object object, Object object1, Object object2) throws GMException;

}
