package com.hc.lease.supplier.service;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseScheme;
import com.hc.lease.supplier.model.LeaseSchemeVehicle;

import java.util.List;
import java.util.Map;

/**
* 融租方案-适用车型Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseSchemeVehicleService extends BaseService<LeaseSchemeVehicle> {


    void deleteBySchemeId(Long id);
}
