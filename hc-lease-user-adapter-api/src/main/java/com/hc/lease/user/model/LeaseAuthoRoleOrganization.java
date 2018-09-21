package com.hc.lease.user.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 角色-公司、部门、组中间表。用于控制角色查看指定公司、部门的数据
 */
public class LeaseAuthoRoleOrganization implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "角色主键ID", hidden = false)
    private Long roleId;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        return "LeaseAuthoRoleOrganization{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", organizationStructureId=" + organizationStructureId +
                ", organizationStructureType='" + organizationStructureType + '\'' +
                ", ids=" + ids +
                '}';
    }
}