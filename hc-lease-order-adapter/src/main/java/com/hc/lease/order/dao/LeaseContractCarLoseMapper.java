package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractCarLose;

import java.util.Map;

public interface LeaseContractCarLoseMapper extends BaseDao<LeaseContractCarLose> {

    int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException;

}