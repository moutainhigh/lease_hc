package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.postlending.model.LeaseAllinpayBatch;

import java.util.List;
import java.util.Map;

/**
* 通联批量代收批次统计Service
* @author Tong
* @version 2017-06-09
*/

public interface LeaseAllinpayBatchService extends BaseService<LeaseAllinpayBatch> {

    LeaseAllinpayBatch selectByBatchNumber(Map<String, Object> paramsMap);

    List<LeaseAllinpayBatch> findNoPage(Map<String, Object> paramsMap);
}
