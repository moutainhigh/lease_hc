package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseCarSupplierMapper;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.service.api.LeaseCarSupplierService;
import com.hc.lease.supplier.vo.LeaseCarSupplierPageVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆供应商ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-05
 */
@Service("leaseCarSupplierService")
public class LeaseCarSupplierServiceImpl implements LeaseCarSupplierService {

    @Autowired
    private LeaseCarSupplierMapper leaseCarSupplierMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarSupplierMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseCarSupplierMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarSupplier insert(LeaseCarSupplier record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarSupplierMapper.insert(record);
        return record;
    }

    public LeaseCarSupplier insertSelective(LeaseCarSupplier record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarSupplierMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseCarSupplier> record) throws GMException {
        int row = leaseCarSupplierMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseCarSupplier record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarSupplierMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarSupplier record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarSupplierMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseCarSupplier selectByPrimaryKey(Long id) throws GMException {
        LeaseCarSupplier leaseCarSupplier = leaseCarSupplierMapper.selectByPrimaryKey(id);
        return leaseCarSupplier;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarSupplier> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierMapper.findPage(paramsMap);
        PageInfo<LeaseCarSupplier> page = new PageInfo<LeaseCarSupplier>(leaseCarSupplierList);
        return page;
    }

    public List<LeaseCarSupplier> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierMapper.findAll(paramsMap);
        return leaseCarSupplierList;
    }

    public List<LeaseCarSupplier> findByName(Map params) {

        List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierMapper.findByName(params);
        return leaseCarSupplierList;
    }

    public int disableByPrimaryKey(Map<String, Object> params) {
        int row = leaseCarSupplierMapper.disableByPrimaryKey(params);
        return row;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param params
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(Map params) throws GMException {
        List<String> leaseCarSupplierList = leaseCarSupplierMapper.findExportExcelModel(params);
        return leaseCarSupplierList;
    }

    public void updateSort(LeaseCarSupplier leaseCarSupplier) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseCarSupplier.getId());
        paramsMap.put("mark",leaseCarSupplier.getMark());
        leaseCarSupplierMapper.updateSort(paramsMap);
    }

    public List<LeaseCarSupplierPageVo> findAllNoPage(Map params) {
        List<LeaseCarSupplierPageVo> leaseCarSupplierList = leaseCarSupplierMapper.findAllNoPage(params);
        return leaseCarSupplierList;
    }
}
