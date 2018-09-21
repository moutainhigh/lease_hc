package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseGpsSupplier;

import java.util.List;
import java.util.Map;

public interface LeaseGpsSupplierMapper extends BaseDao<LeaseGpsSupplier> {
    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseGpsSupplier> insertViewParames(Map<String, Object> paramsMap);

    List<LeaseGpsSupplier> findByName(Map params);
}