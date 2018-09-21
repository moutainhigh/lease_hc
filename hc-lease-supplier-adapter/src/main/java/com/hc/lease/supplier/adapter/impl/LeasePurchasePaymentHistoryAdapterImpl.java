package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.baseInfo.service.api.LeaseUseUsedService;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeasePurchasePaymentHistoryAdapter;
import com.hc.lease.supplier.model.LeasePurchaseContract;
import com.hc.lease.supplier.model.LeasePurchasePaymentHistory;
import com.hc.lease.supplier.service.api.LeasePurchaseContractService;
import com.hc.lease.supplier.service.api.LeasePurchasePaymentHistoryService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hc.lease.common.core.constant.DictType.TYPE_STAGING_NUMBER;

/**
 * 采购融租还款记录AdapterImpl
 * @author Qiang
 * @version 2017-05-12
 */
@Service("leasePurchasePaymentHistoryAdapter")
public class LeasePurchasePaymentHistoryAdapterImpl implements LeasePurchasePaymentHistoryAdapter {

	@Autowired
	private LeasePurchasePaymentHistoryService leasePurchasePaymentHistoryService;
    @Autowired
    private LeasePurchaseContractService leasePurchaseContractService;
    @Autowired
    private LeaseDictService leaseDictService;
    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;


    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseDict> leaseDicts = leaseDictService.findAll(null);
        Long dictId=null;
        for (LeaseDict leaseDict : leaseDicts) {
           if("融资".equals(leaseDict.getValue())){
               dictId = leaseDict.getId();
               break;
           }
        }
        Map<String,Object> paramMap=Maps.newHashMap();
        paramMap.put("dictId",dictId);
        List<LeasePurchaseContract> leasePurchaseContractList=leasePurchaseContractService.selectByLeaseCar(paramMap);
        List<LeaseDict> leaseDictList=leaseDictService.findByType(TYPE_STAGING_NUMBER);

        Map<String,Object> map=new HashMap();
        map.put("leasePurchaseContractList",leasePurchaseContractList);
        map.put("leaseDictList",leaseDictList);
        return map;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {

        int row = leasePurchasePaymentHistoryService.deleteByPrimaryKey(id);
        leaseUseUsedService.deleteByUse(id,UseType.TYPE_LEASE_PURCHASE_PAYMENT_HISTORY);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leasePurchasePaymentHistoryService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeasePurchasePaymentHistory record) throws GMException {
        record = leasePurchasePaymentHistoryService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeasePurchasePaymentHistory record) throws GMException {
        record = leasePurchasePaymentHistoryService.insertSelective(record);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getPurchaseContractId(), null, UseType.TYPE_LEASE_PURCHASE_PAYMENT_HISTORY, UsedType.TYPE_LEASE_PURCHASE_CONTRACT);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getPurchaseContractId(), null, UseType.TYPE_LEASE_PURCHASE_PAYMENT_HISTORY, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeasePurchasePaymentHistory> list) throws GMException {
        return 0;
    }

    public int updateByPrimaryKeySelective(LeasePurchasePaymentHistory record) throws GMException {
        int row = leasePurchasePaymentHistoryService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(),UseType.TYPE_LEASE_PURCHASE_PAYMENT_HISTORY);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getPurchaseContractId(), null, UseType.TYPE_LEASE_PURCHASE_PAYMENT_HISTORY, UsedType.TYPE_LEASE_PURCHASE_CONTRACT);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getPurchaseContractId(), null, UseType.TYPE_LEASE_PURCHASE_PAYMENT_HISTORY, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);
        return row;
    }

    public int updateByPrimaryKey(LeasePurchasePaymentHistory record) throws GMException {
        int row = leasePurchasePaymentHistoryService.updateByPrimaryKey(record);
        return row;
    }


    public LeasePurchasePaymentHistory selectByPrimaryKey(Long id) throws GMException {
        LeasePurchasePaymentHistory leasePurchasePaymentHistory = leasePurchasePaymentHistoryService.selectByPrimaryKey(id);
        return leasePurchasePaymentHistory;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeasePurchasePaymentHistory> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeasePurchasePaymentHistory> page = leasePurchasePaymentHistoryService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeasePurchasePaymentHistory> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeasePurchasePaymentHistory> leasePurchasePaymentHistoryList = leasePurchasePaymentHistoryService.findAll(paramsMap);
        return leasePurchasePaymentHistoryList;
    }

}
