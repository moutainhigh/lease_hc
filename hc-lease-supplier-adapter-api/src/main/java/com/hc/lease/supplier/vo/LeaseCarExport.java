package com.hc.lease.supplier.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import com.hc.lease.supplier.model.LeaseCarDictAccessory;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.model.LeaseCarOtherCost;
import com.hc.lease.supplier.model.LeaseCostCheck;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseCarExport implements Serializable {

    @CostCheckExcelCol("采购合同编号")
    private String purchaseContractNnumber;
    @CostCheckExcelCol("融资方名称")
    private String carBuyFinancingerName;
    @CostCheckExcelCol("供应商名称")
    private String carSupplierName;
    @CostCheckExcelCol("供应商编号")
    private String supplierinternalNumber;
    @CostCheckExcelCol("公司合同方名称")
    private String companyHeaderName;
    @CostCheckExcelCol("品牌名称")
    private String carBrandsName;
    @CostCheckExcelCol("系列名称")
    private String carSeriesName;
    @CostCheckExcelCol("车型名称")
    private String carModelName;
    @CostCheckExcelCol("颜色名称")
    private String carColorName;
    @CostCheckExcelCol("发动机号")
    private String engineNumber;
    @CostCheckExcelCol("车架号")
    private String cardFrameNumber;
    @CostCheckExcelCol("所属分公司")
    private String branchCompanyName;
    @CostCheckExcelCol("出厂日期")
    private String manufactureTime;
    @CostCheckExcelCol("合格证号")
    private String certificateNumber;
    @CostCheckExcelCol("车牌号")
    private String plateNumber;
    @CostCheckExcelCol("车辆含税价")
    private String invoicedCarPrice;
    @CostCheckExcelCol("抵押类别")
    private String mortgageType;
    @CostCheckExcelCol("所有人")
    private String belongerCompanyHeaderName;
    @CostCheckExcelCol("入库日期")
    private String inStorehouseTime;
    @CostCheckExcelCol("GPS供应商")
    private String gpsSupplierName;
    @CostCheckExcelCol("市场指导价")
    private String marketPrice;


    public String getPurchaseContractNnumber() {
        return purchaseContractNnumber;
    }

    public void setPurchaseContractNnumber(String purchaseContractNnumber) {
        this.purchaseContractNnumber = purchaseContractNnumber;
    }

    public String getCarBuyFinancingerName() {
        return carBuyFinancingerName;
    }

    public void setCarBuyFinancingerName(String carBuyFinancingerName) {
        this.carBuyFinancingerName = carBuyFinancingerName;
    }

    public String getCarSupplierName() {
        return carSupplierName;
    }

    public void setCarSupplierName(String carSupplierName) {
        this.carSupplierName = carSupplierName;
    }

    public String getSupplierinternalNumber() {
        return supplierinternalNumber;
    }

    public void setSupplierinternalNumber(String supplierinternalNumber) {
        this.supplierinternalNumber = supplierinternalNumber;
    }

    public String getCompanyHeaderName() {
        return companyHeaderName;
    }

    public void setCompanyHeaderName(String companyHeaderName) {
        this.companyHeaderName = companyHeaderName;
    }

    public String getCarBrandsName() {
        return carBrandsName;
    }

    public void setCarBrandsName(String carBrandsName) {
        this.carBrandsName = carBrandsName;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarColorName() {
        return carColorName;
    }

    public void setCarColorName(String carColorName) {
        this.carColorName = carColorName;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getCardFrameNumber() {
        return cardFrameNumber;
    }

    public void setCardFrameNumber(String cardFrameNumber) {
        this.cardFrameNumber = cardFrameNumber;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public String getManufactureTime() {
        return manufactureTime;
    }

    public void setManufactureTime(String manufactureTime) {
        this.manufactureTime = DateUtil.interceptDate(manufactureTime);
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getInvoicedCarPrice() {
        return invoicedCarPrice;
    }

    public void setInvoicedCarPrice(String invoicedCarPrice) {
        this.invoicedCarPrice = invoicedCarPrice;
    }

    public String getMortgageType() {
        return mortgageType;
    }

    public void setMortgageType(String mortgageType) {
        this.mortgageType = mortgageType;
    }

    public String getBelongerCompanyHeaderName() {
        return belongerCompanyHeaderName;
    }

    public void setBelongerCompanyHeaderName(String belongerCompanyHeaderName) {
        this.belongerCompanyHeaderName = belongerCompanyHeaderName;
    }

    public String getInStorehouseTime() {
        return inStorehouseTime;
    }

    public void setInStorehouseTime(String inStorehouseTime) {
        this.inStorehouseTime = DateUtil.interceptDate(inStorehouseTime);
    }

    public String getGpsSupplierName() {
        return gpsSupplierName;
    }

    public void setGpsSupplierName(String gpsSupplierName) {
        this.gpsSupplierName = gpsSupplierName;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }
}