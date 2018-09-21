package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseSchemeRepaymentMapper;
import com.hc.lease.order.model.LeaseSchemeRepayment;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentService;
import com.hc.lease.order.vo.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租方案申请订单ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseSchemeRepaymentService")
public class LeaseSchemeRepaymentServiceImpl implements LeaseSchemeRepaymentService {

    @Autowired
    private LeaseSchemeRepaymentMapper leaseSchemeRepaymentMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeRepaymentMapper.deleteByPrimaryKey(id);
        return row;
    }

    public List<LeaseSchemeRepayment> selectByContractId(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.selectByContractId(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 租金支付表 / 融租合同-月租还款计划明细
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<SelectByContractIdVo> findByContractId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<SelectByContractIdVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findByContractId(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemeRepaymentMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeRepayment insert(LeaseSchemeRepayment record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentMapper.insert(record);
        return record;
    }

    public LeaseSchemeRepayment insertSelective(LeaseSchemeRepayment record) throws GMException {
        int row = leaseSchemeRepaymentMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSchemeRepayment> list) throws GMException {
        return 0;
    }


    public int updateByPrimaryKeySelective(LeaseSchemeRepayment record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeRepayment record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseSchemeRepayment selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeRepayment leaseSchemeRepayment = leaseSchemeRepaymentMapper.selectByPrimaryKey(id);
        return leaseSchemeRepayment;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseSchemeRepayment> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeRepayment> leaseSchemeOrderList = leaseSchemeRepaymentMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeRepayment> page = new PageInfo<LeaseSchemeRepayment>(leaseSchemeOrderList);
        return page;
    }

    public List<LeaseSchemeRepayment> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepayment> leaseSchemeOrderList = leaseSchemeRepaymentMapper.findAll(paramsMap);
        return leaseSchemeOrderList;
    }

    public void deleteByContractId(Long id) {
        leaseSchemeRepaymentMapper.deleteByContractId(id);
    }

   /* public List<LeaseSchemeRepayment> findBySchemeId(List<Long> ids) {
        List<LeaseSchemeRepayment> leaseSchemeOrderList=leaseSchemeRepaymentMapper.findBySchemeId(ids);

        return leaseSchemeOrderList;
    }*/

    /**
     * 融租合同的 当月月供、过期未付款的月供
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindMonthVo> findMonth(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindMonthVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findMonth(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 融租合同的 当月月供
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindMonthVo> findCurrentMonth(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindMonthVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findCurrentMonth(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 融租合同的 已逾期的还款记录
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindOverdueVo> findOverdue(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindOverdueVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findOverdue(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 融租合同的 当月已逾期的月租还款记录
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindOverdueVo> findCurrentOverdue(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindOverdueVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findCurrentOverdue(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 检测 融租合同的 已逾期，未扣款的月租
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseSchemeRepayment> checkOverdue(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.checkOverdue(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * @param leaseSchemeRepaymentList
     */
    public void batchUpdate(List<LeaseSchemeRepayment> leaseSchemeRepaymentList, DubboTreaceParames dubboTreaceParames) {
        leaseSchemeRepaymentMapper.batchUpdate(leaseSchemeRepaymentList);
    }

    /**
     * @param paramsMap
     * @return
     */
    public LeaseSchemeRepayment selectContract(Map<String, Object> paramsMap) {
        LeaseSchemeRepayment leaseSchemeRepayment = leaseSchemeRepaymentMapper.selectContract(paramsMap);
        return leaseSchemeRepayment;
    }

    /**
     * 通联批扣 查询所有月供/挂靠/统计数据
     *
     * @param paramsMap\
     * @return
     * @throws GMException
     */
    public PageInfo<BatchPostlendingPaymentVo> findBatchPostlendingPayment(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<BatchPostlendingPaymentVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findBatchPostlendingPayment(paramsMap);
        PageInfo<BatchPostlendingPaymentVo> page = new PageInfo<BatchPostlendingPaymentVo>(leaseSchemeRepaymentList);
        return page;
    }

    /**
     * 提交批扣查询需要处理的月供、滞纳金，查询扣款方式支持代扣的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<BatchPostlendingPaymentVo> findBatchPostlendingPaymentDual(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<BatchPostlendingPaymentVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findBatchPostlendingPaymentDual(paramsMap);
        return leaseSchemeRepaymentList;
    }

    public Map<String, Object> findAllMonthStatistics(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        Map<String, Object> leaseSchemeRepayment = leaseSchemeRepaymentMapper.findAllMonthStatistics(paramsMap);
        return leaseSchemeRepayment;
    }

    /**
     * 根据分公司统计所有月供 批量扣款
     *
     * @param paramsMap
     * @return
     */
    public List<FindAllMonthStaticsticsByCityVo> findAllMonthStatisticsByCity(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<FindAllMonthStaticsticsByCityVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findAllMonthStatisticsByCity(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 批量补录的数据/月供
     *
     * @param paramsMap
     * @return
     */
    public List<Map<String, Object>> findRepaymentExcept(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> leaseSchemeRepayment = leaseSchemeRepaymentMapper.findRepaymentExcept(paramsMap);
        return leaseSchemeRepayment;
    }

    /**
     * 查询某个扣款日的合同还款明细数据/月租、滞纳金、尾款
     *
     * @param list
     * @return
     * @throws GMException
     */
    public List<FindByRepaymentDateVo> findByRepaymentDate(List<String> list, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindByRepaymentDateVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findByRepaymentDate(list);
        return leaseSchemeRepaymentList;
    }

    /**
     * 查询还款明细数据/月租、滞纳金、挂靠费
     *
     * @param list
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public List<FindByRepaymentDateVo> findByRepaymentId(List<Long> list, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindByRepaymentDateVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findByRepaymentId(list);
        return leaseSchemeRepaymentList;
    }

    /**
     * 还款日7天前、3天前 的还款数据
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public List<LeaseSchemeRepayment> advanceSendRepaymentSms(Map<String, String> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.advanceSendRepaymentSms(paramsMap);
        return leaseSchemeRepaymentList;
    }

    public LeaseSchemeRepayment findByContractIdAndPeriod(Map<String, Object> params) {
        LeaseSchemeRepayment leaseSchemeRepayment = leaseSchemeRepaymentMapper.findByContractIdAndPeriod(params);
        return leaseSchemeRepayment;
    }

    public boolean updateTotalByContractId(Map<String, Object> params) {
        return leaseSchemeRepaymentMapper.updateTotalByContractId(params);
    }

    public List<BatchPostlendingPaymentVo> batchPostlendingPaymentNoPage(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<BatchPostlendingPaymentVo> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findBatchPostlendingPayment(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 备份数据
     *
     * @param paramsMap
     * @return
     */
    @Override
    public int backData(Map<String, Object> paramsMap) {
        int row = leaseSchemeRepaymentMapper.backData(paramsMap);
        return row;
    }
}
