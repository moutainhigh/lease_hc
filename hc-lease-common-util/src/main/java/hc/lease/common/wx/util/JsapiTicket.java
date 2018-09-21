package hc.lease.common.wx.util;

/**
 * 获取jsapi_ticket
 * Created by tong on 2018/1/18.
 */
public class JsapiTicket {
    //结果状态
    private String errcode;
    //结果状态描述
    private String errmsg;
    //jsapi_ticket值
    private String ticket;
    // 凭证有效时间，单位：秒
    private int expiresIn;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
