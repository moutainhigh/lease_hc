package com.hc.lease.postlending.vo;

import com.aipg.payreq.Trans_Detail;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 通联支付需要传递的参数实体
 * Created by tong on 2018/6/27
 */
public class PostlendingPaymentParameVo implements Serializable {

    @ApiModelProperty(value = "批量扣款提交的数据 所有月租、滞纳金、其他金额 ", hidden = false)
    private List<BatchPaymentVo> batchPaymentVo;

    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "批次号/批扣流水", hidden = false)
    private String batchNumber;

    @ApiModelProperty(value = "所有合同主键ID", hidden = false, required = true)
    List<Long> contractIds;

    @ApiModelProperty(value = "通联代扣交易 每笔额度", hidden = false, required = true)
    BigDecimal allinpayPriceLimit;

    @ApiModelProperty(value = "批扣、同一个合同主键和还款计划明细主键组合做Map的键的款项处理成一条之后的数据集合", hidden = false)
    Map<String, TransBodyInstallVo> batchMapAll;

    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false, required = true)
    private Integer payWay;

    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量", hidden = false, required = true)
    private Integer singleOrBatch;

    @ApiModelProperty(value = "代收状态流水 类型 0:提交通联单笔扣款(代扣)的结果;1:提交通联批量扣款(代扣)的结果;2:轮询通联单笔扣款(代扣)的结果;3:轮询通联批量扣款(代扣)的结果;4:提交通联单笔扣款(协议支付)的结果;5:提交通联批量扣款(协议支付)的结果", hidden = false)
    private Integer allinpayStatusLogType;

    @ApiModelProperty(value = "交易代码", hidden = false, required = true)
    private String trxCode;

    @ApiModelProperty(value = "交易代码", hidden = false, required = true)
    private String busiCode;

    @ApiModelProperty(value = "总金额", hidden = false, required = true)
    BigDecimal totalPrice;

    @ApiModelProperty(value = "批扣数量", hidden = false)
    private Integer number;

    @ApiModelProperty(value = "通联批量扣款 每笔明细", hidden = false, required = true)
    private List<Trans_Detail> transList;

    @ApiModelProperty(value = "操作来源 0:单笔; 1:批量;2:手动批扣", hidden = false)
    private Integer controllerSource;

    public List<BatchPaymentVo> getBatchPaymentVo() {
        return batchPaymentVo;
    }

    public void setBatchPaymentVo(List<BatchPaymentVo> batchPaymentVo) {
        this.batchPaymentVo = batchPaymentVo;
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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public List<Long> getContractIds() {
        return contractIds;
    }

    public void setContractIds(List<Long> contractIds) {
        this.contractIds = contractIds;
    }

    public BigDecimal getAllinpayPriceLimit() {
        return allinpayPriceLimit;
    }

    public void setAllinpayPriceLimit(BigDecimal allinpayPriceLimit) {
        this.allinpayPriceLimit = allinpayPriceLimit;
    }

    public Map<String, TransBodyInstallVo> getBatchMapAll() {
        return batchMapAll;
    }

    public void setBatchMapAll(Map<String, TransBodyInstallVo> batchMapAll) {
        this.batchMapAll = batchMapAll;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getSingleOrBatch() {
        return singleOrBatch;
    }

    public void setSingleOrBatch(Integer singleOrBatch) {
        this.singleOrBatch = singleOrBatch;
    }

    public Integer getAllinpayStatusLogType() {
        return allinpayStatusLogType;
    }

    public void setAllinpayStatusLogType(Integer allinpayStatusLogType) {
        this.allinpayStatusLogType = allinpayStatusLogType;
    }

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Trans_Detail> getTransList() {
        return transList;
    }

    public void setTransList(List<Trans_Detail> transList) {
        this.transList = transList;
    }

    public Integer getControllerSource() {
        return controllerSource;
    }

    public void setControllerSource(Integer controllerSource) {
        this.controllerSource = controllerSource;
    }

    @Override
    public String toString() {
        return "PostlendingPaymentParameVo{" +
                "batchPaymentVo=" + batchPaymentVo +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", batchNumber='" + batchNumber + '\'' +
                ", contractIds=" + contractIds +
                ", allinpayPriceLimit=" + allinpayPriceLimit +
                ", batchMapAll=" + batchMapAll +
                ", payWay=" + payWay +
                ", singleOrBatch=" + singleOrBatch +
                ", allinpayStatusLogType=" + allinpayStatusLogType +
                ", trxCode='" + trxCode + '\'' +
                ", busiCode='" + busiCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", number=" + number +
                ", transList=" + transList +
                ", controllerSource=" + controllerSource +
                '}';
    }
}
