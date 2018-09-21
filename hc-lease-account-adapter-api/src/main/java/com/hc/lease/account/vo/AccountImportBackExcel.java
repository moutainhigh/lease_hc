package com.hc.lease.account.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelSheet;
import com.hc.lease.common.core.excel.poi.vo.EmergencyContactExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountBankExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountExcelTemplate;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LZQ on 2018/3/14.
 */
@Data
public class AccountImportBackExcel implements Serializable {

    @ExcelSheet(classObj = LeaseAccountExcelTemplate.class, sheetName = "承租人信息")
    List<LeaseAccountExcelTemplate> leaseAccountExcels=new ArrayList<>();

    @ExcelSheet(classObj = LeaseAccountBankExcelTemplate.class, sheetName = "承租人银行卡")
    List<LeaseAccountBankExcelTemplate> accountBankExcels = new ArrayList<>();

    @ExcelSheet(classObj = EmergencyContactExcelTemplate.class, sheetName = "紧急联系人")
    List<EmergencyContactExcelTemplate> emergencyContactExcels=new ArrayList<>();

    public List<LeaseAccountExcelTemplate> getLeaseAccountExcels() {
        return leaseAccountExcels;
    }

    public void setLeaseAccountExcels(List<LeaseAccountExcelTemplate> leaseAccountExcels) {
        this.leaseAccountExcels = leaseAccountExcels;
    }

    public List<LeaseAccountBankExcelTemplate> getAccountBankExcels() {
        return accountBankExcels;
    }

    public void setAccountBankExcels(List<LeaseAccountBankExcelTemplate> accountBankExcels) {
        this.accountBankExcels = accountBankExcels;
    }

    public List<EmergencyContactExcelTemplate> getEmergencyContactExcels() {
        return emergencyContactExcels;
    }

    public void setEmergencyContactExcels(List<EmergencyContactExcelTemplate> emergencyContactExcels) {
        this.emergencyContactExcels = emergencyContactExcels;
    }
}
