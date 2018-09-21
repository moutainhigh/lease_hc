package com.aipg.transquery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("unchecked")
public class QTransRsp  implements Serializable {
	private List details;
	public List getDetails()
	{
		return details;
	}

	public void setDetails(List details)
	{
		this.details = details;
	}
	public void addDtl(QTDetail dtl)
	{
		if(details==null) details=new ArrayList();
		details.add(dtl);
	}
}
