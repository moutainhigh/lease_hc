package com.hc.lease.account.adapter.api;

import com.allinpay.model.QuickReturnMessage;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.vo.LeaseAccountExcel;
import com.hc.lease.common.allinpay.model.QuickSendMessageVo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.EmergencyContactExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.EmergencyContactImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountImportExcelBackInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;
import java.util.Map;

/**
 * 承租人/用户Adapter
 *
 * @author Tong
 * @version 2017-05-22
 */

public interface LeaseAccountAdapter extends BaseAdapter<LeaseAccount> {

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @param deviceId
     * @return
     * @throws GMException
     */
    ResultHashMap accountLogin(String phone, String password, String deviceId) throws GMException;

    List<LeaseAccount> selectAllAccountNoPage(Map<String, Object> paramsMap) throws GMException;

    /**
     * 新增/注册
     *
     * @param leaseAccount
     * @return
     */
    ResultHashMap accountRegister(LeaseAccount leaseAccount) throws GMException;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int deleteByAccountCompany(Long id) throws GMException;

    int deleteBy(Long id, Integer type) throws GMException;

    LeaseAccount selectBy(Long id, Integer type) throws GMException;

    List<LeaseAccountExcel> findAllByExcel(Object o);

    LeaseAccountImportExcelBackInfo importAccountExcel(List<LeaseAccountExcelTemplate> leaseAccountExcelTemplateList) throws GMException;

    EmergencyContactImportExcelBackInfo importEmergencyContactExcel(List<EmergencyContactExcelTemplate> emergencyContactExcelTemplates) throws GMException;

    /**
     * 协议支付签约短信触发
     * 承租人银行卡通联协议支付签约 2步之1
     *
     * @param quickSendMessageVo
     * @return
     */
    QuickReturnMessage sendMessage(QuickSendMessageVo quickSendMessageVo, DubboTreaceParames dubboTreaceParames) throws GMException;

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
    public ResultHashMap sign(QuickSendMessageVo quickSendMessageVo, UserSession userSession, DubboTreaceParames dubboTreaceParames) throws GMException;

    int updateAccountNameByAccountId(LeaseAccount leaseAccount);

}
