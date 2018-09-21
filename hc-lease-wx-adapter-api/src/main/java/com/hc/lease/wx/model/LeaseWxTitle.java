package com.hc.lease.wx.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class LeaseWxTitle implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "首页标题", hidden = false)
    private String homeTitle;
    @ApiModelProperty(value = "首页口号", hidden = false)
    private String homeSlogan;
    @ApiModelProperty(value = "加盟代理标题", hidden = false)
    private String agentTitle;
    @ApiModelProperty(value = "车辆列表标题", hidden = false)
    private String carTitle;
    @ApiModelProperty(value = "车辆详情标题", hidden = false)
    private String cardetailTitle;
    @ApiModelProperty(value = "创建时间", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改时间", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "是否启用", hidden = false)
    private Boolean isEnable;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeTitle() {
        return homeTitle;
    }

    public void setHomeTitle(String homeTitle) {
        this.homeTitle = homeTitle == null ? null : homeTitle.trim();
    }

    public String getHomeSlogan() {
        return homeSlogan;
    }

    public void setHomeSlogan(String homeSlogan) {
        this.homeSlogan = homeSlogan == null ? null : homeSlogan.trim();
    }

    public String getAgentTitle() {
        return agentTitle;
    }

    public void setAgentTitle(String agentTitle) {
        this.agentTitle = agentTitle == null ? null : agentTitle.trim();
    }

    public String getCarTitle() {
        return carTitle;
    }

    public void setCarTitle(String carTitle) {
        this.carTitle = carTitle == null ? null : carTitle.trim();
    }

    public String getCardetailTitle() {
        return cardetailTitle;
    }

    public void setCardetailTitle(String cardetailTitle) {
        this.cardetailTitle = cardetailTitle == null ? null : cardetailTitle.trim();
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

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}