package com.hc.lease.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.account.dao.LeaseAccountCreditLevelMapper;
import com.hc.lease.account.model.LeaseAccountCreditLevel;
import com.hc.lease.account.service.api.LeaseAccountCreditLevelService;
import com.hc.lease.account.vo.AccountCreditLevelVo;
import com.hc.lease.account.vo.FindAccountCreditLevelVo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 承租人评级列表 Service Impl
 * Created by LJ on 2018/1/25
 */
@Service("leaseAccountCreditLevelService")
public class LeaseAccountCreditLevelServiceImpl implements LeaseAccountCreditLevelService {

    @Autowired
    private LeaseAccountCreditLevelMapper leaseAccountCreditLevelMapper;

    @Override
    public LeaseAccountCreditLevel insertSelective(LeaseAccountCreditLevel record) throws GMException {
        leaseAccountCreditLevelMapper.insertSelective(record);
        return record;
    }

    @Override
    public int updateByPrimaryKeySelective(LeaseAccountCreditLevel record) throws GMException {
        return leaseAccountCreditLevelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<AccountCreditLevelVo> findAccountCreditLevel(int pageNum, int pageSize, FindAccountCreditLevelVo pageVo) {
        PageHelper.startPage(pageNum, pageSize);
        List<AccountCreditLevelVo> leaseContractAdvanceList = leaseAccountCreditLevelMapper.findAccountCreditLevel(pageVo);
        return new PageInfo<>(leaseContractAdvanceList);
    }

    @Override
    public LeaseAccountCreditLevel insert(LeaseAccountCreditLevel entity) throws GMException {
        return null;
    }

    @Override
    public int insertList(List<LeaseAccountCreditLevel> list) throws GMException {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(LeaseAccountCreditLevel entity) throws GMException {
        return 0;
    }

    /**
     * 评级
     *
     * @param leaseAccountCreditLevel
     * @return
     */
    @Override
    public int setLevel(LeaseAccountCreditLevel leaseAccountCreditLevel) {
        return leaseAccountCreditLevelMapper.setLevel(leaseAccountCreditLevel);
    }

    @Override
    public LeaseAccountCreditLevel selectByPrimaryKey(Long id) throws GMException {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Long id) throws GMException {
        return 0;
    }

    @Override
    public int deleteBatchById(List<Long> ids) throws GMException {
        return 0;
    }

    @Override
    public PageInfo<LeaseAccountCreditLevel> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    @Override
    public List<LeaseAccountCreditLevel> findAll(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
     * 用户主键ID查询评级数据
     *
     * @param accountId
     * @return
     */
    @Override
    public LeaseAccountCreditLevel findAccountId(Long accountId) {
        return leaseAccountCreditLevelMapper.findAccountId(accountId);
    }
}
