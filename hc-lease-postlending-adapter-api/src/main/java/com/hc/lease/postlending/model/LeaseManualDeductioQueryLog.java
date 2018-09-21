package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 手动扣款通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条支付流水都对应一条轮询流水
 */
public class LeaseManualDeductioQueryLog implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "手动扣款提交的数据主键id", hidden = false)
    private Long dataId;
    @ApiModelProperty(value = "手动扣款支付流水主键id", hidden = false)
    private Long payLogId;
    @ApiModelProperty(value = "通联支付状态/0:已提交;1:成功;2:失败", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "通联支付反馈状态码", hidden = false)
    private String retCode;
    @ApiModelProperty(value = "通联支付反馈状态描述", hidden = false)
    private String errMsg;
    @ApiModelProperty(value = "通联支付反馈状态日期", hidden = false)
    private Date backTime;
    @ApiModelProperty(value = "通联返回的 文件名/可用于通联流水查询", hidden = false)
    private String reqSn;
    @ApiModelProperty(value = "记录序号 通联批量代收 每笔金额的 序号", hidden = false)
    private String sn;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getPayLogId() {
        return payLogId;
    }

    public void setPayLogId(Long payLogId) {
        this.payLogId = payLogId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode == null ? null : retCode.trim();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn == null ? null : reqSn.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}