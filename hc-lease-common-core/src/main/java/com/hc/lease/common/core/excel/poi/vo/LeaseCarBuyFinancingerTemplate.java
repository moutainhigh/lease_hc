package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;
import java.math.BigDecimal;

public class LeaseCarBuyFinancingerTemplate implements Serializable {

    @CostCheckExcelCol("名称")
    private String name;
    @CostCheckExcelCol("编号")
    private String number;
    @CostCheckExcelCol("融资方式")
    private String financingModeName;
    @CostCheckExcelCol("融资比例")
    private BigDecimal financingProportion;
    @CostCheckExcelCol("融资额度")
    private BigDecimal financingQuota;
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

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }

    public String getFinancingModeName() {
        return financingModeName;
    }

    public void setFinancingModeName(String financingModeName) {
        this.financingModeName = financingModeName;
    }

    public BigDecimal getFinancingProportion() {
        return financingProportion;
    }

    public void setFinancingProportion(BigDecimal financingProportion) {
        this.financingProportion = financingProportion;
    }

    public BigDecimal getFinancingQuota() {
        return financingQuota;
    }

    public void setFinancingQuota(BigDecimal financingQuota) {
        this.financingQuota = financingQuota;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}