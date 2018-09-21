package com.hc.lease.order.dao;

import com.hc.lease.account.model.LeaseAccountCreditLevel;
import com.hc.lease.account.vo.AccountCreditLevelVo;
import com.hc.lease.account.vo.FindAccountCreditLevelVo;

import java.util.List;

/**
 * 承租人评级列表
 *
 * @author xuzhencheng
 * @since 2018-01-15
 */
public interface LeaseAccountLevelPageMapper {

    int deleteByPrimaryKey(Long id);

    int insert(LeaseAccountCreditLevel record);

    int insertSelective(LeaseAccountCreditLevel record);

    LeaseAccountCreditLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaseAccountCreditLevel record);

    int updateByPrimaryKey(LeaseAccountCreditLevel record);

    /**
     * 分页查询承租人评级列表
     */
    List<AccountCreditLevelVo> findAccountLevelPage(FindAccountCreditLevelVo pageVo);
}
