package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxSmsService;
import com.hc.lease.wx.model.LeaseWxSms;
import com.hc.lease.wx.dao.LeaseWxSmsMapper;

import java.util.List;
import java.util.Map;

/**
 * 小程序短信参数配置ServiceImpl
 * @author Qiang
 * @version 2018-03-23
 */
@Service("leaseWxSmsService")
public class LeaseWxSmsServiceImpl implements LeaseWxSmsService {

	@Autowired
	private LeaseWxSmsMapper leaseWxSmsMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxSmsMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxSmsMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxSms insert(LeaseWxSms leaseWxSms) throws GMException {
        leaseWxSms.setCreateTime(DateTime.now().toDate());
        leaseWxSms.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxSmsMapper.insert(leaseWxSms);
        return leaseWxSms;
    }

    public LeaseWxSms insertSelective(LeaseWxSms leaseWxSms) throws GMException {
        leaseWxSms.setCreateTime(DateTime.now().toDate());
        leaseWxSms.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxSmsMapper.insertSelective(leaseWxSms);
        return leaseWxSms;
    }

    public int insertList(List<LeaseWxSms> list) throws GMException {
        int row = leaseWxSmsMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxSms leaseWxSms) throws GMException {
        leaseWxSms.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxSmsMapper.updateByPrimaryKeySelective(leaseWxSms);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxSms leaseWxSms) throws GMException {
        leaseWxSms.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxSmsMapper.updateByPrimaryKey(leaseWxSms);
        return row;
    }

    public LeaseWxSms selectByPrimaryKey(Long id) throws GMException {
        LeaseWxSms leaseWxSms = leaseWxSmsMapper.selectByPrimaryKey(id);
        return leaseWxSms;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxSms> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxSms> leaseWxSmsList = leaseWxSmsMapper.findPage(paramsMap);
        PageInfo<LeaseWxSms> page = new PageInfo<LeaseWxSms>(leaseWxSmsList);
        return page;
    }

    public List <LeaseWxSms> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxSms> leaseWxSmsList = leaseWxSmsMapper.findAll(paramsMap);
        return leaseWxSmsList;
    }

    public LeaseWxSms findByType(String typeAppointment) {
        LeaseWxSms leaseWxSms= leaseWxSmsMapper.findByType(typeAppointment);
        return leaseWxSms;
    }
}
