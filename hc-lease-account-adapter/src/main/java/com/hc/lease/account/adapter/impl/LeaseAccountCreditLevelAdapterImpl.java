package com.hc.lease.account.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.account.adapter.api.LeaseAccountCreditLevelAdapter;
import com.hc.lease.account.model.LeaseAccountCreditLevel;
import com.hc.lease.account.service.api.LeaseAccountCreditLevelService;
import com.hc.lease.account.vo.AccountCreditLevelVo;
import com.hc.lease.account.vo.FindAccountCreditLevelVo;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.common.core.constant.DictType;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 承租人评级列表 Adapter Impl
 * Created by LJ on 2018/1/25
 */
@Service("leaseAccountCreditLevelAdapter")
public class LeaseAccountCreditLevelAdapterImpl implements LeaseAccountCreditLevelAdapter {

    @Autowired
    private LeaseAccountCreditLevelService leaseAccountCreditLevelService;

    @Autowired
    private LeaseDictService leaseDictService;

    @Override
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) {
        Map<String, Object> map = Maps.newHashMap();
        //承租人信用评级
        map.put("LeaseCreditLevel", leaseDictService.findByType(DictType.LEASE_CREDIT_LEVEL));
        return map;
    }

    @Override
    public ResultHashMap insertSelective(LeaseAccountCreditLevel record) throws GMException {
        leaseAccountCreditLevelService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    @Override
    public int updateByPrimaryKeySelective(LeaseAccountCreditLevel record) throws GMException {
        return leaseAccountCreditLevelService.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<AccountCreditLevelVo> findAccountCreditLevel(int pageNum, int pageSize, FindAccountCreditLevelVo pageVo) {
        return leaseAccountCreditLevelService.findAccountCreditLevel(pageNum, pageSize, pageVo);
    }

    @Override
    public ResultHashMap insert(LeaseAccountCreditLevel entity) throws GMException {
        return null;
    }

    /**
     * 评级
     *
     * @param leaseAccountCreditLevel
     * @return
     * @throws GMException
     */
    @Override
    public ResultHashMap setLevel(LeaseAccountCreditLevel leaseAccountCreditLevel) throws GMException {
        LeaseAccountCreditLevel leaseAccountCreditLevelBack = leaseAccountCreditLevelService.findAccountId(leaseAccountCreditLevel.getAccountId());
        if (leaseAccountCreditLevelBack == null) {
            leaseAccountCreditLevelService.insertSelective(leaseAccountCreditLevel);
        } else {
            leaseAccountCreditLevelService.updateByPrimaryKeySelective(leaseAccountCreditLevel);
        }
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.DUAL_SUCCESS);
        return resultHashMap;
    }

    @Override
    public int insertList(List<LeaseAccountCreditLevel> list) throws GMException {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(LeaseAccountCreditLevel entity) throws GMException {
        return 0;
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
        return leaseAccountCreditLevelService.findAccountId(accountId);
    }
}
