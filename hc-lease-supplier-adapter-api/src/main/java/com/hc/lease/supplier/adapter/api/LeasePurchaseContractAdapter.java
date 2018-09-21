package com.hc.lease.supplier.adapter.api;

import com.hc.lease.supplier.model.LeasePurchaseContract;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 采购合同Adapter
 * @author Qiang
 * @version 2017-05-10
 */

public interface LeasePurchaseContractAdapter extends BaseAdapter<LeasePurchaseContract> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

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
