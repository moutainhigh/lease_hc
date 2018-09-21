

package com.hc.lease.order.vo;

import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.order.model.LeaseSchemeOrderAccount;
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
}
