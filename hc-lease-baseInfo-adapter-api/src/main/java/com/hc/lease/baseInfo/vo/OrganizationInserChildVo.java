package com.hc.lease.baseInfo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 新增/修改 接收参数的实体
 * Created by Tong on 2018/4/12.
 */
public class OrganizationInserChildVo implements Serializable {
    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Integer isEnable;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "类型/公司:company、部门:department、组:group", hidden = false)
    private String type;
    @ApiModelProperty(value = "名称", hidden = false)
    private String name;
    @ApiModelProperty(value = "父级Id", hidden = false)
    private Long parentId;
    @ApiModelProperty(value = "主管主键Id/后台用户主键Id", hidden = false)
    private Long leaderId;
    @ApiModelProperty(value = "助理主键Id/后台用户主键Id", hidden = false)
    private Long assistantId;
    @ApiModelProperty(value = "上级主管主键Id/后台用户主键Id", hidden = false)
    private Long parentLeaderId;
    @ApiModelProperty(value = "分管副总主键Id/后台用户主键Id", hidden = false)
    private Long deputyLeadeId;
    @ApiModelProperty(value = "层级", hidden = false)
    private Integer level;

    public OrganizationInserChildVo() {
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public Long getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }

    public Long getParentLeaderId() {
        return parentLeaderId;
    }

    public void setParentLeaderId(Long parentLeaderId) {
        this.parentLeaderId = parentLeaderId;
    }

    public Long getDeputyLeadeId() {
        return deputyLeadeId;
    }

    public void setDeputyLeadeId(Long deputyLeadeId) {
        this.deputyLeadeId = deputyLeadeId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
