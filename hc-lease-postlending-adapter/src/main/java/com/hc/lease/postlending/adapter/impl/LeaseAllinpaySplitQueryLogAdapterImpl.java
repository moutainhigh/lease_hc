package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitQueryLogAdapter;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitQueryLogService;
import com.hc.lease.postlending.model.LeaseAllinpaySplitQueryLog;

import hc.lease.common.util.ListUtil;

import java.util.List;
import java.util.Map;

import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 通联支付超额拆分交易明细 通联轮询流水AdapterImpl
 *
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitQueryLogAdapter")
public class LeaseAllinpaySplitQueryLogAdapterImpl implements LeaseAllinpaySplitQueryLogAdapter {

    @Autowired
    private LeaseAllinpaySplitQueryLogService leaseAllinpaySplitQueryLogService;

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
        int row = leaseAllinpaySplitQueryLogService.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitQueryLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpaySplitQueryLog record) throws GMException {
        record = leaseAllinpaySplitQueryLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpaySplitQueryLog record) throws GMException {
        record = leaseAllinpaySplitQueryLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitQueryLog record) throws GMException {
        int row = leaseAllinpaySplitQueryLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitQueryLog record) throws GMException {
        int row = leaseAllinpaySplitQueryLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpaySplitQueryLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitQueryLog leaseAllinpaySplitQueryLog = leaseAllinpaySplitQueryLogService.selectByPrimaryKey(id);
        return leaseAllinpaySplitQueryLog;
    }

    public int insertList(List<LeaseAllinpaySplitQueryLog> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplitQueryLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpaySplitQueryLog> page = leaseAllinpaySplitQueryLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplitQueryLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitQueryLog> leaseAllinpaySplitQueryLogList = leaseAllinpaySplitQueryLogService.findAll(paramsMap);
        return leaseAllinpaySplitQueryLogList;
    }

    @Override
    public List<LeaseAllinpaySplitQueryLog> selectByAllinpaySplitLogId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<LeaseAllinpaySplitQueryLog> leaseAllinpaySplitQueryLogList = leaseAllinpaySplitQueryLogService.selectByAllinpaySplitLogId(paramsMap, dubboTreaceParames);
        return leaseAllinpaySplitQueryLogList;
    }

    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseAllinpaySplitQueryLogService.updateRepaymentId(paramsMap);
        return row;
    }
}
