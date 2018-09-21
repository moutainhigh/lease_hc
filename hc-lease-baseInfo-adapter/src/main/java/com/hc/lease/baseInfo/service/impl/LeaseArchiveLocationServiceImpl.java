package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseArchiveLocationMapper;
import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.baseInfo.service.api.LeaseArchiveLocationService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 归档位置ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseArchiveLocationService")
public class LeaseArchiveLocationServiceImpl implements LeaseArchiveLocationService {

    @Autowired
    private LeaseArchiveLocationMapper leaseArchiveLocationMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseArchiveLocationMapper.deleteByPrimaryKey(id);
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
        int row = leaseArchiveLocationMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseArchiveLocation insert(LeaseArchiveLocation record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseArchiveLocationMapper.insert(record);
        return record;
    }

    public LeaseArchiveLocation insertSelective(LeaseArchiveLocation record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseArchiveLocationMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseArchiveLocation> list) throws GMException {
        int row = leaseArchiveLocationMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseArchiveLocation record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseArchiveLocationMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseArchiveLocation record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseArchiveLocationMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseArchiveLocation selectByPrimaryKey(Long id) throws GMException {
        LeaseArchiveLocation leaseArchiveLocation = leaseArchiveLocationMapper.selectByPrimaryKey(id);
        return leaseArchiveLocation;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseArchiveLocation> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseArchiveLocation> leaseArchiveLocationList = leaseArchiveLocationMapper.findPage(paramsMap);
        PageInfo<LeaseArchiveLocation> page = new PageInfo<LeaseArchiveLocation>(leaseArchiveLocationList);
        return page;
    }

    public List<LeaseArchiveLocation> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseArchiveLocation> leaseArchiveLocationList = leaseArchiveLocationMapper.findAll(paramsMap);
        return leaseArchiveLocationList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseArchiveLocation> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseArchiveLocation> list = leaseArchiveLocationMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseArchiveLocation> findByName(Map params) throws GMException {
        List<LeaseArchiveLocation> list = leaseArchiveLocationMapper.findByName(params);
        return list;
    }

    public int disableByPrimaryKey(Map<String, Object> params) {
        int row=leaseArchiveLocationMapper.disableByPrimaryKey(params);
        return row;
    }


    public void updateSort(LeaseArchiveLocation leaseArchiveLocation) {

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseArchiveLocation.getId());
        paramsMap.put("mark",leaseArchiveLocation.getMark());
        leaseArchiveLocationMapper.updateSort(paramsMap);

    }

    public int updateDefaultSelected(Map<String, Object> paramsMap) {
        int row=leaseArchiveLocationMapper.updateDefaultSelected(paramsMap);
        return row;
    }

    public List<LeaseArchiveLocation> findAllNoPage(Map param) {
        List<LeaseArchiveLocation> archiveLocations = leaseArchiveLocationMapper.findPage(param);
        return archiveLocations;
    }

    public Integer findMaxNumber() {
     Integer number=leaseArchiveLocationMapper.findMaxNumber();
        return number;
    }


}
