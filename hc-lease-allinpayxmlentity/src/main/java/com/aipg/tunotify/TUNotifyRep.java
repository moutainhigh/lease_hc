package com.aipg.tunotify;

import java.io.Serializable;

public class TUNotifyRep  implements Serializable {
	private String ACCTNO;
	private String TRXID;
	
	public String getACCTNO() {
		return ACCTNO;
	}
	public void setACCTNO(String aCCTNO) {
		ACCTNO = aCCTNO;
	}
	public String getTRXID() {
		return TRXID;
	}
	public void setTRXID(String tRXID) {
		TRXID = tRXID;
	}
}
