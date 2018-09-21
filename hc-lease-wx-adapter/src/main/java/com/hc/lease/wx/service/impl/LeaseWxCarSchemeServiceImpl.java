package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxCarSchemeService;
import com.hc.lease.wx.model.LeaseWxCarScheme;
import com.hc.lease.wx.dao.LeaseWxCarSchemeMapper;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息ServiceImpl
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxCarSchemeService")
public class LeaseWxCarSchemeServiceImpl implements LeaseWxCarSchemeService {

	@Autowired
	private LeaseWxCarSchemeMapper leaseWxCarSchemeMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCarSchemeMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxCarSchemeMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxCarScheme insert(LeaseWxCarScheme leaseWxCarScheme) throws GMException {
        leaseWxCarScheme.setCreateTime(DateTime.now().toDate());
        leaseWxCarScheme.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarSchemeMapper.insert(leaseWxCarScheme);
        return leaseWxCarScheme;
    }

    public LeaseWxCarScheme insertSelective(LeaseWxCarScheme leaseWxCarScheme) throws GMException {
        leaseWxCarScheme.setCreateTime(DateTime.now().toDate());
        leaseWxCarScheme.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarSchemeMapper.insertSelective(leaseWxCarScheme);
        return leaseWxCarScheme;
    }

    public int insertList(List<LeaseWxCarScheme> list) throws GMException {
        int row = leaseWxCarSchemeMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxCarScheme leaseWxCarScheme) throws GMException {
        leaseWxCarScheme.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarSchemeMapper.updateByPrimaryKeySelective(leaseWxCarScheme);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCarScheme leaseWxCarScheme) throws GMException {
        leaseWxCarScheme.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarSchemeMapper.updateByPrimaryKey(leaseWxCarScheme);
        return row;
    }

    public LeaseWxCarScheme selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCarScheme leaseWxCarScheme = leaseWxCarSchemeMapper.selectByPrimaryKey(id);
        return leaseWxCarScheme;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxCarScheme> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxCarScheme> leaseWxCarSchemeList = leaseWxCarSchemeMapper.findPage(paramsMap);
        PageInfo<LeaseWxCarScheme> page = new PageInfo<LeaseWxCarScheme>(leaseWxCarSchemeList);
        return page;
    }

    public List <LeaseWxCarScheme> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCarScheme> leaseWxCarSchemeList = leaseWxCarSchemeMapper.findAll(paramsMap);
        return leaseWxCarSchemeList;
    }

    public void deleteByCarId(Long id) {
        leaseWxCarSchemeMapper.deleteByCarId(id);
    }
}
