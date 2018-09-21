package com.hc.lease.order.adapter.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractAdvance;
import com.hc.lease.order.vo.FindAdvanceVo;

import java.util.List;
import java.util.Map;

/**
 * 融租合同贷后管理登记为提前还款,因为提前还款款项包括尾款，罚息，剩余本金，做一个提前还款汇总记录，方便处理几种款项的支付状态Adapter
 * @author Tong
 * @version 2017-08-26
 */

public interface LeaseContractAdvanceAdapter extends BaseAdapter<LeaseContractAdvance> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 融租合同的提前还款
     * @param paramsMap
     * @return
     */
    List<FindAdvanceVo> findAdvance(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

}
