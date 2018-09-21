package com.hc.lease.supplier.adapter.api;

import com.hc.lease.common.core.excel.poi.vo.LeaseGpsSupplierExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseGpsSupplierTemplate;
import com.hc.lease.supplier.model.LeaseGpsSupplier;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.vo.LeaseGpsSuppliers;

import java.util.List;
import java.util.Map;

/**
 * GPS供应商表Adapter
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseGpsSupplierAdapter extends BaseAdapter<LeaseGpsSupplier> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map<String,Object> paramsMap) throws GMException;

    int updateSort(LeaseGpsSuppliers leaseGpsSuppliers);

    List<LeaseGpsSupplier> findAllNoPage(Map param);

    LeaseGpsSupplierExcelBackInfo importExcelGpsSupplier(List<LeaseGpsSupplierTemplate> leaseGpsSupplierTemplates) throws GMException;
}
