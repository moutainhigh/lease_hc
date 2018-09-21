package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseInsuranceCompany;

import java.util.List;
import java.util.Map;

/**
* 保险公司Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseInsuranceCompanyService extends BaseService<LeaseInsuranceCompany> {

    List<LeaseInsuranceCompany> findByName(Map params);

    int disableByPrimaryKey(Map<String, Object> params);

    void updateSort(LeaseInsuranceCompany leaseInsuranceCompany);

    Long getIdByInsuranceCompanyName(String insuranceCompanyName);

    List<String> findAllInsuranceCompanyNames();

    List<LeaseInsuranceCompany> findAllNoPage(Map param);

    Integer findMaxNumber();
}
