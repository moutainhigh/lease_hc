package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseContractAdvanceMapper;
import com.hc.lease.order.model.LeaseContractAdvance;
import com.hc.lease.order.service.api.LeaseContractAdvanceService;
import com.hc.lease.order.vo.FindAdvanceVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同 提前还款，融租合同贷后管理登记为提前还款，预约登记ServiceImpl
 *
 * @author Tong
 * @version 2017-08-25
 */
@Service("leaseContractAdvanceService")
public class LeaseContractAdvanceServiceImpl implements LeaseContractAdvanceService {

    @Autowired
    private LeaseContractAdvanceMapper leaseContractAdvanceMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractAdvanceMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractAdvanceMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractAdvance insert(LeaseContractAdvance leaseContractAdvance) throws GMException {
        leaseContractAdvance.setCreateTime(DateTime.now().toDate());
        leaseContractAdvance.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractAdvanceMapper.insert(leaseContractAdvance);
        return leaseContractAdvance;
    }

    public LeaseContractAdvance insertSelective(LeaseContractAdvance leaseContractAdvance) throws GMException {
        leaseContractAdvance.setCreateTime(DateTime.now().toDate());
        leaseContractAdvance.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractAdvanceMapper.insertSelective(leaseContractAdvance);
        return leaseContractAdvance;
    }

    public int insertList(List<LeaseContractAdvance> list) throws GMException {
        int row = leaseContractAdvanceMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractAdvance leaseContractAdvance) throws GMException {
        leaseContractAdvance.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractAdvanceMapper.updateByPrimaryKeySelective(leaseContractAdvance);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractAdvance leaseContractAdvance) throws GMException {
        leaseContractAdvance.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractAdvanceMapper.updateByPrimaryKey(leaseContractAdvance);
        return row;
    }

    public LeaseContractAdvance selectByPrimaryKey(Long id) throws GMException {
        LeaseContractAdvance leaseContractAdvance = leaseContractAdvanceMapper.selectByPrimaryKey(id);
        return leaseContractAdvance;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractAdvance> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractAdvance> leaseContractAdvanceList = leaseContractAdvanceMapper.findPage(paramsMap);
        PageInfo<LeaseContractAdvance> page = new PageInfo<LeaseContractAdvance>(leaseContractAdvanceList);
        return page;
    }

    public List<LeaseContractAdvance> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractAdvance> leaseContractAdvanceList = leaseContractAdvanceMapper.findAll(paramsMap);
        return leaseContractAdvanceList;
    }

    /**
     * 融租合同的提前还款
     *
     * @param paramsMap
     * @return
     */
    public List<FindAdvanceVo> findAdvance(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<FindAdvanceVo> leaseContractAdvanceList = leaseContractAdvanceMapper.findAdvance(paramsMap);
        return leaseContractAdvanceList;
    }

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    public int batchUpdate(List<LeaseContractAdvance> list, DubboTreaceParames dubboTreaceParames) {
        leaseContractAdvanceMapper.batchUpdate(list);
        return 1;
    }
}
