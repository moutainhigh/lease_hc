package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseContractDealEnd;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 贷后合同管理-结束处置Adapter
 * @author Tong
 * @version 2018-08-03
 */

public interface LeaseContractDealEndAdapter extends BaseAdapter<LeaseContractDealEnd> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    LeaseContractDealEnd findByContractId(Long contractId);

}
