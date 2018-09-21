package com.hc.lease.supplier.service;

import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.common.core.dao.BaseService;

/**
* 车辆保险信息Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseCarInsuranceService extends BaseService<LeaseCarInsurance> {

    void updateByCarId(LeaseCarInsurance leaseCarInsurance);

    void deleteByCarId(Long id);
}
