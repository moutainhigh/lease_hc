package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.adapter.api.LeaseRuleAdapter;
import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.baseInfo.service.api.LeaseRuleService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 规则表AdapterImpl
 *
 * @author Tong
 * @version 2017-04-19
 */
@Service("leaseRuleAdapter")
public class LeaseRuleAdapterImpl implements LeaseRuleAdapter {

    @Autowired
    private LeaseRuleService leaseRuleService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    @Override
    public LeaseRule selectEntityByType(String ruleType) {
        return leaseRuleService.selectEntityByType(ruleType);
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseRuleService.deleteByPrimaryKey(id);
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
        int row = leaseRuleService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseRule record) throws GMException {
        record = leaseRuleService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseRule record) throws GMException {
        record = leaseRuleService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseRule selectByPrimaryKey(Long id) throws GMException {
        LeaseRule leaseRule = leaseRuleService.selectByPrimaryKey(id);
        return leaseRule;
    }

    public int updateByPrimaryKeySelective(LeaseRule record) throws GMException {
        int row = leaseRuleService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseRule record) throws GMException {
        int row = leaseRuleService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseRule> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseRule> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseRule> page = leaseRuleService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseRule> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseRule> leaseRuleList = leaseRuleService.findAll(paramsMap);
        return leaseRuleList;
    }

}
