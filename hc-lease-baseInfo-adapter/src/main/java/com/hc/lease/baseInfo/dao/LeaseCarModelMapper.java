package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseCarModel;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 车辆车型
 */
public interface LeaseCarModelMapper extends BaseDao<LeaseCarModel> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarModel> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    LeaseCarModel selectByModelId(Long modelId) throws GMException;

    /**
     * 根据ID查找记录.
     *
     * @param id .
     * @return entity .
     */
    Map<String, Object> selectById(Long id);

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

    int disableByPrimaryKey(Map<String, Object> params) throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    void updateSort(Map<String, Object> paramsMap);

    void updateMarketPriceByPrimaryKey(Map<String, Object> paramsMap);
}