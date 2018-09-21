package com.hc.lease.wx.service.api;

import com.hc.lease.wx.model.LeaseWxCustomer;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 预约客户Service
* @author Qiang
* @version 2017-11-29
*/

public interface LeaseWxCustomerService extends BaseService<LeaseWxCustomer> {

    int updateDealStatus(Long id, Integer deal);

    List<LeaseWxCustomer> findAllNoPage(Map<String, Object> paramsMap);
}
