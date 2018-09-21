package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseScheme;
import com.hc.lease.supplier.model.LeaseSchemeVehicle;

import java.util.List;
import java.util.Map;

public interface LeaseSchemeVehicleMapper extends BaseDao<LeaseSchemeVehicle> {

    List<LeaseSchemeVehicle> findByName(Map params);

    void deleteBySchemeId(Long id);
}