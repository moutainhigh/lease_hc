package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseMaintenancePartnerMapper;
import com.hc.lease.baseInfo.model.LeaseCarBuyFinancinger;
import com.hc.lease.baseInfo.model.LeaseMaintenancePartner;
import com.hc.lease.baseInfo.service.LeaseMaintenancePartnerService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 保养维护合作方ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseMaintenancePartnerService")
public class LeaseMaintenancePartnerServiceImpl implements LeaseMaintenancePartnerService {

    @Autowired
    private LeaseMaintenancePartnerMapper leaseMaintenancePartnerMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseMaintenancePartnerMapper.deleteByPrimaryKey(id);
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
        int row = leaseMaintenancePartnerMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseMaintenancePartner insert(LeaseMaintenancePartner record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseMaintenancePartnerMapper.insert(record);
        return record;
    }

    public LeaseMaintenancePartner insertSelective(LeaseMaintenancePartner record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseMaintenancePartnerMapper.insertSelective(record);
        return record;
    }

    public LeaseMaintenancePartner selectByPrimaryKey(Long id) throws GMException {
        LeaseMaintenancePartner leaseMaintenancePartner = leaseMaintenancePartnerMapper.selectByPrimaryKey(id);
        return leaseMaintenancePartner;
    }

    public int updateByPrimaryKeySelective(LeaseMaintenancePartner record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseMaintenancePartnerMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseMaintenancePartner record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseMaintenancePartnerMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseMaintenancePartner> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseMaintenancePartner> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseMaintenancePartner> leaseMaintenancePartnerList = leaseMaintenancePartnerMapper.findPage(paramsMap);
        PageInfo<LeaseMaintenancePartner> page = new PageInfo<LeaseMaintenancePartner>(leaseMaintenancePartnerList);
        return page;
    }

    public List<LeaseMaintenancePartner> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseMaintenancePartner> leaseMaintenancePartnerList = leaseMaintenancePartnerMapper.findAll(paramsMap);
        return leaseMaintenancePartnerList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseMaintenancePartner> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseMaintenancePartner> list = leaseMaintenancePartnerMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseMaintenancePartner> findByName(Map params) throws GMException {
        List<LeaseMaintenancePartner> list = leaseMaintenancePartnerMapper.findByName(params);
        return list;
    }

}
