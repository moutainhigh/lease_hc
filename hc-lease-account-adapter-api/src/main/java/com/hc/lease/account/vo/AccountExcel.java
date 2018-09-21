package com.hc.lease.account.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelSheet;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LZQ on 2018/3/14.
 */
@Data
public class AccountExcel implements Serializable {

    @ExcelSheet(classObj = LeaseAccountExcel.class, sheetName = "承租人信息")
    List<LeaseAccountExcel> leaseAccountExcels=new ArrayList<>();

    @ExcelSheet(classObj = LeaseAccountBankExcel.class, sheetName = "承租人银行卡")
    List<LeaseAccountBankExcel> accountBankExcels = new ArrayList<>();

    @ExcelSheet(classObj = EmergencyContactExcel.class, sheetName = "紧急联系人")
    List<EmergencyContactExcel> emergencyContactExcels=new ArrayList<>();



}
