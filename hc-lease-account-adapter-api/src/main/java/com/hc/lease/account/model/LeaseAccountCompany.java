package com.hc.lease.account.model;

import com.hc.lease.account.vo.EmergencyContactVo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 注册公司类型用户/承租人
 */
public class LeaseAccountCompany implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "注册用户/承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "公司名称", hidden = false)
    private String companyName;
    @ApiModelProperty(value = "营业执照号", hidden = false)
    private String businessLicenseNumber;
    @ApiModelProperty(value = "营业执图片", hidden = false)
    private String businessLicenseImg;
    @ApiModelProperty(value = "公司注册地址", hidden = false)
    private String companyRegistrationAddress;
    @ApiModelProperty(value = "公司固话", hidden = false)
    private String companyPhone;
    @ApiModelProperty(value = "法人身份证号码", hidden = false)
    private String legalPersonIdCard;
    @ApiModelProperty(value = "法人姓名", hidden = false)
    private String legalPersonName;
    @ApiModelProperty(value = "法人地址", hidden = false)
    private String legalPersonAddress;
    @ApiModelProperty(value = "法人电话", hidden = false)
    private String legalPersonPhone;
    @ApiModelProperty(value = "联系人姓名(联系人)", hidden = false)
    private String contactsName;
    @ApiModelProperty(value = "联系人地址(联系地址)", hidden = false)
    private String contactsAddress;
    @ApiModelProperty(value = "联系人电话(联系电话)", hidden = false)
    private String contactsPhone;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remark;
    @ApiModelProperty(value = "户名", hidden = false)
    private String bankAccountName;
    @ApiModelProperty(value = "银行卡发卡行", hidden = false)
    private Long bankId;
    @ApiModelProperty(value = "支行信息", hidden = false)
    private String branchBank;
    @ApiModelProperty(value = "银行卡号/账号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "银行卡照片", hidden = false)
    private String backCardImg;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;
    @ApiModelProperty(value = "紧急联系人/json格式存放多个联系人/包括:紧急联系人姓名(Emergency_Contact_Name)；紧急联系人与本人关系(Emergency_Contact_Relationship)；急联系人手机(Emergency_Contact_Phone) (个人类型承租人要此参数)", hidden = false)
    private Object emergencyContact;
    @ApiModelProperty(value = "紧急联系人/json格式存放多个联系人/包括:紧急联系人姓名(Emergency_Contact_Name)；紧急联系人与本人关系(Emergency_Contact_Relationship)；急联系人手机(Emergency_Contact_Phone) (个人类型承租人要此参数)", hidden = false)
    private List<EmergencyContactVo> emergencyContactVoList;




    @ApiModelProperty(value = "用户名称/姓名", hidden = false)
    private String name;

    @ApiModelProperty(value = "性别:0:女,1:男 (个人类型承租人要此参数)", hidden = false)
    private Integer sex;

    @ApiModelProperty(value = "手机号(用作账号登录名) (个人类型和公司类型承租人要此参数)", hidden = false)
    private String phone;

    @ApiModelProperty(value = "身份证号 (个人类型和公司类型承租人要此参数)", hidden = false)
    private String idCard;

    @ApiModelProperty(value = "婚姻状态 0:已婚;1:未婚;3:其他 (个人类型承租人要此参数)", hidden = false)
    private Integer maritalStatus;

    @ApiModelProperty(value = "真实姓名", hidden = false)
    private String realName;

    @ApiModelProperty(value = "加密盐", hidden = false)
    private String salt;

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

    @ApiModelProperty(value = "用户类型：0:个人;1:公司", hidden = false)
    private Integer type;


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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getBusinessLicenseImg() {
        return businessLicenseImg;
    }

    public void setBusinessLicenseImg(String businessLicenseImg) {
        this.businessLicenseImg = businessLicenseImg;
    }

    public String getCompanyRegistrationAddress() {
        return companyRegistrationAddress;
    }

    public void setCompanyRegistrationAddress(String companyRegistrationAddress) {
        this.companyRegistrationAddress = companyRegistrationAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getLegalPersonIdCard() {
        return legalPersonIdCard;
    }

    public void setLegalPersonIdCard(String legalPersonIdCard) {
        this.legalPersonIdCard = legalPersonIdCard;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalPersonAddress() {
        return legalPersonAddress;
    }

    public void setLegalPersonAddress(String legalPersonAddress) {
        this.legalPersonAddress = legalPersonAddress;
    }

    public String getLegalPersonPhone() {
        return legalPersonPhone;
    }

    public void setLegalPersonPhone(String legalPersonPhone) {
        this.legalPersonPhone = legalPersonPhone;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsAddress() {
        return contactsAddress;
    }

    public void setContactsAddress(String contactsAddress) {
        this.contactsAddress = contactsAddress;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Object getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Object emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public List<EmergencyContactVo> getEmergencyContactVoList() {
        return emergencyContactVoList;
    }

    public void setEmergencyContactVoList(List<EmergencyContactVo> emergencyContactVoList) {
        this.emergencyContactVoList = emergencyContactVoList;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}