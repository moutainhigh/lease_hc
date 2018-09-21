package com.hc.lease.common.allinpay;

import com.aipg.common.AipgRsp;
import com.aipg.common.InfoReq;
import com.aipg.common.MakeReq;
import com.aipg.common.XSUtil;
import com.aipg.payresp.Body;
import com.aipg.payresp.Ret_Detail;
import com.aipg.rnp.Rnp;
import com.aipg.rnp.RnpaRet;
import com.aipg.rtrsp.TransRet;
import com.aipg.singleacctvalid.ValidRet;
import com.aipg.transquery.QTDetail;
import com.aipg.transquery.QTransRsp;
import com.allinpay.XmlTools;
import com.google.common.collect.Maps;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.TranxConfig;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.util.List;
import java.util.Map;

/**
 * 通联支付
 * Created by tong on 2017/6/2.
 */
@Service("teansxUtils")
public class TeansxUtilsImpl implements TeansxUtils {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 组装报文头部
     *
     * @param trxcod
     * @return 日期：Sep 9, 2012
     */
    public InfoReq makeReq(MakeReq makeReq, String trxcod, TranxConfig tranxContants) {

        InfoReq info = new InfoReq();
        info.setTRX_CODE(trxcod);
        info.setREQ_SN(tranxContants.merchantId + "-" + String.valueOf(System.currentTimeMillis()));
        //info.setREQ_SN(StringUtil.getFixLenthString(4));
        info.setUSER_NAME(tranxContants.userName);
        info.setUSER_PASS(tranxContants.password);
        info.setLEVEL(makeReq.getLevel());//处理级别 0-9  0优先级最低，默认为5
        info.setDATA_TYPE(makeReq.getDataType());//数据格式
        info.setVERSION(makeReq.getVersion());//版本
        if (
                "300000".equals(trxcod) || "300001".equals(trxcod) || "300003".equals(trxcod) || "REFUND".equals(trxcod)
                        || "310003".equals(trxcod) || "310011".equals(trxcod) || "310002".equals(trxcod) || "310001".equals(trxcod)
                ) {
            info.setMERCHANT_ID(tranxContants.merchantId);
        }
        return info;
    }

