package com.hc.lease.wx.service.api;

import com.hc.lease.wx.model.LeaseWxCarOtherScheme;
import com.hc.lease.common.core.dao.BaseService;

/**
* 车辆1+X方案Service
* @author Qiang
* @version 2018-04-10
*/

public interface LeaseWxCarOtherSchemeService extends BaseService<LeaseWxCarOtherScheme> {

    void updateByCarId(LeaseWxCarOtherScheme leaseWxCarOtherScheme);


    LeaseWxCarOtherScheme selectByCarId(Long id);

    void updateByCarIdNoSelective(LeaseWxCarOtherScheme leaseWxCarOtherScheme);

    void deleteByCarId(Long id);
}
