package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.common.core.constant.DictType;
import com.hc.lease.common.core.constant.IncomeExpeSource;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractCarScrapAdapter;
import com.hc.lease.order.model.LeaseContractCarScrap;
import com.hc.lease.order.model.LeaseContractIncomeExpe;
import com.hc.lease.order.service.api.LeaseContractCarScrapService;
import com.hc.lease.order.service.api.LeaseContractIncomeExpeService;
import com.hc.lease.order.service.api.LeaseContractService;
import com.hc.lease.order.vo.CarManagerDealFindContractVo;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-报废AdapterImpl
 *
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractCarScrapAdapter")
public class LeaseContractCarScrapAdapterImpl implements LeaseContractCarScrapAdapter {

    @Autowired
    private LeaseContractCarScrapService leaseContractCarScrapService;

    @Autowired
    private LeaseContractService leaseContractService;

    @Autowired
    private LeaseDictService leaseDictService;

    @Autowired
    private LeaseContractIncomeExpeService leaseContractIncomeExpeService;

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
        int row = leaseContractCarScrapService.deleteByPrimaryKey(id);
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
        int row = leaseContractCarScrapService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractCarScrap record) throws GMException {
        record = leaseContractCarScrapService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractCarScrap record) throws GMException {
        record = leaseContractCarScrapService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractCarScrap record) throws GMException {

        Integer maxNumber = leaseContractCarScrapService.findMaxDualNumber(null);
        if (maxNumber == null) {
            record.setDualNumber(1001);
        } else {
            record.setDualNumber(maxNumber + 1);
        }

        int row = leaseContractCarScrapService.updateByPrimaryKeySelective(record);
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("contractId", record.getContractId());
        paramsMap.put("source", IncomeExpeSource.SCRAP.value());
        paramsMap.put("sourceId", record.getId());
        leaseContractIncomeExpeService.deleteByContractId(paramsMap);
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = record.getIncomeExpeList();
        if (leaseContractIncomeExpeList != null && leaseContractIncomeExpeList.size() > 0) {
            LeaseContractIncomeExpe leaseContractIncomeExpe = null;
            for (int i = 0; i < leaseContractIncomeExpeList.size(); i++) {
                leaseContractIncomeExpe = leaseContractIncomeExpeList.get(i);
                leaseContractIncomeExpe.setSource(IncomeExpeSource.SCRAP.value());
                leaseContractIncomeExpe.setSourceId(record.getId());
            }
            leaseContractIncomeExpeService.insertList(leaseContractIncomeExpeList);
        }

        return row;
    }

    public int updateByPrimaryKey(LeaseContractCarScrap record) throws GMException {
        int row = leaseContractCarScrapService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractCarScrap selectByPrimaryKey(Long id) throws GMException {
        LeaseContractCarScrap leaseContractCarScrap = leaseContractCarScrapService.selectByPrimaryKey(id);
        return leaseContractCarScrap;
    }

    public int insertList(List<LeaseContractCarScrap> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractCarScrap> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractCarScrap> page = leaseContractCarScrapService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseContractCarScrap> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractCarScrap> leaseContractCarScrapList = leaseContractCarScrapService.findAll(paramsMap);
        return leaseContractCarScrapList;
    }

    @Override
    public int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException {
        int dualNumber = leaseContractCarScrapService.findMaxDualNumber(paramsMap);
        return dualNumber;
    }
}
