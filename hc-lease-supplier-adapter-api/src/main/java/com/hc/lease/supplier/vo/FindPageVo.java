package com.hc.lease.supplier.vo;

import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FindPageVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "二级区域id", hidden = false)
    private Long secondaryId;
    @ApiModelProperty(value = "门店名称", hidden = false)
    private String name;
    @ApiModelProperty(value = "业务员", hidden = false)
    private String salesName;
    @ApiModelProperty(value = "类型（1 区域 2 门店）", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "网点级别 1:1级 2:2级", hidden = false)
    private Integer storesLevel;
    @ApiModelProperty(value = "地址", hidden = false)
    private String address;
    @ApiModelProperty(value = "图片", hidden = false)
    private String img;
    @ApiModelProperty(value = "接收的图片", hidden = false)
    private List<String> imgs;
    @ApiModelProperty(value = "联系电话", hidden = false)
    private String phone;
    @ApiModelProperty(value = "创建时间", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改时间", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "是否启用（0 禁用 1 启动）", hidden = false)
    private Boolean isEnable;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "合同签约 0:否、1:是", hidden = false)
    private Integer isContractAward;
    @ApiModelProperty(value = "合作开始日", hidden = false)
    private String cooperationStartTime;
    @ApiModelProperty(value = "合作年限(字典表主键ID)", hidden = false)
    private Long cooperationYearLimit;
    @ApiModelProperty(value = "合作年限名称", hidden = false)
    private String cooperationYearLimitName;
    @ApiModelProperty(value = "合作结束日", hidden = false)
    private String cooperationEndTime;
    @ApiModelProperty(value = "营业执照图片", hidden = false)
    private String businessLicenseImg;
    @ApiModelProperty(value = "营业执照编号", hidden = false)
    private String businessLicenseNumber;
    @ApiModelProperty(value = "负责人", hidden = false)
    private String chargePersonName;
    @ApiModelProperty(value = "负责人身份证", hidden = false)
    private String chargePersonIdCard;
    @ApiModelProperty(value = "营业执照地址", hidden = false)
    private String businessLicenseAdress;

    @ApiModelProperty(value = "保证金额", hidden = false)
    private BigDecimal guaranteeAmount;
    @ApiModelProperty(value = "可提车数量", hidden = false)
    private Integer carNumber;
    @ApiModelProperty(value = "每单佣金", hidden = false)
    private BigDecimal commission;
    @ApiModelProperty(value = "编号", hidden = false)
    private Integer number;

    @ApiModelProperty(value = "二级区域名称", hidden = false)
    private String secondaryName;
    @ApiModelProperty(value = "一级区域名称", hidden = false)
    private String levelName;

    @ApiModelProperty(value = "用于修改排序记录位置变化", hidden = false)
    private Integer mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSecondaryId() {
        return secondaryId;
    }

    public void setSecondaryId(Long secondaryId) {
        this.secondaryId = secondaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStoresLevel() {
        return storesLevel;
    }

    public void setStoresLevel(Integer storesLevel) {
        this.storesLevel = storesLevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public Integer getIsContractAward() {
        return isContractAward;
    }

    public void setIsContractAward(Integer isContractAward) {
        this.isContractAward = isContractAward;
    }

    public String getCooperationStartTime() {
        return cooperationStartTime;
    }

    public void setCooperationStartTime(String cooperationStartTime) {
        this.cooperationStartTime = DateUtil.interceptDate(cooperationStartTime);
    }

    public Long getCooperationYearLimit() {
        return cooperationYearLimit;
    }

    public void setCooperationYearLimit(Long cooperationYearLimit) {
        this.cooperationYearLimit = cooperationYearLimit;
    }

    public String getCooperationEndTime() {
        return cooperationEndTime;
    }

    public void setCooperationEndTime(String cooperationEndTime) {
        this.cooperationEndTime = DateUtil.interceptDate(cooperationEndTime);
    }

    public String getBusinessLicenseImg() {
        return businessLicenseImg;
    }

    public void setBusinessLicenseImg(String businessLicenseImg) {
        this.businessLicenseImg = businessLicenseImg;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getChargePersonName() {
        return chargePersonName;
    }

    public void setChargePersonName(String chargePersonName) {
        this.chargePersonName = chargePersonName;
    }

    public String getChargePersonIdCard() {
        return chargePersonIdCard;
    }

    public void setChargePersonIdCard(String chargePersonIdCard) {
        this.chargePersonIdCard = chargePersonIdCard;
    }

    public String getBusinessLicenseAdress() {
        return businessLicenseAdress;
    }

    public void setBusinessLicenseAdress(String businessLicenseAdress) {
        this.businessLicenseAdress = businessLicenseAdress;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public String getSecondaryName() {
        return secondaryName;
    }

    public void setSecondaryName(String secondaryName) {
        this.secondaryName = secondaryName;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean enable) {
        isEnable = enable;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public BigDecimal getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }
}