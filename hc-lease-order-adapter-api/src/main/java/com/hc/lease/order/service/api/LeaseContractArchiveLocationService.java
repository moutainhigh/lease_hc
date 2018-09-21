package com.hc.lease.order.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.order.model.LeaseContractArchiveLocation;

/**
* 融租合同-归档信息Service
* @author Qiang
* @version 2017-05-23
*/

public interface LeaseContractArchiveLocationService extends BaseService<LeaseContractArchiveLocation> {

    int deleteByContractId(Long id);
}
