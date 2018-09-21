package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseSchemePackage;

/**
* 融租方案-套餐Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseSchemePackageService extends BaseService<LeaseSchemePackage> {

    LeaseSchemePackage selectBySchemeId(Long id);
}
