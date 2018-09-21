package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseCompanyHeader;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 合同方-公司抬头
 */
public interface LeaseCompanyHeaderMapper extends BaseDao<LeaseCompanyHeader> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCompanyHeader> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseCompanyHeader> findByName(Map params) throws GMException;

}