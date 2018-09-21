package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseCar;

import java.util.List;
import java.util.Map;

public interface LeaseCarMapper extends BaseDao<LeaseCar> {

    List<LeaseCar> findByGpsSupplierId(List<Long> ids);

    List<LeaseCar> findByStorehouseId(List<Long> ids);

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
     * 查询 车辆及对应价格
     * @param paramsMap
     * @return
     */
    List<LeaseCar> findCarAndPrice(Map<String, Object> paramsMap);

    /**
     *
     * @param paramsMap
     * @return
     */
    List<LeaseCar> findByParams(Map<String, Object> paramsMap);

}