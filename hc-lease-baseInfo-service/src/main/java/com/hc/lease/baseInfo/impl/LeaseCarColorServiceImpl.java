package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseCarColorMapper;
import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.baseInfo.model.LeaseCarColor;
import com.hc.lease.baseInfo.service.LeaseCarColorService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 车辆颜色
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseCarColorService")
public class LeaseCarColorServiceImpl implements LeaseCarColorService {

    @Autowired
    private LeaseCarColorMapper leaseCarColorMapper;

    public LeaseCarColor sayHello() {
        LeaseCarColor leaseCarColor = leaseCarColorMapper.selectByPrimaryKey(1l);
        System.out.println("=-------LeaseCarColor----xx-----------------");
        System.out.println("leaseCarColor.name==" + leaseCarColor.getName());
        return leaseCarColor;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarColorMapper.deleteByPrimaryKey(id);
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
        int row = leaseCarColorMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarColor insert(LeaseCarColor record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarColorMapper.insert(record);
        return record;
    }

    public LeaseCarColor insertSelective(LeaseCarColor record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarColorMapper.insertSelective(record);
        return record;
    }

    public LeaseCarColor selectByPrimaryKey(Long id) throws GMException {
        LeaseCarColor leaseAccount = leaseCarColorMapper.selectByPrimaryKey(id);
        return leaseAccount;
    }

    public int updateByPrimaryKeySelective(LeaseCarColor record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarColorMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarColor record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarColorMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarColor> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws GMException
     */
    public PageInfo<LeaseCarColor> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarColor> leaseCarColorList = leaseCarColorMapper.findPage(paramsMap);
        PageInfo<LeaseCarColor> page = new PageInfo<LeaseCarColor>(leaseCarColorList);
        return page;
    }

    public List<LeaseCarColor> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarColor> leaseCarColorList = leaseCarColorMapper.findAll(paramsMap);
        return leaseCarColorList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseCarColor> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarColor> list = leaseCarColorMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseCarColor> findByName(Map params) throws GMException {
        List<LeaseCarColor> list = leaseCarColorMapper.findByName(params);
        return list;
    }

}
