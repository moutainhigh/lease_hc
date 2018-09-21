package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseSchemeOrderAccount;

import java.util.List;

public interface LeaseSchemeOrderAccountMapper extends BaseDao<LeaseSchemeOrderAccount> {

    void updateBySchemeOrderIdSelective(LeaseSchemeOrderAccount leaseSchemeOrderAccount);

    void deleteBySchemeOrderId(Long id);

    List<LeaseSchemeOrderAccount> selectByAccountId(long orderAccountId);

    List<LeaseSchemeOrderAccount> selectBySchemeOrderId(long schemeOrderId);

}