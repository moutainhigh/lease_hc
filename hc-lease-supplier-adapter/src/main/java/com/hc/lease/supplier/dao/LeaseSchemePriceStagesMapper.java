package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemePriceStages;

public interface LeaseSchemePriceStagesMapper extends BaseDao<LeaseSchemePriceStages> {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseSchemePriceStages record);

    int insertSelective(LeaseSchemePriceStages record);

    LeaseSchemePriceStages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseSchemePriceStages record);

    int updateByPrimaryKey(LeaseSchemePriceStages record);

    void deleteBySchemePriceId(Long id);
}