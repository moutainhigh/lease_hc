package com.hc.lease.account.dao;

import com.hc.lease.account.model.LeaseAccountCreditLevel;
import com.hc.lease.account.vo.AccountCreditLevelVo;
import com.hc.lease.account.vo.FindAccountCreditLevelVo;
import com.hc.lease.common.core.dao.BaseDao;

import java.util.List;

/**
 * 承租人评级列表
 *
 * @author xuzhencheng
 * @since 2018-01-15
 */
public interface LeaseAccountCreditLevelMapper extends BaseDao<LeaseAccountCreditLevel> {

    /**
     * 分页查询承租人评级列表
     */
    List<AccountCreditLevelVo> findAccountCreditLevel(FindAccountCreditLevelVo pageVo);

    int setLevel(LeaseAccountCreditLevel leaseAccountCreditLevel);

    /**
     * 用户主键ID查询评级数据
     *
     * @param accountId
     * @return
     */
    LeaseAccountCreditLevel findAccountId(Long accountId);

}
