package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseCarBuyFinancingerMapper;
import com.hc.lease.baseInfo.model.LeaseCarBuyFinancinger;
import com.hc.lease.baseInfo.service.api.LeaseCarBuyFinancingerService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 购车融资方ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseCarBuyFinancingerService")
public class LeaseCarBuyFinancingerServiceImpl implements LeaseCarBuyFinancingerService {

    @Autowired
    private LeaseCarBuyFinancingerMapper leaseCarBuyFinancingerMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarBuyFinancingerMapper.deleteByPrimaryKey(id);
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
        int row = leaseCarBuyFinancingerMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarBuyFinancinger insert(LeaseCarBuyFinancinger record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarBuyFinancingerMapper.insert(record);
        return record;
    }

    public LeaseCarBuyFinancinger insertSelective(LeaseCarBuyFinancinger record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarBuyFinancingerMapper.insertSelective(record);
        return record;
    }

    public LeaseCarBuyFinancinger selectByPrimaryKey(Long id) throws GMException {
        LeaseCarBuyFinancinger leaseCarBuyFinancinger = leaseCarBuyFinancingerMapper.selectByPrimaryKey(id);
        return leaseCarBuyFinancinger;
    }

    public int updateByPrimaryKeySelective(LeaseCarBuyFinancinger record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarBuyFinancingerMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarBuyFinancinger record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarBuyFinancingerMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarBuyFinancinger> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarBuyFinancinger> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerMapper.findPage(paramsMap);
        PageInfo<LeaseCarBuyFinancinger> page = new PageInfo<LeaseCarBuyFinancinger>(leaseCarBuyFinancingerList);
        return page;
    }

    public List<LeaseCarBuyFinancinger> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerMapper.findAll(paramsMap);
        return leaseCarBuyFinancingerList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseCarBuyFinancinger> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarBuyFinancinger> list = leaseCarBuyFinancingerMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseCarBuyFinancinger> findByName(Map params) throws GMException {
        List<LeaseCarBuyFinancinger> list = leaseCarBuyFinancingerMapper.findByName(params);
        return list;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarBuyFinancingerMapper.disableByPrimaryKey(params);
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
        List<String> list = leaseCarBuyFinancingerMapper.findExportExcelModel(params);
        return list;
    }

    public void updateSort(LeaseCarBuyFinancinger carBuyFinancinger) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",carBuyFinancinger.getId());
        paramsMap.put("mark",carBuyFinancinger.getMark());
        leaseCarBuyFinancingerMapper.updateSort(paramsMap);

    }

    public List<LeaseCarBuyFinancinger> findAllNoPage(Map param) {
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList=leaseCarBuyFinancingerMapper.findPage(param);
        return leaseCarBuyFinancingerList;
    }
}
