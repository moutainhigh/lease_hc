package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.service.api.LeaseAccountBankCardService;
import com.hc.lease.baseInfo.model.*;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.common.core.constant.*;
import com.hc.lease.common.core.excel.poi.vo.MonthlyRentReadInfo;
import com.hc.lease.common.core.excel.poi.vo.MonthlyRentTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.common.core.file.UploadFileUtil;
import com.hc.lease.order.adapter.api.LeaseContractAdapter;
import com.hc.lease.order.model.*;
import com.hc.lease.order.service.api.*;
import com.hc.lease.order.vo.*;
import com.hc.lease.postlending.model.LeaseAllinpayLog;
import com.hc.lease.postlending.model.LeaseAllinpaySplit;
import com.hc.lease.postlending.service.api.LeaseAllinpayLogService;
import com.hc.lease.supplier.model.*;
import com.hc.lease.supplier.service.api.*;
import com.hc.lease.supplier.vo.FindPageVo;
import hc.lease.common.util.AverageCapitalPlusInterestUtils;
import hc.lease.common.util.FileUtil;
import hc.lease.common.util.ListUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.hc.lease.common.core.constant.ContractStatus.STATUS_3;
import static com.hc.lease.common.core.constant.DictType.TYPE_SCHEMETYPE;
import static com.hc.lease.common.core.constant.DictType.TYPE_STAGING_NUMBER;

