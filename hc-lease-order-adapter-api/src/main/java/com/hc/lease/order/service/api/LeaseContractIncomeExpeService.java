package com.hc.lease.order.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractIncomeExpe;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 贷后车辆管理-收入和支出Service
* @author Tong
* @version 2018-08-03
*/

public interface LeaseContractIncomeExpeService extends BaseService<LeaseContractIncomeExpe> {

    int deleteByContractId(Map<String, Object> paramsMap) throws GMException;

    List<LeaseContractIncomeExpe> findByContractIdAndSource(Map<String, Object> paramsMap) throws GMException;

}
