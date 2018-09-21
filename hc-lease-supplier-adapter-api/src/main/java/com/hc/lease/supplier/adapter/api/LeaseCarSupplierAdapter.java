package com.hc.lease.supplier.adapter.api;

import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.CarSupplierImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarSupplierTemplate;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.vo.LeaseCarSupplierPageVo;
import com.hc.lease.supplier.vo.LeaseCarSuppliers;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 车辆供应商表Adapter
 *
 * @author Qiang
 * @version 2017-05-05
 */

public interface LeaseCarSupplierAdapter extends BaseAdapter<LeaseCarSupplier> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params) throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    int updateSort(LeaseCarSuppliers leaseCarSuppliers);

    List<LeaseCarSupplierPageVo> findAllNoPage(Map params);

    CarSupplierImportExcelBackInfo importExcelCarSupplier(List<LeaseCarSupplierTemplate> carSupplierTemplates, UserSession userSession) throws GMException, ParseException;
}
