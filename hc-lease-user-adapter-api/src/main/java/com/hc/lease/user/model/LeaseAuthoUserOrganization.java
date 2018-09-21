package com.hc.lease.user.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用户-公司、部门、组中间表，用户所属的组织
 */
public class LeaseAuthoUserOrganization implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "用户主键ID", hidden = false)
    private Long userId;
    @ApiModelProperty(value = "关联对象主键Id（公司、部门、组）", hidden = false)
    private Long organizationStructureId;
    @ApiModelProperty(value = "关联对象类型（公司:company、部门:department、组:group）", hidden = false)
    private String organizationStructureType;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrganizationStructureId() {
        return organizationStructureId;
    }

    public void setOrganizationStructureId(Long organizationStructureId) {
        this.organizationStructureId = organizationStructureId;
    }

    public String getOrganizationStructureType() {
        return organizationStructureType;
    }

    public void setOrganizationStructureType(String organizationStructureType) {
        this.organizationStructureType = organizationStructureType == null ? null : organizationStructureType.trim();
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "LeaseAuthoUserOrganization{" +
                "id=" + id +
                ", userId=" + userId +
                ", organizationStructureId=" + organizationStructureId +
                ", organizationStructureType='" + organizationStructureType + '\'' +
                ", ids=" + ids +
                '}';
    }
}