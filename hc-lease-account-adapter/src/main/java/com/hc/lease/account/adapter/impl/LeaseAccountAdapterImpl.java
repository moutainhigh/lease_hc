package com.hc.lease.account.adapter.impl;

import com.aipg.quickpay.AllinpayAccountTypeEnum;
import com.aipg.quickpay.AllinpayIdTypeEnum;
import com.allinpay.data.QuickData;
import com.allinpay.model.QuickReturnMessage;
import com.allinpay.util.CheckCode;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.account.adapter.api.LeaseAccountAdapter;
import com.hc.lease.account.constant.AccountBankPaySinStatus;
import com.hc.lease.account.model.*;
import com.hc.lease.account.service.api.*;
import com.hc.lease.account.vo.AccountBankCardSignStrategyCommonVo;
import com.hc.lease.account.vo.LeaseAccountExcel;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseBankService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.baseInfo.service.api.LeaseUseUsedService;
import com.hc.lease.common.allinpay.adapter.TranxAdapter;
import com.hc.lease.common.allinpay.model.QuickSendMessageVo;
import com.hc.lease.common.core.constant.*;
import com.hc.lease.common.core.excel.poi.vo.EmergencyContactExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.EmergencyContactImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountImportExcelBackInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.common.core.strategy.Context;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.ListUtil;
import hc.lease.common.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 承租人/用户AdapterImpl
 *
 * @author Tong
 * @version 2017-05-22
 */
@Service("leaseAccountAdapter")
public class LeaseAccountAdapterImpl implements LeaseAccountAdapter {

    private static Context context = new Context();

    @Autowired
    private LeaseAccountService leaseAccountService;

    @Autowired
    private LeaseAccountSessionService leaseAccountSessionService;

    @Autowired
    private LeaseAccountCreditService leaseAccountCreditService;

    @Autowired
    private LeaseDictService leaseDictService;

    @Autowired
    private LeaseUseUsedService leaseUseUsedService;
    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseAccountBankCardService leaseAccountBankCardService;
    @Autowired
    private TranxAdapter tranxAdapter;
    @Autowired
    private LeaseAccountBankPaySinService leaseAccountBankPaySinService;

    @Resource
    ShardedJedisTemplate shardedJedisTemplate;

    @Value("${img.url}")
    String imgUrl;

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径根目录

    @Value("${account.img.fileImgFolder}")
    private String accountFileImgFolder;//用户图片存放文件夹路径

    /**
     * 初始化编辑页面的参数
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        Map<String, Object> map = Maps.newHashMap();
        List<LeaseDict> leaseDictFinancingModeList = leaseDictService.findByType(DictType.TYPE_HOUSINGTYPE);//住房类型
        map.put("leaseDictFinancingModeList", leaseDictFinancingModeList);
        return map;
    }


    /**
     * 检测数据是否存在
     *
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkByAccountIsExist(Long id, Integer type) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_ACCOUNT);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                paramsMap.put("id", id);
                paramsMap.put("type", type);
                LeaseAccount leaseAccount = leaseAccountService.selectBy(paramsMap);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseAccount.getName());
                exceptionMessageList.add(exceptionMessageMap);
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        backMap.put("isExist", item);
        backMap.put("exceptionMessageList", exceptionMessageList);
        return backMap;
    }

    /**
     * 删除
     * 个人用户 、 公司用户
     *
     * @param id
     * @param type
     * @return
     * @throws GMException
     */
    public int deleteBy(Long id, Integer type) throws GMException {

        if (!type.equals(1) && !type.equals(0))
            throw new GMException(GMExceptionConstant.ACCOUNT_TYPE_ERROR);

        Map<String, Object> isExist = checkByAccountIsExist(id, type);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseAccountService.deleteByPrimaryKey(id);
        leaseAccountBankCardService.deleteByAccountId(id);
        //leaseAccountCreditService.deleteByAccountId(id);
        Map params = Maps.newHashMap();
        params.put("id", id);
        context.delete(context, type + "LeaseAccount", null, params);//
        leaseUseUsedService.deleteByUse(id, UseType.TYPE_LEASE_ACCOUNT);
        return row;
    }

