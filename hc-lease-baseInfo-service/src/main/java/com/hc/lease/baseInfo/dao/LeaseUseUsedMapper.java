package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.common.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 使用和被使用的数据
 */
public interface LeaseUseUsedMapper extends BaseDao<LeaseUseUsed> {

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

}