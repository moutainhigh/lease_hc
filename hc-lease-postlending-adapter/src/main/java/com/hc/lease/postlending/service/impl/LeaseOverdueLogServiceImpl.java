package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseOverdueLogMapper;
import com.hc.lease.postlending.model.LeaseOverdueLog;
import com.hc.lease.postlending.service.api.LeaseOverdueLogService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 逾期记录ServiceImpl
 *
 * @author Tong
 * @version 2017-06-09
 */
@Service("leaseOverdueLogService")
public class LeaseOverdueLogServiceImpl implements LeaseOverdueLogService {

    @Autowired
    private LeaseOverdueLogMapper leaseOverdueLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseOverdueLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseOverdueLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseOverdueLog insert(LeaseOverdueLog record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseOverdueLogMapper.insert(record);
        return record;
    }

    public LeaseOverdueLog insertSelective(LeaseOverdueLog record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseOverdueLogMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseOverdueLog> list) throws GMException {
        int row = leaseOverdueLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseOverdueLog record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseOverdueLogMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseOverdueLog record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseOverdueLogMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseOverdueLog selectByPrimaryKey(Long id) throws GMException {
        LeaseOverdueLog leaseOverdueLog = leaseOverdueLogMapper.selectByPrimaryKey(id);
        return leaseOverdueLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseOverdueLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseOverdueLog> leaseOverdueLogList = leaseOverdueLogMapper.findPage(paramsMap);
        PageInfo<LeaseOverdueLog> page = new PageInfo<LeaseOverdueLog>(leaseOverdueLogList);
        return page;
    }

    public List<LeaseOverdueLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseOverdueLog> leaseOverdueLogList = leaseOverdueLogMapper.findAll(paramsMap);
        return leaseOverdueLogList;
    }

    /**
     * 批量更新
     *
     * @param leaseOverdueLogList
     * @return
     */
    public int updateBatch(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames) {
        int row = leaseOverdueLogMapper.updateBatch(leaseOverdueLogList);
        return row;
    }

    /**
     * 批量新增
     *
     * @param leaseOverdueLogList
     * @return
     */
    public int insertBatch(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames) {
        int row = leaseOverdueLogMapper.insertBatch(leaseOverdueLogList);
        return row;
    }

    /**
     * @param paramsMap
     * @return
     */
    public LeaseOverdueLog selectByContractIdRepaymentId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseOverdueLog leaseOverdueLog = leaseOverdueLogMapper.selectByContractIdRepaymentId(paramsMap);
        return leaseOverdueLog;
    }

    /**
     * 更新支付状态
     *
     * @param leaseOverdueLog
     * @return
     */
    public int updateStatus(LeaseOverdueLog leaseOverdueLog, DubboTreaceParames dubboTreaceParames) {
        int row = leaseOverdueLogMapper.updateStatus(leaseOverdueLog);
        return row;
    }

    /**
     * 批量更新支付状态
     *
     * @param leaseOverdueLogList
     * @return
     */
    public int batchUpdateStatus(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames) {
        int row = leaseOverdueLogMapper.batchUpdateStatus(leaseOverdueLogList);
        return row;
    }

    /**
     * 合同修改同时修改 还款计划主键id
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseOverdueLogMapper.updateRepaymentId(paramsMap);
        return row;
    }
}
