package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建人：tong<br/>
 * 创建时间：2018/1/12<br/>
 * 说明：小程序门店数据EXCEL导入模板
 */
@Data
@CostCheckExcelCol("代理商数据导入")
public class WxStoresTemplate implements Serializable {

    @CostCheckExcelCol("一级区域")
    private String level;
    @CostCheckExcelCol("二级区域")
    private String secondary;
    @CostCheckExcelCol("代理商名称")
    private String name;
    @CostCheckExcelCol("地址")
    private String address;
    @CostCheckExcelCol("联系电话")
    private String phone;

    @CostCheckExcelCol("网点级别")
    private Integer storesLevel;
    @CostCheckExcelCol("合同签约")
    private String isContractAward;
    @CostCheckExcelCol("合作开始日")
    private Date cooperationStartTime;
    @CostCheckExcelCol("合作年限(字典表主键ID)")
    private String cooperationYearLimit;
    @CostCheckExcelCol("合作结束日")
    private Date cooperationEndTime;
    @CostCheckExcelCol("营业执照编号")
    private String businessLicenseNumber;
    @CostCheckExcelCol("负责人")
    private String chargePersonName;
    @CostCheckExcelCol("负责人身份证")
    private String chargePersonIdCard;
    @CostCheckExcelCol("营业执照地址")
    private String businessLicenseAdress;
    @CostCheckExcelCol("保证金额")
    private BigDecimal guaranteeAmount;
    @CostCheckExcelCol("可提车数量")
    private Integer carNumber;
    @CostCheckExcelCol("每单佣金")
    private BigDecimal commission;
    @ApiModelProperty(value = "编号", hidden = false)
    private Integer number;
    @ApiModelProperty(value = "业务员", hidden = false)
    private String salesName;

    @CostCheckExcelCol("导入结果")
    private String updateState;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsContractAward() {
        return isContractAward;
    }

    public void setIsContractAward(String isContractAward) {
        this.isContractAward = isContractAward;
    }

    public Date getCooperationStartTime() {
        return cooperationStartTime;
    }

    public void setCooperationStartTime(Date cooperationStartTime) {
        this.cooperationStartTime = cooperationStartTime;
    }

    public String getCooperationYearLimit() {
        return cooperationYearLimit;
    }

    public void setCooperationYearLimit(String cooperationYearLimit) {
        this.cooperationYearLimit = cooperationYearLimit;
    }

    public Date getCooperationEndTime() {
        return cooperationEndTime;
    }

    public void setCooperationEndTime(Date cooperationEndTime) {
        this.cooperationEndTime = cooperationEndTime;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getChargePersonName() {
        return chargePersonName;
    }

    public void setChargePersonName(String chargePersonName) {
        this.chargePersonName = chargePersonName;
    }

    public String getChargePersonIdCard() {
        return chargePersonIdCard;
    }

    public void setChargePersonIdCard(String chargePersonIdCard) {
        this.chargePersonIdCard = chargePersonIdCard;
    }

    public String getBusinessLicenseAdress() {
        return businessLicenseAdress;
    }

    public void setBusinessLicenseAdress(String businessLicenseAdress) {
        this.businessLicenseAdress = businessLicenseAdress;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }

    public Integer getStoresLevel() {
        return storesLevel;
    }

    public void setStoresLevel(Integer storesLevel) {
        this.storesLevel = storesLevel;
    }

    public BigDecimal getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }
}
