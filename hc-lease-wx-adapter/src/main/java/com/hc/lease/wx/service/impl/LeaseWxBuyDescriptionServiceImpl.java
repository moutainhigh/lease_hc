package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxBuyDescriptionService;
import com.hc.lease.wx.model.LeaseWxBuyDescription;
import com.hc.lease.wx.dao.LeaseWxBuyDescriptionMapper;

import java.util.List;
import java.util.Map;

/**
 * 代理图ServiceImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxBuyDescriptionService")
public class LeaseWxBuyDescriptionServiceImpl implements LeaseWxBuyDescriptionService {

	@Autowired
	private LeaseWxBuyDescriptionMapper leaseWxBuyDescriptionMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxBuyDescriptionMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxBuyDescriptionMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxBuyDescription insert(LeaseWxBuyDescription leaseWxBuyDescription) throws GMException {
        leaseWxBuyDescription.setCreateTime(DateTime.now().toDate());
        leaseWxBuyDescription.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxBuyDescriptionMapper.insert(leaseWxBuyDescription);
        return leaseWxBuyDescription;
    }

    public LeaseWxBuyDescription insertSelective(LeaseWxBuyDescription leaseWxBuyDescription) throws GMException {
        leaseWxBuyDescription.setCreateTime(DateTime.now().toDate());
        leaseWxBuyDescription.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxBuyDescriptionMapper.insertSelective(leaseWxBuyDescription);
        return leaseWxBuyDescription;
    }

    public int insertList(List<LeaseWxBuyDescription> list) throws GMException {
        int row = leaseWxBuyDescriptionMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxBuyDescription leaseWxBuyDescription) throws GMException {
        leaseWxBuyDescription.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxBuyDescriptionMapper.updateByPrimaryKeySelective(leaseWxBuyDescription);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxBuyDescription leaseWxBuyDescription) throws GMException {
        leaseWxBuyDescription.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxBuyDescriptionMapper.updateByPrimaryKey(leaseWxBuyDescription);
        return row;
    }

    public LeaseWxBuyDescription selectByPrimaryKey(Long id) throws GMException {
        LeaseWxBuyDescription leaseWxBuyDescription = leaseWxBuyDescriptionMapper.selectByPrimaryKey(id);
        return leaseWxBuyDescription;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxBuyDescription> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxBuyDescription> leaseWxBuyDescriptionList = leaseWxBuyDescriptionMapper.findPage(paramsMap);
        PageInfo<LeaseWxBuyDescription> page = new PageInfo<LeaseWxBuyDescription>(leaseWxBuyDescriptionList);
        return page;
    }

    public List <LeaseWxBuyDescription> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxBuyDescription> leaseWxBuyDescriptionList = leaseWxBuyDescriptionMapper.findAll(paramsMap);
        return leaseWxBuyDescriptionList;
    }

}
