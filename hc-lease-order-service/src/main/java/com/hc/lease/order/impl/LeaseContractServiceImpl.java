package com.hc.lease.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseContractMapper;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import com.hc.lease.order.model.LeaseSchemeRepayment;
import com.hc.lease.order.service.LeaseContractService;
import hc.lease.common.util.JsonUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseContractService")
public class LeaseContractServiceImpl implements LeaseContractService {

    @Autowired
    private LeaseContractMapper leaseContractMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContract insert(LeaseContract record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractMapper.insert(record);
        return record;
    }

    public LeaseContract insertSelective(LeaseContract record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseContract> list) throws GMException {
        return 0;
    }


    public int updateByPrimaryKeySelective(LeaseContract record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContract record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseContract selectByPrimaryKey(Long id) throws GMException {
        LeaseContract leaseContract = leaseContractMapper.selectByPrimaryKey(id);
        return leaseContract;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContract> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContract> leaseContractList = leaseContractMapper.findPage(paramsMap);
        if (leaseContractList != null) {
            if (leaseContractList.size() > 0) {
                for (int i = 0; i < leaseContractList.size(); i++) {
                    LeaseContract leaseContract = leaseContractList.get(i);
                    if (leaseContract != null) {
                        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts = leaseContract.getLeaseSchemeOrderAccounts();
                        if (leaseSchemeOrderAccounts != null) {
                            if (leaseSchemeOrderAccounts.size() > 0) {
                                String leaseSchemeOrderAccountJson = JsonUtil.stringify(leaseSchemeOrderAccounts);
                                leaseContract.setLeaseSchemeOrderAccountJson(leaseSchemeOrderAccountJson);
                            }
                        }
                        List<LeaseContractArchiveLocation> leaseContractArchiveLocations = leaseContract.getLeaseContractArchiveLocationList();
                        if (leaseContractArchiveLocations != null) {
                            if (leaseContractArchiveLocations.size() > 0) {
                                String leaseContractArchiveLocationJson = JsonUtil.stringify(leaseContractArchiveLocations);
                                leaseContract.setLeaseContractArchiveLocationJson(leaseContractArchiveLocationJson);
                            }
                        }
                    }
                }
            }
        }
        PageInfo<LeaseContract> page = new PageInfo<LeaseContract>(leaseContractList);
        return page;
    }

    public List<LeaseContract> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContract> leaseContractList = leaseContractMapper.findAll(paramsMap);
        return leaseContractList;
    }

    /**
     * 月供管理合同列表
     *
     * @param paramsMap
     * @return
     */
    public PageInfo<LeaseContract> findPostLending(int pageNum, int pageSize, Map<String, Object> paramsMap) {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContract> leaseContractList = leaseContractMapper.findPostLending(paramsMap);
        PageInfo<LeaseContract> page = new PageInfo<LeaseContract>(leaseContractList);
        return page;
    }

    public List<LeaseContract> findByParams(Map params) {
        List<LeaseContract> leaseContracts = leaseContractMapper.findByParams(params);
        return leaseContracts;
    }

    /**
     * 支付历史统计
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> allinpayLogStatistics(Map<String, Object> paramsMap) {
        Map<String, Object> map = leaseContractMapper.allinpayLogStatistics(paramsMap);
        return map;
    }

    /**
     * 月供管理统计 成功
     *
     * @param paramsMap
     * @return
     */
    public Integer postLendingStatisticsSuccess(Map<String, Object> paramsMap) {
        Integer map = leaseContractMapper.postLendingStatisticsSuccess(paramsMap);
        return map;
    }

    /**
     * 月供管理统计 失败
     *
     * @param paramsMap
     * @return
     */
    public Integer postLendingStatisticsFail(Map<String, Object> paramsMap) {
        Integer map = leaseContractMapper.postLendingStatisticsFail(paramsMap);
        return map;
    }

    /**
     * 月供管理统计 逾期
     *
     * @param paramsMap
     * @return
     */
    public Integer postLendingStatisticsOverdue(Map<String, Object> paramsMap) {
        Integer map = leaseContractMapper.postLendingStatisticsOverdue(paramsMap);
        return map;
    }

    public LeaseContract selectOrderInfo(Map<String, Object> paramsMap) throws GMException {
        LeaseContract leaseContract = leaseContractMapper.selectOrderInfo(paramsMap);
        if (leaseContract != null) {
            List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts = leaseContract.getLeaseSchemeOrderAccounts();
            if (leaseSchemeOrderAccounts != null) {
                if (leaseSchemeOrderAccounts.size() > 0) {
                    String leaseSchemeOrderAccountJson = JsonUtil.stringify(leaseSchemeOrderAccounts);
                    leaseContract.setLeaseSchemeOrderAccountJson(leaseSchemeOrderAccountJson);
                }
            }
            List<LeaseContractArchiveLocation> leaseContractArchiveLocations = leaseContract.getLeaseContractArchiveLocationList();
            if (leaseContractArchiveLocations != null) {
                if (leaseContractArchiveLocations.size() > 0) {
                    String leaseContractArchiveLocationJson = JsonUtil.stringify(leaseContractArchiveLocations);
                    leaseContract.setLeaseContractArchiveLocationJson(leaseContractArchiveLocationJson);
                }
            }
            List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseContract.getLeaseSchemeRepaymentList();
            if (leaseSchemeRepaymentList != null) {
                if (leaseSchemeRepaymentList.size() > 0) {
                    String leaseSchemeRepaymentJson = JsonUtil.stringify(leaseSchemeRepaymentList);
                    leaseContract.setLeaseSchemeRepaymentJson(leaseSchemeRepaymentJson);
                }
            }
        }
        return leaseContract;
    }
}
