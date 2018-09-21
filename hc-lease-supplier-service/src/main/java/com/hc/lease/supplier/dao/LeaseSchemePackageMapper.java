package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemePackage;

public interface LeaseSchemePackageMapper  extends BaseDao<LeaseSchemePackage>{

    LeaseSchemePackage selectBySchemeId(Long id);
}