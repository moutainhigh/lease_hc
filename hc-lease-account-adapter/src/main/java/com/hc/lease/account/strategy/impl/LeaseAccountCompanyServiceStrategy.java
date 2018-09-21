package com.hc.lease.account.strategy.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.model.LeaseAccountCompany;
import com.hc.lease.account.service.api.LeaseAccountBankCardService;
import com.hc.lease.account.service.api.LeaseAccountCompanyService;
import com.hc.lease.account.service.api.LeaseAccountService;
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
 * 公司类型用户/承租人
 * Created by tong on 2017/11/3.
 */
public class LeaseAccountCompanyServiceStrategy implements Strategy {

    @Override
    public Object insert(Object object, Object object1, Object object2) throws GMException {

        LeaseAccount leaseAccount = (LeaseAccount) object1;
        Map params = (Map) object2;
        String maxSize = (String) params.get("maxSize");
        String fileImgFolder = (String) params.get("fileImgFolder");
        String accountFileImgFolder = (String) params.get("accountFileImgFolder");
        String imgUrl = (String) params.get("imgUrl");

        LeaseAccountCompanyService leaseAccountCompanyService = (LeaseAccountCompanyService) SpringContextHolder.getBean("leaseAccountCompanyService");
        LeaseAccountService leaseAccountService = (LeaseAccountService) SpringContextHolder.getBean("leaseAccountService");
        LeaseAccountBankCardService leaseAccountBankCardService = (LeaseAccountBankCardService) SpringContextHolder.getBean("leaseAccountBankCardService");

        leaseAccount.setName(leaseAccount.getCompanyName());
        if (leaseAccount.getRealName() == null) {
            leaseAccount.setRealName(leaseAccount.getName());
        }
        leaseAccount = leaseAccountService.insertSelective(leaseAccount);//

        //注册公司类型用户/承租人信息
        LeaseAccountCompany leaseAccountCompany = new LeaseAccountCompany();
        leaseAccountCompany.setAccountId(leaseAccount.getId());
        leaseAccountCompany.setBusinessLicenseImg(leaseAccount.getBusinessLicenseImg());
        leaseAccountCompany.setBusinessLicenseNumber(leaseAccount.getBusinessLicenseNumber());
        leaseAccountCompany.setCompanyName(leaseAccount.getCompanyName());
        leaseAccountCompany.setCompanyPhone(leaseAccount.getCompanyPhone());
        leaseAccountCompany.setCompanyRegistrationAddress(leaseAccount.getCompanyRegistrationAddress());
        leaseAccountCompany.setContactsAddress(leaseAccount.getContactsAddress());
        leaseAccountCompany.setContactsName(leaseAccount.getContactsName());
        leaseAccountCompany.setContactsPhone(leaseAccount.getContactsPhone());
        leaseAccountCompany.setLegalPersonAddress(leaseAccount.getLegalPersonAddress());
        leaseAccountCompany.setLegalPersonIdCard(leaseAccount.getLegalPersonIdCard());
        leaseAccountCompany.setLegalPersonName(leaseAccount.getLegalPersonName());
        leaseAccountCompany.setLegalPersonPhone(leaseAccount.getLegalPersonPhone());
        leaseAccountCompany.setRemark(leaseAccount.getRemark());
        leaseAccountCompany.setEmergencyContact(leaseAccount.getEmergencyContact());
        leaseAccountCompany.setBankAccountName(leaseAccount.getBankAccountName());
        leaseAccountCompany.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccount.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCompany.setBackCardNumber(leaseAccount.getBackCardNumber());
        leaseAccountCompany.setBankId(leaseAccount.getBankId());
        leaseAccountCompany.setBranchBank(leaseAccount.getBranchBank());
        leaseAccountCompany.setCreateBy(leaseAccount.getCreateBy());
        leaseAccountCompany.setUpdateBy(leaseAccount.getUpdateBy());

        leaseAccountCompanyService.insertSelective(leaseAccountCompany);
        //承租人银行卡
        if(leaseAccount.getLeaseAccountBankCards()!=null&& leaseAccount.getLeaseAccountBankCards().size()>0){
        List<LeaseAccountBankCard> leaseAccountBankCards=leaseAccount.getLeaseAccountBankCards();
            for (LeaseAccountBankCard leaseAccountBankCard : leaseAccountBankCards) {
                leaseAccountBankCard.setAccountId(leaseAccount.getId());
                leaseAccountBankCard.setBankAccountName(leaseAccount.getName());
                leaseAccountBankCard.setCreateBy(leaseAccount.getCreateBy());
                leaseAccountBankCard.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccountBankCard.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
                leaseAccountBankCardService.insertSelective(leaseAccountBankCard);
            }
        }




        return true;
    }

