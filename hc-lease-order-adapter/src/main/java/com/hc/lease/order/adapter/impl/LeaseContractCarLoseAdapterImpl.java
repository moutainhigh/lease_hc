package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.CallbackDealWay;
import com.hc.lease.common.core.constant.ContractStatus;
import com.hc.lease.common.core.constant.IncomeExpeSource;
import com.hc.lease.common.core.constant.LostDealWay;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractCarLoseAdapter;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.model.LeaseContractCarLose;
import com.hc.lease.order.model.LeaseContractIncomeExpe;
import com.hc.lease.order.service.api.LeaseContractCarLoseService;
import com.hc.lease.order.service.api.LeaseContractIncomeExpeService;
import com.hc.lease.order.service.api.LeaseContractService;
import com.hc.lease.order.vo.CarManagerDealFindContractVo;
import com.hc.lease.supplier.model.LeaseCar;
import com.hc.lease.supplier.service.api.LeaseCarService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-丢失AdapterImpl
 *
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractCarLoseAdapter")
public class LeaseContractCarLoseAdapterImpl implements LeaseContractCarLoseAdapter {

    @Autowired
    private LeaseContractCarLoseService leaseContractCarLoseService;

    @Autowired
    private LeaseContractService leaseContractService;

    @Autowired
    private LeaseContractIncomeExpeService leaseContractIncomeExpeService;

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
        int row = leaseContractCarLoseService.deleteByPrimaryKey(id);
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
        int row = leaseContractCarLoseService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractCarLose record) throws GMException {
        record = leaseContractCarLoseService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractCarLose record) throws GMException {
        Integer maxNumber = leaseContractCarLoseService.findMaxDualNumber(null);
        if (maxNumber == null) {
            record.setDualNumber(1001);
        } else {
            record.setDualNumber(maxNumber + 1);
        }
        record = leaseContractCarLoseService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractCarLose record) throws GMException {

        int row = leaseContractCarLoseService.updateByPrimaryKeySelective(record);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("contractId", record.getContractId());
        paramsMap.put("source", IncomeExpeSource.LOST.value());
        paramsMap.put("sourceId", record.getId());
        leaseContractIncomeExpeService.deleteByContractId(paramsMap);
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = record.getIncomeExpeList();
        if (leaseContractIncomeExpeList != null && leaseContractIncomeExpeList.size() > 0) {
            LeaseContractIncomeExpe leaseContractIncomeExpe = null;
            for (int i = 0; i < leaseContractIncomeExpeList.size(); i++) {
                leaseContractIncomeExpe = leaseContractIncomeExpeList.get(i);
                leaseContractIncomeExpe.setSource(IncomeExpeSource.LOST.value());
                leaseContractIncomeExpe.setSourceId(record.getId());
            }
            leaseContractIncomeExpeService.insertList(leaseContractIncomeExpeList);
        }

        //修改合同状态
        if (record.getDealWay().equals(LostDealWay.LostDealWay_2.value())) { //断供 则把合同状态改为结束
            LeaseContract leaseContract = new LeaseContract();
            leaseContract.setId(record.getContractId());
            leaseContract.setStatus(ContractStatus.STATUS_2);
            leaseContract.setDealStatus(LostDealWay.LostDealWay_2.dealStatus());
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
        leaseCar.setDealStatus(LostDealWay.getDealStatusValue(record.getDealWay()));
        leaseCar.setCarCondition(CallbackDealWay.getCarConditionValue(record.getDealWay()));
        leaseCar.setId(record.getCarId());
        leaseCarService.updateDealStatus(leaseCar);
        //修改车辆状态

        return row;
    }

    public int updateByPrimaryKey(LeaseContractCarLose record) throws GMException {
        int row = leaseContractCarLoseService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractCarLose selectByPrimaryKey(Long id) throws GMException {
        LeaseContractCarLose leaseContractCarLose = leaseContractCarLoseService.selectByPrimaryKey(id);
        return leaseContractCarLose;
    }

    public int insertList(List<LeaseContractCarLose> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractCarLose> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractCarLose> page = leaseContractCarLoseService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseContractCarLose> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractCarLose> leaseContractCarLoseList = leaseContractCarLoseService.findAll(paramsMap);
        return leaseContractCarLoseList;
    }

    @Override
    public int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException {
        int dualNumber = leaseContractCarLoseService.findMaxDualNumber(paramsMap);
        return dualNumber;
    }
}
