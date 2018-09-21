package com.hc.lease.common.allinpay.adapter;

import com.aipg.acctvalid.ValbSum;
import com.aipg.acctvalid.ValidBD;
import com.aipg.acctvalid.ValidBReq;
import com.aipg.acctvalid.VbDetail;
import com.aipg.common.AipgReq;
import com.aipg.common.InfoReq;
import com.aipg.common.MakeReq;
import com.aipg.idverify.IdVer;
import com.aipg.idverify.VerQry;
import com.aipg.payreq.Body;
import com.aipg.payreq.Trans_Sum;
import com.aipg.rtreq.Trans;
import com.aipg.singleacctvalid.ValidR;
import com.aipg.transquery.TransQueryReq;
import com.allinpay.XmlTools;
import com.allinpay.data.QuickData;
import com.allinpay.model.QuickReturnMessage;
import com.allinpay.param.quick.FagrcReq;
import com.allinpay.param.quick.FasttrxReq;
import com.allinpay.util.QuickEnum;
import com.hc.lease.common.allinpay.QuickTeansxUtils;
import com.hc.lease.common.allinpay.TeansxUtils;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.BusiCode;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.TranxCode;
import com.hc.lease.common.core.constant.TranxConfig;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.vo.PostlendingPaymentParameVo;
import com.hc.lease.postlending.vo.TransBody;
import com.ym.common.redis.template.ShardedJedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通联支付
 * Created by tong on 2017/6/2.
 */
@Service("tranxAdapter")
public class TranxAdapterImpl implements TranxAdapter {

    TranxConfig tranxConfig = new TranxConfig();
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private TeansxUtils teansxUtils;
    @Autowired
    private QuickTeansxUtils quickTeansxUtils;

    @Resource
    ShardedJedisTemplate shardedJedisTemplate;

    /**
     * 批量代收
     * trx_code 100001批量代收 100002批量代付 100011单笔实时代收 100014单笔实时代付
     *
     * @param postlendingPaymentParameVo
     * @return
     * @throws GMException
     */
    public ReturnMessage batchTranx(PostlendingPaymentParameVo postlendingPaymentParameVo, DubboTreaceParames dubboTreaceParames) throws GMException {

        String xml = "";
        AipgReq aipg = new AipgReq();
        InfoReq info = teansxUtils.makeReq(new MakeReq("5", "2", "03"), postlendingPaymentParameVo.getTrxCode(), tranxConfig);
        aipg.setINFO(info);

        Body body = new Body();
        Trans_Sum trans_sum = new Trans_Sum();
        trans_sum.setBUSINESS_CODE(postlendingPaymentParameVo.getBusiCode());
        trans_sum.setMERCHANT_ID(tranxConfig.merchantId);
        trans_sum.setTOTAL_ITEM(postlendingPaymentParameVo.getNumber() == null ? "0" : postlendingPaymentParameVo.getNumber().toString());
        trans_sum.setTOTAL_SUM(postlendingPaymentParameVo.getTotalPrice() == null ? "0" : postlendingPaymentParameVo.getTotalPrice().toString());
        body.setTRANS_SUM(trans_sum);

        body.setDetails(postlendingPaymentParameVo.getTransList());
        aipg.addTrx(body);

        xml = XmlTools.buildXml(aipg, true);
        ReturnMessage returnMessage = teansxUtils.dealRet(teansxUtils.sendToTlt(xml, tranxConfig.isTLTFront, tranxConfig.tranURL, tranxConfig));

        return returnMessage;
    }

