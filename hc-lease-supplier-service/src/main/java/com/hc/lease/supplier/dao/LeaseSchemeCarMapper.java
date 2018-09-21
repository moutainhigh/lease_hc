package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemeCar;

public interface LeaseSchemeCarMapper extends BaseDao<LeaseSchemeCar> {

    int updateBySchemeId(LeaseSchemeCar leaseSchemeCar);

    int deleteBySchemeId(Long id);
}