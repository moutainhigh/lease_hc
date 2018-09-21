package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseCarModelColorMapper;
import com.hc.lease.baseInfo.model.LeaseCarModelColor;
import com.hc.lease.baseInfo.service.LeaseCarModelColorService;
import com.hc.lease.baseInfo.vo.LeaseCarModelColorPriceVo;
import com.hc.lease.common.core.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 车辆车型-车辆颜色ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseCarModelColorService")
public class LeaseCarModelColorServiceImpl implements LeaseCarModelColorService {

    @Autowired
    private LeaseCarModelColorMapper leaseCarModelColorMapper;

    /**
     * 根据车辆 车型删除
     *
     * @param modelId
     * @return
     * @throws GMException
     */
    public int deleteByModelId(Long modelId) throws GMException {
        int row = leaseCarModelColorMapper.deleteByModelId(modelId);
        return row;
    }

    /**
     * 根据ID删除记录
     *
     * @param id .
     * @return
     * @throws GMException
     */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarModelColorMapper.deleteByPrimaryKey(id);
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
        int row = leaseCarModelColorMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarModelColor insert(LeaseCarModelColor record) throws GMException {
        int row = leaseCarModelColorMapper.insert(record);
        return record;
    }

    public LeaseCarModelColor insertSelective(LeaseCarModelColor record) throws GMException {
        int row = leaseCarModelColorMapper.insertSelective(record);
        return record;
    }

    public LeaseCarModelColor selectByPrimaryKey(Long id) throws GMException {
        LeaseCarModelColor leaseCarModelColor = leaseCarModelColorMapper.selectByPrimaryKey(id);
        return leaseCarModelColor;
    }

    public ArrayList<LeaseCarModelColorPriceVo> selectByModelId(Long modelId) throws GMException {
        ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorPriceVo = leaseCarModelColorMapper.selectByModelId(modelId);
        return leaseCarModelColorPriceVo;
    }

    public int updateByPrimaryKeySelective(LeaseCarModelColor record) throws GMException {
        int row = leaseCarModelColorMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarModelColor record) throws GMException {
        int row = leaseCarModelColorMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarModelColor> list) throws GMException {
        int row = leaseCarModelColorMapper.insertList(list);
        return row;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarModelColor> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorMapper.findPage(paramsMap);
        PageInfo<LeaseCarModelColor> page = new PageInfo<LeaseCarModelColor>(leaseCarModelColorList);
        return page;
    }

    public List<LeaseCarModelColor> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorMapper.findAll(paramsMap);
        return leaseCarModelColorList;
    }

    /**
     * 根据颜色主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCarModelColor> findByColorId(List<Long> ids) throws GMException {
        List<LeaseCarModelColor> leaseCarSeriesList = leaseCarModelColorMapper.findByColorId(ids);
        return leaseCarSeriesList;
    }

    public List<LeaseCarModelColor> selectCarPrice(Map<String, Object> paramsMap) {
        List<LeaseCarModelColor> leaseCarModelColorList= leaseCarModelColorMapper.selectCarPrice(paramsMap);
        return leaseCarModelColorList;
    }

    public List<LeaseCarModelColor> selectColor() {
        List<LeaseCarModelColor> leaseCarModelColorList=leaseCarModelColorMapper.selectColor();
        return leaseCarModelColorList;
    }

}
