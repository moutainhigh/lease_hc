package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseSchemePriceRent;

public interface LeaseSchemePriceRentMapper extends BaseDao<LeaseSchemePriceRent> {

    void deleteBySchemePriceId(Long id);
}