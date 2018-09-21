package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 车辆系列Service
 *
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseCarSeriesService extends BaseService<LeaseCarSeries> {

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
