package com.hc.lease.wx.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.wx.model.LeaseWxAgent;

import java.util.Map;

public interface LeaseWxAgentMapper  extends BaseDao<LeaseWxAgent>{

    int updateDealStatus(Map<String, Object> paramsMap);
}