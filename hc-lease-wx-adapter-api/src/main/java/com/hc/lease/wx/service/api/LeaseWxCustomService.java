package com.hc.lease.wx.service.api;

import com.hc.lease.wx.model.LeaseWxCustom;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 小程序短信参数配置Service
* @author Qiang
* @version 2018-03-23
*/

public interface LeaseWxCustomService extends BaseService<LeaseWxCustom> {

    int updateDealStatus(Long id, Integer deal);

    List<LeaseWxCustom> findAllNoPage(Map<String, Object> paramsMap);
}
