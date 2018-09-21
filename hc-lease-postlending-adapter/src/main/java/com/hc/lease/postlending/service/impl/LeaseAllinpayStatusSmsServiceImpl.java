package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.service.api.LeaseAllinpayStatusSmsService;
import com.hc.lease.postlending.model.LeaseAllinpayStatusSms;
import com.hc.lease.postlending.dao.LeaseAllinpayStatusSmsMapper;

import java.util.List;
import java.util.Map;

/**
 * 通联扣款结果短信通知日志ServiceImpl
 * @author Tong
 * @version 2017-09-13
 */
@Service("leaseAllinpayStatusSmsService")
public class LeaseAllinpayStatusSmsServiceImpl implements LeaseAllinpayStatusSmsService {

	@Autowired
	private LeaseAllinpayStatusSmsMapper leaseAllinpayStatusSmsMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpayStatusSmsMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpayStatusSmsMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpayStatusSms insert(LeaseAllinpayStatusSms leaseAllinpayStatusSms) throws GMException {
        leaseAllinpayStatusSms.setCreateTime(DateTime.now().toDate());
        leaseAllinpayStatusSms.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayStatusSmsMapper.insert(leaseAllinpayStatusSms);
        return leaseAllinpayStatusSms;
    }

    public LeaseAllinpayStatusSms insertSelective(LeaseAllinpayStatusSms leaseAllinpayStatusSms) throws GMException {
        leaseAllinpayStatusSms.setCreateTime(DateTime.now().toDate());
        leaseAllinpayStatusSms.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayStatusSmsMapper.insertSelective(leaseAllinpayStatusSms);
        return leaseAllinpayStatusSms;
    }

    public int insertList(List<LeaseAllinpayStatusSms> list) throws GMException {
        int row = leaseAllinpayStatusSmsMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayStatusSms leaseAllinpayStatusSms) throws GMException {
        leaseAllinpayStatusSms.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayStatusSmsMapper.updateByPrimaryKeySelective(leaseAllinpayStatusSms);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayStatusSms leaseAllinpayStatusSms) throws GMException {
        leaseAllinpayStatusSms.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayStatusSmsMapper.updateByPrimaryKey(leaseAllinpayStatusSms);
        return row;
    }

    public LeaseAllinpayStatusSms selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayStatusSms leaseAllinpayStatusSms = leaseAllinpayStatusSmsMapper.selectByPrimaryKey(id);
        return leaseAllinpayStatusSms;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAllinpayStatusSms> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpayStatusSms> leaseAllinpayStatusSmsList = leaseAllinpayStatusSmsMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpayStatusSms> page = new PageInfo<LeaseAllinpayStatusSms>(leaseAllinpayStatusSmsList);
        return page;
    }

    public List <LeaseAllinpayStatusSms> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayStatusSms> leaseAllinpayStatusSmsList = leaseAllinpayStatusSmsMapper.findAll(paramsMap);
        return leaseAllinpayStatusSmsList;
    }

}
