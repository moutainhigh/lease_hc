package com.hc.lease.user.model;

import com.hc.lease.user.vo.InsertUerOrganization;
import com.hc.lease.user.vo.InsertUserAuthoRole;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 后台用户
 */
public class LeaseUser implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

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

    @ApiModelProperty(value = "加密盐", hidden = false)
    private String salt;

    @ApiModelProperty(value = "密码", hidden = false)
    private String password;

    @ApiModelProperty(value = "头像", hidden = false)
    private String icon;

    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;

    @ApiModelProperty(value = "账号状态:0使用中、1锁定、2注销、3禁用", hidden = false)
    private Integer status;

    @ApiModelProperty(value = "加密盐", hidden = false)
    private String credentialsSalt;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    @ApiModelProperty(value = "设备id", hidden = false)
    private String deviceId;

    @ApiModelProperty(value = "所属单位/部门", hidden = false)
    private List<InsertUerOrganization> organizationList;

    @ApiModelProperty(value = "职能角色", hidden = false)
    private List<InsertUserAuthoRole> roleListZero;

    @ApiModelProperty(value = "补充角色", hidden = false)
    private List<InsertUserAuthoRole> roleListOne;

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
        this.name = name == null ? null : name.trim();
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
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCredentialsSalt(String credentialsSalt) {
        this.credentialsSalt = phone + salt;
    }

    public String getCredentialsSalt() {
        return phone + salt;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<InsertUerOrganization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<InsertUerOrganization> organizationList) {
        this.organizationList = organizationList;
    }

    public List<InsertUserAuthoRole> getRoleListZero() {
        return roleListZero;
    }

    public void setRoleListZero(List<InsertUserAuthoRole> roleListZero) {
        this.roleListZero = roleListZero;
    }

    public List<InsertUserAuthoRole> getRoleListOne() {
        return roleListOne;
    }

    public void setRoleListOne(List<InsertUserAuthoRole> roleListOne) {
        this.roleListOne = roleListOne;
    }

    @Override
    public String toString() {
        return "LeaseUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", sort=" + sort +
                ", status=" + status +
                ", credentialsSalt='" + credentialsSalt + '\'' +
                ", ids=" + ids +
                ", deviceId='" + deviceId + '\'' +
                ", organizationList=" + organizationList +
                ", roleListZero=" + roleListZero +
                ", roleListOne=" + roleListOne +
                '}';
    }
}