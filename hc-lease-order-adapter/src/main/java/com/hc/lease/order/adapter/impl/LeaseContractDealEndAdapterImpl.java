package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.common.core.constant.CarCondition;
import com.hc.lease.common.core.constant.ContractEndDealWay;
import com.hc.lease.common.core.constant.ContractStatus;
import com.hc.lease.common.core.constant.IncomeExpeSource;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractDealEndAdapter;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.model.LeaseContractDealEnd;
import com.hc.lease.order.model.LeaseContractIncomeExpe;
import com.hc.lease.order.service.api.LeaseContractDealEndService;
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
 * 贷后合同管理-结束处置AdapterImpl
 *
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractDealEndAdapter")
public class LeaseContractDealEndAdapterImpl implements LeaseContractDealEndAdapter {

    @Autowired
    private LeaseContractDealEndService leaseContractDealEndService;

    @Autowired
    private LeaseContractService leaseContractService;

    @Autowired
    private LeaseDictService leaseDictService;

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
        int row = leaseContractDealEndService.deleteByPrimaryKey(id);
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
        int row = leaseContractDealEndService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractDealEnd record) throws GMException {
        record = leaseContractDealEndService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractDealEnd record) throws GMException {
        record = leaseContractDealEndService.insertSelective(record);
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = record.getIncomeExpeList();
        if (leaseContractIncomeExpeList != null && leaseContractIncomeExpeList.size() > 0) {
            LeaseContractIncomeExpe leaseContractIncomeExpe = null;
            for (int i = 0; i < leaseContractIncomeExpeList.size(); i++) {
                leaseContractIncomeExpe = leaseContractIncomeExpeList.get(i);
                leaseContractIncomeExpe.setSource(IncomeExpeSource.DEAL_END.value());
                leaseContractIncomeExpe.setSourceId(record.getId());
            }
            leaseContractIncomeExpeService.insertList(leaseContractIncomeExpeList);
        }

        //修改合同状态
        if (
                record.getDealWay().equals(ContractEndDealWay.ContractEndDealWay_2.value())
                        || record.getDealWay().equals(ContractEndDealWay.ContractEndDealWay_3.value())
                        || record.getDealWay().equals(ContractEndDealWay.ContractEndDealWay_4.value())
                        || record.getDealWay().equals(ContractEndDealWay.ContractEndDealWay_5.value())
                ) { //结束 则把合同状态改为结束
            LeaseContract leaseContract = new LeaseContract();
            leaseContract.setId(record.getContractId());
            leaseContract.setStatus(ContractStatus.STATUS_2);
            leaseContract.setDealStatus(ContractEndDealWay.getDealStatusValue(record.getDealWay()));
            leaseContractService.updateDealStatus(leaseContract);
        } else {
            LeaseContract leaseContract = new LeaseContract();
            leaseContract.setId(record.getContractId());
            leaseContract.setDealStatus(ContractEndDealWay.getDealStatusValue(record.getDealWay()));
            leaseContractService.updateDealStatusAndStatusBack(leaseContract);
        }
        //修改合同状态

        //修改车辆状态
        LeaseCar leaseCar = new LeaseCar();
        leaseCar.setDealStatus(ContractEndDealWay.getDealStatusValue(record.getDealWay()));
        leaseCar.setCarCondition(CarCondition.CarCondition_2.value());
        leaseCarService.updateDealStatus(leaseCar);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractDealEnd record) throws GMException {
        int row = leaseContractDealEndService.updateByPrimaryKeySelective(record);
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("contractId", record.getContractId());
        paramsMap.put("source", IncomeExpeSource.DEAL_END.value());
        paramsMap.put("sourceId", record.getId());
        leaseContractIncomeExpeService.deleteByContractId(paramsMap);
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = record.getIncomeExpeList();
        if (leaseContractIncomeExpeList != null && leaseContractIncomeExpeList.size() > 0) {
            LeaseContractIncomeExpe leaseContractIncomeExpe = null;
            for (int i = 0; i < leaseContractIncomeExpeList.size(); i++) {
                leaseContractIncomeExpe = leaseContractIncomeExpeList.get(i);
                leaseContractIncomeExpe.setSource(IncomeExpeSource.DEAL_END.value());
                leaseContractIncomeExpe.setSourceId(record.getId());
            }
            leaseContractIncomeExpeService.insertList(leaseContractIncomeExpeList);
        }

        //修改合同状态
        if (
                record.getDealWay().equals(ContractEndDealWay.ContractEndDealWay_2.value())
                        || record.getDealWay().equals(ContractEndDealWay.ContractEndDealWay_3.value())
                        || record.getDealWay().equals(ContractEndDealWay.ContractEndDealWay_4.value())
                        || record.getDealWay().equals(ContractEndDealWay.ContractEndDealWay_5.value())
                ) { //结束 则把合同状态改为结束
            LeaseContract leaseContract = new LeaseContract();
            leaseContract.setId(record.getContractId());
            leaseContract.setStatus(ContractStatus.STATUS_2);
            leaseContract.setDealStatus(ContractEndDealWay.getDealStatusValue(record.getDealWay()));
            leaseContractService.updateDealStatus(leaseContract);
        } else {
            LeaseContract leaseContract = new LeaseContract();
            leaseContract.setId(record.getContractId());
            leaseContract.setDealStatus(ContractEndDealWay.getDealStatusValue(record.getDealWay()));
            leaseContractService.updateDealStatusAndStatusBack(leaseContract);
        }
        //修改合同状态

        //修改车辆状态
        LeaseCar leaseCar = new LeaseCar();
        leaseCar.setDealStatus(ContractEndDealWay.getDealStatusValue(record.getDealWay()));
        leaseCar.setCarCondition(CarCondition.CarCondition_2.value());
        leaseCarService.updateDealStatus(leaseCar);

        return row;
    }

    public int updateByPrimaryKey(LeaseContractDealEnd record) throws GMException {
        int row = leaseContractDealEndService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractDealEnd selectByPrimaryKey(Long id) throws GMException {
        LeaseContractDealEnd leaseContractDealEnd = leaseContractDealEndService.selectByPrimaryKey(id);
        return leaseContractDealEnd;
    }

    public int insertList(List<LeaseContractDealEnd> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractDealEnd> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractDealEnd> page = leaseContractDealEndService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseContractDealEnd> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractDealEnd> leaseContractDealEndList = leaseContractDealEndService.findAll(paramsMap);
        return leaseContractDealEndList;
    }

    @Override
    public LeaseContractDealEnd findByContractId(Long contractId) {
        LeaseContractDealEnd leaseContractDealEnd = leaseContractDealEndService.findByContractId(contractId);
        return leaseContractDealEnd;
    }
}
