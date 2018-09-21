package com.hc.lease.account.service.api;

import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.vo.LeaseAccountBankExcel;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 承租人银行卡Service
 *
 * @author Qiang
 * @version 2018-01-15
 */

public interface LeaseAccountBankCardService extends BaseService<LeaseAccountBankCard> {

    void deleteByAccountId(Long id);

    LeaseAccountBankCard selectByBackCardNumberAndAccountId(LeaseAccountBankCard leaseAccountBankCard);

    List<LeaseAccountBankCard> selectByAccountId(Long id);

    List<LeaseAccountBankExcel> findAllByExcel(Object o);

    LeaseAccountBankCard findByAccountIdAndBackCardNumber(Map<String, Object> params);

    LeaseAccountBankCard findByAccountIdAndId(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据 手机、身份证、银行主键Id、银行卡或存折号码 查询
     *
     * @param params
     * @return
     */
    List<LeaseAccountBankCard> findByAccountInfo(Map<String, Object> params);

    int updateAccountNameByAccountId(LeaseAccountBankCard leaseAccountBankCard);

}
