package com.hc.lease.order.dao;

import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractBaseinfoUse;

import java.util.List;
import java.util.Map;

/**
 * 融租合同基础数据
 */
public interface LeaseContractBaseinfoUseMapper extends BaseDao<LeaseContractBaseinfoUse> {

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseContractBaseinfoUse> findByName(Map params) throws GMException;

}