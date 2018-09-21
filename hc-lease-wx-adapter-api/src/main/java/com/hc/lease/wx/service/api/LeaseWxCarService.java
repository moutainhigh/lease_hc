package com.hc.lease.wx.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.wx.model.LeaseWxCar;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息Service
 *
 * @author Qiang
 * @version 2017-11-29
 */

public interface LeaseWxCarService extends BaseService<LeaseWxCar> {

    void updateSort(LeaseWxCar leaseWxCar);

    List<LeaseWxCar> findByCarName(Map<String, Object> paramsMap);

    /**
     * 批量更新对象.
     *
     * @param list
     * @return int
     */
    int updateByPrimaryKeyList(List<LeaseWxCar> list) throws GMException;


    List<LeaseWxCar> findByName(Map params);

    List<LeaseWxCar> findAllNoPage(Map<String, Object> paramsMap);
}
