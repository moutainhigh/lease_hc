package com.hc.lease.account.service.api;

import com.hc.lease.account.model.LeaseAccountCredit;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;

/**
* 个人类型用户/承租人Service
* @author Tong
* @version 2017-06-06
*/

public interface LeaseAccountCreditService extends BaseService<LeaseAccountCredit> {

    int updateByAccountId(LeaseAccountCredit leaseAccountCredit);

    int deleteByAccountId(Long accountId);

    int deleteBatchByAccountId(List<Long> ids);

    void updateByAccountIdPrimaryKeySelective(LeaseAccountCredit leaseAccountCredit);
}
