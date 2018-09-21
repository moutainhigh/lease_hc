package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemeCarFinancinger;

import java.util.List;
import java.util.Map;

public interface LeaseSchemeCarFinancingerMapper  extends BaseDao<LeaseSchemeCarFinancinger>{
    int deleteByPrimaryKey(Long id);

    int insert(LeaseSchemeCarFinancinger record);

    int insertSelective(LeaseSchemeCarFinancinger record);

    LeaseSchemeCarFinancinger selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseSchemeCarFinancinger record);

    int updateByPrimaryKey(LeaseSchemeCarFinancinger record);

    List<LeaseSchemeCarFinancinger> findByCarId(Map<String, Object> map);

    int deleteByCarId(Long carId);

}