package com.hc.lease.account.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 承租人银行卡通联支付签约
 */
public class LeaseAccountBankPaySin implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "注册用户/承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "姓名", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人银行卡主键id", hidden = false)
    private Long bankCardId;
    @ApiModelProperty(value = "手机号", hidden = false)
    private String tel;
    @ApiModelProperty(value = "身份证号", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "银行代码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "银行名称", hidden = false)
    private String bankName;
    @ApiModelProperty(value = "银行卡号", hidden = false)
    private String bankCardNumber;
    @ApiModelProperty(value = "银行主键Id", hidden = false)
    private Long bankId;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "状态 0:未签约 1:已签约 2签约中 3:签约失败", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "签约流水号", hidden = false)
    private String reqSn;
    @ApiModelProperty(value = "签约通联请求状态码", hidden = false)
    private String reqCode;
    @ApiModelProperty(value = "签约通联请求状态描述", hidden = false)
    private String reqMsg;
    @ApiModelProperty(value = "协议号", hidden = false)
    private String agrmNo;
    @ApiModelProperty(value = "原请求流水、对应申请请求报文中的REQ_SN", hidden = false)
    private String srcreqSn;

    @ApiModelProperty(value = "签约通联处理状态码", hidden = false, required = true)
    private String rnpaCode;
    @ApiModelProperty(value = "签约通联处理状态描述", hidden = false, required = true)
    private String rnpaMsg;
    @ApiModelProperty(value = "类型: 0系统承租人授权、1:新增承租人授权", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "操作来源: 0后台系统操作、1:PC、小程序网页操作", hidden = false)
    private Integer source;
    @ApiModelProperty(value = "承租人: 0否、1:是", hidden = false)
    private Integer isAccount;
    @ApiModelProperty(value = "银行预留手机号", hidden = false)
    private String bankPhone;

    @ApiModelProperty(value = "承租人: 0否、1:是", hidden = false)
    private String isAccountString;

    @ApiModelProperty(value = "状态 0:签约失败 1:签约成功", hidden = false)
    private  String statusString;

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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public Long getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(Long bankCardId) {
        this.bankCardId = bankCardId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
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
        this.reqSn = reqSn;
    }

    public String getReqCode() {
        return reqCode;
    }

    public void setReqCode(String reqCode) {
        this.reqCode = reqCode;
    }

    public String getReqMsg() {
        return reqMsg;
    }

    public void setReqMsg(String reqMsg) {
        this.reqMsg = reqMsg;
    }

    public String getAgrmNo() {
        return agrmNo;
    }

    public void setAgrmNo(String agrmNo) {
        this.agrmNo = agrmNo;
    }

    public String getSrcreqSn() {
        return srcreqSn;
    }

    public void setSrcreqSn(String srcreqSn) {
        this.srcreqSn = srcreqSn;
    }

    public String getRnpaCode() {
        return rnpaCode;
    }

    public void setRnpaCode(String rnpaCode) {
        this.rnpaCode = rnpaCode;
    }

    public String getRnpaMsg() {
        return rnpaMsg;
    }

    public void setRnpaMsg(String rnpaMsg) {
        this.rnpaMsg = rnpaMsg;
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

    public Integer getIsAccount() {
        return isAccount;
    }

    public void setIsAccount(Integer isAccount) {
        this.isAccount = isAccount;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getIsAccountString() {
        return isAccountString;
    }

    public void setIsAccountString(String isAccountString) {
        this.isAccountString = isAccountString;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

}