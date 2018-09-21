package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseSchemeRepaymentStatusAdapter;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import com.hc.lease.order.vo.FindByPlateNumberAndRepaymentDateVo;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 月供的状态、滞纳金的状态、挂靠费的状态、提前还款的状态、尾付的状态，一个合同的某一期对应的这几种款项只有一条记录，可能每一种款项会操作多次扣款，每次操作的状态都更新AdapterImpl
 *
 * @author Tong
 * @version 2017-08-17
 */
@Service("leaseSchemeRepaymentStatusAdapter")
public class LeaseSchemeRepaymentStatusAdapterImpl implements LeaseSchemeRepaymentStatusAdapter {

    @Autowired
    private LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService;

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
        int row = leaseSchemeRepaymentStatusService.deleteByPrimaryKey(id);
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
        int row = leaseSchemeRepaymentStatusService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemeRepaymentStatus record) throws GMException {
        record = leaseSchemeRepaymentStatusService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemeRepaymentStatus record) throws GMException {
        record = leaseSchemeRepaymentStatusService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeRepaymentStatus record) throws GMException {
        int row = leaseSchemeRepaymentStatusService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeRepaymentStatus record) throws GMException {
        int row = leaseSchemeRepaymentStatusService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemeRepaymentStatus selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusService.selectByPrimaryKey(id);
        return leaseSchemeRepaymentStatus;
    }

    public int insertList(List<LeaseSchemeRepaymentStatus> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseSchemeRepaymentStatus> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemeRepaymentStatus> page = leaseSchemeRepaymentStatusService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseSchemeRepaymentStatus> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepaymentStatus> leaseSchemeRepaymentStatusList = leaseSchemeRepaymentStatusService.findAll(paramsMap);
        return leaseSchemeRepaymentStatusList;
    }

    /**
     * 查询某个合同某一期的某种款项的数据
     *
     * @param paramsMap
     * @return
     */
    public LeaseSchemeRepaymentStatus findByType(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusService.findByType(paramsMap, dubboTreaceParames);
        return leaseSchemeRepaymentStatus;
    }

    /**
     * 定时轮询通联超额拆分交易结果 批量更新
     *
     * @param list
     * @return
     */
    @Override
    public int batchUpdateBySplitCheck(List<LeaseSchemeRepaymentStatus> list) {
        return leaseSchemeRepaymentStatusService.batchUpdateBySplitCheck(list);
    }

    /**
     * 车牌号和扣款日期查询还款计划
     *
     * @param paramsMap
     * @return
     */
    @Override
    public FindByPlateNumberAndRepaymentDateVo findByPlateNumberAndRepaymentDate(Map<String, Object> paramsMap) {
        return leaseSchemeRepaymentStatusService.findByPlateNumberAndRepaymentDate(paramsMap);
    }

    /**
     * 备份数据
     *
     * @param paramsMap
     * @return
     */
    @Override
    public int backData(Map<String, Object> paramsMap) {
        return leaseSchemeRepaymentStatusService.backData(paramsMap);
    }

    /**
     * 合同是否存在还款中的还款计划
     *
     * @param paramsMap
     * @return
     */
    @Override
    public Boolean findContractPayStatusByContractId(Map<String, Object> paramsMap) {
        return leaseSchemeRepaymentStatusService.findContractPayStatusByContractId(paramsMap);
    }
}
