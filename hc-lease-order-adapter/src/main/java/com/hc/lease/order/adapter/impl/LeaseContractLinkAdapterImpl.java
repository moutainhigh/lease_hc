package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractLinkAdapter;
import com.hc.lease.order.model.LeaseContractLink;
import com.hc.lease.order.service.api.LeaseContractLinkService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同 挂靠，可能每一种款项会操作多次扣款，租期结束且融租合同贷后管理登记为挂靠AdapterImpl
 *
 * @author Tong
 * @version 2017-08-24
 */
@Service("leaseContractLinkAdapter")
public class LeaseContractLinkAdapterImpl implements LeaseContractLinkAdapter {

    @Autowired
    private LeaseContractLinkService leaseContractLinkService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractLinkService.deleteByPrimaryKey(id);
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
        int row = leaseContractLinkService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractLink record) throws GMException {
        record = leaseContractLinkService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractLink record) throws GMException {
        record = leaseContractLinkService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractLink record) throws GMException {
        int row = leaseContractLinkService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractLink record) throws GMException {
        int row = leaseContractLinkService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractLink selectByPrimaryKey(Long id) throws GMException {
        LeaseContractLink leaseContractLink = leaseContractLinkService.selectByPrimaryKey(id);
        return leaseContractLink;
    }

    public int insertList(List<LeaseContractLink> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractLink> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractLink> page = leaseContractLinkService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContractLink> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractLink> leaseContractLinkList = leaseContractLinkService.findAll(paramsMap);
        return leaseContractLinkList;
    }

}
