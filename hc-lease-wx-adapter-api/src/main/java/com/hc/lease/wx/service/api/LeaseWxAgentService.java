package com.hc.lease.wx.service.api;

import com.hc.lease.wx.model.LeaseWxAgent;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 代理Service
* @author Qiang
* @version 2017-11-29
*/

public interface LeaseWxAgentService extends BaseService<LeaseWxAgent> {

    int updateDealStatus(Long id, Integer deal);

    List<LeaseWxAgent> findAllNoPage(Map<String, Object> paramsMap);
}
