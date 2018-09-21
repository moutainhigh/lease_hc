package com.allinpay.param.quick;

/**
 * @author zzq
 * @date 2018/3/31
 * @Description
 */
public class FagraReq {
    private String MERCHANT_ID;
    private String BANK_CODE;
    private String ACCOUNT_TYPE;
    private String ACCOUNT_NO;
    private String ACCOUNT_NAME;
    private String ACCOUNT_PROP;
    private String ID_TYPE;
    private String ID;
    private String TEL;
    private String CVV2;
    private String VAILDDATE;
    private String MERREM;
    private String REMARK;

    @Override
    public String toString() {
        return "FagraReq{" +
                "MERCHANT_ID='" + MERCHANT_ID + '\'' +
                ", BANK_CODE='" + BANK_CODE + '\'' +
                ", ACCOUNT_TYPE='" + ACCOUNT_TYPE + '\'' +
                ", ACCOUNT_NO='" + ACCOUNT_NO + '\'' +
                ", ACCOUNT_NAME='" + ACCOUNT_NAME + '\'' +
                ", ACCOUNT_PROP='" + ACCOUNT_PROP + '\'' +
                ", ID_TYPE='" + ID_TYPE + '\'' +
                ", ID='" + ID + '\'' +
                ", TEL='" + TEL + '\'' +
                ", CVV2='" + CVV2 + '\'' +
                ", VAILDDATE='" + VAILDDATE + '\'' +
                ", MERREM='" + MERREM + '\'' +
                ", REMARK='" + REMARK + '\'' +
                '}';
    }

    public String getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(String MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public String getBANK_CODE() {
        return BANK_CODE;
    }

    public void setBANK_CODE(String BANK_CODE) {
        this.BANK_CODE = BANK_CODE;
    }

    public String getACCOUNT_TYPE() {
        return ACCOUNT_TYPE;
    }

    public void setACCOUNT_TYPE(String ACCOUNT_TYPE) {
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
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

    public String getACCOUNT_PROP() {
        return ACCOUNT_PROP;
    }

    public void setACCOUNT_PROP(String ACCOUNT_PROP) {
        this.ACCOUNT_PROP = ACCOUNT_PROP;
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

    public String getMERREM() {
        return MERREM;
    }

    public void setMERREM(String MERREM) {
        this.MERREM = MERREM;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }
}
