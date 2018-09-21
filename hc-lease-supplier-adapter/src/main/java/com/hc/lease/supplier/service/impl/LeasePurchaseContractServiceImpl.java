package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeasePurchaseContractMapper;
import com.hc.lease.supplier.model.LeasePurchaseContract;
import com.hc.lease.supplier.service.api.LeasePurchaseContractService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 采购合同ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-10
 */
@Service("leasePurchaseContractService")
public class LeasePurchaseContractServiceImpl implements LeasePurchaseContractService {

    @Autowired
    private LeasePurchaseContractMapper leasePurchaseContractMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leasePurchaseContractMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leasePurchaseContractMapper.deleteBatchById(ids);
        return row;
    }

    public LeasePurchaseContract insert(LeasePurchaseContract record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leasePurchaseContractMapper.insert(record);
        return record;
    }

    public LeasePurchaseContract insertSelective(LeasePurchaseContract record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leasePurchaseContractMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeasePurchaseContract> record) throws GMException {
        int row = leasePurchaseContractMapper.insertList(record);
        return row;
    }

    public int updateByPrimaryKeySelective(LeasePurchaseContract record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leasePurchaseContractMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeasePurchaseContract record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leasePurchaseContractMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeasePurchaseContract selectByPrimaryKey(Long id) throws GMException {
        LeasePurchaseContract leasePurchaseContract = leasePurchaseContractMapper.selectByPrimaryKey(id);
        return leasePurchaseContract;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeasePurchaseContract> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractMapper.findPage(paramsMap);
        PageInfo<LeasePurchaseContract> page = new PageInfo<LeasePurchaseContract>(leasePurchaseContractList);
        return page;
    }

    public List<LeasePurchaseContract> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractMapper.findAll(paramsMap);
        return leasePurchaseContractList;
    }

    public List<LeasePurchaseContract> selectByLeaseCar(Map<String, Object> paramsMap) {
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractMapper.selectByLeaseCar(paramsMap);
        return leasePurchaseContractList;
    }

    public List<LeasePurchaseContract> findByCarSupplierId(List<Long> ids) {

        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractMapper.findByCarSupplierId(ids);

        return leasePurchaseContractList;
    }

    public List<LeasePurchaseContract> findByParams(Map<String, Object> paramsMap) {
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractMapper.findByParams(paramsMap);
        return leasePurchaseContractList;
    }

    public List<LeasePurchaseContract> selectByCarBuyFinancingerId(List<Long> ids) {
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractMapper.selectByCarBuyFinancingerId(ids);

        return leasePurchaseContractList;
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
        List<String> leasePurchaseContractList = leasePurchaseContractMapper.findExportExcelModel(params);
        return leasePurchaseContractList;
    }

    /**
     * 根据采购合同编号查询
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeasePurchaseContract> selectByContractNumber(Map<String, Object> paramsMap) {
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractMapper.selectByContractNumber(paramsMap);
        return leasePurchaseContractList;
    }
}
