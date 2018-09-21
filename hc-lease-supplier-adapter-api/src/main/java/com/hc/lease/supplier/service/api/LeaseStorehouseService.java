package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseStorehouse;

import java.util.List;
import java.util.Map;

/**
* 仓库Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseStorehouseService extends BaseService<LeaseStorehouse> {

    List<LeaseStorehouse> findByBranchCompanyId(List<String> ids);

    List<LeaseStorehouse> findByName(Map params);

    List<LeaseStorehouse> findByBelongIdAndBelongType(Map<String, Object> params);

    int disableByPrimaryKey(Map<String, Object> params);

    void updateSort(LeaseStorehouse leaseStorehouse);

    int updateDefaultSelected(Map<String, Object> paramsMap);

    List<LeaseStorehouse> findAllNoPage(Map param);
}
