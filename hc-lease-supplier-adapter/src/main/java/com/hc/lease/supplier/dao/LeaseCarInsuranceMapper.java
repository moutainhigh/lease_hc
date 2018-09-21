package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.vo.CarInsuranceExportEntity;
import com.hc.lease.supplier.vo.CarInsuranceExportEntityQuery;
import com.hc.lease.supplier.vo.CarInsuranceExportQuery;
import com.hc.lease.supplier.vo.InsuranceCarIdQuery;

import java.util.List;
import java.util.Map;

public interface LeaseCarInsuranceMapper extends BaseDao<LeaseCarInsurance> {

    void updateByCarId(LeaseCarInsurance leaseCarInsurance);

    void deleteByCarId(Long id);

    /**
     * 修改车辆保险信息
     *
     * @param leaseCarInsurance 修改参数
     */
    boolean updateEntity(LeaseCarInsurance leaseCarInsurance);

    /**
     * 根据条件查询车辆保险信息
     *
     * @param leaseCarInsurance 查询参数
     */
    List<LeaseCarInsurance> selectEntity(LeaseCarInsurance leaseCarInsurance);

    /**
     * 根据车辆ID与保险类型，查询该车辆保险份额数量
     */
    Integer selectPortionNum(LeaseCarInsurance leaseCarInsurance);


    List<Long> insuranceCarIdQuery(InsuranceCarIdQuery queryParameter);

    List<CarInsuranceExportEntity> insuranceExportEntityQuery(CarInsuranceExportEntityQuery queryParameter);
}