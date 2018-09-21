package com.hc.lease.common.allinpay;

import com.allinpay.model.QuickReturnMessage;
import com.allinpay.param.common.AipgRsp;
import com.allinpay.param.common.InfoReq;
import com.allinpay.param.query.QTDetail;
import com.allinpay.param.query.QTransResp;
import com.allinpay.param.quick.*;
import com.allinpay.tool.XSUtilEx;
import com.allinpay.tool.XmlTools;
import com.allinpay.util.QuickEnum;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.TranxConfig;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.ConnectException;
import java.util.List;
import java.util.Map;

/**
 * @author tong
 * @date 2018/4/18
 * @Description
 */
@Service("quickTeansxUtils")
public class QuickTeansxUtilsImpl implements QuickTeansxUtils {
    private final static Logger logger = LoggerFactory.getLogger(QuickTeansxUtilsImpl.class);
    TranxConfig tranxConfig = new TranxConfig();

    public String sendXml(String xml, boolean isFront) throws Exception {
        logger.info("======================发送报文======================：\n" + xml);
        String resp = XmlTools.send(tranxConfig.quickPay_tranURL, xml);
        logger.info("======================响应内容======================");
        boolean flag = verifyMsg(resp, tranxConfig.quickPay_tltcerPath, isFront);
        if (flag) {
            logger.info("响应内容验证通过");
        } else {
            logger.info("响应内容验证不通过");
        }
        logger.info(resp);
        return resp;
    }

