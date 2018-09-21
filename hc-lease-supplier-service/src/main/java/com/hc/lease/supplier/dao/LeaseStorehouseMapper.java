package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseStorehouse;

import java.util.List;
import java.util.Map;

public interface LeaseStorehouseMapper extends BaseDao<LeaseStorehouse> {

    List<LeaseStorehouse> findByBranchCompanyId(List<String> ids);

    List<LeaseStorehouse> findByName(Map params);

    List<LeaseStorehouse> findByBelongIdAndBelongType(Map<String, Object> params);
}