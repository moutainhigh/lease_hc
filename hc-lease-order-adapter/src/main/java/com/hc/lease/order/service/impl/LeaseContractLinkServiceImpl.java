package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseContractLinkMapper;
import com.hc.lease.order.model.LeaseContractLink;
import com.hc.lease.order.service.api.LeaseContractLinkService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同 挂靠，租期结束且融租合同贷后管理登记为挂靠ServiceImpl
 *
 * @author Tong
 * @version 2017-08-24
 */
@Service("leaseContractLinkService")
public class LeaseContractLinkServiceImpl implements LeaseContractLinkService {

    @Autowired
    private LeaseContractLinkMapper leaseContractLinkMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractLinkMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractLinkMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractLink insert(LeaseContractLink leaseContractLink) throws GMException {
        leaseContractLink.setCreateTime(DateTime.now().toDate());
        leaseContractLink.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractLinkMapper.insert(leaseContractLink);
        return leaseContractLink;
    }

    public LeaseContractLink insertSelective(LeaseContractLink leaseContractLink) throws GMException {
        leaseContractLink.setCreateTime(DateTime.now().toDate());
        leaseContractLink.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractLinkMapper.insertSelective(leaseContractLink);
        return leaseContractLink;
    }

    public int insertList(List<LeaseContractLink> list) throws GMException {
        int row = leaseContractLinkMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractLink leaseContractLink) throws GMException {
        leaseContractLink.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractLinkMapper.updateByPrimaryKeySelective(leaseContractLink);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractLink leaseContractLink) throws GMException {
        leaseContractLink.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractLinkMapper.updateByPrimaryKey(leaseContractLink);
        return row;
    }

    public LeaseContractLink selectByPrimaryKey(Long id) throws GMException {
        LeaseContractLink leaseContractLink = leaseContractLinkMapper.selectByPrimaryKey(id);
        return leaseContractLink;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractLink> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractLink> leaseContractLinkList = leaseContractLinkMapper.findPage(paramsMap);
        PageInfo<LeaseContractLink> page = new PageInfo<LeaseContractLink>(leaseContractLinkList);
        return page;
    }

    public List<LeaseContractLink> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractLink> leaseContractLinkList = leaseContractLinkMapper.findAll(paramsMap);
        return leaseContractLinkList;
    }

}
