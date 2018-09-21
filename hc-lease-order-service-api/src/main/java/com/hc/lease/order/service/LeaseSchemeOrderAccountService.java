package com.hc.lease.order.service;

import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import com.hc.lease.common.core.dao.BaseService;

/**
* 融租方案申请订单-承租人Service
* @author Qiang
* @version 2017-05-23
*/

public interface LeaseSchemeOrderAccountService extends BaseService<LeaseSchemeOrderAccount> {


    void updateBySchemeOrderIdSelective(LeaseSchemeOrderAccount leaseSchemeOrderAccount);

    void deleteBySchemeOrderId(Long id);
}