/**
 * 融租合同AdapterImpl
 *
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseContractAdapter")
public class LeaseContractAdapterImpl implements LeaseContractAdapter {

    @Autowired
    private LeaseContractService leaseContractService;
    @Autowired
    private LeaseCompanyHeaderService leaseCompanyHeaderService;
    @Autowired
    private LeaseSchemeService leaseSchemeService;
    @Autowired
    private LeaseDictService leaseDictService;
    @Autowired
    private LeaseArchiveLocationService leaseArchiveLocationService;
    @Autowired
    private LeaseContractArchiveLocationService leaseContractArchiveLocationService;
    @Autowired
    private LeaseSchemeOrderService leaseSchemeOrderService;
    @Autowired
    private LeasePackageService leasePackageService;
    @Autowired
    private LeaseSchemePackageService leaseSchemePackageService;
    @Autowired
    private LeaseSchemeOrderAccountService leaseSchemeOrderAccountService;
    @Autowired
    private LeaseSchemeRepaymentService leaseSchemeRepaymentService;
    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;
    @Autowired
    private LeaseRuleService leaseRuleService;
    @Autowired
    private LeaseContractBaseinfoService leaseContractBaseinfoService;
    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;
    @Autowired
    private LeaseCarBrandsService leaseCarBrandsService;
    @Autowired
    private LeaseCarSeriesService leaseCarSeriesService;
    @Autowired
    private LeaseCarModelService leaseCarModelService;
    @Autowired
    private LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService;
    @Autowired
    private LeaseAllinpayLogService leaseAllinpayLogService;
    @Autowired
    private LeaseContractBaseinfoUseService leaseContractBaseinfoUseService;
    @Autowired
    private LeasePackageBalancePaymentService leasePackageBalancePaymentService;

    @Autowired
    private LeaseUpdateMonthlyrentService leaseUpdateMonthlyrentService;
    @Autowired
    private LeaseAccountBankCardService leaseAccountBankCardService;
    @Autowired
    private LeaseAgentsService leaseAgentsService;
    @Autowired
    LeaseSchemeRepaymentStatusHService LeaseSchemeRepaymentStatusHService;
    @Autowired
    private LeaseSchemePriceService leaseSchemePriceService;
    @Autowired
    private LeaseSchemePriceStagesService leaseSchemePriceStagesService;
    @Autowired
    private LeaseSchemeContractService leaseSchemeContractService;

    @Value("${img.url}")
    String imgUrl;

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径根目录

    @Value("${order.img.fileImgFolder}")
    private String orderFileImgFolder;//图片存放文件夹路径
    @Value("${template.contract}")
    private String contractTemplate;
    @Value("${template.customer}")
    private String customerTemplate;
    @Value("${template.credit}")
    private String creditTemplate;
    @Value("${template.deduction}")
    private String deductionTemplate;
    @Value("${template.zhengQin}")
    private String zhengQinTemplate;
    @Value("${contract.address}")
    private String contractAddress;

    /**
     * 根据名称检测数据是否存在
     *
     * @param name
     * @return
     * @throws GMException
     */
    public boolean checkByNameIsExist(String name, Long id) throws GMException {
        boolean item = false;
        Map params = Maps.newHashMap();
        params.put("name", name);
        params.put("id", id);
        List<LeaseScheme> leaseSchemeList = leaseSchemeService.findByName(params);
        if (leaseSchemeList != null) {
            if (leaseSchemeList.size() > 0) {
                item = true;
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        return item;
    }


    /**
     * 检测数据是否存在
     *
     * @param paramsKey
     * @param paramsValue
     * @param id
     * @return
     * @throws GMException
     */
    public boolean checkByParams(String paramsKey, String paramsValue, Long id) throws GMException {
        boolean item = false;
        Map params = Maps.newHashMap();
        params.put(paramsKey, paramsValue);
        params.put("id", id);
        List<LeaseContract> leasContractList = leaseContractService.findByParams(params);
        if (leasContractList != null) {
            if (leasContractList.size() > 0) {
                item = true;
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        return item;
    }

    /**
     * 初始化编辑页面的参数
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {

        //List<LeaseDealer> leaseDealerList = leaseDealerService.findAll(null);
        List<FindPageVo> leaseDealerList = leaseAgentsService.findAllNoPage(null);
        List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderService.findAll(null);//公司抬头
        List<LeaseScheme> leaseSchemeList = leaseSchemeService.findAllNoPage();//方案
        List<LeaseDict> stagingNumbers = leaseDictService.findByType(TYPE_STAGING_NUMBER);//分期数
        List<LeaseDict> schemeTypes = leaseDictService.findByType(TYPE_SCHEMETYPE);//方案可选类型
        List<LeaseArchiveLocation> leaseArchiveLocationList = leaseArchiveLocationService.findAll(null);//归档位置
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(null);//分公司
        List<LeaseRule> leaseRuleList = leaseRuleService.findAll(null);//规则
        List<LeaseContractBaseinfo> leaseContractBaseinfoList = leaseContractBaseinfoService.findAllNoPage(null);//合同模板
        List<LeaseCarBrands> leaseCarBrandses = leaseCarBrandsService.findAll(null);//品牌
        List<LeaseCarSeries> leaseCarSeries = leaseCarSeriesService.findAll(null);//系列
        List<LeaseCarModel> leaseCarModels = leaseCarModelService.findAll(null);//车型
        List<LeaseAccountBankCard> leaseAccountBankCards = leaseAccountBankCardService.findAll(null);//承租人银行卡
        Map<String, Object> map = Maps.newHashMap();
        map.put("leaseDealerList", leaseDealerList);
        map.put("leaseCompanyHeaderList", leaseCompanyHeaderList);//公司抬头
        map.put("leaseSchemeList", leaseSchemeList);//方案
        map.put("stagingNumbers", stagingNumbers);//分期数
        map.put("schemeTypes", schemeTypes);//方案可选类型
        map.put("leaseArchiveLocationList", leaseArchiveLocationList);//归档位置
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);//分公司
        map.put("leaseRuleList", leaseRuleList);//规则
        map.put("leaseContractBaseinfoList", leaseContractBaseinfoList);//合同模板
        map.put("leaseCarBrandsList", leaseCarBrandses);//品牌
        map.put("leaseCarSerieList", leaseCarSeries);//系列
        map.put("leaseCarModelList", leaseCarModels);//车型
        map.put("leaseAccountBankCardList", leaseAccountBankCards);//承租人银行卡
        return map;
    }

    /**
     * 列表页面 需要的初始化参数
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public Map<String, Object> insertViewParamesListPage(Map<String, Object> paramsMap) throws GMException {
        Map<String, Object> map = Maps.newHashMap();
        List<LeaseCarBrands> leaseCarBrandses = leaseCarBrandsService.findAll(null);
        List<LeaseCarSeries> leaseCarSeries = leaseCarSeriesService.findAll(null);
        List<LeaseCarModel> leaseCarModels = leaseCarModelService.findAll(null);
        map.put("leaseCarBrandsList", leaseCarBrandses);
        map.put("leaseCarSerieList", leaseCarSeries);
        map.put("leaseCarModelList", leaseCarModels);
        return map;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {

        //判断合同状态是否可编辑
        LeaseContract contract = leaseContractService.selectByPrimaryKey(id);
        if (contract.getStatus() != STATUS_3) {
            throw new GMException(GMExceptionConstant.CONTRACT_UPDATE_FAILED, null);
        }

        LeaseContract leaseContract = leaseContractService.selectByPrimaryKey(id);
        //融租合同模板
        leaseContractBaseinfoUseService.deleteByPrimaryKey(leaseContract.getContractBaseinfoId());
        //融租订单
        leaseSchemeOrderService.deleteByPrimaryKey(leaseContract.getSchemeOrderId());
        //融租合同-承租人
        leaseSchemeOrderAccountService.deleteBySchemeOrderId(leaseContract.getSchemeOrderId());
        //融租合同
        int row = leaseContractService.deleteByPrimaryKey(id);
        //归档信息
        leaseContractArchiveLocationService.deleteByContractId(id);

        //月租还款计划明细
        leaseSchemeRepaymentService.deleteByContractId(id);
        //支付状态汇总管理
        leaseSchemeRepaymentStatusService.deleteByContractId(id);
        //通联代收流水
        leaseAllinpayLogService.deleteByContractId(id);

        leaseUseUsedService.deleteByUse(id, UseType.TYPE_LEASE_CONTRACT);

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
        int row = leaseContractService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContract record) throws GMException {
        record = leaseContractService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContract record) throws GMException {
        record = leaseContractService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 新增
     *
     * @param record
     * @return
     * @throws GMException
     */
    public ResultHashMap insertSelectives(LeaseContractOrder record) throws GMException {

        StringBuffer number = new StringBuffer(record.getContractNumberYear());
        number.append(record.getContractNumber());
        //检测合同编号是否存在
        boolean contractNumberIsExist = checkByParams("contractNumber", number.toString(), record.getId());
        if (contractNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "contractNumberYear");
            backMap.put("key", "contractNumber");
            throw new GMException(GMExceptionConstant.CONTRACTNUMBER_REPEAT, backMap);
        }

        //融租方案
        LeaseScheme leaseScheme = new LeaseScheme();
        if (record.getSchemeName() != null && !"".equals(record.getSchemeName())) {
            boolean bool = checkByNameIsExist(record.getSchemeName(), null);
            if (bool) {
                throw new GMException(GMExceptionConstant.SCHEME_NAME_REPEAT);
            }
            leaseScheme.setSchemeName(record.getSchemeName());
            leaseScheme.setSchemeType(record.getSchemeType());
            leaseScheme.setAnnualInterest(record.getAnnualInterest());
            leaseScheme.setCreateBy(record.getCreateBy());
            leaseScheme.setBrandsId(record.getBrandsId());
            leaseScheme.setSeriesId(record.getSeriesId());
            leaseScheme.setModelId(record.getModelId());
            leaseScheme.setTotalAmount(record.getTotalAmount());
            leaseScheme.setIsType(record.getIsType());
            leaseScheme = leaseSchemeService.insertSelective(leaseScheme);

            LeasePackage leasePackage = new LeasePackage();
            leasePackage.setStagingContainMonthlyRent(record.getStagingContainMonthlyRent());
            leasePackage.setType(1);
            leasePackage.setBalancePayment(record.getBalancePayment());
            leasePackage.setDownPayment(record.getDownPayment());
            leasePackage.setStagingNumberId(record.getStagingNumberId());
            leasePackage.setMonthlyRent(record.getMonthlyRent());
            leasePackage = leasePackageService.insertSelective(leasePackage);

            LeaseSchemePackage leaseSchemePackage = new LeaseSchemePackage();
            leaseSchemePackage.setSchemeId(leaseScheme.getId());
            leaseSchemePackage.setPackageId(leasePackage.getId());
            leaseSchemePackageService.insertSelective(leaseSchemePackage);

            //融租方案-尾款
            if (record.getLeasePackageBalancePayments().size() > 0) {
                List<LeasePackageBalancePayment> leasePackageBalancePayments = record.getLeasePackageBalancePayments();
                for (LeasePackageBalancePayment leasePackageBalancePayment : leasePackageBalancePayments) {
                    leasePackageBalancePayment.setCreateBy(record.getCreateBy());
                    leasePackageBalancePayment.setPackageId(leasePackage.getId());
                    leasePackageBalancePayment.setSchemeId(leaseScheme.getId());
                    leasePackageBalancePayment.setIsType(record.getIsType());
                    leasePackageBalancePaymentService.insertSelective(leasePackageBalancePayment);
                }
            }
            //融租方案-尾款

        }
        //融租方案

        Calendar calendar = Calendar.getInstance();
        Integer payDate = null;
        if (record.getRepaymentDate() != null) {
            calendar.setTime(record.getRepaymentDate());
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DAY_OF_MONTH));
            payDate = calendar.get(Calendar.DAY_OF_MONTH);
            /*if (day > 0 && day <= 10) {
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 5);
                payDate = 5;
            } else if (day >= 11 && day <= 20) {
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 15);
                payDate = 15;
            } else {
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 25);
                payDate = 25;
            }*/
        }

        //融租订单
        LeaseSchemeOrder leaseSchemeOrder = new LeaseSchemeOrder();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = sdf.format(date);

        leaseSchemeOrder.setCardId(record.getCardId());
        leaseSchemeOrder.setCarPrice(record.getCarPrice());
        leaseSchemeOrder.setContractPartyId(record.getContractPartyId());
        leaseSchemeOrder.setSn(str);
        leaseSchemeOrder.setLeasePrice(record.getLeasePrice());
        leaseSchemeOrder.setTotleCarPrice(record.getTotleCarPrice());
        leaseSchemeOrder.setComprehensiveQuote(record.getComprehensiveQuote().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setCommission(record.getCommission().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setReceiveMargin(record.getReceiveMargin().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setStatus(0);
        leaseSchemeOrder.setCreateBy(record.getCreateBy());
        leaseSchemeOrder.setPayDate(payDate);
        leaseSchemeOrder.setContractBrandsId(record.getContractBrandsId());
        leaseSchemeOrder.setContractSeriesId(record.getContractSeriesId());
        leaseSchemeOrder.setContractModelId(record.getContractModelId());

        if (leaseScheme.getId() != null) {
            leaseSchemeOrder.setSchemeId(leaseScheme.getId());
        } else {
            leaseSchemeOrder.setSchemeId(record.getSchemeId());
        }


        LeaseSchemePackage leaseSchemePackage = leaseSchemePackageService.selectBySchemeId(leaseSchemeOrder.getSchemeId());
        LeaseScheme leaseSchemeInterest = leaseSchemeService.selectByPrimaryKey(leaseSchemeOrder.getSchemeId());
        LeasePackage leasePackage = leasePackageService.selectByPrimaryKey(leaseSchemePackage.getPackageId());
        LeaseDict leaseDict = leaseDictService.selectByPrimaryKey(leasePackage.getStagingNumberId().longValue());
        Integer period = Integer.valueOf(leaseDict.getValue());

        BigDecimal price = new BigDecimal(0);
        double perMonthPrincipalInterest = 0;
        Map<Integer, BigDecimal> mapPrincipal = null;
        Map<Integer, BigDecimal> mapInterest = null;

        if (leaseSchemeInterest.getIsType() == 1) {
            LeasePackageBalancePayment leasePackageBalancePayment = leasePackageBalancePaymentService.selectBySchemeId(leaseSchemeOrder.getSchemeId());
            price = record.getComprehensiveQuote().setScale(2, BigDecimal.ROUND_HALF_UP).subtract(leasePackage.getDownPayment()).subtract(leasePackageBalancePayment.getBalancePayment());
            perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterestAndBalancePayment(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
            //System.out.println("等额本息---每月还款本息：" + perMonthPrincipalInterest);
            mapPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
            mapInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
            System.out.println("等额本息---每月还款利息：" + mapInterest);
        }
        //融租合同-还款

        if (leaseSchemeInterest.getIsType() == 2) {
            leaseSchemeOrder.setMonthlyRent(leasePackage.getMonthlyRent().setScale(2, BigDecimal.ROUND_HALF_UP));
            leaseSchemeOrder.setLeasePrice(leaseSchemeInterest.getTotalAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
        } else {
            LeasePackageBalancePayment leasePackageBalancePayment = leasePackageBalancePaymentService.selectBySchemeId(leaseSchemeOrder.getSchemeId());
            BigDecimal monthlyRent = new BigDecimal(perMonthPrincipalInterest);
            leaseSchemeOrder.setMonthlyRent(monthlyRent);
            BigDecimal leasePrice = monthlyRent.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(leaseDict.getValue())).add(leasePackageBalancePayment.getBalancePayment()).add(leasePackage.getDownPayment());
            leaseSchemeOrder.setLeasePrice(leasePrice);
        }
        leaseSchemeOrder.setPeriodCount(period);//分期数
        leaseSchemeOrder = leaseSchemeOrderService.insertSelective(leaseSchemeOrder);
        //融租合同模板
        LeaseContractBaseinfoUse _leaseBaseinfoUse = addLeaseContractBaseinfoUse(record);
        //新增/插入合同数据
        LeaseContract leaseContract = addLeaseContract(record, leaseSchemeOrder, _leaseBaseinfoUse);
        //融租方案-承租人
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList = record.getLeaseSchemeOrderAccounts();
        Long lesseeId = null;
        if (leaseSchemeOrderAccountList.size() > 0) {
            for (LeaseSchemeOrderAccount leaseSchemeOrderAccount : leaseSchemeOrderAccountList) {
                if (leaseSchemeOrderAccount.getIsDefaultPay() == 1) {
                    lesseeId = leaseSchemeOrderAccount.getAccountId();
                }
                leaseSchemeOrderAccount.setSchemeOrderId(leaseSchemeOrder.getId());
                leaseSchemeOrderAccountService.insertSelective(leaseSchemeOrderAccount);
                leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseSchemeOrderAccount.getAccountId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_ACCOUNT);
            }
        }

        //归档位置
        List<LeaseContractArchiveLocation> contractArchiveLocations = record.getLeaseContractArchiveLocationList();
        if (contractArchiveLocations.size() > 0) {
            for (LeaseContractArchiveLocation contractArchiveLocation : contractArchiveLocations) {
                contractArchiveLocation.setContractId(leaseContract.getId());
                leaseContractArchiveLocationService.insertSelective(contractArchiveLocation);
                leaseCommonService.insertUseUsed(leaseContract.getId(), null, contractArchiveLocation.getArchiveLocationId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_ARCHIVELOCATION);
            }
        }

        //处理还款计划表
        addLeaseSchemeRepayment(price, record, leaseDict, leaseContract, leaseSchemeInterest, lesseeId, mapPrincipal, mapInterest, perMonthPrincipalInterest, calendar, leaseSchemeOrder, null, "add");

        leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseContract.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseSchemeOrder.getCardId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_CAR);
        leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseSchemeOrder.getSchemeId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_SCHENE);
        leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseContract.getContractBaseinfoId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_CONTRACTBASEINFO);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;

    }

    /**
     * 修改
     *
     * @param record
     * @return
     * @throws GMException
     */
    public int updateByPrimaryKeySelectives(LeaseContractOrder record) throws GMException {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("contractId", record.getId());

        //合同是否存在还款中的还款计划
        Boolean isPaying = leaseSchemeRepaymentStatusService.findContractPayStatusByContractId(paramsMap);
        if (isPaying) {
            throw new GMException(GMExceptionConstant.CONTRACT_IS_PAYING, null);
        }

        //判断合同状态是否可编辑
        LeaseContract contract = leaseContractService.selectByPrimaryKey(record.getId());
        /* if (contract.getStatus() != STATUS_3) {
            throw new GMException(GMExceptionConstant.CONTRACT_UPDATE_FAILED, null);
        }*/

        StringBuffer number = new StringBuffer(record.getContractNumberYear());
        number.append(record.getContractNumber());
        //检测合同编号是否存在
        boolean contractNumberIsExist = checkByParams("contractNumber", number.toString(), record.getId());
        if (contractNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "contractNumberYear");
            backMap.put("key", "contractNumber");
            throw new GMException(GMExceptionConstant.CONTRACTNUMBER_REPEAT, backMap);
        }

        //先删除leaseUser新增的的数据
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CONTRACT);

        //融租方案
        LeaseScheme leaseScheme = new LeaseScheme();
        //定制的方案
        if (record.getSchemeName() != null && !"".equals(record.getSchemeName())) {
            boolean bool = checkByNameIsExist(record.getSchemeName(), record.getSchemeId());
            if (bool) {
                throw new GMException(GMExceptionConstant.SCHEME_NAME_REPEAT);
            }

            LeaseSchemePackage leaseSchemePackageOld = leaseSchemePackageService.selectBySchemeId(record.getSchemeId());
            LeasePackage leasePackageOld = leasePackageService.selectByPrimaryKey(leaseSchemePackageOld.getPackageId());

            leaseScheme.setSchemeName(record.getSchemeName());
            leaseScheme.setSchemeType(record.getSchemeType());
            leaseScheme.setAnnualInterest(record.getAnnualInterest());
            leaseScheme.setCreateBy(record.getUpdateBy());
            leaseScheme.setBrandsId(record.getBrandsId());
            leaseScheme.setSeriesId(record.getSeriesId());
            leaseScheme.setModelId(record.getModelId());
            leaseScheme.setTotalAmount(record.getTotalAmount());
            leaseScheme.setIsType(record.getIsType());
            //判断是否为定制方案 如定制方案则删除
            if (leasePackageOld.getType() == 1) {
                leaseSchemePackageService.deleteByPrimaryKey(leaseSchemePackageOld.getId());
                leasePackageService.deleteByPrimaryKey(leasePackageOld.getId());
                leaseSchemeService.deleteByPrimaryKey(record.getSchemeId());
                leasePackageBalancePaymentService.deleteByPackageId(leasePackageOld.getId());
            }
            leaseScheme = leaseSchemeService.insertSelective(leaseScheme);

            LeasePackage leasePackage = new LeasePackage();
            leasePackage.setStagingContainMonthlyRent(record.getStagingContainMonthlyRent());
            leasePackage.setType(1);
            leasePackage.setBalancePayment(record.getBalancePayment());
            leasePackage.setDownPayment(record.getDownPayment());
            leasePackage.setStagingNumberId(record.getStagingNumberId());
            leasePackage.setMonthlyRent(record.getMonthlyRent());
            leasePackage = leasePackageService.insertSelective(leasePackage);

            LeaseSchemePackage leaseSchemePackage = new LeaseSchemePackage();
            leaseSchemePackage.setSchemeId(leaseScheme.getId());
            leaseSchemePackage.setPackageId(leasePackage.getId());
            leaseSchemePackageService.insertSelective(leaseSchemePackage);

            if (record.getLeasePackageBalancePayments().size() > 0) {
                List<LeasePackageBalancePayment> leasePackageBalancePayments = record.getLeasePackageBalancePayments();
                for (LeasePackageBalancePayment leasePackageBalancePayment : leasePackageBalancePayments) {
                    leasePackageBalancePayment.setCreateBy(record.getCreateBy());
                    leasePackageBalancePayment.setPackageId(leasePackage.getId());
                    leasePackageBalancePayment.setSchemeId(leaseScheme.getId());
                    leasePackageBalancePayment.setIsType(record.getIsType());
                    leasePackageBalancePaymentService.insertSelective(leasePackageBalancePayment);
                }
            }
        }
        //定制的方案

        Calendar calendar = Calendar.getInstance();
        Integer payDate = null;

        if (record.getRepaymentDate() != null) {
            calendar.setTime(record.getRepaymentDate());
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DAY_OF_MONTH));
            payDate = calendar.get(Calendar.DAY_OF_MONTH);
           /* if (day > 0 && day <= 10) {
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 5);
                payDate = 5;
            } else if (day >= 11 && day <= 20) {
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 15);
                payDate = 15;
            } else {
                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 25);
                payDate = 25;
            }*/
        }

        //融租订单
        LeaseSchemeOrder leaseSchemeOrder = new LeaseSchemeOrder();
        leaseSchemeOrder.setId(record.getSchemeOrderId());
        leaseSchemeOrder.setCardId(record.getCardId());
        leaseSchemeOrder.setCarPrice(record.getCarPrice());
        leaseSchemeOrder.setContractPartyId(record.getContractPartyId());
        leaseSchemeOrder.setLeasePrice(record.getLeasePrice());
        leaseSchemeOrder.setTotleCarPrice(record.getTotleCarPrice());
        leaseSchemeOrder.setComprehensiveQuote(record.getComprehensiveQuote().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setCommission(record.getCommission().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setReceiveMargin(record.getReceiveMargin().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setStatus(0);
        leaseSchemeOrder.setUpdateBy(record.getUpdateBy());
        leaseSchemeOrder.setPayDate(payDate);
        leaseSchemeOrder.setContractBrandsId(record.getContractBrandsId());
        leaseSchemeOrder.setContractSeriesId(record.getContractSeriesId());
        leaseSchemeOrder.setContractModelId(record.getContractModelId());
        if (leaseScheme.getId() == null) {//不是定制的方案
            leaseSchemeOrder.setSchemeId(record.getSchemeId());
        } else {
            leaseSchemeOrder.setSchemeId(leaseScheme.getId());
        }

        LeaseSchemePackage leaseSchemePackage = leaseSchemePackageService.selectBySchemeId(leaseSchemeOrder.getSchemeId());
        LeaseScheme leaseSchemeInterest = leaseSchemeService.selectByPrimaryKey(leaseSchemeOrder.getSchemeId());
        LeasePackage leasePackage = leasePackageService.selectByPrimaryKey(leaseSchemePackage.getPackageId());
        LeaseDict leaseDict = leaseDictService.selectByPrimaryKey(leasePackage.getStagingNumberId().longValue());
        Integer period = Integer.valueOf(leaseDict.getValue());
        //融租合同-还款


        BigDecimal price = new BigDecimal(0);
        double perMonthPrincipalInterest = 0;
        Map<Integer, BigDecimal> mapPrincipal = null;
        Map<Integer, BigDecimal> mapInterest = null;

        if (leaseSchemeInterest.getIsType() == 1) {
            LeasePackageBalancePayment leasePackageBalancePayment = leasePackageBalancePaymentService.selectBySchemeId(leaseSchemeOrder.getSchemeId());
            price = record.getComprehensiveQuote().setScale(2, BigDecimal.ROUND_HALF_UP).subtract(leasePackage.getDownPayment()).subtract(leasePackageBalancePayment.getBalancePayment());
            perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterestAndBalancePayment(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
            //System.out.println("等额本息---每月还款本息：" + perMonthPrincipalInterest);
            mapPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
            mapInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
            System.out.println("等额本息---每月还款利息：" + mapInterest);
        }
        //融租合同-还款

        if (leaseSchemeInterest.getIsType() == 2) {
            leaseSchemeOrder.setMonthlyRent(leasePackage.getMonthlyRent().setScale(2, BigDecimal.ROUND_HALF_UP));
            leaseSchemeOrder.setLeasePrice(leaseSchemeInterest.getTotalAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
        } else {
            LeasePackageBalancePayment leasePackageBalancePayment = leasePackageBalancePaymentService.selectBySchemeId(leaseSchemeOrder.getSchemeId());
            BigDecimal monthlyRent = new BigDecimal(perMonthPrincipalInterest);
            leaseSchemeOrder.setMonthlyRent(monthlyRent);
            BigDecimal leasePrice = monthlyRent.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(leaseDict.getValue())).add(leasePackageBalancePayment.getBalancePayment()).add(leasePackage.getDownPayment());
            leaseSchemeOrder.setLeasePrice(leasePrice);
        }
        leaseSchemeOrder.setPeriodCount(period);//分期数
        leaseSchemeOrderService.updateByPrimaryKeySelective(leaseSchemeOrder);

        addLeaseContractBaseinfoUse(record);//处理融租合同模板
        record.setVsersionNumber(contract.getVsersionNumber() + 1);//每次修改数据版本号递增
        LeaseContract leaseContract = updateLeaseContract(record);//处理合同修改

        //融租方案-承租人
        leaseSchemeOrderAccountService.deleteBySchemeOrderId(leaseSchemeOrder.getId());
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList = record.getLeaseSchemeOrderAccounts();
        Long lesseeId = null;
        if (leaseSchemeOrderAccountList.size() > 0) {
            for (LeaseSchemeOrderAccount leaseSchemeOrderAccount : leaseSchemeOrderAccountList) {
                if (leaseSchemeOrderAccount.getIsDefaultPay() == 1) {
                    lesseeId = leaseSchemeOrderAccount.getAccountId();
                }
                leaseSchemeOrderAccount.setSchemeOrderId(leaseSchemeOrder.getId());
                leaseSchemeOrderAccountService.insertSelective(leaseSchemeOrderAccount);
                leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseSchemeOrderAccount.getAccountId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_ACCOUNT);
            }
        }

        //归档位置
        int row = 0;
        row = leaseContractArchiveLocationService.deleteByContractId(leaseContract.getId());
        List<LeaseContractArchiveLocation> contractArchiveLocations = record.getLeaseContractArchiveLocationList();
        if (contractArchiveLocations.size() > 0) {
            for (LeaseContractArchiveLocation contractArchiveLocation : contractArchiveLocations) {
                contractArchiveLocation.setContractId(leaseContract.getId());
                leaseContractArchiveLocationService.insertSelective(contractArchiveLocation);
                leaseCommonService.insertUseUsed(leaseContract.getId(), null, contractArchiveLocation.getArchiveLocationId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_ARCHIVELOCATION);
            }
        }


        //合同修改时 查询合同原还款历史的还款状态

        paramsMap.put("createBy", record.getUpdateBy());
        paramsMap.put("updateBy", record.getUpdateBy());
        paramsMap.put("vsersionNumber", contract.getVsersionNumber());
        leaseSchemeRepaymentService.backData(paramsMap);//备份还款计划明细到历史表
        leaseSchemeRepaymentStatusService.backData(paramsMap);//备份支付状态汇总管理到历史表

        leaseSchemeRepaymentService.deleteByContractId(record.getId());//删除还款计划明细
        leaseSchemeRepaymentStatusService.deleteByContractId(record.getId());//删除支付状态汇总管理

        //查询还款计划历史
        List<FindByContractIdAndPeriodVo> findByContractIdAndPeriodVoList = LeaseSchemeRepaymentStatusHService.findByContractIdAndPeriod(paramsMap);

        //生成还款计划表
        addLeaseSchemeRepayment(price, record, leaseDict, leaseContract, leaseSchemeInterest, lesseeId, mapPrincipal, mapInterest, perMonthPrincipalInterest, calendar, leaseSchemeOrder, findByContractIdAndPeriodVoList, "update");

        //更新通联代收流水
        LeaseAllinpayLog leaseAllinpayLog = new LeaseAllinpayLog();
        leaseAllinpayLog.setContractId(record.getId());
        leaseAllinpayLog.setUpdateType(1);//0:合同未作修改 ; 1:合同已作修改
        leaseAllinpayLogService.updateByContractId(leaseAllinpayLog);
        //更新通联代收流水

        //更新拆分后的每笔交易明细
        LeaseAllinpaySplit leaseAllinpaySplit = new LeaseAllinpaySplit();
        leaseAllinpaySplit.setContractId(record.getId());
        leaseAllinpaySplit.setUpdateType(1);//0:合同未作修改 ; 1:合同已作修改
        leaseAllinpayLogService.updateByContractId(leaseAllinpayLog);
        //更新拆分后的每笔交易明细

        leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseContract.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseSchemeOrder.getCardId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_CAR);
        leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseSchemeOrder.getSchemeId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_SCHENE);
        leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseContract.getContractBaseinfoId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_CONTRACTBASEINFO);


        return row;
    }

    /**
     * 处理合同修改
     *
     * @param record
     * @return
     * @throws GMException
     */
    private LeaseContract updateLeaseContract(LeaseContractOrder record) throws GMException {
        LeaseContract leaseContract = new LeaseContract();
        leaseContract.setId(record.getId());
        leaseContract.setAccountContactAdress(record.getAccountContactAdress());
        leaseContract.setBranchCompanyId(record.getBranchCompanyId());
        leaseContract.setContractKey(record.getContractKey());
        leaseContract.setContractNumber(record.getContractNumber());
        leaseContract.setContractNumberYear(record.getContractNumberYear());
        leaseContract.setContractBaseinfoId(record.getContractBaseinfoId());
        leaseContract.setGuaranteeContact(record.getGuaranteeContact());
        leaseContract.setGuaranteeContactName(record.getGuaranteeContactName());
        leaseContract.setGuaranteeContactPhone(record.getGuaranteeContactPhone());
        leaseContract.setGuaranteeIdCard(record.getGuaranteeIdCard());
        leaseContract.setGuaranteeName(record.getGuaranteeName());
        leaseContract.setGuaranteeZipCode(record.getGuaranteeZipCode());
        leaseContract.setLeaseEndTime(record.getLeaseEndTime());
        leaseContract.setLeaseStartTime(record.getLeaseStartTime());
        leaseContract.setSaleChannelId(record.getSaleChannelId());
        leaseContract.setSaleChannelType(record.getSaleChannelType());
        leaseContract.setGuaranteeContactAddress(record.getGuaranteeContactAddress());
        leaseContract.setThirdPartyLiabilityInsurance(record.getThirdPartyLiabilityInsurance());
        leaseContract.setStatus(STATUS_3);
        leaseContract.setCompleteContractNumber(record.getCompleteContractNumber());
        leaseContract.setUpdateBy(record.getUpdateBy());
        leaseContract.setContractType(record.getContractType());
        leaseContract.setVsersionNumber(record.getVsersionNumber());
        //String filePath = uploadService.base64UploadFile(record.getCardCheckAcceptImg(),FileUtil.IMAGE_EXTENSION);
        if (record.getCardCheckAcceptImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getCardCheckAcceptImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, orderFileImgFolder, imgUrl);
            leaseContract.setCardCheckAcceptImg(filePath);
        }
        if (record.getIdCardImg() != null) {
            String idCard = UploadFileUtil.base64UploadFile(record.getIdCardImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, orderFileImgFolder, imgUrl);
            leaseContract.setIdCardImg(idCard);
        }
        if (record.getCarAcceptImg() != null) {
            String carAccept = UploadFileUtil.base64UploadFile(record.getCarAcceptImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, orderFileImgFolder, imgUrl);
            leaseContract.setCarAcceptImg(carAccept);

        }
        leaseContractService.updateByPrimaryKeySelective(leaseContract);
        return leaseContract;
    }


    /**
     * 贷后直租合同改期数 生成还款计划表
     *
     * @param contractManagerAddLeaseSchemeRepaymentVo
     * @throws GMException
     */
    private void updateContractPeriodAddLeaseSchemeRepayment(ContractManagerAddLeaseSchemeRepaymentVo contractManagerAddLeaseSchemeRepaymentVo) throws GMException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal residualPrincipal = contractManagerAddLeaseSchemeRepaymentVo.getPrice();
        Date nowDate = DateTime.now().toDate();

        //标准合同
        if (contractManagerAddLeaseSchemeRepaymentVo.getLeaseStartTime() != null) {
            Integer period = contractManagerAddLeaseSchemeRepaymentVo.getPeriod();
            if (period != 0) {
                for (int i = 1; i <= period; i++) {
                    LeaseSchemeRepayment leaseSchemeRepayment = new LeaseSchemeRepayment();
                    //归还本金
                    leaseSchemeRepayment.setReturnPrincipal(contractManagerAddLeaseSchemeRepaymentVo.getMapPrincipal().get(i));
                    //归还利息
                    leaseSchemeRepayment.setReturnInterest(contractManagerAddLeaseSchemeRepaymentVo.getMapInterest().get(i));
                    //合计
                    BigDecimal total = new BigDecimal(contractManagerAddLeaseSchemeRepaymentVo.getPerMonthPrincipalInterest());
                    leaseSchemeRepayment.setTotal(total);
                    //剩余本金
                    residualPrincipal = residualPrincipal.subtract(contractManagerAddLeaseSchemeRepaymentVo.getMapPrincipal().get(i));
                    leaseSchemeRepayment.setResidualPrincipal(residualPrincipal);
                    contractManagerAddLeaseSchemeRepaymentVo.getCalendar().add(Calendar.MONTH, 1);
                    Date time = contractManagerAddLeaseSchemeRepaymentVo.getCalendar().getTime();
                    try {
                        leaseSchemeRepayment.setRepaymentDate(sd.parse(sd.format(time)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    leaseSchemeRepayment = updateContractPeriodAddSchemeRepaymentMonth(i, nowDate, leaseSchemeRepayment, contractManagerAddLeaseSchemeRepaymentVo);
                    //插入 支付状态汇总管理 月供数据
                    updateContractPeriodAddSchemeRepaymentStatusMonth(nowDate, leaseSchemeRepayment, total, contractManagerAddLeaseSchemeRepaymentVo);
                }
            }
        } else if (contractManagerAddLeaseSchemeRepaymentVo.getLeaseStartTime() == null) {
            Integer period = contractManagerAddLeaseSchemeRepaymentVo.getPeriod();
            if (period != 0) {
                for (int i = 1; i <= period; i++) {
                    LeaseSchemeRepayment leaseSchemeRepayment = new LeaseSchemeRepayment();
                    //归还本金
                    leaseSchemeRepayment.setReturnPrincipal(contractManagerAddLeaseSchemeRepaymentVo.getMapPrincipal().get(i));
                    //归还利息
                    leaseSchemeRepayment.setReturnInterest(contractManagerAddLeaseSchemeRepaymentVo.getMapInterest().get(i));
                    //合计
                    BigDecimal total = new BigDecimal(contractManagerAddLeaseSchemeRepaymentVo.getPerMonthPrincipalInterest());
                    leaseSchemeRepayment.setTotal(total);
                    //剩余本金
                    residualPrincipal = residualPrincipal.subtract(contractManagerAddLeaseSchemeRepaymentVo.getMapPrincipal().get(i));
                    leaseSchemeRepayment.setResidualPrincipal(residualPrincipal);

                    leaseSchemeRepayment = updateContractPeriodAddSchemeRepaymentMonth(i, nowDate, leaseSchemeRepayment, contractManagerAddLeaseSchemeRepaymentVo);
                    //插入 支付状态汇总管理 月供数据
                    updateContractPeriodAddSchemeRepaymentStatusMonth(nowDate, leaseSchemeRepayment, total, contractManagerAddLeaseSchemeRepaymentVo);
                }
            }
        }
    }

    /**
     * 插入 支付状态汇总管理 月供数据
     *
     * @param i
     * @param nowDate
     * @param leaseSchemeRepayment
     * @param contractManagerAddLeaseSchemeRepaymentVo
     * @return
     * @throws GMException
     */
    private LeaseSchemeRepayment updateContractPeriodAddSchemeRepaymentMonth(Integer i, Date nowDate, LeaseSchemeRepayment leaseSchemeRepayment, ContractManagerAddLeaseSchemeRepaymentVo contractManagerAddLeaseSchemeRepaymentVo
    ) throws GMException {
        leaseSchemeRepayment.setPeriod(i);
        leaseSchemeRepayment.setLoanAmount(contractManagerAddLeaseSchemeRepaymentVo.getComprehensiveQuote());
        leaseSchemeRepayment.setContractId(contractManagerAddLeaseSchemeRepaymentVo.getContractId());
        leaseSchemeRepayment.setAnnualInterest(contractManagerAddLeaseSchemeRepaymentVo.getAnnualInterest());
        leaseSchemeRepayment.setLesseeId(contractManagerAddLeaseSchemeRepaymentVo.getLesseeId());
        leaseSchemeRepayment.setCreateTime(nowDate);
        leaseSchemeRepayment.setUpdateTime(nowDate);
        leaseSchemeRepayment.setCreateBy(contractManagerAddLeaseSchemeRepaymentVo.getCreateBy());
        leaseSchemeRepayment.setUpdateBy(contractManagerAddLeaseSchemeRepaymentVo.getUpdateBy());
        leaseSchemeRepayment = leaseSchemeRepaymentService.insertSelective(leaseSchemeRepayment);
        //插入 还款记录 数据
        return leaseSchemeRepayment;
    }

    /**
     * 插入 支付状态汇总管理 月供数据
     *
     * @param nowDate
     * @param leaseSchemeRepayment
     * @param total
     * @param contractManagerAddLeaseSchemeRepaymentVo
     * @return
     * @throws GMException
     */
    private LeaseSchemeRepaymentStatus updateContractPeriodAddSchemeRepaymentStatusMonth(Date nowDate, LeaseSchemeRepayment leaseSchemeRepayment, BigDecimal total, ContractManagerAddLeaseSchemeRepaymentVo contractManagerAddLeaseSchemeRepaymentVo
    ) throws GMException {

        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
        leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_0);
        leaseSchemeRepaymentStatus.setPayWay(PayWay.DEFUAL);

        //插入 支付状态汇总管理 月供数据
        leaseSchemeRepaymentStatus.setRepaymentId(leaseSchemeRepayment.getId());
        leaseSchemeRepaymentStatus.setContractId(contractManagerAddLeaseSchemeRepaymentVo.getContractId());
        leaseSchemeRepaymentStatus.setCreateTime(nowDate);
        leaseSchemeRepaymentStatus.setUpdateTime(nowDate);
        leaseSchemeRepaymentStatus.setCreateBy(contractManagerAddLeaseSchemeRepaymentVo.getCreateBy());
        leaseSchemeRepaymentStatus.setUpdateBy(contractManagerAddLeaseSchemeRepaymentVo.getUpdateBy());
        leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_0);
        leaseSchemeRepaymentStatus.setTotlePrice(total);
        leaseSchemeRepaymentStatusService.insertSelective(leaseSchemeRepaymentStatus);
        //插入 支付状态汇总管理 月供数据
        return leaseSchemeRepaymentStatus;
    }

    /**
     * 生成还款计划表
     *
     * @param price
     * @param record
     * @param leaseDict
     * @param leaseContract
     * @param leaseSchemeInterest
     * @param lesseeId
     * @param mapPrincipal
     * @param mapInterest                     等额本息---每月还款利息
     * @param perMonthPrincipalInterest
     * @param calendar
     * @param leaseSchemeOrder
     * @param findByContractIdAndPeriodVoList 修改合同则存在此部分数据
     * @param type                            操作类型 update修改;add新增
     * @throws GMException
     */
    private void addLeaseSchemeRepayment(BigDecimal price, LeaseContractOrder record, LeaseDict leaseDict, LeaseContract leaseContract
            , LeaseScheme leaseSchemeInterest, Long lesseeId, Map<Integer, BigDecimal> mapPrincipal, Map<Integer, BigDecimal> mapInterest
            , double perMonthPrincipalInterest, Calendar calendar, LeaseSchemeOrder leaseSchemeOrder, List<FindByContractIdAndPeriodVo> findByContractIdAndPeriodVoList
            , String type
    ) throws GMException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal residualPrincipal = new BigDecimal(price.doubleValue());
        Date nowDate = DateTime.now().toDate();

        //方案的所有尾款
        List<LeasePackageBalancePayment> leasePackageBalancePaymentList = leasePackageBalancePaymentService.findBySchemeId(leaseSchemeOrder.getSchemeId());

        //标准合同
        if (record.getLeaseStartTime() != null && leaseSchemeInterest.getIsType() == 1) {
            Integer period = Integer.valueOf(leaseDict.getValue());
            if (period != 0) {
                for (int i = 1; i <= period; i++) {
                    LeaseSchemeRepayment leaseSchemeRepayment = new LeaseSchemeRepayment();
                    //归还本金
                    leaseSchemeRepayment.setReturnPrincipal(mapPrincipal.get(i));
                    //归还利息
                    leaseSchemeRepayment.setReturnInterest(mapInterest.get(i));
                    //合计
                    BigDecimal total = new BigDecimal(perMonthPrincipalInterest);
                    leaseSchemeRepayment.setTotal(total);
                    //剩余本金
                    residualPrincipal = residualPrincipal.subtract(mapPrincipal.get(i));
                    leaseSchemeRepayment.setResidualPrincipal(residualPrincipal);
                    calendar.add(Calendar.MONTH, 1);
                    Date time = calendar.getTime();
                    try {
                        leaseSchemeRepayment.setRepaymentDate(sd.parse(sd.format(time)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    leaseSchemeRepayment = addSchemeRepaymentMonth(leaseSchemeInterest, lesseeId, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList, type);
                    //插入 支付状态汇总管理 月供数据
                    addSchemeRepaymentStatusMonth(leaseSchemeInterest, lesseeId, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList, type, total);
                    //插入 支付状态汇总管理 尾款数据
                    addSchemeRepaymentStatusBalancePayment(leasePackageBalancePaymentList, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                    if (type.equals("update")) {//修改操作
                        //插入 支付状态汇总管理 逾期数据
                        //addSchemeRepaymentStatusOverdue(i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                        //插入 支付状态汇总管理 其他金额数据
                        addSchemeRepaymentStatusOther(i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                    }
                }
            }
        } else if (record.getLeaseStartTime() != null && leaseSchemeInterest.getIsType() == 2) {//准合同
            Integer period = Integer.valueOf(leaseDict.getValue());
            if (period != 0) {
                for (int i = 1; i <= period; i++) {
                    LeaseSchemeRepayment leaseSchemeRepayment = new LeaseSchemeRepayment();
                    //归还本金
                    leaseSchemeRepayment.setReturnPrincipal(new BigDecimal(0));
                    //归还利息
                    leaseSchemeRepayment.setReturnInterest(new BigDecimal(0));
                    //合计
                    BigDecimal total = new BigDecimal(perMonthPrincipalInterest);
                    leaseSchemeRepayment.setTotal(leaseSchemeOrder.getMonthlyRent());
                    //剩余本金
                    // residualPrincipal = residualPrincipal.subtract(mapPrincipal.get(i));
                    leaseSchemeRepayment.setResidualPrincipal(new BigDecimal(0));
                    calendar.add(Calendar.MONTH, 1);
                    Date time = calendar.getTime();
                    try {
                        leaseSchemeRepayment.setRepaymentDate(sd.parse(sd.format(time)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    leaseSchemeRepayment = addSchemeRepaymentMonth(leaseSchemeInterest, lesseeId, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList, type);
                    //插入 支付状态汇总管理 月供数据
                    addSchemeRepaymentStatusMonth(leaseSchemeInterest, lesseeId, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList, type, total);
                    //插入 支付状态汇总管理 尾款数据
                    addSchemeRepaymentStatusBalancePayment(leasePackageBalancePaymentList, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                    if (type.equals("update")) {//修改操作
                        //插入 支付状态汇总管理 逾期数据
                        //addSchemeRepaymentStatusOverdue(i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                        //插入 支付状态汇总管理 其他金额数据
                        addSchemeRepaymentStatusOther(i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                    }
                }
            }
        } else if (record.getLeaseStartTime() == null && leaseSchemeInterest.getIsType() == 1) {
            Integer period = Integer.valueOf(leaseDict.getValue());
            if (period != 0) {
                for (int i = 1; i <= period; i++) {
                    LeaseSchemeRepayment leaseSchemeRepayment = new LeaseSchemeRepayment();
                    //归还本金
                    leaseSchemeRepayment.setReturnPrincipal(mapPrincipal.get(i));
                    //归还利息
                    leaseSchemeRepayment.setReturnInterest(mapInterest.get(i));
                    //合计
                    BigDecimal total = new BigDecimal(perMonthPrincipalInterest);
                    leaseSchemeRepayment.setTotal(total);
                    //剩余本金
                    residualPrincipal = residualPrincipal.subtract(mapPrincipal.get(i));
                    leaseSchemeRepayment.setResidualPrincipal(residualPrincipal);

                    leaseSchemeRepayment = addSchemeRepaymentMonth(leaseSchemeInterest, lesseeId, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList, type);
                    //插入 支付状态汇总管理 月供数据
                    addSchemeRepaymentStatusMonth(leaseSchemeInterest, lesseeId, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList, type, total);
                    //插入 支付状态汇总管理 尾款数据
                    addSchemeRepaymentStatusBalancePayment(leasePackageBalancePaymentList, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                    if (type.equals("update")) {//修改操作
                        //插入 支付状态汇总管理 逾期数据
                        //addSchemeRepaymentStatusOverdue(i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                        //插入 支付状态汇总管理 其他金额数据
                        addSchemeRepaymentStatusOther(i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                    }
                }
            }
        } else {
            Integer period = Integer.valueOf(leaseDict.getValue());
            if (period != 0) {
                for (int i = 1; i <= period; i++) {
                    LeaseSchemeRepayment leaseSchemeRepayment = new LeaseSchemeRepayment();
                    //归还本金
                    leaseSchemeRepayment.setReturnPrincipal(new BigDecimal(0));
                    //归还利息
                    leaseSchemeRepayment.setReturnInterest(new BigDecimal(0));
                    //合计
                    BigDecimal total = new BigDecimal(perMonthPrincipalInterest);
                    leaseSchemeRepayment.setTotal(leaseSchemeOrder.getMonthlyRent());
                    //剩余本金
                    // residualPrincipal = residualPrincipal.subtract(mapPrincipal.get(i));
                    leaseSchemeRepayment.setResidualPrincipal(new BigDecimal(0));

                    leaseSchemeRepayment = addSchemeRepaymentMonth(leaseSchemeInterest, lesseeId, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList, type);
                    //插入 支付状态汇总管理 月供数据
                    addSchemeRepaymentStatusMonth(leaseSchemeInterest, lesseeId, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList, type, total);
                    //插入 支付状态汇总管理 尾款数据
                    addSchemeRepaymentStatusBalancePayment(leasePackageBalancePaymentList, i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                    if (type.equals("update")) {//修改操作
                        //插入 支付状态汇总管理 逾期数据
                        //addSchemeRepaymentStatusOverdue(i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                        //插入 支付状态汇总管理 其他金额数据
                        addSchemeRepaymentStatusOther(i, nowDate, record, leaseSchemeRepayment, leaseContract, findByContractIdAndPeriodVoList);
                    }
                }
            }
        }
    }

    /**
     * 插入 支付状态汇总管理 月供数据
     *
     * @param leaseSchemeInterest
     * @param lesseeId
     * @param i
     * @param nowDate
     * @param record
     * @param leaseSchemeRepayment
     * @param leaseContract
     * @param findByContractIdAndPeriodVoList 修改的时候会存在这部分数据
     * @param type
     * @return
     * @throws GMException
     */
    private LeaseSchemeRepayment addSchemeRepaymentMonth(LeaseScheme leaseSchemeInterest, Long lesseeId, Integer i, Date nowDate
            , LeaseContractOrder record, LeaseSchemeRepayment leaseSchemeRepayment, LeaseContract leaseContract, List<FindByContractIdAndPeriodVo> findByContractIdAndPeriodVoList
            , String type
    ) throws GMException {
        leaseSchemeRepayment.setPeriod(i);
        leaseSchemeRepayment.setLoanAmount(record.getComprehensiveQuote());
        leaseSchemeRepayment.setContractId(leaseContract.getId());
        leaseSchemeRepayment.setAnnualInterest(leaseSchemeInterest.getAnnualInterest());
        leaseSchemeRepayment.setLesseeId(lesseeId);
        leaseSchemeRepayment.setCreateTime(nowDate);
        leaseSchemeRepayment.setUpdateTime(nowDate);
        leaseSchemeRepayment.setCreateBy(record.getCreateBy());
        leaseSchemeRepayment.setUpdateBy(record.getUpdateBy());

        /*
        //还原合同修改前的逾期数据
        if (type.equals("update")) {//修改操作
            if (findByContractIdAndPeriodVoList != null && findByContractIdAndPeriodVoList.size() > 0) {//合同修改前的数据
                for (int j = 0; j < findByContractIdAndPeriodVoList.size(); j++) {
                    FindByContractIdAndPeriodVo findByContractIdAndPeriodVo = findByContractIdAndPeriodVoList.get(j);
                    if (i == findByContractIdAndPeriodVo.getPeriod() && findByContractIdAndPeriodVo.getType().equals(RepaymentStatusType.TYPE_0)) {
                        leaseSchemeRepayment.setOverdue(findByContractIdAndPeriodVo.getOverdue());//逾期
                        leaseSchemeRepayment.setOverdueDay(findByContractIdAndPeriodVo.getOverdueDay());//逾期天数
                        break;
                    }
                }
            }
        }
        //还原合同修改前的逾期数据
        */

        leaseSchemeRepayment = leaseSchemeRepaymentService.insertSelective(leaseSchemeRepayment);
        //插入 还款记录 数据
        return leaseSchemeRepayment;
    }

    /**
     * 插入 支付状态汇总管理 月供数据
     *
     * @param leaseSchemeInterest
     * @param lesseeId
     * @param i
     * @param nowDate
     * @param record
     * @param leaseSchemeRepayment
     * @param leaseContract
     * @param findByContractIdAndPeriodVoList 修改的时候会存在这部分数据
     * @param type
     * @param total                           合计
     * @return
     * @throws GMException
     */
    private LeaseSchemeRepaymentStatus addSchemeRepaymentStatusMonth(LeaseScheme leaseSchemeInterest, Long lesseeId, Integer i, Date nowDate
            , LeaseContractOrder record, LeaseSchemeRepayment leaseSchemeRepayment, LeaseContract leaseContract, List<FindByContractIdAndPeriodVo> findByContractIdAndPeriodVoList
            , String type, BigDecimal total
    ) throws GMException {

        //合同原有还款历史的还款数据则使用原还款计划数据
        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
        if (type.equals("update")) {//修改操作
            if (findByContractIdAndPeriodVoList != null && findByContractIdAndPeriodVoList.size() > 0) {//合同原有还款历史的还款数据则使用原还款计划数据
                for (int j = 0; j < findByContractIdAndPeriodVoList.size(); j++) {
                    FindByContractIdAndPeriodVo findByContractIdAndPeriodVo = findByContractIdAndPeriodVoList.get(j);
                    if (i == findByContractIdAndPeriodVo.getPeriod() && findByContractIdAndPeriodVo.getType().equals(RepaymentStatusType.TYPE_0)) {
                        leaseSchemeRepaymentStatus.setPayWay(findByContractIdAndPeriodVo.getPayWay());
                        leaseSchemeRepaymentStatus.setPaymentResult(findByContractIdAndPeriodVo.getPaymentResult());
                        leaseSchemeRepaymentStatus.setPaymentResultMsg(findByContractIdAndPeriodVo.getPaymentResultMsg());
                        leaseSchemeRepaymentStatus.setReqSn(findByContractIdAndPeriodVo.getReqSn());
                        leaseSchemeRepaymentStatus.setSn(findByContractIdAndPeriodVo.getSn());
                        break;
                    } else {
                        leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_0);
                        leaseSchemeRepaymentStatus.setPayWay(PayWay.DEFUAL);
                    }
                }
            } else {
                leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_0);
                leaseSchemeRepaymentStatus.setPayWay(PayWay.DEFUAL);
            }
        } else {
            leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_0);
            leaseSchemeRepaymentStatus.setPayWay(PayWay.DEFUAL);
        }
        //合同原有还款历史的还款数据则使用原还款计划数据

        //插入 支付状态汇总管理 月供数据
        leaseSchemeRepaymentStatus.setRepaymentId(leaseSchemeRepayment.getId());
        leaseSchemeRepaymentStatus.setContractId(leaseContract.getId());
        leaseSchemeRepaymentStatus.setCreateTime(nowDate);
        leaseSchemeRepaymentStatus.setUpdateTime(nowDate);
        leaseSchemeRepaymentStatus.setCreateBy(record.getCreateBy());
        leaseSchemeRepaymentStatus.setUpdateBy(record.getUpdateBy());
        leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_0);
        leaseSchemeRepaymentStatus.setTotlePrice(total);
        leaseSchemeRepaymentStatusService.insertSelective(leaseSchemeRepaymentStatus);
        //插入 支付状态汇总管理 月供数据
        return leaseSchemeRepaymentStatus;
    }

    /**
     * 插入 支付状态汇总管理 月租的尾款数据
     *
     * @param leasePackageBalancePaymentList
     * @param i
     * @param nowDate
     * @param record
     * @param leaseSchemeRepayment
     * @param leaseContract
     * @param findByContractIdAndPeriodVoList 修改的时候会存在这部分数据
     * @throws GMException
     */
    private void addSchemeRepaymentStatusBalancePayment(List<LeasePackageBalancePayment> leasePackageBalancePaymentList, Integer i, Date nowDate
            , LeaseContractOrder record, LeaseSchemeRepayment leaseSchemeRepayment, LeaseContract leaseContract, List<FindByContractIdAndPeriodVo> findByContractIdAndPeriodVoList
    ) throws GMException {
        //插入 支付状态汇总管理 尾款数据
        if (leasePackageBalancePaymentList != null) {
            if (leasePackageBalancePaymentList.size() > 0) {
                for (int j = 0; j < leasePackageBalancePaymentList.size(); j++) {
                    LeasePackageBalancePayment leasePackageBalancePayment = leasePackageBalancePaymentList.get(j);
                    Integer balancePaymentNumber = leasePackageBalancePayment.getBalancePaymentNumber();//尾款分期数
                    BigDecimal balancePayment = leasePackageBalancePayment.getBalancePayment();//尾款
                    if (balancePaymentNumber == i) {
                        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
                        leaseSchemeRepaymentStatus.setRepaymentId(leaseSchemeRepayment.getId());
                        leaseSchemeRepaymentStatus.setContractId(leaseContract.getId());
                        leaseSchemeRepaymentStatus.setCreateTime(nowDate);
                        leaseSchemeRepaymentStatus.setUpdateTime(nowDate);
                        leaseSchemeRepaymentStatus.setCreateBy(record.getCreateBy());
                        leaseSchemeRepaymentStatus.setUpdateBy(record.getUpdateBy());
                        leaseSchemeRepaymentStatus.setTotlePrice(balancePayment);
                        //合同原有还款历史的还款数据则使用原还款计划数据
                        if (findByContractIdAndPeriodVoList != null && findByContractIdAndPeriodVoList.size() > 0) {//合同原有还款历史的还款数据则使用原还款计划数据
                            for (int k = 0; k < findByContractIdAndPeriodVoList.size(); k++) {
                                FindByContractIdAndPeriodVo findByContractIdAndPeriodVo = findByContractIdAndPeriodVoList.get(k);
                                if (i == findByContractIdAndPeriodVo.getPeriod() && findByContractIdAndPeriodVo.getType().equals(RepaymentStatusType.TYPE_4)) {
                                    leaseSchemeRepaymentStatus.setPayWay(findByContractIdAndPeriodVo.getPayWay());
                                    leaseSchemeRepaymentStatus.setPaymentResult(findByContractIdAndPeriodVo.getPaymentResult());
                                    leaseSchemeRepaymentStatus.setPaymentResultMsg(findByContractIdAndPeriodVo.getPaymentResultMsg());
                                    leaseSchemeRepaymentStatus.setReqSn(findByContractIdAndPeriodVo.getReqSn());
                                    leaseSchemeRepaymentStatus.setSn(findByContractIdAndPeriodVo.getSn());
                                    leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_4);
                                    break;
                                } else {
                                    leaseSchemeRepaymentStatus.setPayWay(PayWay.DEFUAL);
                                    leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_0);
                                    leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_4);
                                }
                            }
                        } else {
                            leaseSchemeRepaymentStatus.setPayWay(PayWay.DEFUAL);
                            leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_0);
                            leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_4);
                        }
                        //合同原有还款历史的还款数据则使用原还款计划数据
                        leaseSchemeRepaymentStatusService.insertSelective(leaseSchemeRepaymentStatus);
                    }
                }
            }
        }
        //插入 支付状态汇总管理 尾款数据
    }

    /**
     * 插入 支付状态汇总管理 其他金额数据
     * 修改合同则会处理
     * 修改合同后要把还款计划的逾期数据补上
     *
     * @param i
     * @param nowDate
     * @param record
     * @param leaseSchemeRepayment
     * @param leaseContract
     * @param findByContractIdAndPeriodVoList 修改的时候会存在这部分数据
     * @throws GMException
     */
    private void addSchemeRepaymentStatusOther(Integer i, Date nowDate
            , LeaseContractOrder record, LeaseSchemeRepayment leaseSchemeRepayment, LeaseContract leaseContract, List<FindByContractIdAndPeriodVo> findByContractIdAndPeriodVoList
    ) throws GMException {
        //合同原有还款历史的还款数据则使用原还款计划数据
        if (findByContractIdAndPeriodVoList != null && findByContractIdAndPeriodVoList.size() > 0) {//合同原有还款历史的还款数据则使用原还款计划数据
            LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
            for (int k = 0; k < findByContractIdAndPeriodVoList.size(); k++) {
                FindByContractIdAndPeriodVo findByContractIdAndPeriodVo = findByContractIdAndPeriodVoList.get(k);
                if (i == findByContractIdAndPeriodVo.getPeriod() && findByContractIdAndPeriodVo.getType().equals(RepaymentStatusType.TYPE_7)) {
                    leaseSchemeRepaymentStatus.setPayWay(findByContractIdAndPeriodVo.getPayWay());
                    leaseSchemeRepaymentStatus.setPaymentResult(findByContractIdAndPeriodVo.getPaymentResult());
                    leaseSchemeRepaymentStatus.setPaymentResultMsg(findByContractIdAndPeriodVo.getPaymentResultMsg());
                    leaseSchemeRepaymentStatus.setReqSn(findByContractIdAndPeriodVo.getReqSn());
                    leaseSchemeRepaymentStatus.setSn(findByContractIdAndPeriodVo.getSn());
                    leaseSchemeRepaymentStatus.setType(findByContractIdAndPeriodVo.getType());
                    leaseSchemeRepaymentStatus.setRepaymentId(leaseSchemeRepayment.getId());
                    leaseSchemeRepaymentStatus.setContractId(leaseContract.getId());
                    leaseSchemeRepaymentStatus.setCreateTime(nowDate);
                    leaseSchemeRepaymentStatus.setUpdateTime(nowDate);
                    leaseSchemeRepaymentStatus.setCreateBy(record.getCreateBy());
                    leaseSchemeRepaymentStatus.setUpdateBy(record.getUpdateBy());
                    leaseSchemeRepaymentStatus.setTotlePrice(findByContractIdAndPeriodVo.getTotlePrice());
                    break;
                }
            }
            leaseSchemeRepaymentStatusService.insertSelective(leaseSchemeRepaymentStatus);
        }
        //合同原有还款历史的还款数据则使用原还款计划数据
    }

    /**
     * 插入 支付状态汇总管理 逾期数据
     * 修改合同则会处理
     * 修改合同后要把还款计划的逾期数据补上
     *
     * @param i
     * @param nowDate
     * @param record
     * @param leaseSchemeRepayment
     * @param leaseContract
     * @param findByContractIdAndPeriodVoList 修改的时候会存在这部分数据
     * @throws GMException
     */
    private void addSchemeRepaymentStatusOverdue(Integer i, Date nowDate
            , LeaseContractOrder record, LeaseSchemeRepayment leaseSchemeRepayment, LeaseContract leaseContract, List<FindByContractIdAndPeriodVo> findByContractIdAndPeriodVoList
    ) throws GMException {
        //合同原有还款历史的还款数据则使用原还款计划数据
        if (findByContractIdAndPeriodVoList != null && findByContractIdAndPeriodVoList.size() > 0) {//合同原有还款历史的还款数据则使用原还款计划数据
            LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
            for (int k = 0; k < findByContractIdAndPeriodVoList.size(); k++) {
                FindByContractIdAndPeriodVo findByContractIdAndPeriodVo = findByContractIdAndPeriodVoList.get(k);
                if (i == findByContractIdAndPeriodVo.getPeriod() && findByContractIdAndPeriodVo.getType().equals(RepaymentStatusType.TYPE_2)) {
                    leaseSchemeRepaymentStatus.setPayWay(findByContractIdAndPeriodVo.getPayWay());
                    leaseSchemeRepaymentStatus.setPaymentResult(findByContractIdAndPeriodVo.getPaymentResult());
                    leaseSchemeRepaymentStatus.setPaymentResultMsg(findByContractIdAndPeriodVo.getPaymentResultMsg());
                    leaseSchemeRepaymentStatus.setReqSn(findByContractIdAndPeriodVo.getReqSn());
                    leaseSchemeRepaymentStatus.setSn(findByContractIdAndPeriodVo.getSn());
                    leaseSchemeRepaymentStatus.setType(findByContractIdAndPeriodVo.getType());
                    leaseSchemeRepaymentStatus.setRepaymentId(leaseSchemeRepayment.getId());
                    leaseSchemeRepaymentStatus.setContractId(leaseContract.getId());
                    leaseSchemeRepaymentStatus.setCreateTime(nowDate);
                    leaseSchemeRepaymentStatus.setUpdateTime(nowDate);
                    leaseSchemeRepaymentStatus.setCreateBy(record.getCreateBy());
                    leaseSchemeRepaymentStatus.setUpdateBy(record.getUpdateBy());
                    leaseSchemeRepaymentStatus.setTotlePrice(findByContractIdAndPeriodVo.getTotlePrice());
                    break;
                }
            }
            leaseSchemeRepaymentStatusService.insertSelective(leaseSchemeRepaymentStatus);
        }
        //合同原有还款历史的还款数据则使用原还款计划数据
    }

    /**
     * 新增/插入合同数据
     *
     * @param record
     * @param leaseSchemeOrder
     * @param _leaseBaseinfoUse
     * @return
     * @throws GMException
     */
    private LeaseContract addLeaseContract(LeaseContractOrder record, LeaseSchemeOrder leaseSchemeOrder, LeaseContractBaseinfoUse _leaseBaseinfoUse) throws GMException {
        LeaseContract leaseContract = new LeaseContract();
        leaseContract.setAccountContactAdress(record.getAccountContactAdress());
        leaseContract.setBranchCompanyId(record.getBranchCompanyId());
        leaseContract.setCreateBy(record.getCreateBy());

        //String filePath = uploadService.base64UploadFile(record.getCardCheckAcceptImg(), FileUtil.IMAGE_EXTENSION);
        if (record.getCardCheckAcceptImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getCardCheckAcceptImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, orderFileImgFolder, imgUrl);
            leaseContract.setCardCheckAcceptImg(filePath);
        }
        if (record.getIdCardImg() != null) {
            String idCard = UploadFileUtil.base64UploadFile(record.getIdCardImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, orderFileImgFolder, imgUrl);
            leaseContract.setIdCardImg(idCard);
        }
        if (record.getCarAcceptImg() != null) {
            String carAccept = UploadFileUtil.base64UploadFile(record.getCarAcceptImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, orderFileImgFolder, imgUrl);
            leaseContract.setCarAcceptImg(carAccept);
        }

        leaseContract.setContractKey(record.getContractKey());
        leaseContract.setContractNumber(record.getContractNumber());
        leaseContract.setContractNumberYear(record.getContractNumberYear());
        leaseContract.setGuaranteeContact(record.getGuaranteeContact());
        leaseContract.setContractBaseinfoId(_leaseBaseinfoUse.getId());
        leaseContract.setGuaranteeContactName(record.getGuaranteeContactName());
        leaseContract.setGuaranteeContactPhone(record.getGuaranteeContactPhone());
        leaseContract.setGuaranteeIdCard(record.getGuaranteeIdCard());
        leaseContract.setGuaranteeName(record.getGuaranteeName());
        leaseContract.setGuaranteeZipCode(record.getGuaranteeZipCode());
        leaseContract.setLeaseEndTime(record.getLeaseEndTime());
        leaseContract.setLeaseStartTime(record.getLeaseStartTime());
        leaseContract.setSaleChannelId(record.getSaleChannelId());
        leaseContract.setSaleChannelType(record.getSaleChannelType());
        leaseContract.setGuaranteeContactAddress(record.getGuaranteeContactAddress());
        leaseContract.setThirdPartyLiabilityInsurance(record.getThirdPartyLiabilityInsurance());
        leaseContract.setSchemeOrderId(leaseSchemeOrder.getId());
        leaseContract.setCompleteContractNumber(record.getCompleteContractNumber());
        leaseContract.setStatus(STATUS_3);
        leaseContract.setBackStatus(STATUS_3);
        leaseContract.setContractType(record.getContractType());
        leaseContract = leaseContractService.insertSelective(leaseContract);

        return leaseContract;

    }

    private LeaseContractBaseinfoUse addLeaseContractBaseinfoUse(LeaseContractOrder record) throws GMException {
        LeaseContractBaseinfoUse leaseContractBaseinfoUse = new LeaseContractBaseinfoUse();
        if (record.getContractBaseinfoId() == null) {
            leaseContractBaseinfoUse.setName(record.getName());
            leaseContractBaseinfoUse.setBranchCompanyId(record.getBaseInfoBranchCompanyId());
            leaseContractBaseinfoUse.setContractPartyName(record.getBaseInfoContractPartyName());
            leaseContractBaseinfoUse.setContractPartyAdress(record.getContractPartyAdress());
            leaseContractBaseinfoUse.setContractBranchCompany(record.getContractBranchCompany());
            leaseContractBaseinfoUse.setLegalPerson(record.getLegalPerson());
            leaseContractBaseinfoUse.setDownPaymentTimeLimit(record.getDownPaymentTimeLimit());
            leaseContractBaseinfoUse.setLoanDeposit(record.getLoanDeposit());
            leaseContractBaseinfoUse.setImportantEventPrice(record.getImportantEventPrice());
            leaseContractBaseinfoUse.setCheckTime(record.getCheckTime());
            leaseContractBaseinfoUse.setAppointArea(record.getAppointArea());
            leaseContractBaseinfoUse.setRentOverdueTimeLimit(record.getRentOverdueTimeLimit());
            leaseContractBaseinfoUse.setCarLesseeCity(record.getCarLesseeCity());
            leaseContractBaseinfoUse.setCityInsideRecoveryCost(record.getCityInsideRecoveryCost());
            leaseContractBaseinfoUse.setCityOutsideRecoveryCost(record.getCityOutsideRecoveryCost());
            leaseContractBaseinfoUse.setProvinceInsideRecoveryCost(record.getProvinceInsideRecoveryCost());
            leaseContractBaseinfoUse.setProvinceOutsideRecoveryCost(record.getProvinceOutsideRecoveryCost());
            leaseContractBaseinfoUse.setDayCustodianCost(record.getDayCustodianCost());
            leaseContractBaseinfoUse.setContinuityOverdue(record.getContinuityOverdue());
            leaseContractBaseinfoUse.setCumulativeOverdue(record.getCumulativeOverdue());
            leaseContractBaseinfoUse.setLicenseMonthlyRent(record.getLicenseMonthlyRent());
            leaseContractBaseinfoUse.setContractPartyContactAddressVoList(record.getContractPartyContactAddressVoList());

            leaseContractBaseinfoUse.setAccountName(record.getAccountName());
            leaseContractBaseinfoUse.setAccount(record.getAccount());
            leaseContractBaseinfoUse.setBankId(record.getBankId());
            leaseContractBaseinfoUse.setBranchBank(record.getBranchBank());
            leaseContractBaseinfoUse.setDefaultInterest(record.getDefaultInterest());

            leaseContractBaseinfoUse.setAuthorizedPerson(record.getAuthorizedPerson());
            leaseContractBaseinfoUse.setPartyA(record.getPartyA());
            leaseContractBaseinfoUse.setPartyB(record.getPartyB());
            leaseContractBaseinfoUse.setPartyC(record.getPartyC());
            leaseContractBaseinfoUse.setLoanGuarantor(record.getLoanGuarantor());
            leaseContractBaseinfoUse.setGuarantor(record.getGuarantor());
            leaseContractBaseinfoUse.setRemarks(record.getRemarks());
            leaseContractBaseinfoUse.setCreateBy(record.getCreateBy());
            leaseContractBaseinfoUse = leaseContractBaseinfoUseService.insertSelective(leaseContractBaseinfoUse);

        } else {
            leaseContractBaseinfoUse.setId(record.getContractBaseinfoId());
            leaseContractBaseinfoUse.setName(record.getName());
            leaseContractBaseinfoUse.setBranchCompanyId(record.getBaseInfoBranchCompanyId());
            leaseContractBaseinfoUse.setContractPartyName(record.getBaseInfoContractPartyName());
            leaseContractBaseinfoUse.setContractPartyAdress(record.getContractPartyAdress());
            leaseContractBaseinfoUse.setContractBranchCompany(record.getContractBranchCompany());
            leaseContractBaseinfoUse.setLegalPerson(record.getLegalPerson());
            leaseContractBaseinfoUse.setDownPaymentTimeLimit(record.getDownPaymentTimeLimit());
            leaseContractBaseinfoUse.setLoanDeposit(record.getLoanDeposit());
            leaseContractBaseinfoUse.setImportantEventPrice(record.getImportantEventPrice());
            leaseContractBaseinfoUse.setCheckTime(record.getCheckTime());
            leaseContractBaseinfoUse.setAppointArea(record.getAppointArea());
            leaseContractBaseinfoUse.setRentOverdueTimeLimit(record.getRentOverdueTimeLimit());
            leaseContractBaseinfoUse.setCarLesseeCity(record.getCarLesseeCity());
            leaseContractBaseinfoUse.setCityInsideRecoveryCost(record.getCityInsideRecoveryCost());
            leaseContractBaseinfoUse.setCityOutsideRecoveryCost(record.getCityOutsideRecoveryCost());
            leaseContractBaseinfoUse.setProvinceInsideRecoveryCost(record.getProvinceInsideRecoveryCost());
            leaseContractBaseinfoUse.setProvinceOutsideRecoveryCost(record.getProvinceOutsideRecoveryCost());
            leaseContractBaseinfoUse.setDayCustodianCost(record.getDayCustodianCost());
            leaseContractBaseinfoUse.setContinuityOverdue(record.getContinuityOverdue());
            leaseContractBaseinfoUse.setCumulativeOverdue(record.getCumulativeOverdue());
            leaseContractBaseinfoUse.setLicenseMonthlyRent(record.getLicenseMonthlyRent());
            leaseContractBaseinfoUse.setContractPartyContactAddressVoList(record.getContractPartyContactAddressVoList());

            leaseContractBaseinfoUse.setAccountName(record.getAccountName());
            leaseContractBaseinfoUse.setAccount(record.getAccount());
            leaseContractBaseinfoUse.setBankId(record.getBankId());
            leaseContractBaseinfoUse.setBranchBank(record.getBranchBank());
            leaseContractBaseinfoUse.setDefaultInterest(record.getDefaultInterest());

            leaseContractBaseinfoUse.setAuthorizedPerson(record.getAuthorizedPerson());
            leaseContractBaseinfoUse.setPartyA(record.getPartyA());
            leaseContractBaseinfoUse.setPartyB(record.getPartyB());
            leaseContractBaseinfoUse.setPartyC(record.getPartyC());
            leaseContractBaseinfoUse.setLoanGuarantor(record.getLoanGuarantor());
            leaseContractBaseinfoUse.setRemarks(record.getRemarks());
            leaseContractBaseinfoUse.setGuarantor(record.getGuarantor());
            leaseContractBaseinfoUse.setUpdateBy(record.getUpdateBy());
            leaseContractBaseinfoUseService.updateByPrimaryKeySelective(leaseContractBaseinfoUse);
        }

        return leaseContractBaseinfoUse;
    }


    public int updateByPrimaryKeySelective(LeaseContract record) throws GMException {
        int row = leaseContractService.updateByPrimaryKeySelective(record);
        return row;
    }


    public int updateByPrimaryKey(LeaseContract record) throws GMException {
        int row = leaseContractService.updateByPrimaryKey(record);
        return row;
    }


    public LeaseContract selectByPrimaryKey(Long id) throws GMException {
        LeaseContract leaseContract = leaseContractService.selectByPrimaryKey(id);
        return leaseContract;
    }

    public int insertList(List<LeaseContract> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContract> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        //paramsMap.put("imgUrl", imgUrl);
        PageInfo<LeaseContract> page = leaseContractService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContract> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContract> leaseContractList = leaseContractService.findAll(paramsMap);
        return leaseContractList;
    }

    /**
     * 月供管理合同列表
     *
     * @param paramsMap
     * @return
     */
    public PageInfo<LeasePostLendingVo> findPostLending(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        PageInfo<LeasePostLendingVo> page = leaseContractService.findPostLending(pageNum, pageSize, paramsMap, dubboTreaceParames);
        return page;
    }

    public LeaseContract selectOrderInfo(Map<String, Object> paramsMap) throws GMException {
        LeaseContract leaseContract = leaseContractService.selectOrderInfo(paramsMap);
        return leaseContract;
    }

    public Map<String, Object> exportContract(Map<String, Object> paramsMap) throws GMException {
        LeaseContract leaseContract = selectOrderInfo(paramsMap);
        LeaseContractBaseinfoUse leaseContractBaseinfo = leaseContractBaseinfoUseService.selectByPrimaryKey(leaseContract.getContractBaseinfoId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("leaseContract", leaseContract);
        map.put("leaseContractBaseinfo", leaseContractBaseinfo);
        return map;
    }

    /**
     * 合同的尾付
     *
     * @param paramsMap
     * @return
     */
    public FindBalanceVo findBalancePayment(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        FindBalanceVo map = leaseContractService.findBalancePayment(paramsMap, dubboTreaceParames);
        return map;
    }

    /**
     * 融租合同承租人信息
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> findContractAccount(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        Map map = leaseContractService.findContractAccount(paramsMap, dubboTreaceParames);
        return map;
    }

    /**
     * 初始化单笔扣款页面的参数/合同信息
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     */
    @Override
    public Map<String, Object> payViewParamesContractInfo(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        Map map = leaseContractService.payViewParamesContractInfo(paramsMap, dubboTreaceParames);
        return map;
    }

    public Boolean checkOrderAccount(long orderAccountId) {

        boolean flag = false;
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts = leaseSchemeOrderAccountService.selectByAccountId(orderAccountId);
        if (leaseSchemeOrderAccounts.size() == 0) {
            flag = true;
        } else if (leaseSchemeOrderAccounts.size() > 0 && leaseSchemeOrderAccounts != null) {
            int size = 0;
            for (LeaseSchemeOrderAccount leaseSchemeOrderAccount : leaseSchemeOrderAccounts) {
                LeaseContract leaseContract = leaseContractService.selectBySchemeOrderId(leaseSchemeOrderAccount.getSchemeOrderId());
                if (leaseContract.getStatus() == 1) {
                    size++;
                }
            }
            if (size == leaseSchemeOrderAccounts.size()) {
                flag = true;
            }
        }
        return flag;
    }

    public MonthlyRentReadInfo updateMonthlyRent(List<MonthlyRentTemplate> monthlyRentTemplates, UserSession userSession) throws GMException {
        MonthlyRentReadInfo monthlyRentReadInfo = new MonthlyRentReadInfo();
        int successNum = 0;
        int failNum = 0;
        for (MonthlyRentTemplate monthlyRentTemplate : monthlyRentTemplates) {
            //判断合同编号是否存在
            if (!StringUtils.isEmpty(monthlyRentTemplate.getContractNumber())) {
                LeaseContract leaseContract = leaseContractService.findByCompleteContractNumber(monthlyRentTemplate.getContractNumber().trim());
                if (leaseContract == null) {
                    failNum++;
                    monthlyRentTemplate.setUpdateState("不存在此编号的融租合同!");
                    continue;
                }
                LeaseSchemeOrder leaseSchemeOrder = leaseSchemeOrderService.selectByPrimaryKey(leaseContract.getSchemeOrderId());
                LeaseScheme leaseScheme = leaseSchemeService.selectByPrimaryKey(leaseSchemeOrder.getSchemeId());
                if (leaseScheme.getIsType() == 2) {
                    failNum++;
                    monthlyRentTemplate.setUpdateState("此融租合同方案为年度方案,无法执行此操作!");
                    continue;
                }


                //修改代理商
                if (StringUtils.isBlank(monthlyRentTemplate.getAgentsName())) {
                    Map<String, Object> maps = Maps.newHashMap();
                    maps.put("saleChannelId", null);
                    maps.put("saleChannelType", 0);
                    maps.put("id", leaseContract.getId());
                    leaseContractService.updateSaleChannelId(maps);
                } else {
                    Map<String, Object> param = Maps.newHashMap();
                    param.put("name", monthlyRentTemplate.getAgentsName());
                    List<LeaseAgents> agentsList = leaseAgentsService.findByName(param);
                    if (agentsList != null && agentsList.size() > 0) {
                        Long saleChannelId = agentsList.get(0).getId();
                        if (leaseContract.getSaleChannelType() == 1) {
                            if (!leaseContract.getSaleChannelId().equals(saleChannelId)) {
                                Map<String, Object> maps = Maps.newHashMap();
                                maps.put("saleChannelId", saleChannelId);
                                maps.put("id", leaseContract.getId());
                                leaseContractService.updateSaleChannelId(maps);
                            }
                        } else {
                            Map<String, Object> maps = Maps.newHashMap();
                            maps.put("saleChannelId", saleChannelId);
                            maps.put("saleChannelType", 1);
                            maps.put("id", leaseContract.getId());
                            leaseContractService.updateSaleChannelId(maps);
                        }
                    } else {
                        failNum++;
                        monthlyRentTemplate.setUpdateState("不存在此代理商！");
                        continue;
                    }
                }

                BigDecimal monthlyRent = leaseSchemeOrder.getMonthlyRent();
                BigDecimal templateMonthlyRent = monthlyRentTemplate.getMonthlyRent();
                if (monthlyRent.compareTo(templateMonthlyRent) == 0) {
                    successNum++;
                    monthlyRentTemplate.setUpdateState("成功！");
                    continue;
                } else {
                    BigDecimal subtract = new BigDecimal(0);
                    if (monthlyRent.compareTo(templateMonthlyRent) == 1) {
                        subtract = monthlyRent.subtract(templateMonthlyRent);
                    } else {
                        subtract = templateMonthlyRent.subtract(monthlyRent);
                    }
                    if (subtract.compareTo(new BigDecimal(1)) == 1) {
                        failNum++;
                        monthlyRentTemplate.setUpdateState("修改的租金金额与原租金误差大于1！");
                        continue;
                    }
                }
                boolean flag = true;
                try {
                    Map<String, Object> params = new HashedMap();
                    params.put("contractId", leaseContract.getId());
                    params.put("total", templateMonthlyRent);
                    flag = leaseSchemeRepaymentService.updateTotalByContractId(params);
                    if (!flag) {
                        failNum++;
                        monthlyRentTemplate.setUpdateState("修改月供计划表失败！");
                        continue;
                    }
                    LeaseSchemeOrder _leaseSchemeOrder = new LeaseSchemeOrder();
                    _leaseSchemeOrder.setId(leaseSchemeOrder.getId());
                    _leaseSchemeOrder.setMonthlyRent(templateMonthlyRent);
                    int change = leaseSchemeOrderService.updateByPrimaryKeySelective(_leaseSchemeOrder);
                    if (change != 0) {
                        flag = true;
                    } else {
                        flag = false;
                        failNum++;
                        monthlyRentTemplate.setUpdateState("修改月供失败！");
                        continue;
                    }
                    flag = leaseSchemeRepaymentStatusService.updateByContractIdAndType(params);
                    if (!flag) {
                        failNum++;
                        monthlyRentTemplate.setUpdateState("修改月供流水失败！");
                        continue;
                    }


                } catch (Exception e) {
                    System.out.println("*************************处理失败合同id为" + leaseContract.getId());
                }

                successNum++;
                monthlyRentTemplate.setUpdateState("成功");

                LeaseUpdateMonthlyrent leaseUpdateMonthlyrent = new LeaseUpdateMonthlyrent();
                leaseUpdateMonthlyrent.setCreateBy(userSession.getUserId());
                leaseUpdateMonthlyrent.setContractId(leaseContract.getId());
                leaseUpdateMonthlyrent.setNewMonthlyrent(templateMonthlyRent);
                leaseUpdateMonthlyrent.setOldMonthlyrent(monthlyRent);
                leaseUpdateMonthlyrentService.insertSelective(leaseUpdateMonthlyrent);
              /*  //为标准的则计算租金
                BigDecimal price = new BigDecimal(0);
                double perMonthPrincipalInterest = 0;
                Map<Integer, BigDecimal> mapPrincipal = null;
                Map<Integer, BigDecimal> mapInterest = null;
                BigDecimal residualPrincipal = new BigDecimal(price.doubleValue());

                LeaseSchemePackage leaseSchemePackage = leaseSchemePackageService.selectBySchemeId(leaseSchemeOrder.getSchemeId());
                LeaseScheme leaseSchemeInterest = leaseSchemeService.selectByPrimaryKey(leaseSchemeOrder.getSchemeId());
                LeasePackage leasePackage = leasePackageService.selectByPrimaryKey(leaseSchemePackage.getPackageId());
                LeaseDict leaseDict = leaseDictService.selectByPrimaryKey(leasePackage.getStagingNumberId().longValue());
                //先计算price
                LeasePackageBalancePayment leasePackageBalancePayment = leasePackageBalancePaymentService.selectBySchemeId(leaseSchemeOrder.getSchemeId());
               *//* price = record.getComprehensiveQuote().setScale(2, BigDecimal.ROUND_HALF_UP).subtract(leasePackage.getDownPayment()).subtract(leasePackageBalancePayment.getBalancePayment());*//*
                perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterestAndBalancePayment(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
                //System.out.println("等额本息---每月还款本息：" + perMonthPrincipalInterest);
                mapPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
                mapInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(price.doubleValue(), (leaseSchemeInterest.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(leaseDict.getValue()), leasePackageBalancePayment.getBalancePayment().doubleValue());
                System.out.println("等额本息---每月还款利息：" + mapInterest);

                Integer period = Integer.valueOf(leaseDict.getValue());
                if (period != 0) {
                    for (int i = 1; i <= period; i++) {
                        Map<String,Object> params=new HashedMap();
                        params.put("contractId",leaseContract.getId());
                        params.put("period",i);
                        LeaseSchemeRepayment leaseSchemeRepayment=leaseSchemeRepaymentService.findByContractIdAndPeriod(params);
                        leaseSchemeRepayment.setId(leaseSchemeRepayment.getId());
                        leaseSchemeRepayment.setPeriod(i);
                        //leaseSchemeRepayment.setLoanAmount(record.getComprehensiveQuote());
                        leaseSchemeRepayment.setContractId(leaseContract.getId());
                        //归还本金
                        leaseSchemeRepayment.setReturnPrincipal(mapPrincipal.get(i));
                        //归还利息
                        leaseSchemeRepayment.setReturnInterest(mapInterest.get(i));
                        //合计
                        BigDecimal total = new BigDecimal(perMonthPrincipalInterest);
                        leaseSchemeRepayment.setTotal(total);
                        //剩余本金
                        residualPrincipal = residualPrincipal.subtract(mapPrincipal.get(i));
                        leaseSchemeRepayment.setResidualPrincipal(residualPrincipal);
                        leaseSchemeRepaymentService.updateByPrimaryKeySelective(leaseSchemeRepayment);
                        //插入 还款记录 数据

                        //插入 支付状态汇总管理 数据
                        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
                        leaseSchemeRepaymentStatus.setRepaymentId(leaseSchemeRepayment.getId());
                        leaseSchemeRepaymentStatus.setUpdateTime(DateTime.now().toDate());
                        leaseSchemeRepaymentStatus.setTotlePrice(total);
                        leaseSchemeRepaymentStatusService.updateByRepaymentId(leaseSchemeRepaymentStatus);
                    }*/
            } else {
                failNum++;
                monthlyRentTemplate.setUpdateState("导入的合同编号为空");
                continue;
            }
        }
        monthlyRentReadInfo.setMonthlyRentTemplates(monthlyRentTemplates);
        monthlyRentReadInfo.setSuccessNum(successNum);
        monthlyRentReadInfo.setFailNum(failNum);
        return monthlyRentReadInfo;
    }

    /**
     * 合同所有数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindAllContractVo> selectAll(Map<String, Object> paramsMap) throws GMException {
        List<FindAllContractVo> leaseContractList = leaseContractService.selectAll(paramsMap);
        return leaseContractList;
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
        List<CarManagerFindContractVo> carCallbackFindContractVoList = leaseContractService.carManagerFindContract(paramsMap);
        return carCallbackFindContractVoList;
    }

    @Override
    public CarManagerDealFindContractVo carManagerDealFindContract(Map<String, Object> paramsMap) throws GMException {
        CarManagerDealFindContractVo carManagerAddFindContractVo = leaseContractService.carManagerDealFindContract(paramsMap);
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
        int row = leaseContractService.updateDealStatus(leaseContract);
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
        int row = leaseContractService.updateDealStatusAndStatusBack(leaseContract);
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
        PageInfo page = leaseContractService.contractManagerFindContractUpdatePeriod(pageNum, pageSize, paramsMap, dubboTreaceParames);
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
        PageInfo page = leaseContractService.contractManagerFindContractDealEnd(pageNum, pageSize, paramsMap, dubboTreaceParames);
        return page;
    }

    /**
     * 合同公共处理
     * 改期数、转租
     *
     * @param contractManagerVo
     * @param userSession
     * @param leaseContractOld
     * @param leaseSchemeOrderOld
     * @return
     * @throws GMException
     */
    public int contractManager(ContractManagerVo contractManagerVo, UserSession userSession, LeaseContract leaseContractOld, LeaseSchemeOrder leaseSchemeOrderOld, List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList) throws GMException {

        //插入方案报价数据
        LeaseSchemePrice leaseSchemePrice = new LeaseSchemePrice();
        leaseSchemePrice.setMarketPrice(contractManagerVo.getComprehensiveQuote());
        leaseSchemePrice.setCustomerComprehensiveQuote(contractManagerVo.getComprehensiveQuote());
        leaseSchemePrice.setAnnualInterest(contractManagerVo.getAnnualInterest());
        leaseSchemePrice.setType(SchemePriceType.SchemeType_1.value());//合同报价方案类型 0:默认套餐;1:定制套餐
        leaseSchemePrice = leaseSchemePriceService.insertSelective(leaseSchemePrice);
        LeaseSchemePriceStages leaseSchemePriceStage = new LeaseSchemePriceStages();
        leaseSchemePriceStage.setSchemePriceId(leaseSchemePrice.getId());
        leaseSchemePriceStage.setStagingNumberId(contractManagerVo.getStagingNumberId());
        leaseSchemePriceStage.setMonthlyRent(contractManagerVo.getMonthlyRent());
        leaseSchemePriceStage.setBalancePayment(contractManagerVo.getBalancePayment());
        leaseSchemePriceStage.setStagingNumberType(contractManagerVo.getStagingNumberType());
        leaseSchemePriceStage = leaseSchemePriceStagesService.insertSelective(leaseSchemePriceStage);
        //插入方案报价数据

        //插入融租订单数据
        Calendar calendar = Calendar.getInstance();
        Integer payDate = null;
        if (contractManagerVo.getRepaymentStartDate() != null) {
            calendar.setTime(contractManagerVo.getRepaymentStartDate());
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DAY_OF_MONTH));
            payDate = calendar.get(Calendar.DAY_OF_MONTH);
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = sdf.format(date);
        LeaseSchemeOrder leaseSchemeOrder = new LeaseSchemeOrder();
        leaseSchemeOrder.setParentId(leaseSchemeOrderOld.getId());
        leaseSchemeOrder.setCardId(leaseSchemeOrderOld.getCardId());
        leaseSchemeOrder.setCarPrice(leaseSchemeOrderOld.getCarPrice());
        leaseSchemeOrder.setContractPartyId(leaseSchemeOrderOld.getContractPartyId());
        leaseSchemeOrder.setSn(str);
        leaseSchemeOrder.setComprehensiveQuote(contractManagerVo.getComprehensiveQuote().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setCommission(leaseSchemeOrderOld.getCommission().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setReceiveMargin(leaseSchemeOrderOld.getReceiveMargin().setScale(2, BigDecimal.ROUND_HALF_UP));
        leaseSchemeOrder.setStatus(0);
        leaseSchemeOrder.setCreateBy(userSession.getUserId());
        leaseSchemeOrder.setPayDate(payDate);

        BigDecimal price = new BigDecimal(0);
        double perMonthPrincipalInterest = 0;
        Map<Integer, BigDecimal> mapPrincipal = null;
        Map<Integer, BigDecimal> mapInterest = null;

        //计算等额本息
        price = contractManagerVo.getComprehensiveQuote().setScale(2, BigDecimal.ROUND_HALF_UP).subtract(contractManagerVo.getDownPayment()).subtract(contractManagerVo.getBalancePayment());
        perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterestAndBalancePayment(price.doubleValue(), (contractManagerVo.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(contractManagerVo.getPeriod()), contractManagerVo.getBalancePayment().doubleValue());
        //System.out.println("等额本息---每月还款本息：" + perMonthPrincipalInterest);
        mapPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(price.doubleValue(), (contractManagerVo.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(contractManagerVo.getPeriod()), contractManagerVo.getBalancePayment().doubleValue());
        mapInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(price.doubleValue(), (contractManagerVo.getAnnualInterest().doubleValue()) / 100, Integer.valueOf(contractManagerVo.getPeriod()), contractManagerVo.getBalancePayment().doubleValue());
        System.out.println("等额本息---每月还款利息：" + mapInterest);
        //计算等额本息

        BigDecimal monthlyRent = new BigDecimal(perMonthPrincipalInterest);
        leaseSchemeOrder.setMonthlyRent(monthlyRent);
        BigDecimal leasePrice = monthlyRent.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(contractManagerVo.getPeriod())).add(contractManagerVo.getBalancePayment());
        leaseSchemeOrder.setLeasePrice(leasePrice);

        leaseSchemeOrder.setPeriodCount(contractManagerVo.getPeriod());//分期数
        leaseSchemeOrder = leaseSchemeOrderService.insertSelective(leaseSchemeOrder);
        //插入融租订单数据

        //插入合同数据
        LeaseContract leaseContract = new LeaseContract();
        leaseContract.setSchemeOrderId(leaseSchemeOrder.getId());
        leaseContract.setSaleChannelType(leaseContractOld.getSaleChannelType());
        leaseContract.setSaleChannelId(leaseContractOld.getSaleChannelId());
        leaseContract.setGuaranteeContact(leaseContractOld.getGuaranteeContact());
        leaseContract.setContractBaseinfoId(leaseContractOld.getId());
        leaseContract.setGuaranteeContactName(leaseContractOld.getGuaranteeContactName());
        leaseContract.setGuaranteeContactPhone(leaseContractOld.getGuaranteeContactPhone());
        leaseContract.setGuaranteeIdCard(leaseContractOld.getGuaranteeIdCard());
        leaseContract.setGuaranteeName(leaseContractOld.getGuaranteeName());
        leaseContract.setGuaranteeZipCode(leaseContractOld.getGuaranteeZipCode());
        leaseContract.setGuaranteeContactAddress(leaseContractOld.getGuaranteeContactAddress());
        leaseContract.setThirdPartyLiabilityInsurance(leaseContractOld.getThirdPartyLiabilityInsurance());
        leaseContract.setContractNumber(contractManagerVo.getContractNumber());
        leaseContract.setContractNumberYear(contractManagerVo.getContractNumberYear());
        leaseContract.setCompleteContractNumber(contractManagerVo.getCompleteContractNumber());
        leaseContract.setLeaseStartTime(contractManagerVo.getLeaseStartTime());
        leaseContract.setLeaseEndTime(contractManagerVo.getLeaseEndTime());
        leaseContract.setParentId(leaseContractOld.getId());
        leaseContract.setSourceType(contractManagerVo.getSourceType());//合同来源类型 0 原始合同 1 改期数 2 续期 3 转租
        leaseContract.setPriceDifference(contractManagerVo.getPriceDifference());
        leaseContract.setRemarks(contractManagerVo.getRemarks());
        leaseContract.setCreateBy(userSession.getUserId());
        leaseContract.setUpdateBy(userSession.getUserId());
        leaseContract = leaseContractService.insertSelective(leaseContract);
        //插入合同数据

        LeaseSchemeContract leaseSchemeContract = new LeaseSchemeContract();
        leaseSchemeContract.setContractId(leaseContract.getId());
        leaseSchemeContract.setSchemeId(leaseSchemePriceStage.getId());
        leaseSchemeContract.setSchemeType(SchemeType.SchemeType_0.value());
        leaseSchemeContractService.insertSelective(leaseSchemeContract);

        //融租方案-承租人
        Long lesseeId = null;
        if (leaseSchemeOrderAccountList.size() > 0) {
            for (LeaseSchemeOrderAccount leaseSchemeOrderAccount : leaseSchemeOrderAccountList) {
                if (leaseSchemeOrderAccount.getIsDefaultPay() == 1) {
                    lesseeId = leaseSchemeOrderAccount.getAccountId();
                }
                leaseSchemeOrderAccount.setSchemeOrderId(leaseSchemeOrder.getId());
                leaseSchemeOrderAccountService.insertSelective(leaseSchemeOrderAccount);
                leaseCommonService.insertUseUsed(leaseContract.getId(), null, leaseSchemeOrderAccount.getAccountId(), null, UseType.TYPE_LEASE_CONTRACT, UsedType.TYPE_LEASE_ACCOUNT);
            }
        }
        //融租方案-承租人

        //处理还款计划表
        ContractManagerAddLeaseSchemeRepaymentVo contractManagerAddLeaseSchemeRepaymentVo = new ContractManagerAddLeaseSchemeRepaymentVo();
        contractManagerAddLeaseSchemeRepaymentVo.setPrice(price);
        contractManagerAddLeaseSchemeRepaymentVo.setLeaseStartTime(contractManagerVo.getLeaseStartTime());
        contractManagerAddLeaseSchemeRepaymentVo.setComprehensiveQuote(contractManagerVo.getComprehensiveQuote());
        contractManagerAddLeaseSchemeRepaymentVo.setCreateBy(userSession.getUserId());
        contractManagerAddLeaseSchemeRepaymentVo.setUpdateBy(userSession.getUserId());
        contractManagerAddLeaseSchemeRepaymentVo.setPeriod(contractManagerVo.getPeriod());
        contractManagerAddLeaseSchemeRepaymentVo.setContractId(leaseContract.getId());
        contractManagerAddLeaseSchemeRepaymentVo.setAnnualInterest(contractManagerVo.getAnnualInterest());
        contractManagerAddLeaseSchemeRepaymentVo.setLesseeId(lesseeId);
        contractManagerAddLeaseSchemeRepaymentVo.setMapPrincipal(mapPrincipal);
        contractManagerAddLeaseSchemeRepaymentVo.setMapInterest(mapInterest);
        contractManagerAddLeaseSchemeRepaymentVo.setPerMonthPrincipalInterest(perMonthPrincipalInterest);
        contractManagerAddLeaseSchemeRepaymentVo.setCalendar(calendar);
        updateContractPeriodAddLeaseSchemeRepayment(contractManagerAddLeaseSchemeRepaymentVo);

        return 0;
    }

    /**
     * 提交 改期数
     *
     * @param contractManagerVo
     * @return
     * @throws GMException
     */
    @Override
    public int updateContractPeriod(ContractManagerVo contractManagerVo, UserSession userSession) throws GMException {
        LeaseContract leaseContractOld = leaseContractService.selectByPrimaryKey(contractManagerVo.getContractId());
        LeaseSchemeOrder leaseSchemeOrderOld = leaseSchemeOrderService.selectByPrimaryKey(leaseContractOld.getSchemeOrderId());
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList = leaseSchemeOrderAccountService.selectBySchemeOrderId(leaseSchemeOrderOld.getId());
        LeaseDict leaseDict = leaseDictService.selectByPrimaryKey(contractManagerVo.getStagingNumberId());//分期数
        Integer period = Integer.valueOf(leaseDict.getValue());//分期数
        Integer sourceType = SourceType.SchemeType_1.value();//合同来源类型 0 原始合同 1 改期数 2 续期 3 转租
        contractManagerVo.setSourceType(sourceType);
        contractManagerVo.setPeriod(period);
        contractManager(contractManagerVo, userSession, leaseContractOld, leaseSchemeOrderOld, leaseSchemeOrderAccountList);//合同公共处理

        //合同状态改为结束
        LeaseContract leaseContract = new LeaseContract();
        leaseContract.setId(contractManagerVo.getContractId());
        leaseContract.setStatus(ContractStatus.STATUS_2);
        leaseContract.setDealStatus(DealStatus.Deal_Status_60.value());
        leaseContractService.updateDealStatus(leaseContract);
        //合同状态改为结束

        return 0;
    }

    /**
     * 提交 续期
     *
     * @param contractManagerVo
     * @param userSession
     * @return
     * @throws GMException
     */
    @Override
    public int continueContract(ContractManagerVo contractManagerVo, UserSession userSession) throws GMException {

        //检测是否可以续期
        if (!contractManagerVo.getIsContinue().equals(1))
            throw new GMException(GMExceptionConstant.CONTINUECONTRACT_ERROR);

        LeaseContract leaseContractOld = leaseContractService.selectByPrimaryKey(contractManagerVo.getContractId());
        LeaseSchemeOrder leaseSchemeOrderOld = leaseSchemeOrderService.selectByPrimaryKey(leaseContractOld.getSchemeOrderId());
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList = contractManagerVo.getLeaseSchemeOrderAccounts();
        Integer sourceType = SourceType.SchemeType_2.value();//合同来源类型 0 原始合同 1 改期数 2 续期 3 转租
        contractManagerVo.setSourceType(sourceType);
        contractManagerVo.setStagingNumberType(StagingNumberType.CallbackWay_2.value());
        contractManager(contractManagerVo, userSession, leaseContractOld, leaseSchemeOrderOld, leaseSchemeOrderAccountList);//合同公共处理

        //合同状态改为结束
        LeaseContract leaseContract = new LeaseContract();
        leaseContract.setId(contractManagerVo.getContractId());
        leaseContract.setStatus(ContractStatus.STATUS_2);
        leaseContract.setDealStatus(DealStatus.Deal_Status_70.value());
        leaseContractService.updateDealStatus(leaseContract);
        //合同状态改为结束

        return 0;
    }

    /**
     * 提交 转租
     *
     * @param contractManagerVo
     * @param userSession
     * @return
     * @throws GMException
     */
    @Override
    public int transferContract(ContractManagerVo contractManagerVo, UserSession userSession) throws GMException {

        //检测是否可以转租
        if (!contractManagerVo.getIsTransfer().equals(1))
            throw new GMException(GMExceptionConstant.TRANSFERCONTRACT_ERROR);

        LeaseContract leaseContractOld = leaseContractService.selectByPrimaryKey(contractManagerVo.getContractId());
        LeaseSchemeOrder leaseSchemeOrderOld = leaseSchemeOrderService.selectByPrimaryKey(leaseContractOld.getSchemeOrderId());
        List<LeaseSchemeOrderAccount> leaseSchemeOrderAccountList = contractManagerVo.getLeaseSchemeOrderAccounts();
        LeaseDict leaseDict = leaseDictService.selectByPrimaryKey(contractManagerVo.getStagingNumberId());//分期数
        Integer period = Integer.valueOf(leaseDict.getValue());//分期数
        Integer sourceType = SourceType.SchemeType_3.value();//合同来源类型 0 原始合同 1 改期数 2 续期 3 转租
        contractManagerVo.setSourceType(sourceType);
        contractManagerVo.setPeriod(period);
        contractManagerVo.setStagingNumberType(StagingNumberType.CallbackWay_1.value());
        contractManager(contractManagerVo, userSession, leaseContractOld, leaseSchemeOrderOld, leaseSchemeOrderAccountList);//合同公共处理

        //合同状态改为结束
        LeaseContract leaseContract = new LeaseContract();
        leaseContract.setId(contractManagerVo.getContractId());
        leaseContract.setStatus(ContractStatus.STATUS_2);
        leaseContract.setDealStatus(DealStatus.Deal_Status_80.value());
        leaseContractService.updateDealStatus(leaseContract);
        //合同状态改为结束

        return 0;
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
        PageInfo page = leaseContractService.contractDQZZManagerFindContractContinue(pageNum, pageSize, paramsMap, dubboTreaceParames);
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
        PageInfo page = leaseContractService.contractDQZZManagerFindContractTransfer(pageNum, pageSize, paramsMap, dubboTreaceParames);
        return page;
    }
    @Override
    public FindAllinpayLogStatisticsVo findAllinpayLogStatistics(Map<String, Object> paramsMap) throws GMException {
        FindAllinpayLogStatisticsVo findAllinpayLogStatisticsVoList = leaseContractService.findAllinpayLogStatistics(paramsMap);
        return findAllinpayLogStatisticsVoList;
    }
}
