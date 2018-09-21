package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractLink;
import com.hc.lease.order.model.LeaseSchemeRepayment;

import java.util.List;
import java.util.Map;

/**
 * 融租合同 挂靠
 * 租期结束且融租合同贷后管理登记为挂靠
 */
public interface LeaseContractLinkMapper extends BaseDao<LeaseContractLink> {

}