package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.baseInfo.vo.LeaseCarSeriesList;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.CarBrandSeriesImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarBrandSeriesTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;
import java.util.Map;

/**
 * 车辆系列Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseCarSeriesAdapter extends BaseAdapter<LeaseCarSeries> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    ResultHashMap insertSelective(LeaseCarSeries leaseCarSeries, UserSession userSession)throws GMException;

    int updateByPrimaryKeySelective(LeaseCarSeries leaseCarSeries, UserSession userSession)throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    int updateSort(LeaseCarSeriesList leaseCarSeriesList);

    List<LeaseCarSeries> findAllNoPage(Map params);

    CarBrandSeriesImportExcelBackInfo importExcelCarBrandSeries(List<LeaseCarBrandSeriesTemplate> leaseCarBrandSeriesTemplates, UserSession userSession) throws GMException;
}
