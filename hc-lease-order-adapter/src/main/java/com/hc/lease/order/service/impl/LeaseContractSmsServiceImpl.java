package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseContractSmsService;
import com.hc.lease.order.model.LeaseContractSms;
import com.hc.lease.order.dao.LeaseContractSmsMapper;

import java.util.List;
import java.util.Map;

/**
 * 短信日志ServiceImpl
 * @author Qiang
 * @version 2017-08-31
 */
@Service("leaseContractSmsService")
public class LeaseContractSmsServiceImpl implements LeaseContractSmsService {

	@Autowired
	private LeaseContractSmsMapper leaseContractSmsMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractSmsMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractSmsMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractSms insert(LeaseContractSms record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractSmsMapper.insert(record);
        return record;
    }

    public LeaseContractSms insertSelective(LeaseContractSms record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractSmsMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseContractSms> list) throws GMException {
        int row = leaseContractSmsMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractSms record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractSmsMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractSms record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractSmsMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractSms selectByPrimaryKey(Long id) throws GMException {
        LeaseContractSms leaseContractSms = leaseContractSmsMapper.selectByPrimaryKey(id);
        return leaseContractSms;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseContractSms> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractSms> leaseContractSmsList = leaseContractSmsMapper.findPage(paramsMap);
        PageInfo<LeaseContractSms> page = new PageInfo<LeaseContractSms>(leaseContractSmsList);
        return page;
    }

    public List <LeaseContractSms> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractSms> leaseContractSmsList = leaseContractSmsMapper.findAll(paramsMap);
        return leaseContractSmsList;
    }

}
