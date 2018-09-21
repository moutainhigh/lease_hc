package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseSchemeVehicle;

/**
* 融租方案-适用车型Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseSchemeVehicleService extends BaseService<LeaseSchemeVehicle> {


    void deleteBySchemeId(Long id);
}
