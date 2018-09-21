package com.hc.lease.wx.service.api;

import com.hc.lease.wx.model.LeaseWxCarScheme;
import com.hc.lease.common.core.dao.BaseService;

/**
* 车辆信息Service
* @author Qiang
* @version 2017-11-29
*/

public interface LeaseWxCarSchemeService extends BaseService<LeaseWxCarScheme> {

    void deleteByCarId(Long id);
}
