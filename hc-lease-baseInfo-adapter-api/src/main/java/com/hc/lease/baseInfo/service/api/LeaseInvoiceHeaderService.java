package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseInvoiceHeader;
import com.hc.lease.common.core.dao.BaseService;

import java.util.Map;

/**
 * 发票抬头信息Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseInvoiceHeaderService extends BaseService<LeaseInvoiceHeader> {

    LeaseInvoiceHeader selectByCarSupplierIdAndType(Long id);

    int disableByPrimaryKey(Map<String, Object> params);
}
