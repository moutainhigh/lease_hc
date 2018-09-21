package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseBank;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 银行Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseBankService extends BaseService<LeaseBank> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseBank> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
