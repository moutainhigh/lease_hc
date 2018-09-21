package com.hc.lease.user.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseAuthoUserOrganization;
import com.hc.lease.common.core.dao.BaseService;

/**
 * 用户-公司、部门、组中间表，用户所属的组织Service
 *
 * @author tong
 * @version 2018-08-27
 */

public interface LeaseAuthoUserOrganizationService extends BaseService<LeaseAuthoUserOrganization> {
    /**
     * 删除用户的所属组织
     *
     * @param userId
     * @return
     * @throws GMException
     */
    int deleteByUserId(Long userId) throws GMException;

}
