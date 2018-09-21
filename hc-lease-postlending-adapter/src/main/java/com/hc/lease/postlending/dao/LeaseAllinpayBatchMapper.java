package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.postlending.model.LeaseAllinpayBatch;

import java.util.List;
import java.util.Map;

/**
 * 通联批量代收批次统计
 */
public interface LeaseAllinpayBatchMapper extends BaseDao<LeaseAllinpayBatch> {

    LeaseAllinpayBatch selectByBatchNumber(Map<String, Object> paramsMap);

}