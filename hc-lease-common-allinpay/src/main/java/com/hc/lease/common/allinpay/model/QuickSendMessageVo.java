package com.hc.lease.common.allinpay.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 协议支付签约短信触发 接收参数实体
 *
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public class QuickSendMessageVo implements Serializable {

    @ApiModelProperty(value = "用户主键Id", hidden = false, required = true)
    private Long accountId;
    @ApiModelProperty(value = "承租人银行卡主键id", hidden = false, required = true)
    private Long bankCardId;
    @ApiModelProperty(value = "银行主键Id", hidden = false, required = true)
    private Long bankId;
    @ApiModelProperty(value = "银行名称", hidden = false, required = true)
    private String bankName;
    @ApiModelProperty(value = "银行卡用户名", hidden = false, required = true)
    private String accountName;
    @ApiModelProperty(value = "银行代码", hidden = false, required = true)
    private String bankCode;
    @ApiModelProperty(value = "银行卡或存折号码", hidden = false, required = true)
    private String accountNo;
    @ApiModelProperty(value = "身份证", hidden = false, required = true)
    private String idCard;
    @ApiModelProperty(value = "手机", hidden = false, required = true)
    private String tel;
    @ApiModelProperty(value = "验证码", hidden = false, required = true)
    private String vercode;
    @ApiModelProperty(value = "类型: 0系统承租人授权、1:新增承租人授权", hidden = false, required = true)
    private Integer type;
    @ApiModelProperty(value = "操作来源: 0后台系统操作、1:PC、小程序网页操作", hidden = false)
    private Integer source;
    @ApiModelProperty(value = "成为承租人：1:是;0:否", hidden = false)
    private Integer isAddAccount;
    @ApiModelProperty(value = "银行预留手机号", hidden = false)
    private String bankPhone;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(Long bankCardId) {
        this.bankCardId = bankCardId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getIsAddAccount() {
        return isAddAccount;
    }

    public void setIsAddAccount(Integer isAddAccount) {
        this.isAddAccount = isAddAccount;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    @Override
    public String toString() {
        return "QuickSendMessageVo{" +
                "accountId=" + accountId +
                ", bankCardId=" + bankCardId +
                ", bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", idCard='" + idCard + '\'' +
                ", tel='" + tel + '\'' +
                ", vercode='" + vercode + '\'' +
                ", type=" + type +
                ", source=" + source +
                ", isAddAccount=" + isAddAccount +
                ", bankPhone='" + bankPhone + '\'' +
                '}';
    }
}
