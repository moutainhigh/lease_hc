package com.hc.lease.account.dao;

import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.vo.LeaseAccountBankExcel;
import com.hc.lease.common.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

public interface LeaseAccountBankCardMapper extends BaseDao<LeaseAccountBankCard> {

    void deleteByAccountId(Long id);

    LeaseAccountBankCard selectByBackCardNumberAndAccountId(Map<String, Object> params);

    List<LeaseAccountBankCard> selectByAccountId(Long id);

    List<LeaseAccountBankExcel> findAllByExcel(Object o);

    LeaseAccountBankCard findByAccountIdAndBackCardNumber(Map<String, Object> params);

    LeaseAccountBankCard findByAccountIdAndId(Map<String, Object> paramsMap);

    List<LeaseAccountBankCard> findByAccountInfo(Map<String, Object> params);

    int updateAccountNameByAccountId(LeaseAccountBankCard leaseAccountBankCard);

    List<String> selectBankNameByAccountId(Long id);

    List<String> selectBankCodeByAccountId(Long id);

}