package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemeArea;
import com.hc.lease.supplier.model.LeaseSchemeVehicle;

import java.util.List;
import java.util.Map;

public interface LeaseSchemeAreaMapper extends BaseDao<LeaseSchemeArea> {

    List<LeaseSchemeArea> findByName(Map params);

    List<LeaseSchemeArea> selectBySchemeId(Long id);

    void deleteBySchemeId(Long id);
}