package com.hc.lease.account.vo;

import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.vo.EmergencyContactVo;
import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 承租人导入导出Excel
 */
@Data
public class LeaseAccountExcel implements Serializable {

    @ExcelAttribute(column = "A", name = "姓名(必填)")
    private String name;

    @ExcelAttribute(column = "B", name = "性别(必填)",spinnerParamName = "sexList")
    private String sex;

    @ExcelAttribute(column = "C", name = "联系手机(必填)")
    private String phone;

    @ExcelAttribute(column = "D", name = "其他手机")
    private String otherPhone;

    @ExcelAttribute(column = "E", name = "身份证号(必填)")
    private String idCard;

    @ExcelAttribute(column = "F", name = "婚姻状态" ,spinnerParamName = "maritalStatusList")
    private String maritalStatus;

    @ExcelAttribute(column = "G", name = "联系地址")
    private String idCardAddress;

    @ExcelAttribute(column = "H", name = "实际居住地址")
    private String liveAddress;

    @ExcelAttribute(column = "I", name = "邮编")
    private String zipCode;

    @ExcelAttribute(column = "J", name = "住房类型",dictType = "HousingType")
    private Long housingType;

   /* @ApiModelProperty(value = "住房类型为其他的描述 (个人类型承租人要此参数)", hidden = false)
    private String housingTypeOtherDescribe;*/

    @ExcelAttribute(column = "K", name = "配偶姓名")
    private String spouseName;

    @ExcelAttribute(column = "L", name = "配偶电话")
    private String spousePhone;

    @ExcelAttribute(column = "M", name = "配偶身份证号")
    private String spouseIdCard;

    @ExcelAttribute(column = "N", name = "工作单位")
    private String workUnit;

    @ExcelAttribute(column = "O", name = "工作单位固话")
    private String workUnitPhone;

    @ExcelAttribute(column = "P", name = "近半年月均收入")
    private String halfYearMonthIncome;

    @ExcelAttribute(column = "Q", name = "驾驶证号(必填)")
    private String driverLicenseNumber;

    private Object emergencyContact;

}