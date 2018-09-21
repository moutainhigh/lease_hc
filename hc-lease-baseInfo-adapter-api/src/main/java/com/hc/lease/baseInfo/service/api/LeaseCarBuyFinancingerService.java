package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseCarBuyFinancinger;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 购车融资方Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseCarBuyFinancingerService extends BaseService<LeaseCarBuyFinancinger> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarBuyFinancinger> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseCarBuyFinancinger> findByName(Map params) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    void updateSort(LeaseCarBuyFinancinger carBuyFinancinger);

    List<LeaseCarBuyFinancinger> findAllNoPage(Map param);
}
