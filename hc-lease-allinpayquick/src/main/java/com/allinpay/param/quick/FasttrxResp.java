package com.allinpay.param.quick;

/**
 * @author zzq
 * @date 2018/4/2
 * @Description
 */
public class FasttrxResp extends QuickResp{
    private String RET_CODE;
    private String SETTLE_DAY;
    private String ERR_MSG;
    private String ACCT_SUFFIX;

    public String getRET_CODE() {
        return RET_CODE;
    }

    public void setRET_CODE(String RET_CODE) {
        this.RET_CODE = RET_CODE;
    }

    public String getSETTLE_DAY() {
        return SETTLE_DAY;
    }

    public void setSETTLE_DAY(String SETTLE_DAY) {
        this.SETTLE_DAY = SETTLE_DAY;
    }

    public String getERR_MSG() {
        return ERR_MSG;
    }

    public void setERR_MSG(String ERR_MSG) {
        this.ERR_MSG = ERR_MSG;
    }

    public String getACCT_SUFFIX() {
        return ACCT_SUFFIX;
    }

    public void setACCT_SUFFIX(String ACCT_SUFFIX) {
        this.ACCT_SUFFIX = ACCT_SUFFIX;
    }

    @Override
    public String toString() {
        return "FasttrxResp{" +
                "RET_CODE='" + RET_CODE + '\'' +
                ", SETTLE_DAY='" + SETTLE_DAY + '\'' +
                ", ERR_MSG='" + ERR_MSG + '\'' +
                ", ACCT_SUFFIX='" + ACCT_SUFFIX + '\'' +
                '}';
    }
}
