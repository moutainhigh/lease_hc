package com.hc.lease.wechat.controller;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.RedisKey;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.ListUtil;
import hc.lease.common.util.SpringContextHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * 微信接口参数
 * Created by tong on 2018/1/18.
 */
@Api(value = "WechatConfigController", description = "微信接口参数")
@Controller
@RequestMapping(value = "/api/admin_public/wechat")
public class WechatConfigController {

    private static final Logger logger = LoggerFactory.getLogger(WechatConfigController.class);

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Value("${wechat.appId}")
    private String appId;//凭证

    @Value("${wechat.appSecret}")
    private String appSecret;//密钥

    @Value("${wechat.accessTokenUrl}")
    private String accessTokenUrl;//

    @Value("${wechat.jsapiTicketUrl}")
    private String jsapiTicketUrl;//

    /**
     * 获取jsapi_ticket
     *
     * @return
     */
    @ApiOperation("获取jsapi_ticket")
    @RequestMapping(value = "/getJsapiTicket", method = RequestMethod.GET)
    @ResponseBody
    public ResultHashMap getJsapiTicket() throws GMException {
        Map<String, Object> parames = Maps.newHashMap();

        ShardedJedisTemplate shardedJedisTemplate = (ShardedJedisTemplate) SpringContextHolder.getBean("jedisTemplate");

        logger.trace("=====appId=====" + appId);

        Date newDate = DateTime.now().toDate();
        String wechatJsapiTicket = shardedJedisTemplate.get(RedisKey.WECHAT_JSAPI_TICKET);//缓存的数据
        logger.trace("=====wechatJsapiTicket=====" + wechatJsapiTicket);

        parames.put("jsapiTicket", wechatJsapiTicket);
        parames.put("appId", appId);

        Object object = ListUtil.objectIsNullToMap(parames);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;

    }

}
