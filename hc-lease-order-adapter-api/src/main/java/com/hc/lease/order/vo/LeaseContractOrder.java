

package com.hc.lease.order.vo;

import com.hc.lease.baseInfo.vo.ContractPartyContactAddressVo;
import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import com.hc.lease.supplier.model.LeasePackageBalancePayment;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public class LeaseContractOrder implements Serializable{
//leaseContract
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
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
   /* @ApiModelProperty(value = "收到首期日期", hidden = false)
    private Date payStagingTime;*/
    @ApiModelProperty(value = "租赁起始日期", hidden = false)
    private Date leaseStartTime;
    @ApiModelProperty(value = "租赁结束日期", hidden = false)
    private Date leaseEndTime;
   /* @ApiModelProperty(value = "", hidden = false)
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

    @ApiModelProperty(value = "合同类型（1 标准 2 准合同）", hidden = false)
    private Integer contractType ;
    @ApiModelProperty(value = "数据版本号", hidden = false)
    private Integer vsersionNumber ;

//leaseSchemeOrder
    @ApiModelProperty(value = "订单号", hidden = false)
    private String sn;
    @ApiModelProperty(value = "融租方案主键Id", hidden = false)
    private Long schemeId;
    @ApiModelProperty(value = "车辆主键Id", hidden = false)
    private Long cardId;
    @ApiModelProperty(value = "汽车价格", hidden = false)
    private BigDecimal carPrice;
    @ApiModelProperty(value = "全包价（元）", hidden = false)
    private BigDecimal totleCarPrice;
    @ApiModelProperty(value = "客户综合报价", hidden = false)
    private BigDecimal comprehensiveQuote;
    @ApiModelProperty(value = "租金总额", hidden = false)
    private BigDecimal leasePrice;
    @ApiModelProperty(value = "出租人/合同方主键id", hidden = false)
    private Long contractPartyId;
    @ApiModelProperty(value = "渠道佣金", hidden = false)
    private BigDecimal commission;
    @ApiModelProperty(value = "实收保证金", hidden = false)
    private BigDecimal receiveMargin;
    @ApiModelProperty(value = "品牌主键Id/适用车型", hidden = false)
    private Long contractBrandsId;
    @ApiModelProperty(value = "系列主键Id/适用车型", hidden = false)
    private Long contractSeriesId;
    @ApiModelProperty(value = "车型主键Id/适用车型", hidden = false)
    private Long contractModelId;

//leaseContractArchiveLocation

    @ApiModelProperty(value = "归档位置实体", hidden = false)
    private List<LeaseContractArchiveLocation>  leaseContractArchiveLocationList;

//leaseScheme
    @ApiModelProperty(value = "方案名称", hidden = false)
    private String schemeName;
    @ApiModelProperty(value = "全包价", hidden = false)
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "方案可选类型/字典表的数据 ; 首款尾款绝对值  或 融资比例", hidden = false)
    private Integer schemeType;
    @ApiModelProperty(value = "品牌主键Id/适用车型", hidden = false)
    private Long brandsId;
    @ApiModelProperty(value = "系列主键Id/适用车型", hidden = false)
    private Long seriesId;
    @ApiModelProperty(value = "车型主键Id/适用车型", hidden = false)
    private Long modelId;
    @ApiModelProperty(value = "融租方案类型（1:标准 2 年度尾款）", hidden = false)
    private Integer isType;

    @ApiModelProperty(value = "融租方案尾款实体类", hidden = false)
    private List<LeasePackageBalancePayment> leasePackageBalancePayments;


    //leasePackage
    @ApiModelProperty(value = "首期金额", hidden = false)
    private BigDecimal downPayment;
    @ApiModelProperty(value = "尾款", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "分期数/字典表的分期数主键id", hidden = false)
    private Integer stagingNumberId;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;

    @ApiModelProperty(value = "首期包含第1个月租金 0 是 1 否", hidden = false)
    private Integer stagingContainMonthlyRent;
    @ApiModelProperty(value = "客户经理/渠道备注", hidden = false)
    private String clientManagerRemarks;
    @ApiModelProperty(value = "类型 0:默认套餐;1:定制套餐", hidden = false)
    private Integer type;

    //融租方案申请订单-承租人
  /*  @ApiModelProperty(value = "注册用户/下单人/承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "注册用户/下单人/承租人姓名", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "注册用户/下单人/承租人联系方式", hidden = false)
    private String accountContact;*/
    @ApiModelProperty(value = "承租人实体类List", hidden = false)
    private List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts;

    //融租合同-还款

    @ApiModelProperty(value = "分期数", hidden = false)
    private Integer period;
    @ApiModelProperty(value = "归还本金", hidden = false)
    private BigDecimal returnPrincipal;
    @ApiModelProperty(value = "归还利息", hidden = false)
    private BigDecimal returnInterest;
    @ApiModelProperty(value = "合计", hidden = false)
    private BigDecimal total;
    @ApiModelProperty(value = "剩余本金", hidden = false)
    private BigDecimal residualPrincipal;
    @ApiModelProperty(value = "还款日期", hidden = false)
    private Date repaymentDate;
    @ApiModelProperty(value = "还款结束日期(仅做接收不处理)", hidden = false)
    private Date repaymentEndDate;
    @ApiModelProperty(value = "是否逾期 0是 1否", hidden = false)
    private Short overdue;
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;
    @ApiModelProperty(value = "扣款状态 0未付款 1已付款", hidden = false)
    private Short paymentResult;
    @ApiModelProperty(value = "贷款金额", hidden = false)
    private BigDecimal loanAmount;
    @ApiModelProperty(value = "年利率", hidden = false)
    private BigDecimal annualInterest;


    //融租合同模板

    @ApiModelProperty(value = "模板名称", hidden = false)
    private String name;
    @ApiModelProperty(value = "模板所属分公司", hidden = false)
    private Long baseInfoBranchCompanyId;

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

    @ApiModelProperty(value = "被授权人", hidden = false)
    private String authorizedPerson;
    @ApiModelProperty(value = "甲方", hidden = false)
    private String partyA;
    @ApiModelProperty(value = "乙方", hidden = false)
    private String partyB;
    @ApiModelProperty(value = "丙方", hidden = false)
    private  String partyC;
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



    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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




    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName == null ? null : schemeName.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(Integer schemeType) {
        this.schemeType = schemeType;
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

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getClientManagerRemarks() {
        return clientManagerRemarks;
    }

    public void setClientManagerRemarks(String clientManagerRemarks) {
        this.clientManagerRemarks = clientManagerRemarks == null ? null : clientManagerRemarks.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public Integer getStagingNumberId() {
        return stagingNumberId;
    }

    public void setStagingNumberId(Integer stagingNumberId) {
        this.stagingNumberId = stagingNumberId;
    }


    public Integer getStagingContainMonthlyRent() {
        return stagingContainMonthlyRent;
    }

    public void setStagingContainMonthlyRent(Integer stagingContainMonthlyRent) {
        this.stagingContainMonthlyRent = stagingContainMonthlyRent;
    }

    public List<LeaseContractArchiveLocation> getLeaseContractArchiveLocationList() {
        return leaseContractArchiveLocationList;
    }

    public void setLeaseContractArchiveLocationList(List<LeaseContractArchiveLocation> leaseContractArchiveLocationList) {
        this.leaseContractArchiveLocationList = leaseContractArchiveLocationList;
    }



    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getReturnPrincipal() {
        return returnPrincipal;
    }

    public void setReturnPrincipal(BigDecimal returnPrincipal) {
        this.returnPrincipal = returnPrincipal;
    }

    public BigDecimal getReturnInterest() {
        return returnInterest;
    }

    public void setReturnInterest(BigDecimal returnInterest) {
        this.returnInterest = returnInterest;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getResidualPrincipal() {
        return residualPrincipal;
    }

    public void setResidualPrincipal(BigDecimal residualPrincipal) {
        this.residualPrincipal = residualPrincipal;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Short getOverdue() {
        return overdue;
    }

    public void setOverdue(Short overdue) {
        this.overdue = overdue;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public Short getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Short paymentResult) {
        this.paymentResult = paymentResult;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public List<LeaseSchemeOrderAccount> getLeaseSchemeOrderAccounts() {
        return leaseSchemeOrderAccounts;
    }

    public void setLeaseSchemeOrderAccounts(List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts) {
        this.leaseSchemeOrderAccounts = leaseSchemeOrderAccounts;
    }

    public BigDecimal getComprehensiveQuote() {
        return comprehensiveQuote;
    }

    public void setComprehensiveQuote(BigDecimal comprehensiveQuote) {
        this.comprehensiveQuote = comprehensiveQuote;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }

    public Long getContractBaseinfoId() {
        return contractBaseinfoId;
    }

    public void setContractBaseinfoId(Long contractBaseinfoId) {
        this.contractBaseinfoId = contractBaseinfoId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



    public String getBaseInfoContractPartyName() {
        return baseInfoContractPartyName;
    }

    public void setBaseInfoContractPartyName(String baseInfoContractPartyName) {
        this.baseInfoContractPartyName = baseInfoContractPartyName;
    }

    public Long getBaseInfoBranchCompanyId() {
        return baseInfoBranchCompanyId;
    }

    public void setBaseInfoBranchCompanyId(Long baseInfoBranchCompanyId) {
        this.baseInfoBranchCompanyId = baseInfoBranchCompanyId;
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

    public Integer getIsType() {
        return isType;
    }

    public void setIsType(Integer isType) {
        this.isType = isType;
    }

    public List<LeasePackageBalancePayment> getLeasePackageBalancePayments() {
        return leasePackageBalancePayments;
    }

    public void setLeasePackageBalancePayments(List<LeasePackageBalancePayment> leasePackageBalancePayments) {
        this.leasePackageBalancePayments = leasePackageBalancePayments;
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

    public Date getRepaymentEndDate() {
        return repaymentEndDate;
    }

    public void setRepaymentEndDate(Date repaymentEndDate) {
        this.repaymentEndDate = repaymentEndDate;
    }
}
