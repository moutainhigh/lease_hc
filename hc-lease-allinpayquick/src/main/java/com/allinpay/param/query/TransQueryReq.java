package com.allinpay.param.query;

public class TransQueryReq
{
	private String QUERY_SN;
	private String MERCHANT_ID;

	@Override
	public String toString() {
		return "TransQueryReq{" +
				"QUERY_SN='" + QUERY_SN + '\'' +
				", MERCHANT_ID='" + MERCHANT_ID + '\'' +
				'}';
	}

	public String getQUERY_SN() {
		return QUERY_SN;
	}

	public void setQUERY_SN(String QUERY_SN) {
		this.QUERY_SN = QUERY_SN;
	}

	public String getMERCHANT_ID() {
		return MERCHANT_ID;
	}

	public void setMERCHANT_ID(String MERCHANT_ID) {
		this.MERCHANT_ID = MERCHANT_ID;
	}
}
