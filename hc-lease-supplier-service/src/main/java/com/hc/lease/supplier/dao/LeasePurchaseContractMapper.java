package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeasePurchaseContract;

import java.util.List;
import java.util.Map;

public interface LeasePurchaseContractMapper extends BaseDao<LeasePurchaseContract> {
    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeasePurchaseContract> insertViewParames(Map<String, Object> paramsMap);

    List<LeasePurchaseContract> selectByLeaseCar(Map<String, Object> paramsMap);

    List<LeasePurchaseContract> findByCarSupplierId(List<Long> ids);

    List<LeasePurchaseContract> findByParams(Map<String, Object> paramsMap);

    List<LeasePurchaseContract> selectByCarBuyFinancingerId(List<Long> ids);
}