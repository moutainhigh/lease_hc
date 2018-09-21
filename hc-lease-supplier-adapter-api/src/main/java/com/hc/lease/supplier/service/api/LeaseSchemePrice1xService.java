package com.hc.lease.supplier.service.api;

import com.hc.lease.supplier.model.LeaseSchemePrice1x;
import com.hc.lease.common.core.dao.BaseService;

/**
* 方案报价-1+xService
* @author Qiang
* @version 2018-07-27
*/

public interface LeaseSchemePrice1xService extends BaseService<LeaseSchemePrice1x> {

    void deleteBySchemePriceId(Long id);
}