    /**
     * 实时单笔代收付/代收
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    public ReturnMessage singleTranx(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {
        String xml = "";
        AipgReq aipg = new AipgReq();
        InfoReq info = teansxUtils.makeReq(new MakeReq("5", "2", "03"), transBody.getTrxCode(), tranxConfig);//组装报文头部
        aipg.setINFO(info);
        Trans trans = new Trans();
        trans.setBUSINESS_CODE(transBody.getBusiCode());
        trans.setMERCHANT_ID(tranxConfig.merchantId);
        trans.setSUBMIT_TIME(df.format(new Date()));
        trans.setACCOUNT_NAME(transBody.getBankAccountName());
        trans.setACCOUNT_NO(transBody.getBankAccountNo());
        trans.setACCOUNT_PROP("0");
//		trans.setACCOUNT_TYPE("01");
        BigDecimal totlePrice = transBody.getTotlePrice().multiply(new BigDecimal(100));//因为通联的金额用 分 做单位
        totlePrice = new BigDecimal(totlePrice.intValue());
        trans.setAMOUNT(transBody.getTotlePrice() == null ? "0" : totlePrice.toString());
        trans.setBANK_CODE(transBody.getBankCode());
        trans.setCURRENCY("CNY");
        trans.setCUST_USERID(transBody.getCustUserid());
        trans.setTEL("");

        aipg.addTrx(trans);

        xml = XmlTools.buildXml(aipg, true);

        ReturnMessage returnMessage = teansxUtils.dealRet(teansxUtils.sendToTlt(xml, tranxConfig.isTLTFront, tranxConfig.tranURL, tranxConfig));

        return returnMessage;
    }

    /**
     * 单笔实时身份验证/账户实名验证(四要素)
     *
     * @return
     * @throws GMException
     */
    public ReturnMessage singleAcctVerify(TransBody transBody) throws GMException {
        String xml = "";
        AipgReq aipgReq = new AipgReq();
        InfoReq info = teansxUtils.makeReq(new MakeReq("5", "2", "03"), "211004", tranxConfig);
        aipgReq.setINFO(info);

        ValidR valid = new ValidR();
        valid.setACCOUNT_NAME(transBody.getBankAccountName());//银行卡用户名
        valid.setACCOUNT_NO(transBody.getBankAccountNo());//银行号卡号
//		valid.setACCOUNT_PROP("1");
//		valid.setACCOUNT_TYPE("01");
        valid.setBANK_CODE(transBody.getBankCode());//银行代码
        valid.setID(transBody.getIdCard());//身份证
        valid.setID_TYPE("0");
        valid.setMERCHANT_ID(tranxConfig.merchantId);
        valid.setTEL(tranxConfig.tel);
        valid.setSUBMIT_TIME(df.format(new Date()));
        valid.setREMARK("单笔实时身份验证-备注字段");
        aipgReq.addTrx(valid);

        xml = XmlTools.buildXml(aipgReq, true);//
        String resp = teansxUtils.sendToTlt(xml, tranxConfig.isTLTFront, tranxConfig.tranURL, tranxConfig);
        ReturnMessage returnMessage = teansxUtils.dealRet(resp);
        return returnMessage;
    }

    /**
     * 批量账户验证
     *
     * @return
     */
    public ReturnMessage batchAcctVerify(TransBody transBody) throws GMException {
        String xml = "";
        AipgReq aipgReq = new AipgReq();
        InfoReq info = teansxUtils.makeReq(new MakeReq("5", "2", "03"), "211000", tranxConfig);
        aipgReq.setINFO(info);

        ValidBReq vbreq = new ValidBReq();
        ValbSum VALBSUM = new ValbSum();
        VALBSUM.setMERCHANT_ID(tranxConfig.merchantId);
        VALBSUM.setSUBMIT_TIME(df.format(new Date()));
        VALBSUM.setTOTAL_ITEM("12");
//		VALBSUM.setTOTAL_SUM("200000");

        ValidBD VALIDBD = new ValidBD();
        VbDetail vbdetail = null;
        for (int i = 0; i < 12; i++) {
            if (i % 2 != 0)
                tranxConfig.bankcode = "0104";
            if (i % 3 != 0)
                tranxConfig.bankcode = "0105";
            vbdetail = new VbDetail();
            vbdetail.setACCOUNT_NAME(tranxConfig.acctName + i);
            vbdetail.setACCOUNT_NO(tranxConfig.acctNo + i);
            vbdetail.setACCOUNT_PROP("1");
            vbdetail.setACCOUNT_TYPE("01");
            vbdetail.setBANK_CODE(tranxConfig.bankcode);
            vbdetail.setSN("00" + i);
            vbdetail.setTEL(tranxConfig.tel);
            vbdetail.setOPTYPE("01");//01—新增；02—解除；03—更改
            vbdetail.setID_TYPE("0");//证件类型：0 身份证
            vbdetail.setID("44201010423543543543");//身份证号
            VALIDBD.addDTL(vbdetail);
        }
        vbreq.setVALBSUM(VALBSUM);
        vbreq.setVALIDBD(VALIDBD);
        aipgReq.addTrx(vbreq);

        xml = XmlTools.buildXml(aipgReq, true).replaceAll("<details>\n", "").replaceAll("</details>\n", "");
        String resp = teansxUtils.sendToTlt(xml, tranxConfig.isTLTFront, tranxConfig.tranURL, tranxConfig);
        ReturnMessage returnMessage = teansxUtils.dealRet(resp);
        return returnMessage;
    }

