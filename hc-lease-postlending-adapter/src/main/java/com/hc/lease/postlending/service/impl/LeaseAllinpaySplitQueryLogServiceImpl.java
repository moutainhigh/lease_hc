package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseAllinpaySplitQueryLogMapper;
import com.hc.lease.postlending.model.LeaseAllinpaySplitQueryLog;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitQueryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 通联轮询流水ServiceImpl
 *
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitQueryLogService")
public class LeaseAllinpaySplitQueryLogServiceImpl implements LeaseAllinpaySplitQueryLogService {

    @Autowired
    private LeaseAllinpaySplitQueryLogMapper leaseAllinpaySplitQueryLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpaySplitQueryLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitQueryLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpaySplitQueryLog insert(LeaseAllinpaySplitQueryLog leaseAllinpaySplitQueryLog) throws GMException {
        int row = leaseAllinpaySplitQueryLogMapper.insert(leaseAllinpaySplitQueryLog);
        return leaseAllinpaySplitQueryLog;
    }

    public LeaseAllinpaySplitQueryLog insertSelective(LeaseAllinpaySplitQueryLog leaseAllinpaySplitQueryLog) throws GMException {
        int row = leaseAllinpaySplitQueryLogMapper.insertSelective(leaseAllinpaySplitQueryLog);
        return leaseAllinpaySplitQueryLog;
    }

    public int insertList(List<LeaseAllinpaySplitQueryLog> list) throws GMException {
        int row = leaseAllinpaySplitQueryLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitQueryLog leaseAllinpaySplitQueryLog) throws GMException {
        int row = leaseAllinpaySplitQueryLogMapper.updateByPrimaryKeySelective(leaseAllinpaySplitQueryLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitQueryLog leaseAllinpaySplitQueryLog) throws GMException {
        int row = leaseAllinpaySplitQueryLogMapper.updateByPrimaryKey(leaseAllinpaySplitQueryLog);
        return row;
    }

    public LeaseAllinpaySplitQueryLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitQueryLog leaseAllinpaySplitQueryLog = leaseAllinpaySplitQueryLogMapper.selectByPrimaryKey(id);
        return leaseAllinpaySplitQueryLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplitQueryLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpaySplitQueryLog> leaseAllinpaySplitQueryLogList = leaseAllinpaySplitQueryLogMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpaySplitQueryLog> page = new PageInfo<LeaseAllinpaySplitQueryLog>(leaseAllinpaySplitQueryLogList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplitQueryLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitQueryLog> leaseAllinpaySplitQueryLogList = leaseAllinpaySplitQueryLogMapper.findAll(paramsMap);
        return leaseAllinpaySplitQueryLogList;
    }

    @Override
    public List<LeaseAllinpaySplitQueryLog> selectByAllinpaySplitLogId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<LeaseAllinpaySplitQueryLog> leaseAllinpaySplitQueryLogList = leaseAllinpaySplitQueryLogMapper.selectByAllinpaySplitLogId(paramsMap);
        return leaseAllinpaySplitQueryLogList;
    }

    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseAllinpaySplitQueryLogMapper.updateRepaymentId(paramsMap);
        return row;
    }
}
