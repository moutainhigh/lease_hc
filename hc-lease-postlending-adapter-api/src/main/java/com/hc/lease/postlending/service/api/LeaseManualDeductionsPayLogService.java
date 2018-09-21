package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.postlending.model.LeaseManualDeductionsPayLog;

import java.util.Map;

/**
 * 手动扣款，每一次操作扣款都记录流水Service
 *
 * @author Tong
 * @version 2018-07-06
 */

public interface LeaseManualDeductionsPayLogService extends BaseService<LeaseManualDeductionsPayLog> {

    LeaseManualDeductionsPayLog findByReqSn(Map<String, Object> paramsMap);

}
