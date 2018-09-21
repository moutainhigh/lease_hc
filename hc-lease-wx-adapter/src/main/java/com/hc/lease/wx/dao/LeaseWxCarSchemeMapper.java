package com.hc.lease.wx.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.wx.model.LeaseWxCarScheme;

import java.util.List;

public interface LeaseWxCarSchemeMapper extends BaseDao<LeaseWxCarScheme>{

    void deleteByCarId(Long id);

    List<LeaseWxCarScheme> selectByCarId(Long id);
}