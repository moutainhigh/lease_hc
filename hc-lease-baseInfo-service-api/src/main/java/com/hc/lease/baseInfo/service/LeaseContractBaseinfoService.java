package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 融租合同基础数据Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseContractBaseinfoService extends BaseService<LeaseContractBaseinfo> {

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseContractBaseinfo> findByName(Map params) throws GMException;

    List<LeaseContractBaseinfo> findAllNoPage(Object o);
}