    /**
     * 交易查询/轮询/通联平台查询
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    public ReturnMessage queryTradeNew(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        String xml = "";
        AipgReq aipgReq = new AipgReq();
        InfoReq info = teansxUtils.makeReq(new MakeReq("5", "2", "03"), TranxCode.QUERYTRADENEW, tranxConfig);
        aipgReq.setINFO(info);
        TransQueryReq dr = new TransQueryReq();
        aipgReq.addTrx(dr);
        dr.setMERCHANT_ID(tranxConfig.merchantId);
        dr.setQUERY_SN(transBody.getReqSn());
        dr.setSTATUS(1);
        dr.setTYPE(1);
//		dr.setSTATUS(2);
        if (transBody.getReqSn() == null || "".equals(transBody.getReqSn())) {
            dr.setSTART_DAY(transBody.getStartDate());
            dr.setEND_DAY(transBody.getEndDate());
        }
        xml = XmlTools.buildXml(aipgReq, true);
        ReturnMessage returnMessage = teansxUtils.dealRet(teansxUtils.sendToTlt(xml, tranxConfig.isTLTFront, tranxConfig.tranURL, tranxConfig));
        return returnMessage;
    }

    /**
     * 国民身份验证
     *
     * @return
     */
    public ReturnMessage idVerify(TransBody transBody) throws GMException {
        String xml = "";
        AipgReq aipgReq = new AipgReq();
        InfoReq info = teansxUtils.makeReq(new MakeReq("5", "2", "03"), "220001", tranxConfig);
        aipgReq.setINFO(info);
        IdVer vbreq = new IdVer();
        vbreq.setNAME("555");
        vbreq.setIDNO("320113196912021509");
        aipgReq.addTrx(vbreq);
        xml = XmlTools.buildXml(aipgReq, true);
        String resp = teansxUtils.sendToTlt(xml, tranxConfig.isTLTFront, tranxConfig.tranURL, tranxConfig);
        ReturnMessage returnMessage = teansxUtils.dealRet(resp);
        return returnMessage;
    }

    /**
     * 国民身份验证查询
     *
     * @return
     */
    public ReturnMessage idVerifyQ(TransBody transBody) throws GMException {
        String xml = "";
        AipgReq aipgReq = new AipgReq();
        InfoReq info = teansxUtils.makeReq(new MakeReq("5", "2", "03"), "220003", tranxConfig);
        aipgReq.setINFO(info);

        VerQry vbreq = new VerQry();

        vbreq.setQSN("200604000000445-1431575761436");
        vbreq.setQTARGET("1");
        aipgReq.addTrx(vbreq);

        xml = XmlTools.buildXml(aipgReq, true);
        String resp = teansxUtils.sendToTlt(xml, tranxConfig.isTLTFront, tranxConfig.tranURL, tranxConfig);
        ReturnMessage returnMessage = teansxUtils.dealRet(resp);
        return returnMessage;
    }

    /**
     * 协议支付签约短信触发
     *
     * @param data
     */
    @Override
    public QuickReturnMessage sendMessage(QuickData data) throws GMException {
        String xml = "";
        com.allinpay.param.common.AipgReq aipg = new com.allinpay.param.common.AipgReq();
        com.allinpay.param.common.InfoReq info = quickTeansxUtils.makeReq(QuickEnum.TRX_CODE_310001.getCode());
        aipg.setINFO(info);
        com.allinpay.param.quick.FagraReq req = new com.allinpay.param.quick.FagraReq();
        req.setMERCHANT_ID(tranxConfig.quickPay_merchantId);
        req.setACCOUNT_NAME(data.getAccountName());
        req.setACCOUNT_NO(data.getAccountNo());
        req.setACCOUNT_PROP("0");
        req.setACCOUNT_TYPE(data.getAccountType());
        req.setBANK_CODE(data.getBankCode());
        req.setCVV2(data.getCvv2());
        req.setID_TYPE(data.getIdType());
        req.setMERREM(data.getMerrem());
        req.setVAILDDATE(data.getVailddate());
        req.setTEL(data.getTel());
        req.setID(data.getId());
        req.setREMARK(data.getRemark());
        aipg.addTrx(req);
        xml = com.allinpay.tool.XmlTools.buildXml(aipg, true);
        QuickReturnMessage quickReturnMessage = quickTeansxUtils.resqHandler(quickTeansxUtils.sendToTlt(xml, tranxConfig.isTLTFront));
        return quickReturnMessage;
    }

