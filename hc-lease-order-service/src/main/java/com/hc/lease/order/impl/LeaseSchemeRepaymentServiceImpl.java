package com.hc.lease.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseSchemeRepaymentMapper;
import com.hc.lease.order.model.LeaseSchemeRepayment;
import com.hc.lease.order.service.LeaseSchemeRepaymentService;
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
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
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

    public List<LeaseSchemeRepayment> selectByIsSendPayment(Integer isSendPayment) {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.selectByIsSendPayment(isSendPayment);
        return leaseSchemeRepaymentList;
    }

    /**
     * 月供的还款记录
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseSchemeRepayment> findIsMonthLog(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findIsMonthLog(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 已逾期的还款记录
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseSchemeRepayment> findIsOverdueLog(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findIsOverdueLog(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * @param leaseSchemeRepaymentList
     */
    public void batchUpdate(List<LeaseSchemeRepayment> leaseSchemeRepaymentList) {
        leaseSchemeRepaymentMapper.batchUpdate(leaseSchemeRepaymentList);
    }

    /**
     * 检测是否是月供
     *
     * @param paramsMap
     * @return
     */
    public LeaseSchemeRepayment checkIsMonth(Map<String, Object> paramsMap) {
        LeaseSchemeRepayment leaseSchemeRepayment = leaseSchemeRepaymentMapper.checkIsMonth(paramsMap);
        return leaseSchemeRepayment;
    }

    /**
     * 检测是否是逾期
     *
     * @param paramsMap
     * @return
     */
    public LeaseSchemeRepayment checkIsOverdue(Map<String, Object> paramsMap) {
        LeaseSchemeRepayment leaseSchemeRepayment = leaseSchemeRepaymentMapper.checkIsOverdue(paramsMap);
        return leaseSchemeRepayment;
    }

    /**
     * @param paramsMap
     * @return
     */
    public LeaseSchemeRepayment selectContract(Map<String, Object> paramsMap) {
        LeaseSchemeRepayment leaseSchemeRepayment = leaseSchemeRepaymentMapper.selectContract(paramsMap);
        return leaseSchemeRepayment;
    }

    public List<Map<String, Object>> findAllMonth(Map<String, Object> paramsMap) throws GMException {
        List<Map<String, Object>> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.findAllMonth(paramsMap);
        return leaseSchemeRepaymentList;
    }

    public Map<String, Object> findAllMonthStatistics(Map<String, Object> paramsMap) {
        Map<String, Object> leaseSchemeRepayment = leaseSchemeRepaymentMapper.findAllMonthStatistics(paramsMap);
        return leaseSchemeRepayment;
    }

    public List<LeaseSchemeRepayment> findAllMonthStatisticsByCity(Map<String, Object> paramsMap) {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList  = leaseSchemeRepaymentMapper.findAllMonthStatisticsByCity(paramsMap);
        return leaseSchemeRepaymentList;
    }

    /**
     * 查出 批量扣款 的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseSchemeRepayment> batchCheckIsMonth(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentMapper.batchCheckIsMonth(paramsMap);
        return leaseSchemeRepaymentList;
    }
}
