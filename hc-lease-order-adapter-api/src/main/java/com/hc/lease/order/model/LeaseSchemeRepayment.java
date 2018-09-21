package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LeaseSchemeRepayment implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long lesseeId;
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
    private Integer overdue;
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;
    @ApiModelProperty(value = "贷款金额", hidden = false)
    private BigDecimal loanAmount;
    @ApiModelProperty(value = "年利率", hidden = false)
    private BigDecimal annualInterest;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "合同总分期数", hidden = false)
    private Integer stagingNumber;

    @ApiModelProperty(value = "融租合同号", hidden = false)
    private String contractNumber;
    @ApiModelProperty(value = "承租人姓名", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人手机", hidden = false)
    private String phone;
    @ApiModelProperty(value = "承租人姓名", hidden = false)
    private String accountRealName;
    @ApiModelProperty(value = "银行卡号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "身份证号", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "银行名称", hidden = false)
    private String bankName;
    @ApiModelProperty(value = "银行编码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "分公司名称", hidden = false)
    private String companyName;
    @ApiModelProperty(value = "省份主键id", hidden = false)
    private Long provinceId;
    @ApiModelProperty(value = "城市主键id", hidden = false)
    private Long cityId;
    @ApiModelProperty(value = "省份名称", hidden = false)
    private String provinceName;
    @ApiModelProperty(value = "城市名称", hidden = false)
    private String cityName;
    @ApiModelProperty(value = "金额合计", hidden = false)
    private BigDecimal totalCount;
    @ApiModelProperty(value = "总条数", hidden = false)
    private Integer itemCount;

    @ApiModelProperty(value = "还款日期", hidden = false)
    private String repaymentDateStr;

    @ApiModelProperty(value = "记录序号 通联批量代收 每条数据的 序号", hidden = false)
    private String sn;

    @ApiModelProperty(value = "期数", hidden = false)
    private String totalPeriod;

    @ApiModelProperty(value = "滞纳金日息利率", hidden = false)
    private BigDecimal overdueRate;

    @ApiModelProperty(value = "尾付", hidden = false)
    private BigDecimal balancePayment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Long lesseeId) {
        this.lesseeId = lesseeId;
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

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
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

    public Integer getStagingNumber() {
        return stagingNumber;
    }

    public void setStagingNumber(Integer stagingNumber) {
        this.stagingNumber = stagingNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountRealName() {
        return accountRealName;
    }

    public void setAccountRealName(String accountRealName) {
        this.accountRealName = accountRealName;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getRepaymentDateStr() {
        return repaymentDateStr;
    }

    public void setRepaymentDateStr(String repaymentDateStr) {
        this.repaymentDateStr = repaymentDateStr;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(String totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

}