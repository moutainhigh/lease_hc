package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseAllinpaySplitLogMapper;
import com.hc.lease.postlending.model.LeaseAllinpaySplitLog;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitLogService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 支付流水ServiceImpl
 *
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitLogService")
public class LeaseAllinpaySplitLogServiceImpl implements LeaseAllinpaySplitLogService {

    @Autowired
    private LeaseAllinpaySplitLogMapper leaseAllinpaySplitLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpaySplitLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpaySplitLog insert(LeaseAllinpaySplitLog leaseAllinpaySplitLog) throws GMException {
        leaseAllinpaySplitLog.setCreateTime(DateTime.now().toDate());
        leaseAllinpaySplitLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitLogMapper.insert(leaseAllinpaySplitLog);
        return leaseAllinpaySplitLog;
    }

    public LeaseAllinpaySplitLog insertSelective(LeaseAllinpaySplitLog leaseAllinpaySplitLog) throws GMException {
        int row = leaseAllinpaySplitLogMapper.insertSelective(leaseAllinpaySplitLog);
        return leaseAllinpaySplitLog;
    }

    public int insertList(List<LeaseAllinpaySplitLog> list) throws GMException {
        int row = leaseAllinpaySplitLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitLog leaseAllinpaySplitLog) throws GMException {
        leaseAllinpaySplitLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitLogMapper.updateByPrimaryKeySelective(leaseAllinpaySplitLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitLog leaseAllinpaySplitLog) throws GMException {
        leaseAllinpaySplitLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitLogMapper.updateByPrimaryKey(leaseAllinpaySplitLog);
        return row;
    }

    public LeaseAllinpaySplitLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitLog leaseAllinpaySplitLog = leaseAllinpaySplitLogMapper.selectByPrimaryKey(id);
        return leaseAllinpaySplitLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplitLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpaySplitLog> leaseAllinpaySplitLogList = leaseAllinpaySplitLogMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpaySplitLog> page = new PageInfo<LeaseAllinpaySplitLog>(leaseAllinpaySplitLogList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplitLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitLog> leaseAllinpaySplitLogList = leaseAllinpaySplitLogMapper.findAll(paramsMap);
        return leaseAllinpaySplitLogList;
    }

    @Override
    public LeaseAllinpaySplitLog findByReqSn(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseAllinpaySplitLog leaseAllinpaySplitLog = leaseAllinpaySplitLogMapper.findByReqSn(paramsMap);
        return leaseAllinpaySplitLog;
    }

    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseAllinpaySplitLogMapper.updateRepaymentId(paramsMap);
        return row;
    }
}
