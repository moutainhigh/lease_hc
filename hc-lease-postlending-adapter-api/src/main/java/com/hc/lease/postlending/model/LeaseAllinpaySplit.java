package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 通联支付超额拆分交易明细
 */
public class LeaseAllinpaySplit {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "记录通联支付超额的还款计划明细主键id", hidden = false)
    private Long splitConnectId;
    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false)
    private Integer payWay;
    @ApiModelProperty(value = "支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Integer paymentResult;
    @ApiModelProperty(value = "金额", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "状态结果描述  失败原因描述", hidden = false)
    private String paymentResultMsg;
    @ApiModelProperty(value = "通联返回的 文件名/可用于通联流水查询/最后一次操作的文件名，有可能一个款项操作了多次", hidden = false)
    private String reqSn;
    @ApiModelProperty(value = "记录序号 通联批量代收 每笔金额的 序号/最后一次操作的序号，有可能一个款项操作了多次", hidden = false)
    private String sn;
    @ApiModelProperty(value = "状态 0:无操作1:挂起 2:取消挂起", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "扣款日/扣款时间", hidden = false)
    private Date repaymentDate;
    @ApiModelProperty(value = "是否已过自动扣款时间 0否 1是", hidden = false)
    private Integer isOverTime;
    @ApiModelProperty(value = "交易明细序号总数", hidden = false)
    private Integer sequenceNumberStart;
    @ApiModelProperty(value = "交易明细序号顺序", hidden = false)
    private Integer sequenceNumberEnd;
    @ApiModelProperty(value = "0:合同未作修改 ; 1:合同已作修改", hidden = false)
    private Integer updateType;
    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人/操作人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人/操作人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getSplitConnectId() {
        return splitConnectId;
    }

    public void setSplitConnectId(Long splitConnectId) {
        this.splitConnectId = splitConnectId;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public String getPaymentResultMsg() {
        return paymentResultMsg;
    }

    public void setPaymentResultMsg(String paymentResultMsg) {
        this.paymentResultMsg = paymentResultMsg == null ? null : paymentResultMsg.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getIsOverTime() {
        return isOverTime;
    }

    public void setIsOverTime(Integer isOverTime) {
        this.isOverTime = isOverTime;
    }

    public Integer getSequenceNumberStart() {
        return sequenceNumberStart;
    }

    public void setSequenceNumberStart(Integer sequenceNumberStart) {
        this.sequenceNumberStart = sequenceNumberStart;
    }

    public Integer getSequenceNumberEnd() {
        return sequenceNumberEnd;
    }

    public void setSequenceNumberEnd(Integer sequenceNumberEnd) {
        this.sequenceNumberEnd = sequenceNumberEnd;
    }

    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}