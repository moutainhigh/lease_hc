package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemePrice;

public interface LeaseSchemePriceMapper extends BaseDao<LeaseSchemePrice> {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseSchemePrice record);

    int insertSelective(LeaseSchemePrice record);

    LeaseSchemePrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseSchemePrice record);

    int updateByPrimaryKey(LeaseSchemePrice record);
}