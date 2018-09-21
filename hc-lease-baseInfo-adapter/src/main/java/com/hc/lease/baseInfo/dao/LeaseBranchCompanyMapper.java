package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

public interface LeaseBranchCompanyMapper extends BaseDao<LeaseBranchCompany> {
    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseBranchCompany> insertViewParames(Map<String, Object> paramsMap);

    List<LeaseBranchCompany> findByName(Map params);

    int disableByPrimaryKey(Map<String, Object> params);

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    void updateSort(Map<String, Object> paramsMap);
}