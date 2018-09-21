package com.allinpay.param.quick;

/**
 * @author zzq
 * @date 2018/4/2
 * @Description
 */
public class FagrcnlResp extends QuickResp{
    private String RET_CODE;
    private String ERR_MSG;

    @Override
    public String toString() {
        return "FagrcnlResp{" +
                "RET_CODE='" + RET_CODE + '\'' +
                ", ERR_MSG='" + ERR_MSG + '\'' +
                '}';
    }

    public String getRET_CODE() {
        return RET_CODE;
    }

    public void setRET_CODE(String RET_CODE) {
        this.RET_CODE = RET_CODE;
    }

    public String getERR_MSG() {
        return ERR_MSG;
    }

    public void setERR_MSG(String ERR_MSG) {
        this.ERR_MSG = ERR_MSG;
    }
}
