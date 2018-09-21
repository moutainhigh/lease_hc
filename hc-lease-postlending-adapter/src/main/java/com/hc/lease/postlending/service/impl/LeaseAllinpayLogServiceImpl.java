package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseAllinpayLogMapper;
import com.hc.lease.postlending.model.LeaseAllinpayLog;
import com.hc.lease.postlending.service.api.LeaseAllinpayLogService;
import com.hc.lease.postlending.vo.ContractAllinpayLogVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联代收流水ServiceImpl
 *
 * @author Tong
 * @version 2017-06-09
 */
@Service("leaseAllinpayLogService")
public class LeaseAllinpayLogServiceImpl implements LeaseAllinpayLogService {

    @Autowired
    private LeaseAllinpayLogMapper leaseAllinpayLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpayLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpayLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpayLog insert(LeaseAllinpayLog record) throws GMException {
        int row = leaseAllinpayLogMapper.insert(record);
        return record;
    }

    public LeaseAllinpayLog insertSelective(LeaseAllinpayLog record) throws GMException {
        int row = leaseAllinpayLogMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseAllinpayLog> list) throws GMException {
        int row = leaseAllinpayLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayLog record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayLogMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayLog record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayLogMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayLog leaseAllinpayLog = leaseAllinpayLogMapper.selectByPrimaryKey(id);
        return leaseAllinpayLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpayLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpayLog> leaseAllinpayLogList = leaseAllinpayLogMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpayLog> page = new PageInfo<LeaseAllinpayLog>(leaseAllinpayLogList);
        return page;
    }

    /**
     * 还款历史/合同还款明细
     *
     * @return
     */
    public List<ContractAllinpayLogVo> findByContractId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<ContractAllinpayLogVo> leaseAllinpayLogList = leaseAllinpayLogMapper.findByContractId(paramsMap);
        return leaseAllinpayLogList;
    }

    public List<LeaseAllinpayLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayLog> leaseAllinpayLogList = leaseAllinpayLogMapper.findAll(paramsMap);
        return leaseAllinpayLogList;
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态
     *
     * @param leaseAllinpayLog
     * @return
     * @throws GMException
     */
    public int updateByReqSn(LeaseAllinpayLog leaseAllinpayLog) throws GMException {
        leaseAllinpayLog.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayLogMapper.updateByReqSn(leaseAllinpayLog);
        return row;
    }

    /**
     * 通联日志
     * 单笔
     * 查看明细
     * 因为每笔款不是即时出结果，所以代收流水的状态不是最终状态，轮询流水的状态是最终状态
     *
     * @param paramsMap
     * @return
     */
    public List<ContractAllinpayLogVo> paymentLogDetail(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<ContractAllinpayLogVo> leaseAllinpayLogList = leaseAllinpayLogMapper.paymentLogDetail(paramsMap);
        return leaseAllinpayLogList;
    }

    /**
     * @param paramsMap
     * @return
     */
    public LeaseAllinpayLog findByReqSn(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        LeaseAllinpayLog leaseAllinpayLog = leaseAllinpayLogMapper.findByReqSn(paramsMap);
        return leaseAllinpayLog;
    }

    /**
     * 批扣数据用城市统计
     *
     * @param paramsMap
     * @return
     */
    public List<Map<String, Object>> allinpayBatchStatisticsByCity(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> leaseAllinpayLogList = leaseAllinpayLogMapper.allinpayBatchStatisticsByCity(paramsMap);
        return leaseAllinpayLogList;
    }

    /**
     * 查看统计/总计
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> allinpayBatchStatistics(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        Map<String, Object> leaseAllinpayLog = leaseAllinpayLogMapper.allinpayBatchStatistics(paramsMap);
        return leaseAllinpayLog;
    }

    @Override
    public int deleteByContractId(Long contractId) {
        int row = leaseAllinpayLogMapper.deleteByContractId(contractId);
        return row;
    }

    /**
     * 修改合同 则 跟着更新 支付流水
     *
     * @param leaseAllinpayLog
     * @return
     * @throws GMException
     */
    @Override
    public int updateByContractId(LeaseAllinpayLog leaseAllinpayLog) throws GMException {
        int row = leaseAllinpayLogMapper.updateByContractId(leaseAllinpayLog);
        return row;
    }

    /**
     * 通联日志导出
     *
     * @param paramsMap
     * @return
     */
    public List<ContractAllinpayLogVo> exportAllinpayLog(Map<String, Object> paramsMap) {
        List<ContractAllinpayLogVo> contractAllinpayLogVos = leaseAllinpayLogMapper.exportAllinpayLog(paramsMap);
        return contractAllinpayLogVos;
    }
}
