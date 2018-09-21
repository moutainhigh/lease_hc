package com.hc.lease.order.model;

import com.hc.lease.baseInfo.vo.ContractPartyContactAddressVo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 融租合同模板
 */
public class LeaseContractBaseinfoUse implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "模板名称", hidden = false)
    private String name;

    @ApiModelProperty(value = "出租人", hidden = false)
    private String contractPartyName;

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

    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人主键id", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人主键id", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;

    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Boolean isEnable;

    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    @ApiModelProperty(value = "出租人联系地址", hidden = false)
    private List<ContractPartyContactAddressVo> contractPartyContactAddressVoList;

    @ApiModelProperty(value = "提前还款罚息金额", hidden = false)
    private String defaultInterestName;

    @ApiModelProperty(value = "银行名称", hidden = false)
    private String bankName;

    @ApiModelProperty(value = "所属分公司主键id", hidden = false)
    private Long branchCompanyId;
    @ApiModelProperty(value = "所属分公司名称", hidden = false)
    private String branchCompanyName;

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

    @ApiModelProperty(value = "省份", hidden = false)
    private String provinceName;
    @ApiModelProperty(value = "市", hidden = false)
    private String cityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractPartyName() {
        return contractPartyName;
    }

    public void setContractPartyName(String contractPartyName) {
        this.contractPartyName = contractPartyName == null ? null : contractPartyName.trim();
    }

    public String getContractBranchCompany() {
        return contractBranchCompany;
    }

    public void setContractBranchCompany(String contractBranchCompany) {
        this.contractBranchCompany = contractBranchCompany == null ? null : contractBranchCompany.trim();
    }

    public String getContractPartyAdress() {
        return contractPartyAdress;
    }

    public void setContractPartyAdress(String contractPartyAdress) {
        this.contractPartyAdress = contractPartyAdress == null ? null : contractPartyAdress.trim();
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
        this.downPaymentTimeLimit = downPaymentTimeLimit == null ? null : downPaymentTimeLimit.trim();
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
        this.appointArea = appointArea == null ? null : appointArea.trim();
    }

    public String getRentOverdueTimeLimit() {
        return rentOverdueTimeLimit;
    }

    public void setRentOverdueTimeLimit(String rentOverdueTimeLimit) {
        this.rentOverdueTimeLimit = rentOverdueTimeLimit == null ? null : rentOverdueTimeLimit.trim();
    }

    public String getCarLesseeCity() {
        return carLesseeCity;
    }

    public void setCarLesseeCity(String carLesseeCity) {
        this.carLesseeCity = carLesseeCity == null ? null : carLesseeCity.trim();
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
        this.cumulativeOverdue = cumulativeOverdue == null ? null : cumulativeOverdue.trim();
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

    public List<ContractPartyContactAddressVo> getContractPartyContactAddressVoList() {
        return contractPartyContactAddressVoList;
    }

    public void setContractPartyContactAddressVoList(List<ContractPartyContactAddressVo> contractPartyContactAddressVoList) {
        this.contractPartyContactAddressVoList = contractPartyContactAddressVoList;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
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
        this.account = account == null ? null : account.trim();
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

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
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

    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public BigDecimal getProvinceOutsideRecoveryCost() {
        return provinceOutsideRecoveryCost;
    }

    public void setProvinceOutsideRecoveryCost(BigDecimal provinceOutsideRecoveryCost) {
        this.provinceOutsideRecoveryCost = provinceOutsideRecoveryCost;
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
}