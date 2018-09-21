package com.hc.lease.wx.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.wx.model.LeaseWxHomeImg;

import java.util.Map;

public interface LeaseWxHomeImgMapper extends BaseDao<LeaseWxHomeImg> {

    void updateSort(Map<String, Object> paramsMap);
}