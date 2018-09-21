package com.hc.lease.postlending.service.api;

import com.hc.lease.postlending.model.LeaseAllinpayBatch;
import com.hc.lease.postlending.model.LeaseAllinpaySplitBatch;
import com.hc.lease.common.core.dao.BaseService;

import java.util.Map;

/**
* 通联支付超额拆分交易明细 批量支付批次统计Service
* @author Tong
* @version 2018-06-19
*/

public interface LeaseAllinpaySplitBatchService extends BaseService<LeaseAllinpaySplitBatch> {

    LeaseAllinpaySplitBatch selectByBatchNumber(Map<String, Object> paramsMap);

}
