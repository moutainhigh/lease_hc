package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.service.api.LeaseManualDeductionsStatistService;
import com.hc.lease.postlending.model.LeaseManualDeductionsStatist;
import com.hc.lease.postlending.dao.LeaseManualDeductionsStatistMapper;

import java.util.List;
import java.util.Map;

/**
 * 手动扣款统计ServiceImpl
 *
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductionsStatistService")
public class LeaseManualDeductionsStatistServiceImpl implements LeaseManualDeductionsStatistService {

    @Autowired
    private LeaseManualDeductionsStatistMapper leaseManualDeductionsStatistMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseManualDeductionsStatistMapper.deleteByPrimaryKey(id);
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
        int row = leaseManualDeductionsStatistMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseManualDeductionsStatist insert(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException {
        leaseManualDeductionsStatist.setCreateTime(DateTime.now().toDate());
        leaseManualDeductionsStatist.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsStatistMapper.insert(leaseManualDeductionsStatist);
        return leaseManualDeductionsStatist;
    }

    public LeaseManualDeductionsStatist insertSelective(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException {
        leaseManualDeductionsStatist.setCreateTime(DateTime.now().toDate());
        leaseManualDeductionsStatist.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsStatistMapper.insertSelective(leaseManualDeductionsStatist);
        return leaseManualDeductionsStatist;
    }

    public int insertList(List<LeaseManualDeductionsStatist> list) throws GMException {
        int row = leaseManualDeductionsStatistMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException {
        int row = leaseManualDeductionsStatistMapper.updateByPrimaryKeySelective(leaseManualDeductionsStatist);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException {
        int row = leaseManualDeductionsStatistMapper.updateByPrimaryKey(leaseManualDeductionsStatist);
        return row;
    }

    public LeaseManualDeductionsStatist selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductionsStatist leaseManualDeductionsStatist = leaseManualDeductionsStatistMapper.selectByPrimaryKey(id);
        return leaseManualDeductionsStatist;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseManualDeductionsStatist> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseManualDeductionsStatist> leaseManualDeductionsStatistList = leaseManualDeductionsStatistMapper.findPage(paramsMap);
        PageInfo<LeaseManualDeductionsStatist> page = new PageInfo<LeaseManualDeductionsStatist>(leaseManualDeductionsStatistList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseManualDeductionsStatist> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductionsStatist> leaseManualDeductionsStatistList = leaseManualDeductionsStatistMapper.findAll(paramsMap);
        return leaseManualDeductionsStatistList;
    }

    /**
     * 提交支付更新
     *
     * @param leaseManualDeductionsStatist
     * @return
     * @throws GMException
     */
    @Override
    public int updateOnpay(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException {
        int row = leaseManualDeductionsStatistMapper.updateOnpay(leaseManualDeductionsStatist);
        return row;
    }
}
