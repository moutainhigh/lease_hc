package com.hc.lease.account.strategy.impl;

import com.aipg.quickpay.QuickSendIsAddAccountEnum;
import com.google.common.collect.Maps;
import com.hc.lease.account.adapter.api.LeaseAccountBankCardSignStrategyCommon;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.model.LeaseAccountCredit;
import com.hc.lease.account.service.api.LeaseAccountBankCardService;
import com.hc.lease.account.service.api.LeaseAccountCreditService;
import com.hc.lease.account.service.api.LeaseAccountService;
import com.hc.lease.account.vo.AccountBankCardSignStrategyCommonVo;
import com.hc.lease.common.allinpay.model.QuickSendMessageVo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.strategy.Strategy;
import hc.lease.common.util.MD5Util;
import hc.lease.common.util.SpringContextHolder;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 策略模式
 * 协议支付签约
 * 新增承租人签约
 * Created by tong on 2017/11/3.
 */
public class LeaseAccountBankCardSignAddStrategy implements Strategy {

    /**
     * 处理过程：用 银行卡号、银行主键Id、手机号 检测是否存在承租人的银行卡数据
     * 存在则直接签约，不存在则检测承租人是否存在，不存在承租人则新增承租人
     *
     * @param object
     * @param object1
     * @param object2
     * @return
     * @throws GMException
     */
    @Override
    public Object insert(Object object, Object object1, Object object2) throws GMException {
        Date nowDate = DateTime.now().toDate();
        DubboTreaceParames dubboTreaceParames = (DubboTreaceParames) object2;
        AccountBankCardSignStrategyCommonVo accountBankCardSignStrategyCommonVo = (AccountBankCardSignStrategyCommonVo) object1;

        QuickSendMessageVo quickSendMessageVo = accountBankCardSignStrategyCommonVo.getQuickSendMessageVo();

        LeaseAccountService leaseAccountService = (LeaseAccountService) SpringContextHolder.getBean("leaseAccountService");
        LeaseAccountBankCardSignStrategyCommon leaseAccountBankCardSignStrategyCommon = (LeaseAccountBankCardSignStrategyCommon) SpringContextHolder.getBean("leaseAccountBankCardSignStrategyCommon");
        LeaseAccountBankCardService leaseAccountBankCardService = (LeaseAccountBankCardService) SpringContextHolder.getBean("leaseAccountBankCardService");
        LeaseAccountCreditService leaseAccountCreditService = (LeaseAccountCreditService) SpringContextHolder.getBean("leaseAccountCreditService");

        //如果是新增承租人签约则处理插入承租人数据
        if (quickSendMessageVo.getIsAddAccount() == QuickSendIsAddAccountEnum.TYPE_1.getCode()) {//通联协议支付签约 成为承租人：1:是;0:否
            //检测是否已存在承租人的银行卡
            Map<String, Object> params = Maps.newHashMap();
            params.put("backCardNumber", quickSendMessageVo.getAccountNo());
            params.put("bankId", quickSendMessageVo.getBankId());
            params.put("phone", quickSendMessageVo.getTel());
            params.put("idCard", quickSendMessageVo.getIdCard());
            List<LeaseAccountBankCard> leaseAccountBankCardList = leaseAccountBankCardService.findByAccountInfo(params);
            //检测是否已存在承租人的银行卡
            if (leaseAccountBankCardList != null && leaseAccountBankCardList.size() > 0) {
                LeaseAccountBankCard leaseAccountBankCard = leaseAccountBankCardList.get(0);
                quickSendMessageVo.setAccountId(leaseAccountBankCard.getAccountId());
                quickSendMessageVo.setBankCardId(leaseAccountBankCard.getId());
            } else {

                LeaseAccount leaseAccount = null;
                //承租人是否存在
                List<LeaseAccount> leaseAccountList = leaseAccountService.findByIdCard(params);//
                if (leaseAccountList != null && leaseAccountList.size() > 0) {
                    leaseAccount = leaseAccountList.get(0);
                } else {

                    //插入承租人数据
                    leaseAccount = new LeaseAccount();
                    leaseAccount.setRealName(quickSendMessageVo.getAccountName());
                    leaseAccount.setName(quickSendMessageVo.getAccountName());
                    leaseAccount.setType(0);
                    leaseAccount.setPhone(quickSendMessageVo.getTel());
                    leaseAccount.setSex(1);
                    leaseAccount.setIdCard(quickSendMessageVo.getIdCard());
                    //初始化密码
                    RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
                    leaseAccount.setSalt(randomNumberGenerator.nextBytes().toHex());
                    String accountPassword = MD5Util.string2MD5("123456" + quickSendMessageVo.getTel() + leaseAccount.getCredentialsSalt());
                    leaseAccount.setPassword(accountPassword);
                    //初始化密码
                    leaseAccount = leaseAccountService.insertSelective(leaseAccount);
                    LeaseAccountCredit leaseAccountCredit = new LeaseAccountCredit();
                    leaseAccountCredit.setAccountId(leaseAccount.getId());
                    leaseAccountCredit.setBackCardNumber(quickSendMessageVo.getAccountNo());
                    leaseAccountCredit.setBankId(quickSendMessageVo.getBankId());
                    leaseAccountCredit.setIdCard(quickSendMessageVo.getIdCard());
                    leaseAccountCredit = leaseAccountCreditService.insertSelective(leaseAccountCredit);
                    //插入承租人数据

                }

                //插入 承租人银行卡 数据
                LeaseAccountBankCard leaseAccountBankCard = new LeaseAccountBankCard();
                leaseAccountBankCard.setAccountId(leaseAccount.getId());
                leaseAccountBankCard.setBankPhone(quickSendMessageVo.getBankPhone());
                leaseAccountBankCard.setBankAccountName(leaseAccount.getName());
                leaseAccountBankCard.setBankId(quickSendMessageVo.getBankId());
                leaseAccountBankCard.setBackCardNumber(quickSendMessageVo.getAccountNo());
                leaseAccountBankCard.setCreateBy(leaseAccount.getCreateBy());
                leaseAccountBankCard.setCreateTime(nowDate);
                leaseAccountBankCard.setUpdateTime(nowDate);
                leaseAccountBankCard = leaseAccountBankCardService.insertSelective(leaseAccountBankCard);
                //插入 承租人银行卡 数据

                //根据用户主键Id修改用户名
                leaseAccount.setRealName(quickSendMessageVo.getAccountName());
                leaseAccount.setName(quickSendMessageVo.getAccountName());
                leaseAccount.setPhone(quickSendMessageVo.getTel());
                leaseAccountBankCardService.updateAccountNameByAccountId(leaseAccountBankCard);
                leaseAccountService.updateAccountNameByAccountId(leaseAccount);
                //根据用户主键Id修改用户名

                quickSendMessageVo.setAccountId(leaseAccount.getId());
                quickSendMessageVo.setBankCardId(leaseAccountBankCard.getId());

            }
        }
        //如果是新增承租人签约则处理插入承租人数据
        accountBankCardSignStrategyCommonVo.setQuickSendMessageVo(quickSendMessageVo);
        leaseAccountBankCardSignStrategyCommon.common(accountBankCardSignStrategyCommonVo, dubboTreaceParames);

        return null;
    }

    @Override
    public Object update(Object object, Object object1, Object object2) throws GMException {
        return null;
    }

    @Override
    public Object delete(Object object, Object object1, Object object2) throws GMException {
        return null;
    }

    @Override
    public Object select(Object object, Object object1, Object object2) throws GMException {
        return null;
    }

    @Override
    public Object find(Object object, Object object1, Object object2) throws GMException {
        return null;
    }

    @Override
    public Object findAll(Object object, Object object1, Object object2) throws GMException {
        return null;
    }
}
