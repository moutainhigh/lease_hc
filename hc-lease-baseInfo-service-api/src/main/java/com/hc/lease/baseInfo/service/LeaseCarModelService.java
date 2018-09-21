package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseCarBrands;
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
    public List<LeaseCarSeries> findBySeriesId(List<Long> ids) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseCarModel> findByName(Map params) throws GMException;

}
