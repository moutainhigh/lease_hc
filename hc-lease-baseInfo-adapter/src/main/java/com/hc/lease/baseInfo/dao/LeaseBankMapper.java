package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseBank;
import com.hc.lease.common.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 银行
 */
public interface LeaseBankMapper extends BaseDao<LeaseBank> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseBank> insertViewParames(Map<String, Object> paramsMap);

    List<LeaseBank> findAllNoType(Object o);

    List<String> findAllBankName();

    LeaseBank findByBankName(String bankName);
}