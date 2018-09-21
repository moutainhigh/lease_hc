package com.hc.lease.postlending.adapter.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.postlending.model.LeaseAllinpaySplitLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 支付流水Adapter
 * @author Tong
 * @version 2018-06-19
 */

public interface LeaseAllinpaySplitLogAdapter extends BaseAdapter<LeaseAllinpaySplitLog> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * @param paramsMap
     * @return
     */
    LeaseAllinpaySplitLog findByReqSn(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 合同修改同时修改 拆单的还款计划主键id,
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

}
