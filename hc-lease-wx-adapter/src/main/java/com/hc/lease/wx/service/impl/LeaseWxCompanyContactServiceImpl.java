package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxCompanyContactService;
import com.hc.lease.wx.model.LeaseWxCompanyContact;
import com.hc.lease.wx.dao.LeaseWxCompanyContactMapper;

import java.util.List;
import java.util.Map;

/**
 * 联系我们ServiceImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxCompanyContactService")
public class LeaseWxCompanyContactServiceImpl implements LeaseWxCompanyContactService {

	@Autowired
	private LeaseWxCompanyContactMapper leaseWxCompanyContactMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCompanyContactMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxCompanyContactMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxCompanyContact insert(LeaseWxCompanyContact leaseWxCompanyContact) throws GMException {
        leaseWxCompanyContact.setCreateTime(DateTime.now().toDate());
        leaseWxCompanyContact.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCompanyContactMapper.insert(leaseWxCompanyContact);
        return leaseWxCompanyContact;
    }

    public LeaseWxCompanyContact insertSelective(LeaseWxCompanyContact leaseWxCompanyContact) throws GMException {
        leaseWxCompanyContact.setCreateTime(DateTime.now().toDate());
        leaseWxCompanyContact.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCompanyContactMapper.insertSelective(leaseWxCompanyContact);
        return leaseWxCompanyContact;
    }

    public int insertList(List<LeaseWxCompanyContact> list) throws GMException {
        int row = leaseWxCompanyContactMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxCompanyContact leaseWxCompanyContact) throws GMException {
        leaseWxCompanyContact.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCompanyContactMapper.updateByPrimaryKeySelective(leaseWxCompanyContact);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCompanyContact leaseWxCompanyContact) throws GMException {
        leaseWxCompanyContact.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCompanyContactMapper.updateByPrimaryKey(leaseWxCompanyContact);
        return row;
    }

    public LeaseWxCompanyContact selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCompanyContact leaseWxCompanyContact = leaseWxCompanyContactMapper.selectByPrimaryKey(id);
        return leaseWxCompanyContact;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxCompanyContact> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxCompanyContact> leaseWxCompanyContactList = leaseWxCompanyContactMapper.findPage(paramsMap);
        PageInfo<LeaseWxCompanyContact> page = new PageInfo<LeaseWxCompanyContact>(leaseWxCompanyContactList);
        return page;
    }

    public List <LeaseWxCompanyContact> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCompanyContact> leaseWxCompanyContactList = leaseWxCompanyContactMapper.findAll(paramsMap);
        return leaseWxCompanyContactList;
    }

}
