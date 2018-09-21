package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseContractSms;

public interface LeaseContractSmsMapper  extends BaseDao<LeaseContractSms>{
    int deleteByPrimaryKey(Long id);

    int insert(LeaseContractSms record);

    int insertSelective(LeaseContractSms record);

    LeaseContractSms selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseContractSms record);

    int updateByPrimaryKey(LeaseContractSms record);
}