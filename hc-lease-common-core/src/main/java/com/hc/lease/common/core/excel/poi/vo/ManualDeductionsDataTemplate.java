package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建人：tong<br/>
 * 创建时间：2018/7/6<br/>
 * 说明：手动扣款提交的数据EXCEL
 */
@Data
@CostCheckExcelCol("手动扣款提交的数据EXCEL")
public class ManualDeductionsDataTemplate implements Serializable {

    @CostCheckExcelCol("所属分公司")
    private String branchCompany;
    @CostCheckExcelCol("银行卡用户名")
    private String bankAccountName;
    @CostCheckExcelCol("银行预留手机号")
    private String bankPhone;
    @CostCheckExcelCol("银行编号")
    private String bankCode;
    @CostCheckExcelCol("银行账号")
    private String backCardNumber;
    @CostCheckExcelCol("身份证号")
    private String idCard;
    @CostCheckExcelCol("总金额")
    private BigDecimal totalPrice;
    @CostCheckExcelCol("车牌号")
    private String plateNumber;
    @CostCheckExcelCol("扣款日期")
    private Date repaymentDate;
    @CostCheckExcelCol("逾期天数")
    private Integer overdueDay;

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

}
