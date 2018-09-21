package com.hc.lease.account.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 公司承租人导入导出Excel
 */
@Data
public class LeaseAccountCompanyExcel implements Serializable {

    @ExcelAttribute(column = "A", name = "公司名称(必填)")
    private String companyName;

    @ExcelAttribute(column = "B", name = "统一社会信用代码(必填)")
    private String businessLicenseNumber;

    @ExcelAttribute(column = "C", name = "注册地址(必填)")
    private String companyRegistrationAddress;

    @ExcelAttribute(column = "D", name = "联系人(必填)")
    private String contactsName;

    @ExcelAttribute(column = "E", name = "联系地址(必填)")
    private String contactsAddress;

    @ExcelAttribute(column = "F", name = "联系电话(必填)")
    private String contactsPhone;

    @ExcelAttribute(column = "G", name = "备注")
    private String remark;

    @ExcelAttribute(column = "H", name = "户名")
    private String bankAccountName;

    @ExcelAttribute(column = "I", name = "开户行")
    private String bankName;

    @ExcelAttribute(column = "J", name = "支行")
    private String branchBank;

    @ExcelAttribute(column = "K", name = "账号")
    private String backCardNumber;
















}