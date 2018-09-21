package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;
import java.util.Date;

public class LeaseCarBrandSeriesTemplate implements Serializable {

    @CostCheckExcelCol("品牌")
    private String brandName;
    @CostCheckExcelCol("系列")
    private String seriesName;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}