    @Override
    public Object update(Object object, Object object1, Object object2) throws GMException {

        LeaseAccount leaseAccount = (LeaseAccount) object1;
        Map params = (Map) object2;
        String maxSize = (String) params.get("maxSize");
        String fileImgFolder = (String) params.get("fileImgFolder");
        String accountFileImgFolder = (String) params.get("accountFileImgFolder");
        String imgUrl = (String) params.get("imgUrl");

        LeaseAccountCompanyService leaseAccountCompanyService = (LeaseAccountCompanyService) SpringContextHolder.getBean("leaseAccountCompanyService");
        LeaseAccountBankCardService leaseAccountBankCardService = (LeaseAccountBankCardService) SpringContextHolder.getBean("leaseAccountBankCardService");
        LeaseAccountCompany leaseAccountCompany = new LeaseAccountCompany();
        leaseAccountCompany.setAccountId(leaseAccount.getId());
        leaseAccountCompany.setBusinessLicenseImg(leaseAccount.getBusinessLicenseImg());
        leaseAccountCompany.setBusinessLicenseNumber(leaseAccount.getBusinessLicenseNumber());
        leaseAccountCompany.setCompanyName(leaseAccount.getCompanyName());
        leaseAccountCompany.setCompanyPhone(leaseAccount.getCompanyPhone());
        leaseAccountCompany.setCompanyRegistrationAddress(leaseAccount.getCompanyRegistrationAddress());
        leaseAccountCompany.setContactsAddress(leaseAccount.getContactsAddress());
        leaseAccountCompany.setContactsName(leaseAccount.getContactsName());
        leaseAccountCompany.setContactsPhone(leaseAccount.getContactsPhone());
        leaseAccountCompany.setLegalPersonAddress(leaseAccount.getLegalPersonAddress());
        leaseAccountCompany.setLegalPersonIdCard(leaseAccount.getLegalPersonIdCard());
        leaseAccountCompany.setLegalPersonName(leaseAccount.getLegalPersonName());
        leaseAccountCompany.setLegalPersonPhone(leaseAccount.getLegalPersonPhone());
        leaseAccountCompany.setRemark(leaseAccount.getRemark());
        leaseAccountCompany.setEmergencyContact(leaseAccount.getEmergencyContact());
        leaseAccountCompany.setBankAccountName(leaseAccount.getBankAccountName());
        leaseAccountCompany.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccount.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
        leaseAccountCompany.setBackCardNumber(leaseAccount.getBackCardNumber());
        leaseAccountCompany.setBankId(leaseAccount.getBankId());
        leaseAccountCompany.setBranchBank(leaseAccount.getBranchBank());
        leaseAccountCompany.setCreateBy(leaseAccount.getCreateBy());
        leaseAccountCompany.setUpdateBy(leaseAccount.getUpdateBy());

        int row = leaseAccountCompanyService.updateByAccountId(leaseAccountCompany);
     /*   //承租人银行卡
        if(leaseAccount.getLeaseAccountBankCards()!=null&& leaseAccount.getLeaseAccountBankCards().size()>0){
            List<LeaseAccountBankCard> leaseAccountBankCards=leaseAccount.getLeaseAccountBankCards();
            for (LeaseAccountBankCard leaseAccountBankCard : leaseAccountBankCards) {
                leaseAccountBankCard.setAccountId(leaseAccount.getId());
                leaseAccountBankCard.setBankAccountName(leaseAccount.getName());
                leaseAccountBankCard.setUpdateBy(leaseAccount.getUpdateBy());
                leaseAccountBankCard.setBackCardImg(UploadFileUtil.base64UploadFile(leaseAccountBankCard.getBackCardImg(), null, maxSize, fileImgFolder, accountFileImgFolder, imgUrl));
                leaseAccountBankCardService.insertSelective(leaseAccountBankCard);
            }
        }*/

        return row;
    }

    @Override
    public Object delete(Object object, Object object1, Object object2) throws GMException {

        LeaseAccountCompanyService leaseAccountCompanyService = (LeaseAccountCompanyService) SpringContextHolder.getBean("leaseAccountCompanyService");

        Map params = (Map) object2;
        Long id = (Long) params.get("id");

        int row = leaseAccountCompanyService.deleteByAccountId(id);
        return null;
    }

    @Override
    public Object select(Object object, Object object1, Object object2) throws GMException {
        LeaseAccountCompanyService leaseAccountCompanyService = (LeaseAccountCompanyService) SpringContextHolder.getBean("leaseAccountCompanyService");
        Map params = (Map) object2;
        Long id = (Long) params.get("id");
        LeaseAccount leaseAccount = leaseAccountCompanyService.selectBy(id);
        return leaseAccount;
    }

    @Override
    public Object find(Object object, Object object1, Object object2) throws GMException {
        LeaseAccountCompanyService leaseAccountCompanyService = (LeaseAccountCompanyService) SpringContextHolder.getBean("leaseAccountCompanyService");
        Map paramsMap = (Map) object2;
        Long id = (Long) paramsMap.get("id");
        int pageNum = (int) paramsMap.get("pageNum");
        int pageSize = (int) paramsMap.get("pageSize");
        PageInfo<LeaseAccount> page = leaseAccountCompanyService.findByPage(pageNum, pageSize, paramsMap);
        return page;
    }

    @Override
    public Object findAll(Object object, Object object1, Object object2) throws GMException {
        LeaseAccountCompanyService leaseAccountCompanyService = (LeaseAccountCompanyService) SpringContextHolder.getBean("leaseAccountCompanyService");
        Map paramsMap = (Map) object2;
        List<LeaseAccountCompany> page = leaseAccountCompanyService.findAll(paramsMap);
        return page;
    }

}
