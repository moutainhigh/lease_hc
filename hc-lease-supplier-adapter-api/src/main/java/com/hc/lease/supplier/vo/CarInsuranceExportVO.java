package com.hc.lease.supplier.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by LJ on 2018/4/17
 */
@Data
public class CarInsuranceExportVO implements Serializable {

    /**
     * 车辆保险主键ID
     */
    private Long insuranceId;

    /**
     * 保险保单号
     */
    private String insuranceNumber;

    /**
     * 保险公司名称
     */
    private String companyName;

    /**
     * 保险保费
     */
    private BigDecimal premium;

    /**
     * 保险生效日期
     */
    private Date effectiveTime;

    /**
     * 保险到期日期
     */
    private Date expireTime;


}
