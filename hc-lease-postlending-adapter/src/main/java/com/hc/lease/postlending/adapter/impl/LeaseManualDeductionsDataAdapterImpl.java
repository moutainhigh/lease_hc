package com.hc.lease.postlending.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.account.model.LeaseAccountBankPaySin;
import com.hc.lease.account.service.api.LeaseAccountBankPaySinService;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.constant.PaymentResult;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.excel.poi.vo.ManualDeductionsDataTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import com.hc.lease.order.vo.FindByPlateNumberAndRepaymentDateVo;
import com.hc.lease.postlending.adapter.api.LeaseManualDeductionsDataAdapter;
import com.hc.lease.postlending.model.LeaseManualDeductionsData;
import com.hc.lease.postlending.model.LeaseManualDeductionsStatist;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsDataService;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsStatistService;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.vo.*;
import hc.lease.common.util.ListUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 手动扣款提交的数据AdapterImpl
 *
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductionsDataAdapter")
public class LeaseManualDeductionsDataAdapterImpl implements LeaseManualDeductionsDataAdapter {

    private static Context context = new Context();

    @Autowired
    private LeaseManualDeductionsDataService leaseManualDeductionsDataService;

    @Autowired
    private LeaseManualDeductionsStatistService leaseManualDeductionsStatistService;

    @Autowired
    private LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService;

