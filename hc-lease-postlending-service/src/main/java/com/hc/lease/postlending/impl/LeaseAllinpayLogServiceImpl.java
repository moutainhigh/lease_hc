package com.hc.lease.postlending.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseAllinpayLogMapper;
import com.hc.lease.postlending.model.LeaseAllinpayLog;
import com.hc.lease.postlending.service.LeaseAllinpayLogService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联代收流水ServiceImpl
 *
 * @author Tong
 * @version 2017-06-09
 */
@Service("leaseAllinpayLogService")
public class LeaseAllinpayLogServiceImpl implements LeaseAllinpayLogService {

    @Autowired
    private LeaseAllinpayLogMapper leaseAllinpayLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpayLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpayLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpayLog insert(LeaseAllinpayLog record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayLogMapper.insert(record);
        return record;
    }

    public LeaseAllinpayLog insertSelective(LeaseAllinpayLog record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayLogMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseAllinpayLog> list) throws GMException {
        int row = leaseAllinpayLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayLog record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayLogMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayLog record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayLogMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayLog leaseAllinpayLog = leaseAllinpayLogMapper.selectByPrimaryKey(id);
        return leaseAllinpayLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpayLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpayLog> leaseAllinpayLogList = leaseAllinpayLogMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpayLog> page = new PageInfo<LeaseAllinpayLog>(leaseAllinpayLogList);
        return page;
    }

    public List<LeaseAllinpayLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayLog> leaseAllinpayLogList = leaseAllinpayLogMapper.findAll(paramsMap);
        return leaseAllinpayLogList;
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态
     *
     * @param leaseAllinpayLog
     * @return
     * @throws GMException
     */
    public int updateByReqSn(LeaseAllinpayLog leaseAllinpayLog) throws GMException {
        int row = leaseAllinpayLogMapper.updateByReqSn(leaseAllinpayLog);
        return row;
    }

    /**
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public LeaseAllinpayLog selectByReqSn(Map<String, Object> paramsMap) throws GMException {
        LeaseAllinpayLog leaseAllinpayLog = leaseAllinpayLogMapper.selectByReqSn(paramsMap);
        return leaseAllinpayLog;
    }

    /**
     * 需要轮询通联 的 交易流水
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseAllinpayLog> findQueryTradeNew(Map<String, Object> paramsMap) {
        List<LeaseAllinpayLog> leaseAllinpayLogList = leaseAllinpayLogMapper.findQueryTradeNew(paramsMap);
        return leaseAllinpayLogList;
    }

}
