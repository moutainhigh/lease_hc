package com.hc.lease.account.dao;

import com.hc.lease.account.model.LeaseAccountSession;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.Map;

/**
 * 注册用户/承租人登录状态session
 * Created by Tong on 2017/3/31.
 */
public interface LeaseAccountSessionMapper extends BaseDao<LeaseAccountSession> {

    int deleteByAccountId(Long accountId) throws GMException;

    LeaseAccountSession selectByDeviceId(String deviceId) throws GMException;

    int deleteByDeviceIdAndPhone(Map<String, Object> paramsMap) throws GMException;

}
