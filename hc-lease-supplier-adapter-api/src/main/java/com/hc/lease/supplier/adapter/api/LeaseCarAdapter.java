package com.hc.lease.supplier.adapter.api;

import com.hc.lease.common.core.aop.CurrentUser;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.CarImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.model.LeaseCar;
import com.hc.lease.supplier.vo.LeaseCarExport;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息Adapter
 *
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseCarAdapter extends BaseAdapter<LeaseCar> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 列表页面 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParamesListPage(Map<String, Object> paramsMap) throws GMException;

    List<LeaseCar> selectAllCarNoPage(Map<String, Object> paramsMap);

    /**
     * 车辆数据导入
     *
     * @param leaseCarTemplate
     * @return
     * @throws GMException
     */
    CarImportExcelBackInfo importExcelCar(List<LeaseCarTemplate> leaseCarTemplate, @CurrentUser UserSession userSession) throws GMException;

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseCarExport> findLeaseCarExport(Map<String, Object> paramsMap);

    /**
     * 修改车辆贷后的处理方案
     *
     * @param leaseCar
     * @return
     * @throws GMException
     */
    int updateDealStatus(LeaseCar leaseCar) throws GMException;

}
