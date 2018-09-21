package com.aipg.payresp;

public class Ret_Detail {
	private String SN="";
	private String RET_CODE="";
	private String ERR_MSG="";
	
	
	public String getSN() {
		return SN;
	}
	public void setSN(String sn) {
		SN = sn;
	}
	public String getRET_CODE() {
		return RET_CODE;
	}
	public void setRET_CODE(String ret_code) {
		RET_CODE = ret_code;
	}
	public String getERR_MSG() {
		return ERR_MSG;
	}
	public void setERR_MSG(String sn) {
		ERR_MSG = sn;
	}

	@Override
	public String toString() {
		return "Ret_Detail{" +
				"SN='" + SN + '\'' +
				", RET_CODE='" + RET_CODE + '\'' +
				", ERR_MSG='" + ERR_MSG + '\'' +
				'}';
	}
}
