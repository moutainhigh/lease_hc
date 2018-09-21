package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseSchemeRepaymentStatusHMapper;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatusH;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusHService;
import com.hc.lease.order.vo.FindByContractIdAndPeriodVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 支付状态汇总管理 历史ServiceImpl
 *
 * @author Tong
 * @version 2018-07-19
 */
@Service("leaseSchemeRepaymentStatusHService")
public class LeaseSchemeRepaymentStatusHServiceImpl implements LeaseSchemeRepaymentStatusHService {

    @Autowired
    private LeaseSchemeRepaymentStatusHMapper leaseSchemeRepaymentStatusHMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeRepaymentStatusHMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemeRepaymentStatusHMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeRepaymentStatusH insert(LeaseSchemeRepaymentStatusH leaseSchemeRepaymentStatusH) throws GMException {
        leaseSchemeRepaymentStatusH.setCreateTime(DateTime.now().toDate());
        leaseSchemeRepaymentStatusH.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentStatusHMapper.insert(leaseSchemeRepaymentStatusH);
        return leaseSchemeRepaymentStatusH;
    }

    public LeaseSchemeRepaymentStatusH insertSelective(LeaseSchemeRepaymentStatusH leaseSchemeRepaymentStatusH) throws GMException {
        leaseSchemeRepaymentStatusH.setCreateTime(DateTime.now().toDate());
        leaseSchemeRepaymentStatusH.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentStatusHMapper.insertSelective(leaseSchemeRepaymentStatusH);
        return leaseSchemeRepaymentStatusH;
    }

    public int insertList(List<LeaseSchemeRepaymentStatusH> list) throws GMException {
        int row = leaseSchemeRepaymentStatusHMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeRepaymentStatusH leaseSchemeRepaymentStatusH) throws GMException {
        leaseSchemeRepaymentStatusH.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentStatusHMapper.updateByPrimaryKeySelective(leaseSchemeRepaymentStatusH);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeRepaymentStatusH leaseSchemeRepaymentStatusH) throws GMException {
        leaseSchemeRepaymentStatusH.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentStatusHMapper.updateByPrimaryKey(leaseSchemeRepaymentStatusH);
        return row;
    }

    public LeaseSchemeRepaymentStatusH selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeRepaymentStatusH leaseSchemeRepaymentStatusH = leaseSchemeRepaymentStatusHMapper.selectByPrimaryKey(id);
        return leaseSchemeRepaymentStatusH;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseSchemeRepaymentStatusH> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeRepaymentStatusH> leaseSchemeRepaymentStatusHList = leaseSchemeRepaymentStatusHMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeRepaymentStatusH> page = new PageInfo<LeaseSchemeRepaymentStatusH>(leaseSchemeRepaymentStatusHList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseSchemeRepaymentStatusH> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepaymentStatusH> leaseSchemeRepaymentStatusHList = leaseSchemeRepaymentStatusHMapper.findAll(paramsMap);
        return leaseSchemeRepaymentStatusHList;
    }

    /**
     * 合同修改时 查询合同原还款历史的还款状态
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<FindByContractIdAndPeriodVo> findByContractIdAndPeriod(Map<String, Object> paramsMap) {
        List<FindByContractIdAndPeriodVo> leaseSchemeRepaymentStatusH = leaseSchemeRepaymentStatusHMapper.findByContractIdAndPeriod(paramsMap);
        return leaseSchemeRepaymentStatusH;
    }
}
