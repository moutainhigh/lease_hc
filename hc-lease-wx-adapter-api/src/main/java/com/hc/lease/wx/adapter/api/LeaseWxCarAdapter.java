package com.hc.lease.wx.adapter.api;

import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.WxCarImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.WxCarTemplate;
import com.hc.lease.wx.model.LeaseWxCar;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.wx.model.LeaseWxCars;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息Adapter
 *
 * @author Qiang
 * @version 2017-11-29
 */

public interface LeaseWxCarAdapter extends BaseAdapter<LeaseWxCar> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int updateSort(LeaseWxCars leaseWxCars);

    /**
     * 处理小程序车辆导入
     *
     * @param wxCarTemplateList 车辆数据
     * @param userSession
     * @return
     * @throws GMException
     */
    WxCarImportExcelBackInfo importExcelWxCar(List<WxCarTemplate> wxCarTemplateList, UserSession userSession) throws GMException;

    List<LeaseWxCar> findByCarName(Map<String, Object> paramsMap);

    List<LeaseWxCar> findAllNoPage(Map<String, Object> paramsMap);
}
