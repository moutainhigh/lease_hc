package com.hc.lease.account.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelSheet;
import com.hc.lease.common.core.excel.poi.vo.EmergencyContactExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountBankExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountCompanyExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountExcelTemplate;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LZQ on 2018/3/14.
 */
@Data
public class AccountCompanyImportBackExcel implements Serializable {

    @ExcelSheet(classObj = LeaseAccountCompanyExcelTemplate.class, sheetName = "承租人信息")
    List<LeaseAccountCompanyExcelTemplate> leaseAccountCompanyExcels=new ArrayList<>();


}
