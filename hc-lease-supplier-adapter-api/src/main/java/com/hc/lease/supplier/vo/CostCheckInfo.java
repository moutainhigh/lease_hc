package com.hc.lease.supplier.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/21<br/>
 * 说明：核对登记状态
 */
@Data
public class CostCheckInfo  implements Serializable{
    //车架号
    private String cardFrameNumber;
    //车核对状态
    private String carCheckState;
    //保险和车船税核对状态
    private String insuranceCheckState;
    //购置税核对状态
    private String purchaseTaxCheckState;
    //其他成本核对状态
    private String otherCostState;
    /**
     * 车辆id
     */
    private Long carId;
    /**
     * 含税车价
     */
    private BigDecimal invoicedCarPrice;
    /**
     * 车发票号
     */
    private String invoiceNumber;
    /**
     * 购置税
     */
    private BigDecimal purchaseTax;
}
