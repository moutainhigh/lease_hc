package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 接收 支付参数封装
 * 手动扣款
 * Created by tong on 2018/7/9
 */
public class TransManualDeductionsBody implements Serializable {

    @ApiModelProperty(value = "交易流水号 (需提供：交易查询/轮询,)", hidden = false, required = true)
    private String reqSn;
    @ApiModelProperty(value = "记录序号 通联批量代收 每条数据的 序号", hidden = false, required = true)
    private String sn;
    @ApiModelProperty(value = "月供月份/融租合同-还款主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long contractId;
    @ApiModelProperty(value = "手动扣款提交的数据主键id", hidden = false, required = true)
    Long dataId;
    @ApiModelProperty(value = "手动扣款流水主键Id", hidden = false, required = true)
    private Long payLogId;
    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false, required = true)
    private Integer payWay;
    @ApiModelProperty(value = "提交通联状态", hidden = false, required = true)
    private String aipgrspRetCode;
    @ApiModelProperty(value = "提交通联状态描述", hidden = false, required = true)
    private String aipgrspErrMsg;
    @ApiModelProperty(value = "通联交易处理结果描述", hidden = false, required = true)
    private String errMsg;

    private String rnpaRetRetCode;
    private String rnpaRetErrmsg;
    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    private Integer isSpilt;
    @ApiModelProperty(value = "是否已经扣款 0否 1是", hidden = false)
    Integer payStatus;

    @ApiModelProperty(value = "手动扣款统计主键id", hidden = false, required = true)
    private Long statistId;
    @ApiModelProperty(value = "总金额", hidden = false)
    private BigDecimal totalPrice;

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

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getAipgrspRetCode() {
        return aipgrspRetCode;
    }

    public void setAipgrspRetCode(String aipgrspRetCode) {
        this.aipgrspRetCode = aipgrspRetCode;
    }

    public String getAipgrspErrMsg() {
        return aipgrspErrMsg;
    }

    public void setAipgrspErrMsg(String aipgrspErrMsg) {
        this.aipgrspErrMsg = aipgrspErrMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getRnpaRetRetCode() {
        return rnpaRetRetCode;
    }

    public void setRnpaRetRetCode(String rnpaRetRetCode) {
        this.rnpaRetRetCode = rnpaRetRetCode;
    }

    public String getRnpaRetErrmsg() {
        return rnpaRetErrmsg;
    }

    public void setRnpaRetErrmsg(String rnpaRetErrmsg) {
        this.rnpaRetErrmsg = rnpaRetErrmsg;
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

    public Integer getIsSpilt() {
        return isSpilt;
    }

    public void setIsSpilt(Integer isSpilt) {
        this.isSpilt = isSpilt;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Long getStatistId() {
        return statistId;
    }

    public void setStatistId(Long statistId) {
        this.statistId = statistId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "TransManualDeductionsBody{" +
                "reqSn='" + reqSn + '\'' +
                ", sn='" + sn + '\'' +
                ", repaymentId=" + repaymentId +
                ", contractId=" + contractId +
                ", dataId=" + dataId +
                ", payLogId=" + payLogId +
                ", payWay=" + payWay +
                ", aipgrspRetCode='" + aipgrspRetCode + '\'' +
                ", aipgrspErrMsg='" + aipgrspErrMsg + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", rnpaRetRetCode='" + rnpaRetRetCode + '\'' +
                ", rnpaRetErrmsg='" + rnpaRetErrmsg + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", isSpilt=" + isSpilt +
                ", payStatus=" + payStatus +
                ", statistId=" + statistId +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
