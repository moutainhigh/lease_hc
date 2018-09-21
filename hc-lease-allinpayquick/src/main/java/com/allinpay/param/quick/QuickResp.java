package com.allinpay.param.quick;

/**
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public class QuickResp {
    private String RET_CODE;
    private String ERR_MSG;

    @Override
    public String toString() {
        return "QuickResp{" +
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
