package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseManualDeductionsStatist;
import com.hc.lease.common.core.dao.BaseService;

/**
* 手动扣款统计Service
* @author Tong
* @version 2018-07-06
*/

public interface LeaseManualDeductionsStatistService extends BaseService<LeaseManualDeductionsStatist> {

    /**
     * 提交支付更新
     *
     * @param leaseManualDeductionsStatist
     * @return
     * @throws GMException
     */
    int updateOnpay(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException;

}
