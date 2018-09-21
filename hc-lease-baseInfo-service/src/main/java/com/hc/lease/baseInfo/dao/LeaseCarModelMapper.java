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
    public List<LeaseCarSeries> findBySeriesId(List<Long> ids) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseCarModel> findByName(Map params) throws GMException;

}