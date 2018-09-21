package com.hc.lease.account.service.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.account.model.LeaseAccountCreditLevel;
import com.hc.lease.account.vo.AccountCreditLevelVo;
import com.hc.lease.account.vo.FindAccountCreditLevelVo;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;

/**
 * 承租人评级列表 Service
 * Created by LJ on 2018/1/25
 */
public interface LeaseAccountCreditLevelService extends BaseService<LeaseAccountCreditLevel> {
    /**
     * 分页查询承租人评级列表
     */
    PageInfo<AccountCreditLevelVo> findAccountCreditLevel(int pageNum, int pageSize, FindAccountCreditLevelVo pageVo);

    int setLevel(LeaseAccountCreditLevel leaseAccountCreditLevel);

    /**
     * 用户主键ID查询评级数据
     *
     * @param accountId
     * @return
     */
    LeaseAccountCreditLevel findAccountId(Long accountId);

}
