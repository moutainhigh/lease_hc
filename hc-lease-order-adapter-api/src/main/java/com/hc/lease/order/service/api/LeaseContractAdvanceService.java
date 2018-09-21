package com.hc.lease.order.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.order.model.LeaseContractAdvance;
import com.hc.lease.order.vo.FindAdvanceVo;

import java.util.List;
import java.util.Map;

/**
 * 融租合同 提前还款，融租合同贷后管理登记为提前还款，预约登记Service
 *
 * @author Tong
 * @version 2017-08-25
 */

public interface LeaseContractAdvanceService extends BaseService<LeaseContractAdvance> {

    /**
     * 融租合同的提前还款
     *
     * @param paramsMap
     * @return
     */
    List<FindAdvanceVo> findAdvance(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    int batchUpdate(List<LeaseContractAdvance> list, DubboTreaceParames dubboTreaceParames);

}
