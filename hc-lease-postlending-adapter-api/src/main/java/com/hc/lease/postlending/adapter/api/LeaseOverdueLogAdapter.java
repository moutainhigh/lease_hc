package com.hc.lease.postlending.adapter.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.postlending.model.LeaseOverdueLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 逾期记录Adapter
 * @author Tong
 * @version 2017-06-09
 */

public interface LeaseOverdueLogAdapter extends BaseAdapter<LeaseOverdueLog> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 合同修改同时修改 还款计划主键id
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

    /**
     * 批量更新
     *
     * @param leaseOverdueLogList
     * @return
     */
    int updateBatch(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames);

    /**
     * 批量新增
     *
     * @param leaseOverdueLogList
     * @return
     */
    int insertBatch(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames);

    /**
     * @param paramsMap
     * @return
     */
    LeaseOverdueLog selectByContractIdRepaymentId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

}
