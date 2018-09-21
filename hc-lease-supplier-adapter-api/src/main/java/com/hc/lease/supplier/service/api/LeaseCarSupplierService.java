package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.vo.LeaseCarSupplierPageVo;

import java.util.List;
import java.util.Map;

/**
* 车辆供应商Service
* @author Qiang
* @version 2017-05-05
*/

public interface LeaseCarSupplierService extends BaseService<LeaseCarSupplier> {

    List<LeaseCarSupplier> findByName(Map params);

    int disableByPrimaryKey(Map<String, Object> params);

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    void updateSort(LeaseCarSupplier leaseCarSupplier);

    List<LeaseCarSupplierPageVo> findAllNoPage(Map params);
}
