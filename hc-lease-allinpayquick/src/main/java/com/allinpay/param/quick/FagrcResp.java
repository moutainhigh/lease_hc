package com.allinpay.param.quick;

/**
 * @author zzq
 * @date 2018/4/2
 * @Description
 */
public class FagrcResp extends QuickResp{
    private String AGRMNO;
    private String RET_CODE;
    private String ERR_MSG;

    public String getAGRMNO() {
        return AGRMNO;
    }

    public void setAGRMNO(String AGRMNO) {
        this.AGRMNO = AGRMNO;
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

    @Override
    public String toString() {
        return "FagrcResp{" +
                "AGRMNO='" + AGRMNO + '\'' +
                ", RET_CODE='" + RET_CODE + '\'' +
                ", ERR_MSG='" + ERR_MSG + '\'' +
                '}';
    }
}
