package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 创建人：tong<br/>
 * 创建时间：2018/1/10<br/>
 * 说明：小程序车辆方案EXCEL导入模板
 */
@Data
@CostCheckExcelCol("车辆方案数据EXCEL导入")
public class WxCarSchemeTemplate implements Serializable {

    @CostCheckExcelCol("车辆名称")
    private String carName;
    @ApiModelProperty(value = "首付", hidden = false)
    private String downPayment;
    @ApiModelProperty(value = "月供", hidden = false)
    private String monthlyRent;
    @ApiModelProperty(value = "尾付", hidden = false)
    private String balancePayment;
    @ApiModelProperty(value = "分期数", hidden = false)
    private Integer stagingNumber;
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

    public String getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(String balancePayment) {
        this.balancePayment = balancePayment;
    }

    public Integer getStagingNumber() {
        return stagingNumber;
    }

    public void setStagingNumber(Integer stagingNumber) {
        this.stagingNumber = stagingNumber;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }
}
