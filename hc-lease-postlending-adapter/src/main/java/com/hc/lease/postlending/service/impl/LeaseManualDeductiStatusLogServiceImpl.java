package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseManualDeductiStatusLogMapper;
import com.hc.lease.postlending.model.LeaseManualDeductiStatusLog;
import com.hc.lease.postlending.service.api.LeaseManualDeductiStatusLogService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 手动扣款支付状态流水ServiceImpl
 *
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductiStatusLogService")
public class LeaseManualDeductiStatusLogServiceImpl implements LeaseManualDeductiStatusLogService {

    @Autowired
    private LeaseManualDeductiStatusLogMapper leaseManualDeductiStatusLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseManualDeductiStatusLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseManualDeductiStatusLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseManualDeductiStatusLog insert(LeaseManualDeductiStatusLog leaseManualDeductiStatusLog) throws GMException {
        leaseManualDeductiStatusLog.setCreateTime(DateTime.now().toDate());
        int row = leaseManualDeductiStatusLogMapper.insert(leaseManualDeductiStatusLog);
        return leaseManualDeductiStatusLog;
    }

    public LeaseManualDeductiStatusLog insertSelective(LeaseManualDeductiStatusLog leaseManualDeductiStatusLog) throws GMException {
        leaseManualDeductiStatusLog.setCreateTime(DateTime.now().toDate());
        int row = leaseManualDeductiStatusLogMapper.insertSelective(leaseManualDeductiStatusLog);
        return leaseManualDeductiStatusLog;
    }

    public int insertList(List<LeaseManualDeductiStatusLog> list) throws GMException {
        int row = leaseManualDeductiStatusLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductiStatusLog leaseManualDeductiStatusLog) throws GMException {
        int row = leaseManualDeductiStatusLogMapper.updateByPrimaryKeySelective(leaseManualDeductiStatusLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductiStatusLog leaseManualDeductiStatusLog) throws GMException {
        int row = leaseManualDeductiStatusLogMapper.updateByPrimaryKey(leaseManualDeductiStatusLog);
        return row;
    }

    public LeaseManualDeductiStatusLog selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductiStatusLog leaseManualDeductiStatusLog = leaseManualDeductiStatusLogMapper.selectByPrimaryKey(id);
        return leaseManualDeductiStatusLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseManualDeductiStatusLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseManualDeductiStatusLog> leaseManualDeductiStatusLogList = leaseManualDeductiStatusLogMapper.findPage(paramsMap);
        PageInfo<LeaseManualDeductiStatusLog> page = new PageInfo<LeaseManualDeductiStatusLog>(leaseManualDeductiStatusLogList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseManualDeductiStatusLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductiStatusLog> leaseManualDeductiStatusLogList = leaseManualDeductiStatusLogMapper.findAll(paramsMap);
        return leaseManualDeductiStatusLogList;
    }

}
