package com.hc.lease.wx.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.wx.model.LeaseWxSms;

public interface LeaseWxSmsMapper extends BaseDao<LeaseWxSms> {

    LeaseWxSms findByType(String typeAppointment);
}