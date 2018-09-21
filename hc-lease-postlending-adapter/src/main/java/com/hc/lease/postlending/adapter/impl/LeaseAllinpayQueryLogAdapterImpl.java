package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.adapter.api.LeaseAllinpayQueryLogAdapter;
import com.hc.lease.postlending.service.api.LeaseAllinpayQueryLogService;
import com.hc.lease.postlending.model.LeaseAllinpayQueryLog;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 通联轮询流水，通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条代收流水都对应一条轮询流水AdapterImpl
 * @author Tong
 * @version 2017-08-31
 */
@Service("leaseAllinpayQueryLogAdapter")
public class LeaseAllinpayQueryLogAdapterImpl implements LeaseAllinpayQueryLogAdapter {

	@Autowired
	private LeaseAllinpayQueryLogService leaseAllinpayQueryLogService;

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
        int row = leaseAllinpayQueryLogService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAllinpayQueryLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpayQueryLog record) throws GMException {
        record = leaseAllinpayQueryLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpayQueryLog record) throws GMException {
        record = leaseAllinpayQueryLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayQueryLog record) throws GMException {
        int row = leaseAllinpayQueryLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayQueryLog record) throws GMException {
        int row = leaseAllinpayQueryLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayQueryLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayQueryLog leaseAllinpayQueryLog = leaseAllinpayQueryLogService.selectByPrimaryKey(id);
        return leaseAllinpayQueryLog;
    }

    public int insertList(List<LeaseAllinpayQueryLog> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAllinpayQueryLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpayQueryLog> page = leaseAllinpayQueryLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAllinpayQueryLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayQueryLog> leaseAllinpayQueryLogList = leaseAllinpayQueryLogService.findAll(paramsMap);
        return leaseAllinpayQueryLogList;
    }

}
