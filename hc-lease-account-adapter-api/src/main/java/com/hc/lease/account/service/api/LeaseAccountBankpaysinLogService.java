package com.hc.lease.account.service.api;

import com.hc.lease.account.model.LeaseAccountBankpaysinLog;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

/**
* 承租人银行卡通联支付签约日志Service
* @author Tong
* @version 2018-04-23
*/

public interface LeaseAccountBankpaysinLogService extends BaseService<LeaseAccountBankpaysinLog> {

    /**
     * 根据用户主键Id删除数据
     *
     * @param accountId
     * @return
     * @throws GMException
     */
    int deleteByAccountId(Long accountId) throws GMException;

}
