package com.hc.lease.supplier.service;

import com.hc.lease.supplier.model.LeaseInsuranceCompany;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 保险公司Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseInsuranceCompanyService extends BaseService<LeaseInsuranceCompany> {

    List<LeaseInsuranceCompany> findByName(Map params);
}
