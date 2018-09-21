package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 使用和被使用的数据Service
 *
 * @author Tong
 * @version 2017-06-20
 */

public interface LeaseUseUsedService extends BaseService<LeaseUseUsed> {

    /**
     * @param paramsMap
     * @return
     */
    int deleteByUseUsed(Map<String, Object> paramsMap);

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseUseUsed> selectByUsed(Map<String, Object> paramsMap);

    int deleteByUse(Long id, String typeLeaseScheme);
}
