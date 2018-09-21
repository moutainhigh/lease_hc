package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseSmsLog;
import com.hc.lease.common.core.dao.BaseDao;

public interface LeaseSmsLogMapper extends BaseDao<LeaseSmsLog> {
    int deleteByPrimaryKey(Long id);

    int insert(LeaseSmsLog record);

    int insertSelective(LeaseSmsLog record);

    LeaseSmsLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseSmsLog record);

    int updateByPrimaryKey(LeaseSmsLog record);
}