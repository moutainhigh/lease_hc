package com.hc.lease.common.core.sms;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;

import java.util.Map;

/**
 * 螺丝帽短信
 * Created by Administrator on 2017/9/15.
 */
public interface SmsService {

    Map<String, Object> changeSchemeRepaymentStatusSendSms(Map<String, Object> sendInfoMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 处理螺丝帽短信发送返回报文
     * @param contentMap
     * @return
     * @throws GMException
     */
    Integer dualSmsContent(Map<String, Object> contentMap, DubboTreaceParames dubboTreaceParames) throws GMException;

}
