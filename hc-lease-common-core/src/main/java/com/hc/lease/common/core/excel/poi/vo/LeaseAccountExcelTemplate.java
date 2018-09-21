package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import com.hc.lease.common.core.excel.easyxls.annotation.ExcelSheet;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 承租人导入导出Excel
 */
@Data
public class LeaseAccountExcelTemplate implements Serializable {

    @ExcelAttribute(column = "A", name = "姓名(必填)")
    private String name;

    @ExcelAttribute(column = "B", name = "性别(必填)")
    private String sex;

    @ExcelAttribute(column = "C", name = "电话(必填)")
    private String phone;

    @ExcelAttribute(column = "D", name = "其他手机")
    private String otherPhone;

    @ExcelAttribute(column = "E", name = "身份证号(必填)")
    private String idCard;

    @ExcelAttribute(column = "F", name = "婚姻状态")
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

    @ExcelAttribute(column = "R", name = "导入结果")
    private String updateState;

    @ExcelSheet(classObj = EmergencyContactExcelTemplate.class, connectKey = "idCard", hostKey = "idCard", sheetName = "紧急联系人")
    private List<EmergencyContactExcelTemplate> emergencyContactExcelTemplates;


   /* @ExcelSheet(classObj = LeaseAccountBankExcelTemplate.class, connectKey = "phone", hostKey = "phone", sheetName = "承租人银行卡")
    private List<LeaseAccountBankExcelTemplate> leaseAccountBankExcelTemplates;*/

    //private Object emergencyContact;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }



    public String getIdCardAddress() {
        return idCardAddress;
    }

    public void setIdCardAddress(String idCardAddress) {
        this.idCardAddress = idCardAddress;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getHousingType() {
        return housingType;
    }

    public void setHousingType(Long housingType) {
        this.housingType = housingType;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpousePhone() {
        return spousePhone;
    }

    public void setSpousePhone(String spousePhone) {
        this.spousePhone = spousePhone;
    }

    public String getSpouseIdCard() {
        return spouseIdCard;
    }

    public void setSpouseIdCard(String spouseIdCard) {
        this.spouseIdCard = spouseIdCard;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getWorkUnitPhone() {
        return workUnitPhone;
    }

    public void setWorkUnitPhone(String workUnitPhone) {
        this.workUnitPhone = workUnitPhone;
    }

    public String getHalfYearMonthIncome() {
        return halfYearMonthIncome;
    }

    public void setHalfYearMonthIncome(String halfYearMonthIncome) {
        this.halfYearMonthIncome = halfYearMonthIncome;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }



    public List<EmergencyContactExcelTemplate> getEmergencyContactExcelTemplates() {
        return emergencyContactExcelTemplates;
    }

    public void setEmergencyContactExcelTemplates(List<EmergencyContactExcelTemplate> emergencyContactExcelTemplates) {
        this.emergencyContactExcelTemplates = emergencyContactExcelTemplates;
    }



}