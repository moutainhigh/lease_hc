package com.hc.lease.supplier.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/8<br/>
 * 说明：汽车其他成本表
 */
@Data
public class LeaseCarOtherCost implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long leaseCarOtherCostId;

    @ApiModelProperty(value = "车辆信息主键id(public.lease_car)", hidden = false)
    private Long carId;

    @ApiModelProperty(value = "不含税GPS价格", hidden = false)
    private BigDecimal taxFreeGpsPrice;

    @ApiModelProperty(value = "GPS税额", hidden = false)
    private BigDecimal gpsTax;

    @ApiModelProperty(value = "含税运费价格", hidden = false)
    private BigDecimal taxFreightPrice;

    @ApiModelProperty(value = "不含税运费价格", hidden = false)
    private BigDecimal taxFreeFreightPrice;

    @ApiModelProperty(value = "运费税额", hidden = false)
    private BigDecimal freightTax;

    @ApiModelProperty(value = "采购手续费", hidden = false)
    private BigDecimal purchasingFee;

    @ApiModelProperty(value = "创建时间", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改时间", hidden = false)
    private Date updateTime;

    @Override
    public String toString() {
        return "LeaseCarOtherCost{" +
                "leaseCarOtherCostId=" + leaseCarOtherCostId +
                ", carId=" + carId +
                ", taxFreeGpsPrice=" + taxFreeGpsPrice +
                ", gpsTax=" + gpsTax +
                ", taxFreightPrice=" + taxFreightPrice +
                ", taxFreeFreightPrice=" + taxFreeFreightPrice +
                ", freightTax=" + freightTax +
                ", purchasingFee=" + purchasingFee +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
