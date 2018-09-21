package com.hc.lease.account.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by LZQ on 2018/3/14.
 */
@Data
public class LeaseAccountBankExcel implements Serializable {

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

    @ExcelAttribute(column = "F", name = "银行预留手机号(必填)")
    private String bankPhone;

}





