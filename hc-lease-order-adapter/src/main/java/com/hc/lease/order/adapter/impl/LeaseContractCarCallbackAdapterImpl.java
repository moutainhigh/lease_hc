package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.CallbackDealWay;
import com.hc.lease.common.core.constant.ContractStatus;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractCarCallbackAdapter;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.model.LeaseContractCarCallback;
import com.hc.lease.order.service.api.LeaseContractCarCallbackService;
import com.hc.lease.order.service.api.LeaseContractService;
import com.hc.lease.order.vo.CarManagerDealFindContractVo;
import com.hc.lease.order.vo.FindByPrimaryKeyVo;
import com.hc.lease.supplier.model.LeaseCar;
import com.hc.lease.supplier.service.api.LeaseCarService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-收车AdapterImpl
 *
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractCarCallbackAdapter")
public class LeaseContractCarCallbackAdapterImpl implements LeaseContractCarCallbackAdapter {

    @Autowired
    private LeaseContractCarCallbackService leaseContractCarCallbackService;

    @Autowired
    private LeaseContractService leaseContractService;

    @Autowired
    private LeaseCarService leaseCarService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        CarManagerDealFindContractVo carManagerDealFindContractVo = leaseContractService.carManagerDealFindContract(paramsMap);
        Map<String, Object> backMap = Maps.newHashMap();
        backMap.put("carManagerDealFindContractVo", carManagerDealFindContractVo);
        return backMap;
    }

    /**
     * 根据ID删除记录
     *
     * @param id .
     * @return
     * @throws GMException
     */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractCarCallbackService.deleteByPrimaryKey(id);
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
        int row = leaseContractCarCallbackService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractCarCallback record) throws GMException {
        record = leaseContractCarCallbackService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractCarCallback record) throws GMException {

        Integer maxNumber = leaseContractCarCallbackService.findMaxDualNumber(null);
        if (maxNumber == null) {
            record.setDualNumber(1001);
        } else {
            record.setDualNumber(maxNumber + 1);
        }

        record = leaseContractCarCallbackService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractCarCallback record) throws GMException {

        int row = leaseContractCarCallbackService.updateByPrimaryKeySelective(record);

        //修改合同状态
        if (record.getDealWay().equals(CallbackDealWay.CallbackDealWay_3.value())) { //断供 则把合同状态改为断供
            LeaseContract leaseContract = new LeaseContract();
            leaseContract.setId(record.getContractId());
            leaseContract.setStatus(ContractStatus.STATUS_2);
            leaseContract.setDealStatus(CallbackDealWay.CallbackDealWay_3.dealStatus());
            leaseContractService.updateDealStatus(leaseContract);
        } else {
            LeaseContract leaseContract = new LeaseContract();
            leaseContract.setId(record.getContractId());
            leaseContract.setDealStatus(CallbackDealWay.getDealStatusValue(record.getDealWay()));
            leaseContractService.updateDealStatusAndStatusBack(leaseContract);
        }
        //修改合同状态

        //修改车辆状态
        LeaseCar leaseCar = new LeaseCar();
        leaseCar.setDealStatus(CallbackDealWay.getDealStatusValue(record.getDealWay()));
        leaseCar.setCarCondition(CallbackDealWay.getCarConditionValue(record.getDealWay()));
        leaseCar.setId(record.getCarId());
        leaseCarService.updateDealStatus(leaseCar);
        //修改车辆状态

        return row;
    }

    public int updateByPrimaryKey(LeaseContractCarCallback record) throws GMException {
        int row = leaseContractCarCallbackService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractCarCallback selectByPrimaryKey(Long id) throws GMException {
        LeaseContractCarCallback leaseContractCarCallback = leaseContractCarCallbackService.selectByPrimaryKey(id);
        return leaseContractCarCallback;
    }

    public int insertList(List<LeaseContractCarCallback> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractCarCallback> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractCarCallback> page = leaseContractCarCallbackService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseContractCarCallback> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractCarCallback> leaseContractCarCallbackList = leaseContractCarCallbackService.findAll(paramsMap);
        return leaseContractCarCallbackList;
    }

    @Override
    public FindByPrimaryKeyVo findByPrimaryKey(Long id) {
        FindByPrimaryKeyVo findByPrimaryKeyVo = leaseContractCarCallbackService.findByPrimaryKey(id);
        return findByPrimaryKeyVo;
    }

    @Override
    public int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException {
        int dealNumber = leaseContractCarCallbackService.findMaxDualNumber(paramsMap);
        return dealNumber;
    }
}
