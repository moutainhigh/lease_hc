package com.hc.lease.supplier.service;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseCar;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 车辆信息Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseCarService extends BaseService<LeaseCar> {

    List<LeaseCar> findByGpsSupplierId(List<Long> ids);

    List<LeaseCar> findByStorehouseId(List<Long> ids);

    List<LeaseCar> selectAllCarNoPage(Map<String, Object> paramsMap);

    /**
     * 根据车辆车型主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCar> findByModelId(List<Long> ids) throws GMException;

    /**
     * 根据融资方主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCar> findByCarBuyFinancingerId(List<Long> ids) throws GMException;

    /**
     * 根据经销商主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCar> findByDealerId(List<Long> ids) throws GMException;

    /**
     *
     * @param paramsMap
     * @return
     */
    List<LeaseCar> findByParams(Map<String, Object> paramsMap);

}
