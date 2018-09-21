package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 通联扣款结果短信通知日志
 */
public class LeaseAllinpayStatusSms implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "通联轮询流水主键Id", hidden = false)
    private Long queryLogId;
    @ApiModelProperty(value = "发送数据方的主键Id 即是 月租还款计划明细主键id", hidden = false)
    private Long usedId;
    @ApiModelProperty(value = "短信日志id", hidden = false)
    private Long smsId;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "短信类型：0:通联轮询 ; 1:手动发送逾期提醒 ; 2:自动提前扣款提醒; 3:扣款失败通知", hidden = false)
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQueryLogId() {
        return queryLogId;
    }

    public void setQueryLogId(Long queryLogId) {
        this.queryLogId = queryLogId;
    }

    public Long getUsedId() {
        return usedId;
    }

    public void setUsedId(Long usedId) {
        this.usedId = usedId;
    }

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}