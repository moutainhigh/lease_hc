package com.hc.lease.user.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台用户导出VO
 */
public class ExportUserVo implements Serializable {

    @ApiModelProperty(value = "用户名称/姓名", hidden = false)
    private String name;

    @ApiModelProperty(value = "性别:0:女,1:男", hidden = false)
    private Integer sex;

    @ApiModelProperty(value = "手机号(账号)", hidden = false)
    private String phone;

    @ApiModelProperty(value = "真实姓名", hidden = false)
    private String realName;

    @ApiModelProperty(value = "邮箱地址", hidden = false)
    private String email;

    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人", hidden = false)
    private String createName;

    @ApiModelProperty(value = "修改人", hidden = false)
    private String updateName;

    @ApiModelProperty(value = "账号状态:0使用中、1锁定、2注销、3禁用", hidden = false)
    private Integer status;

    @ApiModelProperty(value = "账号状态", hidden = false)
    private String statusName;

    @ApiModelProperty(value = "部门/组", hidden = false)
    private String organizationName;

    @ApiModelProperty(value = "职位角色", hidden = false)
    private String roleZeroName;

    @ApiModelProperty(value = "补充角色", hidden = false)
    private String roleOneName;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getRoleZeroName() {
        return roleZeroName;
    }

    public void setRoleZeroName(String roleZeroName) {
        this.roleZeroName = roleZeroName;
    }

    public String getRoleOneName() {
        return roleOneName;
    }

    public void setRoleOneName(String roleOneName) {
        this.roleOneName = roleOneName;
    }

}