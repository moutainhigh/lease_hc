package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 接收 支付参数封装
 * 通联支付拆单 批量协议支付
 * Created by tong on 2017/6/10.
 */
public class TransSplitBody implements Serializable {

    @ApiModelProperty(value = "用户主键id", hidden = false, required = true)
    private Long accountId;

    @ApiModelProperty(value = "银行卡或存折上的所有人姓名", hidden = false, required = true)
    private String bankAccountName;

    @ApiModelProperty(value = "银行卡或存折号码", hidden = false, required = true)
    private String bankAccountNo;

    @ApiModelProperty(value = "用户手机号", hidden = false, required = true)
    private String phone;

    @ApiModelProperty(value = "银行预留手机号", hidden = false, required = true)
    private String bankPhone;

    @ApiModelProperty(value = "身份证", hidden = false, required = true)
    private String idCard;

    @ApiModelProperty(value = "银行代码，存折必须填写", hidden = false, required = true)
    private String bankCode;

    @ApiModelProperty(value = "银行名称", hidden = false, required = true)
    private String bankName;

    @ApiModelProperty(value = "月供月份/融租合同-还款主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long repaymentId;

    @ApiModelProperty(value = "支付状态汇总管理主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long repaymentStatusId;

    @ApiModelProperty(value = "融租合同主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long contractId;

    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "批量扣款提交的数据 所有月租、滞纳金、其他金额 (需提供：批量扣款)", hidden = false)
    private List<BatchPaymentSplitVo> batchPaymentSplitVo;

    @ApiModelProperty(value = "协议号 (需提供：通联协议支付)", hidden = false)
    private String agrmno;

    @ApiModelProperty(value = "批次号/批扣流水", hidden = false)
    private String batchNumber;

    @ApiModelProperty(value = "通联支付拆单 批量协议支付 所有合同主键ID (需提供：通联支付拆单 批量协议支付)", hidden = false, required = true)
    List<Long> contractIds;

    @ApiModelProperty(value = "通联支付超额拆分交易明细主键id", hidden = false, required = true)
    Long allinpaySplitId;

    @ApiModelProperty(value = "通联支付超额拆分交易明细主键id", hidden = false, required = true)
    List<Long> allinpaySplitIds;

    @ApiModelProperty(value = "交易流水号 (需提供：交易查询/轮询,)", hidden = false, required = true)
    private String reqSn;

    @ApiModelProperty(value = "记录序号 通联批量代收 每条数据的 序号", hidden = false, required = true)
    private String sn;

    @ApiModelProperty(value = "超额拆分交易明细流水主键Id", hidden = false, required = true)
    private Long allinpaySplitLogId;

    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量", hidden = false, required = true)
    private Integer singleOrBatch;

    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false, required = true)
    private Integer payWay;

    @ApiModelProperty(value = "提交通联状态", hidden = false, required = true)
    private String aipgrspRetCode;

    @ApiModelProperty(value = "提交通联状态描述", hidden = false, required = true)
    private String aipgrspErrMsg;
    @ApiModelProperty(value = "通联交易处理结果编码", hidden = false, required = true)
    private String retCode;
    @ApiModelProperty(value = "通联交易处理结果描述", hidden = false, required = true)
    private String errMsg;
    @ApiModelProperty(value = "通联交易处理结果完成时间", hidden = false, required = true)
    private String finTime;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getRepaymentStatusId() {
        return repaymentStatusId;
    }

    public void setRepaymentStatusId(Long repaymentStatusId) {
        this.repaymentStatusId = repaymentStatusId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    public List<BatchPaymentSplitVo> getBatchPaymentSplitVo() {
        return batchPaymentSplitVo;
    }

    public void setBatchPaymentSplitVo(List<BatchPaymentSplitVo> batchPaymentSplitVo) {
        this.batchPaymentSplitVo = batchPaymentSplitVo;
    }

    public String getAgrmno() {
        return agrmno;
    }

    public void setAgrmno(String agrmno) {
        this.agrmno = agrmno;
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

    public Long getAllinpaySplitId() {
        return allinpaySplitId;
    }

    public void setAllinpaySplitId(Long allinpaySplitId) {
        this.allinpaySplitId = allinpaySplitId;
    }

    public List<Long> getAllinpaySplitIds() {
        return allinpaySplitIds;
    }

    public void setAllinpaySplitIds(List<Long> allinpaySplitIds) {
        this.allinpaySplitIds = allinpaySplitIds;
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

    public Long getAllinpaySplitLogId() {
        return allinpaySplitLogId;
    }

    public void setAllinpaySplitLogId(Long allinpaySplitLogId) {
        this.allinpaySplitLogId = allinpaySplitLogId;
    }

    public Integer getSingleOrBatch() {
        return singleOrBatch;
    }

    public void setSingleOrBatch(Integer singleOrBatch) {
        this.singleOrBatch = singleOrBatch;
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

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getFinTime() {
        return finTime;
    }

    public void setFinTime(String finTime) {
        this.finTime = finTime;
    }

}
