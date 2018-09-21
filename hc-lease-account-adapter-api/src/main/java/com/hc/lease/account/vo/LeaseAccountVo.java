package com.hc.lease.account.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ApiModelProperty注解用于swagger
 * 注册用户/承租人
 */
public class LeaseAccountVo implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "用户名称/姓名", hidden = false)
    private String name;

    @ApiModelProperty(value = "性别:0:女,1:男", hidden = false)
    private Integer sex;

    @ApiModelProperty(value = "手机号(账号)", hidden = false)
    private String phone;

    @ApiModelProperty(value = "身份证号", hidden = false)
    private String idCard;

    @ApiModelProperty(value = "婚姻状态 0:已婚;1:未婚;3:其他", hidden = false)
    private Integer maritalStatus;

    @ApiModelProperty(value = "真实姓名", hidden = false)
    private String realName;

    @ApiModelProperty(value = "密码", hidden = false)
    private String password;

    @ApiModelProperty(value = "头像", hidden = false)
    private String icon;

    @ApiModelProperty(value = "省份ID", hidden = false)
    private Long provinceId;

    @ApiModelProperty(value = "省份名称", hidden = false)
    private String provinceName;

    @ApiModelProperty(value = "城市ID", hidden = false)
    private Long cityId;

    @ApiModelProperty(value = "城市名称", hidden = false)
    private String cityName;

    @ApiModelProperty(value = "区域ID", hidden = false)
    private Long areaId;

    @ApiModelProperty(value = "区域名称", hidden = false)
    private String areaName;

    @ApiModelProperty(value = "详细地址", hidden = false)
    private String address;

    @ApiModelProperty(value = "0锁定 1正常 2注销", hidden = false)
    private Integer status;

    @ApiModelProperty(value = "联系人", hidden = false)
    private String contacts;

    @ApiModelProperty(value = "联系方式", hidden = false)
    private String contactInformation;

    @ApiModelProperty(value = "注册渠道0:APP;1:微信;2:官网", hidden = false)
    private Integer regWay;

    @ApiModelProperty(value = "公司名称(客户)", hidden = false)
    private String companyName;

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

    @ApiModelProperty(value = "身份证照片正面", hidden = false)
    private String idCardImgObverseSide;

    @ApiModelProperty(value = "身份证照片反面", hidden = false)
    private String idCardImgReverseSide;

    @ApiModelProperty(value = "驾驶证号", hidden = false)
    private String driverLicenseNumber;

    @ApiModelProperty(value = "驾驶证照片", hidden = false)
    private String driverLicenseImg;

    @ApiModelProperty(value = "银行卡发卡行", hidden = false)
    private String bankId;

    @ApiModelProperty(value = "支行信息", hidden = false)
    private String branchBank;

    @ApiModelProperty(value = "银行卡号", hidden = false)
    private String backCardNumber;

    @ApiModelProperty(value = "银行卡照片", hidden = false)
    private String backCardImg;

    @ApiModelProperty(value = "银行对账单照片", hidden = false)
    private String bankStatementImg;

    @ApiModelProperty(value = "收入证明照片", hidden = false)
    private String earningsProofImg;

    @ApiModelProperty(value = "网约车应收流水截图", hidden = false)
    private String netCarReceivableLogImg;

    @ApiModelProperty(value = "近三个月通信清单照片", hidden = false)
    private String communicationListImg;

    @ApiModelProperty(value = "征信授权书照片", hidden = false)
    private String attoneyPowerImg;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    @ApiModelProperty(value = "创建日期/注册日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "紧急联系人/json格式存放多个联系人/包括:紧急联系人姓名(Emergency_Contact_Name)；紧急联系人与本人关系(Emergency_Contact_Relationship)；急联系人手机(Emergency_Contact_Phone)", hidden = false)
    private List<EmergencyContactVo> emergencyContactVoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Integer getRegWay() {
        return regWay;
    }

    public void setRegWay(Integer regWay) {
        this.regWay = regWay;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getHousingTypeOtherDescribe() {
        return housingTypeOtherDescribe;
    }

    public void setHousingTypeOtherDescribe(String housingTypeOtherDescribe) {
        this.housingTypeOtherDescribe = housingTypeOtherDescribe;
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

    public String getSpouseIdCardImgObverseSid() {
        return spouseIdCardImgObverseSid;
    }

    public void setSpouseIdCardImgObverseSid(String spouseIdCardImgObverseSid) {
        this.spouseIdCardImgObverseSid = spouseIdCardImgObverseSid;
    }

    public String getSpouseIdCardImgReverseSid() {
        return spouseIdCardImgReverseSid;
    }

    public void setSpouseIdCardImgReverseSid(String spouseIdCardImgReverseSid) {
        this.spouseIdCardImgReverseSid = spouseIdCardImgReverseSid;
    }

    public String getMarriageCertificateImg() {
        return marriageCertificateImg;
    }

    public void setMarriageCertificateImg(String marriageCertificateImg) {
        this.marriageCertificateImg = marriageCertificateImg;
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

    public String getIdCardImgObverseSide() {
        return idCardImgObverseSide;
    }

    public void setIdCardImgObverseSide(String idCardImgObverseSide) {
        this.idCardImgObverseSide = idCardImgObverseSide;
    }

    public String getIdCardImgReverseSide() {
        return idCardImgReverseSide;
    }

    public void setIdCardImgReverseSide(String idCardImgReverseSide) {
        this.idCardImgReverseSide = idCardImgReverseSide;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverLicenseImg() {
        return driverLicenseImg;
    }

    public void setDriverLicenseImg(String driverLicenseImg) {
        this.driverLicenseImg = driverLicenseImg;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
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

    public String getBackCardImg() {
        return backCardImg;
    }

    public void setBackCardImg(String backCardImg) {
        this.backCardImg = backCardImg;
    }

    public String getBankStatementImg() {
        return bankStatementImg;
    }

    public void setBankStatementImg(String bankStatementImg) {
        this.bankStatementImg = bankStatementImg;
    }

    public String getEarningsProofImg() {
        return earningsProofImg;
    }

    public void setEarningsProofImg(String earningsProofImg) {
        this.earningsProofImg = earningsProofImg;
    }

    public String getNetCarReceivableLogImg() {
        return netCarReceivableLogImg;
    }

    public void setNetCarReceivableLogImg(String netCarReceivableLogImg) {
        this.netCarReceivableLogImg = netCarReceivableLogImg;
    }

    public String getCommunicationListImg() {
        return communicationListImg;
    }

    public void setCommunicationListImg(String communicationListImg) {
        this.communicationListImg = communicationListImg;
    }

    public String getAttoneyPowerImg() {
        return attoneyPowerImg;
    }

    public void setAttoneyPowerImg(String attoneyPowerImg) {
        this.attoneyPowerImg = attoneyPowerImg;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
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
}