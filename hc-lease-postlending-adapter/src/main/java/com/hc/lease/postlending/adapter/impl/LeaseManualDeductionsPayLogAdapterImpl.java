package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseManualDeductionsPayLogAdapter;
import com.hc.lease.postlending.model.LeaseManualDeductionsPayLog;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsPayLogService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 手动扣款，每一次操作扣款都记录流水AdapterImpl
 *
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductionsPayLogAdapter")
public class LeaseManualDeductionsPayLogAdapterImpl implements LeaseManualDeductionsPayLogAdapter {

    @Autowired
    private LeaseManualDeductionsPayLogService leaseManualDeductionsPayLogService;

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
        int row = leaseManualDeductionsPayLogService.deleteByPrimaryKey(id);
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
        int row = leaseManualDeductionsPayLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseManualDeductionsPayLog record) throws GMException {
        record = leaseManualDeductionsPayLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseManualDeductionsPayLog record) throws GMException {
        record = leaseManualDeductionsPayLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductionsPayLog record) throws GMException {
        int row = leaseManualDeductionsPayLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductionsPayLog record) throws GMException {
        int row = leaseManualDeductionsPayLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseManualDeductionsPayLog selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductionsPayLog leaseManualDeductionsPayLog = leaseManualDeductionsPayLogService.selectByPrimaryKey(id);
        return leaseManualDeductionsPayLog;
    }

    public int insertList(List<LeaseManualDeductionsPayLog> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseManualDeductionsPayLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseManualDeductionsPayLog> page = leaseManualDeductionsPayLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseManualDeductionsPayLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductionsPayLog> leaseManualDeductionsPayLogList = leaseManualDeductionsPayLogService.findAll(paramsMap);
        return leaseManualDeductionsPayLogList;
    }

    @Override
    public LeaseManualDeductionsPayLog findByReqSn(Map<String, Object> paramsMap) {
        LeaseManualDeductionsPayLog leaseManualDeductionsPayLogList = leaseManualDeductionsPayLogService.findByReqSn(paramsMap);
        return leaseManualDeductionsPayLogList;
    }
}
