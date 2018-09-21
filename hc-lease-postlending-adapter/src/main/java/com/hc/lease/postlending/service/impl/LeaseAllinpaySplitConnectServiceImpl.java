package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseAllinpaySplitConnectMapper;
import com.hc.lease.postlending.model.LeaseAllinpaySplitConnect;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitConnectService;
import com.hc.lease.postlending.vo.FindSplitCheckMapVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联支付（协议支付、代扣），已经超额的还款计划明细则被记录ServiceImpl
 *
 * @author Tong
 * @version 2018-06-25
 */
@Service("leaseAllinpaySplitConnectService")
public class LeaseAllinpaySplitConnectServiceImpl implements LeaseAllinpaySplitConnectService {

    @Autowired
    private LeaseAllinpaySplitConnectMapper leaseAllinpaySplitConnectMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpaySplitConnectMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitConnectMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpaySplitConnect insert(LeaseAllinpaySplitConnect leaseAllinpaySplitConnect) throws GMException {
        int row = leaseAllinpaySplitConnectMapper.insert(leaseAllinpaySplitConnect);
        return leaseAllinpaySplitConnect;
    }

    public LeaseAllinpaySplitConnect insertSelective(LeaseAllinpaySplitConnect leaseAllinpaySplitConnect) throws GMException {
        int row = leaseAllinpaySplitConnectMapper.insertSelective(leaseAllinpaySplitConnect);
        return leaseAllinpaySplitConnect;
    }

    public int insertList(List<LeaseAllinpaySplitConnect> list) throws GMException {
        int row = leaseAllinpaySplitConnectMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitConnect leaseAllinpaySplitConnect) throws GMException {
        leaseAllinpaySplitConnect.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitConnectMapper.updateByPrimaryKeySelective(leaseAllinpaySplitConnect);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitConnect leaseAllinpaySplitConnect) throws GMException {
        leaseAllinpaySplitConnect.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitConnectMapper.updateByPrimaryKey(leaseAllinpaySplitConnect);
        return row;
    }

    public LeaseAllinpaySplitConnect selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitConnect leaseAllinpaySplitConnect = leaseAllinpaySplitConnectMapper.selectByPrimaryKey(id);
        return leaseAllinpaySplitConnect;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplitConnect> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpaySplitConnect> leaseAllinpaySplitConnectList = leaseAllinpaySplitConnectMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpaySplitConnect> page = new PageInfo<LeaseAllinpaySplitConnect>(leaseAllinpaySplitConnectList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplitConnect> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitConnect> leaseAllinpaySplitConnectList = leaseAllinpaySplitConnectMapper.findAll(paramsMap);
        return leaseAllinpaySplitConnectList;
    }

    /**
     * 查询拆分的的明细全部扣款成功的数据
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<FindSplitCheckMapVo> findSplitCheck(Map<String, Object> paramsMap) {
        List<FindSplitCheckMapVo> findSplitCheckMapVoList = leaseAllinpaySplitConnectMapper.findSplitCheck(paramsMap);
        return findSplitCheckMapVoList;
    }

    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseAllinpaySplitConnectMapper.updateRepaymentId(paramsMap);
        return row;
    }
}