    /**
     * 返回报文处理逻辑
     *
     * @param retXml
     */
    public ReturnMessage dealRet(String retXml) throws GMException {

        String trxcode = null;
        AipgRsp aipgrsp = null;
        //或者交易码
        if (retXml.indexOf("<TRX_CODE>") != -1) {
            int end = retXml.indexOf("</TRX_CODE>");
            int begin = end - 6;
            if (begin >= 0) trxcode = retXml.substring(begin, end);
        }
        aipgrsp = XSUtil.parseRsp(retXml);

        ReturnMessage returnMessage = null;

        //实名付申请
        if ("211006".equals(trxcode) || "211006R".equals(trxcode) || "211006C".equals(trxcode)) {
            returnMessage = new ReturnMessage();
            returnMessage.setTrxCode(trxcode);
            returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());//通联返回的 头部 状态码
            returnMessage.setReqSn(aipgrsp.getINFO().getREQ_SN());
            returnMessage.setRepTime(aipgrsp.getINFO().getREPTIME());
            if ("0000".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("提交成功");
                logger.info("提交成功");
                RnpaRet ret = (RnpaRet) aipgrsp.findObj(RnpaRet.class);
                returnMessage.setRnpaRetRetCode(ret.getRET_CODE());
                returnMessage.setRnpaRetErrmsg(ret.getERR_MSG());
                logger.info("交易结果：" + ret.getRET_CODE() + ":" + ret.getERR_MSG());
            } else {
                returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());
                returnMessage.setAipgrspErrmsg(aipgrsp.getINFO().getERR_MSG());
                logger.info("响应码" + aipgrsp.getINFO().getRET_CODE() + "原因：" + aipgrsp.getINFO().getERR_MSG());
            }
        }

        if ("211006Q".equals(trxcode)) {
            returnMessage = new ReturnMessage();
            returnMessage.setTrxCode(trxcode);
            returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());
            returnMessage.setReqSn(aipgrsp.getINFO().getREQ_SN());
            returnMessage.setRepTime(aipgrsp.getINFO().getREPTIME());
            if ("0000".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("提交成功");
                logger.info("提交成功");
                Rnp rnpQ = (Rnp) aipgrsp.getTrxData().get(0);
                returnMessage.setRnpRetCode(rnpQ.getRET_CODE());
                returnMessage.setRnpErrmsg(rnpQ.getERR_MSG());
                logger.info("查询结果：" + rnpQ.getRET_CODE() + ":" + rnpQ.getERR_MSG());
            } else {
                returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());
                returnMessage.setAipgrspErrmsg(aipgrsp.getINFO().getERR_MSG());
                logger.info("响应码" + aipgrsp.getINFO().getRET_CODE() + "原因：" + aipgrsp.getINFO().getERR_MSG());
            }
        }

        //交易退款返回处理逻辑
        if ("REFUND".equals(trxcode)) {
            returnMessage = new ReturnMessage();
            returnMessage.setTrxCode(trxcode);
            returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());
            returnMessage.setReqSn(aipgrsp.getINFO().getREQ_SN());
            returnMessage.setRepTime(aipgrsp.getINFO().getREPTIME());
            if ("0000".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("退款成功");
                logger.info("退款成功");
            } else {
                returnMessage.setAipgrspErrmsg(aipgrsp.getINFO().getERR_MSG());
                logger.info("退款失败，失败原因：" + aipgrsp.getINFO().getERR_MSG());
            }
        }
        //批量代收付返回处理逻辑
        if ("100001".equals(trxcode) || "100002".equals(trxcode) || "211000".equals(trxcode)) {
            returnMessage = new ReturnMessage();
            returnMessage.setTrxCode(trxcode);
            returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());//通联返回的 头部 状态码
            returnMessage.setReqSn(aipgrsp.getINFO().getREQ_SN());
            returnMessage.setRepTime(aipgrsp.getINFO().getREPTIME());

            if ("0000".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("受理成功，请在20分钟后进行10/每次的轮询");
                logger.info("受理成功，请在20分钟后进行10/每次的轮询");

                Body qrsq = (Body) aipgrsp.getTrxData().get(0);
                logger.info("批扣成功，具体结果明细如下:");
                List<Ret_Detail> details = qrsq.getDetails();
                returnMessage.setRetDetails(details);

            } else {
                returnMessage.setAipgrspErrmsg("受理失败，失败原因：" + aipgrsp.getINFO().getERR_MSG());
                logger.info("受理失败，失败原因：" + aipgrsp.getINFO().getERR_MSG());

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("批量代收付返回处理逻辑backMap==" + backMap);
                returnMessage.setRetDetails(null);
                //throw new GMException(GMExceptionConstant.ALLINPAY_PARAME_ERROR, backMap);
            }
        }
        //交易查询处理逻辑
        if ("200004".equals(trxcode) || "200005".equals(trxcode)) {
            returnMessage = new ReturnMessage();
            returnMessage.setTrxCode(trxcode);
            returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());
            returnMessage.setReqSn(aipgrsp.getINFO().getREQ_SN());
            returnMessage.setRepTime(aipgrsp.getINFO().getREPTIME());
            if ("0000".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("查询成功");
                QTransRsp qrsq = (QTransRsp) aipgrsp.getTrxData().get(0);
                logger.info("查询成功，具体结果明细如下:");
                List<QTDetail> details = qrsq.getDetails();
                logger.info("交易查询处理逻辑details==" + details);
                returnMessage.setQueryDetails(details);
                if (details != null) {
                    for (QTDetail lobj : details) {
                        System.out.print("原支付交易批次号:" + lobj.getBATCHID() + "  ");
                        System.out.print("记录序号:" + lobj.getSN() + "  ");
                        System.out.print("账号:" + lobj.getACCOUNT_NO() + "  ");
                        System.out.print("户名:" + lobj.getACCOUNT_NAME() + "  ");
                        System.out.print("金额:" + lobj.getAMOUNT() + "  ");
                        System.out.print("返回结果:" + lobj.getRET_CODE() + "  ");
                        if ("0000".equals(lobj.getRET_CODE())) {
                            logger.info("返回说明:交易成功  ");
                            logger.info("更新交易库状态（原交易的状态）");
                        } else {
                            logger.info("返回说明:" + lobj.getERR_MSG() + "  ");
                            logger.info("更新交易库状态（原交易的状态）");
                        }
                    }
                }

            } else if ("2000".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2001".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2003".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2005".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2007".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2008".equals(aipgrsp.getINFO().getRET_CODE())) {

                returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());
                returnMessage.setAipgrspErrmsg(aipgrsp.getINFO().getERR_MSG() + "该状态时，说明整个批次的交易都在处理中");
                returnMessage.setReqSn(aipgrsp.getINFO().getREQ_SN());
                returnMessage.setRepTime(aipgrsp.getINFO().getREPTIME());

                System.out.print("返回说明:" + aipgrsp.getINFO().getRET_CODE() + "  ");
                logger.info("返回说明：" + aipgrsp.getINFO().getERR_MSG());
                logger.info("该状态时，说明整个批次的交易都在处理中");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("交易查询处理逻辑backMap==" + backMap);

            } else if ("2004".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("整批交易未受理通过（最终失败）");
                logger.info("整批交易未受理通过（最终失败）");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("交易查询处理逻辑backMap==" + backMap);

            } else if ("1002".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("查询无结果集（表示通联端根据商户请求上送的条件查不到对应的结果集）");
                logger.info("查询无结果集（表示通联端根据商户请求上送的条件查不到对应的结果集）");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("交易查询处理逻辑backMap==" + backMap);

            } else {
                returnMessage.setAipgrspErrmsg("查询请求失败，请重新发起查询");
                logger.info("查询请求失败，请重新发起查询");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("交易查询处理逻辑backMap==" + backMap);
                throw new GMException(GMExceptionConstant.ALLINPAY_PARAME_ERROR, backMap);
            }
        }

        //实时交易结果返回处理逻辑(包括单笔实时代收，单笔实时代付，单笔实时身份验证)
        if ("100011".equals(trxcode) || "100014".equals(trxcode) || "100400".equals(trxcode)) {
            returnMessage = new ReturnMessage();
            returnMessage.setTrxCode(trxcode);
            returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());
            returnMessage.setReqSn(aipgrsp.getINFO().getREQ_SN());
            returnMessage.setRepTime(aipgrsp.getINFO().getREPTIME());
            if ("0000".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("提交成功");
                logger.info("提交成功");
                TransRet ret = (TransRet) aipgrsp.getTrxData().get(0);
                logger.info("交易结果：" + ret.getRET_CODE() + ":" + ret.getERR_MSG());
                returnMessage.setTransRetRetCode(ret.getRET_CODE());
                if ("0000".equals(ret.getRET_CODE())) {
                    returnMessage.setTransRetErrmsg("交易成功（最终结果）");
                    logger.info("交易成功（最终结果）");
                } else {
                    returnMessage.setTransRetErrmsg("交易失败原因：" + ret.getERR_MSG());
                    logger.info("交易失败（最终结果）");
                    logger.info("交易失败原因：" + ret.getERR_MSG());

                    Map backMap = Maps.newHashMap();
                    backMap.put("retCode", ret.getRET_CODE());
                    backMap.put("errMsg", ret.getERR_MSG());
                    logger.info("交易查询处理逻辑backMap==" + backMap);
                    throw new GMException(GMExceptionConstant.ALLINPAY_PARAME_ERROR, backMap);
                }
            } else if (
                    "2000".equals(aipgrsp.getINFO().getRET_CODE())
                            || "2001".equals(aipgrsp.getINFO().getRET_CODE())
                            || "2003".equals(aipgrsp.getINFO().getRET_CODE())
                            || "2005".equals(aipgrsp.getINFO().getRET_CODE())
                            || "2007".equals(aipgrsp.getINFO().getRET_CODE())
                            || "2008".equals(aipgrsp.getINFO().getRET_CODE())
                    ) {

                returnMessage.setAipgrspErrmsg("交易处理中或者不确定状态，需要在稍后5分钟后进行交易结果查询（轮询）");

                logger.info("交易处理中或者不确定状态，需要在稍后5分钟后进行交易结果查询（轮询）");
            } else if (aipgrsp.getINFO().getRET_CODE().startsWith("1")) {
                String errormsg = aipgrsp.getINFO().getERR_MSG() == null ? "连接异常，请重试" : aipgrsp.getINFO().getERR_MSG();
                returnMessage.setAipgrspErrmsg("交易请求失败，原因：" + errormsg);
                logger.info("交易请求失败，原因：" + errormsg);

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("返回报文处理逻辑backMap==" + backMap);
                throw new GMException(GMExceptionConstant.ALLINPAY_PARAME_ERROR, backMap);
            } else if ("2017".equals(aipgrsp.getINFO().getRET_CODE())) {
                logger.info(aipgrsp.getINFO().getERR_MSG());

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("返回报文处理逻辑backMap==" + backMap);
                throw new GMException(GMExceptionConstant.ALLINPAY_PRICE_OUT_LIMIT, backMap);
            } else {
                TransRet ret = (TransRet) aipgrsp.getTrxData().get(0);
                returnMessage.setAipgrspErrmsg("交易失败(最终结果)，失败原因：" + ret.getERR_MSG());
                returnMessage.setTransRetErrmsg("交易失败(最终结果)，失败原因：" + ret.getERR_MSG());
                logger.info("交易失败(最终结果)，失败原因：" + ret.getERR_MSG());

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("返回报文处理逻辑backMap==" + backMap);
                throw new GMException(GMExceptionConstant.ALLINPAY_PARAME_ERROR, backMap);
            }
        }
        //(单笔实时身份验证结果返回处理逻辑)
        if ("211003".equals(trxcode) || "220001".equals(trxcode) || "211004".equals(trxcode)) {
            returnMessage = new ReturnMessage();
            returnMessage.setTrxCode(trxcode);
            returnMessage.setAipgrspRetCode(aipgrsp.getINFO().getRET_CODE());
            returnMessage.setReqSn(aipgrsp.getINFO().getREQ_SN());
            returnMessage.setRepTime(aipgrsp.getINFO().getREPTIME());
            if ("0000".equals(aipgrsp.getINFO().getRET_CODE())) {
                logger.info("提交成功");
                ValidRet ret = (ValidRet) aipgrsp.getTrxData().get(0);
                returnMessage.setValidRetRetCode(ret.getRET_CODE());
                returnMessage.setValidRetErrmsg(ret.getERR_MSG());
                logger.info("交易结果：" + ret.getRET_CODE() + ":" + ret.getERR_MSG());
            } else if ("2000".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2001".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2003".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2005".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2007".equals(aipgrsp.getINFO().getRET_CODE())
                    || "2008".equals(aipgrsp.getINFO().getRET_CODE())) {
                returnMessage.setAipgrspErrmsg("验证处理中或者不确定状态，需要在稍后5分钟后进行验证结果查询（轮询）");
                logger.info("验证处理中或者不确定状态，需要在稍后5分钟后进行验证结果查询（轮询）");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("单笔实时身份验证结果返回处理逻辑backMap==" + backMap);

            } else if (aipgrsp.getINFO().getRET_CODE().startsWith("1")) {
                String errormsg = aipgrsp.getINFO().getERR_MSG() == null ? "连接异常，请重试" : aipgrsp.getINFO().getERR_MSG();
                returnMessage.setAipgrspErrmsg("验证请求失败，原因：" + errormsg);
                logger.info("验证请求失败，原因：" + errormsg);

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("单笔实时身份验证结果返回处理逻辑backMap==" + backMap);

            } else {
                TransRet ret = (TransRet) aipgrsp.getTrxData().get(0);
                returnMessage.setAipgrspErrmsg("验证失败(最终结果)，失败原因：" + ret.getERR_MSG());
                returnMessage.setTransRetErrmsg("验证失败(最终结果)，失败原因：" + ret.getERR_MSG());
                logger.info("验证失败(最终结果)，失败原因：" + ret.getERR_MSG());

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", aipgrsp.getINFO().getRET_CODE());
                backMap.put("errMsg", aipgrsp.getINFO().getERR_MSG());
                logger.info("单笔实时身份验证结果返回处理逻辑backMap==" + backMap);
                throw new GMException(GMExceptionConstant.ALLINPAY_PARAME_ERROR, backMap);
            }
        }

        /*
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new GMException(GMExceptionConstant.ALLINPAY_PARAME_ERROR);
        }
        */

        return returnMessage;

    }

    public String sendToTlt(String xml, boolean flag, String url, TranxConfig tranxContants) throws GMException {
        try {
            if (!flag) {
                xml = signMsg(xml, tranxContants);
            } else {
                xml = xml.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "");
            }
            return sendXml(xml, url, flag, tranxContants);
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getCause() instanceof ConnectException || e instanceof ConnectException) {
                e.printStackTrace();
                throw new GMException(GMExceptionConstant.ALLINPAY_TIME_OUT);
                //logger.info("请求链接中断，如果是支付请求，请做交易结果查询，以确认该笔交易是否已被通联受理，避免重复交易");
            }
        }
        //return "请求链接中断，如果是支付请求，请做交易结果查询，以确认该笔交易是否已被通联受理，避免重复交易";
        throw new GMException(GMExceptionConstant.ALLINPAY_TIME_OUT);
    }

    /**
     * 报文签名
     *
     * @param xml
     * @return 日期：Sep 9, 2012
     * @throws Exception
     */
    public String signMsg(String xml, TranxConfig tranxContants) throws Exception {
        xml = XmlTools.signMsg(xml, tranxContants.pfxPath, tranxContants.pfxPassword, false);
        return xml;
    }

    public String sendXml(String xml, String url, boolean isFront, TranxConfig tranxContants) throws UnsupportedEncodingException, Exception {
        logger.info("======================发送报文======================：\n" + xml);
        String resp = XmlTools.send(url, xml);
        logger.info("======================响应内容======================");
        boolean flag = verifyMsg(resp, tranxContants.tltcerPath, isFront);
        if (flag) {
            logger.info("响应内容验证通过");
        } else {
            logger.info("响应内容验证不通过");
        }
        logger.info(resp);
        return resp;
    }

    /**
     * 验证签名
     *
     * @param msg
     * @return 日期：Sep 9, 2012
     * @throws Exception
     */
    public boolean verifyMsg(String msg, String cer, boolean isFront) throws Exception {
        boolean flag = XmlTools.verifySign(msg, cer, false, isFront);
        logger.info("验签结果[" + flag + "]");
        return flag;
    }

}
