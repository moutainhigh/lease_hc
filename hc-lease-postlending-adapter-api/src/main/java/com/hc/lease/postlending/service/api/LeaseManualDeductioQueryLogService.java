package com.hc.lease.postlending.service.api;

import com.hc.lease.postlending.model.LeaseManualDeductioQueryLog;
import com.hc.lease.common.core.dao.BaseService;

/**
* 手动扣款通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条支付流水都对应一条轮询流水Service
* @author Tong
* @version 2018-07-06
*/

public interface LeaseManualDeductioQueryLogService extends BaseService<LeaseManualDeductioQueryLog> {

}
