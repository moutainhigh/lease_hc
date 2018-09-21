package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseInvoiceHeader;
import com.hc.lease.common.core.dao.BaseDao;

import java.util.Map;

/**
 * 发票抬头信息
 */
public interface LeaseInvoiceHeaderMapper extends BaseDao<LeaseInvoiceHeader> {

    LeaseInvoiceHeader selectByCarSupplierIdAndType(Long id);

    int disableByPrimaryKey(Map<String, Object> params);
}