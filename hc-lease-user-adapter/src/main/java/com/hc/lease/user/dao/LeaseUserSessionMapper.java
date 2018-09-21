package com.hc.lease.user.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseUserSession;

import java.util.Map;

/**
 * 后台用户登录状态session
 */
public interface LeaseUserSessionMapper extends BaseDao<LeaseUserSession> {

    int deleteByDeviceIdAndPhone(Map<String, Object> paramsMap) throws GMException;

    LeaseUserSession selectByDeviceId(String deviceId) throws GMException;

}