package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseCompanyHeader;
import com.hc.lease.baseInfo.vo.LeaseCompanyHeaders;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.LeaseCompanyHeaderExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCompanyHeaderTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;
import java.util.Map;

/**
 * 合同方-公司抬头Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseCompanyHeaderAdapter extends BaseAdapter<LeaseCompanyHeader> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    ResultHashMap insertSelective(LeaseCompanyHeader leaseCompanyHeader, UserSession userSession)throws GMException;

    int updateByPrimaryKeySelective(LeaseCompanyHeader leaseCompanyHeader, UserSession userSession)throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    int updateSort(LeaseCompanyHeaders leaseCompanyHeaders);

    List<LeaseCompanyHeader> findAllNoPage(Map param);

    LeaseCompanyHeaderExcelBackInfo importExcelCompanyHeader(List<LeaseCompanyHeaderTemplate> leaseCompanyHeaderTemplates) throws GMException;
}
