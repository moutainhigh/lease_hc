

package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 贷后车辆管理-收车 新增 搜索合同 VO
 */
public class CarManagerDealFindContractVo implements Serializable {
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "合同编号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "车牌号", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "车架号", hidden = false)
    private String cardFrameNumber;
    @ApiModelProperty(value = "品牌名称", hidden = false)
    private String brandsName;
    @ApiModelProperty(value = "系列名称", hidden = false)
    private String seriesName;
    @ApiModelProperty(value = "颜色名称", hidden = false)
    private String colorName;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "型号名称", hidden = false)
    private String contractCompleteModelName;
    @ApiModelProperty(value = "总期数", hidden = false)
    private Integer stagingNumberName;
    @ApiModelProperty(value = "已收期数", hidden = false)
    private Integer payPeriod;
    @ApiModelProperty(value = "拖欠期数", hidden = false)
    private Integer noPayPeriod;
    @ApiModelProperty(value = "应扣款日", hidden = false)
    private Date repaymentDate;
    @ApiModelProperty(value = "车辆指导价", hidden = false)
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "剩余贷款本金", hidden = false)
    private BigDecimal residualPrincipal;
    @ApiModelProperty(value = "交强险到期日", hidden = false)
    private Date strongRiskExpireTime;
    @ApiModelProperty(value = "商业险#1到期日", hidden = false)
    private Date commercialInsuranceExpireTime1;
    @ApiModelProperty(value = "商业险#2到期日", hidden = false)
    private Date commercialInsuranceExpireTime12;
    @ApiModelProperty(value = "合同主键Id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "车辆主键Id", hidden = false)
    private Long carId;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCardFrameNumber() {
        return cardFrameNumber;
    }

    public void setCardFrameNumber(String cardFrameNumber) {
        this.cardFrameNumber = cardFrameNumber;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getContractCompleteModelName() {
        return contractCompleteModelName;
    }

    public void setContractCompleteModelName(String contractCompleteModelName) {
        this.contractCompleteModelName = contractCompleteModelName;
    }

    public Integer getStagingNumberName() {
        return stagingNumberName;
    }

    public void setStagingNumberName(Integer stagingNumberName) {
        this.stagingNumberName = stagingNumberName;
    }

    public Integer getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(Integer payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Integer getNoPayPeriod() {
        return noPayPeriod;
    }

    public void setNoPayPeriod(Integer noPayPeriod) {
        this.noPayPeriod = noPayPeriod;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getResidualPrincipal() {
        return residualPrincipal;
    }

    public void setResidualPrincipal(BigDecimal residualPrincipal) {
        this.residualPrincipal = residualPrincipal;
    }

    public Date getStrongRiskExpireTime() {
        return strongRiskExpireTime;
    }

    public void setStrongRiskExpireTime(Date strongRiskExpireTime) {
        this.strongRiskExpireTime = strongRiskExpireTime;
    }

    public Date getCommercialInsuranceExpireTime1() {
        return commercialInsuranceExpireTime1;
    }

    public void setCommercialInsuranceExpireTime1(Date commercialInsuranceExpireTime1) {
        this.commercialInsuranceExpireTime1 = commercialInsuranceExpireTime1;
    }

    public Date getCommercialInsuranceExpireTime12() {
        return commercialInsuranceExpireTime12;
    }

    public void setCommercialInsuranceExpireTime12(Date commercialInsuranceExpireTime12) {
        this.commercialInsuranceExpireTime12 = commercialInsuranceExpireTime12;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "CarManagerDealFindContractVo{" +
                "accountName='" + accountName + '\'' +
                ", accountPhone='" + accountPhone + '\'' +
                ", completeContractNumber='" + completeContractNumber + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", cardFrameNumber='" + cardFrameNumber + '\'' +
                ", brandsName='" + brandsName + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", colorName='" + colorName + '\'' +
                ", totalPrice=" + totalPrice +
                ", contractCompleteModelName='" + contractCompleteModelName + '\'' +
                ", stagingNumberName=" + stagingNumberName +
                ", payPeriod=" + payPeriod +
                ", noPayPeriod=" + noPayPeriod +
                ", repaymentDate=" + repaymentDate +
                ", marketPrice=" + marketPrice +
                ", residualPrincipal=" + residualPrincipal +
                ", strongRiskExpireTime=" + strongRiskExpireTime +
                ", commercialInsuranceExpireTime1=" + commercialInsuranceExpireTime1 +
                ", commercialInsuranceExpireTime12=" + commercialInsuranceExpireTime12 +
                ", contractId=" + contractId +
                ", carId=" + carId +
                '}';
    }
}
