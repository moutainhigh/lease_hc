package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseInsuranceCompany;

import java.util.List;
import java.util.Map;

public interface LeaseInsuranceCompanyMapper extends BaseDao<LeaseInsuranceCompany> {

    List<LeaseInsuranceCompany> findByName(Map params);

    Long getIdByInsuranceCompanyName(String insuranceCompanyName);

    int disableByPrimaryKey(Map<String, Object> params);

    void updateSort(Map<String, Object> paramsMap);

    List<String> findAllInsuranceCompanyNames();

    Integer findMaxNumber();
}