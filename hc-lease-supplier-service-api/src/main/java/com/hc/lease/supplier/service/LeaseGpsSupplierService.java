package com.hc.lease.supplier.service;

import com.hc.lease.supplier.model.LeaseGpsSupplier;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* GPS供应商Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseGpsSupplierService extends BaseService<LeaseGpsSupplier> {

    List<LeaseGpsSupplier> findByName(Map params);
}
