package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractIncomeExpe;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-收入和支出
 */
public interface LeaseContractIncomeExpeMapper extends BaseDao<LeaseContractIncomeExpe> {

    int deleteByContractId(Map<String, Object> paramsMap) throws GMException;

    List<LeaseContractIncomeExpe> findByContractIdAndSource(Map<String, Object> paramsMap) throws GMException;

}