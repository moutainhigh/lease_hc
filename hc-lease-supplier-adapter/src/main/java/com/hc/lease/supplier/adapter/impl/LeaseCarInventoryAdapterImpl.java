package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseCarInventoryAdapter;
import com.hc.lease.supplier.model.LeaseCarInventory;
import com.hc.lease.supplier.service.api.LeaseCarInventoryService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 库存AdapterImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseCarInventoryAdapter")
public class LeaseCarInventoryAdapterImpl implements LeaseCarInventoryAdapter {

	@Autowired
	private LeaseCarInventoryService leaseCarInventoryService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarInventoryService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leaseCarInventoryService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarInventory record) throws GMException {
        record = leaseCarInventoryService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarInventory record) throws GMException {
        record = leaseCarInventoryService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseCarInventory> list) throws GMException {
        return 0;
    }

   /* public int insert(List<LeaseCarInventory> record) throws GMException {
        int row = leaseCarInventoryService.insert(record);
        return row;
    }

    public int insertSelective(List<LeaseCarInventory> record) throws GMException {
        int row = leaseCarInventoryService.insertSelective(record);
        return row;
    }
*/
    public int updateByPrimaryKeySelective(LeaseCarInventory record) throws GMException {
        int row = leaseCarInventoryService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarInventory record) throws GMException {
        int row = leaseCarInventoryService.updateByPrimaryKey(record);
        return row;
    }

   /* public int updateByPrimaryKeySelective(List<LeaseCarInventory> record) throws GMException {
        int row = leaseCarInventoryService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseCarInventory> record) throws GMException {
        int row = leaseCarInventoryService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeaseCarInventory selectByPrimaryKey(Long id) throws GMException {
        LeaseCarInventory leaseCarInventory = leaseCarInventoryService.selectByPrimaryKey(id);
        return leaseCarInventory;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseCarInventory> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarInventory> page = leaseCarInventoryService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeaseCarInventory> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarInventory> leaseCarInventoryList = leaseCarInventoryService.findAll(paramsMap);
        return leaseCarInventoryList;
    }

}
