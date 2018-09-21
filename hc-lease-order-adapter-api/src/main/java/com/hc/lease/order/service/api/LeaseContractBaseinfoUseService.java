package com.hc.lease.order.service.api;

import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractBaseinfoUse;

import java.util.List;
import java.util.Map;

/**
 * 融租合同基础数据Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseContractBaseinfoUseService extends BaseService<LeaseContractBaseinfoUse> {

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseContractBaseinfoUse> findByName(Map params) throws GMException;

    List<LeaseContractBaseinfoUse> findAllNoPage(Object o);
}
