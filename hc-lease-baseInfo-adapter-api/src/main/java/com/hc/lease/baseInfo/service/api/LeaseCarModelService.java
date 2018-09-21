package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseCarModel;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 车型Service
 *
 * @author Tong
 * @version 2017-04-13
 */

public interface LeaseCarModelService extends BaseService<LeaseCarModel> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarModel> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据ID查找记录.
     *
     * @param id .
     * @return entity .
     */
    Map<String, Object> selectById(Long id) throws GMException;

    /**
     * 根据系列主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCarModel> findBySeriesId(List<Long> ids) throws GMException;

    /**
     * 根据系列主键id、车型名称查找
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseCarModel> findBySeriesIdAndName(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseCarModel> findByName(Map params) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    void updateSort(LeaseCarModel leaseCarModel);

    void updateMarketPriceByPrimaryKey(Map<String, Object> paramsMap);

    List<LeaseCarModel> findAllNoPage(Map params);
}
