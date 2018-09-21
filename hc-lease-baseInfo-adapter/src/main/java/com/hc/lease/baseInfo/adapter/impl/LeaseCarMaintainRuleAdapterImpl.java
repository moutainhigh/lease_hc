package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.adapter.api.LeaseCarMaintainRuleAdapter;
import com.hc.lease.baseInfo.model.LeaseCarMaintainRule;
import com.hc.lease.baseInfo.service.api.LeaseCarMaintainRuleService;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 保养规则AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseCarMaintainRuleAdapter")
public class LeaseCarMaintainRuleAdapterImpl implements LeaseCarMaintainRuleAdapter {

    @Autowired
    private LeaseCarMaintainRuleService leaseCarMaintainRuleService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }


    public ResultHashMap insertSelective(LeaseCarMaintainRule leaseCarMaintainRule, UserSession userSession) throws GMException {
        leaseCarMaintainRule.setCreateBy(userSession.getUserId());
        leaseCarMaintainRule.setUpdateBy(userSession.getUserId());
        leaseCarMaintainRule = leaseCarMaintainRuleService.insertSelective(leaseCarMaintainRule);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseCarMaintainRule leaseCarMaintainRule, UserSession userSession) throws GMException {
        leaseCarMaintainRule.setUpdateBy(userSession.getUserId());
        int row = leaseCarMaintainRuleService.updateByPrimaryKeySelective(leaseCarMaintainRule);
        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarMaintainRuleService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarMaintainRuleService.deleteByPrimaryKey(id);
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
        int row = leaseCarMaintainRuleService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarMaintainRule record) throws GMException {
        record = leaseCarMaintainRuleService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarMaintainRule record) throws GMException {
        record = leaseCarMaintainRuleService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseCarMaintainRule selectByPrimaryKey(Long id) throws GMException {
        LeaseCarMaintainRule leaseCarMaintainRule = leaseCarMaintainRuleService.selectByPrimaryKey(id);
        return leaseCarMaintainRule;
    }

    public int updateByPrimaryKeySelective(LeaseCarMaintainRule record) throws GMException {
        int row = leaseCarMaintainRuleService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarMaintainRule record) throws GMException {
        int row = leaseCarMaintainRuleService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarMaintainRule> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarMaintainRule> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarMaintainRule> page = leaseCarMaintainRuleService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCarMaintainRule> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarMaintainRule> leaseCarMaintainRuleList = leaseCarMaintainRuleService.findAll(paramsMap);
        return leaseCarMaintainRuleList;
    }

}
