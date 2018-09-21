package com.hc.lease.order.adapter.api;

import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatusH;
import com.hc.lease.order.vo.FindByContractIdAndPeriodVo;

import java.util.List;
import java.util.Map;

/**
 * 支付状态汇总管理 历史Adapter
 *
 * @author Tong
 * @version 2018-07-19
 */

public interface LeaseSchemeRepaymentStatusHAdapter extends BaseAdapter<LeaseSchemeRepaymentStatusH> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 合同修改时 查询合同原还款历史的还款状态
     *
     * @param paramsMap
     * @return
     */
    List<FindByContractIdAndPeriodVo> findByContractIdAndPeriod(Map<String, Object> paramsMap);

}
