package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseSchemeOrderAccountMapper;
import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import com.hc.lease.order.service.api.LeaseSchemeOrderAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租方案申请订单-承租人ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseSchemeOrderAccountService")
public class LeaseSchemeOrderAccountServiceImpl implements LeaseSchemeOrderAccountService {

    @Autowired
    private LeaseSchemeOrderAccountMapper leaseSchemeOrderAccountMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeOrderAccountMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemeOrderAccountMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeOrderAccount insert(LeaseSchemeOrderAccount record) throws GMException {
        //record.setCreateTime(DateTime.now().toDate());
        // record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeOrderAccountMapper.insert(record);
        return record;
    }

    public LeaseSchemeOrderAccount insertSelective(LeaseSchemeOrderAccount record) throws GMException {
        // record.setCreateTime(DateTime.now().toDate());
        //record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeOrderAccountMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSchemeOrderAccount> list) throws GMException {
        return 0;
    }


    public int updateByPrimaryKeySelective(LeaseSchemeOrderAccount record) throws GMException {
        //record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeOrderAccountMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeOrderAccount record) throws GMException {
        //record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeOrderAccountMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseSchemeOrderAccount selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeOrderAccount leaseSchemeOrderAccount = leaseSchemeOrderAccountMapper.selectByPrimaryKey(id);
        return leaseSchemeOrderAccount;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseSchemeOrderAccount> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList = leaseSchemeOrderAccountMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeOrderAccount> page = new PageInfo<LeaseSchemeOrderAccount>(leaseSchemeOrderAccountList);
        return page;
    }

    public List<LeaseSchemeOrderAccount> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList = leaseSchemeOrderAccountMapper.findAll(paramsMap);
        return leaseSchemeOrderAccountList;
    }

    public void updateBySchemeOrderIdSelective(LeaseSchemeOrderAccount leaseSchemeOrderAccount) {
        leaseSchemeOrderAccountMapper.updateBySchemeOrderIdSelective(leaseSchemeOrderAccount);
    }

    public void deleteBySchemeOrderId(Long id) {
        leaseSchemeOrderAccountMapper.deleteBySchemeOrderId(id);
    }

    @Override
    public List<LeaseSchemeOrderAccount> selectByAccountId(long orderAccountId) {
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts = leaseSchemeOrderAccountMapper.selectByAccountId(orderAccountId);
        return leaseSchemeOrderAccounts;
    }

    @Override
    public List<LeaseSchemeOrderAccount> selectBySchemeOrderId(long schemeOrderId) {
        return leaseSchemeOrderAccountMapper.selectBySchemeOrderId(schemeOrderId);
    }
}
