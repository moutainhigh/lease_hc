package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.service.api.LeaseAllinpaySplitStatusLogService;
import com.hc.lease.postlending.model.LeaseAllinpaySplitStatusLog;
import com.hc.lease.postlending.dao.LeaseAllinpaySplitStatusLogMapper;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 支付状态流水ServiceImpl
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitStatusLogService")
public class LeaseAllinpaySplitStatusLogServiceImpl implements LeaseAllinpaySplitStatusLogService {

	@Autowired
	private LeaseAllinpaySplitStatusLogMapper leaseAllinpaySplitStatusLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpaySplitStatusLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitStatusLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpaySplitStatusLog insert(LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog) throws GMException {
        int row = leaseAllinpaySplitStatusLogMapper.insert(leaseAllinpaySplitStatusLog);
        return leaseAllinpaySplitStatusLog;
    }

    public LeaseAllinpaySplitStatusLog insertSelective(LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog) throws GMException {
        int row = leaseAllinpaySplitStatusLogMapper.insertSelective(leaseAllinpaySplitStatusLog);
        return leaseAllinpaySplitStatusLog;
    }

    public int insertList(List<LeaseAllinpaySplitStatusLog> list) throws GMException {
        int row = leaseAllinpaySplitStatusLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog) throws GMException {
        int row = leaseAllinpaySplitStatusLogMapper.updateByPrimaryKeySelective(leaseAllinpaySplitStatusLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog) throws GMException {
        int row = leaseAllinpaySplitStatusLogMapper.updateByPrimaryKey(leaseAllinpaySplitStatusLog);
        return row;
    }

    public LeaseAllinpaySplitStatusLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog = leaseAllinpaySplitStatusLogMapper.selectByPrimaryKey(id);
        return leaseAllinpaySplitStatusLog;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAllinpaySplitStatusLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpaySplitStatusLog> leaseAllinpaySplitStatusLogList = leaseAllinpaySplitStatusLogMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpaySplitStatusLog> page = new PageInfo<LeaseAllinpaySplitStatusLog>(leaseAllinpaySplitStatusLogList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseAllinpaySplitStatusLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitStatusLog> leaseAllinpaySplitStatusLogList = leaseAllinpaySplitStatusLogMapper.findAll(paramsMap);
        return leaseAllinpaySplitStatusLogList;
    }

}
