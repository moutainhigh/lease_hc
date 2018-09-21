package com.hc.lease.account.adapter.api;

import com.hc.lease.account.model.LeaseAccountBankpaysinLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 承租人银行卡通联支付签约日志Adapter
 * @author Tong
 * @version 2018-04-23
 */

public interface LeaseAccountBankpaysinLogAdapter extends BaseAdapter<LeaseAccountBankpaysinLog> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据用户主键Id删除数据
     *
     * @param accountId
     * @return
     * @throws GMException
     */
    int deleteByAccountId(Long accountId) throws GMException;

}
