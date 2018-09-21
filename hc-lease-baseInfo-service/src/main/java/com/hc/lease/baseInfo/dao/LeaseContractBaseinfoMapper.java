package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 融租合同基础数据
 */
public interface LeaseContractBaseinfoMapper extends BaseDao<LeaseContractBaseinfo> {

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseContractBaseinfo> findByName(Map params) throws GMException;

}