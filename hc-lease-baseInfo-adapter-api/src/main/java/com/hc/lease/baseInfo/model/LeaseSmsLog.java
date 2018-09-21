package com.hc.lease.baseInfo.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
/**
 * 短信日志表
 */
public class LeaseSmsLog implements Serializable{
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "接收人姓名", hidden = false)
    private String name;
    @ApiModelProperty(value = "接收号码", hidden = false)
    private String phone;
    @ApiModelProperty(value = "发送内容", hidden = false)
    private String message;
    @ApiModelProperty(value = "操作人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "发送时间", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "发送状态（0 成功 1 失败）", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "类型（0 系统自动 1 手动）", hidden = false)
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
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}