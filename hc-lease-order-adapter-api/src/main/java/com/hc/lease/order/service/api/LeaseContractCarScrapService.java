package com.hc.lease.order.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractCarScrap;
import com.hc.lease.common.core.dao.BaseService;

import java.util.Map;

/**
* 贷后车辆管理-报废Service
* @author Tong
* @version 2018-08-03
*/

public interface LeaseContractCarScrapService extends BaseService<LeaseContractCarScrap> {

    int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException;

}
