package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseAllinpayLogAdapter;
import com.hc.lease.postlending.model.LeaseAllinpayLog;
import com.hc.lease.postlending.service.api.LeaseAllinpayLogService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联代收流水AdapterImpl
 *
 * @author Tong
 * @version 2017-06-09
 */
@Service("leaseAllinpayLogAdapter")
public class LeaseAllinpayLogAdapterImpl implements LeaseAllinpayLogAdapter {

    @Autowired
    private LeaseAllinpayLogService leaseAllinpayLogService;

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
        int row = leaseAllinpayLogService.deleteByPrimaryKey(id);
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
        int row = leaseAllinpayLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpayLog record) throws GMException {
        record = leaseAllinpayLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpayLog record) throws GMException {
        record = leaseAllinpayLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayLog record) throws GMException {
        int row = leaseAllinpayLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayLog record) throws GMException {
        int row = leaseAllinpayLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayLog leaseAllinpayLog = leaseAllinpayLogService.selectByPrimaryKey(id);
        return leaseAllinpayLog;
    }

    public int insertList(List<LeaseAllinpayLog> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpayLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpayLog> page = leaseAllinpayLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAllinpayLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayLog> leaseAllinpayLogList = leaseAllinpayLogService.findAll(paramsMap);
        return leaseAllinpayLogList;
    }

    /**
     * @param paramsMap
     * @return
     */
    public LeaseAllinpayLog findByReqSn(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseAllinpayLog leaseAllinpayLog = leaseAllinpayLogService.findByReqSn(paramsMap, dubboTreaceParames);
        return leaseAllinpayLog;
    }

    /**
     * 修改合同 则 跟着更新 支付流水
     *
     * @param leaseAllinpayLog
     * @return
     * @throws GMException
     */
    @Override
    public int updateByContractId(LeaseAllinpayLog leaseAllinpayLog) throws GMException {
        int row = leaseAllinpayLogService.updateByContractId(leaseAllinpayLog);
        return row;
    }
}
