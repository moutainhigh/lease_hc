package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseCarMaintainRuleMapper;
import com.hc.lease.baseInfo.model.LeaseCarMaintainRule;
import com.hc.lease.baseInfo.service.api.LeaseCarMaintainRuleService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 保养规则ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseCarMaintainRuleService")
public class LeaseCarMaintainRuleServiceImpl implements LeaseCarMaintainRuleService {

    @Autowired
    private LeaseCarMaintainRuleMapper leaseCarMaintainRuleMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarMaintainRuleMapper.deleteByPrimaryKey(id);
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
        int row = leaseCarMaintainRuleMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarMaintainRule insert(LeaseCarMaintainRule record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarMaintainRuleMapper.insert(record);
        return record;
    }

    public LeaseCarMaintainRule insertSelective(LeaseCarMaintainRule record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarMaintainRuleMapper.insertSelective(record);
        return record;
    }

    public LeaseCarMaintainRule selectByPrimaryKey(Long id) throws GMException {
        LeaseCarMaintainRule leaseCarMaintainRule = leaseCarMaintainRuleMapper.selectByPrimaryKey(id);
        return leaseCarMaintainRule;
    }

    public int updateByPrimaryKeySelective(LeaseCarMaintainRule record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarMaintainRuleMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarMaintainRule record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarMaintainRuleMapper.updateByPrimaryKey(record);
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
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarMaintainRule> leaseCarMaintainRuleList = leaseCarMaintainRuleMapper.findPage(paramsMap);
        PageInfo<LeaseCarMaintainRule> page = new PageInfo<LeaseCarMaintainRule>(leaseCarMaintainRuleList);

        return page;
    }

    public List<LeaseCarMaintainRule> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarMaintainRule> leaseCarMaintainRuleList = leaseCarMaintainRuleMapper.findAll(paramsMap);
        return leaseCarMaintainRuleList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseCarMaintainRule> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarMaintainRule> list = leaseCarMaintainRuleMapper.insertViewParames(paramsMap);
        return list;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarMaintainRuleMapper.disableByPrimaryKey(params);
        return row;
    }

}
