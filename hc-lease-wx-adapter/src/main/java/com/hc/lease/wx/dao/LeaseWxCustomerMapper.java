package com.hc.lease.wx.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.wx.model.LeaseWxCustomer;

import java.util.Map;

public interface LeaseWxCustomerMapper extends BaseDao<LeaseWxCustomer>{

    int updateDealStatus(Map<String, Object> paramsMap);
}