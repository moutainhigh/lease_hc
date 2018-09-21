package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseAllinpayQueryLogMapper;
import com.hc.lease.postlending.model.LeaseAllinpayQueryLog;
import com.hc.lease.postlending.service.api.LeaseAllinpayQueryLogService;
import com.hc.lease.postlending.vo.FindSuccessNoSendSmsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联轮询流水，通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条代收流水都对应一条轮询流水ServiceImpl
 *
 * @author Tong
 * @version 2017-08-31
 */
@Service("leaseAllinpayQueryLogService")
public class LeaseAllinpayQueryLogServiceImpl implements LeaseAllinpayQueryLogService {

    @Autowired
    private LeaseAllinpayQueryLogMapper leaseAllinpayQueryLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpayQueryLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpayQueryLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpayQueryLog insert(LeaseAllinpayQueryLog leaseAllinpayQueryLog) throws GMException {
        int row = leaseAllinpayQueryLogMapper.insert(leaseAllinpayQueryLog);
        return leaseAllinpayQueryLog;
    }

    public LeaseAllinpayQueryLog insertSelective(LeaseAllinpayQueryLog leaseAllinpayQueryLog) throws GMException {
        int row = leaseAllinpayQueryLogMapper.insertSelective(leaseAllinpayQueryLog);
        return leaseAllinpayQueryLog;
    }

    public int insertList(List<LeaseAllinpayQueryLog> list) throws GMException {
        int row = leaseAllinpayQueryLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayQueryLog leaseAllinpayQueryLog) throws GMException {
        int row = leaseAllinpayQueryLogMapper.updateByPrimaryKeySelective(leaseAllinpayQueryLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayQueryLog leaseAllinpayQueryLog) throws GMException {
        int row = leaseAllinpayQueryLogMapper.updateByPrimaryKey(leaseAllinpayQueryLog);
        return row;
    }

    public LeaseAllinpayQueryLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayQueryLog leaseAllinpayQueryLog = leaseAllinpayQueryLogMapper.selectByPrimaryKey(id);
        return leaseAllinpayQueryLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpayQueryLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpayQueryLog> leaseAllinpayQueryLogList = leaseAllinpayQueryLogMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpayQueryLog> page = new PageInfo<LeaseAllinpayQueryLog>(leaseAllinpayQueryLogList);
        return page;
    }

    public List<LeaseAllinpayQueryLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayQueryLog> leaseAllinpayQueryLogList = leaseAllinpayQueryLogMapper.findAll(paramsMap);
        return leaseAllinpayQueryLogList;
    }

    /**
     * 未发送短信提醒的 通联轮询流水
     *
     * @param paramsMap
     * @return
     */
    public List<FindSuccessNoSendSmsVo> findSuccessNoSendSms(Map<String, Object> paramsMap) {
        List<FindSuccessNoSendSmsVo> leaseAllinpayQueryLogList = leaseAllinpayQueryLogMapper.findSuccessNoSendSms(paramsMap);
        return leaseAllinpayQueryLogList;
    }

    public List<LeaseAllinpayQueryLog> selectByAllinpayLogId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<LeaseAllinpayQueryLog> leaseAllinpayQueryLogList = leaseAllinpayQueryLogMapper.selectByAllinpayLogId(paramsMap);
        return leaseAllinpayQueryLogList;
    }
}
