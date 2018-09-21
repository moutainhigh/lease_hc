package com.hc.lease.supplier.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by LJ on 2018/4/17
 */
@Data
public class InsuranceCarExportEntity implements Serializable {

    /**
     * 所属车辆主键ID
     */
    private Long carId;

    /**
     * 车辆品牌ID
     */
    private Long carBrandId;

    /**
     * 车辆品牌名称
     */
    private String carBrandName;

    /**
     * 车辆系列ID
     */
    private Long carSeriesId;

    /**
     * 车辆系列名称
     */
    private String carSeriesName;

    /**
     * 车辆车型Id
     */
    private String carModelId;

    /**
     * 车辆车型名称
     */
    private String carModelName;

    /**
     * 发动机号
     */
    private String carEngineNum;

    /**
     * 车架号
     */
    private String carFrameNum;

    /**
     * 车牌号
     */
    private String carPlateNumber;

}
