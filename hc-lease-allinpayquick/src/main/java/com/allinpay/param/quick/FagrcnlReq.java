package com.allinpay.param.quick;

/**
 * @author zzq
 * @date 2018/4/2
 * @Description
 */
public class FagrcnlReq {
    private String MERCHANT_ID;
    private String ACCOUNT_NO;
    private String AGRMNO;

    @Override
    public String toString() {
        return "FagrcnlReq{" +
                "MERCHANT_ID='" + MERCHANT_ID + '\'' +
                ", ACCOUNT_NO='" + ACCOUNT_NO + '\'' +
                ", AGRMNO='" + AGRMNO + '\'' +
                '}';
    }

    public String getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(String MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public void setACCOUNT_NO(String ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public String getAGRMNO() {
        return AGRMNO;
    }

    public void setAGRMNO(String AGRMNO) {
        this.AGRMNO = AGRMNO;
    }
}
