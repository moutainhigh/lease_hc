package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseManualDeductionsPayLogMapper;
import com.hc.lease.postlending.model.LeaseManualDeductionsPayLog;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsPayLogService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 手动扣款，每一次操作扣款都记录流水ServiceImpl
 *
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductionsPayLogService")
public class LeaseManualDeductionsPayLogServiceImpl implements LeaseManualDeductionsPayLogService {

    @Autowired
    private LeaseManualDeductionsPayLogMapper leaseManualDeductionsPayLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseManualDeductionsPayLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseManualDeductionsPayLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseManualDeductionsPayLog insert(LeaseManualDeductionsPayLog leaseManualDeductionsPayLog) throws GMException {
        leaseManualDeductionsPayLog.setCreateTime(DateTime.now().toDate());
        leaseManualDeductionsPayLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsPayLogMapper.insert(leaseManualDeductionsPayLog);
        return leaseManualDeductionsPayLog;
    }

    public LeaseManualDeductionsPayLog insertSelective(LeaseManualDeductionsPayLog leaseManualDeductionsPayLog) throws GMException {
        leaseManualDeductionsPayLog.setCreateTime(DateTime.now().toDate());
        leaseManualDeductionsPayLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsPayLogMapper.insertSelective(leaseManualDeductionsPayLog);
        return leaseManualDeductionsPayLog;
    }

    public int insertList(List<LeaseManualDeductionsPayLog> list) throws GMException {
        int row = leaseManualDeductionsPayLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductionsPayLog leaseManualDeductionsPayLog) throws GMException {
        leaseManualDeductionsPayLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsPayLogMapper.updateByPrimaryKeySelective(leaseManualDeductionsPayLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductionsPayLog leaseManualDeductionsPayLog) throws GMException {
        leaseManualDeductionsPayLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsPayLogMapper.updateByPrimaryKey(leaseManualDeductionsPayLog);
        return row;
    }

    public LeaseManualDeductionsPayLog selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductionsPayLog leaseManualDeductionsPayLog = leaseManualDeductionsPayLogMapper.selectByPrimaryKey(id);
        return leaseManualDeductionsPayLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseManualDeductionsPayLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseManualDeductionsPayLog> leaseManualDeductionsPayLogList = leaseManualDeductionsPayLogMapper.findPage(paramsMap);
        PageInfo<LeaseManualDeductionsPayLog> page = new PageInfo<LeaseManualDeductionsPayLog>(leaseManualDeductionsPayLogList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseManualDeductionsPayLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductionsPayLog> leaseManualDeductionsPayLogList = leaseManualDeductionsPayLogMapper.findAll(paramsMap);
        return leaseManualDeductionsPayLogList;
    }

    @Override
    public LeaseManualDeductionsPayLog findByReqSn(Map<String, Object> paramsMap) {
        LeaseManualDeductionsPayLog leaseManualDeductionsPayLogList = leaseManualDeductionsPayLogMapper.findByReqSn(paramsMap);
        return leaseManualDeductionsPayLogList;
    }
}
