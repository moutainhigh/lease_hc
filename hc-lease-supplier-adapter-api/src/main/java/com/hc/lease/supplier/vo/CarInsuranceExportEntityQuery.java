package com.hc.lease.supplier.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by LJ on 2018/4/17
 */
@Data
public class CarInsuranceExportEntityQuery implements Serializable {

    /**
     * 车辆ID
     */
    private Long catId;

    /**
     * 保险类型
     */
    private Integer insuranceType;

    /**
     * 保险年份
     */
    private Integer insuranceYear;

    /**
     * 保险份额
     */
    private Integer portionNum;
}