    /**
     * 协议支付签约
     *
     * @param data 验证码、手机号、银行卡号
     * @return
     * @throws GMException
     */
    @Override
    public QuickReturnMessage sign(QuickData data) throws GMException {

        String xml = "";
        com.allinpay.param.common.AipgReq aipg = new com.allinpay.param.common.AipgReq();
        com.allinpay.param.common.InfoReq info = quickTeansxUtils.makeReq(QuickEnum.TRX_CODE_310002.getCode());
        aipg.setINFO(info);
        FagrcReq req = new FagrcReq();
        req.setMERCHANT_ID(tranxConfig.quickPay_merchantId);//商户ID
        req.setVERCODE(data.getVercode());//验证码
        req.setSRCREQSN(data.getSrcreqSn());//原请求流水 / 对应申请请求报文中的REQ_SN
        aipg.addTrx(req);//
        xml = com.allinpay.tool.XmlTools.buildXml(aipg, true);
        QuickReturnMessage quickReturnMessage = quickTeansxUtils.resqHandler(quickTeansxUtils.sendToTlt(xml, tranxConfig.isTLTFront));
        return quickReturnMessage;
    }


    /**
     * 协议支付
     *
     * @param quickData
     */
    public QuickReturnMessage pay(QuickData quickData) throws GMException {
        String xml = "";
        com.allinpay.param.common.AipgReq aipg = new com.allinpay.param.common.AipgReq();
        com.allinpay.param.common.InfoReq info = quickTeansxUtils.makeReq(QuickEnum.TRX_CODE_310011.getCode());
        aipg.setINFO(info);
        FasttrxReq req = new FasttrxReq();
        req.setMERCHANT_ID(tranxConfig.quickPay_merchantId);//商户号(必填)
        req.setACCOUNT_NAME(quickData.getAccountName());//用户名(必填)
        req.setACCOUNT_NO(quickData.getAccountNo());//用户银行卡号(必填)
        req.setCURRENCY("CNY");//货币类型、人民币：CNY, 港元：HKD，美元：USD。不填时，默认为人民币。(选填)
        req.setAGRMNO(quickData.getAgrmno());//协议号(必填)
        req.setSUBMIT_TIME(dateFormat.format(new Date()));//提交时间(必填)
        req.setBUSINESS_CODE(BusiCode.BATCHTRANX_SINGLETRANX_DS_DS);
        req.setCVV2(quickData.getCvv2());//(选填)信用卡时必填
        req.setID_TYPE(quickData.getIdType());//开户证件类型(选填)
        req.setAMOUNT(quickData.getAmount());//金额、整数，单位分(必填)
        req.setVAILDDATE(quickData.getVailddate());//有效期(选填)、信用卡时必填，格式MMYY(信用卡上的两位月两位年)
        req.setTEL(quickData.getTel());//电话(选填)
        req.setID(quickData.getId());//身份证号(选填)
        req.setREMARK(quickData.getRemark());//备注(选填)
        aipg.addTrx(req);
        xml = com.allinpay.tool.XmlTools.buildXml(aipg, true);
        QuickReturnMessage quickReturnMessage = quickTeansxUtils.resqHandler(quickTeansxUtils.sendToTlt(xml, tranxConfig.isTLTFront));
        return quickReturnMessage;
    }

    /**
     * 交易查询/轮询/通联平台查询
     * 通联协议支付
     *
     * @param sn
     * @return
     * @throws GMException
     */
    @Override
    public QuickReturnMessage search(String sn, DubboTreaceParames dubboTreaceParames) throws GMException {
        String xml = "";
        com.allinpay.param.common.AipgReq aipg = new com.allinpay.param.common.AipgReq();
        com.allinpay.param.common.InfoReq info = quickTeansxUtils.makeReq(QuickEnum.TRX_CODE_200004.getCode());
        com.allinpay.param.query.TransQueryReq req = new com.allinpay.param.query.TransQueryReq();
        req.setMERCHANT_ID(tranxConfig.quickPay_merchantId);
        req.setQUERY_SN(sn);
        aipg.setINFO(info);
        aipg.addTrx(req);
        xml = com.allinpay.tool.XmlTools.buildXml(aipg, true);
        QuickReturnMessage quickReturnMessage = quickTeansxUtils.resqHandler(quickTeansxUtils.sendToTlt(xml, tranxConfig.isTLTFront));
        return quickReturnMessage;
    }
}
