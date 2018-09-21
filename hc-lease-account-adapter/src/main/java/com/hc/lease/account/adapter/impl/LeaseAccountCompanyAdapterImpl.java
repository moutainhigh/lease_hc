package com.hc.lease.account.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.account.adapter.api.LeaseAccountCompanyAdapter;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountCompany;
import com.hc.lease.account.service.api.LeaseAccountCompanyService;
import com.hc.lease.account.service.api.LeaseAccountService;
import com.hc.lease.account.vo.LeaseAccountCompanyExcel;
import com.hc.lease.baseInfo.model.LeaseBank;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseBankService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.service.api.LeaseUseUsedService;
import com.hc.lease.common.core.constant.AccountType;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountCompanyExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountCompanyImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountImportExcelBackInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import hc.lease.common.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 注册公司类型用户AdapterImpl
 *
 * @author Tong
 * @version 2017-11-02
 */
@Service("leaseAccountCompanyAdapter")
public class LeaseAccountCompanyAdapterImpl implements LeaseAccountCompanyAdapter {

    @Autowired
    private LeaseAccountCompanyService leaseAccountCompanyService;

    @Autowired
    private LeaseAccountService leaseAccountService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;
    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseBankService leaseBankService;

    /**
     * 检测数据是否存在
     *
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkByAccountIsExist(Long id) throws GMException {
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
                LeaseAccount leaseAccount = leaseAccountService.selectByPrimaryKey(id);
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
        Map<String, Object> isExist = checkByAccountIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        leaseAccountService.deleteByPrimaryKey(id);
        int row = leaseAccountCompanyService.deleteByAccountId(id);
        leaseUseUsedService.deleteByUse(id, UseType.TYPE_LEASE_ACCOUNT);
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
        int row = leaseAccountCompanyService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAccountCompany record) throws GMException {
        record = leaseAccountCompanyService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAccountCompany record) throws GMException {
        record = leaseAccountCompanyService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 修改
     *
     * @param leaseAccountCompany
     * @return
     * @throws GMException
     */
    public int updateByPrimaryKeySelective(LeaseAccountCompany leaseAccountCompany) throws GMException {

        LeaseAccount leaseAccount = new LeaseAccount();
        leaseAccount.setName(leaseAccountCompany.getContactsName());
        leaseAccount.setPhone(leaseAccountCompany.getContactsPhone());
        leaseAccount.setIdCard(leaseAccountCompany.getLegalPersonIdCard());
        leaseAccount.setId(leaseAccountCompany.getId());

        //检测手机号(联系电话)是否已被注册
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
        //检测手机号(联系电话)是否已被注册

        //检测身份证号码是否存在
        boolean isExist = checkByIdCard(leaseAccount.getIdCard(), leaseAccount.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", leaseAccount.getIdCard());
            throw new GMException(GMExceptionConstant.IDCARD_REPEAT, backMap);
        }

        leaseAccountService.updateByPrimaryKeySelective(leaseAccount);

        leaseAccountCompany.setAccountId(leaseAccountCompany.getId());
        int row = leaseAccountCompanyService.updateByAccountId(leaseAccountCompany);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountCompany record) throws GMException {
        int row = leaseAccountCompanyService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccountCompany selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountCompany leaseAccountCompany = leaseAccountCompanyService.selectByPrimaryKey(id);
        return leaseAccountCompany;
    }

    public int insertList(List<LeaseAccountCompany> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountCompany> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAccountCompany> page = leaseAccountCompanyService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAccountCompany> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountCompany> leaseAccountCompanyList = leaseAccountCompanyService.findAll(paramsMap);
        return leaseAccountCompanyList;
    }

