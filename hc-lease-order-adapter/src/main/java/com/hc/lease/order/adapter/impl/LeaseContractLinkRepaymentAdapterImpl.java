package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractLinkRepaymentAdapter;
import com.hc.lease.order.model.LeaseContractLink;
import com.hc.lease.order.model.LeaseContractLinkRepayment;
import com.hc.lease.order.service.api.LeaseContractLinkRepaymentService;
import com.hc.lease.order.service.api.LeaseContractLinkService;
import com.hc.lease.order.vo.FindLinkVo;
import hc.lease.common.util.DateUtils;
import hc.lease.common.util.ListUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 融租合同-挂靠还款明细，挂靠还款时间跟月租还款时间相同，首次操作还款则添加一条记录，即一个扣款日一条记录，类似还款计划明细，假如没有操作扣款而被检测到过期则自动添加一条过期月份的记录AdapterImpl
 *
 * @author Tong
 * @version 2017-08-24
 */
@Service("leaseContractLinkRepaymentAdapter")
public class LeaseContractLinkRepaymentAdapterImpl implements LeaseContractLinkRepaymentAdapter {

    @Autowired
    private LeaseContractLinkRepaymentService leaseContractLinkRepaymentService;

    @Autowired
    private LeaseContractLinkService leaseContractLinkService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractLinkRepaymentService.deleteByPrimaryKey(id);
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
        int row = leaseContractLinkRepaymentService.deleteBatchById(ids);
        return row;
    }

    /**
     * 定时添加融租合同的挂靠还款明细
     *
     * @return
     * @throws GMException
     */
    public ResultHashMap timeInsert() throws GMException {

        List<LeaseContractLink> leaseContractLinkList = leaseContractLinkService.findAll(null);//融租合同的挂靠数据
        ArrayList<LeaseContractLinkRepayment> arrayList = new ArrayList<LeaseContractLinkRepayment>();
        LeaseContractLinkRepayment leaseContractLinkRepayment = null;
        for (int i = 0; i < leaseContractLinkList.size(); i++) {
            leaseContractLinkRepayment = new LeaseContractLinkRepayment();
            LeaseContractLink leaseContractLink = leaseContractLinkList.get(i);
            Long contractLinkId = leaseContractLink.getId();
            Long contractId = leaseContractLink.getContractId();
            Long accountId = leaseContractLink.getAccountId();
            BigDecimal totlePrice = leaseContractLink.getTotlePrice();
            Integer repaymentDate = leaseContractLink.getRepaymentDate();

            leaseContractLinkRepayment.setAccountId(accountId);
            leaseContractLinkRepayment.setContractId(contractId);
            leaseContractLinkRepayment.setContractLinkId(contractLinkId);
            leaseContractLinkRepayment.setCreateTime(DateTime.now().toDate());
            leaseContractLinkRepayment.setUpdateTime(DateTime.now().toDate());
            leaseContractLinkRepayment.setOverdue(0);
            leaseContractLinkRepayment.setTotlePrice(totlePrice);
            leaseContractLinkRepayment.setRepaymentDate(DateTime.parse(DateUtils.getYear() + "-" + DateUtils.getMonth() + "-" + repaymentDate).toDate());
            arrayList.add(leaseContractLinkRepayment);
        }
        int row = leaseContractLinkRepaymentService.insertList(arrayList);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insert(LeaseContractLinkRepayment record) throws GMException {
        record = leaseContractLinkRepaymentService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractLinkRepayment record) throws GMException {
        record = leaseContractLinkRepaymentService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractLinkRepayment record) throws GMException {
        int row = leaseContractLinkRepaymentService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractLinkRepayment record) throws GMException {
        int row = leaseContractLinkRepaymentService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractLinkRepayment selectByPrimaryKey(Long id) throws GMException {
        LeaseContractLinkRepayment leaseContractLinkRepayment = leaseContractLinkRepaymentService.selectByPrimaryKey(id);
        return leaseContractLinkRepayment;
    }

    public int insertList(List<LeaseContractLinkRepayment> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractLinkRepayment> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractLinkRepayment> page = leaseContractLinkRepaymentService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContractLinkRepayment> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractLinkRepayment> leaseContractLinkRepaymentList = leaseContractLinkRepaymentService.findAll(paramsMap);
        return leaseContractLinkRepaymentList;
    }

    /**
     * 融租合同的 当月挂靠、过期未付款的挂靠
     *
     * @param paramsMap
     * @return
     */
    public List<FindLinkVo> findLink(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<FindLinkVo> leaseContractLinkRepaymentList = leaseContractLinkRepaymentService.findLink(paramsMap, dubboTreaceParames);
        return leaseContractLinkRepaymentList;
    }

    /**
     * 融租合同的 已逾期的挂靠还款记录
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseContractLinkRepayment> findOverdue(Map<String, Object> paramsMap) {
        List<LeaseContractLinkRepayment> leaseContractLinkRepaymentList = leaseContractLinkRepaymentService.findOverdue(paramsMap);
        return leaseContractLinkRepaymentList;
    }
}
