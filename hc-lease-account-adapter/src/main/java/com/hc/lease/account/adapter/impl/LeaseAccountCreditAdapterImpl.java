package com.hc.lease.account.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.account.adapter.api.LeaseAccountCreditAdapter;
import com.hc.lease.account.model.LeaseAccountCredit;
import com.hc.lease.account.service.api.LeaseAccountCreditService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 注册用户/承租人征信信息AdapterImpl
 * @author Tong
 * @version 2017-06-06
 */
@Service("leaseAccountCreditAdapter")
public class LeaseAccountCreditAdapterImpl implements LeaseAccountCreditAdapter {

	@Autowired
	private LeaseAccountCreditService leaseAccountCreditService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountCreditService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAccountCreditService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAccountCredit record) throws GMException {
        record = leaseAccountCreditService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAccountCredit record) throws GMException {
        record = leaseAccountCreditService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAccountCredit record) throws GMException {
        int row = leaseAccountCreditService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountCredit record) throws GMException {
        int row = leaseAccountCreditService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccountCredit selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountCredit leaseAccountCredit = leaseAccountCreditService.selectByPrimaryKey(id);
        return leaseAccountCredit;
    }

    public int insertList(List<LeaseAccountCredit> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAccountCredit> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAccountCredit> page = leaseAccountCreditService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAccountCredit> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountCredit> leaseAccountCreditList = leaseAccountCreditService.findAll(paramsMap);
        return leaseAccountCreditList;
    }

    public int updateByAccountId(LeaseAccountCredit leaseAccountCredit) {
        int row = leaseAccountCreditService.updateByAccountId(leaseAccountCredit);
        return row;
    }

    public int deleteByAccountId(Long accountId) {
        int row = leaseAccountCreditService.deleteByAccountId(accountId);
        return row;
    }

    public int deleteBatchByAccountId(List<Long> ids) {
        int row = leaseAccountCreditService.deleteBatchByAccountId(ids);
        return row;
    }
}
