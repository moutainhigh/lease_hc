package com.hc.lease.order.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractLinkRepayment;
import com.hc.lease.order.vo.FindLinkVo;

import java.util.List;
import java.util.Map;

/**
 * 融租合同-挂靠还款明细，挂靠还款时间跟月租还款时间相同，首次操作还款则添加一条记录，即一个扣款日一条记录，类似还款计划明细，假如没有操作扣款而被检测到过期则自动添加一条过期月份的记录Service
 *
 * @author Tong
 * @version 2017-08-24
 */

public interface LeaseContractLinkRepaymentService extends BaseService<LeaseContractLinkRepayment> {

    /**
     * 融租合同的 当月挂靠、过期未付款的挂靠
     *
     * @param paramsMap
     * @return
     */
    List<FindLinkVo> findLink(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 融租合同的 已逾期的挂靠
     *
     * @param paramsMap
     * @return
     */
    List<LeaseContractLinkRepayment> findOverdue(Map<String, Object> paramsMap);

    /**
     * 检测 融租合同的 已逾期的挂靠
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<LeaseContractLinkRepayment> checkOverdue(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 批量更新
     *
     * @param leaseContractLinkRepaymentList
     */
    void batchUpdate(List<LeaseContractLinkRepayment> leaseContractLinkRepaymentList);

}
