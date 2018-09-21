package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseUseUsedMapper;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.LeaseUseUsedService;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 使用和被使用的数据ServiceImpl
 *
 * @author Tong
 * @version 2017-06-20
 */
@Service("leaseUseUsedService")
public class LeaseUseUsedServiceImpl implements LeaseUseUsedService {

    @Autowired
    private LeaseUseUsedMapper leaseUseUsedMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseUseUsedMapper.deleteByPrimaryKey(id);
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
        int row = leaseUseUsedMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseUseUsed insert(LeaseUseUsed record) throws GMException {
        int row = leaseUseUsedMapper.insert(record);
        return record;
    }

    public LeaseUseUsed insertSelective(LeaseUseUsed record) throws GMException {
        int row = leaseUseUsedMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseUseUsed> list) throws GMException {
        int row = leaseUseUsedMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseUseUsed record) throws GMException {
        int row = leaseUseUsedMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseUseUsed record) throws GMException {
        int row = leaseUseUsedMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseUseUsed selectByPrimaryKey(Long id) throws GMException {
        LeaseUseUsed leaseUseUsed = leaseUseUsedMapper.selectByPrimaryKey(id);
        return leaseUseUsed;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseUseUsed> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseUseUsed> leaseUseUsedList = leaseUseUsedMapper.findPage(paramsMap);
        PageInfo<LeaseUseUsed> page = new PageInfo<LeaseUseUsed>(leaseUseUsedList);
        return page;
    }

    public List<LeaseUseUsed> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUseUsed> leaseUseUsedList = leaseUseUsedMapper.findAll(paramsMap);
        return leaseUseUsedList;
    }

    /**
     * @param paramsMap
     * @return
     */
    public int deleteByUseUsed(Map<String, Object> paramsMap) {
        int row = leaseUseUsedMapper.deleteByUseUsed(paramsMap);
        return row;
    }

    /**
     * @param paramsMap
     * @return
     */
    public List<LeaseUseUsed> selectByUsed(Map<String, Object> paramsMap) {
        List<LeaseUseUsed> leaseUseUsedList = leaseUseUsedMapper.selectByUsed(paramsMap);
        return leaseUseUsedList;
    }

    public int deleteByUse(Long useId, String useType) {
        Map<String,Object>paramsMap= Maps.newHashMap();
        paramsMap.put("useId",useId);
        paramsMap.put("useType",useType);
        int row = leaseUseUsedMapper.deleteByUseUsed(paramsMap);
        return row;
    }
}
