package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.postlending.model.LeaseManualDeductionsPayLog;

import java.util.Map;

public interface LeaseManualDeductionsPayLogMapper extends BaseDao<LeaseManualDeductionsPayLog> {

    LeaseManualDeductionsPayLog findByReqSn(Map<String, Object> paramsMap);

}