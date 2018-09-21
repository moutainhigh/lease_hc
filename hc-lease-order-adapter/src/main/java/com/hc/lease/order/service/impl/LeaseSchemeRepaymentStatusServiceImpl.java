package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseSchemeRepaymentStatusMapper;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import com.hc.lease.order.vo.FindByPlateNumberAndRepaymentDateVo;
import com.hc.lease.order.vo.FindQueryTradeNewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 月供的状态、滞纳金的状态、挂靠费的状态、提前还款的状态、尾付的状态，一个合同的某一期对应的这几种款项只有一条记录，可能每一种款项会操作多次扣款，每次操作的状态都更新ServiceImpl
 *
 * @author Tong
 * @version 2017-08-17
 */
@Service("leaseSchemeRepaymentStatusService")
public class LeaseSchemeRepaymentStatusServiceImpl implements LeaseSchemeRepaymentStatusService {

    @Autowired
    private LeaseSchemeRepaymentStatusMapper leaseSchemeRepaymentStatusMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeRepaymentStatusMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemeRepaymentStatusMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeRepaymentStatus insert(LeaseSchemeRepaymentStatus record) throws GMException {
        int row = leaseSchemeRepaymentStatusMapper.insert(record);
        return record;
    }

    public LeaseSchemeRepaymentStatus insertSelective(LeaseSchemeRepaymentStatus record) throws GMException {
        int row = leaseSchemeRepaymentStatusMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSchemeRepaymentStatus> list) throws GMException {
        int row = leaseSchemeRepaymentStatusMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeRepaymentStatus record) throws GMException {
        int row = leaseSchemeRepaymentStatusMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeRepaymentStatus record) throws GMException {
        int row = leaseSchemeRepaymentStatusMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemeRepaymentStatus selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusMapper.selectByPrimaryKey(id);
        return leaseSchemeRepaymentStatus;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseSchemeRepaymentStatus> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeRepaymentStatus> leaseSchemeRepaymentStatusList = leaseSchemeRepaymentStatusMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeRepaymentStatus> page = new PageInfo<LeaseSchemeRepaymentStatus>(leaseSchemeRepaymentStatusList);
        return page;
    }

    public List<LeaseSchemeRepaymentStatus> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepaymentStatus> leaseSchemeRepaymentStatusList = leaseSchemeRepaymentStatusMapper.findAll(paramsMap);
        return leaseSchemeRepaymentStatusList;
    }

    /**
     * 查询某个合同某一期的某种款项的数据
     *
     * @param paramsMap
     * @return
     */
    public LeaseSchemeRepaymentStatus findByType(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusMapper.findByType(paramsMap);
        return leaseSchemeRepaymentStatus;
    }

    /**
     * 需要轮询通联 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @return
     */
    public List<FindQueryTradeNewVo> findQueryTradeNew(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<FindQueryTradeNewVo> leaseAllinpayLogList = leaseSchemeRepaymentStatusMapper.findQueryTradeNew(paramsMap);
        return leaseAllinpayLogList;
    }

    /**
     * 批量更新
     *
     * @param list
     * @return
     */
    public int batchUpdateByContract(List<LeaseSchemeRepaymentStatus> list, DubboTreaceParames dubboTreaceParames) {
        int row = leaseSchemeRepaymentStatusMapper.batchUpdateByContract(list);
        return row;
    }

    public int deleteByContractId(Long contractId) {
        int row = leaseSchemeRepaymentStatusMapper.deleteByContractId(contractId);
        return row;
    }

    /**
     * 查询月供、滞纳金的支付状态
     *
     * @param paramsMap
     * @return
     */
    public LeaseSchemeRepaymentStatus selectByContract(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusMapper.selectByContract(paramsMap);
        return leaseSchemeRepaymentStatus;
    }

    /**
     * 合同是否还款完毕
     *
     * @param paramsMap
     * @return
     */
    public Boolean findByContractidAndStatus(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        Boolean contractidAndStatus = leaseSchemeRepaymentStatusMapper.findByContractidAndStatus(paramsMap);
        return contractidAndStatus;
    }

    public void updateByRepaymentId(LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus) {
        leaseSchemeRepaymentStatusMapper.updateByRepaymentId(leaseSchemeRepaymentStatus);
    }

    public boolean updateByContractIdAndType(Map<String, Object> params) {
        return leaseSchemeRepaymentStatusMapper.updateByContractIdAndType(params);

    }

    /**
     * 定时轮询通联超额拆分交易结果 批量更新
     *
     * @param list
     * @return
     */
    @Override
    public int batchUpdateBySplitCheck(List<LeaseSchemeRepaymentStatus> list) {
        return leaseSchemeRepaymentStatusMapper.batchUpdateBySplitCheck(list);
    }

    /**
     * 车牌号和扣款日期查询还款计划
     *
     * @param paramsMap
     * @return
     */
    @Override
    public FindByPlateNumberAndRepaymentDateVo findByPlateNumberAndRepaymentDate(Map<String, Object> paramsMap) {
        return leaseSchemeRepaymentStatusMapper.findByPlateNumberAndRepaymentDate(paramsMap);
    }

    /**
     * 备份数据
     *
     * @param paramsMap
     * @return
     */
    @Override
    public int backData(Map<String, Object> paramsMap) {
        return leaseSchemeRepaymentStatusMapper.backData(paramsMap);
    }

    /**
     * 合同是否存在还款中的还款计划
     *
     * @param paramsMap
     * @return
     */
    @Override
    public Boolean findContractPayStatusByContractId(Map<String, Object> paramsMap) {
        return leaseSchemeRepaymentStatusMapper.findContractPayStatusByContractId(paramsMap);
    }
}
