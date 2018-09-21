package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by LZQ on 2018/3/14.
 */
@Data
public class LeaseAccountBankExcelTemplate implements Serializable {

    @ExcelAttribute(column = "A", name = "身份证(必填)")
    private String idCard;

    @ExcelAttribute(column = "B", name = "户名(必填)")
    private String bankAccountName;

    @ExcelAttribute(column = "C", name = "银行(必填)")
    private String bankName;

    @ExcelAttribute(column = "D", name = "银行支行(必填)")
    private String branchBank;

    @ExcelAttribute(column = "E", name = "银行卡号(必填)")
    private String backCardNumber;

    @ExcelAttribute(column = "F", name = "银行预留手机号")
    private String bankPhone;

    @ExcelAttribute(column = "G", name = "导入结果")
    private String updateState;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchBank() {
        return branchBank;
    }

    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }
}





