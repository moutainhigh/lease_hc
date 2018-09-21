package com.hc.lease.supplier.adapter.api;

import com.hc.lease.common.core.excel.poi.vo.LeaseStorehouseExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseStorehouseTemplate;
import com.hc.lease.supplier.model.LeaseStorehouse;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.vo.LeaseStorehouses;

import java.util.List;
import java.util.Map;

/**
 * 仓库Adapter
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseStorehouseAdapter extends BaseAdapter<LeaseStorehouse> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    int updateSort(LeaseStorehouses leaseStorehouses);

    int updateDefaultSelected(Map<String, Object> paramsMap);

    List<LeaseStorehouse> findAllNoPage(Map param);

    LeaseStorehouseExcelBackInfo importExcelStorehouse(List<LeaseStorehouseTemplate> leaseStorehouseTemplates) throws GMException;
}
