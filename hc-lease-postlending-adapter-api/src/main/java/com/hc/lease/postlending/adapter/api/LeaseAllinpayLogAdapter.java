package com.hc.lease.postlending.adapter.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpayLog;

import java.util.Map;

/**
 * 通联代收流水Adapter
 *
 * @author Tong
 * @version 2017-06-09
 */

public interface LeaseAllinpayLogAdapter extends BaseAdapter<LeaseAllinpayLog> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * @param paramsMap
     * @return
     */
    LeaseAllinpayLog findByReqSn(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 修改合同 则 跟着更新 支付流水
     *
     * @param leaseAllinpayLog
     * @return
     * @throws GMException
     */
    int updateByContractId(LeaseAllinpayLog leaseAllinpayLog) throws GMException;

}
