package com.hc.lease.account.service.api;

import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.vo.LeaseAccountExcel;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 注册用户/承租人Service
 *
 * @author Tong
 * @version 2017-05-22
 */

public interface LeaseAccountService extends BaseService<LeaseAccount> {

    public List<LeaseAccount> findByPhone(Map<String, Object> paramsMap) throws GMException;

    List<LeaseAccount> selectAllAccountNoPage(Map<String, Object> paramsMap);

    List<LeaseAccount> findByIdCard(Map<String, Object> paramsMap);

    int deleteByAccountCompany(Long id) throws GMException;

    LeaseAccount selectBy(Map<String, Object> paramsMap) throws GMException;

    List<LeaseAccountExcel> findAllByExcel(Object o);

    int updateAccountNameByAccountId(LeaseAccount leaseAccount);

}
