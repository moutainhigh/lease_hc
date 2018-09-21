package com.hc.lease.order.service.api;

import com.hc.lease.order.model.LeaseContractDealEnd;
import com.hc.lease.common.core.dao.BaseService;

/**
* 贷后合同管理-结束处置Service
* @author Tong
* @version 2018-08-03
*/

public interface LeaseContractDealEndService extends BaseService<LeaseContractDealEnd> {

    LeaseContractDealEnd findByContractId(Long contractId);

}
