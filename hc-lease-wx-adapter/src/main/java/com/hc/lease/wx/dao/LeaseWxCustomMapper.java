package com.hc.lease.wx.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.wx.model.LeaseWxCustom;

import java.util.Map;

public interface LeaseWxCustomMapper extends BaseDao<LeaseWxCustom> {

    int updateDealStatus(Map<String, Object> paramsMap);
}