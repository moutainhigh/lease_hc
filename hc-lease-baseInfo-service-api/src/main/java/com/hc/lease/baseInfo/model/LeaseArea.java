package com.hc.lease.baseInfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 地区
 */
public class LeaseArea implements Serializable {
    @ApiModelProperty(value = "地区主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "名称", hidden = false)
    private String name;

    @ApiModelProperty(value = "父级主键id", hidden = false)
    private Long parentId;

    @ApiModelProperty(value = "简称拼音", hidden = false)
    private String shortName;

    @ApiModelProperty(value = "级别", hidden = false)
    private Integer level;

    @ApiModelProperty(value = "归档位置主键id", hidden = false)
    private String mergerName;

    @ApiModelProperty(value = "区号", hidden = false)
    private String code;

    @ApiModelProperty(value = "邮编", hidden = false)
    private String zipCode;

    @ApiModelProperty(value = "拼音全拼", hidden = false)
    private String pinYin;

    @ApiModelProperty(value = "拼音缩写", hidden = false)
    private String shortPy;

    @ApiModelProperty(value = "模块，指定位置可用", hidden = false)
    private String model;

    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人主键id", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人主键id", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;

    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Boolean isEnable;

    @ApiModelProperty(value = "是否热门 0 否 1 是", hidden = false)
    private Boolean isHot;

    @ApiModelProperty(value = "下级数据集合", hidden = false)
    private List<LeaseArea> children;

    @ApiModelProperty(value = "地区主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "名称不能为空")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName == null ? null : mergerName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    public String getShortPy() {
        return shortPy;
    }

    public void setShortPy(String shortPy) {
        this.shortPy = shortPy == null ? null : shortPy.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public List<LeaseArea> getChildren() {
        return children;
    }

    public void setChildren(List<LeaseArea> children) {
        this.children = children;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}