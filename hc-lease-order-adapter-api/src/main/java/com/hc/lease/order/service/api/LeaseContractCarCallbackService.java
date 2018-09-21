package com.hc.lease.order.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractCarCallback;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.order.vo.FindByPrimaryKeyVo;

import java.util.Map;

/**
* 贷后车辆管理-收车Service
* @author Tong
* @version 2018-08-03
*/

public interface LeaseContractCarCallbackService extends BaseService<LeaseContractCarCallback> {

    FindByPrimaryKeyVo findByPrimaryKey(Long id);

    int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException;

}
