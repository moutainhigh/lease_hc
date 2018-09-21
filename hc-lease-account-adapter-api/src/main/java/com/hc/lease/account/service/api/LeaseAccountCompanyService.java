package com.hc.lease.account.service.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountCompany;
import com.hc.lease.account.vo.LeaseAccountCompanyExcel;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 注册公司类型用户/承租人Service
 *
 * @author Tong
 * @version 2017-11-02
 */

public interface LeaseAccountCompanyService extends BaseService<LeaseAccountCompany> {

    int updateByAccountId(LeaseAccountCompany leaseAccountCompany);

    int deleteByAccountId(Long accountId);

    LeaseAccount selectBy(Long id);

    PageInfo<LeaseAccount> findByPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException;

    List<LeaseAccountCompanyExcel> findAllByCompanyExcel(Object o);
}
