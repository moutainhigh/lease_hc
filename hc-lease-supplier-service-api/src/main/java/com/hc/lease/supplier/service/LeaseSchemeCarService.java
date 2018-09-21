package com.hc.lease.supplier.service;

import com.hc.lease.supplier.model.LeaseSchemeCar;
import com.hc.lease.common.core.dao.BaseService;

/**
* 融资方案-车辆Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseSchemeCarService extends BaseService<LeaseSchemeCar> {

    int updateBySchemId(LeaseSchemeCar leaseSchemeCar);

    int deleteBySchemeId(Long id);
}
