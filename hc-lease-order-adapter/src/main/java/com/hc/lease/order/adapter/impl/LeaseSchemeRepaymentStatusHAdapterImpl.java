package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseSchemeRepaymentStatusHAdapter;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatusH;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusHService;
import com.hc.lease.order.vo.FindByContractIdAndPeriodVo;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 支付状态汇总管理 历史AdapterImpl
 *
 * @author Tong
 * @version 2018-07-19
 */
@Service("leaseSchemeRepaymentStatusHAdapter")
public class LeaseSchemeRepaymentStatusHAdapterImpl implements LeaseSchemeRepaymentStatusHAdapter {

    @Autowired
    private LeaseSchemeRepaymentStatusHService leaseSchemeRepaymentStatusHService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
     * 根据ID删除记录
     *
     * @param id .
     * @return
     * @throws GMException
     */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeRepaymentStatusHService.deleteByPrimaryKey(id);
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
        int row = leaseSchemeRepaymentStatusHService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemeRepaymentStatusH record) throws GMException {
        record = leaseSchemeRepaymentStatusHService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemeRepaymentStatusH record) throws GMException {
        record = leaseSchemeRepaymentStatusHService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeRepaymentStatusH record) throws GMException {
        int row = leaseSchemeRepaymentStatusHService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeRepaymentStatusH record) throws GMException {
        int row = leaseSchemeRepaymentStatusHService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemeRepaymentStatusH selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeRepaymentStatusH leaseSchemeRepaymentStatusH = leaseSchemeRepaymentStatusHService.selectByPrimaryKey(id);
        return leaseSchemeRepaymentStatusH;
    }

    public int insertList(List<LeaseSchemeRepaymentStatusH> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseSchemeRepaymentStatusH> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemeRepaymentStatusH> page = leaseSchemeRepaymentStatusHService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseSchemeRepaymentStatusH> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepaymentStatusH> leaseSchemeRepaymentStatusHList = leaseSchemeRepaymentStatusHService.findAll(paramsMap);
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
        List<FindByContractIdAndPeriodVo> leaseSchemeRepaymentStatusH = leaseSchemeRepaymentStatusHService.findByContractIdAndPeriod(paramsMap);
        return leaseSchemeRepaymentStatusH;
    }
}
