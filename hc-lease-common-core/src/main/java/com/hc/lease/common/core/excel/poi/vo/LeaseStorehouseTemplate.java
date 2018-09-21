package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;

public class LeaseStorehouseTemplate implements Serializable {

    @CostCheckExcelCol("名称")
    private String name;
    @CostCheckExcelCol("编号")
    private String number;
    @CostCheckExcelCol("所属分公司")
    private String companyName;
    @CostCheckExcelCol("最大停车量")
    private String maxCardSum;
    @CostCheckExcelCol("联系人")
    private String contacts;
    @CostCheckExcelCol("联系人电话")
    private String contactPhone;
    @CostCheckExcelCol("地址")
    private String address;
    @CostCheckExcelCol("备注")
    private String remarks;
    @CostCheckExcelCol("导入结果")
    private String updateState;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMaxCardSum() {
        return maxCardSum;
    }

    public void setMaxCardSum(String maxCardSum) {
        this.maxCardSum = maxCardSum;
    }
}