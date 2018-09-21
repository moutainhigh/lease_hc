package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;

public class LeaseArchiveLocationTemplate implements Serializable {

    @CostCheckExcelCol("名称")
    private String name;
    @CostCheckExcelCol("备注")
    private String remarks;
    @CostCheckExcelCol("预留列")
    private String address;
    @CostCheckExcelCol("导入结果")
    private String updateState;


    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}