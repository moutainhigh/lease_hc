package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseBankAllinpayPriceLimit;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 通联支付银行额度，包括通联代扣、通联协议支付 的限额Adapter
 * @author Tong
 * @version 2018-05-10
 */

public interface LeaseBankAllinpayPriceLimitAdapter extends BaseAdapter<LeaseBankAllinpayPriceLimit> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
