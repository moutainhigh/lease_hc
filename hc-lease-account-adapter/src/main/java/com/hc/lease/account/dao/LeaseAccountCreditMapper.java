package com.hc.lease.account.dao;

import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountCredit;
import com.hc.lease.common.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 个人类型用户/承租人
 * Created by Tong on 2017/3/31.
 */
public interface LeaseAccountCreditMapper extends BaseDao<LeaseAccountCredit> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseAccount> insertViewParames(Map<String, Object> paramsMap);

    int updateByAccountId(LeaseAccountCredit leaseAccountCredit);

    int deleteByAccountId(Long accountId);

    int deleteBatchByAccountId(List<Long> ids);

    void updateByAccountIdPrimaryKeySelective(LeaseAccountCredit leaseAccountCredit);
}
