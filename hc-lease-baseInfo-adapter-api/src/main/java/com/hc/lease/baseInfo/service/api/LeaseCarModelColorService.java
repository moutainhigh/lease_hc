package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseCarModelColor;
import com.hc.lease.baseInfo.vo.LeaseCarModelColorPriceVo;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 车辆车型-车辆颜色Service
 *
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseCarModelColorService extends BaseService<LeaseCarModelColor> {

    public int deleteByModelId(Long modelId) throws GMException;

    ArrayList<LeaseCarModelColorPriceVo> selectByModelId(Long modelId) throws GMException;

    /**
     * 根据颜色主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCarModelColor> findByColorId(List<Long> ids) throws GMException;

    /**
     * 根据modelId和colorId查找价格
     * @param paramsMap
     * @return
     */
    List<LeaseCarModelColor> selectCarPrice(Map<String, Object> paramsMap);

    List<LeaseCarModelColor> selectColor();

    List<LeaseCarModelColor> selectCarModelAndColor(Map<String, Object> paramsMap);

}
