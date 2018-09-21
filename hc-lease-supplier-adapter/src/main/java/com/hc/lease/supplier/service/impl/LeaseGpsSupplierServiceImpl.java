package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseGpsSupplierMapper;
import com.hc.lease.supplier.model.LeaseGpsSupplier;
import com.hc.lease.supplier.service.api.LeaseGpsSupplierService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * GPS供应商ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseGpsSupplierService")
public class LeaseGpsSupplierServiceImpl implements LeaseGpsSupplierService {

    @Autowired
    private LeaseGpsSupplierMapper leaseGpsSupplierMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseGpsSupplierMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseGpsSupplierMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseGpsSupplier insert(LeaseGpsSupplier record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseGpsSupplierMapper.insert(record);
        return record;
    }

    public LeaseGpsSupplier insertSelective(LeaseGpsSupplier record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseGpsSupplierMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseGpsSupplier> record) throws GMException {
        int row = leaseGpsSupplierMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseGpsSupplier record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseGpsSupplierMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseGpsSupplier record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseGpsSupplierMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseGpsSupplier selectByPrimaryKey(Long id) throws GMException {
        LeaseGpsSupplier leaseGpsSupplier = leaseGpsSupplierMapper.selectByPrimaryKey(id);
        return leaseGpsSupplier;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseGpsSupplier> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierMapper.findPage(paramsMap);
        PageInfo<LeaseGpsSupplier> page = new PageInfo<LeaseGpsSupplier>(leaseGpsSupplierList);
        return page;
    }

    public List<LeaseGpsSupplier> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierMapper.findAll(paramsMap);
        return leaseGpsSupplierList;
    }

    public List<LeaseGpsSupplier> findByName(Map params) {

        List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierMapper.findByName(params);
        return leaseGpsSupplierList;
    }

    public int disableByPrimaryKey(Map<String, Object> params) {
        int row = leaseGpsSupplierMapper.disableByPrimaryKey(params);
        return row;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(Map<String, Object> paramsMap) throws GMException {
        List<String> leaseGpsSupplierList = leaseGpsSupplierMapper.findExportExcelModel(paramsMap);
        return leaseGpsSupplierList;
    }

    public void updateSort(LeaseGpsSupplier leaseGpsSupplier) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseGpsSupplier.getId());
        paramsMap.put("mark",leaseGpsSupplier.getMark());
        leaseGpsSupplierMapper.updateSort(paramsMap);
    }

    public List<LeaseGpsSupplier> findAllNoPage(Map param) {
        List<LeaseGpsSupplier> leaseGpsSupplierList=leaseGpsSupplierMapper.findPage(param);
        return leaseGpsSupplierList;
    }
}
