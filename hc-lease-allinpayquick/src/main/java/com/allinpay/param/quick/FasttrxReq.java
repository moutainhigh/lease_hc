package com.allinpay.param.quick;

/**
 * @author tong
 * @date 2018/4/2
 * @Description
 */
public class FasttrxReq {
    private String BUSINESS_CODE;//业务代码(必填)
    private String MERCHANT_ID;//商户号(必填)
    private String SUBMIT_TIME;//提交时间(必填)
    private String AGRMNO;//协议号(必填)
    private String ACCOUNT_NO;//用户银行卡号(必填)
    private String ACCOUNT_NAME;//用户名(必填)
    private String AMOUNT;//金额、整数，单位分(必填)
    private String CURRENCY;//货币类型(选填)
    private String ID_TYPE;//开户证件类型(选填)
    private String ID;//证件号(选填)
    private String TEL;//手机号(选填)
    private String CVV2;//CVV2(选填)信用卡时必填
    private String VAILDDATE;//有效期(选填)信用卡时必填，格式MMYY(信用卡上的两位月两位年)
    private String CUST_USERID;//自定义用户号(选填)、商户自定义的用户号，开发人员可当作备注字段使用
    private String SUMMARY;//商户自定义的用户号(选填)、开发人员可当作备注字段使用
    private String REMARK;//备注(选填)

    public String getBUSINESS_CODE() {
        return BUSINESS_CODE;
    }

    public void setBUSINESS_CODE(String BUSINESS_CODE) {
        this.BUSINESS_CODE = BUSINESS_CODE;
    }

    public String getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(String MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public String getSUBMIT_TIME() {
        return SUBMIT_TIME;
    }

    public void setSUBMIT_TIME(String SUBMIT_TIME) {
        this.SUBMIT_TIME = SUBMIT_TIME;
    }

    public String getAGRMNO() {
        return AGRMNO;
    }

    public void setAGRMNO(String AGRMNO) {
        this.AGRMNO = AGRMNO;
    }

    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public void setACCOUNT_NO(String ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }

    public void setACCOUNT_NAME(String ACCOUNT_NAME) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
    }

    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public void setCURRENCY(String CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    public String getID_TYPE() {
        return ID_TYPE;
    }

    public void setID_TYPE(String ID_TYPE) {
        this.ID_TYPE = ID_TYPE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getCVV2() {
        return CVV2;
    }

    public void setCVV2(String CVV2) {
        this.CVV2 = CVV2;
    }

    public String getVAILDDATE() {
        return VAILDDATE;
    }

    public void setVAILDDATE(String VAILDDATE) {
        this.VAILDDATE = VAILDDATE;
    }

    public String getCUST_USERID() {
        return CUST_USERID;
    }

    public void setCUST_USERID(String CUST_USERID) {
        this.CUST_USERID = CUST_USERID;
    }

    public String getSUMMARY() {
        return SUMMARY;
    }

    public void setSUMMARY(String SUMMARY) {
        this.SUMMARY = SUMMARY;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    @Override
    public String toString() {
        return "FasttrxReq{" +
                "BUSINESS_CODE='" + BUSINESS_CODE + '\'' +
                ", MERCHANT_ID='" + MERCHANT_ID + '\'' +
                ", SUBMIT_TIME='" + SUBMIT_TIME + '\'' +
                ", AGRMNO='" + AGRMNO + '\'' +
                ", ACCOUNT_NO='" + ACCOUNT_NO + '\'' +
                ", ACCOUNT_NAME='" + ACCOUNT_NAME + '\'' +
                ", AMOUNT='" + AMOUNT + '\'' +
                ", CURRENCY='" + CURRENCY + '\'' +
                ", ID_TYPE='" + ID_TYPE + '\'' +
                ", ID='" + ID + '\'' +
                ", TEL='" + TEL + '\'' +
                ", CVV2='" + CVV2 + '\'' +
                ", VAILDDATE='" + VAILDDATE + '\'' +
                ", CUST_USERID='" + CUST_USERID + '\'' +
                ", SUMMARY='" + SUMMARY + '\'' +
                ", REMARK='" + REMARK + '\'' +
                '}';
    }
}
