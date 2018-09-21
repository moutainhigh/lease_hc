package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
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

    int disableByPrimaryKey(Map<String, Object> params);

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map<String, Object> paramsMap) throws GMException;

    void updateSort(Map<String, Object> paramsMap);
}