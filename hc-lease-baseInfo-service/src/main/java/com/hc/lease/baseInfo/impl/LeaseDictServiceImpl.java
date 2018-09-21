package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseDictMapper;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.service.LeaseDictService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 字典表ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseDictService")
public class LeaseDictServiceImpl implements LeaseDictService {

    @Autowired
    private LeaseDictMapper leaseDictMapper;

    public List<LeaseDict> findByType(String type) {
        List<LeaseDict> leaseDictList = leaseDictMapper.findByType(type);
        return leaseDictList;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseDictMapper.deleteByPrimaryKey(id);
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
        int row = leaseDictMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseDict insert(LeaseDict record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseDictMapper.insert(record);
        return record;
    }

    public LeaseDict insertSelective(LeaseDict record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseDictMapper.insertSelective(record);
        return record;
    }

    public LeaseDict selectByPrimaryKey(Long id) throws GMException {
        LeaseDict leaseDict = leaseDictMapper.selectByPrimaryKey(id);
        return leaseDict;
    }

    public int updateByPrimaryKeySelective(LeaseDict record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseDictMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseDict record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseDictMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseDict> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     * @return
     */
    public PageInfo<LeaseDict> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseDict> leaseDictList = leaseDictMapper.findPage(paramsMap);
        PageInfo<LeaseDict> page = new PageInfo<LeaseDict>(leaseDictList);
        return page;
    }

    public List<LeaseDict> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseDict> leaseDictList = leaseDictMapper.findAll(paramsMap);
        return leaseDictList;
    }

}
