package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseSchemeOrder;

import java.util.List;

public interface LeaseSchemeOrderMapper  extends BaseDao<LeaseSchemeOrder> {

    List<LeaseSchemeOrder> findBySchemeId(List<Long> ids);


}