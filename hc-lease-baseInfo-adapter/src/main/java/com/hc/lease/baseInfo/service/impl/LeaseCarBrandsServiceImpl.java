package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseCarBrandsMapper;
import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.baseInfo.service.api.LeaseCarBrandsService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆品牌ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseCarBrandsService")
public class LeaseCarBrandsServiceImpl implements LeaseCarBrandsService {

    @Autowired
    private LeaseCarBrandsMapper leaseCarBrandsMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarBrandsMapper.deleteByPrimaryKey(id);
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
        int row = leaseCarBrandsMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarBrands insert(LeaseCarBrands record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarBrandsMapper.insert(record);
        return record;
    }

    public LeaseCarBrands insertSelective(LeaseCarBrands record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarBrandsMapper.insertSelective(record);
        return record;
    }

    public LeaseCarBrands selectByPrimaryKey(Long id) throws GMException {
        LeaseCarBrands leaseCarBrands = leaseCarBrandsMapper.selectByPrimaryKey(id);
        return leaseCarBrands;
    }

    public int updateByPrimaryKeySelective(LeaseCarBrands record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarBrandsMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarBrands record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarBrandsMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarBrands> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarBrands> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarBrands> leaseCarBrandsList = leaseCarBrandsMapper.findPage(paramsMap);
        PageInfo<LeaseCarBrands> page = new PageInfo<LeaseCarBrands>(leaseCarBrandsList);
        return page;
    }

    public List<LeaseCarBrands> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarBrands> list = leaseCarBrandsMapper.findAll(paramsMap);
        return list;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseCarBrands> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarBrands> list = leaseCarBrandsMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseCarBrands> findByName(Map params) throws GMException {
        List<LeaseCarBrands> list = leaseCarBrandsMapper.findByName(params);
        return list;
    }

    public int disableByPrimaryKey(Map<String, Object> params) {
        int row = leaseCarBrandsMapper.disableByPrimaryKey(params);
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
        List<String> list = leaseCarBrandsMapper.findExportExcelModel(params);
        return list;
    }

    public void updateSort(LeaseCarBrands leaseCarBrands) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseCarBrands.getId());
        paramsMap.put("mark",leaseCarBrands.getMark());
        leaseCarBrandsMapper.updateSort(paramsMap);
    }
}
