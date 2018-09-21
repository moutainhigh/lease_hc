package com.hc.lease.common.allinpay;

import com.allinpay.model.QuickReturnMessage;
import com.allinpay.param.common.InfoReq;
import com.hc.lease.common.core.exception.GMException;

/**
 * @author zzq
 * @date 2018/4/11
 * @Description
 */
public interface QuickTeansxUtils {

    public String sendXml(String xml, boolean isFront) throws Exception;

    public String sendToTlt(String xml, boolean flag) throws GMException;

    /**
     * 报文签名
     *
     * @param
     * @return 日期：Sep 9, 2012
     * @throws Exception
     */
    public String signMsg(String xml) throws Exception;

    /**
     * 验证签名
     *
     * @param msg
     * @return 日期：Sep 9, 2012
     * @throws Exception
     */
    public boolean verifyMsg(String msg, String cer, boolean isFront) throws Exception;

    /**
     * 组装报文头部
     *
     * @param trxcod
     * @return 日期：Sep 9, 2012
     */
    public InfoReq makeReq(String trxcod);

    /**
     * 返回报文处理逻辑
     *
     * @param xml
     */
    public QuickReturnMessage resqHandler(String xml) throws GMException;

}
