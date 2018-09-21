package com.hc.lease.user.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 新增/注册 后台用户 的 职能角色/补充角色
 */
public class InsertUserAuthoRole implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "角色名", hidden = false)
    private String name;
    @ApiModelProperty(value = "角色类型：0只能角色、1补充角色", hidden = false)
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InsertUserAuthoRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}