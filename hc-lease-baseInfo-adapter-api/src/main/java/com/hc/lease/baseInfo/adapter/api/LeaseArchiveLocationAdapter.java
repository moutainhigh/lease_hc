package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.baseInfo.vo.LeaseArchiveLocations;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.LeaseArchiveLocationExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseArchiveLocationTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;
import java.util.Map;

/**
 * 归档位置Adapter
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseArchiveLocationAdapter extends BaseAdapter<LeaseArchiveLocation> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    ResultHashMap insertSelective(LeaseArchiveLocation leaseArchiveLocation, UserSession userSession)throws GMException;

    int updateByPrimaryKeySelective(LeaseArchiveLocation leaseArchiveLocation, UserSession userSession)throws GMException;

    int disableByPrimaryKey(Map<String, Object> params);

    int updateSort(LeaseArchiveLocations leaseArchiveLocations);

    int updateDefaultSelected(Map<String, Object> paramsMap);

    List<LeaseArchiveLocation> findAllNoPage(Map param);

    LeaseArchiveLocationExcelBackInfo importExcelArchiveLocation(List<LeaseArchiveLocationTemplate> leaseArchiveLocationTemplates) throws GMException;
}
