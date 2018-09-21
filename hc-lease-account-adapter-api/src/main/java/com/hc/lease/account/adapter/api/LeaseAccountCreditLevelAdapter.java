package com.hc.lease.account.adapter.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountCreditLevel;
import com.hc.lease.account.vo.AccountCreditLevelVo;
import com.hc.lease.account.vo.FindAccountCreditLevelVo;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;
import java.util.Map;

/**
 * 承租人评级列表 Adapter
 * Created by LJ on 2018/1/25
 */
public interface LeaseAccountCreditLevelAdapter extends BaseAdapter<LeaseAccountCreditLevel> {

    Map<String, Object> insertViewParames(Map<String, Object> paramsMap);

    /**
     * 分页查询承租人评级列表
     */
    PageInfo<AccountCreditLevelVo> findAccountCreditLevel(int pageNum, int pageSize, FindAccountCreditLevelVo pageVo);

    ResultHashMap setLevel(LeaseAccountCreditLevel leaseAccountCreditLevel) throws GMException;

    /**
     * 用户主键ID查询评级数据
     *
     * @param accountId
     * @return
     */
    LeaseAccountCreditLevel findAccountId(Long accountId);

}
