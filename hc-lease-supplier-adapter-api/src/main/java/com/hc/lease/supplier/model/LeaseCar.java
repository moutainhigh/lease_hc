package com.hc.lease.supplier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseCar implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "采购合同编号", hidden = false)
    private String contractNumber;
    @ApiModelProperty(value = "采购合同主键Id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "分公司主键Id", hidden = false)
    private Long branchCompanyId;
    @ApiModelProperty(value = "融资方主键id", hidden = false)
    private Long carBuyFinancingerId;
    @ApiModelProperty(value = "品牌主键Id", hidden = false)
    private Long brandsId;
    @ApiModelProperty(value = "系列主键Id", hidden = false)
    private Long seriesId;
    @ApiModelProperty(value = "车型主键Id", hidden = false)
    private Long modelId;
    @ApiModelProperty(value = "颜色主键Id", hidden = false)
    private Long colorId;
    @ApiModelProperty(value = "车架号", hidden = false)
    private String cardFrameNumber;
    @ApiModelProperty(value = "发动机号", hidden = false)
    private String engineNumber;
    @ApiModelProperty(value = "出厂日期", hidden = false)
    private Date manufactureTime;
    @ApiModelProperty(value = "合格证号", hidden = false)
    private String certificateNumber;
    @ApiModelProperty(value = "发票号", hidden = false)
    private String invoiceNumber;
    @ApiModelProperty(value = "随车物料主键Id", hidden = false)
    private Long accessoryId;
    @ApiModelProperty(value = "抵押类型主键id", hidden = false)
    private Long mortgageTypeId;

    @ApiModelProperty(value = "购车资金类型主键id", hidden = false)
    private Long buyCardCapitalTypeId;

    @ApiModelProperty(value = "所有人:0公司:;1:承租人", hidden = false)
    private Integer belongerTpye;
    @ApiModelProperty(value = "所有人为公司的主键id", hidden = false)
    private Long belongerCompanyHeaderId;
    @ApiModelProperty(value = "保险受益人:0公司:;1:融资方", hidden = false)
    private Integer insuranceBeneficiaryType;
    @ApiModelProperty(value = "保险受益人为公司的主键id", hidden = false)
    private Long beneficiaryCompanyHeaderId;
    @ApiModelProperty(value = "保险受益人为融资方主键id", hidden = false)
    private Long beneficiaFinancingerId;
    @ApiModelProperty(value = "车牌号", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "车辆登记证号", hidden = false)
    private String registrationNumber;
    @ApiModelProperty(value = "车辆登记证", hidden = false)
    private String registrationNumberImg;
    @ApiModelProperty(value = "车辆登记证List", hidden = false)
    private List<String> registrationNumberImgs;
    @ApiModelProperty(value = "GPS供应商主键id", hidden = false)
    private Long gpsSupplierId;
    @ApiModelProperty(value = "不含税车价", hidden = false)
    private BigDecimal price;
    @ApiModelProperty(value = "购置税率", hidden = false)
    private BigDecimal purchaseTaxRate;
    @ApiModelProperty(value = "购置税", hidden = false)
    private BigDecimal purchaseTax;
    @ApiModelProperty(value = "开票税", hidden = false)
    private BigDecimal invoicingTax;
    @ApiModelProperty(value = "车辆含税价/采购合同价", hidden = false)
    private BigDecimal invoicedCarPrice;
    @ApiModelProperty(value = "上牌费用", hidden = false)
    private BigDecimal onPlateCost;
    @ApiModelProperty(value = "GPS费用", hidden = false)
    private BigDecimal gpsCost;
    @ApiModelProperty(value = "抵押费用", hidden = false)
    private BigDecimal mortgageCost;
    @ApiModelProperty(value = "车船税", hidden = false)
    private BigDecimal vehicleVesselTax;
    @ApiModelProperty(value = "其他费用", hidden = false)
    private BigDecimal otherCost;
    @ApiModelProperty(value = "仓库主键id", hidden = false)
    private Long storehouseId;
    @ApiModelProperty(value = "仓库类型（0 公司 1经销商 2 二网）", hidden = false)
    private Integer storehouseType;
    @ApiModelProperty(value = "合同处置方案状态 对应 lease_car_status 表的Source和Status的组合", hidden = false)
    private String dealStatus;
    @ApiModelProperty(value = "车况 1新车 2次新车、二手车", hidden = false)
    private Integer carCondition;
    @ApiModelProperty(value = "经销商主键Id", hidden = false)
    private Long dealerId;
    @ApiModelProperty(value = "仓库状态0:未入仓;1:已入仓", hidden = false)
    private Integer storehouseStatus;
    @ApiModelProperty(value = "租赁状态0:未开始;1:未到期未过户;2:已过户;3:已过户抵押;4:已回收;5:到期不变更（售后回租）", hidden = false)
    private Integer leaseStatus;
    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Boolean isEnable;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "是否已买保险", hidden = false)
    private Boolean insuranceStatus;
    @ApiModelProperty(value = "是否已装GPS/", hidden = false)
    private Boolean gpsStatus;
    @ApiModelProperty(value = "是否已抵押", hidden = false)
    private Boolean mortgageStatus;
    @ApiModelProperty(value = "上牌状态:是否已上牌/有录入车牌号则视为已上牌/ 0 已上牌 1已预约未上牌 2未预约", hidden = false)
    private Integer plateStatus;
    @ApiModelProperty(value = "入库日期", hidden = false)
    private Date inStorehouseTime;
    @ApiModelProperty(value = "销售渠道/来自融租合同 0: 直销; 1:经销商", hidden = false)
    private Integer saleChannelType;
    @ApiModelProperty(value = "销售渠道 为:经销商/经销商主键id", hidden = false)
    private Long saleChannelId;
    @ApiModelProperty(value = "销售日期/来自融租合同", hidden = false)
    private Date saleTime;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "汽车保险信息", hidden = false)
    private List<LeaseCarInsurance> laseCarinsurances;

    private String laseCarinsurancesJson;
    @ApiModelProperty(value = "汽车随车物料信息", hidden = false)
    private List<LeaseCarDictAccessory> leaseCarDictAccessories;

    private String leaseCarDictAccessoriesJson;

    //显示用
    private String carBuyFinancingerName;
    private String brandsName;
    private String seriesName;
    private String businessModelName;
    private String completeModelName;
    private String colorName;
    private String mortgageTypeName;
    private String buyCardCapitalTypeName;
    private String belongerCompanyHeaderName;
    private String beneficiaryCompanyHeaderName;
    private String beneficiaFinancingerName;
    private String gpsSupplierName;
    private String storehouseName;
    private String dealerName;
    private String branchCompanyName;
    private String carSupplierName;
    @ApiModelProperty(value = "市场指导价", hidden = false)
    private BigDecimal marketPrice;


    /**
     * 汽车其他成本表
     */
    private LeaseCarOtherCost leaseCarOtherCost;
    /**
     * 成本核对表
     */
    private LeaseCostCheck leaseCostCheck;

    public LeaseCar() {
    }

    public LeaseCar(Long id, String contractNumber, Long contractId, Long branchCompanyId, Long carBuyFinancingerId, Long brandsId, Long seriesId, Long modelId, Long colorId, String cardFrameNumber, String engineNumber, Date manufactureTime, String certificateNumber, String invoiceNumber, Long accessoryId, Long mortgageTypeId, Long buyCardCapitalTypeId, Integer belongerTpye, Long belongerCompanyHeaderId, Integer insuranceBeneficiaryType, Long beneficiaryCompanyHeaderId, Long beneficiaFinancingerId, String plateNumber, String registrationNumber, String registrationNumberImg, List<String> registrationNumberImgs, Long gpsSupplierId, BigDecimal price, BigDecimal purchaseTaxRate, BigDecimal purchaseTax, BigDecimal invoicingTax, BigDecimal invoicedCarPrice, BigDecimal onPlateCost, BigDecimal gpsCost, BigDecimal mortgageCost, BigDecimal vehicleVesselTax, BigDecimal otherCost, Long storehouseId, Integer storehouseType, String dealStatus, Integer carCondition, Long dealerId, Integer storehouseStatus, Integer leaseStatus, Boolean isEnable, Date createTime, Date updateTime, Long createBy, Long updateBy, Integer sort, Boolean insuranceStatus, Boolean gpsStatus, Boolean mortgageStatus, Integer plateStatus, Date inStorehouseTime, Integer saleChannelType, Long saleChannelId, Date saleTime, String remarks, List<LeaseCarInsurance> laseCarinsurances, String laseCarinsurancesJson, List<LeaseCarDictAccessory> leaseCarDictAccessories, String leaseCarDictAccessoriesJson, String carBuyFinancingerName, String brandsName, String seriesName, String businessModelName, String colorName, String mortgageTypeName, String buyCardCapitalTypeName, String belongerCompanyHeaderName, String beneficiaryCompanyHeaderName, String beneficiaFinancingerName, String gpsSupplierName, String storehouseName, String dealerName, String branchCompanyName, String carSupplierName, LeaseCarOtherCost leaseCarOtherCost, LeaseCostCheck leaseCostCheck, List<Long> ids) {
        this.id = id;
        this.contractNumber = contractNumber;
        this.contractId = contractId;
        this.branchCompanyId = branchCompanyId;
        this.carBuyFinancingerId = carBuyFinancingerId;
        this.brandsId = brandsId;
        this.seriesId = seriesId;
        this.modelId = modelId;
        this.colorId = colorId;
        this.cardFrameNumber = cardFrameNumber;
        this.engineNumber = engineNumber;
        this.manufactureTime = manufactureTime;
        this.certificateNumber = certificateNumber;
        this.invoiceNumber = invoiceNumber;
        this.accessoryId = accessoryId;
        this.mortgageTypeId = mortgageTypeId;
        this.buyCardCapitalTypeId = buyCardCapitalTypeId;
        this.belongerTpye = belongerTpye;
        this.belongerCompanyHeaderId = belongerCompanyHeaderId;
        this.insuranceBeneficiaryType = insuranceBeneficiaryType;
        this.beneficiaryCompanyHeaderId = beneficiaryCompanyHeaderId;
        this.beneficiaFinancingerId = beneficiaFinancingerId;
        this.plateNumber = plateNumber;
        this.registrationNumber = registrationNumber;
        this.registrationNumberImg = registrationNumberImg;
        this.registrationNumberImgs = registrationNumberImgs;
        this.gpsSupplierId = gpsSupplierId;
        this.price = price;
        this.purchaseTaxRate = purchaseTaxRate;
        this.purchaseTax = purchaseTax;
        this.invoicingTax = invoicingTax;
        this.invoicedCarPrice = invoicedCarPrice;
        this.onPlateCost = onPlateCost;
        this.gpsCost = gpsCost;
        this.mortgageCost = mortgageCost;
        this.vehicleVesselTax = vehicleVesselTax;
        this.otherCost = otherCost;
        this.storehouseId = storehouseId;
        this.storehouseType = storehouseType;
        this.dealStatus = dealStatus;
        this.carCondition = carCondition;
        this.dealerId = dealerId;
        this.storehouseStatus = storehouseStatus;
        this.leaseStatus = leaseStatus;
        this.isEnable = isEnable;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.sort = sort;
        this.insuranceStatus = insuranceStatus;
        this.gpsStatus = gpsStatus;
        this.mortgageStatus = mortgageStatus;
        this.plateStatus = plateStatus;
        this.inStorehouseTime = inStorehouseTime;
        this.saleChannelType = saleChannelType;
        this.saleChannelId = saleChannelId;
        this.saleTime = saleTime;
        this.remarks = remarks;
        this.laseCarinsurances = laseCarinsurances;
        this.laseCarinsurancesJson = laseCarinsurancesJson;
        this.leaseCarDictAccessories = leaseCarDictAccessories;
        this.leaseCarDictAccessoriesJson = leaseCarDictAccessoriesJson;
        this.carBuyFinancingerName = carBuyFinancingerName;
        this.brandsName = brandsName;
        this.seriesName = seriesName;
        this.businessModelName = businessModelName;
        this.colorName = colorName;
        this.mortgageTypeName = mortgageTypeName;
        this.buyCardCapitalTypeName = buyCardCapitalTypeName;
        this.belongerCompanyHeaderName = belongerCompanyHeaderName;
        this.beneficiaryCompanyHeaderName = beneficiaryCompanyHeaderName;
        this.beneficiaFinancingerName = beneficiaFinancingerName;
        this.gpsSupplierName = gpsSupplierName;
        this.storehouseName = storehouseName;
        this.dealerName = dealerName;
        this.branchCompanyName = branchCompanyName;
        this.carSupplierName = carSupplierName;
        this.leaseCarOtherCost = leaseCarOtherCost;
        this.leaseCostCheck = leaseCostCheck;
        this.ids = ids;
    }

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<LeaseCarInsurance> getLaseCarInsurances() {
        return laseCarinsurances;
    }

    public void setLaseCarInsurances(List<LeaseCarInsurance> laseCarinsurances) {
        this.laseCarinsurances = laseCarinsurances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public Long getCarBuyFinancingerId() {
        return carBuyFinancingerId;
    }

    public void setCarBuyFinancingerId(Long carBuyFinancingerId) {
        this.carBuyFinancingerId = carBuyFinancingerId;
    }

    public Long getBrandsId() {
        return brandsId;
    }

    public void setBrandsId(Long brandsId) {
        this.brandsId = brandsId;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getCardFrameNumber() {
        return cardFrameNumber;
    }

    public void setCardFrameNumber(String cardFrameNumber) {
        this.cardFrameNumber = cardFrameNumber == null ? null : cardFrameNumber.trim();
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber == null ? null : engineNumber.trim();
    }

    public Date getManufactureTime() {
        return manufactureTime;
    }

    public void setManufactureTime(Date manufactureTime) {
        this.manufactureTime = manufactureTime;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public Long getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Long accessoryId) {
        this.accessoryId = accessoryId;
    }

    public Long getMortgageTypeId() {
        return mortgageTypeId;
    }

    public void setMortgageTypeId(Long mortgageTypeId) {
        this.mortgageTypeId = mortgageTypeId;
    }

    public String getMortgageTypeName() {
        return mortgageTypeName;
    }

    public void setMortgageTypeName(String mortgageTypeName) {
        this.mortgageTypeName = mortgageTypeName == null ? null : mortgageTypeName.trim();
    }

    public Long getBuyCardCapitalTypeId() {
        return buyCardCapitalTypeId;
    }

    public void setBuyCardCapitalTypeId(Long buyCardCapitalTypeId) {
        this.buyCardCapitalTypeId = buyCardCapitalTypeId;
    }

    public String getBuyCardCapitalTypeName() {
        return buyCardCapitalTypeName;
    }

    public void setBuyCardCapitalTypeName(String buyCardCapitalTypeName) {
        this.buyCardCapitalTypeName = buyCardCapitalTypeName == null ? null : buyCardCapitalTypeName.trim();
    }

    public Integer getBelongerTpye() {
        return belongerTpye;
    }

    public void setBelongerTpye(Integer belongerTpye) {
        this.belongerTpye = belongerTpye;
    }

    public Long getBelongerCompanyHeaderId() {
        return belongerCompanyHeaderId;
    }

    public void setBelongerCompanyHeaderId(Long belongerCompanyHeaderId) {
        this.belongerCompanyHeaderId = belongerCompanyHeaderId;
    }

    public Integer getInsuranceBeneficiaryType() {
        return insuranceBeneficiaryType;
    }

    public void setInsuranceBeneficiaryType(Integer insuranceBeneficiaryType) {
        this.insuranceBeneficiaryType = insuranceBeneficiaryType;
    }

    public Long getBeneficiaryCompanyHeaderId() {
        return beneficiaryCompanyHeaderId;
    }

    public void setBeneficiaryCompanyHeaderId(Long beneficiaryCompanyHeaderId) {
        this.beneficiaryCompanyHeaderId = beneficiaryCompanyHeaderId;
    }

    public Long getBeneficiaFinancingerId() {
        return beneficiaFinancingerId;
    }

    public void setBeneficiaFinancingerId(Long beneficiaFinancingerId) {
        this.beneficiaFinancingerId = beneficiaFinancingerId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber == null ? null : registrationNumber.trim();
    }

    public String getRegistrationNumberImg() {
        return registrationNumberImg;
    }

    public void setRegistrationNumberImg(String registrationNumberImg) {
        this.registrationNumberImg = registrationNumberImg == null ? null : registrationNumberImg.trim();
    }

    public Long getGpsSupplierId() {
        return gpsSupplierId;
    }

    public void setGpsSupplierId(Long gpsSupplierId) {
        this.gpsSupplierId = gpsSupplierId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPurchaseTaxRate() {
        return purchaseTaxRate;
    }

    public void setPurchaseTaxRate(BigDecimal purchaseTaxRate) {
        this.purchaseTaxRate = purchaseTaxRate;
    }

    public BigDecimal getPurchaseTax() {
        return purchaseTax;
    }

    public void setPurchaseTax(BigDecimal purchaseTax) {
        this.purchaseTax = purchaseTax;
    }

    public BigDecimal getOnPlateCost() {
        return onPlateCost;
    }

    public void setOnPlateCost(BigDecimal onPlateCost) {
        this.onPlateCost = onPlateCost;
    }

    public BigDecimal getGpsCost() {
        return gpsCost;
    }

    public void setGpsCost(BigDecimal gpsCost) {
        this.gpsCost = gpsCost;
    }

    public BigDecimal getMortgageCost() {
        return mortgageCost;
    }

    public void setMortgageCost(BigDecimal mortgageCost) {
        this.mortgageCost = mortgageCost;
    }

    public BigDecimal getVehicleVesselTax() {
        return vehicleVesselTax;
    }

    public void setVehicleVesselTax(BigDecimal vehicleVesselTax) {
        this.vehicleVesselTax = vehicleVesselTax;
    }

    public BigDecimal getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(BigDecimal otherCost) {
        this.otherCost = otherCost;
    }

    public Long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Long storehouseId) {
        this.storehouseId = storehouseId;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getStorehouseStatus() {
        return storehouseStatus;
    }

    public void setStorehouseStatus(Integer storehouseStatus) {
        this.storehouseStatus = storehouseStatus;
    }

    public Integer getLeaseStatus() {
        return leaseStatus;
    }

    public void setLeaseStatus(Integer leaseStatus) {
        this.leaseStatus = leaseStatus;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(Boolean insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    public Boolean getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(Boolean gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public Integer getPlateStatus() {
        return plateStatus;
    }

    public void setPlateStatus(Integer plateStatus) {
        this.plateStatus = plateStatus;
    }

    public Date getInStorehouseTime() {
        return inStorehouseTime;
    }

    public void setInStorehouseTime(Date inStorehouseTime) {
        this.inStorehouseTime = inStorehouseTime;
    }

    public Integer getSaleChannelType() {
        return saleChannelType;
    }

    public void setSaleChannelType(Integer saleChannelType) {
        this.saleChannelType = saleChannelType;
    }

    public Long getSaleChannelId() {
        return saleChannelId;
    }

    public void setSaleChannelId(Long saleChannelId) {
        this.saleChannelId = saleChannelId;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getInvoicingTax() {
        return invoicingTax;
    }

    public void setInvoicingTax(BigDecimal invoicingTax) {
        this.invoicingTax = invoicingTax;
    }

    public BigDecimal getInvoicedCarPrice() {
        return invoicedCarPrice;
    }

    public void setInvoicedCarPrice(BigDecimal invoicedCarPrice) {
        this.invoicedCarPrice = invoicedCarPrice;
    }

    public List<String> getRegistrationNumberImgs() {
        return registrationNumberImgs;
    }

    public void setRegistrationNumberImgs(List<String> registrationNumberImgs) {
        this.registrationNumberImgs = registrationNumberImgs;
    }

    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public Boolean getMortgageStatus() {
        return mortgageStatus;
    }

    public void setMortgageStatus(Boolean mortgageStatus) {
        this.mortgageStatus = mortgageStatus;
    }

    public List<LeaseCarDictAccessory> getLeaseCarDictAccessories() {
        return leaseCarDictAccessories;
    }

    public void setLeaseCarDictAccessories(List<LeaseCarDictAccessory> leaseCarDictAccessories) {
        this.leaseCarDictAccessories = leaseCarDictAccessories;
    }

    public String getCarBuyFinancingerName() {
        return carBuyFinancingerName;
    }

    public void setCarBuyFinancingerName(String carBuyFinancingerName) {
        this.carBuyFinancingerName = carBuyFinancingerName;
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

    public String getBusinessModelName() {
        return businessModelName;
    }

    public void setBusinessModelName(String businessModelName) {
        this.businessModelName = businessModelName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getBelongerCompanyHeaderName() {
        return belongerCompanyHeaderName;
    }

    public void setBelongerCompanyHeaderName(String belongerCompanyHeaderName) {
        this.belongerCompanyHeaderName = belongerCompanyHeaderName;
    }

    public String getBeneficiaryCompanyHeaderName() {
        return beneficiaryCompanyHeaderName;
    }

    public void setBeneficiaryCompanyHeaderName(String beneficiaryCompanyHeaderName) {
        this.beneficiaryCompanyHeaderName = beneficiaryCompanyHeaderName;
    }

    public String getBeneficiaFinancingerName() {
        return beneficiaFinancingerName;
    }

    public void setBeneficiaFinancingerName(String beneficiaFinancingerName) {
        this.beneficiaFinancingerName = beneficiaFinancingerName;
    }

    public String getGpsSupplierName() {
        return gpsSupplierName;
    }

    public void setGpsSupplierName(String gpsSupplierName) {
        this.gpsSupplierName = gpsSupplierName;
    }

    public String getStorehouseName() {
        return storehouseName;
    }

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public String getLaseCarinsurancesJson() {
        return laseCarinsurancesJson;
    }

    public void setLaseCarinsurancesJson(String laseCarinsurancesJson) {
        this.laseCarinsurancesJson = laseCarinsurancesJson;
    }

    public String getLeaseCarDictAccessoriesJson() {
        return leaseCarDictAccessoriesJson;
    }

    public void setLeaseCarDictAccessoriesJson(String leaseCarDictAccessoriesJson) {
        this.leaseCarDictAccessoriesJson = leaseCarDictAccessoriesJson;
    }

    public String getCarSupplierName() {
        return carSupplierName;
    }

    public void setCarSupplierName(String carSupplierName) {
        this.carSupplierName = carSupplierName;
    }

    public Integer getStorehouseType() {
        return storehouseType;
    }

    public void setStorehouseType(Integer storehouseType) {
        this.storehouseType = storehouseType;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Integer getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(Integer carCondition) {
        this.carCondition = carCondition;
    }

    public LeaseCarOtherCost getLeaseCarOtherCost() {
        return leaseCarOtherCost;
    }

    public void setLeaseCarOtherCost(LeaseCarOtherCost leaseCarOtherCost) {
        this.leaseCarOtherCost = leaseCarOtherCost;
    }

    public LeaseCostCheck getLeaseCostCheck() {
        return leaseCostCheck;
    }

    public void setLeaseCostCheck(LeaseCostCheck leaseCostCheck) {
        this.leaseCostCheck = leaseCostCheck;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getCompleteModelName() {
        return completeModelName;
    }

    public void setCompleteModelName(String completeModelName) {
        this.completeModelName = completeModelName;
    }
}