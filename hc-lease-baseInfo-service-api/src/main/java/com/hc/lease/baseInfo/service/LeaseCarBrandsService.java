package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 车辆品牌Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseCarBrandsService extends BaseService<LeaseCarBrands> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarBrands> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseCarBrands> findByName(Map params) throws GMException;

}
