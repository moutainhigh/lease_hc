package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付状态汇总管理
 * 月供的状态、滞纳金的状态、挂靠费的状态、提前还款的状态、
 * 尾付的状态，一个合同的某一期对应的这几种款项只有一个状态，
 * 可能每一种款项会操作多次扣款，每次操作的状态都更新
 */
public class LeaseSchemeRepaymentStatus implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "融租合同-还款计划明细主键id", hidden = false)
    private Long repaymentId;

    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;

    @ApiModelProperty(value = "款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/月租的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款", hidden = false)
    private Integer type;

    @ApiModelProperty(value = "支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Integer paymentResult;

    @ApiModelProperty(value = "主键id", hidden = false)
    private String paymentResultMsg;

    @ApiModelProperty(value = "状态结果描述  失败原因描述", hidden = false)
    private String reqSn;

    @ApiModelProperty(value = "通联返回的 文件名/可用于通联流水查询/最后一次操作的文件名，有可能一个款项操作了多次", hidden = false)
    private String sn;

    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "lease_scheme_repayment_status", hidden = false)
    private BigDecimal totlePrice;

    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他", hidden = false)
    private Integer payWay;

    @ApiModelProperty(value = "代收流水主键id", hidden = false)
    private Long allinpayLogId;

    @ApiModelProperty(value = "款项类型 0:月租;1:挂靠", hidden = false)
    private Integer overdueType;

    public LeaseSchemeRepaymentStatus() {
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
    }

    public String getPaymentResultMsg() {
        return paymentResultMsg;
    }

    public void setPaymentResultMsg(String paymentResultMsg) {
        this.paymentResultMsg = paymentResultMsg;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Long getAllinpayLogId() {
        return allinpayLogId;
    }

    public void setAllinpayLogId(Long allinpayLogId) {
        this.allinpayLogId = allinpayLogId;
    }

    public Integer getOverdueType() {
        return overdueType;
    }

    public void setOverdueType(Integer overdueType) {
        this.overdueType = overdueType;
    }

}