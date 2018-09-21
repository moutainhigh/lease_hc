package com.hc.lease.supplier.service.api;

import com.hc.lease.supplier.model.LeaseSchemePriceRent;
import com.hc.lease.common.core.dao.BaseService;

/**
* 方案报价-纯租Service
* @author Qiang
* @version 2018-08-09
*/

public interface LeaseSchemePriceRentService extends BaseService<LeaseSchemePriceRent> {

    void deleteBySchemePriceId(Long id);
}
