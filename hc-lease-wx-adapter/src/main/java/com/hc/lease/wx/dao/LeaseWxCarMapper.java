package com.hc.lease.wx.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.wx.model.LeaseWxCar;

import java.util.List;
import java.util.Map;

public interface LeaseWxCarMapper extends BaseDao<LeaseWxCar> {

    void updateSort(Map<String, Object> paramsMap);

    List<LeaseWxCar> findByName(Map params);

    List<LeaseWxCar> findByCarName(Map<String, Object> paramsMap);

}