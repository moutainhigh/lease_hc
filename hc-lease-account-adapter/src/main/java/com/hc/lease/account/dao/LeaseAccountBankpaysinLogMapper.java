package com.hc.lease.account.dao;

import com.hc.lease.account.model.LeaseAccountBankpaysinLog;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

/**
 * 承租人银行卡通联支付签约日志
 */
public interface LeaseAccountBankpaysinLogMapper extends BaseDao<LeaseAccountBankpaysinLog> {

    /**
     * 根据用户主键Id删除数据
     *
     * @param accountId
     * @return
     * @throws GMException
     */
    int deleteByAccountId(Long accountId) throws GMException;

}