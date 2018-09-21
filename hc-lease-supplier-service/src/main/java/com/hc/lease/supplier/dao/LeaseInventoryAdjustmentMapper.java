package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseInventoryAdjustment;

import java.util.List;
import java.util.Map;

public interface LeaseInventoryAdjustmentMapper  extends BaseDao< LeaseInventoryAdjustment> {
    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseInventoryAdjustment> insertViewParames(Map<String, Object> paramsMap);
}