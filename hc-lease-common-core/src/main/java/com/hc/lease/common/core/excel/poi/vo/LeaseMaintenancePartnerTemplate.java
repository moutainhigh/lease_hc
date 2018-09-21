package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;

public class LeaseMaintenancePartnerTemplate implements Serializable {

    @CostCheckExcelCol("名称")
    private String name;
    @CostCheckExcelCol("编号")
    private String number;
    @CostCheckExcelCol("省")
    private String provinceName;
    @CostCheckExcelCol("市")
    private String cityName;
    @CostCheckExcelCol("地址")
    private String address;
    @CostCheckExcelCol("联系电话")
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