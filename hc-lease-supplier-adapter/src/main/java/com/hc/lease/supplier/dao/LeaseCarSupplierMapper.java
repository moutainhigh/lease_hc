package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.vo.LeaseCarSupplierPageVo;

import java.util.List;
import java.util.Map;

public interface LeaseCarSupplierMapper extends BaseDao<LeaseCarSupplier> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarSupplier> insertViewParames(Map<String, Object> paramsMap);

    List<LeaseCarSupplier> findByName(Map params);

    int disableByPrimaryKey(Map<String, Object> params);

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    void updateSort(Map<String, Object> paramsMap);

    List<LeaseCarSupplierPageVo> findAllNoPage(Map params);
}