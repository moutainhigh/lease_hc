package com.hc.lease.supplier.adapter.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.vo.CarInsuranceExportCountResult;
import com.hc.lease.supplier.vo.CarInsuranceImportResultExcel;
import com.hc.lease.supplier.vo.InsuranceCarIdQuery;
import com.hc.lease.supplier.vo.LeaseCarInsuranceExcel;

import java.util.List;
import java.util.Map;

/**
 * 车辆保险信息Adapter
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseCarInsuranceAdapter extends BaseAdapter<LeaseCarInsurance> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;


    /**
     * 导出车辆保险信息查询
     */
    List<LeaseCarInsuranceExcel> exportAllQuery(InsuranceCarIdQuery queryParameter);

    /**
     * 导出车辆保险信息分页查询
     */
    PageInfo<LeaseCarInsuranceExcel> exportPageQuery(InsuranceCarIdQuery queryParameter);

    /**
     * 车辆保险合同Excel导入
     */
    CarInsuranceExportCountResult saveCarInsuranceExcelImport(List<LeaseCarInsuranceExcel> list) throws Exception;

}
