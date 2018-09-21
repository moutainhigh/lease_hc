package com.hc.lease.user.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseAuthoUserOrganization;

public interface LeaseAuthoUserOrganizationMapper extends BaseDao<LeaseAuthoUserOrganization> {

    int deleteByUserId(Long userId) throws GMException;

}