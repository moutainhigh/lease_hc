package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.common.core.dao.BaseDao;

import java.util.List;

/**
 * 字典表
 */
public interface LeaseDictMapper extends BaseDao<LeaseDict> {

    List<LeaseDict> findByType(String type);

}