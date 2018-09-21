package com.hc.lease.supplier.service.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.vo.CarInsuranceExportCountResult;
import com.hc.lease.supplier.vo.CarInsuranceImportResultExcel;
import com.hc.lease.supplier.vo.InsuranceCarIdQuery;
import com.hc.lease.supplier.vo.LeaseCarInsuranceExcel;

import java.util.List;

/**
 * 车辆保险信息Service
 *
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseCarInsuranceService extends BaseService<LeaseCarInsurance> {

    void updateByCarId(LeaseCarInsurance leaseCarInsurance);

    void deleteByCarId(Long id);

    /**
     * 修改车辆保险信息
     *
     * @param leaseCarInsurance 修改参数
     */
    void updateEntity(LeaseCarInsurance leaseCarInsurance) throws Exception;

    /**
     * 根据条件查询车辆保险信息
     *
     * @param leaseCarInsurance 查询参数
     */
    List<LeaseCarInsurance> selectEntity(LeaseCarInsurance leaseCarInsurance);

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
