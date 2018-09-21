package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseCarSeriesMapper;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.baseInfo.service.api.LeaseCarSeriesService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆系列ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseCarSeriesService")
public class LeaseCarSeriesServiceImpl implements LeaseCarSeriesService {

    @Autowired
    private LeaseCarSeriesMapper leaseCarSeriesMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarSeriesMapper.deleteByPrimaryKey(id);
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
        int row = leaseCarSeriesMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarSeries insert(LeaseCarSeries record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarSeriesMapper.insert(record);
        return record;
    }

    public LeaseCarSeries insertSelective(LeaseCarSeries record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarSeriesMapper.insertSelective(record);
        return record;
    }

    public LeaseCarSeries selectByPrimaryKey(Long id) throws GMException {
        LeaseCarSeries leaseCarSeries = leaseCarSeriesMapper.selectByPrimaryKey(id);
        return leaseCarSeries;
    }

    public int updateByPrimaryKeySelective(LeaseCarSeries record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarSeriesMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarSeries record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarSeriesMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarSeries> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarSeries> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesMapper.findPage(paramsMap);
        PageInfo<LeaseCarSeries> page = new PageInfo<LeaseCarSeries>(leaseCarSeriesList);
        return page;
    }

    public List<LeaseCarSeries> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesMapper.findAll(paramsMap);
        return leaseCarSeriesList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseCarSeries> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarSeries> list = leaseCarSeriesMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 根据品牌主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCarSeries> findByBrandsId(List<Long> ids) throws GMException {
        List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesMapper.findByBrandsId(ids);
        return leaseCarSeriesList;
    }

    /**
     * 根据品牌主键id、系列名称查找
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public List<LeaseCarSeries> findByBrandsIdAndName(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesMapper.findByBrandsIdAndName(paramsMap);
        return leaseCarSeriesList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseCarSeries> findByName(Map params) throws GMException {
        List<LeaseCarSeries> list = leaseCarSeriesMapper.findByName(params);
        return list;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarSeriesMapper.disableByPrimaryKey(params);
        return row;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param params
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(Map params) throws GMException {
        List<String> list = leaseCarSeriesMapper.findExportExcelModel(params);
        return list;
    }

    public void updateSort(LeaseCarSeries leaseCarSeries) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseCarSeries.getId());
        paramsMap.put("mark",leaseCarSeries.getMark());
        leaseCarSeriesMapper.updateSort(paramsMap);
    }

    public List<LeaseCarSeries> findAllNoPage(Map params) {
        List<LeaseCarSeries> leaseCarSeries=leaseCarSeriesMapper.findPage(params);
        return leaseCarSeries;
    }
}
