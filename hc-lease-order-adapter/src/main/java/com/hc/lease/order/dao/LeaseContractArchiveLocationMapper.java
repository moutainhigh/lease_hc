package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseContractArchiveLocation;

public interface LeaseContractArchiveLocationMapper extends BaseDao<LeaseContractArchiveLocation> {

    int deleteByContractId(Long id);
}