package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseOverdueLogAdapter;
import com.hc.lease.postlending.model.LeaseOverdueLog;
import com.hc.lease.postlending.service.api.LeaseOverdueLogService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 逾期记录AdapterImpl
 *
 * @author Tong
 * @version 2017-06-09
 */
@Service("leaseOverdueLogAdapter")
public class LeaseOverdueLogAdapterImpl implements LeaseOverdueLogAdapter {

    @Autowired
    private LeaseOverdueLogService leaseOverdueLogService;

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
        int row = leaseOverdueLogService.deleteByPrimaryKey(id);
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
        int row = leaseOverdueLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseOverdueLog record) throws GMException {
        record = leaseOverdueLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseOverdueLog record) throws GMException {
        record = leaseOverdueLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseOverdueLog record) throws GMException {
        int row = leaseOverdueLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseOverdueLog record) throws GMException {
        int row = leaseOverdueLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseOverdueLog selectByPrimaryKey(Long id) throws GMException {
        LeaseOverdueLog leaseOverdueLog = leaseOverdueLogService.selectByPrimaryKey(id);
        return leaseOverdueLog;
    }

    public int insertList(List<LeaseOverdueLog> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseOverdueLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseOverdueLog> page = leaseOverdueLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseOverdueLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseOverdueLog> leaseOverdueLogList = leaseOverdueLogService.findAll(paramsMap);
        return leaseOverdueLogList;
    }

    /**
     * 合同修改同时修改 还款计划主键id
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseOverdueLogService.updateRepaymentId(paramsMap);
        return row;
    }

    @Override
    public int updateBatch(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames) {
        int row = leaseOverdueLogService.updateBatch(leaseOverdueLogList, dubboTreaceParames);
        return row;
    }

    @Override
    public int insertBatch(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames) {
        int row = leaseOverdueLogService.insertBatch(leaseOverdueLogList, dubboTreaceParames);
        return row;
    }

    @Override
    public LeaseOverdueLog selectByContractIdRepaymentId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseOverdueLog leaseOverdueLog = leaseOverdueLogService.selectByContractIdRepaymentId(paramsMap, dubboTreaceParames);
        return leaseOverdueLog;
    }
}
