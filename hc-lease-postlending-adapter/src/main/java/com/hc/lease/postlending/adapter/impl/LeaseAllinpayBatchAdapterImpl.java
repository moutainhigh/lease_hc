package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseAllinpayBatchAdapter;
import com.hc.lease.postlending.model.LeaseAllinpayBatch;
import com.hc.lease.postlending.service.api.LeaseAllinpayBatchService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联批量代收批次统计AdapterImpl
 *
 * @author Tong
 * @version 2017-06-09
 */
@Service("leaseAllinpayBatchAdapter")
public class LeaseAllinpayBatchAdapterImpl implements LeaseAllinpayBatchAdapter {

    @Autowired
    private LeaseAllinpayBatchService leaseAllinpayBatchService;

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
        int row = leaseAllinpayBatchService.deleteByPrimaryKey(id);
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
        int row = leaseAllinpayBatchService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpayBatch record) throws GMException {
        record = leaseAllinpayBatchService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpayBatch record) throws GMException {
        record = leaseAllinpayBatchService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayBatch record) throws GMException {
        int row = leaseAllinpayBatchService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayBatch record) throws GMException {
        int row = leaseAllinpayBatchService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayBatch selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayBatch leaseAllinpayBatch = leaseAllinpayBatchService.selectByPrimaryKey(id);
        return leaseAllinpayBatch;
    }

    public int insertList(List<LeaseAllinpayBatch> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpayBatch> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpayBatch> page = leaseAllinpayBatchService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAllinpayBatch> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayBatch> leaseAllinpayBatchList = leaseAllinpayBatchService.findAll(paramsMap);
        return leaseAllinpayBatchList;
    }

    @Override
    public LeaseAllinpayBatch selectByBatchNumber(Map<String, Object> paramsMap) {
        LeaseAllinpayBatch leaseAllinpayBatch = leaseAllinpayBatchService.selectByBatchNumber(paramsMap);
        return leaseAllinpayBatch;
    }
}
