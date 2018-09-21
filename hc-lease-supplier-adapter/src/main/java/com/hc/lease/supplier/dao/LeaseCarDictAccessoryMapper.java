package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseCarDictAccessory;

public interface LeaseCarDictAccessoryMapper extends BaseDao<LeaseCarDictAccessory> {


    void deleteByCarId(Long id);
}