package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxCompanyProfileService;
import com.hc.lease.wx.model.LeaseWxCompanyProfile;
import com.hc.lease.wx.dao.LeaseWxCompanyProfileMapper;

import java.util.List;
import java.util.Map;

/**
 * 联系我们ServiceImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxCompanyProfileService")
public class LeaseWxCompanyProfileServiceImpl implements LeaseWxCompanyProfileService {

	@Autowired
	private LeaseWxCompanyProfileMapper leaseWxCompanyProfileMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCompanyProfileMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxCompanyProfileMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxCompanyProfile insert(LeaseWxCompanyProfile leaseWxCompanyProfile) throws GMException {
        leaseWxCompanyProfile.setCreateTime(DateTime.now().toDate());
        leaseWxCompanyProfile.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCompanyProfileMapper.insert(leaseWxCompanyProfile);
        return leaseWxCompanyProfile;
    }

    public LeaseWxCompanyProfile insertSelective(LeaseWxCompanyProfile leaseWxCompanyProfile) throws GMException {
        leaseWxCompanyProfile.setCreateTime(DateTime.now().toDate());
        leaseWxCompanyProfile.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCompanyProfileMapper.insertSelective(leaseWxCompanyProfile);
        return leaseWxCompanyProfile;
    }

    public int insertList(List<LeaseWxCompanyProfile> list) throws GMException {
        int row = leaseWxCompanyProfileMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxCompanyProfile leaseWxCompanyProfile) throws GMException {
        leaseWxCompanyProfile.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCompanyProfileMapper.updateByPrimaryKeySelective(leaseWxCompanyProfile);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCompanyProfile leaseWxCompanyProfile) throws GMException {
        leaseWxCompanyProfile.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCompanyProfileMapper.updateByPrimaryKey(leaseWxCompanyProfile);
        return row;
    }

    public LeaseWxCompanyProfile selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCompanyProfile leaseWxCompanyProfile = leaseWxCompanyProfileMapper.selectByPrimaryKey(id);
        return leaseWxCompanyProfile;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxCompanyProfile> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxCompanyProfile> leaseWxCompanyProfileList = leaseWxCompanyProfileMapper.findPage(paramsMap);
        PageInfo<LeaseWxCompanyProfile> page = new PageInfo<LeaseWxCompanyProfile>(leaseWxCompanyProfileList);
        return page;
    }

    public List <LeaseWxCompanyProfile> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCompanyProfile> leaseWxCompanyProfileList = leaseWxCompanyProfileMapper.findAll(paramsMap);
        return leaseWxCompanyProfileList;
    }

}
