package com.hc.lease.postlending.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.service.LeaseAllinpayStatusLogService;
import com.hc.lease.postlending.model.LeaseAllinpayStatusLog;
import com.hc.lease.postlending.dao.LeaseAllinpayStatusLogMapper;

import java.util.List;
import java.util.Map;

/**
 * 代收状态流水ServiceImpl
 * @author Tong
 * @version 2017-06-15
 */
@Service("leaseAllinpayStatusLogService")
public class LeaseAllinpayStatusLogServiceImpl implements LeaseAllinpayStatusLogService {

	@Autowired
	private LeaseAllinpayStatusLogMapper leaseAllinpayStatusLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpayStatusLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpayStatusLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpayStatusLog insert(LeaseAllinpayStatusLog record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        int row = leaseAllinpayStatusLogMapper.insert(record);
        return record;
    }

    public LeaseAllinpayStatusLog insertSelective(LeaseAllinpayStatusLog record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        int row = leaseAllinpayStatusLogMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseAllinpayStatusLog> list) throws GMException {
        int row = leaseAllinpayStatusLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayStatusLog record) throws GMException {
        int row = leaseAllinpayStatusLogMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayStatusLog record) throws GMException {
        int row = leaseAllinpayStatusLogMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayStatusLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayStatusLog leaseAllinpayStatusLog = leaseAllinpayStatusLogMapper.selectByPrimaryKey(id);
        return leaseAllinpayStatusLog;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAllinpayStatusLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpayStatusLog> leaseAllinpayStatusLogList = leaseAllinpayStatusLogMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpayStatusLog> page = new PageInfo<LeaseAllinpayStatusLog>(leaseAllinpayStatusLogList);
        return page;
    }

    public List <LeaseAllinpayStatusLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayStatusLog> leaseAllinpayStatusLogList = leaseAllinpayStatusLogMapper.findAll(paramsMap);
        return leaseAllinpayStatusLogList;
    }

}
