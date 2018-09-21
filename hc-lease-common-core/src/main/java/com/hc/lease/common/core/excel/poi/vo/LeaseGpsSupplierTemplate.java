package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;
import java.util.Date;

public class LeaseGpsSupplierTemplate implements Serializable {

    @CostCheckExcelCol("名称")
    private String name;
    @CostCheckExcelCol("编号")
    private String number;
    @CostCheckExcelCol("GPS成本")
    private String gpsCost;
    @CostCheckExcelCol("联系人")
    private String contacts;
    @CostCheckExcelCol("联系手机")
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

    public String getGpsCost() {
        return gpsCost;
    }

    public void setGpsCost(String gpsCost) {
        this.gpsCost = gpsCost;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}