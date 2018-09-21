package com.aipg.accttrans;

import java.io.Serializable;

public class AcctTransferReq  implements Serializable {
	private String PAYEECUSID;
	private String AMOUNT;
	private String MEMO;
	public String getPAYEECUSID() {
		return PAYEECUSID;
	}
	public void setPAYEECUSID(String pAYEECUSID) {
		PAYEECUSID = pAYEECUSID;
	}
	public String getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(String aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public String getMEMO() {
		return MEMO;
	}
	public void setMEMO(String mEMO) {
		MEMO = mEMO;
	}
}
