package com.hc.lease.user.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseAuthoUserRole;

/**
 * 用户对应的角色Service
 *
 * @author tong
 * @version 2018-08-27
 */

public interface LeaseAuthoUserRoleService extends BaseService<LeaseAuthoUserRole> {
    /**
     * 删除用户的所属角色
     *
     * @param userId
     * @return
     * @throws GMException
     */
    int deleteByUserId(Long userId) throws GMException;

}
