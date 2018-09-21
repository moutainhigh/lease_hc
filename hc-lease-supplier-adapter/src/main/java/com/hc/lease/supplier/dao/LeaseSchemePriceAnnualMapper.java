package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemePriceAnnual;

public interface LeaseSchemePriceAnnualMapper extends BaseDao<LeaseSchemePriceAnnual> {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseSchemePriceAnnual record);

    int insertSelective(LeaseSchemePriceAnnual record);

    LeaseSchemePriceAnnual selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseSchemePriceAnnual record);

    int updateByPrimaryKey(LeaseSchemePriceAnnual record);

    void deleteBySchemePriceId(Long id);
}