    /**
     * 检测身份证号码是否存在
     *
     * @param idCard
     * @param id
     * @return
     * @throws GMException
     */
    public boolean checkByIdCard(String idCard, Long id) throws GMException {
        boolean item = false;
        Map params = Maps.newHashMap();
        params.put("idCard", idCard);
        params.put("id", id);
        List<LeaseAccount> leaseAccountList = leaseAccountService.findByIdCard(params);
        if (leaseAccountList != null) {
            if (leaseAccountList.size() > 0) {
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
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAccountService.deleteBatchById(ids);
        leaseAccountCreditService.deleteBatchByAccountId(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAccount record) throws GMException {
        record = leaseAccountService.insert(record);
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
    public ResultHashMap insertSelective(LeaseAccount record) throws GMException {
        record.setType(AccountType.PERSONAL);//用户类型：0:个人;1:公司
        //检测手机号是否已被注册
        Map paramsMap = Maps.newHashMap();
        paramsMap.put("phone", record.getPhone());
        paramsMap.put("id", record.getId());
        List<LeaseAccount> leaseAccountList = leaseAccountService.findByPhone(paramsMap);
        if (leaseAccountList != null) {
            if (leaseAccountList.size() > 0) {
                Map backMap = Maps.newHashMap();
                backMap.put("key", "phone");
                throw new GMException(GMExceptionConstant.ACCOUNT_PHONE_IS_REPEAT, backMap);
            }
        }
        //检测手机号是否已被注册

        //检测身份证号码是否存在
        boolean isExist = checkByIdCard(record.getIdCard(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "idCard");
            throw new GMException(GMExceptionConstant.IDCARD_REPEAT, backMap);
        }

        //初始化密码
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        record.setSalt(randomNumberGenerator.nextBytes().toHex());
        String accountPassword = MD5Util.string2MD5(record.getPassword() + record.getPhone() + record.getCredentialsSalt());
        record.setPassword(accountPassword);
        //初始化密码

        //插入用户数据
        record = leaseAccountService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 修改
     * 个人用户 、 公司用户
     *
     * @param leaseAccount
     * @return
     * @throws GMException
     */
    public int updateByPrimaryKeySelective(LeaseAccount leaseAccount) throws GMException {

        if (!leaseAccount.getType().equals(1) && !leaseAccount.getType().equals(0))
            throw new GMException(GMExceptionConstant.ACCOUNT_TYPE_ERROR);

        //检测手机号是否已被注册
        Map paramsMap = Maps.newHashMap();
        paramsMap.put("phone", leaseAccount.getPhone());
        paramsMap.put("id", leaseAccount.getId());
        List<LeaseAccount> leaseAccountList = leaseAccountService.findByPhone(paramsMap);
        if (leaseAccountList != null) {
            if (leaseAccountList.size() > 0) {
                Map backMap = Maps.newHashMap();
                backMap.put("key", leaseAccount.getPhone());
                throw new GMException(GMExceptionConstant.ACCOUNT_PHONE_IS_REPEAT, backMap);
            }
        }
        //检测手机号是否已被注册

        //检测身份证号码是否存在
        boolean isExist = checkByIdCard(leaseAccount.getIdCard(), leaseAccount.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", leaseAccount.getIdCard());
            throw new GMException(GMExceptionConstant.IDCARD_REPEAT, backMap);
        }

        leaseAccountService.updateByPrimaryKeySelective(leaseAccount);

        //leaseAccountBankCardService.deleteByAccountId(leaseAccount.getId());

        Map params = Maps.newHashMap();
        params.put("maxSize", maxSize);
        params.put("fileImgFolder", fileImgFolder);
        params.put("accountFileImgFolder", accountFileImgFolder);
        params.put("imgUrl", imgUrl);
        int row = (int) context.update(context, leaseAccount.getType() + "LeaseAccount", leaseAccount, params);

        //LeaseAccountCredit leaseAccountCredit1 = new LeaseAccountCredit.Builder().createBy(5L).build();

        ///////
        //////

        return row;
    }

    public int updateByPrimaryKey(LeaseAccount record) throws GMException {
        int row = leaseAccountService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccount selectByPrimaryKey(Long id) throws GMException {
        LeaseAccount leaseAccount = leaseAccountService.selectByPrimaryKey(id);
        return leaseAccount;
    }

    /**
     * 详细信息/修改回显信息
     * 个人用户 、 公司用户
     *
     * @param id
     * @param type
     * @return
     * @throws GMException
     */
    public LeaseAccount selectBy(Long id, Integer type) throws GMException {

        if (!type.equals(1) && !type.equals(0))
            throw new GMException(GMExceptionConstant.ACCOUNT_TYPE_ERROR);

        Map params = Maps.newHashMap();
        params.put("id", id);
        LeaseAccount leaseAccount = (LeaseAccount) context.select(context, type + "LeaseAccount", null, params);
        //LeaseAccount leaseAccount = leaseAccountService.selectByPrimaryKey(id);
        return leaseAccount;
    }

    public List<LeaseAccountExcel> findAllByExcel(Object o) {

        List<LeaseAccountExcel> leaseAccountExcels = leaseAccountService.findAllByExcel(o);
        return leaseAccountExcels;
    }


    public int insertList(List<LeaseAccount> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     * 个人用户 、 公司用户
     *
     * @param pageNum
     * @param pageSize
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public PageInfo<LeaseAccount> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        Integer type = (Integer) paramsMap.get("type");

        if (!type.equals(1) && !type.equals(0))
            throw new GMException(GMExceptionConstant.ACCOUNT_TYPE_ERROR);

        paramsMap.put("pageNum", pageNum);
        paramsMap.put("pageSize", pageSize);
        PageInfo<LeaseAccount> page = (PageInfo<LeaseAccount>) context.find(context, type + "LeaseAccount", null, paramsMap);
        //PageInfo<LeaseAccount> page = leaseAccountService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAccount> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccount> leaseAccountList = leaseAccountService.findAll(paramsMap);
        return leaseAccountList;
    }

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @param deviceId
     * @return
     * @throws GMException
     */
    public ResultHashMap accountLogin(String phone, String password, String deviceId) throws GMException {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("phone", phone);
        paramsMap.put("deviceId", deviceId);

        List<LeaseAccount> leaseAccountList = leaseAccountService.findByPhone(paramsMap);
        if (leaseAccountList == null || leaseAccountList.size() <= 0) {
            throw new GMException(GMExceptionConstant.ACCOUNT_PHONE_IS_NOT_REPEAT);
        }
        LeaseAccount leaseAccount = leaseAccountList.get(0);

        switch (leaseAccount.getStatus()) {
            case 0:
                throw new GMException(GMExceptionConstant.ACCOUNT_IS_LOCK);//账号锁定
            case 2:
                throw new GMException(GMExceptionConstant.ACCOUNT_PASSWORD_IS_WITHDRAW);//账号注销
        }

        String accountPassword = MD5Util.string2MD5(password + leaseAccount.getPhone() + leaseAccount.getCredentialsSalt());
        if (!leaseAccount.getPassword().equals(accountPassword)) {
            throw new GMException(GMExceptionConstant.ACCOUNT_PASSWORD_IS_ERROR);//账号密码错误
        }

        //注册用户/承租人登录状态session
        LeaseAccountSession leaseAccountSession = new LeaseAccountSession();
        leaseAccountSession.setAccountId(leaseAccount.getId());
        leaseAccountSession.setPhone(leaseAccount.getPhone());
        leaseAccountSession.setRealName(leaseAccount.getRealName());
        leaseAccountSession.setDeviceId(deviceId);
        DateTime dateTime = DateTime.now();
        leaseAccountSession.setSessionLoginTime(dateTime.toDate());
        DateTime limitDateTime = dateTime.plusHours(2);//2小时后过期
        leaseAccountSession.setSessionLimitTime(limitDateTime.toDate());
        String token = MD5Util.string2MD5(MD5Util.string2MD5(MD5Util.string2MD5(accountPassword) + deviceId) + System.currentTimeMillis());//token加密
        leaseAccountSession.setSessionCurrent(token);
        leaseAccountSessionService.deleteByDeviceIdAndPhone(paramsMap);
        leaseAccountSessionService.insertSelective(leaseAccountSession);
        //注册用户/承租人登录状态session

        //登录用户实体
        LoginLeaseAccount loginAccount = new LoginLeaseAccount();
        loginAccount.setAccountId(leaseAccount.getId());
        loginAccount.setRealName(leaseAccount.getRealName());
        loginAccount.setPhone(leaseAccount.getPhone());
        loginAccount.setIcon(StringUtils.isEmpty(leaseAccount.getIcon()) ? null : leaseAccount.getIcon());
        loginAccount.setStatus(leaseAccount.getStatus());
        loginAccount.setToken(token);
        //登录用户实体

        Object object = ListUtil.objectIsNullToList(loginAccount);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.LOGIN_SUCCESS);
        return resultHashMap;
    }

    public List<LeaseAccount> selectAllAccountNoPage(Map<String, Object> paramsMap) throws GMException {
        Integer type = (Integer) paramsMap.get("type");

        if (!type.equals(1) && !type.equals(0))
            throw new GMException(GMExceptionConstant.ACCOUNT_TYPE_ERROR);
        List<LeaseAccount> leaseAccountList = (List<LeaseAccount>) context.findAll(context, type + "LeaseAccount", null, paramsMap);
        //List<LeaseAccount> leaseAccountList = leaseAccountService.selectAllAccountNoPage(paramsMap);
        return leaseAccountList;
    }

    /**
     * 新增/注册
     *
     * @param leaseAccount
     * @return
     */
    public ResultHashMap accountRegister(LeaseAccount leaseAccount) throws GMException {

        if (!leaseAccount.getType().equals(1) && !leaseAccount.getType().equals(0))
            throw new GMException(GMExceptionConstant.ACCOUNT_TYPE_ERROR);

        //检测手机号是否已被其他承租人注册
        Map paramsMap = Maps.newHashMap();
        paramsMap.put("phone", leaseAccount.getPhone());
        paramsMap.put("id", leaseAccount.getId());
        List<LeaseAccount> leaseAccountList = leaseAccountService.findByPhone(paramsMap);
        if (leaseAccountList != null) {
            if (leaseAccountList.size() > 0) {
                Map backMap = Maps.newHashMap();
                backMap.put("key", leaseAccount.getPhone());
                throw new GMException(GMExceptionConstant.ACCOUNT_PHONE_IS_REPEAT, backMap);
            }
        }
        //检测手机号是否已被其他承租人注册

        //检测身份证号码是否已被其他承租人注册
        boolean isExist = checkByIdCard(leaseAccount.getIdCard(), leaseAccount.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", leaseAccount.getIdCard());
            throw new GMException(GMExceptionConstant.IDCARD_REPEAT, backMap);
        }
        //检测身份证号码是否已被其他承租人注册

        //初始化密码
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        leaseAccount.setSalt(randomNumberGenerator.nextBytes().toHex());
        String accountPassword = MD5Util.string2MD5(leaseAccount.getPassword() + leaseAccount.getPhone() + leaseAccount.getCredentialsSalt());
        leaseAccount.setPassword(accountPassword);
        //初始化密码

        Map params = Maps.newHashMap();
        params.put("maxSize", maxSize);
        params.put("fileImgFolder", fileImgFolder);
        params.put("accountFileImgFolder", accountFileImgFolder);
        params.put("imgUrl", imgUrl);

        //插入注册用户/承租人
        context.insert(context, leaseAccount.getType() + "LeaseAccount", leaseAccount, params);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * @param id
     * @return
     */
    public int deleteByAccountCompany(Long id) throws GMException {
        int row = leaseAccountService.deleteByAccountCompany(id);
        return row;
    }

    @Override
    public int deleteByPrimaryKey(Long id) throws GMException {
        return 0;
    }


    public LeaseAccountImportExcelBackInfo importAccountExcel(List<LeaseAccountExcelTemplate> leaseAccountExcelTemplateList) throws GMException {

        LeaseAccountImportExcelBackInfo leaseAccountImportExcelBackInfo = null;
        ArrayList<LeaseAccount> leaseWxCarListInsert = new ArrayList<LeaseAccount>();
        ArrayList<LeaseAccount> leaseWxCarListUpdate = new ArrayList<LeaseAccount>();
        int successNum = 0;
        int failNum = 0;
        if (leaseAccountExcelTemplateList != null && leaseAccountExcelTemplateList.size() > 0) {
            for (LeaseAccountExcelTemplate leaseAccountExcelTemplate : leaseAccountExcelTemplateList) {

                String name = leaseAccountExcelTemplate.getName();
                String idCard = leaseAccountExcelTemplate.getIdCard();
                String sex = leaseAccountExcelTemplate.getSex();
                String phone = leaseAccountExcelTemplate.getPhone();
                String driverLicenseNumber = leaseAccountExcelTemplate.getDriverLicenseNumber();

                if (StringUtils.isBlank(name) || StringUtils.isBlank(idCard)
                        || StringUtils.isBlank(phone) || StringUtils.isBlank(sex) || StringUtils.isBlank(driverLicenseNumber)
                        ) {
                    leaseAccountExcelTemplate.setUpdateState("失败");
                    failNum++;
                    continue;
                }

                LeaseAccount leaseAccount = new LeaseAccount();
                leaseAccount.setName(leaseAccountExcelTemplate.getName());
                leaseAccount.setPhone(leaseAccountExcelTemplate.getPhone());
                if ("男".equals(leaseAccountExcelTemplate.getSex())) {
                    leaseAccount.setSex(1);
                } else {
                    leaseAccount.setSex(0);
                }

                leaseAccount.setIdCard(leaseAccountExcelTemplate.getIdCard());
                leaseAccount.setType(0);
                leaseAccount.setRealName(leaseAccountExcelTemplate.getName());
                //leaseAccount.setStatus(1);

                if (leaseAccountExcelTemplate.getMaritalStatus() != null) {
                    if ("已婚".equals(leaseAccountExcelTemplate.getMaritalStatus())) {
                        leaseAccount.setMaritalStatus(0);
                    } else if ("未婚".equals(leaseAccountExcelTemplate.getMaritalStatus())) {
                        leaseAccount.setMaritalStatus(1);
                    } else if ("其他".equals(leaseAccountExcelTemplate.getMaritalStatus())) {
                        leaseAccount.setMaritalStatus(3);
                    }
                }

                leaseAccount.setCreateTime(DateTime.now().toDate());
                leaseAccount.setUpdateTime(DateTime.now().toDate());
                LeaseAccountCredit leaseAccountCredit = new LeaseAccountCredit();
                leaseAccountCredit.setOtherPhone(leaseAccountExcelTemplate.getOtherPhone());

                leaseAccountCredit.setIdCardAddress(leaseAccountExcelTemplate.getIdCardAddress());
                leaseAccountCredit.setLiveAddress(leaseAccountExcelTemplate.getLiveAddress());
                leaseAccountCredit.setZipCode(leaseAccountExcelTemplate.getZipCode());
                leaseAccountCredit.setIdCard(leaseAccountExcelTemplate.getIdCard());
                leaseAccountCredit.setHousingType(leaseAccountExcelTemplate.getHousingType());
                leaseAccountCredit.setSpouseIdCard(leaseAccountExcelTemplate.getSpouseIdCard());
                leaseAccountCredit.setSpouseName(leaseAccountExcelTemplate.getSpouseName());
                leaseAccountCredit.setWorkUnit(leaseAccountExcelTemplate.getWorkUnit());
                leaseAccountCredit.setWorkUnitPhone(leaseAccountExcelTemplate.getWorkUnitPhone());
                leaseAccountCredit.setHalfYearMonthIncome(leaseAccountExcelTemplate.getHalfYearMonthIncome());
                leaseAccountCredit.setDriverLicenseNumber(leaseAccountExcelTemplate.getDriverLicenseNumber());

                if (leaseAccountExcelTemplate.getEmergencyContactExcelTemplates() != null && leaseAccountExcelTemplate.getEmergencyContactExcelTemplates().size() > 0) {
                    List<EmergencyContactExcelTemplate> emergencyContactExcelTemplates = leaseAccountExcelTemplate.getEmergencyContactExcelTemplates();
                    for (int i = 0; i < emergencyContactExcelTemplates.size(); i++) {
                        emergencyContactExcelTemplates.get(i).setSort(i + 1);
                    }
                    leaseAccountCredit.setEmergencyContact(emergencyContactExcelTemplates);
                }

                Map paramsMap = Maps.newHashMap();
                paramsMap.put("idCard", leaseAccountExcelTemplate.getIdCard().trim());
                List<LeaseAccount> leaseAccountFind = leaseAccountService.findByIdCard(paramsMap);
                if (leaseAccountFind == null || leaseAccountFind.size() <= 0) {
                    //不存在则新增
                    LeaseAccount leaseAccountInsert = leaseAccountService.insertSelective(leaseAccount);
                    leaseAccountCredit.setAccountId(leaseAccountInsert.getId());
                    leaseAccountCreditService.insertSelective(leaseAccountCredit);

                } else {
                    //存在则修改
                    for (LeaseAccount account : leaseAccountFind) {
                        leaseAccount.setId(account.getId());
                        leaseAccountService.updateByPrimaryKeySelective(leaseAccount);

                        leaseAccountCredit.setAccountId(account.getId());
                        leaseAccountCreditService.updateByAccountIdPrimaryKeySelective(leaseAccountCredit);
                    }
                }
                leaseAccountExcelTemplate.setUpdateState("成功");
                successNum++;
            }
        }


        leaseAccountImportExcelBackInfo = new LeaseAccountImportExcelBackInfo();
        leaseAccountImportExcelBackInfo.setFailNum(failNum);//失败数量
        leaseAccountImportExcelBackInfo.setSuccessNum(successNum);//成功数量
        leaseAccountImportExcelBackInfo.setBackInfo(null);//反馈信息
        leaseAccountImportExcelBackInfo.setLeaseAccountExcelTemplates(leaseAccountExcelTemplateList);
        return leaseAccountImportExcelBackInfo;
    }

    public EmergencyContactImportExcelBackInfo importEmergencyContactExcel(List<EmergencyContactExcelTemplate> emergencyContactExcelTemplates) throws GMException {

        EmergencyContactImportExcelBackInfo emergencyContactImportExcelBackInfo = null;
        int successNum = 0;
        int failNum = 0;

        if (emergencyContactExcelTemplates != null && emergencyContactExcelTemplates.size() > 0) {

            for (int i = 0; i <= emergencyContactExcelTemplates.size(); i++) {


                emergencyContactExcelTemplates.get(i).getIdCard();

            }
            for (EmergencyContactExcelTemplate emergencyContactExcelTemplate : emergencyContactExcelTemplates) {

                String phone = emergencyContactExcelTemplate.getIdCard();
                String emergencyContactName = emergencyContactExcelTemplate.getEmergencyContactName();
                if (StringUtils.isBlank(phone) || StringUtils.isBlank(emergencyContactName)
                        ) {
                    //emergencyContactExcelTemplate.setUpdateState("失败");
                    failNum++;
                    continue;
                }


                Map paramsMap = Maps.newHashMap();
                paramsMap.put("idCard(", emergencyContactExcelTemplate.getIdCard().trim());
                List<LeaseAccount> leaseAccountFind = leaseAccountService.findByIdCard(paramsMap);
                if (leaseAccountFind == null || leaseAccountFind.size() <= 0) {
                    //emergencyContactExcelTemplate.setUpdateState("失败");
                    failNum++;
                    continue;

                } else {

                    LeaseAccountCredit leaseAccountCredit = new LeaseAccountCredit();


                }


            }


        }


        return null;
    }

    /**
     * 协议支付签约短信触发
     * 承租人银行卡通联协议支付签约 2步之1
     *
     * @param quickSendMessageVo
     * @return
     */
    @Override
    public QuickReturnMessage sendMessage(QuickSendMessageVo quickSendMessageVo, DubboTreaceParames dubboTreaceParames) throws GMException {

        //发送 协议支付签约短信
        QuickData data = new QuickData();
        data.setAccountName(quickSendMessageVo.getAccountName());//姓名
        data.setAccountNo(quickSendMessageVo.getAccountNo());//银行卡号
        data.setBankCode(quickSendMessageVo.getBankCode());//银行代码
        data.setId(quickSendMessageVo.getIdCard());//身份证号
        data.setTel(quickSendMessageVo.getBankPhone());//银行预留电话
        data.setIdType(AllinpayIdTypeEnum.ID_TYPE_0.getCode());//开户证件类型
        data.setAccountProp("00");//账户属性 0私人，1公司。不填时，默认为私人0
        data.setAccountType(AllinpayAccountTypeEnum.BANK_CARD.getCode());//账户类型 00银行卡，01存折，02信用卡。不填默认为银行卡00。
        QuickReturnMessage quickReturnMessage = tranxAdapter.sendMessage(data);
        //发送 协议支付签约短信

        CheckCode.checkBankPaySin(quickReturnMessage);//根据通联反馈码 判定 通联处理结果

        //缓存 原请求流水 / 对应申请请求报文中的REQ_SN、协议支付签约用到
        //手机号+银行卡号做 键
        shardedJedisTemplate.setex(data.getTel() + data.getAccountNo(), quickReturnMessage.getReqSn(), 600);

        return quickReturnMessage;
    }

    /**
     * 协议支付签约
     * 承租人银行卡通联协议支付签约 2步之2
     *
     * @param quickSendMessageVo
     * @param userSession
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public ResultHashMap sign(QuickSendMessageVo quickSendMessageVo, UserSession userSession, DubboTreaceParames dubboTreaceParames) throws GMException {

        //检测银行卡是否已经签约
        LeaseAccountBankPaySin leaseAccountBankPaySin = leaseAccountBankPaySinService.findByBankCardNumber(quickSendMessageVo.getAccountNo());
        if (leaseAccountBankPaySin != null) {
            if (leaseAccountBankPaySin.getStatus() == AccountBankPaySinStatus.AccountBankPaySinStatus_1.getVal() || leaseAccountBankPaySin.getStatus() == AccountBankPaySinStatus.AccountBankPaySinStatus_2.getVal()) {
                throw new GMException(GMExceptionConstant.ALLINPAY_SIGN_BANKCARDNUMBER_ISSIGN);
            }
        }
        //检测银行卡是否已经签约

        //redis缓存中取出 原请求流水
        String srcreqSn = shardedJedisTemplate.getAsList(quickSendMessageVo.getBankPhone() + quickSendMessageVo.getAccountNo());
        if (StringUtils.isEmpty(srcreqSn)) throw new GMException(GMExceptionConstant.ALLINPAY_SIGN_ERROR);
        //redis缓存中取出 原请求流水

        //协议支付签约
        QuickData data = new QuickData();
        data.setTel(quickSendMessageVo.getBankPhone());//银行预留电话
        data.setAccountNo(quickSendMessageVo.getAccountNo());//银行卡号
        data.setVercode(quickSendMessageVo.getVercode());//验证码
        data.setSrcreqSn(srcreqSn);//原请求流水、对应申请请求报文中的REQ_SN
        QuickReturnMessage quickReturnMessage = tranxAdapter.sign(data);
        //协议支付签约

        /*
        CheckCode.checkBankPaySin(quickReturnMessage);//根据通联反馈码 判定 通联处理结果
        ///////////////////上面的通联处理不成功则不处理插入数据库////////////////////
        */

        AccountBankCardSignStrategyCommonVo accountBankCardSignStrategyCommonVo = new AccountBankCardSignStrategyCommonVo();
        accountBankCardSignStrategyCommonVo.setLeaseAccountBankPaySin(leaseAccountBankPaySin);
        accountBankCardSignStrategyCommonVo.setQuickReturnMessage(quickReturnMessage);
        accountBankCardSignStrategyCommonVo.setQuickSendMessageVo(quickSendMessageVo);
        accountBankCardSignStrategyCommonVo.setSrcreqSn(srcreqSn);
        accountBankCardSignStrategyCommonVo.setUserSession(userSession);

        context.insert(context, quickSendMessageVo.getType() + "LeaseAccountBankCardSign", accountBankCardSignStrategyCommonVo, dubboTreaceParames);//

        Integer status = CheckCode.checkBankPaySinStatus(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode());
        //成功则清除redis缓存
        if (status.equals(1))
            shardedJedisTemplate.del(quickSendMessageVo.getTel() + quickSendMessageVo.getAccountNo());//清除redis缓存
        //成功则清除redis缓存

        ResultHashMap resultHashMap = CheckCode.checkBankPaySinBack(quickReturnMessage);
        return resultHashMap;
    }

    @Override
    public int updateAccountNameByAccountId(LeaseAccount leaseAccount) {
        int row = leaseAccountService.updateAccountNameByAccountId(leaseAccount);
        return row;
    }
}
