package com.hc.lease.account.dao;

import com.hc.lease.account.model.LeaseAccountBankPaySin;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.Map;

/**
 * 承租人银行卡通联支付签约
 */
public interface LeaseAccountBankPaySinMapper extends BaseDao<LeaseAccountBankPaySin> {

    /**
     * 检测银行卡是否已经授权签约成功
     *
     * @param bankCardNumber
     * @return
     * @throws GMException
     */
    LeaseAccountBankPaySin findByBankCardNumber(String bankCardNumber) throws GMException;

    /**
     * 协议支付签约
     * 新增承租人代扣授权 页面刷新请求数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    LeaseAccountBankPaySin findAccountBankCardById(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据用户主键Id修改数据
     *
     * @param leaseAccountBankPaySin
     * @return
     * @throws GMException
     */
    int updateByAccountId(LeaseAccountBankPaySin leaseAccountBankPaySin) throws GMException;

    /**
     * 根据用户主键Id删除数据
     *
     * @param accountId
     * @return
     * @throws GMException
     */
    int deleteByAccountId(Long accountId) throws GMException;

    /**
     * 根据用户主键Id修改用户名
     *
     * @param leaseAccountBankPaySin
     * @return
     * @throws GMException
     */
    int updateAccountNameByAccountId(LeaseAccountBankPaySin leaseAccountBankPaySin) throws GMException;

}