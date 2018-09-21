package com.hc.lease.common.core.common;

import com.hc.lease.common.core.constant.RedisKey;
import com.hc.lease.common.core.dubbo.filter.DubboTraceFilter;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * spring容器启动完毕后 做某些初始化
 * Created by tong on 2017/10/11.
 */
@Component("initializationInformation")
public class InitializationInformation implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(InitializationInformation.class);

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Value("${dubbo.white.ip.status}")
    private String whiteIpStatus;//是否开启dubbo白名单

    @Value("${dubbo.white.ip}")
    private String whiteIp;//dubbo白名单IP

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        try {
            ShardedJedisTemplate shardedJedisTemplate = (ShardedJedisTemplate) SpringContextHolder.getBean("jedisTemplate");
            shardedJedisTemplate.setex(RedisKey.DUBBO_WHITE_IP, whiteIp, Integer.parseInt(redisSeconds));
            shardedJedisTemplate.setex(RedisKey.DUBBO_WHITE_IP_STATUS, whiteIpStatus, Integer.parseInt(redisSeconds));
            logger.trace("【白名单IP" + whiteIp + "】");
            logger.trace("【是否开启dubbo白名单" + whiteIpStatus + "】");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }
}
