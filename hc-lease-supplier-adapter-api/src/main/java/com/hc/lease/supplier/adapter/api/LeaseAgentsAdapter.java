package com.hc.lease.supplier.adapter.api;

import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.WxStoresImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.WxStoresTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseAgents;
import com.hc.lease.supplier.vo.FindPageVo;
import com.hc.lease.supplier.vo.LeaseAgentsList;

import java.util.List;
import java.util.Map;

/**
 * 门店Adapter
 *
 * @author Qiang
 * @version 2017-12-15
 */

public interface LeaseAgentsAdapter extends BaseAdapter<LeaseAgents> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 处理小程序门店导入
     *
     * @param wxStoresTemplateList 门店数据
     * @param userSession
     * @return
     * @throws GMException
     */
    WxStoresImportExcelBackInfo importExcelWxStores(List<WxStoresTemplate> wxStoresTemplateList, UserSession userSession) throws GMException;

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseAgents> findByName(Map<String, Object> paramsMap);

    int disableByPrimaryKey(Map<String, Object> paramsMap);

    int updateSort(LeaseAgentsList leaseAgentsList);

    List<FindPageVo> findAllNoPage(Object o);

    List<String> findExportExcelModel(Map param);
}
