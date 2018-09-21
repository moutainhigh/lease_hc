package com.hc.lease.supplier.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 车辆保险信息Excel导入导出模板
 * Created by LJ on 2018/4/13
 */
@Data
@ApiModel
public class LeaseCarInsuranceExcel implements Serializable {

    /**
     * 所属车辆主键ID
     */
    @ExcelAttribute(name = "车辆主键ID", isExport = false)
    @ApiModelProperty(value = "车辆主键ID")
    private Long carId;

    /**
     * 车辆品牌名称
     */
    @ExcelAttribute(name = "品牌")
    @ApiModelProperty(value = "品牌名称")
    private String carBrandName;

    /**
     * 车辆系列名称
     */
    @ExcelAttribute(name = "系列")
    @ApiModelProperty(value = "系列名称")
    private String carSeriesName;

    /**
     * 车型名称
     */
    @ExcelAttribute(name = "车型")
    @ApiModelProperty(value = "车型名称")
    private String carModelName;

    /**
     * 发动机号
     */
    @ExcelAttribute(name = "发动机号")
    @ApiModelProperty(value = "发动机号")
    private String carEngineNum;

    /**
     * 车架号
     */
    @ExcelAttribute(name = "车架号(必填)")
    @ApiModelProperty(value = "车架号")
    private String carFrameNum;

    /**
     * 车牌号
     */
    @ExcelAttribute(name = "车牌号")
    @ApiModelProperty(value = "车牌号")
    private String carPlateNumber;

    /**
     * 交强险到期日期
     */
    @ExcelAttribute(name = "交强险到期日期")
    @ApiModelProperty(value = "交强险到期日期")
    private Date jqInsuranceExpireDate;

    /**
     * 商业险#1到期日期
     */
    @ExcelAttribute(name = "商业险#1到期日期")
    @ApiModelProperty(value = "商业险#1到期日期")
    private Date commercialInsuranceExpireDate;

    /**
     * 商业险#2到期日期
     */
    @ExcelAttribute(name = "商业险#2到期日期")
    @ApiModelProperty(value = "商业险#2到期日期")
    private Date secondCommercialInsuranceExpireDate;

    /**
     * 交强险保险ID
     */
    @ExcelAttribute(name = "交强险保险ID", isExport = false)
    @ApiModelProperty(value = "交强险保险ID")
    private Long jqInsuranceId;

    /**
     * 交强险保单号
     */
    @ExcelAttribute(name = "交强险保单号")
    @ApiModelProperty(value = "交强险保单号")
    private String jqInsuranceWarrantyNum;

    /**
     * 交强险保险公司ID
     */
    @ExcelAttribute(name = "交强险保险公司ID", isExport = false)
    @ApiModelProperty(value = "交强险保险公司ID")
    private Long jqInsuranceCompanyId;

    /**
     * 交强险保险公司名称
     */
    @ExcelAttribute(name = "交强险保险公司(必填)", spinnerParamName = "insuranceCompanyList")
    @ApiModelProperty(value = "交强险保险公司")
    private String jqInsuranceCompanyName;

    /**
     * 交强险保费
     */
    @ExcelAttribute(name = "交强险保费")
    @ApiModelProperty(value = "交强险保费")
    private BigDecimal jqInsuranceCost;

    /**
     * 交强险生效日期
     */
    @ExcelAttribute(name = "交强险生效日期(必填)")
    @ApiModelProperty(value = "交强险生效日期")
    private Date jqInsuranceEffectiveDate;

    /**
     * 商业险#1保险ID
     */
    @ExcelAttribute(name = "商业险#1保险ID", isExport = false)
    @ApiModelProperty(value = "商业险#1保险ID")
    private Long commercialInsuranceId;

    /**
     * 商业险#1保单号
     */
    @ExcelAttribute(name = "商业险#1保单号")
    @ApiModelProperty(value = "商业险#1保单号")
    private String commercialInsuranceWarrantyNum;

    /**
     * 商业险#1保险公司ID
     */
    @ExcelAttribute(name = "商业险#1保险公司ID", isExport = false)
    @ApiModelProperty(value = "商业险#1保险公司ID")
    private Long commercialInsuranceCompanyId;

    /**
     * 商业险#1保险公司(必填)
     */
    @ExcelAttribute(name = "商业险#1保险公司(必填)", spinnerParamName = "insuranceCompanyList")
    @ApiModelProperty(value = "商业险#1保险公司")
    private String commercialInsuranceCompanyName;

    /**
     * 商业险#1保费
     */
    @ExcelAttribute(name = "商业险#1保费")
    @ApiModelProperty(value = "商业险#1保费")
    private BigDecimal commercialInsuranceCost;

    /**
     * 商业险#1生效日期(必填)
     */
    @ExcelAttribute(name = "商业险#1生效日期(必填)")
    @ApiModelProperty(value = "商业险#1生效日期")
    private Date commercialInsuranceEffectiveDate;

