package com.hc.lease.order.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatusH;
import com.hc.lease.order.vo.FindByContractIdAndPeriodVo;

import java.util.List;
import java.util.Map;

/**
 * 支付状态汇总管理 历史Service
 *
 * @author Tong
 * @version 2018-07-19
 */

public interface LeaseSchemeRepaymentStatusHService extends BaseService<LeaseSchemeRepaymentStatusH> {

    /**
     * 合同修改时 查询合同原还款历史的还款状态
     *
     * @param paramsMap
     * @return
     */
    List<FindByContractIdAndPeriodVo> findByContractIdAndPeriod(Map<String, Object> paramsMap);

}
