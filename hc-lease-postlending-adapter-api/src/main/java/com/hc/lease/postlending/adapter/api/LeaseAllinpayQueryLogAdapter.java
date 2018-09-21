package com.hc.lease.postlending.adapter.api;

import com.hc.lease.postlending.model.LeaseAllinpayQueryLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 通联轮询流水，通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条代收流水都对应一条轮询流水Adapter
 * @author Tong
 * @version 2017-08-31
 */

public interface LeaseAllinpayQueryLogAdapter extends BaseAdapter<LeaseAllinpayQueryLog> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
