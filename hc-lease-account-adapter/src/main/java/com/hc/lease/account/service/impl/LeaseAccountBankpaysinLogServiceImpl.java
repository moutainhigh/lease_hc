package com.hc.lease.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.account.service.api.LeaseAccountBankpaysinLogService;
import com.hc.lease.account.model.LeaseAccountBankpaysinLog;
import com.hc.lease.account.dao.LeaseAccountBankpaysinLogMapper;

import java.util.List;
import java.util.Map;

/**
 * 承租人银行卡通联支付签约日志ServiceImpl
 *
 * @author Tong
 * @version 2018-04-23
 */
@Service("leaseAccountBankpaysinLogService")
public class LeaseAccountBankpaysinLogServiceImpl implements LeaseAccountBankpaysinLogService {

    @Autowired
    private LeaseAccountBankpaysinLogMapper leaseAccountBankpaysinLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountBankpaysinLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseAccountBankpaysinLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAccountBankpaysinLog insert(LeaseAccountBankpaysinLog leaseAccountBankpaysinLog) throws GMException {
        leaseAccountBankpaysinLog.setCreateTime(DateTime.now().toDate());
        leaseAccountBankpaysinLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankpaysinLogMapper.insert(leaseAccountBankpaysinLog);
        return leaseAccountBankpaysinLog;
    }

    public LeaseAccountBankpaysinLog insertSelective(LeaseAccountBankpaysinLog leaseAccountBankpaysinLog) throws GMException {
        leaseAccountBankpaysinLog.setCreateTime(DateTime.now().toDate());
        leaseAccountBankpaysinLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankpaysinLogMapper.insertSelective(leaseAccountBankpaysinLog);
        return leaseAccountBankpaysinLog;
    }

    public int insertList(List<LeaseAccountBankpaysinLog> list) throws GMException {
        int row = leaseAccountBankpaysinLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAccountBankpaysinLog leaseAccountBankpaysinLog) throws GMException {
        leaseAccountBankpaysinLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankpaysinLogMapper.updateByPrimaryKeySelective(leaseAccountBankpaysinLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountBankpaysinLog leaseAccountBankpaysinLog) throws GMException {
        leaseAccountBankpaysinLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankpaysinLogMapper.updateByPrimaryKey(leaseAccountBankpaysinLog);
        return row;
    }

    public LeaseAccountBankpaysinLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountBankpaysinLog leaseAccountBankpaysinLog = leaseAccountBankpaysinLogMapper.selectByPrimaryKey(id);
        return leaseAccountBankpaysinLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountBankpaysinLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAccountBankpaysinLog> leaseAccountBankpaysinLogList = leaseAccountBankpaysinLogMapper.findPage(paramsMap);
        PageInfo<LeaseAccountBankpaysinLog> page = new PageInfo<LeaseAccountBankpaysinLog>(leaseAccountBankpaysinLogList);
        return page;
    }

    public List<LeaseAccountBankpaysinLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountBankpaysinLog> leaseAccountBankpaysinLogList = leaseAccountBankpaysinLogMapper.findAll(paramsMap);
        return leaseAccountBankpaysinLogList;
    }

    /**
     * 根据用户主键Id删除数据
     *
     * @param accountId
     * @return
     * @throws GMException
     */
    @Override
    public int deleteByAccountId(Long accountId) throws GMException {
        int row = leaseAccountBankpaysinLogMapper.deleteByAccountId(accountId);
        return row;
    }
}
