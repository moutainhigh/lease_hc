package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseContractLinkRepaymentMapper;
import com.hc.lease.order.model.LeaseContractLinkRepayment;
import com.hc.lease.order.model.LeaseSchemeRepayment;
import com.hc.lease.order.service.api.LeaseContractLinkRepaymentService;
import com.hc.lease.order.vo.FindLinkVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同-挂靠还款明细，挂靠还款时间跟月租还款时间相同，首次操作还款则添加一条记录，即一个扣款日一条记录，类似还款计划明细，假如没有操作扣款而被检测到过期则自动添加一条过期月份的记录ServiceImpl
 *
 * @author Tong
 * @version 2017-08-24
 */
@Service("leaseContractLinkRepaymentService")
public class LeaseContractLinkRepaymentServiceImpl implements LeaseContractLinkRepaymentService {

    @Autowired
    private LeaseContractLinkRepaymentMapper leaseContractLinkRepaymentMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractLinkRepaymentMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractLinkRepaymentMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractLinkRepayment insert(LeaseContractLinkRepayment leaseContractLinkRepayment) throws GMException {
        leaseContractLinkRepayment.setCreateTime(DateTime.now().toDate());
        leaseContractLinkRepayment.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractLinkRepaymentMapper.insert(leaseContractLinkRepayment);
        return leaseContractLinkRepayment;
    }

    public LeaseContractLinkRepayment insertSelective(LeaseContractLinkRepayment leaseContractLinkRepayment) throws GMException {
        leaseContractLinkRepayment.setCreateTime(DateTime.now().toDate());
        leaseContractLinkRepayment.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractLinkRepaymentMapper.insertSelective(leaseContractLinkRepayment);
        return leaseContractLinkRepayment;
    }

    public int insertList(List<LeaseContractLinkRepayment> list) throws GMException {
        int row = leaseContractLinkRepaymentMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractLinkRepayment leaseContractLinkRepayment) throws GMException {
        leaseContractLinkRepayment.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractLinkRepaymentMapper.updateByPrimaryKeySelective(leaseContractLinkRepayment);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractLinkRepayment leaseContractLinkRepayment) throws GMException {
        leaseContractLinkRepayment.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractLinkRepaymentMapper.updateByPrimaryKey(leaseContractLinkRepayment);
        return row;
    }

    public LeaseContractLinkRepayment selectByPrimaryKey(Long id) throws GMException {
        LeaseContractLinkRepayment leaseContractLinkRepayment = leaseContractLinkRepaymentMapper.selectByPrimaryKey(id);
        return leaseContractLinkRepayment;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractLinkRepayment> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractLinkRepayment> leaseContractLinkRepaymentList = leaseContractLinkRepaymentMapper.findPage(paramsMap);
        PageInfo<LeaseContractLinkRepayment> page = new PageInfo<LeaseContractLinkRepayment>(leaseContractLinkRepaymentList);
        return page;
    }

    public List<LeaseContractLinkRepayment> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractLinkRepayment> leaseContractLinkRepaymentList = leaseContractLinkRepaymentMapper.findAll(paramsMap);
        return leaseContractLinkRepaymentList;
    }

    /**
     * 融租合同的 当月挂靠、过期未付款的挂靠
     *
     * @param paramsMap
     * @return
     */
    public List<FindLinkVo> findLink(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<FindLinkVo> leaseContractLinkRepaymentList = leaseContractLinkRepaymentMapper.findLink(paramsMap);
        return leaseContractLinkRepaymentList;
    }

    /**
     * 融租合同的 当月挂靠、过期未付款的挂靠
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseContractLinkRepayment> findOverdue(Map<String, Object> paramsMap) {
        List<LeaseContractLinkRepayment> leaseContractLinkRepaymentList = leaseContractLinkRepaymentMapper.findOverdue(paramsMap);
        return leaseContractLinkRepaymentList;
    }

    /**
     * 检测 融租合同的 已逾期的挂靠
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseContractLinkRepayment> checkOverdue(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<LeaseContractLinkRepayment> leaseContractLinkRepaymentList = leaseContractLinkRepaymentMapper.checkOverdue(paramsMap);
        return leaseContractLinkRepaymentList;
    }

    /**
     * 批量修改
     *
     * @param leaseSchemeRepaymentList
     */
    public void batchUpdate(List<LeaseContractLinkRepayment> leaseSchemeRepaymentList) {
        leaseContractLinkRepaymentMapper.batchUpdate(leaseSchemeRepaymentList);
    }
}
