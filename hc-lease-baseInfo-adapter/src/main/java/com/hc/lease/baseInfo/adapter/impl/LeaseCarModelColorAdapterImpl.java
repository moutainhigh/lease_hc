package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.adapter.api.LeaseCarModelColorAdapter;
import com.hc.lease.baseInfo.model.LeaseCarModelColor;
import com.hc.lease.baseInfo.service.api.LeaseCarModelColorService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆车型-车辆颜色AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseCarModelColorAdapter")
public class LeaseCarModelColorAdapterImpl implements LeaseCarModelColorAdapter {

    @Autowired
    private LeaseCarModelColorService leaseCarModelColorService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public List<LeaseCarModelColor> selectCarPrice(Map<String, Object> paramsMap) {
        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarPrice(paramsMap);
        return leaseCarModelColorList;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarModelColorService.deleteByPrimaryKey(id);
        return row;
    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseCarModelColorService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarModelColor record) throws GMException {
        record = leaseCarModelColorService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarModelColor record) throws GMException {
        record = leaseCarModelColorService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseCarModelColor selectByPrimaryKey(Long id) throws GMException {
        LeaseCarModelColor leaseCarModelColor = leaseCarModelColorService.selectByPrimaryKey(id);
        return leaseCarModelColor;
    }

    public int updateByPrimaryKeySelective(LeaseCarModelColor record) throws GMException {
        int row = leaseCarModelColorService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarModelColor record) throws GMException {
        int row = leaseCarModelColorService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarModelColor> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarModelColor> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarModelColor> page = leaseCarModelColorService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCarModelColor> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.findAll(paramsMap);
        return leaseCarModelColorList;
    }

    @Override
    public List<LeaseCarModelColor> selectCarModelAndColor(Map<String, Object> paramsMap) {
        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
        return leaseCarModelColorList;
    }

}
