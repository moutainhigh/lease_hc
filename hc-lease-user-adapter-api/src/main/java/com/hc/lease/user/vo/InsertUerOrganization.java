package com.hc.lease.user.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 新增/注册 后台用户 的 所属单位
 */
public class InsertUerOrganization implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "所属单位名称、部门名称", hidden = false)
    private String name;
    @ApiModelProperty(value = "类型/公司:company、部门:department、组:group", hidden = false)
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InsertUerOrganizationDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}