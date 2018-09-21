package com.hc.lease.wx.service.api;

import com.hc.lease.wx.model.LeaseWxSms;
import com.hc.lease.common.core.dao.BaseService;

/**
* 小程序短信参数配置Service
* @author Qiang
* @version 2018-03-23
*/

public interface LeaseWxSmsService extends BaseService<LeaseWxSms> {

    LeaseWxSms findByType(String typeAppointment);
}
