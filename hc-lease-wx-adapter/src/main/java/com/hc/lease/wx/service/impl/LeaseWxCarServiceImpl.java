package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.wx.dao.LeaseWxCarMapper;
import com.hc.lease.wx.dao.LeaseWxCarSchemeMapper;
import com.hc.lease.wx.model.LeaseWxCar;
import com.hc.lease.wx.model.LeaseWxCarScheme;
import com.hc.lease.wx.service.api.LeaseWxCarService;
import hc.lease.common.util.JsonUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息ServiceImpl
 *
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxCarService")
public class LeaseWxCarServiceImpl implements LeaseWxCarService {

    @Autowired
    private LeaseWxCarMapper leaseWxCarMapper;

    @Autowired
    private LeaseWxCarSchemeMapper leaseWxCarSchemeMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCarMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxCarMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxCar insert(LeaseWxCar leaseWxCar) throws GMException {
        leaseWxCar.setCreateTime(DateTime.now().toDate());
        leaseWxCar.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarMapper.insert(leaseWxCar);
        return leaseWxCar;
    }

    public LeaseWxCar insertSelective(LeaseWxCar leaseWxCar) throws GMException {
        leaseWxCar.setCreateTime(DateTime.now().toDate());
        leaseWxCar.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarMapper.insertSelective(leaseWxCar);
        return leaseWxCar;
    }

    /**
     * 批量新增
     *
     * @param list .
     * @return
     * @throws GMException
     */
    public int insertList(List<LeaseWxCar> list) throws GMException {
        int row = leaseWxCarMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxCar leaseWxCar) throws GMException {
        leaseWxCar.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarMapper.updateByPrimaryKeySelective(leaseWxCar);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCar leaseWxCar) throws GMException {
        leaseWxCar.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCarMapper.updateByPrimaryKey(leaseWxCar);
        return row;
    }

    public LeaseWxCar selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCar leaseWxCar = leaseWxCarMapper.selectByPrimaryKey(id);
        return leaseWxCar;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseWxCar> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxCar> leaseWxCarList = leaseWxCarMapper.findPage(paramsMap);
        if (leaseWxCarList != null) {
            if (leaseWxCarList.size() > 0) {
                for (int i = 0; i < leaseWxCarList.size(); i++) {
                    LeaseWxCar leaseWxCar = leaseWxCarList.get(i);
                    if (leaseWxCar != null) {
                        List<LeaseWxCarScheme> leaseWxCarSchemes = leaseWxCar.getLeaseWxCarSchemes();
                        if (leaseWxCarSchemes != null) {
                            if (leaseWxCarSchemes.size() > 0) {
                                String leaseWxCarSchemesJson = JsonUtil.stringify(leaseWxCarSchemes);
                                leaseWxCar.setLeaseWxCarSchemeJson(leaseWxCarSchemesJson);
                            }
                        }
                    }
                }
            }
        }
        PageInfo<LeaseWxCar> page = new PageInfo<LeaseWxCar>(leaseWxCarList);
        return page;
    }

    public List<LeaseWxCar> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCar> leaseWxCarList = leaseWxCarMapper.findAll(paramsMap);
        return leaseWxCarList;
    }

    public void updateSort(LeaseWxCar leaseWxCar) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id", leaseWxCar.getId());
        paramsMap.put("mark", leaseWxCar.getMark());
        leaseWxCarMapper.updateSort(paramsMap);
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseWxCar> findByCarName(Map<String, Object> paramsMap) {
        List<LeaseWxCar> leaseWxCarList = leaseWxCarMapper.findByCarName(paramsMap);
        return leaseWxCarList;
    }

    /**
     * 批量更新对象
     *
     * @param list
     * @return
     */
    @Override
    public int updateByPrimaryKeyList(List<LeaseWxCar> list)  throws GMException{
        int row = leaseWxCarMapper.updateByPrimaryKeyList(list);
        return row;
    }

    public List<LeaseWxCar> findByName(Map params) {

        List<LeaseWxCar> leaseWxCarList=leaseWxCarMapper.findByName(params);
        return leaseWxCarList;
    }

    public List<LeaseWxCar> findAllNoPage(Map<String, Object> paramsMap) {
        List<LeaseWxCar> leaseWxCarList=  leaseWxCarMapper.findPage(paramsMap);
        return leaseWxCarList;
    }
}
