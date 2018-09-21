package com.hc.lease.order.service.api;

import com.hc.lease.order.model.LeaseContractRepaymentExcept;
import com.hc.lease.common.core.dao.BaseService;

/**
* 融租合同 不用系统处理扣款的月租,录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款Service
* @author Tong
* @version 2017-09-01
*/

public interface LeaseContractRepaymentExceptService extends BaseService<LeaseContractRepaymentExcept> {

}
