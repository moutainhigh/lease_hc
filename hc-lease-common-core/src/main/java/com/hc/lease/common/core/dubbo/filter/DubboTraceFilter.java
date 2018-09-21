package com.hc.lease.common.core.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;
import com.hc.lease.common.core.constant.RedisKey;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * dubbo日志拦截插件，方便排查定位异常。
 *
 * @author tong
 *         Date: 2017/9/27
 * @since JDK 1.7
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER}, order = -999)
public class DubboTraceFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(DubboTraceFilter.class);

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        ShardedJedisTemplate shardedJedisTemplate = (ShardedJedisTemplate) SpringContextHolder.getBean("jedisTemplate");
        String whiteIp = shardedJedisTemplate.getAsList(RedisKey.DUBBO_WHITE_IP);
        String whiteIpStatus = shardedJedisTemplate.getAsList(RedisKey.DUBBO_WHITE_IP_STATUS);
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide(); //本端是否为消费端
        //boolean isProviderSide = RpcContext.getContext().isProviderSide(); //本端是否为提供端
        String clientIp = RpcContext.getContext().getRemoteHost();
        String consumerSide = isConsumerSide ? "【本端是消费端】" : "【本端是提供端】";
        String whiteIpStatusName = whiteIpStatus.equals("1") ? "【已启用dubbo白名单】" : "【未启用dubbo白名单】";
        logger.trace("【dubo日志拦截】" + consumerSide + whiteIpStatusName + "【白名单IP:" + whiteIp + "】" + "【dubbo接口访问者IP:" + clientIp + "】");
        //已开启白名单限制，根据IP检测白名单
        if (whiteIpStatus.equals("1")) {
            //白名单的IP放行
            if (whiteIp.contains(clientIp)) {
                return invokeDual(invoker, invocation);
            } else {
                logger.trace("【IP被dubbo白名单限制】");
                return new RpcResult();
            }
        } else {
            logger.trace("【未启用dubbo白名单,直接放行】");
            return invokeDual(invoker, invocation);
        }
    }

    public Result invokeDual(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            FilterDesc filterReq = new FilterDesc();
            filterReq.setInterfaceName(invocation.getInvoker().getInterface().getName());
            filterReq.setMethodName(invocation.getMethodName());
            filterReq.setArgs(invocation.getArguments());
            logger.trace("dubbo请求数据:" + JSON.toJSONString(filterReq));

            RpcInvocation invocation1 = (RpcInvocation) invocation;
            invocation1.setAttachment("traceId", invocation.getAttachment("traceId"));

            Result result = invoker.invoke(invocation);
            if (result.hasException() && invoker.getInterface() != GenericService.class) {
                logger.trace("dubbo执行异常:", result.getException());
            } else {
                FilterDesc filterRsp = new FilterDesc();
                filterRsp.setMethodName(invocation.getMethodName());
                filterRsp.setInterfaceName(invocation.getInvoker().getInterface().getName());
                filterRsp.setArgs(new Object[]{result.getValue()});
                logger.trace("dubbo返回数据:" + JSON.toJSONString(filterRsp));
            }

            return result;
        } catch (RuntimeException e) {
            logger.trace("dubbo未知异常:" + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
            throw e;
        }
    }
}
