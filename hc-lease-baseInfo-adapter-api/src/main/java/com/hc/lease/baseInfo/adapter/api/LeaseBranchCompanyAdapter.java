package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.vo.LeaseBranchCompanys;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.LeaseBranchCompanyExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseBranchCompanyTemplate;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 分公司Adapter
 *
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseBranchCompanyAdapter extends BaseAdapter<LeaseBranchCompany> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    int updateSort(LeaseBranchCompanys leaseBranchCompanys);

    List<LeaseBranchCompany> findAllNoPage(Map params);

    LeaseBranchCompanyExcelBackInfo importExcelBranchCompany(List<LeaseBranchCompanyTemplate> leaseBranchCompanyTemplates) throws GMException;
}
