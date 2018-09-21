package com.hc.lease.order.model;

import java.io.Serializable;
import java.util.List;

public class LeaseSchemeOrderAccount implements Serializable {
    private Long id;

    private Long schemeOrderId;

    private Long accountId;

    private String accountName;

    private String accountContact;

    private Integer isDefaultPay;

    private String idCard;

    private String liveAddress;
    private String emergencyContact;
    private String branchBank;
    private String backCardNumber;
    private String phone;

    private String bankName;

    private List<Long> ids;

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
}