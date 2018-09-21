package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseInvoiceHeaderMapper;
import com.hc.lease.baseInfo.model.LeaseInvoiceHeader;
import com.hc.lease.baseInfo.service.LeaseInvoiceHeaderService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 发票抬头信息ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseInvoiceHeaderService")
public class LeaseInvoiceHeaderServiceImpl implements LeaseInvoiceHeaderService {

    @Autowired
    private LeaseInvoiceHeaderMapper leaseInvoiceHeaderMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseInvoiceHeaderMapper.deleteByPrimaryKey(id);
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
        int row = leaseInvoiceHeaderMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseInvoiceHeader insert(LeaseInvoiceHeader record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseInvoiceHeaderMapper.insert(record);
        return record;
    }

    public LeaseInvoiceHeader insertSelective(LeaseInvoiceHeader record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseInvoiceHeaderMapper.insertSelective(record);
        return record;
    }

    public LeaseInvoiceHeader selectByPrimaryKey(Long id) throws GMException {
        LeaseInvoiceHeader leaseInvoiceHeader = leaseInvoiceHeaderMapper.selectByPrimaryKey(id);
        return leaseInvoiceHeader;
    }

    public int updateByPrimaryKeySelective(LeaseInvoiceHeader record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInvoiceHeaderMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseInvoiceHeader record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInvoiceHeaderMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseInvoiceHeader> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseInvoiceHeader> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseInvoiceHeader> leaseInvoiceHeaderList = leaseInvoiceHeaderMapper.findPage(paramsMap);
        PageInfo<LeaseInvoiceHeader> page = new PageInfo<LeaseInvoiceHeader>(leaseInvoiceHeaderList);
        return page;
    }

    public List<LeaseInvoiceHeader> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseInvoiceHeader> leaseInvoiceHeaderList = leaseInvoiceHeaderMapper.findAll(paramsMap);
        return leaseInvoiceHeaderList;
    }

    public LeaseInvoiceHeader selectByCarSupplierIdAndType(Long id) {

        LeaseInvoiceHeader leaseInvoiceHeader =  leaseInvoiceHeaderMapper.selectByCarSupplierIdAndType(id);


        return leaseInvoiceHeader;
    }
}
