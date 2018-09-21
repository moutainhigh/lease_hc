package com.hc.lease.account.strategy.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.model.LeaseAccountBankPaySin;
import com.hc.lease.account.model.LeaseAccountCredit;
import com.hc.lease.account.service.api.*;
import com.hc.lease.common.core.dubbo.filter.DubboTraceFilter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.file.UploadFileUtil;
import com.hc.lease.common.core.strategy.Strategy;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 策略模式
 * 个人类型用户/承租人
 * Created by tong on 2017/11/3.
 */
public class LeaseAccountCreditServiceStrategy implements Strategy {

    /**
     * 新增
     *
     * @param object
     * @param object1
     * @param object2
     * @return
     * @throws GMException
     */
    @Override
    public Object insert(Object object, Object object1, Object object2) throws GMException {

        LeaseAccount leaseAccount = (LeaseAccount) object1;
        Map params = (Map) object2;
        String maxSize = (String) params.get("maxSize");
        String fileImgFolder = (String) params.get("fileImgFolder");
        String accountFileImgFolder = (String) params.get("accountFileImgFolder");
        String imgUrl = (String) params.get("imgUrl");

        LeaseAccountCreditService leaseAccountCreditService = (LeaseAccountCreditService) SpringContextHolder.getBean("leaseAccountCreditService");
        LeaseAccountService leaseAccountService = (LeaseAccountService) SpringContextHolder.getBean("leaseAccountService");
        LeaseAccountBankCardService leaseAccountBankCardService = (LeaseAccountBankCardService) SpringContextHolder.getBean("leaseAccountBankCardService");
        if (leaseAccount.getRealName() == null) {
            leaseAccount.setRealName(leaseAccount.getName());
        }
        leaseAccount = leaseAccountService.insertSelective(leaseAccount);//

        //插入注册用户/承租人征信信息
        LeaseAccountCredit leaseAccountCredit = new LeaseAccountCredit();
        leaseAccountCredit.setAccountId(leaseAccount.getId());
        leaseAccountCredit.setAttoneyPowerImg(UploadFileUtil.base64UploadFile(leaseAccount.getAttoneyPowerImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        //leaseAccountCredit.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccount.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setBackCardNumber(leaseAccount.getBackCardNumber());
        leaseAccountCredit.setBankId(leaseAccount.getBankId());
        leaseAccountCredit.setBankStatementImg(UploadFileUtil.dualImgs(leaseAccount.getBankStatementImgs(), maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setBranchBank(leaseAccount.getBranchBank());
        leaseAccountCredit.setCommunicationListImg(UploadFileUtil.dualImgs(leaseAccount.getCommunicationListImgs(), maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setDriverLicenseImg(UploadFileUtil.base64UploadFile(leaseAccount.getDriverLicenseImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setDriverLicenseCounterpartImg(UploadFileUtil.base64UploadFile(leaseAccount.getDriverLicenseCounterpartImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setDriverLicenseNumber(leaseAccount.getDriverLicenseNumber());
        leaseAccountCredit.setEarningsProofImg(UploadFileUtil.base64UploadFile(leaseAccount.getEarningsProofImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setEmergencyContact(leaseAccount.getEmergencyContact());
        leaseAccountCredit.setHalfYearMonthIncome(leaseAccount.getHalfYearMonthIncome());
        leaseAccountCredit.setHousingType(leaseAccount.getHousingType());
        leaseAccountCredit.setHousingTypeOtherDescribe(leaseAccount.getHousingTypeOtherDescribe());
        leaseAccountCredit.setIdCard(leaseAccount.getIdCard());
        leaseAccountCredit.setIdCardAddress(leaseAccount.getIdCardAddress());
        leaseAccountCredit.setIdCardImgObverseSide(UploadFileUtil.base64UploadFile(leaseAccount.getIdCardImgObverseSide(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setIdCardImgReverseSide(UploadFileUtil.base64UploadFile(leaseAccount.getIdCardImgReverseSide(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setLiveAddress(leaseAccount.getLiveAddress());
        leaseAccountCredit.setMarriageCertificateImg(UploadFileUtil.base64UploadFile(leaseAccount.getMarriageCertificateImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setNetCarReceivableLogImg(UploadFileUtil.dualImgs(leaseAccount.getNetCarReceivableLogImgs(), maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setSpouseIdCard(leaseAccount.getSpouseIdCard());
        leaseAccountCredit.setSpouseIdCardImgObverseSid(UploadFileUtil.base64UploadFile(leaseAccount.getSpouseIdCardImgObverseSid(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setSpouseIdCardImgReverseSid(UploadFileUtil.base64UploadFile(leaseAccount.getSpouseIdCardImgReverseSid(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setSpouseName(leaseAccount.getSpouseName());
        leaseAccountCredit.setSpousePhone(leaseAccount.getSpousePhone());
        leaseAccountCredit.setWorkUnit(leaseAccount.getWorkUnit());
        leaseAccountCredit.setWorkUnitPhone(leaseAccount.getWorkUnitPhone());
        leaseAccountCredit.setZipCode(leaseAccount.getZipCode());
        leaseAccountCredit.setCreateBy(leaseAccount.getCreateBy());
        leaseAccountCredit.setUpdateBy(leaseAccount.getUpdateBy());
        leaseAccountCredit.setOtherPhone(leaseAccount.getOtherPhone());
        leaseAccountCredit = leaseAccountCreditService.insertSelective(leaseAccountCredit);

        //处理承租人银行卡
        if (leaseAccount.getLeaseAccountBankCards() != null && leaseAccount.getLeaseAccountBankCards().size() > 0) {
            List<LeaseAccountBankCard> leaseAccountBankCards = leaseAccount.getLeaseAccountBankCards();
            for (LeaseAccountBankCard leaseAccountBankCard : leaseAccountBankCards) {
                leaseAccountBankCard.setAccountId(leaseAccount.getId());
                leaseAccountBankCard.setBankAccountName(leaseAccount.getName());
                leaseAccountBankCard.setCreateBy(leaseAccount.getCreateBy());
                leaseAccountBankCard.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccountBankCard.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
                leaseAccountBankCardService.insertSelective(leaseAccountBankCard);
            }
        }
        //处理承租人银行卡

        return true;
    }

    /**
     * 修改
     *
     * @param object
     * @param object1
     * @param object2
     * @return
     * @throws GMException
     */
    @Override
    public Object update(Object object, Object object1, Object object2) throws GMException {

        LeaseAccount leaseAccount = (LeaseAccount) object1;
        Map params = (Map) object2;
        String maxSize = (String) params.get("maxSize");
        String fileImgFolder = (String) params.get("fileImgFolder");
        String accountFileImgFolder = (String) params.get("accountFileImgFolder");
        String imgUrl = (String) params.get("imgUrl");

        LeaseAccountCreditService leaseAccountCreditService = (LeaseAccountCreditService) SpringContextHolder.getBean("leaseAccountCreditService");
        LeaseAccountBankCardService leaseAccountBankCardService = (LeaseAccountBankCardService) SpringContextHolder.getBean("leaseAccountBankCardService");
        LeaseAccountBankPaySinService leaseAccountBankPaySinService = (LeaseAccountBankPaySinService) SpringContextHolder.getBean("leaseAccountBankPaySinService");
        //插入注册用户/承租人征信信息
        LeaseAccountCredit leaseAccountCredit = new LeaseAccountCredit();
        leaseAccountCredit.setAccountId(leaseAccount.getId());
        leaseAccountCredit.setAttoneyPowerImg(UploadFileUtil.base64UploadFile(leaseAccount.getAttoneyPowerImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccount.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setBackCardNumber(leaseAccount.getBackCardNumber());
        leaseAccountCredit.setBankId(leaseAccount.getBankId());
        leaseAccountCredit.setBankStatementImg(UploadFileUtil.dualImgs(leaseAccount.getBankStatementImgs(), maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setBranchBank(leaseAccount.getBranchBank());
        leaseAccountCredit.setCommunicationListImg(UploadFileUtil.dualImgs(leaseAccount.getCommunicationListImgs(), maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setDriverLicenseImg(UploadFileUtil.base64UploadFile(leaseAccount.getDriverLicenseImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setDriverLicenseCounterpartImg(UploadFileUtil.base64UploadFile(leaseAccount.getDriverLicenseCounterpartImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setDriverLicenseNumber(leaseAccount.getDriverLicenseNumber());
        leaseAccountCredit.setEarningsProofImg(UploadFileUtil.base64UploadFile(leaseAccount.getEarningsProofImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setEmergencyContact(leaseAccount.getEmergencyContact());
        leaseAccountCredit.setHalfYearMonthIncome(leaseAccount.getHalfYearMonthIncome());
        leaseAccountCredit.setHousingType(leaseAccount.getHousingType());
        leaseAccountCredit.setHousingTypeOtherDescribe(leaseAccount.getHousingTypeOtherDescribe());
        leaseAccountCredit.setIdCard(leaseAccount.getIdCard());
        leaseAccountCredit.setIdCardAddress(leaseAccount.getIdCardAddress());
        leaseAccountCredit.setIdCardImgObverseSide(UploadFileUtil.base64UploadFile(leaseAccount.getIdCardImgObverseSide(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setIdCardImgReverseSide(UploadFileUtil.base64UploadFile(leaseAccount.getIdCardImgReverseSide(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setLiveAddress(leaseAccount.getLiveAddress());
        leaseAccountCredit.setMarriageCertificateImg(UploadFileUtil.base64UploadFile(leaseAccount.getMarriageCertificateImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setNetCarReceivableLogImg(UploadFileUtil.dualImgs(leaseAccount.getNetCarReceivableLogImgs(), maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setSpouseIdCard(leaseAccount.getSpouseIdCard());
        leaseAccountCredit.setSpouseIdCardImgObverseSid(UploadFileUtil.base64UploadFile(leaseAccount.getSpouseIdCardImgObverseSid(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setSpouseIdCardImgReverseSid(UploadFileUtil.base64UploadFile(leaseAccount.getSpouseIdCardImgReverseSid(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCredit.setSpouseName(leaseAccount.getSpouseName());
        leaseAccountCredit.setSpousePhone(leaseAccount.getSpousePhone());
        leaseAccountCredit.setWorkUnit(leaseAccount.getWorkUnit());
        leaseAccountCredit.setWorkUnitPhone(leaseAccount.getWorkUnitPhone());
        leaseAccountCredit.setZipCode(leaseAccount.getZipCode());
        leaseAccountCredit.setOtherPhone(leaseAccount.getOtherPhone());
        int row = leaseAccountCreditService.updateByAccountId(leaseAccountCredit);

        //处理承租人银行卡
        if (leaseAccount.getLeaseAccountBankCards() != null && leaseAccount.getLeaseAccountBankCards().size() > 0) {

            List<LeaseAccountBankCard> leaseAccountBankCards = leaseAccount.getLeaseAccountBankCards();//修改的最新数据
            Map<String, Object> paramsMap = null;
            for (LeaseAccountBankCard leaseAccountBankCard : leaseAccountBankCards) {//修改的最新数据

                paramsMap = Maps.newHashMap();
                paramsMap.put("accountId", leaseAccount.getId());
                paramsMap.put("id", leaseAccountBankCard.getId());
                LeaseAccountBankCard leaseAccountBankCardOld = leaseAccountBankCardService.findByAccountIdAndId(paramsMap);
                if (leaseAccountBankCardOld != null) {
                    //已存在则更新
                    leaseAccountBankCard.setAccountId(leaseAccount.getId());
                    leaseAccountBankCard.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccountBankCard.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
                    leaseAccountBankCard.setBankAccountName(leaseAccount.getName());
                    leaseAccountBankCard.setUpdateBy(leaseAccount.getUpdateBy());
                    leaseAccountBankCardService.updateByPrimaryKey(leaseAccountBankCard);
                } else {
                    //不存在则新增
                    leaseAccountBankCard.setAccountId(leaseAccount.getId());
                    leaseAccountBankCard.setBankAccountName(leaseAccount.getName());
                    leaseAccountBankCard.setUpdateBy(leaseAccount.getUpdateBy());
                    leaseAccountBankCard.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccountBankCard.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
                    leaseAccountBankCardService.insertSelective(leaseAccountBankCard);
                }

            }

        }
        //处理承租人银行卡

        //处理承租人银行卡通联支付签约
        LeaseAccountBankPaySin leaseAccountBankPaySin = new LeaseAccountBankPaySin();
        leaseAccountBankPaySin.setAccountId(leaseAccount.getId());//承租人主键id
        leaseAccountBankPaySin.setAccountName(leaseAccount.getName());//姓名
        leaseAccountBankPaySin.setTel(leaseAccount.getPhone());//电话
        leaseAccountBankPaySin.setIdCard(leaseAccount.getIdCard());//身份证号
        leaseAccountBankPaySinService.updateByAccountId(leaseAccountBankPaySin);
        //处理承租人银行卡通联支付签约

        return row;
    }

    /**
     * 删除
     *
     * @param object
     * @param object1
     * @param object2
     * @return
     * @throws GMException
     */
    @Override
    public Object delete(Object object, Object object1, Object object2) throws GMException {

        LeaseAccountCreditService leaseAccountCreditService = (LeaseAccountCreditService) SpringContextHolder.getBean("leaseAccountCreditService");
        LeaseAccountBankPaySinService leaseAccountBankPaySinService = (LeaseAccountBankPaySinService) SpringContextHolder.getBean("leaseAccountBankPaySinService");
        LeaseAccountBankpaysinLogService leaseAccountBankpaysinLogService = (LeaseAccountBankpaysinLogService) SpringContextHolder.getBean("leaseAccountBankpaysinLogService");

        Map params = (Map) object2;
        Long id = (Long) params.get("id");

        int row = leaseAccountCreditService.deleteByAccountId(id);
        leaseAccountBankPaySinService.deleteByAccountId(id);
        //leaseAccountBankpaysinLogService.deleteByAccountId(id);
        return row;
    }

    /**
     * 查询
     *
     * @param object
     * @param object1
     * @param object2
     * @return
     * @throws GMException
     */
    @Override
    public Object select(Object object, Object object1, Object object2) throws GMException {
        LeaseAccountService leaseAccountService = (LeaseAccountService) SpringContextHolder.getBean("leaseAccountService");
        Map params = (Map) object2;
        Long id = (Long) params.get("id");
        LeaseAccount leaseAccount = leaseAccountService.selectByPrimaryKey(id);
        return leaseAccount;
    }

    /**
     * 查询所有
     *
     * @param object
     * @param object1
     * @param object2
     * @return
     * @throws GMException
     */
    @Override
    public Object find(Object object, Object object1, Object object2) throws GMException {
        LeaseAccountService leaseAccountService = (LeaseAccountService) SpringContextHolder.getBean("leaseAccountService");
        Map paramsMap = (Map) object2;
        Long id = (Long) paramsMap.get("id");
        int pageNum = (int) paramsMap.get("pageNum");
        int pageSize = (int) paramsMap.get("pageSize");
        PageInfo<LeaseAccount> page = leaseAccountService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 查询所有
     *
     * @param object
     * @param object1
     * @param object2
     * @return
     * @throws GMException
     */
    @Override
    public Object findAll(Object object, Object object1, Object object2) throws GMException {
        LeaseAccountService leaseAccountService = (LeaseAccountService) SpringContextHolder.getBean("leaseAccountService");
        Map paramsMap = (Map) object2;
        List<LeaseAccount> page = leaseAccountService.findAll(paramsMap);
        return page;
    }

}
