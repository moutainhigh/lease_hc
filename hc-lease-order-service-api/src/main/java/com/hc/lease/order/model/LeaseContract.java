package com.hc.lease.order.model;

import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseContract implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "还款记录主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租订单主键id", hidden = false)
    private Long schemeOrderId;
    @ApiModelProperty(value = "融租合同模板主键id", hidden = false)
    private Long contractBaseinfoId;
    @ApiModelProperty(value = "分公司主键Id", hidden = false)
    private Long branchCompanyId;
    @ApiModelProperty(value = "销售渠道 0: 直销; 1:经销商", hidden = false)
    private Integer saleChannelType;
    @ApiModelProperty(value = "销售渠道 为:经销商/经销商主键id", hidden = false)
    private Long saleChannelId;
    @ApiModelProperty(value = "合同编号-年", hidden = false)
    private String contractNumberYear;
    @ApiModelProperty(value = "合同编号-号", hidden = false)
    private String contractNumber;
    @ApiModelProperty(value = "合同ID", hidden = false)
    private String contractKey;
    @ApiModelProperty(value = "收到首期日期", hidden = false)
    private Date payStagingTime;
    @ApiModelProperty(value = "租赁起始日期", hidden = false)
    private Date leaseStartTime;
    @ApiModelProperty(value = "租赁结束日期", hidden = false)
    private Date leaseEndTime;
  /*  @ApiModelProperty(value = "", hidden = false)
    private Boolean stagingContainMonthlyRent;
    @ApiModelProperty(value = "", hidden = false)
    private Long companyHeaderId;*/
    @ApiModelProperty(value = "承租人联系地址", hidden = false)
    private String accountContactAdress;

    @ApiModelProperty(value = "担保人姓名", hidden = false)
    private String guaranteeName;
    @ApiModelProperty(value = "担保人身份证号", hidden = false)
    private String guaranteeIdCard;
    @ApiModelProperty(value = "担保人联系地址", hidden = false)
    private String guaranteeContactAddress;
    @ApiModelProperty(value = "续保第三方责任险最低保额（元）", hidden = false)
    private BigDecimal thirdPartyLiabilityInsurance;
    @ApiModelProperty(value = "车辆交付验收确认书 图片", hidden = false)
    private String cardCheckAcceptImg;

    @ApiModelProperty(value = "手持身份证 图片", hidden = false)
    private String idCardImg;
    @ApiModelProperty(value = "交付车辆 图片", hidden = false)
    private String carAcceptImg;

    @ApiModelProperty(value = "担保人手机", hidden = false)
    private String guaranteeContact;
    @ApiModelProperty(value = "担保人紧急联系人姓名", hidden = false)
    private String guaranteeContactName;
    @ApiModelProperty(value = "担保人紧急联系人手机", hidden = false)
    private String guaranteeContactPhone;
    @ApiModelProperty(value = "担保人邮编", hidden = false)
    private String guaranteeZipCode;
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
    @ApiModelProperty(value = "合同状态", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;


    //显示需要用
    @ApiModelProperty(value = "归档位置实体", hidden = false)
    private List<LeaseContractArchiveLocation>  leaseContractArchiveLocationList;
    private  String leaseContractArchiveLocationJson;

    @ApiModelProperty(value = "承租人实体类List", hidden = false)
    private List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts;
    private String leaseSchemeOrderAccountJson;

    @ApiModelProperty(value = "还款记录List", hidden = false)
    private List<LeaseSchemeRepayment> leaseSchemeRepaymentList;

    private String leaseSchemeRepaymentJson;

    @ApiModelProperty(value = "分公司名称", hidden = false)
    private String branchCompanyName;
    @ApiModelProperty(value = "合同方", hidden = false)
    private String contractPartyName;
    @ApiModelProperty(value = "经销商", hidden = false)
    private String dealerName;
    @ApiModelProperty(value = "客户综合报价", hidden = false)
    private BigDecimal comprehensiveQuote;

    private String brandsName;
    private String seriesName;
    private String businessModelName;
    private String colorName;
    private String schemeName;
    private String plateNumber;
    private Long cardId;
    private Long schemeId;
    private String sn;
    private BigDecimal carPrice;
    private BigDecimal totleCarPrice;
    private BigDecimal leasePrice;
    private Long contractPartyId;
    private BigDecimal annualInterest;
    private BigDecimal downPayment;
    private BigDecimal balancePayment;
    private Long stagingNumberId;
    private BigDecimal commission;
    private BigDecimal receiveMargin;
    private String cardFrameNumber;
    private String engineNumber;
    private BigDecimal purchaseTax;
    private BigDecimal onPlateCost;
    private BigDecimal vehicleVesselTax;
    private String itemType;

   private String leaseContractBaseinfo;

    @ApiModelProperty(value = "失败累计", hidden = false)
    private Integer paymentResultCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getSchemeOrderId() {
        return schemeOrderId;
    }

    public void setSchemeOrderId(Long schemeOrderId) {
        this.schemeOrderId = schemeOrderId;
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

    public String getContractNumberYear() {
        return contractNumberYear;
    }

    public void setContractNumberYear(String contractNumberYear) {
        this.contractNumberYear = contractNumberYear == null ? null : contractNumberYear.trim();
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public String getContractKey() {
        return contractKey;
    }

    public void setContractKey(String contractKey) {
        this.contractKey = contractKey == null ? null : contractKey.trim();
    }

    public Date getPayStagingTime() {
        return payStagingTime;
    }

    public void setPayStagingTime(Date payStagingTime) {
        this.payStagingTime = payStagingTime;
    }

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public Date getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(Date leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

   /* public Boolean getStagingContainMonthlyRent() {
        return stagingContainMonthlyRent;
    }

    public void setStagingContainMonthlyRent(Boolean stagingContainMonthlyRent) {
        this.stagingContainMonthlyRent = stagingContainMonthlyRent;
    }

    public Long getCompanyHeaderId() {
        return companyHeaderId;
    }

    public void setCompanyHeaderId(Long companyHeaderId) {
        this.companyHeaderId = companyHeaderId;
    }
*/
    public String getAccountContactAdress() {
        return accountContactAdress;
    }

    public void setAccountContactAdress(String accountContactAdress) {
        this.accountContactAdress = accountContactAdress == null ? null : accountContactAdress.trim();
    }

    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName == null ? null : guaranteeName.trim();
    }

    public String getGuaranteeIdCard() {
        return guaranteeIdCard;
    }

    public void setGuaranteeIdCard(String guaranteeIdCard) {
        this.guaranteeIdCard = guaranteeIdCard == null ? null : guaranteeIdCard.trim();
    }

    public String getGuaranteeContactAddress() {
        return guaranteeContactAddress;
    }

    public void setGuaranteeContactAddress(String guaranteeContactAddress) {
        this.guaranteeContactAddress = guaranteeContactAddress == null ? null : guaranteeContactAddress.trim();
    }

    public BigDecimal getThirdPartyLiabilityInsurance() {
        return thirdPartyLiabilityInsurance;
    }

    public void setThirdPartyLiabilityInsurance(BigDecimal thirdPartyLiabilityInsurance) {
        this.thirdPartyLiabilityInsurance = thirdPartyLiabilityInsurance;
    }

    public String getCardCheckAcceptImg() {
        return cardCheckAcceptImg;
    }

    public void setCardCheckAcceptImg(String cardCheckAcceptImg) {
        this.cardCheckAcceptImg = cardCheckAcceptImg == null ? null : cardCheckAcceptImg.trim();
    }

    public String getGuaranteeContact() {
        return guaranteeContact;
    }

    public void setGuaranteeContact(String guaranteeContact) {
        this.guaranteeContact = guaranteeContact == null ? null : guaranteeContact.trim();
    }

    public String getGuaranteeContactName() {
        return guaranteeContactName;
    }

    public void setGuaranteeContactName(String guaranteeContactName) {
        this.guaranteeContactName = guaranteeContactName == null ? null : guaranteeContactName.trim();
    }

    public String getGuaranteeContactPhone() {
        return guaranteeContactPhone;
    }

    public void setGuaranteeContactPhone(String guaranteeContactPhone) {
        this.guaranteeContactPhone = guaranteeContactPhone == null ? null : guaranteeContactPhone.trim();
    }

    public String getGuaranteeZipCode() {
        return guaranteeZipCode;
    }

    public void setGuaranteeZipCode(String guaranteeZipCode) {
        this.guaranteeZipCode = guaranteeZipCode == null ? null : guaranteeZipCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public List<LeaseContractArchiveLocation> getLeaseContractArchiveLocationList() {
        return leaseContractArchiveLocationList;
    }

    public void setLeaseContractArchiveLocationList(List<LeaseContractArchiveLocation> leaseContractArchiveLocationList) {
        this.leaseContractArchiveLocationList = leaseContractArchiveLocationList;
    }

    public String getLeaseContractArchiveLocationJson() {
        return leaseContractArchiveLocationJson;
    }

    public void setLeaseContractArchiveLocationJson(String leaseContractArchiveLocationJson) {
        this.leaseContractArchiveLocationJson = leaseContractArchiveLocationJson;
    }

    public List<LeaseSchemeOrderAccount> getLeaseSchemeOrderAccounts() {
        return leaseSchemeOrderAccounts;
    }

    public void setLeaseSchemeOrderAccounts(List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts) {
        this.leaseSchemeOrderAccounts = leaseSchemeOrderAccounts;
    }

    public String getLeaseSchemeOrderAccountJson() {
        return leaseSchemeOrderAccountJson;
    }

    public void setLeaseSchemeOrderAccountJson(String leaseSchemeOrderAccountJson) {
        this.leaseSchemeOrderAccountJson = leaseSchemeOrderAccountJson;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public String getContractPartyName() {
        return contractPartyName;
    }

    public void setContractPartyName(String contractPartyName) {
        this.contractPartyName = contractPartyName;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public BigDecimal getComprehensiveQuote() {
        return comprehensiveQuote;
    }

    public void setComprehensiveQuote(BigDecimal comprehensiveQuote) {
        this.comprehensiveQuote = comprehensiveQuote;
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

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Integer getPaymentResultCount() {
        return paymentResultCount;
    }

    public void setPaymentResultCount(Integer paymentResultCount) {
        this.paymentResultCount = paymentResultCount;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public BigDecimal getTotleCarPrice() {
        return totleCarPrice;
    }

    public void setTotleCarPrice(BigDecimal totleCarPrice) {
        this.totleCarPrice = totleCarPrice;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public Long getContractPartyId() {
        return contractPartyId;
    }

    public void setContractPartyId(Long contractPartyId) {
        this.contractPartyId = contractPartyId;
    }

    public Long getContractBaseinfoId() {
        return contractBaseinfoId;
    }

    public void setContractBaseinfoId(Long contractBaseinfoId) {
        this.contractBaseinfoId = contractBaseinfoId;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

    public Long getStagingNumberId() {
        return stagingNumberId;
    }

    public void setStagingNumberId(Long stagingNumberId) {
        this.stagingNumberId = stagingNumberId;
    }

    public BigDecimal getReceiveMargin() {
        return receiveMargin;
    }

    public void setReceiveMargin(BigDecimal receiveMargin) {
        this.receiveMargin = receiveMargin;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public List<LeaseSchemeRepayment> getLeaseSchemeRepaymentList() {
        return leaseSchemeRepaymentList;
    }

    public void setLeaseSchemeRepaymentList(List<LeaseSchemeRepayment> leaseSchemeRepaymentList) {
        this.leaseSchemeRepaymentList = leaseSchemeRepaymentList;
    }

    public String getLeaseSchemeRepaymentJson() {
        return leaseSchemeRepaymentJson;
    }

    public void setLeaseSchemeRepaymentJson(String leaseSchemeRepaymentJson) {
        this.leaseSchemeRepaymentJson = leaseSchemeRepaymentJson;
    }

    public String getCardFrameNumber() {
        return cardFrameNumber;
    }

    public void setCardFrameNumber(String cardFrameNumber) {
        this.cardFrameNumber = cardFrameNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
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

    public BigDecimal getVehicleVesselTax() {
        return vehicleVesselTax;
    }

    public void setVehicleVesselTax(BigDecimal vehicleVesselTax) {
        this.vehicleVesselTax = vehicleVesselTax;
    }


    public String getLeaseContractBaseinfo() {
        return leaseContractBaseinfo;
    }

    public void setLeaseContractBaseinfo(String leaseContractBaseinfo) {
        this.leaseContractBaseinfo = leaseContractBaseinfo;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg;
    }

    public String getCarAcceptImg() {
        return carAcceptImg;
    }

    public void setCarAcceptImg(String carAcceptImg) {
        this.carAcceptImg = carAcceptImg;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}