package com.hc.lease.user.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseUserLoginLog;
import com.hc.lease.common.core.dao.BaseService;

/**
 * 后台用户登录日志Service
 *
 * @author Tong
 * @version 2017-12-18
 */

public interface LeaseUserLoginLogService extends BaseService<LeaseUserLoginLog> {

    /**
     * 根据session修改
     *
     * @param leaseUserLoginLog
     * @return
     */
    int updateBySessionCurrent(LeaseUserLoginLog leaseUserLoginLog);

    /**
     * @param leaseUserLoginLog
     * @return
     */
    LeaseUserLoginLog addSelective(LeaseUserLoginLog leaseUserLoginLog) throws GMException;

}
