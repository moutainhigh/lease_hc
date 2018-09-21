package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 未发送短信提醒的 状态为成功的 通联轮询流水
 * Created by tong on 2017/9/13.
 */
public class FindSuccessNoSendSmsVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "代收流水主键id", hidden = false)
    private Long allinpayLogId;
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "支付状态汇总管理主键id", hidden = false)
    private Long repaymentStatusId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "通联支付状态/0:已提交;1:成功;2:失败", hidden = false)
    private Integer status;

    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "承租人姓名", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人银行卡号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "承租人银行名称", hidden = false)
    private String bankName;
    @ApiModelProperty(value = "承租人手机/账号", hidden = false)
    private String phone;

    @ApiModelProperty(value = "款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:还款到最后一期的尾付; 5:提前还款罚款;6:提前还款的尾付", hidden = false)
    private Integer payType;
    @ApiModelProperty(value = "合计金额", hidden = false)
    private BigDecimal totlePrice;

    @ApiModelProperty(value = "还款日", hidden = false, required = true)
    private Date repaymentDate;
    @ApiModelProperty(value = "支付款项类型名称", hidden = false)
    private String payTypeName;
    @ApiModelProperty(value = "完整合同编号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "通联支付反馈状态码", hidden = false)
    private String retCode;
    @ApiModelProperty(value = "通联支付反馈状态描述", hidden = false)
    private String errMsg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAllinpayLogId() {
        return allinpayLogId;
    }

    public void setAllinpayLogId(Long allinpayLogId) {
        this.allinpayLogId = allinpayLogId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
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
}
