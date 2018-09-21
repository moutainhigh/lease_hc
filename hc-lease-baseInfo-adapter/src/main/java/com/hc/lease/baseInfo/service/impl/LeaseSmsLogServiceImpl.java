package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.baseInfo.service.api.LeaseSmsLogService;
import com.hc.lease.baseInfo.model.LeaseSmsLog;
import com.hc.lease.baseInfo.dao.LeaseSmsLogMapper;

import java.util.List;
import java.util.Map;

/**
 * 短信日志ServiceImpl
 * @author Qiang
 * @version 2017-08-30
 */
@Service("leaseSmsLogService")
public class LeaseSmsLogServiceImpl implements LeaseSmsLogService {

	@Autowired
	private LeaseSmsLogMapper leaseSmsLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSmsLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseSmsLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSmsLog insert(LeaseSmsLog record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());

        int row = leaseSmsLogMapper.insert(record);
        return record;
    }

    public LeaseSmsLog insertSelective(LeaseSmsLog record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());

        int row = leaseSmsLogMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSmsLog> list) throws GMException {
        int row = leaseSmsLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSmsLog record) throws GMException {

        int row = leaseSmsLogMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSmsLog record) throws GMException {

        int row = leaseSmsLogMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSmsLog selectByPrimaryKey(Long id) throws GMException {
        LeaseSmsLog leaseSmsLog = leaseSmsLogMapper.selectByPrimaryKey(id);
        return leaseSmsLog;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSmsLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSmsLog> leaseSmsLogList = leaseSmsLogMapper.findPage(paramsMap);
        PageInfo<LeaseSmsLog> page = new PageInfo<LeaseSmsLog>(leaseSmsLogList);
        return page;
    }

    public List <LeaseSmsLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSmsLog> leaseSmsLogList = leaseSmsLogMapper.findAll(paramsMap);
        return leaseSmsLogList;
    }

}
