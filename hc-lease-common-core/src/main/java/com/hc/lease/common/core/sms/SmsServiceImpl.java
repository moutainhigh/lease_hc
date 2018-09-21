package com.hc.lease.common.core.sms;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;

/**
 * 螺丝帽短信
 * Created by tong on 2017/9/15.
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {

    private Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Override
    public Map<String, Object> changeSchemeRepaymentStatusSendSms(Map<String, Object> sendInfoMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map backMap = null;
        String content = null;
        if (sendInfoMap != null) {
            if (sendInfoMap.size() > 0) {
                backMap = Maps.newHashMap();
                for (Object phone : sendInfoMap.keySet()) {
                    content = SmsApi.sendMsg(phone.toString(), sendInfoMap.get(phone).toString() + "【合创汽车金融】", false);
                    backMap.put(phone, content);
                }
            }
        }
        return backMap;
    }

    /**
     * 处理螺丝帽短信发送返回报文
     *
     * @param contentMap
     * @return
     * @throws GMException
     */
    public Integer dualSmsContent(Map<String, Object> contentMap, DubboTreaceParames dubboTreaceParames) throws GMException {

        Integer status = 0;
        //解析短信报文内容
        if (contentMap != null) {
            if (contentMap.size() > 0) {
                for (Object obj : contentMap.keySet()) {
                    String content = (String) contentMap.get(obj);
                    JSONObject jsonObject = JSONObject.fromObject(content);
                    if (content != null) {
                        Iterator<String> keys = jsonObject.keys();//定义迭代器
                        String key = null;
                        while (keys.hasNext()) {
                            key = keys.next();
                            if (key.equals("error")) {
                                status = (Integer) jsonObject.get(key);
                            }
                        }
                    }
                }
            }
        }
        //解析短信报文内容

        return status;
    }
}
