package com.hc.lease.postlending.adapter.api;

import com.hc.lease.postlending.model.LeaseManualDeductionsStatist;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 手动扣款统计Adapter
 * @author Tong
 * @version 2018-07-06
 */

public interface LeaseManualDeductionsStatistAdapter extends BaseAdapter<LeaseManualDeductionsStatist> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 提交支付更新
     *
     * @param leaseManualDeductionsStatist
     * @return
     * @throws GMException
     */
    int updateOnpay(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException;

}
