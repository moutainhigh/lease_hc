package com.hc.lease.supplier.service;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseCarDictAccessory;
import com.hc.lease.supplier.model.LeaseSchemeCar;

/**
* 车辆信息-车辆-随车物料Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseCarDictAccessoryService extends BaseService<LeaseCarDictAccessory> {


    void deleteByCarId(Long id);
}
