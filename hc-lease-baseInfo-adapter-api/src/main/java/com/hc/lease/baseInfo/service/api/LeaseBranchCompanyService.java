package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

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

    int disableByPrimaryKey(Map<String, Object> params);

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    void updateSort(LeaseBranchCompany leaseBranchCompany);

    List<LeaseBranchCompany> findAllNoPage(Map params);
}
