package com.allinpay.param.quick;

/**
 * @author zzq
 * @date 2018/4/2
 * @Description
 */
public class FagrcReq {
    private String MERCHANT_ID;
    private String SRCREQSN;
    private String VERCODE;

    @Override
    public String toString() {
        return "FagrcReq{" +
                "MERCHANT_ID='" + MERCHANT_ID + '\'' +
                ", SRCREQSN='" + SRCREQSN + '\'' +
                ", VERCODE='" + VERCODE + '\'' +
                '}';
    }

    public String getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    public void setMERCHANT_ID(String MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }

    public String getSRCREQSN() {
        return SRCREQSN;
    }

    public void setSRCREQSN(String SRCREQSN) {
        this.SRCREQSN = SRCREQSN;
    }

    public String getVERCODE() {
        return VERCODE;
    }

    public void setVERCODE(String VERCODE) {
        this.VERCODE = VERCODE;
    }
}
