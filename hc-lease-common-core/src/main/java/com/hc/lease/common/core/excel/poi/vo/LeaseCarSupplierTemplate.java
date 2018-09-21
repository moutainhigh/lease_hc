package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;
import java.util.Date;

public class LeaseCarSupplierTemplate implements Serializable {

    @CostCheckExcelCol("名称")
    private String name;
    @CostCheckExcelCol("编号")
    private String internalNumber;
    @CostCheckExcelCol("组织机构号码")
    private String organizationNumber;
    @CostCheckExcelCol("地址")
    private String address;
    @CostCheckExcelCol("联系人")
    private String contacts;
    @CostCheckExcelCol("电话")
    private String contactPhone;
    @CostCheckExcelCol("手机")
    private String phone;
    @CostCheckExcelCol("开始合作日期")
    private Date cooperateTime;
  /*  @CostCheckExcelCol("供应商优势")
    private String advantage;*/
    @CostCheckExcelCol("备注")
    private String remarks;
    @CostCheckExcelCol("户名")
    private String accountName;
    @CostCheckExcelCol("发卡行")
    private String bankName;
    @CostCheckExcelCol("开户支行")
    private String branchBank;
    @CostCheckExcelCol("账号")
    private String account;
    @CostCheckExcelCol("导入结果")
    private String updateState;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(String internalNumber) {
        this.internalNumber = internalNumber;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getCooperateTime() {
        return cooperateTime;
    }

    public void setCooperateTime(Date cooperateTime) {
        this.cooperateTime = cooperateTime;
    }

  /*  public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }*/

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranchBank() {
        return branchBank;
    }

    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}