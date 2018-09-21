package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseInvoiceHeader;
import com.hc.lease.common.core.dao.BaseDao;

/**
 * 发票抬头信息
 */
public interface LeaseInvoiceHeaderMapper extends BaseDao<LeaseInvoiceHeader> {

    LeaseInvoiceHeader selectByCarSupplierIdAndType(Long id);
}