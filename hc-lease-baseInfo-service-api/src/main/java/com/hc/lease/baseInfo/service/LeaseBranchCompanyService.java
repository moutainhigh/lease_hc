package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 分公司Service
 *
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseBranchCompanyService extends BaseService<LeaseBranchCompany> {

    List<LeaseBranchCompany> findByName(Map params);
}
