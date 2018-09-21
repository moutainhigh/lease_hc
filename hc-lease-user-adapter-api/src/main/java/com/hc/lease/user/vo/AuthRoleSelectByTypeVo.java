package com.hc.lease.user.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 角色 用类型查询 VO
 */
public class AuthRoleSelectByTypeVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "角色名", hidden = false)
    private String name;
    @ApiModelProperty(value = "角色类型：0职位、1补充", hidden = false)
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
        return "AuthRoleSelectByTypeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}