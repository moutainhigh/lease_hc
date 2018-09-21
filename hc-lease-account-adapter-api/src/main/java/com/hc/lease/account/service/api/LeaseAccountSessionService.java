package com.hc.lease.account.service.api;

import com.hc.lease.account.model.LeaseAccountSession;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.Map;

/**
 * 注册用户/承租人登录状态sessionService
 *
 * @author Tong
 * @version 2017-05-24
 */

public interface LeaseAccountSessionService extends BaseService<LeaseAccountSession> {

    int insertOrUpdate(LeaseAccountSession leaseAccountSession) throws GMException;

    LeaseAccountSession selectByDeviceId(String deviceId) throws GMException;

    int deleteByDeviceIdAndPhone(Map<String, Object> paramsMap) throws GMException;

}
