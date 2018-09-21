package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitStatusLogAdapter;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitStatusLogService;
import com.hc.lease.postlending.model.LeaseAllinpaySplitStatusLog;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 通联支付超额拆分交易明细 支付状态流水AdapterImpl
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitStatusLogAdapter")
public class LeaseAllinpaySplitStatusLogAdapterImpl implements LeaseAllinpaySplitStatusLogAdapter {

	@Autowired
	private LeaseAllinpaySplitStatusLogService leaseAllinpaySplitStatusLogService;

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
        int row = leaseAllinpaySplitStatusLogService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAllinpaySplitStatusLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpaySplitStatusLog record) throws GMException {
        record = leaseAllinpaySplitStatusLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpaySplitStatusLog record) throws GMException {
        record = leaseAllinpaySplitStatusLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitStatusLog record) throws GMException {
        int row = leaseAllinpaySplitStatusLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitStatusLog record) throws GMException {
        int row = leaseAllinpaySplitStatusLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpaySplitStatusLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog = leaseAllinpaySplitStatusLogService.selectByPrimaryKey(id);
        return leaseAllinpaySplitStatusLog;
    }

    public int insertList(List<LeaseAllinpaySplitStatusLog> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAllinpaySplitStatusLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpaySplitStatusLog> page = leaseAllinpaySplitStatusLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseAllinpaySplitStatusLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitStatusLog> leaseAllinpaySplitStatusLogList = leaseAllinpaySplitStatusLogService.findAll(paramsMap);
        return leaseAllinpaySplitStatusLogList;
    }

}
