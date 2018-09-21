package com.hc.lease.account.vo;

import com.allinpay.model.QuickReturnMessage;
import com.hc.lease.account.model.LeaseAccountBankPaySin;
import com.hc.lease.common.allinpay.model.QuickSendMessageVo;
import com.hc.lease.common.core.constant.UserSession;

import java.io.Serializable;

/**
 * 通联协议支付 签约
 * 策略模式 公共处理
 * 传值实体
 */
public class AccountBankCardSignStrategyCommonVo implements Serializable {

    //协议支付签约数据
    QuickSendMessageVo quickSendMessageVo;
    //通联协议支付签约返回数据
    QuickReturnMessage quickReturnMessage;
    //银行卡授权签约数据
    LeaseAccountBankPaySin leaseAccountBankPaySin;
    //登录用户信息
    UserSession userSession;
    //原请求流水
    String srcreqSn;

    public QuickSendMessageVo getQuickSendMessageVo() {
        return quickSendMessageVo;
    }

    public void setQuickSendMessageVo(QuickSendMessageVo quickSendMessageVo) {
        this.quickSendMessageVo = quickSendMessageVo;
    }

    public QuickReturnMessage getQuickReturnMessage() {
        return quickReturnMessage;
    }

    public void setQuickReturnMessage(QuickReturnMessage quickReturnMessage) {
        this.quickReturnMessage = quickReturnMessage;
    }

    public LeaseAccountBankPaySin getLeaseAccountBankPaySin() {
        return leaseAccountBankPaySin;
    }

    public void setLeaseAccountBankPaySin(LeaseAccountBankPaySin leaseAccountBankPaySin) {
        this.leaseAccountBankPaySin = leaseAccountBankPaySin;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public String getSrcreqSn() {
        return srcreqSn;
    }

    public void setSrcreqSn(String srcreqSn) {
        this.srcreqSn = srcreqSn;
    }
}