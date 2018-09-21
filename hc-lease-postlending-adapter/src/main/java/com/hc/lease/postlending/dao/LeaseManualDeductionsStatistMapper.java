package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseManualDeductionsStatist;

public interface LeaseManualDeductionsStatistMapper extends BaseDao<LeaseManualDeductionsStatist> {

    /**
     * 提交支付更新
     *
     * @param leaseManualDeductionsStatist
     * @return
     * @throws GMException
     */
    int updateOnpay(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException;

}