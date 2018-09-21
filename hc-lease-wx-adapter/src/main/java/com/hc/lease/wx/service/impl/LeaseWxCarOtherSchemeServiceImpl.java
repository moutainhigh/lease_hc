package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxCarOtherSchemeService;
import com.hc.lease.wx.model.LeaseWxCarOtherScheme;
import com.hc.lease.wx.dao.LeaseWxCarOtherSchemeMapper;

import java.util.List;
import java.util.Map;

/**
 * 车辆1+X方案ServiceImpl
 * @author Qiang
 * @version 2018-04-10
 */
@Service("leaseWxCarOtherSchemeService")
public class LeaseWxCarOtherSchemeServiceImpl implements LeaseWxCarOtherSchemeService {

	@Autowired
	private LeaseWxCarOtherSchemeMapper leaseWxCarOtherSchemeMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCarOtherSchemeMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxCarOtherSchemeMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxCarOtherScheme insert(LeaseWxCarOtherScheme leaseWxCarOtherScheme) throws GMException {
        leaseWxCarOtherScheme.setCreateTime(DateTime.now().toDate());
        leaseWxCarOtherScheme.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarOtherSchemeMapper.insert(leaseWxCarOtherScheme);
        return leaseWxCarOtherScheme;
    }

    public LeaseWxCarOtherScheme insertSelective(LeaseWxCarOtherScheme leaseWxCarOtherScheme) throws GMException {
        leaseWxCarOtherScheme.setCreateTime(DateTime.now().toDate());
        leaseWxCarOtherScheme.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarOtherSchemeMapper.insertSelective(leaseWxCarOtherScheme);
        return leaseWxCarOtherScheme;
    }

    public int insertList(List<LeaseWxCarOtherScheme> list) throws GMException {
        int row = leaseWxCarOtherSchemeMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxCarOtherScheme leaseWxCarOtherScheme) throws GMException {
        leaseWxCarOtherScheme.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarOtherSchemeMapper.updateByPrimaryKeySelective(leaseWxCarOtherScheme);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCarOtherScheme leaseWxCarOtherScheme) throws GMException {
        leaseWxCarOtherScheme.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarOtherSchemeMapper.updateByPrimaryKey(leaseWxCarOtherScheme);
        return row;
    }

    public LeaseWxCarOtherScheme selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCarOtherScheme leaseWxCarOtherScheme = leaseWxCarOtherSchemeMapper.selectByPrimaryKey(id);
        return leaseWxCarOtherScheme;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxCarOtherScheme> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxCarOtherScheme> leaseWxCarOtherSchemeList = leaseWxCarOtherSchemeMapper.findPage(paramsMap);
        PageInfo<LeaseWxCarOtherScheme> page = new PageInfo<LeaseWxCarOtherScheme>(leaseWxCarOtherSchemeList);
        return page;
    }

    public List <LeaseWxCarOtherScheme> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCarOtherScheme> leaseWxCarOtherSchemeList = leaseWxCarOtherSchemeMapper.findAll(paramsMap);
        return leaseWxCarOtherSchemeList;
    }

    public void updateByCarId(LeaseWxCarOtherScheme leaseWxCarOtherScheme) {
        leaseWxCarOtherSchemeMapper.updateByCarId(leaseWxCarOtherScheme);
    }

    public LeaseWxCarOtherScheme selectByCarId(Long id) {
        LeaseWxCarOtherScheme leaseWxCarOtherScheme= leaseWxCarOtherSchemeMapper.selectByCarId(id);
        return leaseWxCarOtherScheme;
    }

    public void updateByCarIdNoSelective(LeaseWxCarOtherScheme leaseWxCarOtherScheme) {
        leaseWxCarOtherSchemeMapper.updateByCarIdNoSelective(leaseWxCarOtherScheme);
    }

    public void deleteByCarId(Long id) {

        leaseWxCarOtherSchemeMapper.deleteByCarId(id);

    }
}
