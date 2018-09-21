package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseCarSupplier;

import java.util.List;
import java.util.Map;

public interface LeaseCarSupplierMapper extends BaseDao<LeaseCarSupplier> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarSupplier> insertViewParames(Map<String, Object> paramsMap);

    List<LeaseCarSupplier> findByName(Map params);
}