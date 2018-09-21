package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitBatchAdapter;
import com.hc.lease.postlending.model.LeaseAllinpaySplitBatch;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitBatchService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 批量支付批次统计AdapterImpl
 *
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitBatchAdapter")
public class LeaseAllinpaySplitBatchAdapterImpl implements LeaseAllinpaySplitBatchAdapter {

    @Autowired
    private LeaseAllinpaySplitBatchService leaseAllinpaySplitBatchService;

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
        int row = leaseAllinpaySplitBatchService.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitBatchService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpaySplitBatch record) throws GMException {
        record = leaseAllinpaySplitBatchService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpaySplitBatch record) throws GMException {
        record = leaseAllinpaySplitBatchService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitBatch record) throws GMException {
        int row = leaseAllinpaySplitBatchService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitBatch record) throws GMException {
        int row = leaseAllinpaySplitBatchService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpaySplitBatch selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitBatch leaseAllinpaySplitBatch = leaseAllinpaySplitBatchService.selectByPrimaryKey(id);
        return leaseAllinpaySplitBatch;
    }

    public int insertList(List<LeaseAllinpaySplitBatch> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplitBatch> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpaySplitBatch> page = leaseAllinpaySplitBatchService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplitBatch> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitBatch> leaseAllinpaySplitBatchList = leaseAllinpaySplitBatchService.findAll(paramsMap);
        return leaseAllinpaySplitBatchList;
    }

    @Override
    public LeaseAllinpaySplitBatch selectByBatchNumber(Map<String, Object> paramsMap) {
        LeaseAllinpaySplitBatch leaseAllinpaySplitBatch = leaseAllinpaySplitBatchService.selectByBatchNumber(paramsMap);
        return leaseAllinpaySplitBatch;
    }
}
