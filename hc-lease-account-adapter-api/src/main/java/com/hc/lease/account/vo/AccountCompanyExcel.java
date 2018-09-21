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
public class AccountCompanyExcel implements Serializable {

    @ExcelSheet(classObj = LeaseAccountCompanyExcel.class, sheetName = "公司承租人信息")
    List<LeaseAccountCompanyExcel> leaseAccountCompanyExcels=new ArrayList<>();

}
