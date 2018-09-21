package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseManualDeductioQueryLogMapper;
import com.hc.lease.postlending.model.LeaseManualDeductioQueryLog;
import com.hc.lease.postlending.service.api.LeaseManualDeductioQueryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 手动扣款通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条支付流水都对应一条轮询流水ServiceImpl
 *
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductioQueryLogService")
public class LeaseManualDeductioQueryLogServiceImpl implements LeaseManualDeductioQueryLogService {

    @Autowired
    private LeaseManualDeductioQueryLogMapper leaseManualDeductioQueryLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseManualDeductioQueryLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseManualDeductioQueryLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseManualDeductioQueryLog insert(LeaseManualDeductioQueryLog leaseManualDeductioQueryLog) throws GMException {
        int row = leaseManualDeductioQueryLogMapper.insert(leaseManualDeductioQueryLog);
        return leaseManualDeductioQueryLog;
    }

    public LeaseManualDeductioQueryLog insertSelective(LeaseManualDeductioQueryLog leaseManualDeductioQueryLog) throws GMException {
        int row = leaseManualDeductioQueryLogMapper.insertSelective(leaseManualDeductioQueryLog);
        return leaseManualDeductioQueryLog;
    }

    public int insertList(List<LeaseManualDeductioQueryLog> list) throws GMException {
        int row = leaseManualDeductioQueryLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductioQueryLog leaseManualDeductioQueryLog) throws GMException {
        int row = leaseManualDeductioQueryLogMapper.updateByPrimaryKeySelective(leaseManualDeductioQueryLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductioQueryLog leaseManualDeductioQueryLog) throws GMException {
        int row = leaseManualDeductioQueryLogMapper.updateByPrimaryKey(leaseManualDeductioQueryLog);
        return row;
    }

    public LeaseManualDeductioQueryLog selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductioQueryLog leaseManualDeductioQueryLog = leaseManualDeductioQueryLogMapper.selectByPrimaryKey(id);
        return leaseManualDeductioQueryLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseManualDeductioQueryLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseManualDeductioQueryLog> leaseManualDeductioQueryLogList = leaseManualDeductioQueryLogMapper.findPage(paramsMap);
        PageInfo<LeaseManualDeductioQueryLog> page = new PageInfo<LeaseManualDeductioQueryLog>(leaseManualDeductioQueryLogList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseManualDeductioQueryLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductioQueryLog> leaseManualDeductioQueryLogList = leaseManualDeductioQueryLogMapper.findAll(paramsMap);
        return leaseManualDeductioQueryLogList;
    }

}
