package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeasePackageBalancePayment;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;

/**
 * 融租方案-尾款Service
 *
 * @author Qiang
 * @version 2017-11-02
 */

public interface LeasePackageBalancePaymentService extends BaseService<LeasePackageBalancePayment> {

    void deleteByPackageId(Long packageId) throws GMException;

    LeasePackageBalancePayment selectBySchemeId(Long schemeId) throws GMException;

    List<LeasePackageBalancePayment> findBySchemeId(Long schemeId) throws GMException;

}
