package com.hc.lease.common.allinpay;

import com.aipg.common.InfoReq;
import com.aipg.common.MakeReq;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.TranxConfig;
import com.hc.lease.common.core.exception.GMException;

import java.io.UnsupportedEncodingException;

/**
 * 通联支付
 * Created by tong on 2017/6/2.
 */
public interface TeansxUtils {

    /**
     * 组装报文头部
     *
     * @param makeReq
     * @param trxcod
     * @param tranxContants
     * @return
     */
    public InfoReq makeReq(MakeReq makeReq, String trxcod, TranxConfig tranxContants);

    /**
     * 返回报文处理逻辑
     *
     * @param retXml
     */
    public ReturnMessage dealRet(String retXml) throws GMException;

    public String sendToTlt(String xml, boolean flag, String url, TranxConfig tranxContants) throws GMException;

    /**
     * 报文签名
     *
     * @param xml
     * @return 日期：Sep 9, 2012
     * @throws Exception
     */
    public String signMsg(String xml, TranxConfig tranxContants) throws Exception;

    public String sendXml(String xml, String url, boolean isFront, TranxConfig tranxContants) throws UnsupportedEncodingException, Exception;

    /**
     * 验证签名
     *
     * @param msg
     * @return 日期：Sep 9, 2012
     * @throws Exception
     */
    public boolean verifyMsg(String msg, String cer, boolean isFront) throws Exception;

}
