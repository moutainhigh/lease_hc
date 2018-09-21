package com.hc.lease.supplier.service.api;

import com.hc.lease.supplier.model.LeaseSchemeCarFinancinger;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;

/**
* 车辆与融租方Service
* @author Qiang
* @version 2017-08-18
*/

public interface LeaseSchemeCarFinancingerService extends BaseService<LeaseSchemeCarFinancinger> {

    List<LeaseSchemeCarFinancinger> findByCarId(Long id);

    int deleteByCarId(Long carId);

}
