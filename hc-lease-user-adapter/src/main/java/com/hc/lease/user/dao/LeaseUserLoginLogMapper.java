package com.hc.lease.user.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.user.model.LeaseUser;
import com.hc.lease.user.model.LeaseUserLoginLog;

/**
 * 后台用户登录日志
 */
public interface LeaseUserLoginLogMapper extends BaseDao<LeaseUserLoginLog> {

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
    int addSelective(LeaseUserLoginLog leaseUserLoginLog);

}