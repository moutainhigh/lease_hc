package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;
import java.util.Date;

public class LeaseBranchCompanyTemplate implements Serializable {

    @CostCheckExcelCol("名称")
    private String name;
    @CostCheckExcelCol("编号")
    private String number;
    @CostCheckExcelCol("组织机构号码")
    private String organizationNumber;
    @CostCheckExcelCol("省")
    private String provinceName;
    @CostCheckExcelCol("市")
    private String cityName;
    @CostCheckExcelCol("地址")
    private String address;
    @CostCheckExcelCol("联系人")
    private String contacts;
    @CostCheckExcelCol("电话")
    private String contactPhone;
    @CostCheckExcelCol("手机")
    private String phone;
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