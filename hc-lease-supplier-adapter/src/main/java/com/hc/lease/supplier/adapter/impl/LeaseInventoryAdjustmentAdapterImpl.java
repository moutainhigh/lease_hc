package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.baseInfo.service.api.LeaseBranchCompanyService;
import com.hc.lease.baseInfo.service.api.LeaseDealerService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseInventoryAdjustmentAdapter;
import com.hc.lease.supplier.model.LeaseInventoryAdjustment;
import com.hc.lease.supplier.model.LeaseStorehouse;
import com.hc.lease.supplier.service.api.LeaseInventoryAdjustmentService;
import com.hc.lease.supplier.service.api.LeaseStorehouseService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 调库AdapterImpl
 * @author Qiang
 * @version 2017-05-22
 */
@Service("leaseInventoryAdjustmentAdapter")
public class LeaseInventoryAdjustmentAdapterImpl implements LeaseInventoryAdjustmentAdapter {

	@Autowired
	private LeaseInventoryAdjustmentService leaseInventoryAdjustmentService;
    @Autowired
    private LeaseStorehouseService leaseStorehouseService;
    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;
    @Autowired
    private LeaseDealerService leaseDealerService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        Map<String,Object> map=new HashMap();
        //分公司仓库
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(null);
        if(leaseBranchCompanyList!=null && leaseBranchCompanyList.size()>0) {
            Iterator<LeaseBranchCompany> branchCompanyIterator = leaseBranchCompanyList.iterator();
            while(branchCompanyIterator.hasNext()){
                LeaseBranchCompany leaseBranchCompany = branchCompanyIterator.next();
                Map<String, Object> params = new HashMap();
                params.put("belongType", 0);
                params.put("belongId", leaseBranchCompany.getId());
                List<LeaseStorehouse> storehouseList = leaseStorehouseService.findByBelongIdAndBelongType(params);
                if (storehouseList.size() == 0) {
                    branchCompanyIterator.remove();
                    continue;
                } else {
                    leaseBranchCompany.setLeaseStorehouseList(storehouseList);
                }
            }
        }
        //经销商仓库
        List<LeaseDealer> leaseDealerList = leaseDealerService.selectByGrade(1);
        if(leaseDealerList!=null && leaseDealerList.size()>0) {
            Iterator<LeaseDealer> leaseDealerIterator = leaseDealerList.iterator();
            while(leaseDealerIterator.hasNext()){
                LeaseDealer leaseDealer = leaseDealerIterator.next();
                Map<String, Object> params = new HashMap();
                params.put("belongType", 1);
                params.put("belongId", leaseDealer.getId());
                List<LeaseStorehouse> storehouseLists = leaseStorehouseService.findByBelongIdAndBelongType(params);
                if (storehouseLists.size() == 0) {
                    leaseDealerIterator.remove();
                    continue;
                } else {
                    leaseDealer.setLeaseStorehouseList(storehouseLists);
                }
            }
        }
        //二网仓库
        List<LeaseDealer> leaseDealerLists = leaseDealerService.selectByGrade(2);
        if(leaseDealerLists!=null&& leaseDealerLists.size()>0) {
            Iterator<LeaseDealer> dealerIterator = leaseDealerLists.iterator();
            while(dealerIterator.hasNext()){
                LeaseDealer dealer = dealerIterator.next();
                Map<String, Object> params = new HashMap();
                params.put("belongType", 2);
                params.put("belongId", dealer.getId());
                List<LeaseStorehouse> storehouses = leaseStorehouseService.findByBelongIdAndBelongType(params);
                if (storehouses.size() == 0) {
                    dealerIterator.remove();
                    continue;
                } else {
                    dealer.setLeaseStorehouseList(storehouses);
                }
            }
        }

        map.put("leaseDealerStorehouseList",leaseDealerList);
        map.put("leaseTwoDealerStorehouseList",leaseDealerLists);
        map.put("leaseCompanyStorehouseList",leaseBranchCompanyList);
        return map;
    }
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseInventoryAdjustmentService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leaseInventoryAdjustmentService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseInventoryAdjustment record) throws GMException {
        leaseInventoryAdjustmentService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }
    public ResultHashMap insertSelective(LeaseInventoryAdjustment record) throws GMException {
        leaseInventoryAdjustmentService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }
    public int insertList(List<LeaseInventoryAdjustment> list) throws GMException {
        return 0;
    }



    public int updateByPrimaryKeySelective(LeaseInventoryAdjustment record) throws GMException {
        int row = leaseInventoryAdjustmentService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseInventoryAdjustment record) throws GMException {
        int row = leaseInventoryAdjustmentService.updateByPrimaryKey(record);
        return row;
    }



    public LeaseInventoryAdjustment selectByPrimaryKey(Long id) throws GMException {
        LeaseInventoryAdjustment leaseInventoryAdjustment = leaseInventoryAdjustmentService.selectByPrimaryKey(id);
        return leaseInventoryAdjustment;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseInventoryAdjustment> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseInventoryAdjustment> page = leaseInventoryAdjustmentService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeaseInventoryAdjustment> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseInventoryAdjustment> leaseInventoryAdjustmentList = leaseInventoryAdjustmentService.findAll(paramsMap);
        return leaseInventoryAdjustmentList;
    }

}
