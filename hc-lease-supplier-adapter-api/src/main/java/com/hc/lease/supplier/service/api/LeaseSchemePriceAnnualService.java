package com.hc.lease.supplier.service.api;

import com.hc.lease.supplier.model.LeaseSchemePriceAnnual;
import com.hc.lease.common.core.dao.BaseService;

/**
* 方案报价-年度尾款Service
* @author Qiang
* @version 2018-07-27
*/

public interface LeaseSchemePriceAnnualService extends BaseService<LeaseSchemePriceAnnual> {

    void deleteBySchemePriceId(Long id);
}
