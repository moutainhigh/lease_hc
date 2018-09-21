package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseGpsSupplier;

import java.util.List;
import java.util.Map;

/**
* GPS供应商Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseGpsSupplierService extends BaseService<LeaseGpsSupplier> {

    List<LeaseGpsSupplier> findByName(Map params);

    int disableByPrimaryKey(Map<String, Object> params);

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map<String,Object> paramsMap) throws GMException;

    void updateSort(LeaseGpsSupplier leaseGpsSupplier);

    List<LeaseGpsSupplier> findAllNoPage(Map param);
}
