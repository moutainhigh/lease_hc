package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseCarModel;
import com.hc.lease.baseInfo.vo.LeaseCarModels;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.CarModelImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarModelTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;
import java.util.Map;

/**
 * 车辆车型Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseCarModelAdapter extends BaseAdapter<LeaseCarModel> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据ID查找记录.
     *
     * @param id .
     * @return entity .
     */
    Map<String, Object>  selectById(Long id) throws GMException ;

    ResultHashMap insertSelective(LeaseCarModel leaseCarModel, UserSession userSession)throws GMException ;

    int updateByPrimaryKeySelective(LeaseCarModel leaseCarModel, UserSession userSession)throws GMException ;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException ;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    int updateSort(LeaseCarModels leaseCarModels);

    int updateMarketPriceByPrimaryKey(Map<String, Object> paramsMap);

    List<LeaseCarModel> findAllNoPage(Map params);

    CarModelImportExcelBackInfo importExcelCarModel(List<LeaseCarModelTemplate> leaseCarModelTemplates, UserSession userSession) throws GMException;
}
