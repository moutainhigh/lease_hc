package com.hc.lease.supplier.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by LJ on 2018/4/17
 */
@Data
public class CarInsuranceExportEntity implements Serializable {

    /**
     * 保险主键ID
     */
    private Long id;

    /**
     * 保险所属车辆ID
     */
    private Long carId;

    /**
     * 保险保单号
     */
    private String insuranceWarrantyNum;

    /**
     * 所属保险公司ID
     */
    private Long insuranceCompanyId;

    /**
     * 保险公司名称
     */
    private String insuranceCompanyName;

    /**
     * 保费
     */
    private BigDecimal insuranceCost;

    /**
     * 保险生效日期
     */
    private Date insuranceEffectiveDate;

    /**
     * 保险到期日期
     */
    private Date insuranceExpireDate;
}
