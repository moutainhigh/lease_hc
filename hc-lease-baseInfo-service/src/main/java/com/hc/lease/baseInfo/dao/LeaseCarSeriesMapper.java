package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseCarModel;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 车辆系列
 */
public interface LeaseCarSeriesMapper extends BaseDao<LeaseCarSeries> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarSeries> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据品牌主键id查找
     *
     * @return
     */
    List<LeaseCarSeries> findByBrandsId(List<Long> ids) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseCarSeries> findByName(Map params) throws GMException;

}