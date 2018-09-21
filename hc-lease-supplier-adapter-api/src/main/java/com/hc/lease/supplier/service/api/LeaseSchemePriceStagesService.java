package com.hc.lease.supplier.service.api;

import com.hc.lease.supplier.model.LeaseSchemePriceStages;
import com.hc.lease.common.core.dao.BaseService;

/**
* 方案报价-分期Service
* @author Qiang
* @version 2018-07-27
*/

public interface LeaseSchemePriceStagesService extends BaseService<LeaseSchemePriceStages> {

    void deleteBySchemePriceId(Long id);
}
