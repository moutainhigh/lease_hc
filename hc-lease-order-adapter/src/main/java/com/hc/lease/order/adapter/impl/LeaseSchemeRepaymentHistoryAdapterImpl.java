package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.adapter.api.LeaseSchemeRepaymentHistoryAdapter;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentHistoryService;
import com.hc.lease.order.model.LeaseSchemeRepaymentHistory;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 根据融租合同数据生成月租还款计划明细 历史AdapterImpl
 * @author Tong
 * @version 2018-07-19
 */
@Service("leaseSchemeRepaymentHistoryAdapter")
public class LeaseSchemeRepaymentHistoryAdapterImpl implements LeaseSchemeRepaymentHistoryAdapter {

	@Autowired
	private LeaseSchemeRepaymentHistoryService leaseSchemeRepaymentHistoryService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
    * 根据ID删除记录
    *
    * @param id .
    * @return
    * @throws GMException
    */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeRepaymentHistoryService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemeRepaymentHistoryService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemeRepaymentHistory record) throws GMException {
        record = leaseSchemeRepaymentHistoryService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemeRepaymentHistory record) throws GMException {
        record = leaseSchemeRepaymentHistoryService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeRepaymentHistory record) throws GMException {
        int row = leaseSchemeRepaymentHistoryService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeRepaymentHistory record) throws GMException {
        int row = leaseSchemeRepaymentHistoryService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemeRepaymentHistory selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeRepaymentHistory leaseSchemeRepaymentHistory = leaseSchemeRepaymentHistoryService.selectByPrimaryKey(id);
        return leaseSchemeRepaymentHistory;
    }

    public int insertList(List<LeaseSchemeRepaymentHistory> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemeRepaymentHistory> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemeRepaymentHistory> page = leaseSchemeRepaymentHistoryService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseSchemeRepaymentHistory> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepaymentHistory> leaseSchemeRepaymentHistoryList = leaseSchemeRepaymentHistoryService.findAll(paramsMap);
        return leaseSchemeRepaymentHistoryList;
    }

}