    public String sendToTlt(String xml, boolean flag) throws GMException {
        try {
            if (!flag) {
                xml = signMsg(xml);
            } else {
                xml = xml.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "");
            }
            return sendXml(xml, flag);
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getCause() instanceof ConnectException || e instanceof ConnectException) {
                e.printStackTrace();
                throw new GMException(GMExceptionConstant.ALLINPAY_TIME_OUT);
                //System.out.println("请求链接中断，如果是支付请求，请做交易结果查询，以确认该笔交易是否已被通联受理，避免重复交易");
                //logger.info("请求链接中断，如果是支付请求，请做交易结果查询，以确认该笔交易是否已被通联受理，避免重复交易");
            }
        }
        //return "请求链接中断，如果是支付请求，请做交易结果查询，以确认该笔交易是否已被通联受理，避免重复交易";
        throw new GMException(GMExceptionConstant.ALLINPAY_TIME_OUT);
    }

    /**
     * 报文签名
     *
     * @param
     * @return 日期：Sep 9, 2012
     * @throws Exception
     */
    public String signMsg(String xml) throws Exception {
        xml = XmlTools.signMsg(xml, tranxConfig.quickPay_pfxPath, tranxConfig.quickPay_pfxPassword, false);
        return xml;
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

    /**
     * 组装报文头部
     *
     * @param trxcod
     * @return 日期：Sep 9, 2012
     */
    public InfoReq makeReq(String trxcod) {
        InfoReq info = new InfoReq();
        info.setTRX_CODE(trxcod);
        info.setREQ_SN(tranxConfig.quickPay_merchantId + "-" + String.valueOf(System.currentTimeMillis()));
        //info.setREQ_SN(StringUtil.getFixLenthString(4));
        info.setUSER_NAME(tranxConfig.quickPay_userName);
        info.setUSER_PASS(tranxConfig.quickPay_password);
        info.setLEVEL("5");
        info.setDATA_TYPE("2");
        info.setVERSION("04");
        if ("310003".equals(trxcod)
                || "310011".equals(trxcod)
                || "310002".equals(trxcod)
                || "310001".equals(trxcod)) {
            info.setMERCHANT_ID(tranxConfig.quickPay_merchantId);
        }
        return info;
    }

    /**
     * 返回报文处理逻辑
     *
     * @param xml
     */
    public QuickReturnMessage resqHandler(String xml) throws GMException {
        AipgRsp rsp = XSUtilEx.xmlRsp(xml);
        String trxcode = rsp.getINFO().getTRX_CODE();

        QuickReturnMessage quickReturnMessage = null;
        logger.info("trxcode" + trxcode);
        //协议支付签约短信触发、协议支付签约、协议支付解约、协议支付
        if (QuickEnum.TRX_CODE_310001.getCode().equals(trxcode) || QuickEnum.TRX_CODE_310002.getCode().equals(trxcode) || QuickEnum.TRX_CODE_310003.getCode().equals(trxcode) || QuickEnum.TRX_CODE_310011.getCode().equals(trxcode)) {

            quickReturnMessage = new QuickReturnMessage();
            quickReturnMessage.setTrxCode(trxcode);
            quickReturnMessage.setAipgrspRetCode(rsp.getINFO().getRET_CODE());
            quickReturnMessage.setReqSn(rsp.getINFO().getREQ_SN());
            quickReturnMessage.setRepTime(rsp.getINFO().getREPTIME());
            logger.info("trtcode" + rsp.getINFO().getRET_CODE());
            if ("0000".equals(rsp.getINFO().getRET_CODE())) {
                QuickResp resp = new QuickResp();
                if (QuickEnum.TRX_CODE_310001.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                    resp = (FagraResp) rsp.findObj(FagraResp.class);
                } else if (QuickEnum.TRX_CODE_310002.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                    resp = (FagrcResp) rsp.findObj(FagrcResp.class);
                } else if (QuickEnum.TRX_CODE_310003.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                    resp = (FagrcnlResp) rsp.findObj(FagrcnlResp.class);
                } else if (QuickEnum.TRX_CODE_310011.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                    resp = (FasttrxResp) rsp.findObj(FasttrxResp.class);
                }
                if ("0000".equals(resp.getRET_CODE())) {
                    if (QuickEnum.TRX_CODE_310002.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setAgrmno(((FagrcResp) resp).getAGRMNO());
                        quickReturnMessage.setRnpaRetRetCode(((FagrcResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagrcResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                        logger.info("处理成功，协议号为：" + ((FagrcResp) resp).getAGRMNO());
                    } else if (QuickEnum.TRX_CODE_310001.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FagraResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagraResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    } else if (QuickEnum.TRX_CODE_310003.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FagrcnlResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagrcnlResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    } else if (QuickEnum.TRX_CODE_310011.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FasttrxResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FasttrxResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    }
                    logger.info("处理成功（最终成功）");
                } else if (resp.getRET_CODE().startsWith("3")) {
                    if (QuickEnum.TRX_CODE_310002.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setAgrmno(((FagrcResp) resp).getAGRMNO());
                        quickReturnMessage.setRnpaRetRetCode(((FagrcResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagrcResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                        logger.info("处理成功，协议号为：" + ((FagrcResp) resp).getAGRMNO());
                    } else if (QuickEnum.TRX_CODE_310001.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FagraResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagraResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    } else if (QuickEnum.TRX_CODE_310003.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FagrcnlResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagrcnlResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    } else if (QuickEnum.TRX_CODE_310011.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FasttrxResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FasttrxResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    }
                    quickReturnMessage.setAipgrspErrmsg("处理失败（最终失败）");
                    logger.info("处理失败（最终失败）");
                } else {
                    if (QuickEnum.TRX_CODE_310002.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setAgrmno(((FagrcResp) resp).getAGRMNO());
                        quickReturnMessage.setRnpaRetRetCode(((FagrcResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagrcResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                        logger.info("处理成功，协议号为：" + ((FagrcResp) resp).getAGRMNO());
                    } else if (QuickEnum.TRX_CODE_310001.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FagraResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagraResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    } else if (QuickEnum.TRX_CODE_310003.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FagrcnlResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FagrcnlResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    } else if (QuickEnum.TRX_CODE_310011.getCode().equals(rsp.getINFO().getTRX_CODE())) {
                        quickReturnMessage.setRnpaRetRetCode(((FasttrxResp) resp).getRET_CODE());
                        quickReturnMessage.setRnpaRetErrmsg(((FasttrxResp) resp).getERR_MSG());
                        quickReturnMessage.setAipgrspErrmsg("处理成功（最终成功）");
                    }
                    quickReturnMessage.setAipgrspErrmsg("响应码：" + resp.getRET_CODE() + "原因：" + resp.getERR_MSG());
                    logger.info("响应码：" + resp.getRET_CODE() + "原因：" + resp.getERR_MSG());
                }
            } else if (rsp.getINFO().getRET_CODE().startsWith("2")) {
                quickReturnMessage.setAipgrspErrmsg("处理中交易，需调用查询接口查询交易最终状态");
                logger.info("处理中交易，需调用查询接口查询交易最终状态");
            } else {
                quickReturnMessage.setAipgrspErrmsg("响应码：" + rsp.getINFO().getRET_CODE() + "原因：" + rsp.getINFO().getERR_MSG());
                logger.info("响应码：" + rsp.getINFO().getRET_CODE() + "原因：" + rsp.getINFO().getERR_MSG());
            }
        }

        //交易结果查询
        if (rsp.getINFO().getTRX_CODE().equals("200004") || rsp.getINFO().getTRX_CODE().equals("200005")) {

            quickReturnMessage = new QuickReturnMessage();
            quickReturnMessage.setTrxCode(trxcode);
            quickReturnMessage.setAipgrspRetCode(rsp.getINFO().getRET_CODE());
            quickReturnMessage.setReqSn(rsp.getINFO().getREQ_SN());
            quickReturnMessage.setRepTime(rsp.getINFO().getREPTIME());

            if ("0000".equals(rsp.getINFO().getRET_CODE())) {
                quickReturnMessage.setAipgrspErrmsg("查询成功");
                QTransResp qrsq = (QTransResp) rsp.getTrxData().get(0);
                logger.info("查询成功，具体结果明细如下:");
                List<QTDetail> details = qrsq.getDetails();
                logger.info("交易查询处理逻辑details==" + details);
                quickReturnMessage.setQueryDetails(details);
                if (details != null) {
                    for (QTDetail lobj : details) {
                        logger.info("原支付交易批次号:" + lobj.getBATCHID() + "  ");
                        logger.info("记录序号:" + lobj.getSN() + "  ");
                        logger.info("账号:" + lobj.getACCOUNT_NO() + "  ");
                        logger.info("户名:" + lobj.getACCOUNT_NAME() + "  ");
                        logger.info("金额:" + lobj.getAMOUNT() + "  ");
                        logger.info("返回结果:" + lobj.getRET_CODE() + "  ");
                        if ("0000".equals(lobj.getRET_CODE())) {
                            logger.info("返回说明:交易成功  ");
                            logger.info("更新交易库状态（原交易的状态）");
                        } else {
                            logger.info("返回说明:" + lobj.getERR_MSG() + "  ");
                            logger.info("更新交易库状态（原交易的状态）");
                        }
                    }
                }
            } else if (rsp.getINFO().getRET_CODE().equals("2000")
                    || rsp.getINFO().getRET_CODE().equals("2001")
                    || rsp.getINFO().getRET_CODE().equals("2003")
                    || rsp.getINFO().getRET_CODE().equals("2005")
                    || rsp.getINFO().getRET_CODE().equals("2007")
                    || rsp.getINFO().getRET_CODE().equals("2008")) {

                quickReturnMessage.setAipgrspRetCode(rsp.getINFO().getRET_CODE());
                quickReturnMessage.setAipgrspErrmsg(rsp.getINFO().getERR_MSG() + "该状态时，说明整个批次的交易都在处理中");
                quickReturnMessage.setReqSn(rsp.getINFO().getREQ_SN());
                quickReturnMessage.setRepTime(rsp.getINFO().getREPTIME());

                logger.info("返回说明:" + rsp.getINFO().getRET_CODE() + "  ");
                logger.info("返回说明：" + rsp.getINFO().getERR_MSG());
                logger.info("该状态时，说明整个批次的交易都在处理中");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", rsp.getINFO().getRET_CODE());
                backMap.put("errMsg", rsp.getINFO().getERR_MSG());
                logger.info("交易查询处理逻辑backMap==" + backMap);

            } else if ("2004".equals(rsp.getINFO().getRET_CODE())) {
                quickReturnMessage.setAipgrspErrmsg("整批交易未受理通过（最终失败）");
                logger.info("整批交易未受理通过（最终失败）");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", rsp.getINFO().getRET_CODE());
                backMap.put("errMsg", rsp.getINFO().getERR_MSG());
                logger.info("交易查询处理逻辑backMap==" + backMap);

            } else if (rsp.getINFO().getRET_CODE().equals("1002")) {
                quickReturnMessage.setAipgrspErrmsg("查询无结果集（表示通联端根据商户请求上送的条件查不到对应的结果集）");
                logger.info("查询无结果集（表示通联端根据商户请求上送的条件查不到对应的结果集）");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", rsp.getINFO().getRET_CODE());
                backMap.put("errMsg", rsp.getINFO().getERR_MSG());
                logger.info("交易查询处理逻辑backMap==" + backMap);

            } else {
                quickReturnMessage.setAipgrspErrmsg("查询请求失败，请重新发起查询");
                logger.info("查询请求失败，请重新发起查询");

                Map backMap = Maps.newHashMap();
                backMap.put("retCode", rsp.getINFO().getRET_CODE());
                backMap.put("errMsg", rsp.getINFO().getERR_MSG());
                logger.info("交易查询处理逻辑backMap==" + backMap);
                throw new GMException(GMExceptionConstant.ALLINPAY_PARAME_ERROR, backMap);
            }
        }

        return quickReturnMessage;

    }

}
