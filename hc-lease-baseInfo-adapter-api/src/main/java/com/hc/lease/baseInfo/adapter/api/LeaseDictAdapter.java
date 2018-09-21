package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.vo.LeaseDicts;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.LeaseDictBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseDictTemplate;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 字典表Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseDictAdapter extends BaseAdapter<LeaseDict> {

    List<LeaseDict> findByType(String type);

    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(String type) throws GMException;

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseDict> findByValueAndType(Map<String, Object> paramsMap);

    int disableByPrimaryKey(Map<String, Object> paramsMap);

    int updateDefaultSelected(Map<String, Object> paramsMap);

    int updateSort(LeaseDicts leaseDicts);

    LeaseDictBackInfo importExcelCarColor(List<LeaseDictTemplate> leaseDictTemplates, String type) throws GMException;
}
