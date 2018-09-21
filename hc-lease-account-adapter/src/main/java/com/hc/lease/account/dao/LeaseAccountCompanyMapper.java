package com.hc.lease.account.dao;

import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountCompany;
import com.hc.lease.account.model.LeaseAccountCredit;
import com.hc.lease.account.vo.LeaseAccountCompanyExcel;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 注册公司类型用户/承租人
 */
public interface LeaseAccountCompanyMapper extends BaseDao<LeaseAccountCompany> {

    int updateByAccountId(LeaseAccountCompany leaseAccountCompany);

    int deleteByAccountId(Long accountId);

    LeaseAccount selectBy(Long id);

    List<LeaseAccount> findByPage(Map<String, Object> paramsMap) throws GMException;

    List<LeaseAccountCompanyExcel> findAllByCompanyExcel(Object o);
}