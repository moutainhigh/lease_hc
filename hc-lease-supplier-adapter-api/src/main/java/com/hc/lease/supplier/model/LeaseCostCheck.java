package com.hc.lease.supplier.model;

import com.hc.lease.supplier.enumeration.PublicStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/6<br/>
 * 说明：成本核对表
 */
@Data
public class LeaseCostCheck implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long leaseCostCheckId;

    @ApiModelProperty(value = "车辆信息主键id(public.lease_car)", hidden = false)
    private Long carId;

    @ApiModelProperty(value = "车信息核对状态（S：已核对，F：未核对）", hidden = false)
    private String carCheckState;

    @ApiModelProperty(value = "保险和车船税核对状态（S：已核对，F：未核对）", hidden = false)
    private String insuranceCheckState;

    @ApiModelProperty(value = "购置税核对状态（S：已核对，F：未核对）", hidden = false)
    private String purchaseTaxCheckState;

    @ApiModelProperty(value = "其他成本状态（S：已核对，F：未核对）", hidden = false)
    private String otherCostState;

    @ApiModelProperty(value = "操作人id（public.lease_user）", hidden = false)
    private Long operatorId;

    @ApiModelProperty(value = "创建时间", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改时间", hidden = false)
    private Date updateTime;

    @Override
    public String toString() {
        return "LeaseCostCheck{" +
                "leaseCostCheckId=" + leaseCostCheckId +
                ", carId=" + carId +
                ", carCheckState='" + carCheckState + '\'' +
                ", insuranceCheckState='" + insuranceCheckState + '\'' +
                ", purchaseTaxCheckState='" + purchaseTaxCheckState + '\'' +
                ", otherCostState='" + otherCostState + '\'' +
                ", operatorId=" + operatorId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    /**
     * 空值判断
     * @param leaseCostCheck 实体类
     */
    public LeaseCostCheck paramCheck(LeaseCostCheck leaseCostCheck){
        leaseCostCheck.setCarCheckState(StringUtils.isEmpty(leaseCostCheck.getCarCheckState()) ? PublicStatusEnum.F.getStringValue() : PublicStatusEnum.S.getStringValue());
        leaseCostCheck.setInsuranceCheckState(StringUtils.isEmpty(leaseCostCheck.getInsuranceCheckState()) ? PublicStatusEnum.F.getStringValue() : PublicStatusEnum.S.getStringValue());
        leaseCostCheck.setPurchaseTaxCheckState(StringUtils.isEmpty(leaseCostCheck.getPurchaseTaxCheckState()) ? PublicStatusEnum.F.getStringValue() : PublicStatusEnum.S.getStringValue());
        leaseCostCheck.setOtherCostState(StringUtils.isEmpty(leaseCostCheck.getOtherCostState()) ? PublicStatusEnum.F.getStringValue() : PublicStatusEnum.S.getStringValue());
        return leaseCostCheck;
    }

}
