package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseContractMapper;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import com.hc.lease.order.model.LeaseSchemeRepayment;
import com.hc.lease.order.service.api.LeaseContractService;
import com.hc.lease.order.vo.*;
import com.hc.lease.supplier.model.LeasePackageBalancePayment;
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

                        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseContract.getLeaseSchemeRepaymentList();
                        if (leaseSchemeRepaymentList != null) {
                            if (leaseSchemeRepaymentList.size() > 0) {
                                String leaseSchemeRepaymentJson = JsonUtil.stringify(leaseSchemeRepaymentList);
                                leaseContract.setLeaseSchemeRepaymentJson(leaseSchemeRepaymentJson);
                            }
                        }
                        List<LeasePackageBalancePayment> leasePackageBalancePayments = leaseContract.getLeasePackageBalancePayments();
                        if (leasePackageBalancePayments != null && leasePackageBalancePayments.size() > 0) {
                            String leasePackageBalancePaymentJson = JsonUtil.stringify(leasePackageBalancePayments);
                            leaseContract.setLeasePackageBalancePaymentJson(leasePackageBalancePaymentJson);
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
     * 月供管理列表 / 租金支付计划表 / 还款历史
     *
     * @param paramsMap
     * @return
     */
    public PageInfo<LeasePostLendingVo> findPostLending(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        PageHelper.startPage(pageNum, pageSize);
        List<LeasePostLendingVo> leaseContractList = leaseContractMapper.findPostLending(paramsMap);
        PageInfo<LeasePostLendingVo> page = new PageInfo<LeasePostLendingVo>(leaseContractList);
        return page;
    }

    /**
     * 逾期短信通知列表
     *
     * @param paramsMap
     * @return
     */
    public PageInfo<LeasePostLendingVo> findPostLendingOverdueSms(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        PageHelper.startPage(pageNum, pageSize);
        List<LeasePostLendingVo> leaseContractList = leaseContractMapper.findPostLendingOverdueSms(paramsMap);
        PageInfo<LeasePostLendingVo> page = new PageInfo<LeasePostLendingVo>(leaseContractList);
        return page;
    }

    public List<LeaseContract> findByParams(Map params) {
        List<LeaseContract> leaseContracts = leaseContractMapper.findByParams(params);
        return leaseContracts;
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
            List<LeasePackageBalancePayment> leasePackageBalancePayments = leaseContract.getLeasePackageBalancePayments();
            if (leasePackageBalancePayments != null && leasePackageBalancePayments.size() > 0) {
                String leasePackageBalancePaymentJson = JsonUtil.stringify(leasePackageBalancePayments);
                leaseContract.setLeasePackageBalancePaymentJson(leasePackageBalancePaymentJson);
            }
        }
        return leaseContract;
    }

    /**
     * 合同的尾付
     *
     * @param paramsMap
     * @return
     */
    public FindBalanceVo findBalancePayment(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        FindBalanceVo map = leaseContractMapper.findBalancePayment(paramsMap);
        return map;
    }

    /**
     * 融租合同承租人信息
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> findContractAccount(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        Map map = leaseContractMapper.findContractAccount(paramsMap);
        return map;
    }

    /**
     * 初始化单笔扣款页面的参数/合同信息
     *
     * @param paramsMap
     * @return
     */
    @Override
    public Map<String, Object> payViewParamesContractInfo(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        Map map = leaseContractMapper.payViewParamesContractInfo(paramsMap);
        return map;
    }

    /**
     * 融资租赁标的物
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> findContractInfo(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        Map map = leaseContractMapper.findContractInfo(paramsMap);
        return map;
    }


    public LeaseContract selectBySchemeOrderId(Long schemeOrderId) {

        LeaseContract leaseContract = leaseContractMapper.getBySchemeOrderId(schemeOrderId);
        return leaseContract;
    }

    /**
     * 各种款项的支付结果统计 / 如：单人综合扣款表头的统计
     *
     * @param paramsMap
     * @return
     */
    public List<Map<String, Object>> selectAllContractStatusDetails(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> list = leaseContractMapper.selectAllContractStatusDetails(paramsMap);
        return list;
    }

    /**
     * 各种支付方式统计 / 如：单人综合扣款表头的统计
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<Map<String, Object>> selectAllContractPayWayDetails(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> list = leaseContractMapper.selectAllContractPayWayDetails(paramsMap);
        return list;
    }

    public List<Map<String, Object>> selectAllContractStatusDetailsOverdueSms(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> list = leaseContractMapper.selectAllContractStatusDetailsOverdueSms(paramsMap);
        return list;
    }

    /**
     * 分公司统计
     *
     * @param paramsMap
     * @return
     */
    public List<Map<String, Object>> findAllContractStatisticsByCity(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> list = leaseContractMapper.findAllContractStatisticsByCity(paramsMap);
        return list;
    }

    /**
     * 根据分公司统计所有合同 / 如：逾期短信通知
     *
     * @param paramsMap
     * @return
     */
    public List<Map<String, Object>> findAllContractStatisticsByCityOverdueSms(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> list = leaseContractMapper.findAllContractStatisticsByCityOverdueSms(paramsMap);
        return list;
    }

    /**
     * 合同状态统计
     *
     * @param paramsMap
     * @return
     */
    public List<Map<String, Object>> findAllContractStatisticsByStatus(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> list = leaseContractMapper.findAllContractStatisticsByStatus(paramsMap);
        return list;
    }

    /**
     * 根据状态统计所有合同 / 如：逾期短信通知
     *
     * @param paramsMap
     * @return
     */
    public List<Map<String, Object>> findAllContractStatisticsByStatusOverdueSms(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<Map<String, Object>> list = leaseContractMapper.findAllContractStatisticsByStatusOverdueSms(paramsMap);
        return list;
    }

    public LeaseContract findByCompleteContractNumber(String contractNumber) {
        LeaseContract leaseContract = leaseContractMapper.findByCompleteContractNumber(contractNumber);

        return leaseContract;
    }

    /**
     * 合同所有数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindAllContractVo> selectAll(Map<String, Object> paramsMap) throws GMException {
        List<FindAllContractVo> leaseContractList = leaseContractMapper.selectAll(paramsMap);
        return leaseContractList;
    }

    public void updateSaleChannelId(Map<String, Object> maps) {
        leaseContractMapper.updateSaleChannelId(maps);

    }

    /**
     * 收车、丢失、报废 新增的页面 合同数据列表
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public List<CarManagerFindContractVo> carManagerFindContract(Map<String, Object> paramsMap) throws GMException {
        List<CarManagerFindContractVo> carCallbackFindContractVoList = leaseContractMapper.carManagerFindContract(paramsMap);
        return carCallbackFindContractVoList;
    }

    @Override
    public CarManagerDealFindContractVo carManagerDealFindContract(Map<String, Object> paramsMap) throws GMException {
        CarManagerDealFindContractVo carManagerAddFindContractVo = leaseContractMapper.carManagerDealFindContract(paramsMap);
        return carManagerAddFindContractVo;
    }

    /**
     * 修改 车辆贷后的 处理方案为断供， 则把合同状态改为断供
     *
     * @param leaseContract
     * @return
     * @throws GMException
     */
    @Override
    public int updateDealStatus(LeaseContract leaseContract) throws GMException {
        int row = leaseContractMapper.updateDealStatus(leaseContract);
        return row;
    }

    /**
     * 修改 车辆贷后的 处理方案， 还原合同状态
     *
     * @param leaseContract
     * @return
     * @throws GMException
     */
    @Override
    public int updateDealStatusAndStatusBack(LeaseContract leaseContract) throws GMException {
        int row = leaseContractMapper.updateDealStatusAndStatusBack(leaseContract);
        return row;
    }

    /**
     * 贷后直租合同 数据列表/改期数
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public PageInfo contractManagerFindContractUpdatePeriod(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<ContractManagerDealFindContractVo> contractManagerDealFindContractVoList = leaseContractMapper.contractManagerFindContractUpdatePeriod(paramsMap);
        PageInfo<ContractManagerDealFindContractVo> page = new PageInfo<ContractManagerDealFindContractVo>(contractManagerDealFindContractVoList);
        return page;
    }

    /**
     * 贷后直租合同 数据列表/结束处置
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public PageInfo contractManagerFindContractDealEnd(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<ContractManagerDealFindContractVo> contractManagerDealFindContractVoList = leaseContractMapper.contractManagerFindContractDealEnd(paramsMap);
        PageInfo<ContractManagerDealFindContractVo> page = new PageInfo<ContractManagerDealFindContractVo>(contractManagerDealFindContractVoList);
        return page;
    }

    /**
     * 贷前直租合同-次新车处置 合同数据列表 / 续期
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public PageInfo contractDQZZManagerFindContractContinue(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<ContractDQZZManagerFindContractVo> contractManagerDealFindContractVoList = leaseContractMapper.contractDQZZManagerFindContractContinue(paramsMap);
        PageInfo<ContractDQZZManagerFindContractVo> page = new PageInfo<ContractDQZZManagerFindContractVo>(contractManagerDealFindContractVoList);
        return page;
    }

    /**
     * 贷前直租合同-次新车处置 合同数据列表 / 转租
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public PageInfo contractDQZZManagerFindContractTransfer(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<ContractDQZZManagerFindContractVo> contractManagerDealFindContractVoList = leaseContractMapper.contractDQZZManagerFindContractTransfer(paramsMap);
        PageInfo<ContractDQZZManagerFindContractVo> page = new PageInfo<ContractDQZZManagerFindContractVo>(contractManagerDealFindContractVoList);
        return page;
    }
    /**
     * 还款历史 查看里面的统计部分
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public FindAllinpayLogStatisticsVo findAllinpayLogStatistics(Map<String, Object> paramsMap) throws GMException {
        FindAllinpayLogStatisticsVo findAllinpayLogStatisticsVoList = leaseContractMapper.findAllinpayLogStatistics(paramsMap);
        return findAllinpayLogStatisticsVoList;
    }

}
