package com.hc.lease.account.adapter.impl;

import com.allinpay.model.QuickReturnMessage;
import com.allinpay.util.CheckCode;
import com.hc.lease.account.adapter.api.LeaseAccountBankCardSignStrategyCommon;
import com.hc.lease.account.constant.AccountBankPaySinStatus;
import com.hc.lease.account.model.LeaseAccountBankPaySin;
import com.hc.lease.account.model.LeaseAccountBankpaysinLog;
import com.hc.lease.account.service.api.LeaseAccountBankPaySinService;
import com.hc.lease.account.service.api.LeaseAccountBankpaysinLogService;
import com.hc.lease.account.vo.AccountBankCardSignStrategyCommonVo;
import com.hc.lease.common.allinpay.model.QuickSendMessageVo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通联协议支付 签约
 * 策略模式 公共处理
 * Created by tong on 2018/4/26.
 */
@Service("leaseAccountBankCardSignStrategyCommon")
public class LeaseAccountBankCardSignStrategyCommonImpl implements LeaseAccountBankCardSignStrategyCommon {

    @Autowired
    private LeaseAccountBankPaySinService leaseAccountBankPaySinService;
    @Autowired
    private LeaseAccountBankpaysinLogService leaseAccountBankpaysinLogService;

    /**
     * @param accountBankCardSignStrategyCommonVo
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public Object common(AccountBankCardSignStrategyCommonVo accountBankCardSignStrategyCommonVo, DubboTreaceParames dubboTreaceParames) throws GMException {
        LeaseAccountBankPaySin leaseAccountBankPaySin = accountBankCardSignStrategyCommonVo.getLeaseAccountBankPaySin();
        QuickReturnMessage quickReturnMessage = accountBankCardSignStrategyCommonVo.getQuickReturnMessage();
        QuickSendMessageVo quickSendMessageVo = accountBankCardSignStrategyCommonVo.getQuickSendMessageVo();
        String srcreqSn = accountBankCardSignStrategyCommonVo.getSrcreqSn();
        UserSession userSession = accountBankCardSignStrategyCommonVo.getUserSession();

        //已签约、签约中 则只更新数据状态，不插入数据
        if (leaseAccountBankPaySin != null && (leaseAccountBankPaySin.getStatus() == AccountBankPaySinStatus.AccountBankPaySinStatus_0.getVal() || leaseAccountBankPaySin.getStatus() == AccountBankPaySinStatus.AccountBankPaySinStatus_3.getVal())) {
            //更新 承租人银行卡通联支付签约 数据
            leaseAccountBankPaySin.setReqSn(quickReturnMessage.getReqSn());//签约流水号
            leaseAccountBankPaySin.setSrcreqSn(srcreqSn);//原请求流水、对应申请请求报文中的REQ_SN
            leaseAccountBankPaySin.setReqCode(quickReturnMessage.getAipgrspRetCode());//签约状态码
            leaseAccountBankPaySin.setReqMsg(quickReturnMessage.getAipgrspErrmsg());//签约状态描述
            leaseAccountBankPaySin.setAgrmNo(quickReturnMessage.getAgrmno());//协议号

            Integer status = CheckCode.checkBankPaySinStatus(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode());
            leaseAccountBankPaySin.setStatus(status);

            leaseAccountBankPaySin.setCreateBy(userSession == null ? null : userSession.getUserId());//创建人
            leaseAccountBankPaySin.setUpdateBy(userSession == null ? null : userSession.getUserId());//修改人
            leaseAccountBankPaySin.setRnpaCode(quickReturnMessage.getRnpaRetRetCode());//签约通联处理状态码
            leaseAccountBankPaySin.setRnpaMsg(quickReturnMessage.getRnpaRetErrmsg());//签约通联处理状态描述
            leaseAccountBankPaySin.setType(quickSendMessageVo.getType());//类型: 0系统承租人授权、1:新增承租人授权
            leaseAccountBankPaySin.setSource(quickSendMessageVo.getSource());//操作来源: 0后台系统操作、1:PC、小程序网页操作
            leaseAccountBankPaySinService.updateByPrimaryKeySelective(leaseAccountBankPaySin);
            //更新 承租人银行卡通联支付签约 数据
        } else {
            //插入 承租人银行卡通联支付签约 数据
            leaseAccountBankPaySin = new LeaseAccountBankPaySin();
            leaseAccountBankPaySin.setAccountId(quickSendMessageVo.getAccountId());//承租人主键id
            leaseAccountBankPaySin.setBankCardId(quickSendMessageVo.getBankCardId());//用户银行主键id
            leaseAccountBankPaySin.setAccountName(quickSendMessageVo.getAccountName());//姓名
            leaseAccountBankPaySin.setTel(quickSendMessageVo.getTel());//电话
            leaseAccountBankPaySin.setIdCard(quickSendMessageVo.getIdCard());//身份证号
            leaseAccountBankPaySin.setBankCode(quickSendMessageVo.getBankCode());//银行代码
            leaseAccountBankPaySin.setBankCardNumber(quickSendMessageVo.getAccountNo());//银行卡号
            leaseAccountBankPaySin.setBankId(quickSendMessageVo.getBankId());//银行主键id
            leaseAccountBankPaySin.setBankName(quickSendMessageVo.getBankName());//银行名称
            leaseAccountBankPaySin.setReqSn(quickReturnMessage.getReqSn());//签约流水号
            leaseAccountBankPaySin.setSrcreqSn(srcreqSn);//原请求流水、对应申请请求报文中的REQ_SN
            leaseAccountBankPaySin.setReqCode(quickReturnMessage.getAipgrspRetCode());//签约状态码
            leaseAccountBankPaySin.setReqMsg(quickReturnMessage.getAipgrspErrmsg());//签约状态描述
            leaseAccountBankPaySin.setAgrmNo(quickReturnMessage.getAgrmno());//协议号
            leaseAccountBankPaySin.setBankPhone(quickSendMessageVo.getBankPhone());//银行预留手机

            Integer status = CheckCode.checkBankPaySinStatus(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode());
            leaseAccountBankPaySin.setStatus(status);

            leaseAccountBankPaySin.setCreateBy(userSession == null ? null : userSession.getUserId());//创建人
            leaseAccountBankPaySin.setUpdateBy(userSession == null ? null : userSession.getUserId());//修改人
            leaseAccountBankPaySin.setRnpaCode(quickReturnMessage.getRnpaRetRetCode());//签约通联处理状态码
            leaseAccountBankPaySin.setRnpaMsg(quickReturnMessage.getRnpaRetErrmsg());//签约通联处理状态描述
            leaseAccountBankPaySin.setType(quickSendMessageVo.getType());//类型: 0系统承租人授权、1:新增承租人授权
            leaseAccountBankPaySin.setSource(quickSendMessageVo.getSource());//操作来源: 0后台系统操作、1:PC、小程序网页操作
            leaseAccountBankPaySin = leaseAccountBankPaySinService.insertSelective(leaseAccountBankPaySin);
            //插入 承租人银行卡通联支付签约 数据

            //根据用户主键Id修改用户名
            leaseAccountBankPaySinService.updateAccountNameByAccountId(leaseAccountBankPaySin);

        }

        //插入 承租人银行卡通联支付签约流水 数据
        LeaseAccountBankpaysinLog leaseAccountBankpaysinLog = new LeaseAccountBankpaysinLog();
        leaseAccountBankpaysinLog.setAccountId(quickSendMessageVo.getAccountId());//承租人主键id
        leaseAccountBankpaysinLog.setBankPaySinId(leaseAccountBankPaySin.getId());
        leaseAccountBankpaysinLog.setReqSn(quickReturnMessage.getReqSn());//签约流水号
        leaseAccountBankpaysinLog.setSrcreqSn(srcreqSn);//原请求流水、对应申请请求报文中的REQ_SN
        leaseAccountBankpaysinLog.setReqCode(quickReturnMessage.getAipgrspRetCode());//签约状态码
        leaseAccountBankpaysinLog.setReqMsg(quickReturnMessage.getAipgrspErrmsg());//签约状态描述
        leaseAccountBankpaysinLog.setAgrmNo(quickReturnMessage.getAgrmno());//协议号

        Integer status = CheckCode.checkBankPaySinStatus(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode());
        leaseAccountBankPaySin.setStatus(status);

        leaseAccountBankpaysinLog.setCreateBy(userSession == null ? null : userSession.getUserId());//创建人
        leaseAccountBankpaysinLog.setUpdateBy(userSession == null ? null : userSession.getUserId());//修改人
        leaseAccountBankpaysinLog.setRnpaCode(quickReturnMessage.getRnpaRetRetCode());
        leaseAccountBankpaysinLog.setRnpaMsg(quickReturnMessage.getRnpaRetErrmsg());
        leaseAccountBankpaysinLogService.insertSelective(leaseAccountBankpaysinLog);
        //插入 承租人银行卡通联支付签约流水 数据

        return null;
    }
}
