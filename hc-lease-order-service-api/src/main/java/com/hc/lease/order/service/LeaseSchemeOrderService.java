package com.hc.lease.order.service;

import com.hc.lease.order.model.LeaseSchemeOrder;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;

/**
* 融租方案申请订单Service
* @author Qiang
* @version 2017-05-23
*/

public interface LeaseSchemeOrderService extends BaseService<LeaseSchemeOrder> {

    List<LeaseSchemeOrder> findBySchemeId(List<Long> ids);
}
