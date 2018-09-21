package com.hc.lease.supplier.service;

import com.hc.lease.supplier.model.LeasePurchaseContract;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 采购合同Service
* @author Qiang
* @version 2017-05-10
*/

public interface LeasePurchaseContractService extends BaseService<LeasePurchaseContract> {

    List<LeasePurchaseContract> selectByLeaseCar(Map<String, Object> paramsMap);

    List<LeasePurchaseContract> findByCarSupplierId(List<Long> ids);

    List<LeasePurchaseContract> findByParams(Map<String, Object> paramsMap);

    List<LeasePurchaseContract> selectByCarBuyFinancingerId(List<Long> ids);
}
