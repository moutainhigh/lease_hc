package com.allinpay.param.query;

import java.io.Serializable;

public class QTDetail implements Serializable
{
	private String BATCHID;
	private String SN;
	private String TRXDIR;
	private String SETTDAY;
	private String FINTIME;
	private String SUBMITTIME;
	private String ACCOUNT_NO;
	private String ACCOUNT_NAME;
	private String AMOUNT;
	private String CUST_USERID;
	private String REMARK;
	private String RET_CODE;
	private String ERR_MSG;

	public String getBATCHID() {
		return BATCHID;
	}

	public void setBATCHID(String BATCHID) {
		this.BATCHID = BATCHID;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String SN) {
		this.SN = SN;
	}

	public String getTRXDIR() {
		return TRXDIR;
	}

	public void setTRXDIR(String TRXDIR) {
		this.TRXDIR = TRXDIR;
	}

	public String getSETTDAY() {
		return SETTDAY;
	}

	public void setSETTDAY(String SETTDAY) {
		this.SETTDAY = SETTDAY;
	}

	public String getFINTIME() {
		return FINTIME;
	}

	public void setFINTIME(String FINTIME) {
		this.FINTIME = FINTIME;
	}

	public String getSUBMITTIME() {
		return SUBMITTIME;
	}

	public void setSUBMITTIME(String SUBMITTIME) {
		this.SUBMITTIME = SUBMITTIME;
	}

	public String getACCOUNT_NO() {
		return ACCOUNT_NO;
	}

	public void setACCOUNT_NO(String ACCOUNT_NO) {
		this.ACCOUNT_NO = ACCOUNT_NO;
	}

	public String getACCOUNT_NAME() {
		return ACCOUNT_NAME;
	}

	public void setACCOUNT_NAME(String ACCOUNT_NAME) {
		this.ACCOUNT_NAME = ACCOUNT_NAME;
	}

	public String getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(String AMOUNT) {
		this.AMOUNT = AMOUNT;
	}

	public String getCUST_USERID() {
		return CUST_USERID;
	}

	public void setCUST_USERID(String CUST_USERID) {
		this.CUST_USERID = CUST_USERID;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
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
		return "QTDetail{" +
				"BATCHID='" + BATCHID + '\'' +
				", SN='" + SN + '\'' +
				", TRXDIR='" + TRXDIR + '\'' +
				", SETTDAY='" + SETTDAY + '\'' +
				", FINTIME='" + FINTIME + '\'' +
				", SUBMITTIME='" + SUBMITTIME + '\'' +
				", ACCOUNT_NO='" + ACCOUNT_NO + '\'' +
				", ACCOUNT_NAME='" + ACCOUNT_NAME + '\'' +
				", AMOUNT='" + AMOUNT + '\'' +
				", CUST_USERID='" + CUST_USERID + '\'' +
				", REMARK='" + REMARK + '\'' +
				", RET_CODE='" + RET_CODE + '\'' +
				", ERR_MSG='" + ERR_MSG + '\'' +
				'}';
	}
}
