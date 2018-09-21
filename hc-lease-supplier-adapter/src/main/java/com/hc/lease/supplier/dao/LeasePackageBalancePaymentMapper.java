package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeasePackageBalancePayment;

import java.util.List;

public interface LeasePackageBalancePaymentMapper extends BaseDao<LeasePackageBalancePayment> {
    int deleteByPrimaryKey(Long id);

    int insert(LeasePackageBalancePayment record);

    int insertSelective(LeasePackageBalancePayment record);

    LeasePackageBalancePayment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeasePackageBalancePayment record);

    int updateByPrimaryKey(LeasePackageBalancePayment record);

    void deleteByPackageId(Long packageId);

    LeasePackageBalancePayment selectBySchemeId(Long schemeId);

    List<LeasePackageBalancePayment> findBySchemeId(Long schemeId);

}