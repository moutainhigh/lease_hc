package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseSchemeOrderAdapter;
import com.hc.lease.order.model.LeaseSchemeOrder;
import com.hc.lease.order.service.api.LeaseSchemeOrderService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租方案申请订单AdapterImpl
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseSchemeOrderAdapter")
public class LeaseSchemeOrderAdapterImpl implements LeaseSchemeOrderAdapter {

	@Autowired
	private LeaseSchemeOrderService leaseSchemeOrderService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeOrderService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemeOrderService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemeOrder record) throws GMException {
        record = leaseSchemeOrderService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemeOrder record) throws GMException {
        record = leaseSchemeOrderService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseSchemeOrder record) throws GMException {
        int row = leaseSchemeOrderService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeOrder record) throws GMException {
        int row = leaseSchemeOrderService.updateByPrimaryKey(record);
        return row;
    }



    public LeaseSchemeOrder selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeOrder leaseSchemeOrder = leaseSchemeOrderService.selectByPrimaryKey(id);
        return leaseSchemeOrder;
    }

    public int insertList(List<LeaseSchemeOrder> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemeOrder> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemeOrder> page = leaseSchemeOrderService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseSchemeOrder> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeOrder> leaseSchemeOrderList = leaseSchemeOrderService.findAll(paramsMap);
        return leaseSchemeOrderList;
    }

}
