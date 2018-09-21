package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseContractAdvance;
import com.hc.lease.order.vo.FindAdvanceVo;

import java.util.List;
import java.util.Map;

/**
 * 融租合同 提前还款
 * 融租合同贷后管理登记为提前还款,因为提前还款款项包括尾款，罚息，剩余本金，做一个提前还款汇总记录，方便处理几种款项的支付状态
 */
public interface LeaseContractAdvanceMapper extends BaseDao<LeaseContractAdvance> {

    /**
     * 融租合同的提前还款
     *
     * @param paramsMap
     * @return
     */
    List<FindAdvanceVo> findAdvance(Map<String, Object> paramsMap);

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    int batchUpdate(List<LeaseContractAdvance> list);

}