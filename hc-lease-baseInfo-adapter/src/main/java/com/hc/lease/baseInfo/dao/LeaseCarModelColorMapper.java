package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseCarModelColor;
import com.hc.lease.baseInfo.vo.LeaseCarModelColorPriceVo;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 车辆车型-车辆颜色
 */
public interface LeaseCarModelColorMapper extends BaseDao<LeaseCarModelColor> {

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

    List<LeaseCarModelColor> selectCarPrice(Map<String, Object> paramsMap);

    List<LeaseCarModelColor> selectColor();

    List<LeaseCarModelColor> selectCarModelAndColor(Map<String, Object> paramsMap);

}