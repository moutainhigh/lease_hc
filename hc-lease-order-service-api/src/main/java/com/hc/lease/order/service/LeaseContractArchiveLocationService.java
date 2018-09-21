package com.hc.lease.order.service;

import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.common.core.dao.BaseService;

/**
* 融租合同-归档信息Service
* @author Qiang
* @version 2017-05-23
*/

public interface LeaseContractArchiveLocationService extends BaseService<LeaseContractArchiveLocation> {

    int deleteByContractId(Long id);
}
