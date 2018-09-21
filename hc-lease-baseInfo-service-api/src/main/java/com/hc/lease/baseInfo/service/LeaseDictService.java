package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;

/**
 * 字典表Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseDictService extends BaseService<LeaseDict> {

    List<LeaseDict> findByType(String type);

}
