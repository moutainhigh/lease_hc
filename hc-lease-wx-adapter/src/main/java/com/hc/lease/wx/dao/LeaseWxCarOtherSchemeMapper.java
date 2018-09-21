package com.hc.lease.wx.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.wx.model.LeaseWxCarOtherScheme;

public interface LeaseWxCarOtherSchemeMapper extends BaseDao<LeaseWxCarOtherScheme> {

    void updateByCarId(LeaseWxCarOtherScheme leaseWxCarOtherScheme);

    LeaseWxCarOtherScheme selectByCarId(Long id);

    void updateByCarIdNoSelective(LeaseWxCarOtherScheme leaseWxCarOtherScheme);

    void deleteByCarId(Long id);
}