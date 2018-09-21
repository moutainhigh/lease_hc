package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseCarModelMapper;
import com.hc.lease.baseInfo.model.LeaseCarModel;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.baseInfo.service.api.LeaseCarModelService;
import com.hc.lease.baseInfo.vo.LeaseCarModelColorPriceVo;
import com.hc.lease.common.core.exception.GMException;
import hc.lease.common.util.JsonUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车型ServiceImpl
 *
 * @author Tong
 * @version 2017-04-13
 */
@Service("leaseCarModelService")
public class LeaseCarModelServiceImpl implements LeaseCarModelService {

    @Autowired
    private LeaseCarModelMapper leaseCarModelMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarModelMapper.deleteByPrimaryKey(id);
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
        int row = leaseCarModelMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarModel insert(LeaseCarModel record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarModelMapper.insert(record);
        return record;
    }

    public LeaseCarModel insertSelective(LeaseCarModel record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarModelMapper.insertSelective(record);
        return record;
    }

    public LeaseCarModel selectByPrimaryKey(Long id) throws GMException {
        LeaseCarModel leaseCarModel = leaseCarModelMapper.selectByPrimaryKey(id);
        return leaseCarModel;
    }

    public Map<String, Object> selectById(Long id) throws GMException {
        Map<String, Object> leaseCarModel = leaseCarModelMapper.selectById(id);
        return leaseCarModel;
    }

    public int updateByPrimaryKeySelective(LeaseCarModel record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarModelMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarModel record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarModelMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarModel> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarModel> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarModel> leaseCarModelList = leaseCarModelMapper.findPage(paramsMap);

        if (leaseCarModelList != null) {
            if (leaseCarModelList.size() > 0) {
                for (int i = 0; i < leaseCarModelList.size(); i++) {
                    LeaseCarModel leaseCarModel = leaseCarModelList.get(i);
                    if (leaseCarModel != null) {
                        List<LeaseCarModelColorPriceVo> leaseCarModelColorPriceVoList = leaseCarModel.getLeaseCarModelColorPriceVoList();
                        if (leaseCarModelColorPriceVoList != null) {
                            if (leaseCarModelColorPriceVoList.size() > 0) {
                                String leaseCarModelColorPriceJson = JsonUtil.stringify(leaseCarModelColorPriceVoList);
                                leaseCarModel.setLeaseCarModelColorPriceJson(leaseCarModelColorPriceJson);
                            }
                        }
                    }
                }
            }
        }

        PageInfo<LeaseCarModel> page = new PageInfo<LeaseCarModel>(leaseCarModelList);
        return page;
    }

    public List<LeaseCarModel> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarModel> leaseCarModelList = leaseCarModelMapper.findAll(paramsMap);
        return leaseCarModelList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseCarModel> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarModel> list = leaseCarModelMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 根据系列主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCarModel> findBySeriesId(List<Long> ids) throws GMException {
        List<LeaseCarModel> leaseCarSeriesList = leaseCarModelMapper.findBySeriesId(ids);
        return leaseCarSeriesList;
    }

    /**
     * 根据系列主键id、车型名称查找
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public List<LeaseCarModel> findBySeriesIdAndName(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarModel> leaseCarSeriesList = leaseCarModelMapper.findBySeriesIdAndName(paramsMap);
        return leaseCarSeriesList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseCarModel> findByName(Map params) throws GMException {
        List<LeaseCarModel> list = leaseCarModelMapper.findByName(params);
        return list;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarModelMapper.disableByPrimaryKey(params);
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
        List<String> list = leaseCarModelMapper.findExportExcelModel(params);
        return list;
    }

    public void updateSort(LeaseCarModel leaseCarModel) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseCarModel.getId());
        paramsMap.put("mark",leaseCarModel.getMark());
        leaseCarModelMapper.updateSort(paramsMap);

    }

    public void updateMarketPriceByPrimaryKey(Map<String, Object> paramsMap) {
        leaseCarModelMapper.updateMarketPriceByPrimaryKey(paramsMap);
    }

    public List<LeaseCarModel> findAllNoPage(Map params) {
        List<LeaseCarModel>  leaseCarModelList=leaseCarModelMapper.findPage(params);
        return leaseCarModelList;
    }
}
