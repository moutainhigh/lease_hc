package com.hc.lease.account.adapter.api;

import com.hc.lease.account.model.LeaseAccountCredit;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 注册用户/承租人征信信息Adapter
 *
 * @author Tong
 * @version 2017-06-06
 */

public interface LeaseAccountCreditAdapter extends BaseAdapter<LeaseAccountCredit> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int updateByAccountId(LeaseAccountCredit leaseAccountCredit);

    int deleteByAccountId(Long accountId);

    int deleteBatchByAccountId(List<Long> ids);

}
