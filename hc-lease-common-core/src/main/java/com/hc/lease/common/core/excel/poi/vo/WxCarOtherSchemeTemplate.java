package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * 创建时间：2018/4/11<br/>
 * 说明：小程序车辆方案EXCEL导入模板
 */
@Data
@CostCheckExcelCol("车辆1+X方案数据EXCEL导入")
public class WxCarOtherSchemeTemplate implements Serializable {

    @CostCheckExcelCol("车辆名称")
    private String carName;
    @CostCheckExcelCol("首付")
    private String downPayment;
    @CostCheckExcelCol("第一年月供")
    private String monthlyRent;
    @CostCheckExcelCol("第一年分期数")
    private Integer firstYearStagingNumber;
    @CostCheckExcelCol("尾款")
    private String balancePayment;
    @CostCheckExcelCol("尾款24期月供")
    private String stagingNumber24MonthlyRent;
    @CostCheckExcelCol("尾款36期月供")
    private String stagingNumber36MonthlyRent;

    @CostCheckExcelCol("导入结果")
    private String updateState;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }

    public String getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(String monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Integer getFirstYearStagingNumber() {
        return firstYearStagingNumber;
    }

    public void setFirstYearStagingNumber(Integer firstYearStagingNumber) {
        this.firstYearStagingNumber = firstYearStagingNumber;
    }

    public String getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(String balancePayment) {
        this.balancePayment = balancePayment;
    }

    public String getStagingNumber24MonthlyRent() {
        return stagingNumber24MonthlyRent;
    }

    public void setStagingNumber24MonthlyRent(String stagingNumber24MonthlyRent) {
        this.stagingNumber24MonthlyRent = stagingNumber24MonthlyRent;
    }

    public String getStagingNumber36MonthlyRent() {
        return stagingNumber36MonthlyRent;
    }

    public void setStagingNumber36MonthlyRent(String stagingNumber36MonthlyRent) {
        this.stagingNumber36MonthlyRent = stagingNumber36MonthlyRent;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }
}
