package com.hc.lease.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.account.dao.LeaseAccountCreditMapper;
import com.hc.lease.account.model.LeaseAccountCredit;
import com.hc.lease.account.service.api.LeaseAccountCreditService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 个人类型用户/承租人ServiceImpl
 *
 * @author Tong
 * @version 2017-06-06
 */
@Service("leaseAccountCreditService")
public class LeaseAccountCreditServiceImpl implements LeaseAccountCreditService {

    @Autowired
    private LeaseAccountCreditMapper leaseAccountCreditMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountCreditMapper.deleteByPrimaryKey(id);
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
        int row = leaseAccountCreditMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAccountCredit insert(LeaseAccountCredit record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountCreditMapper.insert(record);
        return record;
    }

    public LeaseAccountCredit insertSelective(LeaseAccountCredit record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountCreditMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseAccountCredit> list) throws GMException {
        int row = leaseAccountCreditMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAccountCredit record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountCreditMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountCredit record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountCreditMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccountCredit selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountCredit leaseAccountCredit = leaseAccountCreditMapper.selectByPrimaryKey(id);
        return leaseAccountCredit;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountCredit> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAccountCredit> leaseAccountCreditList = leaseAccountCreditMapper.findPage(paramsMap);
        PageInfo<LeaseAccountCredit> page = new PageInfo<LeaseAccountCredit>(leaseAccountCreditList);
        return page;
    }

    public List<LeaseAccountCredit> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountCredit> leaseAccountCreditList = leaseAccountCreditMapper.findAll(paramsMap);
        return leaseAccountCreditList;
    }

    public int updateByAccountId(LeaseAccountCredit leaseAccountCredit) {
        int row = leaseAccountCreditMapper.updateByAccountId(leaseAccountCredit);
        return row;
    }

    public int deleteByAccountId(Long accountId) {
        int row = leaseAccountCreditMapper.deleteByAccountId(accountId);
        return row;
    }

    public int deleteBatchByAccountId(List<Long> ids) {
        int row = leaseAccountCreditMapper.deleteBatchByAccountId(ids);
        return row;
    }

    public void updateByAccountIdPrimaryKeySelective(LeaseAccountCredit leaseAccountCredit) {

        leaseAccountCreditMapper.updateByAccountIdPrimaryKeySelective(leaseAccountCredit);


    }
}
