package com.hc.lease.account.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 承租人银行卡通联支付签约日志
 */
public class LeaseAccountBankpaysinLog {
    private Long id;

    private Long accountId;

    private Long bankPaySinId;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Integer status;

    private String reqSn;

    private String agrmNo;

    private String reqMsg;

    private String reqCode;

    private String srcreqSn;

    private String rnpaCode;

    private String rnpaMsg;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getBankPaySinId() {
        return bankPaySinId;
    }

    public void setBankPaySinId(Long bankPaySinId) {
        this.bankPaySinId = bankPaySinId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn == null ? null : reqSn.trim();
    }

    public String getAgrmNo() {
        return agrmNo;
    }

    public void setAgrmNo(String agrmNo) {
        this.agrmNo = agrmNo == null ? null : agrmNo.trim();
    }

    public String getReqMsg() {
        return reqMsg;
    }

    public void setReqMsg(String reqMsg) {
        this.reqMsg = reqMsg == null ? null : reqMsg.trim();
    }

    public String getReqCode() {
        return reqCode;
    }

    public void setReqCode(String reqCode) {
        this.reqCode = reqCode == null ? null : reqCode.trim();
    }

    public String getSrcreqSn() {
        return srcreqSn;
    }

    public void setSrcreqSn(String srcreqSn) {
        this.srcreqSn = srcreqSn == null ? null : srcreqSn.trim();
    }

    public String getRnpaCode() {
        return rnpaCode;
    }

    public void setRnpaCode(String rnpaCode) {
        this.rnpaCode = rnpaCode == null ? null : rnpaCode.trim();
    }

    public String getRnpaMsg() {
        return rnpaMsg;
    }

    public void setRnpaMsg(String rnpaMsg) {
        this.rnpaMsg = rnpaMsg == null ? null : rnpaMsg.trim();
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}