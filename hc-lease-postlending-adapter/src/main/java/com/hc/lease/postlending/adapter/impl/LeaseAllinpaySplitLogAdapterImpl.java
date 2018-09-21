package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitLogAdapter;
import com.hc.lease.postlending.model.LeaseAllinpaySplitLog;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitLogService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 支付流水AdapterImpl
 *
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitLogAdapter")
public class LeaseAllinpaySplitLogAdapterImpl implements LeaseAllinpaySplitLogAdapter {

    @Autowired
    private LeaseAllinpaySplitLogService leaseAllinpaySplitLogService;

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
        int row = leaseAllinpaySplitLogService.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpaySplitLog record) throws GMException {
        record = leaseAllinpaySplitLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpaySplitLog record) throws GMException {
        record = leaseAllinpaySplitLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitLog record) throws GMException {
        int row = leaseAllinpaySplitLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitLog record) throws GMException {
        int row = leaseAllinpaySplitLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpaySplitLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitLog leaseAllinpaySplitLog = leaseAllinpaySplitLogService.selectByPrimaryKey(id);
        return leaseAllinpaySplitLog;
    }

    public int insertList(List<LeaseAllinpaySplitLog> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplitLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpaySplitLog> page = leaseAllinpaySplitLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplitLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitLog> leaseAllinpaySplitLogList = leaseAllinpaySplitLogService.findAll(paramsMap);
        return leaseAllinpaySplitLogList;
    }

    @Override
    public LeaseAllinpaySplitLog findByReqSn(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseAllinpaySplitLog leaseAllinpaySplitLog = leaseAllinpaySplitLogService.findByReqSn(paramsMap, dubboTreaceParames);
        return leaseAllinpaySplitLog;
    }

    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseAllinpaySplitLogService.updateRepaymentId(paramsMap);
        return row;
    }
}
