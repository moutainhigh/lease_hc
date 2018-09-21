package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseSchemeOrderAccountAdapter;
import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import com.hc.lease.order.service.api.LeaseSchemeOrderAccountService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租方案申请订单-承租人AdapterImpl
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseSchemeOrderAccountAdapter")
public class LeaseSchemeOrderAccountAdapterImpl implements LeaseSchemeOrderAccountAdapter {

	@Autowired
	private LeaseSchemeOrderAccountService leaseSchemeOrderAccountService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeOrderAccountService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemeOrderAccountService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemeOrderAccount record) throws GMException {
        record = leaseSchemeOrderAccountService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemeOrderAccount record) throws GMException {
        record = leaseSchemeOrderAccountService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }



    public int updateByPrimaryKeySelective(LeaseSchemeOrderAccount record) throws GMException {
        int row = leaseSchemeOrderAccountService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeOrderAccount record) throws GMException {
        int row = leaseSchemeOrderAccountService.updateByPrimaryKey(record);
        return row;
    }



    public LeaseSchemeOrderAccount selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeOrderAccount leaseSchemeOrderAccount = leaseSchemeOrderAccountService.selectByPrimaryKey(id);
        return leaseSchemeOrderAccount;
    }

    public int insertList(List<LeaseSchemeOrderAccount> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemeOrderAccount> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemeOrderAccount> page = leaseSchemeOrderAccountService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseSchemeOrderAccount> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList = leaseSchemeOrderAccountService.findAll(paramsMap);
        return leaseSchemeOrderAccountList;
    }

    @Override
    public List<LeaseSchemeOrderAccount> selectBySchemeOrderId(long schemeOrderId) {
        return leaseSchemeOrderAccountService.selectBySchemeOrderId(schemeOrderId);
    }
}
