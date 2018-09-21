package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.postlending.model.LeaseAllinpayQueryLog;
import com.hc.lease.postlending.vo.FindSuccessNoSendSmsVo;

import java.util.List;
import java.util.Map;

/**
 * 通联轮询流水，通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条代收流水都对应一条轮询流水Service
 *
 * @author Tong
 * @version 2017-08-31
 */

public interface LeaseAllinpayQueryLogService extends BaseService<LeaseAllinpayQueryLog> {

    /**
     * 未发送短信提醒的 通联轮询流水
     *
     * @param paramsMap
     * @return
     */
    List<FindSuccessNoSendSmsVo> findSuccessNoSendSms(Map<String, Object> paramsMap);

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseAllinpayQueryLog> selectByAllinpayLogId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

}
