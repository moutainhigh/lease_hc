package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatusH;
import com.hc.lease.order.vo.FindByContractIdAndPeriodVo;

import java.util.List;
import java.util.Map;

public interface LeaseSchemeRepaymentStatusHMapper extends BaseDao<LeaseSchemeRepaymentStatusH> {

    /**
     * 合同修改时 查询合同原还款历史的还款状态
     *
     * @param paramsMap
     * @return
     */
    List<FindByContractIdAndPeriodVo> findByContractIdAndPeriod(Map<String, Object> paramsMap);

}