    /**
     * 新增/注册
     *
     * @param leaseAccountCompany
     * @return
     */
    public ResultHashMap accountRegister(LeaseAccountCompany leaseAccountCompany) throws GMException {

        LeaseAccount leaseAccount = new LeaseAccount();
        leaseAccount.setName(leaseAccountCompany.getContactsName());
        leaseAccount.setPhone(leaseAccountCompany.getContactsPhone());
        leaseAccount.setIdCard(leaseAccountCompany.getLegalPersonIdCard());
        leaseAccount.setType(AccountType.COMPANY);//用户类型：0:个人;1:公司

        //检测手机号(联系电话)是否已被注册
        Map paramsMap = Maps.newHashMap();
        paramsMap.put("phone", leaseAccount.getPhone());
        paramsMap.put("id", leaseAccount.getId());
        List<LeaseAccount> leaseAccountList = leaseAccountService.findByPhone(paramsMap);
        if (leaseAccountList != null) {
            if (leaseAccountList.size() > 0) {
                Map backMap = Maps.newHashMap();
                backMap.put("key", "phone");
                throw new GMException(GMExceptionConstant.ACCOUNT_PHONE_IS_REPEAT, backMap);
            }
        }
        //检测手机号(联系电话)是否已被注册

        //检测身份证号码是否存在
        boolean isExist = checkByIdCard(leaseAccount.getIdCard(), leaseAccount.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "idCard");
            throw new GMException(GMExceptionConstant.IDCARD_REPEAT, backMap);
        }

        //初始化密码
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        leaseAccount.setSalt(randomNumberGenerator.nextBytes().toHex());
        String accountPassword = MD5Util.string2MD5(leaseAccount.getPassword() + leaseAccount.getPhone() + leaseAccount.getCredentialsSalt());
        leaseAccount.setPassword(accountPassword);
        //初始化密码
        //插入注册用户/承租人
        leaseAccount = leaseAccountService.insertSelective(leaseAccount);

