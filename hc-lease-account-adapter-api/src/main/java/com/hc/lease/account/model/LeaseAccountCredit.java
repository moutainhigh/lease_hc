package com.hc.lease.account.model;

import com.hc.lease.account.vo.EmergencyContactVo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 个人类型用户/承租人
 */
public class LeaseAccountCredit implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "注册用户/承租人主键id", hidden = false)
    private Long accountId;

    @ApiModelProperty(value = "身份证地址", hidden = false)
    private String idCardAddress;

    @ApiModelProperty(value = "实际居住地址", hidden = false)
    private String liveAddress;

    @ApiModelProperty(value = "邮编", hidden = false)
    private String zipCode;

    @ApiModelProperty(value = "住房类型 0:自有无贷款;1:自有有贷款;2:租房;3:其他/字典表的住房类型", hidden = false)
    private Long housingType;

    @ApiModelProperty(value = "住房类型为其他的描述", hidden = false)
    private String housingTypeOtherDescribe;

    @ApiModelProperty(value = "配偶姓名", hidden = false)
    private String spouseName;

    @ApiModelProperty(value = "配偶电话", hidden = false)
    private String spousePhone;

    @ApiModelProperty(value = "配偶身份证号", hidden = false)
    private String spouseIdCard;

    @ApiModelProperty(value = "配偶身份证照片正面", hidden = false)
    private String spouseIdCardImgObverseSid;

    @ApiModelProperty(value = "配偶身份证照片反面", hidden = false)
    private String spouseIdCardImgReverseSid;

    @ApiModelProperty(value = "结婚证照片", hidden = false)
    private String marriageCertificateImg;

    @ApiModelProperty(value = "紧急联系人/json格式存放多个联系人/包括:紧急联系人姓名(Emergency_Contact_Name)；紧急联系人与本人关系(Emergency_Contact_Relationship)；急联系人手机(Emergency_Contact_Phone)", hidden = false)
    private Object emergencyContact;

    @ApiModelProperty(value = "工作单位", hidden = false)
    private String workUnit;

    @ApiModelProperty(value = "工作单位固话", hidden = false)
    private String workUnitPhone;

    @ApiModelProperty(value = "近半年月均收入", hidden = false)
    private String halfYearMonthIncome;

    @ApiModelProperty(value = "身份证号", hidden = false)
    private String idCard;

    @ApiModelProperty(value = "身份证照片正面", hidden = false)
    private String idCardImgObverseSide;

    @ApiModelProperty(value = "身份证照片反面", hidden = false)
    private String idCardImgReverseSide;

    @ApiModelProperty(value = "驾驶证号", hidden = false)
    private String driverLicenseNumber;

    @ApiModelProperty(value = "驾驶证照片", hidden = false)
    private String driverLicenseImg;

    @ApiModelProperty(value = "驾驶证照片副本", hidden = false)
    private String driverLicenseCounterpartImg;

    @ApiModelProperty(value = "银行卡发卡行", hidden = false)
    private Long bankId;

    @ApiModelProperty(value = "支行信息", hidden = false)
    private String branchBank;

    @ApiModelProperty(value = "银行卡号", hidden = false)
    private String backCardNumber;

    @ApiModelProperty(value = "银行卡照片", hidden = false)
    private String backCardImg;

    @ApiModelProperty(value = "银行对账单照片", hidden = false)
    private String bankStatementImg;

    @ApiModelProperty(value = "银行对账单照片/接收多张图片", hidden = false)
    private List<String> bankStatementImgs;

    @ApiModelProperty(value = "收入证明照片", hidden = false)
    private String earningsProofImg;

    @ApiModelProperty(value = "网约车应收流水截图", hidden = false)
    private String netCarReceivableLogImg;

    @ApiModelProperty(value = "近三个月通信清单照片", hidden = false)
    private String communicationListImg;

    @ApiModelProperty(value = "征信授权书照片", hidden = false)
    private String attoneyPowerImg;

    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "紧急联系人/json格式存放多个联系人/包括:顺序(Sort)；紧急联系人姓名(Emergency_Contact_Name)；紧急联系人与本人关系(Emergency_Contact_Relationship)；急联系人手机(Emergency_Contact_Phone)", hidden = false)
    private List<EmergencyContactVo> emergencyContactVoList;

    @ApiModelProperty(value = "其他手机", hidden = false)
    private String otherPhone;

