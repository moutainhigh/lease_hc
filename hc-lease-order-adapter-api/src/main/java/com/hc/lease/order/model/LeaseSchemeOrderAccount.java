package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseSchemeOrderAccount implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "融租订单id", hidden = false)
    private Long schemeOrderId;
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人联系", hidden = false)
    private String accountContact;
    @ApiModelProperty(value = "默认付款", hidden = false)
    private Integer isDefaultPay;
    @ApiModelProperty(value = "扣款银行卡主键id", hidden = false)
    private Long bankCardId;
    @ApiModelProperty(value = "身份证", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "联系地址", hidden = false)
    private String liveAddress;
    @ApiModelProperty(value = "身份证地址", hidden = false)
    private String idCardAddress;
    @ApiModelProperty(value = "紧急联系人", hidden = false)
    private String emergencyContact;
    @ApiModelProperty(value = "银行支行", hidden = false)
    private String branchBank;
    @ApiModelProperty(value = "联系地址", hidden = false)
    private String backCardNumber;
    private String phone;

    private String bankName;
//营业执照号
    private String businessLicenseNumber;
    //联系人
    private String contactsName;
    //联系地址
    private String contactsAddress;
    //公司注册地址
    private String companyRegistrationAddress;
    //类型
    private Integer accountType;

    private List<Long> ids;
    //银行编号
    private String bankCode;
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
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountContact() {
        return accountContact;
    }

    public void setAccountContact(String accountContact) {
        this.accountContact = accountContact == null ? null : accountContact.trim();
    }

    public Integer getIsDefaultPay() {
        return isDefaultPay;
    }

    public void setIsDefaultPay(Integer isDefaultPay) {
        this.isDefaultPay = isDefaultPay;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getBranchBank() {
        return branchBank;
    }

    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIdCardAddress() {
        return idCardAddress;
    }

    public void setIdCardAddress(String idCardAddress) {
        this.idCardAddress = idCardAddress;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsAddress() {
        return contactsAddress;
    }

    public void setContactsAddress(String contactsAddress) {
        this.contactsAddress = contactsAddress;
    }

    public String getCompanyRegistrationAddress() {
        return companyRegistrationAddress;
    }

    public void setCompanyRegistrationAddress(String companyRegistrationAddress) {
        this.companyRegistrationAddress = companyRegistrationAddress;
    }


    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Long getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(Long bankCardId) {
        this.bankCardId = bankCardId;
    }
}