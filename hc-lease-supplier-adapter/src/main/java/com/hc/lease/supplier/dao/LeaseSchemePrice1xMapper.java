package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemePrice1x;

public interface LeaseSchemePrice1xMapper extends BaseDao<LeaseSchemePrice1x>{
    int deleteByPrimaryKey(Long id);

    int insert(LeaseSchemePrice1x record);

    int insertSelective(LeaseSchemePrice1x record);

    LeaseSchemePrice1x selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseSchemePrice1x record);

    int updateByPrimaryKey(LeaseSchemePrice1x record);

    void deleteBySchemePriceId(Long id);
}