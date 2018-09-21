package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
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

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    /**
     * 根据采购合同编号查询
     *
     * @param paramsMap
     * @return
     */
    List<LeasePurchaseContract> selectByContractNumber(Map<String, Object> paramsMap);

}