/*

    public static class Builder  {
        private Long createBy;
        private String driverLicenseImg;

        public Builder createBy(Long createBy) {
            this.createBy = createBy;
            return this;
        }

        public LeaseAccountCredit build() {
            return new LeaseAccountCredit (this);
        }
    }

    private LeaseAccountCredit(Builder builder) {
        this.createBy = builder.createBy;
    }
*/























    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getIdCardAddress() {
        return idCardAddress;
    }

    public void setIdCardAddress(String idCardAddress) {
        this.idCardAddress = idCardAddress == null ? null : idCardAddress.trim();
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress == null ? null : liveAddress.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public Long getHousingType() {
        return housingType;
    }

    public void setHousingType(Long housingType) {
        this.housingType = housingType;
    }

    public String getHousingTypeOtherDescribe() {
        return housingTypeOtherDescribe;
    }

    public void setHousingTypeOtherDescribe(String housingTypeOtherDescribe) {
        this.housingTypeOtherDescribe = housingTypeOtherDescribe == null ? null : housingTypeOtherDescribe.trim();
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName == null ? null : spouseName.trim();
    }

    public String getSpousePhone() {
        return spousePhone;
    }

    public void setSpousePhone(String spousePhone) {
        this.spousePhone = spousePhone == null ? null : spousePhone.trim();
    }

    public String getSpouseIdCard() {
        return spouseIdCard;
    }

    public void setSpouseIdCard(String spouseIdCard) {
        this.spouseIdCard = spouseIdCard == null ? null : spouseIdCard.trim();
    }

    public String getSpouseIdCardImgObverseSid() {
        return spouseIdCardImgObverseSid;
    }

    public void setSpouseIdCardImgObverseSid(String spouseIdCardImgObverseSid) {
        this.spouseIdCardImgObverseSid = spouseIdCardImgObverseSid == null ? null : spouseIdCardImgObverseSid.trim();
    }

    public String getSpouseIdCardImgReverseSid() {
        return spouseIdCardImgReverseSid;
    }

    public void setSpouseIdCardImgReverseSid(String spouseIdCardImgReverseSid) {
        this.spouseIdCardImgReverseSid = spouseIdCardImgReverseSid == null ? null : spouseIdCardImgReverseSid.trim();
    }

    public String getMarriageCertificateImg() {
        return marriageCertificateImg;
    }

    public void setMarriageCertificateImg(String marriageCertificateImg) {
        this.marriageCertificateImg = marriageCertificateImg == null ? null : marriageCertificateImg.trim();
    }

    public Object getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Object emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    public String getWorkUnitPhone() {
        return workUnitPhone;
    }

    public void setWorkUnitPhone(String workUnitPhone) {
        this.workUnitPhone = workUnitPhone == null ? null : workUnitPhone.trim();
    }

    public String getHalfYearMonthIncome() {
        return halfYearMonthIncome;
    }

    public void setHalfYearMonthIncome(String halfYearMonthIncome) {
        this.halfYearMonthIncome = halfYearMonthIncome == null ? null : halfYearMonthIncome.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getIdCardImgObverseSide() {
        return idCardImgObverseSide;
    }

    public void setIdCardImgObverseSide(String idCardImgObverseSide) {
        this.idCardImgObverseSide = idCardImgObverseSide == null ? null : idCardImgObverseSide.trim();
    }

    public String getIdCardImgReverseSide() {
        return idCardImgReverseSide;
    }

    public void setIdCardImgReverseSide(String idCardImgReverseSide) {
        this.idCardImgReverseSide = idCardImgReverseSide == null ? null : idCardImgReverseSide.trim();
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber == null ? null : driverLicenseNumber.trim();
    }

    public String getDriverLicenseImg() {
        return driverLicenseImg;
    }

    public void setDriverLicenseImg(String driverLicenseImg) {
        this.driverLicenseImg = driverLicenseImg == null ? null : driverLicenseImg.trim();
    }

    public String getDriverLicenseCounterpartImg() {
        return driverLicenseCounterpartImg;
    }

    public void setDriverLicenseCounterpartImg(String driverLicenseCounterpartImg) {
        this.driverLicenseCounterpartImg = driverLicenseCounterpartImg;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId == null ? null : bankId;
    }

    public String getBranchBank() {
        return branchBank;
    }

    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank == null ? null : branchBank.trim();
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber == null ? null : backCardNumber.trim();
    }

    public String getBackCardImg() {
        return backCardImg;
    }

    public void setBackCardImg(String backCardImg) {
        this.backCardImg = backCardImg == null ? null : backCardImg.trim();
    }

    public String getBankStatementImg() {
        return bankStatementImg;
    }

    public void setBankStatementImg(String bankStatementImg) {
        this.bankStatementImg = bankStatementImg == null ? null : bankStatementImg.trim();
    }

    public List<String> getBankStatementImgs() {
        return bankStatementImgs;
    }

    public void setBankStatementImgs(List<String> bankStatementImgs) {
        this.bankStatementImgs = bankStatementImgs;
    }

    public String getEarningsProofImg() {
        return earningsProofImg;
    }

    public void setEarningsProofImg(String earningsProofImg) {
        this.earningsProofImg = earningsProofImg == null ? null : earningsProofImg.trim();
    }

    public String getNetCarReceivableLogImg() {
        return netCarReceivableLogImg;
    }

    public void setNetCarReceivableLogImg(String netCarReceivableLogImg) {
        this.netCarReceivableLogImg = netCarReceivableLogImg == null ? null : netCarReceivableLogImg.trim();
    }

    public String getCommunicationListImg() {
        return communicationListImg;
    }

    public void setCommunicationListImg(String communicationListImg) {
        this.communicationListImg = communicationListImg == null ? null : communicationListImg.trim();
    }

    public String getAttoneyPowerImg() {
        return attoneyPowerImg;
    }

    public void setAttoneyPowerImg(String attoneyPowerImg) {
        this.attoneyPowerImg = attoneyPowerImg == null ? null : attoneyPowerImg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public List<EmergencyContactVo> getEmergencyContactVoList() {
        return emergencyContactVoList;
    }

    public void setEmergencyContactVoList(List<EmergencyContactVo> emergencyContactVoList) {
        this.emergencyContactVoList = emergencyContactVoList;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }
}