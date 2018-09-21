package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseContractArchiveLocationMapper;
import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.order.service.api.LeaseContractArchiveLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同-归档信息ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseContractArchiveLocationService")
public class LeaseContractArchiveLocationServiceImpl implements LeaseContractArchiveLocationService {

    @Autowired
    private LeaseContractArchiveLocationMapper leaseContractArchiveLocationMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractArchiveLocationMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractArchiveLocationMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractArchiveLocation insert(LeaseContractArchiveLocation record) throws GMException {

        int row = leaseContractArchiveLocationMapper.insert(record);
        return record;
    }

    public LeaseContractArchiveLocation insertSelective(LeaseContractArchiveLocation record) throws GMException {

        int row = leaseContractArchiveLocationMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseContractArchiveLocation> list) throws GMException {
        return 0;
    }


    public int updateByPrimaryKeySelective(LeaseContractArchiveLocation record) throws GMException {
        //record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractArchiveLocationMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractArchiveLocation record) throws GMException {
        //record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractArchiveLocationMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseContractArchiveLocation selectByPrimaryKey(Long id) throws GMException {
        LeaseContractArchiveLocation leaseContractArchiveLocation = leaseContractArchiveLocationMapper.selectByPrimaryKey(id);
        return leaseContractArchiveLocation;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractArchiveLocation> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractArchiveLocation> leaseContractArchiveLocationList = leaseContractArchiveLocationMapper.findPage(paramsMap);
        PageInfo<LeaseContractArchiveLocation> page = new PageInfo<LeaseContractArchiveLocation>(leaseContractArchiveLocationList);
        return page;
    }

    public List<LeaseContractArchiveLocation> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractArchiveLocation> leaseContractArchiveLocationList = leaseContractArchiveLocationMapper.findAll(paramsMap);
        return leaseContractArchiveLocationList;
    }

    public int deleteByContractId(Long id) {
        int row = leaseContractArchiveLocationMapper.deleteByContractId(id);
        return row;
    }
}
