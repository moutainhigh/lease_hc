package com.hc.lease.supplier.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeasePurchaseContract;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.LeasePurchasePaymentHistoryService;
import com.hc.lease.supplier.model.LeasePurchasePaymentHistory;
import com.hc.lease.supplier.dao.LeasePurchasePaymentHistoryMapper;

import java.util.List;
import java.util.Map;

/**
 * 采购融租还款记录ServiceImpl
 * @author Qiang
 * @version 2017-05-12
 */
@Service("leasePurchasePaymentHistoryService")
public class LeasePurchasePaymentHistoryServiceImpl implements LeasePurchasePaymentHistoryService {

	@Autowired
	private LeasePurchasePaymentHistoryMapper leasePurchasePaymentHistoryMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leasePurchasePaymentHistoryMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leasePurchasePaymentHistoryMapper.deleteBatchById(ids);
        return row;
    }

    public LeasePurchasePaymentHistory insert(LeasePurchasePaymentHistory record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leasePurchasePaymentHistoryMapper.insert(record);
        return record;
    }

    public LeasePurchasePaymentHistory insertSelective(LeasePurchasePaymentHistory record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leasePurchasePaymentHistoryMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeasePurchasePaymentHistory> record) throws GMException {
        int row = leasePurchasePaymentHistoryMapper.insertList(record);
        return row;
    }

    public int updateByPrimaryKeySelective(LeasePurchasePaymentHistory record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leasePurchasePaymentHistoryMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeasePurchasePaymentHistory record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leasePurchasePaymentHistoryMapper.updateByPrimaryKey(record);
        return row;
    }



    public LeasePurchasePaymentHistory selectByPrimaryKey(Long id) throws GMException {
        LeasePurchasePaymentHistory leasePurchasePaymentHistory = leasePurchasePaymentHistoryMapper.selectByPrimaryKey(id);
        return leasePurchasePaymentHistory;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeasePurchasePaymentHistory> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeasePurchasePaymentHistory> leasePurchasePaymentHistoryList = leasePurchasePaymentHistoryMapper.findPage(paramsMap);
        PageInfo<LeasePurchasePaymentHistory> page = new PageInfo<LeasePurchasePaymentHistory>(leasePurchasePaymentHistoryList);
        return page;
    }

    public List <LeasePurchasePaymentHistory> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeasePurchasePaymentHistory> leasePurchasePaymentHistoryList = leasePurchasePaymentHistoryMapper.findAll(paramsMap);
        return leasePurchasePaymentHistoryList;
    }

}
