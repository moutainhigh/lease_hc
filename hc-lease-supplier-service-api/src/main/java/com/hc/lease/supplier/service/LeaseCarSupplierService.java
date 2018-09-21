package com.hc.lease.supplier.service;

import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 车辆供应商Service
* @author Qiang
* @version 2017-05-05
*/

public interface LeaseCarSupplierService extends BaseService<LeaseCarSupplier> {

    List<LeaseCarSupplier> findByName(Map params);
}