        //注册公司类型用户/承租人信息
        leaseAccountCompany.setAccountId(leaseAccount.getId());
        leaseAccountCompany = leaseAccountCompanyService.insertSelective(leaseAccountCompany);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;

    }

    public List<LeaseAccountCompanyExcel> findAllByCompanyExcel(Object o) {
        List<LeaseAccountCompanyExcel> leaseAccountCompanyExcels = leaseAccountCompanyService.findAllByCompanyExcel(o);

        return leaseAccountCompanyExcels;
    }


    public int updateByAccountId(LeaseAccountCompany leaseAccountCompany) {
        int row = leaseAccountCompanyService.updateByAccountId(leaseAccountCompany);
        return row;
    }

    public LeaseAccountCompanyImportExcelBackInfo importAccountCompanyExcel(List<LeaseAccountCompanyExcelTemplate> leaseAccountCompanyExcelTemplates) throws GMException {

        LeaseAccountCompanyImportExcelBackInfo leaseAccountCompanyImportExcelBackInfo = null;

        int successNum = 0;
        int failNum = 0;
        if (leaseAccountCompanyExcelTemplates != null && leaseAccountCompanyExcelTemplates.size() > 0) {
            for (LeaseAccountCompanyExcelTemplate leaseAccountCompanyExcelTemplate : leaseAccountCompanyExcelTemplates) {
                String companyName = leaseAccountCompanyExcelTemplate.getCompanyName();
                String businessLicenseNumber = leaseAccountCompanyExcelTemplate.getBusinessLicenseNumber();
                String contactsName = leaseAccountCompanyExcelTemplate.getContactsName();
                String contactsPhone = leaseAccountCompanyExcelTemplate.getContactsPhone();
                String contactsAddress = leaseAccountCompanyExcelTemplate.getContactsAddress();
                String companyRegistrationAddress = leaseAccountCompanyExcelTemplate.getCompanyRegistrationAddress();

                if (StringUtils.isBlank(companyName) || StringUtils.isBlank(businessLicenseNumber)
                        || StringUtils.isBlank(contactsName) || StringUtils.isBlank(contactsPhone) || StringUtils.isBlank(contactsAddress)
                        || StringUtils.isBlank(companyRegistrationAddress)
                        ) {
                    leaseAccountCompanyExcelTemplate.setUpdateState("失败");
                    failNum++;
                    continue;
                }

                LeaseBank leaseBank = leaseBankService.findByBankName(leaseAccountCompanyExcelTemplate.getBankName().trim());
                if (leaseBank == null) {
                    leaseAccountCompanyExcelTemplate.setUpdateState("失败");
                    failNum++;
                    continue;
                }

                LeaseAccount leaseAccount = new LeaseAccount();
                leaseAccount.setName(leaseAccountCompanyExcelTemplate.getCompanyName());
                leaseAccount.setPhone(leaseAccountCompanyExcelTemplate.getContactsPhone());
                leaseAccount.setType(1);
                leaseAccount.setRealName(leaseAccountCompanyExcelTemplate.getCompanyName());
                leaseAccount.setCompanyName(leaseAccountCompanyExcelTemplate.getCompanyName());
                //leaseAccount.setStatus(1);
                leaseAccount.setCreateTime(DateTime.now().toDate());
                leaseAccount.setUpdateTime(DateTime.now().toDate());


                LeaseAccountCompany leaseAccountCompany = new LeaseAccountCompany();
                leaseAccountCompany.setCompanyName(leaseAccountCompanyExcelTemplate.getCompanyName());
                leaseAccountCompany.setContactsName(leaseAccountCompanyExcelTemplate.getContactsName());
                leaseAccountCompany.setContactsPhone(leaseAccountCompanyExcelTemplate.getContactsPhone());
                leaseAccountCompany.setContactsAddress(leaseAccountCompanyExcelTemplate.getContactsAddress());
                leaseAccountCompany.setCompanyRegistrationAddress(leaseAccountCompanyExcelTemplate.getCompanyRegistrationAddress());
                leaseAccountCompany.setBusinessLicenseNumber(leaseAccountCompanyExcelTemplate.getBusinessLicenseNumber());
                leaseAccountCompany.setRemark(leaseAccountCompanyExcelTemplate.getRemark());
                leaseAccountCompany.setBankAccountName(leaseAccountCompanyExcelTemplate.getBankAccountName());
                leaseAccountCompany.setBankId(leaseBank.getId());
                leaseAccountCompany.setBranchBank(leaseAccountCompanyExcelTemplate.getBranchBank());
                leaseAccountCompany.setBackCardNumber(leaseAccountCompanyExcelTemplate.getBackCardNumber());

                Map paramsMap = Maps.newHashMap();
                paramsMap.put("phone", leaseAccountCompanyExcelTemplate.getContactsPhone().trim());
                List<LeaseAccount> leaseAccountFind = leaseAccountService.findByPhone(paramsMap);
                if (leaseAccountFind == null || leaseAccountFind.size() <= 0) {
                    //没有则新增
                    LeaseAccount leaseAccountInsert = leaseAccountService.insertSelective(leaseAccount);
                    leaseAccountCompany.setAccountId(leaseAccountInsert.getId());
                    leaseAccountCompanyService.insertSelective(leaseAccountCompany);
                } else {

                    for (LeaseAccount account : leaseAccountFind) {
                        leaseAccount.setId(account.getId());
                        leaseAccountService.updateByPrimaryKeySelective(leaseAccount);
                        leaseAccountCompany.setAccountId(account.getId());
                        leaseAccountCompanyService.updateByAccountId(leaseAccountCompany);
                    }
                }

                leaseAccountCompanyExcelTemplate.setUpdateState("成功");
                successNum++;

            }

        }

        leaseAccountCompanyImportExcelBackInfo = new LeaseAccountCompanyImportExcelBackInfo();
        leaseAccountCompanyImportExcelBackInfo.setFailNum(failNum);//失败数量
        leaseAccountCompanyImportExcelBackInfo.setSuccessNum(successNum);//成功数量
        leaseAccountCompanyImportExcelBackInfo.setBackInfo(null);//反馈信息
        leaseAccountCompanyImportExcelBackInfo.setLeaseAccountCompanyExcelTemplates(leaseAccountCompanyExcelTemplates);
        return leaseAccountCompanyImportExcelBackInfo;

    }
}