    @Autowired
    private LeaseAccountBankPaySinService leaseAccountBankPaySinService;

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
        int row = leaseManualDeductionsDataService.deleteByPrimaryKey(id);
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
        int row = leaseManualDeductionsDataService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseManualDeductionsData record) throws GMException {
        record = leaseManualDeductionsDataService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseManualDeductionsData record) throws GMException {
        record = leaseManualDeductionsDataService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductionsData record) throws GMException {
        int row = leaseManualDeductionsDataService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductionsData record) throws GMException {
        int row = leaseManualDeductionsDataService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseManualDeductionsData selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductionsData leaseManualDeductionsData = leaseManualDeductionsDataService.selectByPrimaryKey(id);
        return leaseManualDeductionsData;
    }

    public int insertList(List<LeaseManualDeductionsData> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseManualDeductionsData> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseManualDeductionsData> page = leaseManualDeductionsDataService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseManualDeductionsData> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductionsData> leaseManualDeductionsDataList = leaseManualDeductionsDataService.findAll(paramsMap);
        return leaseManualDeductionsDataList;
    }

    /**
     * 可以扣款的数据
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<FindNeedPayVo> findNeedPay(Map<String, Object> paramsMap) throws GMException {
        List<FindNeedPayVo> leaseManualDeductionsDataList = leaseManualDeductionsDataService.findNeedPay(paramsMap);
        return leaseManualDeductionsDataList;
    }

    /**
     * 手动扣款/新增(Excel上传)
     *
     * @param manualDeductionsDataTemplateList
     * @return
     * @throws GMException
     */
    @Override
    public ResultHashMap importManualDeductions(List<ManualDeductionsDataTemplate> manualDeductionsDataTemplateList, UserSession userSession, DubboTreaceParames dubboTreaceParames) throws GMException {
        Date nowDate = DateTime.now().toDate();
        ResultHashMap resultHashMap = null;
        if (manualDeductionsDataTemplateList != null) {
            if (manualDeductionsDataTemplateList.size() > 0) {
                LeaseManualDeductionsStatist leaseManualDeductionsStatist = importManualDeductionsDualStatist(manualDeductionsDataTemplateList, nowDate, userSession);
                resultHashMap = importManualDeductionsDual(manualDeductionsDataTemplateList, nowDate, userSession, leaseManualDeductionsStatist, dubboTreaceParames);
            }
        }
        return resultHashMap;
    }

    /**
     * 手动扣款/重新上传
     *
     * @param manualDeductionsDataTemplateList
     * @param userSession
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public ResultHashMap importManualDeductionsAgain(List<ManualDeductionsDataTemplate> manualDeductionsDataTemplateList, Long statistId, UserSession userSession, DubboTreaceParames dubboTreaceParames) throws GMException {
        leaseManualDeductionsDataService.deleteByStatistId(statistId);
        Date nowDate = DateTime.now().toDate();
        ResultHashMap resultHashMap = null;
        if (manualDeductionsDataTemplateList == null || manualDeductionsDataTemplateList.size() <= 0) {
            throw new GMException(GMExceptionConstant.FAILED_SAVE_UPDATE);
        }

        LeaseManualDeductionsStatist leaseManualDeductionsStatist = leaseManualDeductionsStatistService.selectByPrimaryKey(statistId);
        if (leaseManualDeductionsStatist.getIsPay().equals(1))
            throw new GMException(GMExceptionConstant.MANUAL_DEDUCTIONS_IS_PAY);

        resultHashMap = importManualDeductionsDual(manualDeductionsDataTemplateList, nowDate, userSession, leaseManualDeductionsStatist, dubboTreaceParames);

        //更新 手动扣款统计 重新上传状态
        BigDecimal allTotalPrice = new BigDecimal(0);
        for (int i = 0; i < manualDeductionsDataTemplateList.size(); i++) {
            ManualDeductionsDataTemplate manualDeductionsDataTemplate = manualDeductionsDataTemplateList.get(i);
            BigDecimal totalPrice = manualDeductionsDataTemplate.getTotalPrice();
            totalPrice = totalPrice == null ? new BigDecimal(0) : totalPrice;
            allTotalPrice = allTotalPrice.add(totalPrice);
        }
        leaseManualDeductionsStatist.setTotalPrice(allTotalPrice);
        leaseManualDeductionsStatist.setTotalSum(manualDeductionsDataTemplateList.size());
        leaseManualDeductionsStatist.setUpdateTime(nowDate);
        leaseManualDeductionsStatist.setIsImportAgain(1);//是否已重新上传 0否 1是
        leaseManualDeductionsStatistService.updateByPrimaryKeySelective(leaseManualDeductionsStatist);

        return resultHashMap;
    }

    /**
     * 处理 手动扣款提交的数据
     *
     * @param manualDeductionsDataTemplateList
     * @param nowDate
     * @param userSession
     * @param leaseManualDeductionsStatist
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    public ResultHashMap importManualDeductionsDual(List<ManualDeductionsDataTemplate> manualDeductionsDataTemplateList, Date nowDate, UserSession userSession, LeaseManualDeductionsStatist leaseManualDeductionsStatist, DubboTreaceParames dubboTreaceParames) throws GMException {
        LeaseManualDeductionsData leaseManualDeductionsData = null;
        List<LeaseManualDeductionsData> leaseManualDeductionsDataList = new ArrayList<LeaseManualDeductionsData>();
        Map<String, Object> paramsMap = null;
        for (int i = 0; i < manualDeductionsDataTemplateList.size(); i++) {
            paramsMap = Maps.newHashMap();
            ManualDeductionsDataTemplate manualDeductionsDataTemplate = manualDeductionsDataTemplateList.get(i);
            //扣款日期、车牌号有数据则检测是否存在合同
            if (manualDeductionsDataTemplate.getRepaymentDate() != null && manualDeductionsDataTemplate.getPlateNumber() != null) {
                Date repaymentDateBegin = DateUtil.getMonthBegin(manualDeductionsDataTemplate.getRepaymentDate());
                Date repaymentDateEnd = DateUtil.getMonthEnd(manualDeductionsDataTemplate.getRepaymentDate());
                paramsMap.put("plateNumber", manualDeductionsDataTemplate.getPlateNumber());
                paramsMap.put("repaymentDateBegin", repaymentDateBegin);
                paramsMap.put("repaymentDateEnd", repaymentDateEnd);
                FindByPlateNumberAndRepaymentDateVo findByPlateNumberAndRepaymentDateVo = leaseSchemeRepaymentStatusService.findByPlateNumberAndRepaymentDate(paramsMap);//合同还款计划
                if (findByPlateNumberAndRepaymentDateVo != null) {//存在合同
                    leaseManualDeductionsData = importManualDeductionsDualExist(findByPlateNumberAndRepaymentDateVo, manualDeductionsDataTemplate, nowDate, userSession, leaseManualDeductionsStatist, paramsMap);
                } else {//不存在合同
                    leaseManualDeductionsData = importManualDeductionsDualNotExist(manualDeductionsDataTemplate, nowDate, userSession, leaseManualDeductionsStatist, paramsMap);
                }
            } else {//不存在合同
                leaseManualDeductionsData = importManualDeductionsDualNotExist(manualDeductionsDataTemplate, nowDate, userSession, leaseManualDeductionsStatist, paramsMap);
            }
            leaseManualDeductionsDataList.add(leaseManualDeductionsData);
        }
        leaseManualDeductionsDataService.insertList(leaseManualDeductionsDataList);
        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.DUAL_SUCCESS);
        return resultHashMap;
    }

    /**
     * 存在合同
     * 组装数据
     *
     * @param manualDeductionsDataTemplate
     * @param nowDate
     * @param userSession
     * @param leaseManualDeductionsStatist
     * @return
     * @throws GMException
     */
    public LeaseManualDeductionsData importManualDeductionsDualExist(FindByPlateNumberAndRepaymentDateVo findByPlateNumberAndRepaymentDateVo, ManualDeductionsDataTemplate manualDeductionsDataTemplate, Date nowDate, UserSession userSession, LeaseManualDeductionsStatist leaseManualDeductionsStatist, Map<String, Object> paramsMap) throws GMException {
        LeaseManualDeductionsData leaseManualDeductionsData = new LeaseManualDeductionsData();

        CheckIsOperationVo checkIsOperationVo = checkIsOperation(findByPlateNumberAndRepaymentDateVo, manualDeductionsDataTemplate, null);
        Integer isOperation = checkIsOperationVo.getIsOperation();//能否操作
        String isOperationMsg = checkIsOperationVo.getIsOperationMsg();//不能操作原因
        Integer isExistContract = checkIsOperationVo.getIsExistContract();//合同是否存在
        Integer isSign = checkIsOperationVo.getIsSign();//银行卡是否签约
        Integer isExcessLimit = checkIsOperationVo.getIsExcessLimit();//是否超额
        Integer isBankPhoneErr = checkIsOperationVo.getIsBankPhoneErr();//银行预留手机是否异常
        Integer isPriceErr = checkIsOperationVo.getIsPriceErr();
        Integer isRepaymentDateErr = checkIsOperationVo.getIsRepaymentDateErr();//扣款日是否异常
        Long repaymentId = checkIsOperationVo.getRepaymentId();
        Long contractId = checkIsOperationVo.getContractId();

        leaseManualDeductionsData.setStatistId(leaseManualDeductionsStatist.getId());
        leaseManualDeductionsData.setRepaymentId(repaymentId);
        leaseManualDeductionsData.setContractId(contractId);
        leaseManualDeductionsData.setBranchCompany(manualDeductionsDataTemplate.getBranchCompany());
        leaseManualDeductionsData.setBackCardNumber(manualDeductionsDataTemplate.getBackCardNumber());
        leaseManualDeductionsData.setBankAccountName(manualDeductionsDataTemplate.getBankAccountName());
        leaseManualDeductionsData.setBankCode(manualDeductionsDataTemplate.getBankCode());
        leaseManualDeductionsData.setBankPhone(manualDeductionsDataTemplate.getBankPhone());
        leaseManualDeductionsData.setReallyBankPhone(findByPlateNumberAndRepaymentDateVo.getBankPhone());
        leaseManualDeductionsData.setAgrmNo(findByPlateNumberAndRepaymentDateVo.getAgrmNo());
        leaseManualDeductionsData.setIdCard(manualDeductionsDataTemplate.getIdCard());
        leaseManualDeductionsData.setTotalPrice(manualDeductionsDataTemplate.getTotalPrice() == null ? new BigDecimal(0) : manualDeductionsDataTemplate.getTotalPrice());
        leaseManualDeductionsData.setOverdueDay(manualDeductionsDataTemplate.getOverdueDay());
        leaseManualDeductionsData.setPlateNumber(manualDeductionsDataTemplate.getPlateNumber());
        leaseManualDeductionsData.setRepaymentDate(manualDeductionsDataTemplate.getRepaymentDate());
        leaseManualDeductionsData.setReallyRepaymentDate(findByPlateNumberAndRepaymentDateVo.getRepaymentDate());
        leaseManualDeductionsData.setPaymentResult(PaymentResult.TYPE_0);
        leaseManualDeductionsData.setIsOperation(isOperation);
        leaseManualDeductionsData.setIsOperationMsg(isOperationMsg);
        leaseManualDeductionsData.setIsExistContract(isExistContract);
        leaseManualDeductionsData.setIsSign(isSign);
        leaseManualDeductionsData.setIsExcessLimit(isExcessLimit);
        leaseManualDeductionsData.setIsBankPhoneErr(isBankPhoneErr);
        leaseManualDeductionsData.setIsPriceErr(isPriceErr);
        leaseManualDeductionsData.setIsRepaymentDateErr(isRepaymentDateErr);
        leaseManualDeductionsData.setCreateBy(userSession.getUserId());
        leaseManualDeductionsData.setCreateTime(nowDate);
        leaseManualDeductionsData.setUpdateBy(userSession.getUserId());
        leaseManualDeductionsData.setUpdateTime(nowDate);

        leaseManualDeductionsData.setPaymentResult(0);

        return leaseManualDeductionsData;
    }

    /**
     * 不存在合同
     * 组装数据
     *
     * @param manualDeductionsDataTemplate
     * @param nowDate
     * @param userSession
     * @param leaseManualDeductionsStatist
     * @return
     * @throws GMException
     */
    public LeaseManualDeductionsData importManualDeductionsDualNotExist(ManualDeductionsDataTemplate manualDeductionsDataTemplate, Date nowDate, UserSession userSession, LeaseManualDeductionsStatist leaseManualDeductionsStatist, Map<String, Object> paramsMap) throws GMException {
        LeaseAccountBankPaySin leaseAccountBankPaySin = null;
        if (manualDeductionsDataTemplate.getBackCardNumber() != null) {
            leaseAccountBankPaySin = leaseAccountBankPaySinService.findByBankCardNumber(manualDeductionsDataTemplate.getBackCardNumber());//银行卡信息
        }

        CheckIsOperationVo checkIsOperationVo = checkIsOperation(null, manualDeductionsDataTemplate, leaseAccountBankPaySin);//检测各种状态
        Integer isOperation = checkIsOperationVo.getIsOperation();//能否操作
        String isOperationMsg = checkIsOperationVo.getIsOperationMsg();//不能操作原因

        LeaseManualDeductionsData leaseManualDeductionsData = new LeaseManualDeductionsData();
        leaseManualDeductionsData.setStatistId(leaseManualDeductionsStatist.getId());
        leaseManualDeductionsData.setRepaymentId(null);
        leaseManualDeductionsData.setContractId(null);
        leaseManualDeductionsData.setBranchCompany(manualDeductionsDataTemplate.getBranchCompany());
        leaseManualDeductionsData.setBackCardNumber(manualDeductionsDataTemplate.getBackCardNumber());
        leaseManualDeductionsData.setBankAccountName(manualDeductionsDataTemplate.getBankAccountName());
        leaseManualDeductionsData.setBankCode(manualDeductionsDataTemplate.getBankCode());
        leaseManualDeductionsData.setBankPhone(manualDeductionsDataTemplate.getBankPhone());
        leaseManualDeductionsData.setReallyBankPhone(leaseAccountBankPaySin != null ? leaseAccountBankPaySin.getBankPhone() : null);
        leaseManualDeductionsData.setAgrmNo(leaseAccountBankPaySin != null ? leaseAccountBankPaySin.getAgrmNo() : null);
        leaseManualDeductionsData.setIdCard(manualDeductionsDataTemplate.getIdCard());
        leaseManualDeductionsData.setTotalPrice(manualDeductionsDataTemplate.getTotalPrice() == null ? new BigDecimal(0) : manualDeductionsDataTemplate.getTotalPrice());
        leaseManualDeductionsData.setOverdueDay(manualDeductionsDataTemplate.getOverdueDay());
        leaseManualDeductionsData.setPlateNumber(manualDeductionsDataTemplate.getPlateNumber());
        leaseManualDeductionsData.setRepaymentDate(manualDeductionsDataTemplate.getRepaymentDate());
        leaseManualDeductionsData.setReallyRepaymentDate(null);
        leaseManualDeductionsData.setPaymentResult(PaymentResult.TYPE_0);
        leaseManualDeductionsData.setIsOperation(isOperation);
        leaseManualDeductionsData.setIsOperationMsg(isOperationMsg);
        leaseManualDeductionsData.setIsExistContract(checkIsOperationVo.getIsExistContract());
        leaseManualDeductionsData.setIsSign(checkIsOperationVo.getIsSign());
        leaseManualDeductionsData.setIsExcessLimit(checkIsOperationVo.getIsExcessLimit());
        leaseManualDeductionsData.setIsBankPhoneErr(checkIsOperationVo.getIsBankPhoneErr());
        leaseManualDeductionsData.setIsPriceErr(checkIsOperationVo.getIsPriceErr());
        leaseManualDeductionsData.setIsRepaymentDateErr(checkIsOperationVo.getIsRepaymentDateErr());
        leaseManualDeductionsData.setCreateBy(userSession.getUserId());
        leaseManualDeductionsData.setCreateTime(nowDate);
        leaseManualDeductionsData.setUpdateBy(userSession.getUserId());
        leaseManualDeductionsData.setUpdateTime(nowDate);
        leaseManualDeductionsData.setPaymentResult(PaymentResult.TYPE_0);
        return leaseManualDeductionsData;
    }

    /**
     * 处理 手动扣款统计
     *
     * @param manualDeductionsDataTemplateList
     * @return
     * @throws GMException
     */
    public LeaseManualDeductionsStatist importManualDeductionsDualStatist(List<ManualDeductionsDataTemplate> manualDeductionsDataTemplateList, Date nowDate, UserSession userSession) throws GMException {
        LeaseManualDeductionsStatist leaseManualDeductionsStatist = new LeaseManualDeductionsStatist();
        BigDecimal allTotalPrice = new BigDecimal(0);
        for (int i = 0; i < manualDeductionsDataTemplateList.size(); i++) {
            ManualDeductionsDataTemplate manualDeductionsDataTemplate = manualDeductionsDataTemplateList.get(i);
            BigDecimal totalPrice = manualDeductionsDataTemplate.getTotalPrice();
            totalPrice = totalPrice == null ? new BigDecimal(0) : totalPrice;
            allTotalPrice = allTotalPrice.add(totalPrice);
        }
        leaseManualDeductionsStatist.setTotalPrice(allTotalPrice);//总金额/应扣总额
        leaseManualDeductionsStatist.setTotalSum(manualDeductionsDataTemplateList.size());//总数量
        leaseManualDeductionsStatist.setCreateTime(nowDate);
        leaseManualDeductionsStatist.setUpdateTime(nowDate);
        leaseManualDeductionsStatist.setCreateBy(userSession.getUserId());
        leaseManualDeductionsStatist.setUpdateBy(userSession.getUserId());
        leaseManualDeductionsStatist = leaseManualDeductionsStatistService.insertSelective(leaseManualDeductionsStatist);
        return leaseManualDeductionsStatist;
    }

    /**
     * 检测各种状态
     *
     * @param findByPlateNumberAndRepaymentDateVo 查询的数据
     * @param manualDeductionsDataTemplate        提交的数据
     * @param leaseAccountBankPaySin              银行卡信息
     * @return
     * @throws GMException
     */
    public CheckIsOperationVo checkIsOperation(
            FindByPlateNumberAndRepaymentDateVo findByPlateNumberAndRepaymentDateVo
            , ManualDeductionsDataTemplate manualDeductionsDataTemplate
            , LeaseAccountBankPaySin leaseAccountBankPaySin
    ) throws GMException {
        CheckIsOperationVo checkIsOperationVo = new CheckIsOperationVo();
        //有合同
        if (findByPlateNumberAndRepaymentDateVo != null) {
            //excel空值判断
            if (manualDeductionsDataTemplate.getTotalPrice() == null
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBackCardNumber())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBankAccountName())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBankCode())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBankPhone())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBranchCompany())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getIdCard())
                    ) {
                checkIsOperationVo.setIsOperation(0);
                checkIsOperationVo.setIsOperationMsg("失败，缺少必填项，或银行卡信息有误，或银行卡签约有误");
                checkIsOperationVo.setRepaymentId(null);
                checkIsOperationVo.setContractId(null);
            } else {
                Integer isBankPhoneErr = 0;
                if (findByPlateNumberAndRepaymentDateVo.getBankPhone() == null) {
                    isBankPhoneErr = 1;//银行预留手机是否异常
                } else {
                    isBankPhoneErr = findByPlateNumberAndRepaymentDateVo.getBankPhone().equals(manualDeductionsDataTemplate.getBankPhone()) ? 0 : 1;//银行预留手机是否异常
                }
                //Integer isExcessLimit = manualDeductionsDataTemplate.getTotalPrice().compareTo(findByPlateNumberAndRepaymentDateVo.getPriceLimit()) == 1 ? 1 : 0;//是否超额 0否 1是
                Integer isPriceErr = 0;
                BigDecimal totlePrice0 = findByPlateNumberAndRepaymentDateVo.getTotlePrice0() == null ? new BigDecimal(0) : findByPlateNumberAndRepaymentDateVo.getTotlePrice0();//月租金额
                //BigDecimal totlePrice2 = findByPlateNumberAndRepaymentDateVo.getTotlePrice2() == null ? new BigDecimal(0) : findByPlateNumberAndRepaymentDateVo.getTotlePrice2();//滞纳金金额
                Integer overdueDayUp = manualDeductionsDataTemplate.getOverdueDay() == null ? 0 : manualDeductionsDataTemplate.getOverdueDay();
                BigDecimal totalOverdue = findByPlateNumberAndRepaymentDateVo.getOverdueRate().multiply(new BigDecimal(overdueDayUp)).multiply(totlePrice0).setScale(2, BigDecimal.ROUND_HALF_UP);//逾期金额
                BigDecimal total = totlePrice0.add(totalOverdue);

                if (manualDeductionsDataTemplate.getTotalPrice().compareTo(total) == 1) {
                    isPriceErr = manualDeductionsDataTemplate.getTotalPrice().subtract(total).compareTo(new BigDecimal(0.1)) == 1 ? 1 : 0;
                } else {
                    isPriceErr = total.subtract(manualDeductionsDataTemplate.getTotalPrice()).compareTo(new BigDecimal(0.1)) == 1 ? 1 : 0;
                }
                Integer isRepaymentDateErr = findByPlateNumberAndRepaymentDateVo.getRepaymentId() != null ? 0 : 1;//扣款日是否异常 0否 1是
                Integer isSign = findByPlateNumberAndRepaymentDateVo.getIsSign().equals(1) ? 1 : 0;//银行卡是否签约 0否 1是
                Integer isExcessLimit = manualDeductionsDataTemplate.getTotalPrice().compareTo(findByPlateNumberAndRepaymentDateVo.getPriceLimit()) == 1 ? 1 : 0;//是否超额
                checkIsOperationVo.setIsExistContract(1);
                checkIsOperationVo.setIsSign(isSign);
                checkIsOperationVo.setIsExcessLimit(isExcessLimit);
                checkIsOperationVo.setIsBankPhoneErr(isBankPhoneErr);
                checkIsOperationVo.setIsPriceErr(isPriceErr);
                checkIsOperationVo.setIsRepaymentDateErr(isRepaymentDateErr);
                checkIsOperationVo.setRepaymentId(findByPlateNumberAndRepaymentDateVo.getRepaymentId());
                checkIsOperationVo.setContractId(findByPlateNumberAndRepaymentDateVo.getContractId());
                //扣款中或者已成功扣款则不需再操作扣款
                if (findByPlateNumberAndRepaymentDateVo.getPaymentResult0() == null) {
                    checkIsOperationVo.setIsOperation(0);
                    checkIsOperationVo.setIsOperationMsg("合同已经操作过通联扣款或线下缴款登记");
                } else if (findByPlateNumberAndRepaymentDateVo.getPaymentResult0().equals(PaymentResult.TYPE_1)) {
                    checkIsOperationVo.setIsOperation(0);
                    checkIsOperationVo.setIsOperationMsg("合同已经操作过通联扣款或线下缴款登记");

                } else if (findByPlateNumberAndRepaymentDateVo.getPaymentResult0().equals(PaymentResult.TYPE_2)) {
                    checkIsOperationVo.setIsOperation(0);
                    checkIsOperationVo.setIsOperationMsg("合同已经操作过通联扣款或线下缴款登记");
                } else if (isBankPhoneErr.equals(1)) {//银行预留手机异常
                    checkIsOperationVo.setIsOperation(0);
                    checkIsOperationVo.setIsOperationMsg("银行预留手机不一致");
                }

                    /*else if (isExcessLimit.equals(1)) {//超额
                        map.put("isOperation", 0);
                        map.put("isOperationMsg", "超额");
                    } */

                /*
                else if (isPriceErr.equals(1)) {//金额异常
                    checkIsOperationVo.setIsOperation(0);
                    checkIsOperationVo.setIsOperationMsg("金额异常,月租+滞纳金金额相差大于0.01");
                }
                */

                else if (isRepaymentDateErr.equals(1)) {//扣款日异常
                    checkIsOperationVo.setIsOperation(0);
                    checkIsOperationVo.setIsOperationMsg("扣款日异常");
                } else if (isSign.equals(0)) {//银行卡未签约
                    checkIsOperationVo.setIsOperation(0);
                    checkIsOperationVo.setIsOperationMsg("银行卡未签约");
                } else {
                    checkIsOperationVo.setIsOperation(1);
                    checkIsOperationVo.setIsOperationMsg(null);
                }
            }
        } else {
            checkIsOperationVo.setRepaymentId(null);
            checkIsOperationVo.setContractId(null);
            checkIsOperationVo.setIsExistContract(0);
            checkIsOperationVo.setIsExcessLimit(0);
            checkIsOperationVo.setIsPriceErr(0);
            checkIsOperationVo.setIsRepaymentDateErr(0);
            //excel空值判断
            if (manualDeductionsDataTemplate.getTotalPrice() == null
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBackCardNumber())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBankAccountName())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBankCode())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBankPhone())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getBranchCompany())
                    || StringUtils.isBlank(manualDeductionsDataTemplate.getIdCard())
                    ) {
                checkIsOperationVo.setIsOperation(0);
                checkIsOperationVo.setIsOperationMsg("失败，缺少必填项，或银行卡信息有误，或银行卡签约有误");
            } else {
                if (leaseAccountBankPaySin == null) {
                    checkIsOperationVo.setIsSign(0);
                    checkIsOperationVo.setIsBankPhoneErr(1);
                    checkIsOperationVo.setIsOperation(0);
                    checkIsOperationVo.setIsOperationMsg("失败，缺少必填项，或银行卡信息有误，或银行卡签约有误");
                } else {
                    if (StringUtils.isNotEmpty(leaseAccountBankPaySin.getAgrmNo())) {
                        checkIsOperationVo.setIsSign(1);
                        checkIsOperationVo.setIsOperation(1);
                        checkIsOperationVo.setIsOperationMsg(null);
                    } else {
                        checkIsOperationVo.setIsSign(0);
                        checkIsOperationVo.setIsOperation(0);
                        checkIsOperationVo.setIsOperationMsg("银行预留手机号异常");
                    }
                    if (!leaseAccountBankPaySin.getBankPhone().equals(manualDeductionsDataTemplate.getBankPhone())) {
                        checkIsOperationVo.setIsBankPhoneErr(1);
                        checkIsOperationVo.setIsOperation(0);
                        checkIsOperationVo.setIsOperationMsg("银行预留手机号异常");
                    } else {
                        checkIsOperationVo.setIsBankPhoneErr(0);
                        checkIsOperationVo.setIsOperation(1);
                        checkIsOperationVo.setIsOperationMsg(null);
                    }
                }
            }
        }

        return checkIsOperationVo;
    }

    /**
     * 手动扣款/提交支付
     *
     * @param leaseManualDeductionsDataList
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public ResultHashMap dualImportManualDeductionsPay(List<FindNeedPayVo> leaseManualDeductionsDataList, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames, UserSession userSession) throws GMException {
        if (leaseManualDeductionsDataList == null || leaseManualDeductionsDataList.size() <= 0) {
            throw new GMException(GMExceptionConstant.FAILED_SAVE_UPDATE);
        }

        Date nowDate = DateTime.now().toDate();

        TransManualDeductionsBody transManualDeductionsBody = new TransManualDeductionsBody();
        transManualDeductionsBody.setCreateTime(nowDate);
        transManualDeductionsBody.setCreateBy(userSession.getUserId());
        transManualDeductionsBody.setUpdateTime(nowDate);
        transManualDeductionsBody.setUpdateBy(userSession.getUserId());
        transManualDeductionsBody.setIsSpilt(0);

        for (int i = 0; i < leaseManualDeductionsDataList.size(); i++) {
            String sn = String.valueOf(System.currentTimeMillis()) + "-000" + i;//记录序号 通联批量扣款、通联会原样返回
            transManualDeductionsBody.setSn(sn);
            FindNeedPayVo findNeedPayVo = leaseManualDeductionsDataList.get(i);
            context.deal(context, JDBCTpye.JDBC_INSERT + "ManualDeductionsPayCommon", transManualDeductionsBody, findNeedPayVo, null, dubboTreaceParames);
        }

        ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.MANUAL_ALLINPAY_SEND_SUCCESS);
        return resultHashMap;
    }

    /**
     * 需要轮询通联手动扣款
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<FindQueryTradeVo> findQueryTrade(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindQueryTradeVo> findQueryTradeVoList = leaseManualDeductionsDataService.findQueryTrade(paramsMap, dubboTreaceParames);
        return findQueryTradeVoList;
    }

    /**
     * 下载核对
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsCheckExcel(Map<String, Object> paramsMap) throws GMException {
        List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsCheckExcelList = leaseManualDeductionsDataService.exportManualDeductionsCheckExcel(paramsMap);
        if (exportManualDeductionsCheckExcelList == null || exportManualDeductionsCheckExcelList.size() <= 0) {
            throw new GMException(GMExceptionConstant.FAILED_SAVE_UPDATE);
        }
        //更新 手动扣款统计 提交支付状态
        LeaseManualDeductionsStatist leaseManualDeductionsStatist = new LeaseManualDeductionsStatist();
        leaseManualDeductionsStatist.setIsCheck(1);//是否已下载核对 0否 1是
        leaseManualDeductionsStatist.setId((Long) paramsMap.get("statistId"));
        leaseManualDeductionsStatistService.updateByPrimaryKeySelective(leaseManualDeductionsStatist);
        return exportManualDeductionsCheckExcelList;
    }

    /**
     * 下载结果
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsPaymentResultExcel(Map<String, Object> paramsMap) throws GMException {
        List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsCheckExcelList = leaseManualDeductionsDataService.exportManualDeductionsCheckExcel(paramsMap);
        if (exportManualDeductionsCheckExcelList == null || exportManualDeductionsCheckExcelList.size() <= 0) {
            throw new GMException(GMExceptionConstant.FAILED_SAVE_UPDATE);
        }
        //更新 手动扣款统计 提交支付状态
        LeaseManualDeductionsStatist leaseManualDeductionsStatist = new LeaseManualDeductionsStatist();
        leaseManualDeductionsStatist.setIsDownloadResult(1);//是否已下载结果 0否 1是
        leaseManualDeductionsStatist.setId((Long) paramsMap.get("statistId"));
        leaseManualDeductionsStatistService.updateByPrimaryKeySelective(leaseManualDeductionsStatist);
        return exportManualDeductionsCheckExcelList;
    }

    /**
     * 手动扣款统计主键id 删除
     *
     * @param statistId
     * @return
     */
    @Override
    public int deleteByStatistId(Long statistId) {
        int row = leaseManualDeductionsDataService.deleteByStatistId(statistId);
        return row;
    }
}
