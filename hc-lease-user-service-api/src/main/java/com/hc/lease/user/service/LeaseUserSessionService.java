package com.hc.lease.user.service;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseUserSession;
import com.hc.lease.common.core.dao.BaseService;

import java.util.Map;

/**
* 后台用户登录状态sessionService
* @author Tong
* @version 2017-06-26
*/

public interface LeaseUserSessionService extends BaseService<LeaseUserSession> {

    int deleteByDeviceIdAndPhone(Map<String, Object> paramsMap) throws GMException;

    LeaseUserSession selectByDeviceId(String deviceId) throws GMException;

}
