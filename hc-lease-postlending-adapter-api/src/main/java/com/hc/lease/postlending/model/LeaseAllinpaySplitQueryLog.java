package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 通联支付超额拆分交易明细 通联轮询流水
 */
public class LeaseAllinpaySplitQueryLog {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "通联支付超额拆分交易明细 支付流水 主键id", hidden = false)
    private Long allinpaySplitLogId;
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "通联支付超额拆分交易明细主键id", hidden = false)
    private Long allinpaySplitId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
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
    @ApiModelProperty(value = "记录序号 通联批量扣款 每条数据的 序号", hidden = false)
    private String sn;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAllinpaySplitLogId() {
        return allinpaySplitLogId;
    }

    public void setAllinpaySplitLogId(Long allinpaySplitLogId) {
        this.allinpaySplitLogId = allinpaySplitLogId;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getAllinpaySplitId() {
        return allinpaySplitId;
    }

    public void setAllinpaySplitId(Long allinpaySplitId) {
        this.allinpaySplitId = allinpaySplitId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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