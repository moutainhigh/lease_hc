package com.hc.lease.common.core.dubbo.filter;

import com.alibaba.dubbo.rpc.RpcContext;
import com.hc.lease.common.core.exception.GMException;

import java.util.Map;

/**
 * 设置、获取dubbo透传参数
 * 方便排查问题
 * Created by tong on 2017/11/6.
 */
public class DubboAttachment {

    /**
     * 设置dubbo透传参数
     *
     * @param key
     * @param value
     * @throws GMException
     */
    public static void dubboSetAttachment(String key, String value) {
        RpcContext.getContext().setAttachment(key, value);
    }

    /**
     * 获取dubbo透传参数
     *
     * @param key
     * @throws GMException
     */
    public static String dubboGetAttachment(String key) {
        Map<String, String> attachments = RpcContext.getContext().getAttachments();
        String traceId = attachments.get(key);
        return traceId;
    }
}
