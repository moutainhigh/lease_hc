package com.hc.lease.account.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.service.api.LeaseAccountService;
import com.hc.lease.account.vo.LeaseAccountBankExcel;
import com.hc.lease.baseInfo.model.LeaseBank;
import com.hc.lease.baseInfo.service.api.LeaseBankService;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountBankExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountBankImportExcelBackInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.account.adapter.api.LeaseAccountBankCardAdapter;
import com.hc.lease.account.service.api.LeaseAccountBankCardService;
import com.hc.lease.account.model.LeaseAccountBankCard;

import hc.lease.common.util.ListUtil;

import java.util.List;
import java.util.Map;

import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 承租人银行卡AdapterImpl
 *
 * @author Qiang
 * @version 2018-01-15
 */
@Service("leaseAccountBankCardAdapter")
public class LeaseAccountBankCardAdapterImpl implements LeaseAccountBankCardAdapter {

    @Autowired
    private LeaseAccountBankCardService leaseAccountBankCardService;

    @Autowired
    private LeaseBankService leaseBankService;
    @Autowired
    private LeaseAccountService leaseAccountService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public List<LeaseAccountBankExcel> findAllByExcel(Object o) {

        List<LeaseAccountBankExcel> leaseAccountBankExcels = leaseAccountBankCardService.findAllByExcel(o);

        return leaseAccountBankExcels;
    }


    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountBankCardService.deleteByPrimaryKey(id);
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
        int row = leaseAccountBankCardService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAccountBankCard record) throws GMException {
        record = leaseAccountBankCardService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAccountBankCard record) throws GMException {
        record = leaseAccountBankCardService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAccountBankCard record) throws GMException {
        int row = leaseAccountBankCardService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountBankCard record) throws GMException {
        int row = leaseAccountBankCardService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccountBankCard selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountBankCard leaseAccountBankCard = leaseAccountBankCardService.selectByPrimaryKey(id);
        return leaseAccountBankCard;
    }

    public int insertList(List<LeaseAccountBankCard> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountBankCard> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAccountBankCard> page = leaseAccountBankCardService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAccountBankCard> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountBankCard> leaseAccountBankCardList = leaseAccountBankCardService.findAll(paramsMap);
        return leaseAccountBankCardList;
    }


    public LeaseAccountBankImportExcelBackInfo importAccountBankCardExcel(List<LeaseAccountBankExcelTemplate> leaseAccountBankExcelTemplates) throws GMException {

        LeaseAccountBankImportExcelBackInfo leaseAccountBankImportExcelBackInfo = null;
        int successNum = 0;
        int failNum = 0;

        if (leaseAccountBankExcelTemplates != null && leaseAccountBankExcelTemplates.size() > 0) {

            for (LeaseAccountBankExcelTemplate leaseAccountBankExcelTemplate : leaseAccountBankExcelTemplates) {
                String idCard = leaseAccountBankExcelTemplate.getIdCard();
                String backCardNumber = leaseAccountBankExcelTemplate.getBackCardNumber();
                String bankName = leaseAccountBankExcelTemplate.getBankName();
                String branchBank = leaseAccountBankExcelTemplate.getBranchBank();
                String bankPhone = leaseAccountBankExcelTemplate.getBankPhone();

                if (StringUtils.isBlank(idCard) || StringUtils.isBlank(backCardNumber)
                        || StringUtils.isBlank(bankName) || StringUtils.isBlank(branchBank) || StringUtils.isBlank(bankPhone)
                        ) {
                    leaseAccountBankExcelTemplate.setUpdateState("失败");
                    failNum++;
                    continue;
                }
                LeaseBank leaseBank = leaseBankService.findByBankName(leaseAccountBankExcelTemplate.getBankName().trim());
                if (leaseBank == null) {
                    leaseAccountBankExcelTemplate.setUpdateState("失败");
                    failNum++;
                    continue;
                }
                Map paramsMap = Maps.newHashMap();
                paramsMap.put("idCard", leaseAccountBankExcelTemplate.getIdCard().trim());
                List<LeaseAccount> accountFind = leaseAccountService.findByIdCard(paramsMap);
                if (accountFind == null || accountFind.size() <= 0) {
                    leaseAccountBankExcelTemplate.setUpdateState("失败");
                    failNum++;
                    continue;
                }

                //查询数据库里相同卡号的数据

                Map<String, Object> params = Maps.newHashMap();
                params.put("accountId", accountFind.get(0).getId());
                params.put("backCardNumber", leaseAccountBankExcelTemplate.getBackCardNumber());
                LeaseAccountBankCard _leaseAccountBankCard = leaseAccountBankCardService.findByAccountIdAndBackCardNumber(params);

                LeaseAccountBankCard leaseAccountBankCard = new LeaseAccountBankCard();
                leaseAccountBankCard.setBankAccountName(accountFind.get(0).getName());
                leaseAccountBankCard.setAccountId(accountFind.get(0).getId());
                leaseAccountBankCard.setBackCardNumber(leaseAccountBankExcelTemplate.getBackCardNumber());
                leaseAccountBankCard.setBranchBank(leaseAccountBankExcelTemplate.getBranchBank());
                leaseAccountBankCard.setBankPhone(leaseAccountBankExcelTemplate.getBankPhone());
                leaseAccountBankCard.setBankId(leaseBank.getId());

                if (_leaseAccountBankCard == null) {
                    leaseAccountBankCardService.insertSelective(leaseAccountBankCard);
                } else {
                    //存在则修改
                    leaseAccountBankCard.setId(_leaseAccountBankCard.getId());
                    leaseAccountBankCardService.updateByPrimaryKeySelective(leaseAccountBankCard);
                }
                leaseAccountBankExcelTemplate.setUpdateState("成功");
                successNum++;
            }

        }

        leaseAccountBankImportExcelBackInfo = new LeaseAccountBankImportExcelBackInfo();
        leaseAccountBankImportExcelBackInfo.setFailNum(failNum);//失败数量
        leaseAccountBankImportExcelBackInfo.setSuccessNum(successNum);//成功数量
        leaseAccountBankImportExcelBackInfo.setBackInfo(null);//反馈信息
        leaseAccountBankImportExcelBackInfo.setLeaseAccountBankExcelTemplates(leaseAccountBankExcelTemplates);
        return leaseAccountBankImportExcelBackInfo;
    }

    @Override
    public LeaseAccountBankCard findByAccountIdAndId(Map<String, Object> paramsMap) throws GMException {
        LeaseAccountBankCard leaseAccountBankCard = leaseAccountBankCardService.findByAccountIdAndId(paramsMap);
        return leaseAccountBankCard;
    }

    /**
     * 根据 手机、身份证、银行主键Id、银行卡或存折号码 查询
     *
     * @param params
     * @return
     */
    @Override
    public List<LeaseAccountBankCard> findByAccountInfo(Map<String, Object> params) {
        List<LeaseAccountBankCard> leaseAccountBankCardList = leaseAccountBankCardService.findByAccountInfo(params);
        return leaseAccountBankCardList;
    }

    @Override
    public int updateAccountNameByAccountId(LeaseAccountBankCard leaseAccountBankCard) {
        int row = leaseAccountBankCardService.updateAccountNameByAccountId(leaseAccountBankCard);
        return row;
    }
}
