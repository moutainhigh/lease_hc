package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseContractDealEnd;

/**
 * 贷后合同管理-结束处置
 */
public interface LeaseContractDealEndMapper extends BaseDao<LeaseContractDealEnd> {

    LeaseContractDealEnd findByContractId(Long contractId);

}