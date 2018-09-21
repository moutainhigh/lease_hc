package com.hc.lease.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.activity.service.api.LeaseActivityRecordService;
import com.hc.lease.activity.model.LeaseActivityRecord;
import com.hc.lease.activity.dao.LeaseActivityRecordMapper;

import java.util.List;
import java.util.Map;

/**
 * 活动记录ServiceImpl
 * @author Qiang
 * @version 2018-01-08
 */
@Service("leaseActivityRecordService")
public class LeaseActivityRecordServiceImpl implements LeaseActivityRecordService {

	@Autowired
	private LeaseActivityRecordMapper leaseActivityRecordMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseActivityRecordMapper.deleteByPrimaryKey(id);
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
        int row = leaseActivityRecordMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseActivityRecord insert(LeaseActivityRecord leaseActivityRecord) throws GMException {
        leaseActivityRecord.setCreateTime(DateTime.now().toDate());
        leaseActivityRecord.setUpdateTime(DateTime.now().toDate());
        int row = leaseActivityRecordMapper.insert(leaseActivityRecord);
        return leaseActivityRecord;
    }

    public LeaseActivityRecord insertSelective(LeaseActivityRecord leaseActivityRecord) throws GMException {
        leaseActivityRecord.setCreateTime(DateTime.now().toDate());
        leaseActivityRecord.setUpdateTime(DateTime.now().toDate());
        int row = leaseActivityRecordMapper.insertSelective(leaseActivityRecord);
        return leaseActivityRecord;
    }

    public int insertList(List<LeaseActivityRecord> list) throws GMException {
        int row = leaseActivityRecordMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseActivityRecord leaseActivityRecord) throws GMException {
        leaseActivityRecord.setUpdateTime(DateTime.now().toDate());
        int row = leaseActivityRecordMapper.updateByPrimaryKeySelective(leaseActivityRecord);
        return row;
    }

    public int updateByPrimaryKey(LeaseActivityRecord leaseActivityRecord) throws GMException {
        leaseActivityRecord.setUpdateTime(DateTime.now().toDate());
        int row = leaseActivityRecordMapper.updateByPrimaryKey(leaseActivityRecord);
        return row;
    }

    public LeaseActivityRecord selectByPrimaryKey(Long id) throws GMException {
        LeaseActivityRecord leaseActivityRecord = leaseActivityRecordMapper.selectByPrimaryKey(id);
        return leaseActivityRecord;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseActivityRecord> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseActivityRecord> leaseActivityRecordList = leaseActivityRecordMapper.findPage(paramsMap);
        PageInfo<LeaseActivityRecord> page = new PageInfo<LeaseActivityRecord>(leaseActivityRecordList);
        return page;
    }

    public List <LeaseActivityRecord> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseActivityRecord> leaseActivityRecordList = leaseActivityRecordMapper.findAll(paramsMap);
        return leaseActivityRecordList;
    }

    public LeaseActivityRecord selectByIP(String ipAddress) {
        LeaseActivityRecord leaseActivityRecord=leaseActivityRecordMapper.selectByIP(ipAddress);
        return leaseActivityRecord;
    }

    public List<LeaseActivityRecord> findAllNoPage(Object o) {
        List<LeaseActivityRecord> leaseActivityRecordList=leaseActivityRecordMapper.findPage(null);
        return leaseActivityRecordList;
    }
}
