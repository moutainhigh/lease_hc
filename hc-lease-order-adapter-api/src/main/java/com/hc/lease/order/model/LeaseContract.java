package com.hc.lease.order.model;

import com.hc.lease.baseInfo.vo.ContractPartyContactAddressVo;
import com.hc.lease.supplier.model.LeasePackageBalancePayment;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    @ApiModelProperty(value = "完整合同编号/手动编号预览", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "合同ID", hidden = false)
    private String contractKey;
    @ApiModelProperty(value = "收到首期日期", hidden = false)
    private Date payStagingTime;
    @ApiModelProperty(value = "租赁起始日期", hidden = false)
    private Date leaseStartTime;
    @ApiModelProperty(value = "租赁结束日期", hidden = false)
    private Date leaseEndTime;
    /*  @ApiModelProperty(value = "分期数", hidden = false)
      private Boolean stagingContainMonthlyRent;
      @ApiModelProperty(value = "分公司主键Id", hidden = false)
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
    @ApiModelProperty(value = "合同类型（1 标准 2 准合同）", hidden = false)
    private Integer contractType;
    @ApiModelProperty(value = "数据版本号", hidden = false)
    private Integer vsersionNumber;
    @ApiModelProperty(value = "合同处置方案状态 对应 DealStatus 实体的状态", hidden = false)
    private String dealStatus;
    @ApiModelProperty(value = "备份 合同状态,合同修改会切换状态，备份给Status还原上次的状态", hidden = false)
    private Integer backStatus;

    @ApiModelProperty(value = "父合同主键Id", hidden = false)
    private Long parentId;
    @ApiModelProperty(value = "合同来源类型 0 原始合同 1 改期数 2 续期 3 转租", hidden = false)
    private Integer sourceType;
    @ApiModelProperty(value = "新旧合同差价", hidden = false)
    private BigDecimal priceDifference;

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
    private List<LeaseContractArchiveLocation> leaseContractArchiveLocationList;
    private String leaseContractArchiveLocationJson;

    @ApiModelProperty(value = "承租人实体类List", hidden = false)
    private List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts;
    private String leaseSchemeOrderAccountJson;

    @ApiModelProperty(value = "还款记录List", hidden = false)
    private List<LeaseSchemeRepayment> leaseSchemeRepaymentList;

    private String leaseSchemeRepaymentJson;
    @ApiModelProperty(value = "融租方案尾款List", hidden = false)
    private List<LeasePackageBalancePayment> leasePackageBalancePayments;

    private String leasePackageBalancePaymentJson;

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
    @ApiModelProperty(value = "车况 1新车 2次新车、二手车", hidden = false)
    private Integer carCondition;
    private String engineNumber;
    private BigDecimal purchaseTax;
    private BigDecimal onPlateCost;
    private BigDecimal vehicleVesselTax;
    private String itemType;
    @ApiModelProperty(value = "年度融租方案月租", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "车辆完整型号", hidden = false)
    private String completeModelName;
    @ApiModelProperty(value = "分期数", hidden = false)
    private String stagingNumberName;

    private String leaseContractBaseinfo;

    @ApiModelProperty(value = "失败累计", hidden = false)
    private Integer paymentResultCount;

    @ApiModelProperty(value = "扣款日", hidden = false)
    private String repaymentDate;

    @ApiModelProperty(value = "期数", hidden = false)
    private String period;

    @ApiModelProperty(value = "扣款总额", hidden = false)
    private BigDecimal totlePrice;

    @ApiModelProperty(value = "承租人手机", hidden = false)
    private String accountPhone;

    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;

    @ApiModelProperty(value = "费用明细/扣款方式/扣款结果", hidden = false)
    private ArrayList repaymentDetails;

    @ApiModelProperty(value = "融租方案类型（类型 0:默认套餐;1:定制套餐）", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "融租方案类型（类型 1:标准;1:年度尾款）", hidden = false)
    private Integer isType;
    @ApiModelProperty(value = "准合同品牌ID", hidden = false)
    private Long contractBrandsId;
    @ApiModelProperty(value = "准合同系列ID", hidden = false)
    private Long contractSeriesId;
    @ApiModelProperty(value = "准合同车型ID", hidden = false)
    private Long contractModelId;
    @ApiModelProperty(value = "准合同品牌", hidden = false)
    private String contractBrandsName;
    @ApiModelProperty(value = "准合同系列", hidden = false)
    private String contractSeriesName;
    @ApiModelProperty(value = "准合同车型", hidden = false)
    private String contractBusinessModelName;
    @ApiModelProperty(value = "准合同车型", hidden = false)
    private String contractCompleteModelName;
    @ApiModelProperty(value = "年度尾款融租方案全包价", hidden = false)
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "银行编码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "扣款日（列表用）", hidden = false)
    private Integer payDate;
    @ApiModelProperty(value = "合同月供", hidden = false)
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "是否存在扣款中的还款计划 1是0否", hidden = false)
    private Integer isPaying;

    //融租合同模板


    @ApiModelProperty(value = "模板名称", hidden = false)
    private String name;

    @ApiModelProperty(value = "出租人", hidden = false)
    private String baseInfoContractPartyName;

    @ApiModelProperty(value = "出租人分公司", hidden = false)
    private String contractBranchCompany;

    @ApiModelProperty(value = "出租人住所", hidden = false)
    private String contractPartyAdress;

    @ApiModelProperty(value = "法定代表人", hidden = false)
    private String legalPerson;

    @ApiModelProperty(value = "重大事件金额", hidden = false)
    private BigDecimal importantEventPrice;

    @ApiModelProperty(value = "检测定期", hidden = false)
    private String checkTime;

    @ApiModelProperty(value = "交首款天数期限", hidden = false)
    private String downPaymentTimeLimit;

    @ApiModelProperty(value = "原件出借押金", hidden = false)
    private BigDecimal loanDeposit;

    @ApiModelProperty(value = "约定区域", hidden = false)
    private String appointArea;

    @ApiModelProperty(value = "租金逾期回收期限", hidden = false)
    private String rentOverdueTimeLimit;


    @ApiModelProperty(value = "车辆承租城市", hidden = false)
    private String carLesseeCity;

    @ApiModelProperty(value = "市内回收费", hidden = false)
    private BigDecimal cityInsideRecoveryCost;

    @ApiModelProperty(value = "市外回收费", hidden = false)
    private BigDecimal cityOutsideRecoveryCost;

    @ApiModelProperty(value = "省内回收费", hidden = false)
    private BigDecimal provinceInsideRecoveryCost;

    @ApiModelProperty(value = "省外回收费", hidden = false)
    private BigDecimal provinceOutsideRecoveryCost;
    @ApiModelProperty(value = "日保管费", hidden = false)
    private BigDecimal dayCustodianCost;

    @ApiModelProperty(value = "连续逾期", hidden = false)
    private String continuityOverdue;

    @ApiModelProperty(value = "累计逾期", hidden = false)
    private String cumulativeOverdue;

    @ApiModelProperty(value = "提前还款罚息金额", hidden = false)
    private Long defaultInterest;

    @ApiModelProperty(value = "挂靠牌照月租", hidden = false)
    private BigDecimal licenseMonthlyRent;

    @ApiModelProperty(value = "出租人联系地址/json格式存放多个地址 如[{\"address\":\"广州天河区\"}]", hidden = false)
    private Object contractPartyContactAddress;

    @ApiModelProperty(value = "户名", hidden = false)
    private String accountName;

    @ApiModelProperty(value = "开户行主键id", hidden = false)
    private Long bankId;

    @ApiModelProperty(value = "分行", hidden = false)
    private String branchBank;

    @ApiModelProperty(value = "账号", hidden = false)
    private String account;


    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;

    @ApiModelProperty(value = "出租人联系地址", hidden = false)
    private List<ContractPartyContactAddressVo> contractPartyContactAddressVoList;

    @ApiModelProperty(value = "提前还款罚息金额", hidden = false)
    private String defaultInterestName;

    @ApiModelProperty(value = "银行名称", hidden = false)
    private String bankName;

    @ApiModelProperty(value = "所属分公司主键id", hidden = false)
    private Long baseInfoBranchCompanyId;
    @ApiModelProperty(value = "所属分公司名称", hidden = false)
    private String baseInfoBranchCompanyName;

    @ApiModelProperty(value = "被授权人", hidden = false)
    private String authorizedPerson;
    @ApiModelProperty(value = "甲方", hidden = false)
    private String partyA;
    @ApiModelProperty(value = "乙方", hidden = false)
    private String partyB;
    @ApiModelProperty(value = "丙方", hidden = false)
    private String partyC;
    @ApiModelProperty(value = "借款担保人", hidden = false)
    private String loanGuarantor;
    @ApiModelProperty(value = "担保人", hidden = false)
    private String guarantor;

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

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
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

    public Integer getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(Integer carCondition) {
        this.carCondition = carCondition;
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

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public ArrayList getRepaymentDetails() {
        return repaymentDetails;
    }

    public void setRepaymentDetails(ArrayList repaymentDetails) {
        this.repaymentDetails = repaymentDetails;
    }

    public String getCompleteModelName() {
        return completeModelName;
    }

    public void setCompleteModelName(String completeModelName) {
        this.completeModelName = completeModelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseInfoContractPartyName() {
        return baseInfoContractPartyName;
    }

    public void setBaseInfoContractPartyName(String baseInfoContractPartyName) {
        this.baseInfoContractPartyName = baseInfoContractPartyName;
    }

    public String getContractBranchCompany() {
        return contractBranchCompany;
    }

    public void setContractBranchCompany(String contractBranchCompany) {
        this.contractBranchCompany = contractBranchCompany;
    }

    public String getContractPartyAdress() {
        return contractPartyAdress;
    }

    public void setContractPartyAdress(String contractPartyAdress) {
        this.contractPartyAdress = contractPartyAdress;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public BigDecimal getImportantEventPrice() {
        return importantEventPrice;
    }

    public void setImportantEventPrice(BigDecimal importantEventPrice) {
        this.importantEventPrice = importantEventPrice;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getDownPaymentTimeLimit() {
        return downPaymentTimeLimit;
    }

    public void setDownPaymentTimeLimit(String downPaymentTimeLimit) {
        this.downPaymentTimeLimit = downPaymentTimeLimit;
    }

    public BigDecimal getLoanDeposit() {
        return loanDeposit;
    }

    public void setLoanDeposit(BigDecimal loanDeposit) {
        this.loanDeposit = loanDeposit;
    }

    public String getAppointArea() {
        return appointArea;
    }

    public void setAppointArea(String appointArea) {
        this.appointArea = appointArea;
    }

    public String getRentOverdueTimeLimit() {
        return rentOverdueTimeLimit;
    }

    public void setRentOverdueTimeLimit(String rentOverdueTimeLimit) {
        this.rentOverdueTimeLimit = rentOverdueTimeLimit;
    }

    public String getCarLesseeCity() {
        return carLesseeCity;
    }

    public void setCarLesseeCity(String carLesseeCity) {
        this.carLesseeCity = carLesseeCity;
    }

    public BigDecimal getCityInsideRecoveryCost() {
        return cityInsideRecoveryCost;
    }

    public void setCityInsideRecoveryCost(BigDecimal cityInsideRecoveryCost) {
        this.cityInsideRecoveryCost = cityInsideRecoveryCost;
    }

    public BigDecimal getCityOutsideRecoveryCost() {
        return cityOutsideRecoveryCost;
    }

    public void setCityOutsideRecoveryCost(BigDecimal cityOutsideRecoveryCost) {
        this.cityOutsideRecoveryCost = cityOutsideRecoveryCost;
    }

    public BigDecimal getProvinceInsideRecoveryCost() {
        return provinceInsideRecoveryCost;
    }

    public void setProvinceInsideRecoveryCost(BigDecimal provinceInsideRecoveryCost) {
        this.provinceInsideRecoveryCost = provinceInsideRecoveryCost;
    }

    public BigDecimal getProvinceOutsideRecoveryCost() {
        return provinceOutsideRecoveryCost;
    }

    public void setProvinceOutsideRecoveryCost(BigDecimal provinceOutsideRecoveryCost) {
        this.provinceOutsideRecoveryCost = provinceOutsideRecoveryCost;
    }

    public BigDecimal getDayCustodianCost() {
        return dayCustodianCost;
    }

    public void setDayCustodianCost(BigDecimal dayCustodianCost) {
        this.dayCustodianCost = dayCustodianCost;
    }

    public String getContinuityOverdue() {
        return continuityOverdue;
    }

    public void setContinuityOverdue(String continuityOverdue) {
        this.continuityOverdue = continuityOverdue;
    }

    public String getCumulativeOverdue() {
        return cumulativeOverdue;
    }

    public void setCumulativeOverdue(String cumulativeOverdue) {
        this.cumulativeOverdue = cumulativeOverdue;
    }

    public Long getDefaultInterest() {
        return defaultInterest;
    }

    public void setDefaultInterest(Long defaultInterest) {
        this.defaultInterest = defaultInterest;
    }

    public BigDecimal getLicenseMonthlyRent() {
        return licenseMonthlyRent;
    }

    public void setLicenseMonthlyRent(BigDecimal licenseMonthlyRent) {
        this.licenseMonthlyRent = licenseMonthlyRent;
    }

    public Object getContractPartyContactAddress() {
        return contractPartyContactAddress;
    }

    public void setContractPartyContactAddress(Object contractPartyContactAddress) {
        this.contractPartyContactAddress = contractPartyContactAddress;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBranchBank() {
        return branchBank;
    }

    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<ContractPartyContactAddressVo> getContractPartyContactAddressVoList() {
        return contractPartyContactAddressVoList;
    }

    public void setContractPartyContactAddressVoList(List<ContractPartyContactAddressVo> contractPartyContactAddressVoList) {
        this.contractPartyContactAddressVoList = contractPartyContactAddressVoList;
    }

    public String getDefaultInterestName() {
        return defaultInterestName;
    }

    public void setDefaultInterestName(String defaultInterestName) {
        this.defaultInterestName = defaultInterestName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getBaseInfoBranchCompanyId() {
        return baseInfoBranchCompanyId;
    }

    public void setBaseInfoBranchCompanyId(Long baseInfoBranchCompanyId) {
        this.baseInfoBranchCompanyId = baseInfoBranchCompanyId;
    }


    public String getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(String authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public String getPartyC() {
        return partyC;
    }

    public void setPartyC(String partyC) {
        this.partyC = partyC;
    }

    public String getLoanGuarantor() {
        return loanGuarantor;
    }

    public void setLoanGuarantor(String loanGuarantor) {
        this.loanGuarantor = loanGuarantor;
    }

    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor;
    }

    public String getBaseInfoBranchCompanyName() {
        return baseInfoBranchCompanyName;
    }

    public void setBaseInfoBranchCompanyName(String baseInfoBranchCompanyName) {
        this.baseInfoBranchCompanyName = baseInfoBranchCompanyName;
    }

    public List<LeasePackageBalancePayment> getLeasePackageBalancePayments() {
        return leasePackageBalancePayments;
    }

    public void setLeasePackageBalancePayments(List<LeasePackageBalancePayment> leasePackageBalancePayments) {
        this.leasePackageBalancePayments = leasePackageBalancePayments;
    }

    public String getLeasePackageBalancePaymentJson() {
        return leasePackageBalancePaymentJson;
    }

    public void setLeasePackageBalancePaymentJson(String leasePackageBalancePaymentJson) {
        this.leasePackageBalancePaymentJson = leasePackageBalancePaymentJson;
    }


    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public Integer getVsersionNumber() {
        return vsersionNumber;
    }

    public void setVsersionNumber(Integer vsersionNumber) {
        this.vsersionNumber = vsersionNumber;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Integer getBackStatus() {
        return backStatus;
    }

    public void setBackStatus(Integer backStatus) {
        this.backStatus = backStatus;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public BigDecimal getPriceDifference() {
        return priceDifference;
    }

    public void setPriceDifference(BigDecimal priceDifference) {
        this.priceDifference = priceDifference;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsType() {
        return isType;
    }

    public void setIsType(Integer isType) {
        this.isType = isType;
    }

    public Long getContractBrandsId() {
        return contractBrandsId;
    }

    public void setContractBrandsId(Long contractBrandsId) {
        this.contractBrandsId = contractBrandsId;
    }

    public Long getContractSeriesId() {
        return contractSeriesId;
    }

    public void setContractSeriesId(Long contractSeriesId) {
        this.contractSeriesId = contractSeriesId;
    }

    public Long getContractModelId() {
        return contractModelId;
    }

    public void setContractModelId(Long contractModelId) {
        this.contractModelId = contractModelId;
    }

    public String getContractBrandsName() {
        return contractBrandsName;
    }

    public void setContractBrandsName(String contractBrandsName) {
        this.contractBrandsName = contractBrandsName;
    }

    public String getContractSeriesName() {
        return contractSeriesName;
    }

    public void setContractSeriesName(String contractSeriesName) {
        this.contractSeriesName = contractSeriesName;
    }

    public String getContractBusinessModelName() {
        return contractBusinessModelName;
    }

    public void setContractBusinessModelName(String contractBusinessModelName) {
        this.contractBusinessModelName = contractBusinessModelName;
    }

    public String getContractCompleteModelName() {
        return contractCompleteModelName;
    }

    public void setContractCompleteModelName(String contractCompleteModelName) {
        this.contractCompleteModelName = contractCompleteModelName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }


    public String getStagingNumberName() {
        return stagingNumberName;
    }

    public void setStagingNumberName(String stagingNumberName) {
        this.stagingNumberName = stagingNumberName;
    }


    public Integer getPayDate() {
        return payDate;
    }

    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getIsPaying() {
        return isPaying;
    }

    public void setIsPaying(Integer isPaying) {
        this.isPaying = isPaying;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "id=" + id +
                ", repaymentId=" + repaymentId +
                ", schemeOrderId=" + schemeOrderId +
                ", contractBaseinfoId=" + contractBaseinfoId +
                ", branchCompanyId=" + branchCompanyId +
                ", saleChannelType=" + saleChannelType +
                ", saleChannelId=" + saleChannelId +
                ", contractNumberYear='" + contractNumberYear + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", completeContractNumber='" + completeContractNumber + '\'' +
                ", contractKey='" + contractKey + '\'' +
                ", payStagingTime=" + payStagingTime +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", accountContactAdress='" + accountContactAdress + '\'' +
                ", guaranteeName='" + guaranteeName + '\'' +
                ", guaranteeIdCard='" + guaranteeIdCard + '\'' +
                ", guaranteeContactAddress='" + guaranteeContactAddress + '\'' +
                ", thirdPartyLiabilityInsurance=" + thirdPartyLiabilityInsurance +
                ", cardCheckAcceptImg='" + cardCheckAcceptImg + '\'' +
                ", idCardImg='" + idCardImg + '\'' +
                ", carAcceptImg='" + carAcceptImg + '\'' +
                ", contractType=" + contractType +
                ", vsersionNumber=" + vsersionNumber +
                ", dealStatus='" + dealStatus + '\'' +
                ", backStatus=" + backStatus +
                ", parentId=" + parentId +
                ", sourceType=" + sourceType +
                ", priceDifference=" + priceDifference +
                ", guaranteeContact='" + guaranteeContact + '\'' +
                ", guaranteeContactName='" + guaranteeContactName + '\'' +
                ", guaranteeContactPhone='" + guaranteeContactPhone + '\'' +
                ", guaranteeZipCode='" + guaranteeZipCode + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", sort=" + sort +
                ", status=" + status +
                ", ids=" + ids +
                ", leaseContractArchiveLocationList=" + leaseContractArchiveLocationList +
                ", leaseContractArchiveLocationJson='" + leaseContractArchiveLocationJson + '\'' +
                ", leaseSchemeOrderAccounts=" + leaseSchemeOrderAccounts +
                ", leaseSchemeOrderAccountJson='" + leaseSchemeOrderAccountJson + '\'' +
                ", leaseSchemeRepaymentList=" + leaseSchemeRepaymentList +
                ", leaseSchemeRepaymentJson='" + leaseSchemeRepaymentJson + '\'' +
                ", leasePackageBalancePayments=" + leasePackageBalancePayments +
                ", leasePackageBalancePaymentJson='" + leasePackageBalancePaymentJson + '\'' +
                ", branchCompanyName='" + branchCompanyName + '\'' +
                ", contractPartyName='" + contractPartyName + '\'' +
                ", dealerName='" + dealerName + '\'' +
                ", comprehensiveQuote=" + comprehensiveQuote +
                ", brandsName='" + brandsName + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", businessModelName='" + businessModelName + '\'' +
                ", colorName='" + colorName + '\'' +
                ", schemeName='" + schemeName + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", cardId=" + cardId +
                ", schemeId=" + schemeId +
                ", sn='" + sn + '\'' +
                ", carPrice=" + carPrice +
                ", totleCarPrice=" + totleCarPrice +
                ", leasePrice=" + leasePrice +
                ", contractPartyId=" + contractPartyId +
                ", annualInterest=" + annualInterest +
                ", downPayment=" + downPayment +
                ", balancePayment=" + balancePayment +
                ", stagingNumberId=" + stagingNumberId +
                ", commission=" + commission +
                ", receiveMargin=" + receiveMargin +
                ", cardFrameNumber='" + cardFrameNumber + '\'' +
                ", carCondition=" + carCondition +
                ", engineNumber='" + engineNumber + '\'' +
                ", purchaseTax=" + purchaseTax +
                ", onPlateCost=" + onPlateCost +
                ", vehicleVesselTax=" + vehicleVesselTax +
                ", itemType='" + itemType + '\'' +
                ", monthlyRent=" + monthlyRent +
                ", completeModelName='" + completeModelName + '\'' +
                ", stagingNumberName='" + stagingNumberName + '\'' +
                ", leaseContractBaseinfo='" + leaseContractBaseinfo + '\'' +
                ", paymentResultCount=" + paymentResultCount +
                ", repaymentDate='" + repaymentDate + '\'' +
                ", period='" + period + '\'' +
                ", totlePrice=" + totlePrice +
                ", accountPhone='" + accountPhone + '\'' +
                ", overdueDay=" + overdueDay +
                ", repaymentDetails=" + repaymentDetails +
                ", type=" + type +
                ", isType=" + isType +
                ", contractBrandsId=" + contractBrandsId +
                ", contractSeriesId=" + contractSeriesId +
                ", contractModelId=" + contractModelId +
                ", contractBrandsName='" + contractBrandsName + '\'' +
                ", contractSeriesName='" + contractSeriesName + '\'' +
                ", contractBusinessModelName='" + contractBusinessModelName + '\'' +
                ", contractCompleteModelName='" + contractCompleteModelName + '\'' +
                ", totalAmount=" + totalAmount +
                ", bankCode='" + bankCode + '\'' +
                ", payDate=" + payDate +
                ", totalPrice=" + totalPrice +
                ", isPaying=" + isPaying +
                ", name='" + name + '\'' +
                ", baseInfoContractPartyName='" + baseInfoContractPartyName + '\'' +
                ", contractBranchCompany='" + contractBranchCompany + '\'' +
                ", contractPartyAdress='" + contractPartyAdress + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", importantEventPrice=" + importantEventPrice +
                ", checkTime='" + checkTime + '\'' +
                ", downPaymentTimeLimit='" + downPaymentTimeLimit + '\'' +
                ", loanDeposit=" + loanDeposit +
                ", appointArea='" + appointArea + '\'' +
                ", rentOverdueTimeLimit='" + rentOverdueTimeLimit + '\'' +
                ", carLesseeCity='" + carLesseeCity + '\'' +
                ", cityInsideRecoveryCost=" + cityInsideRecoveryCost +
                ", cityOutsideRecoveryCost=" + cityOutsideRecoveryCost +
                ", provinceInsideRecoveryCost=" + provinceInsideRecoveryCost +
                ", provinceOutsideRecoveryCost=" + provinceOutsideRecoveryCost +
                ", dayCustodianCost=" + dayCustodianCost +
                ", continuityOverdue='" + continuityOverdue + '\'' +
                ", cumulativeOverdue='" + cumulativeOverdue + '\'' +
                ", defaultInterest=" + defaultInterest +
                ", licenseMonthlyRent=" + licenseMonthlyRent +
                ", contractPartyContactAddress=" + contractPartyContactAddress +
                ", accountName='" + accountName + '\'' +
                ", bankId=" + bankId +
                ", branchBank='" + branchBank + '\'' +
                ", account='" + account + '\'' +
                ", remarks='" + remarks + '\'' +
                ", contractPartyContactAddressVoList=" + contractPartyContactAddressVoList +
                ", defaultInterestName='" + defaultInterestName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", baseInfoBranchCompanyId=" + baseInfoBranchCompanyId +
                ", baseInfoBranchCompanyName='" + baseInfoBranchCompanyName + '\'' +
                ", authorizedPerson='" + authorizedPerson + '\'' +
                ", partyA='" + partyA + '\'' +
                ", partyB='" + partyB + '\'' +
                ", partyC='" + partyC + '\'' +
                ", loanGuarantor='" + loanGuarantor + '\'' +
                ", guarantor='" + guarantor + '\'' +
                '}';
    }
}