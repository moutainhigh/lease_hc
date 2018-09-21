package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.postlending.model.LeaseAllinpayBatch;
import com.hc.lease.postlending.model.LeaseAllinpaySplitBatch;

import java.util.Map;

/**
 * 通联支付超额拆分交易明细 批量支付批次统计
 */
public interface LeaseAllinpaySplitBatchMapper extends BaseDao<LeaseAllinpaySplitBatch> {

    LeaseAllinpaySplitBatch selectByBatchNumber(Map<String, Object> paramsMap);

}