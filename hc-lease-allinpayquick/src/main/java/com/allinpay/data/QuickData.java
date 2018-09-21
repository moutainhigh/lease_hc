package com.allinpay.data;

/**
 * @author tong
 * @date 2018/4/11
 * @Description
 */
public class QuickData {
    private String accountName;//用户名
    private String bankCode;//银行编码
    private String accountType;
    private String accountNo;//用户银行卡号
    private String idType;//开户证件类型
    private String id;//证件号
    private String tel;//手机号
    private String cvv2;
    private String vailddate;//有效期、信用卡时必填，格式MMYY(信用卡上的两位月两位年)
    private String merrem;
    private String remark;
    private String accountProp;
    private String agrmno;//协议号
    private String vercode;//验证码
    private String srcreqSn;//原请求流水、对应申请请求报文中的REQ_SN
    private String reqSn;
    private String amount;//金额、整数，单位分

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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getVailddate() {
        return vailddate;
    }

    public void setVailddate(String vailddate) {
        this.vailddate = vailddate;
    }

    public String getMerrem() {
        return merrem;
    }

    public void setMerrem(String merrem) {
        this.merrem = merrem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAgrmno() {
        return agrmno;
    }

    public void setAgrmno(String agrmno) {
        this.agrmno = agrmno;
    }

    public String getAccountProp() {
        return accountProp;
    }

    public void setAccountProp(String accountProp) {
        this.accountProp = accountProp;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public String getSrcreqSn() {
        return srcreqSn;
    }

    public void setSrcreqSn(String srcreqSn) {
        this.srcreqSn = srcreqSn;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
