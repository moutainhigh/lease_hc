package com.hc.lease.user.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseAuthoUserRole;

public interface LeaseAuthoUserRoleMapper extends BaseDao<LeaseAuthoUserRole> {

    int deleteByUserId(Long userId) throws GMException;

}