    /**
     * 商业险#2保险ID
     */
    @ExcelAttribute(name = "商业险#2保险ID", isExport = false)
    @ApiModelProperty(value = "商业险#2保险ID")
    private Long secondCommercialInsuranceId;

    /**
     * 商业险#2保单号
     */
    @ExcelAttribute(name = "商业险#2保单号")
    @ApiModelProperty(value = "商业险#2保单号")
    private String secondCommercialInsuranceWarrantyNum;

    /**
     * 商业险#2保险公司ID
     */
    @ExcelAttribute(name = "商业险#2保险公司ID", isExport = false)
    @ApiModelProperty(value = "商业险#2保险公司ID")
    private Long secondCommercialInsuranceCompanyId;

    /**
     * 商业险#2保险公司(必填)
     */
    @ExcelAttribute(name = "商业险#2保险公司", spinnerParamName = "insuranceCompanyList")
    @ApiModelProperty(value = "商业险#2保险公司")
    private String secondCommercialInsuranceCompanyName;

    /**
     * 商业险#2保费
     */
    @ExcelAttribute(name = "商业险#2保费")
    @ApiModelProperty(value = "商业险#2保费")
    private BigDecimal secondCommercialInsuranceCost;

    /**
     * 商业险#2生效日期(必填)
     */
    @ExcelAttribute(name = "商业险#2生效日期")
    @ApiModelProperty(value = "商业险#2生效日期")
    private Date secondCommercialInsuranceEffectiveDate;


    public void carInfoSet(Long carId, String carBrandName, String carSeriesName, String carModelName, String carEngineNum, String carFrameNum, String carPlateNumber) {
        this.carId = carId;
        this.carBrandName = carBrandName;
        this.carSeriesName = carSeriesName;
        this.carModelName = carModelName;
        this.carEngineNum = carEngineNum;
        this.carFrameNum = carFrameNum;
        this.carPlateNumber = carPlateNumber;
    }

    public void jqInsuranceInfoSet(Long jqInsuranceId, String jqInsuranceWarrantyNum, Long jqInsuranceCompanyId, String jqInsuranceCompanyName, BigDecimal jqInsuranceCost, Date jqInsuranceEffectiveDate, Date jqInsuranceExpireDate) {
        this.jqInsuranceId = jqInsuranceId;
        this.jqInsuranceWarrantyNum = jqInsuranceWarrantyNum;
        this.jqInsuranceCompanyId = jqInsuranceCompanyId;
        this.jqInsuranceCompanyName = jqInsuranceCompanyName;
        this.jqInsuranceCost = jqInsuranceCost;
        this.jqInsuranceEffectiveDate = jqInsuranceEffectiveDate;
        this.jqInsuranceExpireDate = jqInsuranceExpireDate;
    }

    public void commercialInsuranceInfoSet(Long commercialInsuranceId, String commercialInsuranceWarrantyNum, Long commercialInsuranceCompanyId, String commercialInsuranceCompanyName, BigDecimal commercialInsuranceCost, Date commercialInsuranceEffectiveDate, Date commercialInsuranceExpireDate) {
        this.commercialInsuranceId = commercialInsuranceId;
        this.commercialInsuranceWarrantyNum = commercialInsuranceWarrantyNum;
        this.commercialInsuranceCompanyId = commercialInsuranceCompanyId;
        this.commercialInsuranceCompanyName = commercialInsuranceCompanyName;
        this.commercialInsuranceCost = commercialInsuranceCost;
        this.commercialInsuranceEffectiveDate = commercialInsuranceEffectiveDate;
        this.commercialInsuranceExpireDate = commercialInsuranceExpireDate;
    }

    public void secondCommercialInsuranceInfoSet(Long secondCommercialInsuranceId, String secondCommercialInsuranceWarrantyNum, Long secondCommercialInsuranceCompanyId, String secondCommercialInsuranceCompanyName, BigDecimal secondCommercialInsuranceCost, Date secondCommercialInsuranceEffectiveDate, Date secondCommercialInsuranceExpireDate) {
        this.secondCommercialInsuranceId = secondCommercialInsuranceId;
        this.secondCommercialInsuranceWarrantyNum = secondCommercialInsuranceWarrantyNum;
        this.secondCommercialInsuranceCompanyId = secondCommercialInsuranceCompanyId;
        this.secondCommercialInsuranceCompanyName = secondCommercialInsuranceCompanyName;
        this.secondCommercialInsuranceCost = secondCommercialInsuranceCost;
        this.secondCommercialInsuranceEffectiveDate = secondCommercialInsuranceEffectiveDate;
        this.secondCommercialInsuranceExpireDate = secondCommercialInsuranceExpireDate;
    }


}
