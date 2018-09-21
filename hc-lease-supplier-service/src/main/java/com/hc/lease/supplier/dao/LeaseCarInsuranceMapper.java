package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseCarInsurance;

public interface LeaseCarInsuranceMapper extends BaseDao<LeaseCarInsurance>{

    void updateByCarId(LeaseCarInsurance leaseCarInsurance);

    void deleteByCarId(Long id);
}