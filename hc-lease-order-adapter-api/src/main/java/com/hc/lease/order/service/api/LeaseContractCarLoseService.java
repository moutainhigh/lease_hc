package com.hc.lease.order.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractCarLose;
import com.hc.lease.common.core.dao.BaseService;

import java.util.Map;

/**
* 贷后车辆管理-丢失Service
* @author Tong
* @version 2018-08-03
*/

public interface LeaseContractCarLoseService extends BaseService<LeaseContractCarLose> {

    int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException;

}
