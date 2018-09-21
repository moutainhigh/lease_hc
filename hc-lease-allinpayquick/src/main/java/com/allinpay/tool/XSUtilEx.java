package com.allinpay.tool;

import com.allinpay.param.common.AipgReq;
import com.allinpay.param.common.AipgRsp;
import com.allinpay.param.common.InfoReq;
import com.allinpay.param.query.QTDetail;
import com.allinpay.param.query.QTransResp;
import com.allinpay.param.query.TransQueryReq;
import com.allinpay.param.quick.*;
import com.thoughtworks.xstream.XStream;

public class XSUtilEx
{
	private static final String HEAD = "<?xml version=\"1.0\" encoding=\"GBK\"?>";

	public static AipgReq xmlReq(String xmlMsg)
	{
		XStream xs=new XStreamIg();
		XSUtilEx.initXStream(xs, true);
		AipgReq req=(AipgReq) xs.fromXML(xmlMsg);
		return req;
	}
	public static AipgRsp xmlRsp(String xmlMsg)
	{
		XStream xs=new XStreamIg();
		XSUtilEx.initXStream(xs, false);
		AipgRsp rsp=(AipgRsp) xs.fromXML(xmlMsg);
		return rsp;
	}
	public static String reqXml(AipgReq req)
	{
		XStream xs=new XStreamIg();
		XSUtilEx.initXStream(xs, true);
		String xml=HEAD+xs.toXML(req);
		xml=xml.replace("__", "_");
		return xml;
	}
	public static String rspXml(AipgRsp rsp)
	{
		XStream xs=new XStreamIg();
		XSUtilEx.initXStream(xs, false);
		String xml=HEAD+xs.toXML(rsp);
		xml=xml.replace("__", "_");
		return xml;
	}
	public static void initXStream(XStream xs,boolean isreq)
	{
		if(isreq) 
			xs.alias("AIPG", AipgReq.class); 
		else 
			xs.alias("AIPG", AipgRsp.class);

		xs.alias("INFO", InfoReq.class);
		xs.addImplicitCollection(AipgReq.class, "trxData");
		xs.addImplicitCollection(AipgRsp.class, "trxData");
		xs.alias("FAGRA", FagraReq.class);
		xs.alias("FAGRARET", FagraResp.class);
		xs.alias("FAGRCNL", FagrcnlReq.class);
		xs.alias("FAGRCNLRET", FagrcnlResp.class);
		xs.alias("FAGRC", FagrcReq.class);
		xs.alias("FAGRCRET", FagrcResp.class);
		xs.alias("FASTTRX", FasttrxReq.class);
		xs.alias("FASTTRXRET", FasttrxResp.class);
		xs.addImplicitCollection(QTransResp.class, "details");
		xs.alias("QTDETAIL", QTDetail.class);
		xs.alias("QTRANSREQ", TransQueryReq.class);
		xs.alias("QTRANSRSP", QTransResp.class);
	}

}
