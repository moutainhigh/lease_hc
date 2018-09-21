package com.hc.lease.common.thirdparty.plugin.job;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.RedisKey;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.SpringContextHolder;
import hc.lease.common.wx.util.AccessToken;
import hc.lease.common.wx.util.JsapiTicket;
import hc.lease.common.wx.util.WxHttpRequestUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 定时请求微信接口 JsapiTicket
 * Created by tong on 2017/6/30.
 */
@Lazy(false)
@Component("wechatJsapiTokenJob")
public class WechatJsapiTokenJob {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    //每1分钟触发一次  定时请求微信接口 JsapiTicket
    @Scheduled(cron = "${job.getJsapiTicket.corn}")
    public void getJsapiTicket() throws GMException {
        logger.trace("======触发=getJsapiTicket=====" + DateTime.now().toDate());

        Map<String, Object> parames = Maps.newHashMap();
        parames.put("jsapiTicket", null);

        ShardedJedisTemplate shardedJedisTemplate = (ShardedJedisTemplate) SpringContextHolder.getBean("jedisTemplate");

        Date newDate = DateTime.now().toDate();
        String wechatJsapiTicket = shardedJedisTemplate.get(RedisKey.WECHAT_JSAPI_TICKET);//缓存的数据
        if (StringUtils.isEmpty(wechatJsapiTicket)) {
            AccessToken accessToken = WxHttpRequestUtil.getAccessToken(appId, appSecret, accessTokenUrl);//获取access_token
            if (accessToken != null) {
                JsapiTicket jsapiTicket = WxHttpRequestUtil.getJsapiTicket(accessToken.getToken(), jsapiTicketUrl);//获取jsapi_ticket
                String token = accessToken.getToken();
                String ticket = jsapiTicket.getTicket();

                parames.put("jsapiTicket", ticket);
                parames.put("appId", appId);
                int jsapiTicketExpiresIn = jsapiTicket.getExpiresIn();

                //微信公众号jsapi_ticket失效时间戳
                Date invalidDate = DateUtil.addOneSecond(newDate, 7200);//微信公众号jsapi_ticket失效时间戳
                long invalidDateTimestamp = invalidDate.getTime();//微信公众号jsapi_ticket失效时间戳
                //微信公众号jsapi_ticket失效时间戳

                shardedJedisTemplate.setex(RedisKey.WECHAT_ACCESS_TOKEN, token, Integer.parseInt(redisSeconds));//微信公众号accessToken
                shardedJedisTemplate.setex(RedisKey.WECHAT_JSAPI_TICKET, ticket, Integer.parseInt(redisSeconds));//微信公众号jsapi_ticket
                shardedJedisTemplate.setex(RedisKey.WECHAT_JSAPI_TICKET_EXPIRESIN, String.valueOf(jsapiTicketExpiresIn), Integer.parseInt(redisSeconds));//微信公众号jsapi_ticket有效时间/秒
                shardedJedisTemplate.setex(RedisKey.WECHAT_JSAPI_TICKET_INVALID_TIME, String.valueOf(invalidDateTimestamp), Integer.parseInt(redisSeconds));//微信公众号jsapi_ticket失效时间戳
            } else {
                logger.trace("=====重新请求=2=wechatJsapiTicket===token空值了=请检查公众号接口参数=");
            }

        } else {
            long invalidDateTimestamp = Long.parseLong(shardedJedisTemplate.get(RedisKey.WECHAT_JSAPI_TICKET_INVALID_TIME) == null ? "0" : shardedJedisTemplate.get(RedisKey.WECHAT_JSAPI_TICKET_INVALID_TIME));//微信公众号jsapi_ticket失效时间戳
            long createTime = new Date().getTime();//当前时间戳
            long differTime = DateUtil.timeDifferenceV1(invalidDateTimestamp, createTime);//时间差/秒
            if (differTime >= 0) {//当前时间戳大于失效时间戳则判定已失效

                AccessToken accessToken = WxHttpRequestUtil.getAccessToken(appId, appSecret, accessTokenUrl);//获取access_token
                if (accessToken != null) {
                    JsapiTicket jsapiTicket = WxHttpRequestUtil.getJsapiTicket(accessToken.getToken(), jsapiTicketUrl);//获取jsapi_ticket
                    String token = accessToken.getToken();
                    String ticket = jsapiTicket.getTicket();

                    //如果重新请求回来的ticket和缓存的相同则说明这个ticket在微信公众平台未过期则不更新缓存
                    if (!ticket.equals(wechatJsapiTicket)) {
                        parames.put("jsapiTicket", ticket);
                        parames.put("appId", appId);
                        int jsapiTicketExpiresIn = jsapiTicket.getExpiresIn();
                        //微信公众号jsapi_ticket失效时间戳
                        Date invalidDate = DateUtil.addOneSecond(newDate, 7200);//微信公众号jsapi_ticket失效时间戳
                        long invalidDateTimestampNew = invalidDate.getTime();//微信公众号jsapi_ticket失效时间戳
                        //微信公众号jsapi_ticket失效时间戳
                        shardedJedisTemplate.setex(RedisKey.WECHAT_ACCESS_TOKEN, token, Integer.parseInt(redisSeconds));//微信公众号accessToken
                        shardedJedisTemplate.setex(RedisKey.WECHAT_JSAPI_TICKET, ticket, Integer.parseInt(redisSeconds));//微信公众号jsapi_ticket
                        shardedJedisTemplate.setex(RedisKey.WECHAT_JSAPI_TICKET_EXPIRESIN, String.valueOf(jsapiTicketExpiresIn), Integer.parseInt(redisSeconds));//微信公众号jsapi_ticket有效时间/秒
                        shardedJedisTemplate.setex(RedisKey.WECHAT_JSAPI_TICKET_INVALID_TIME, String.valueOf(invalidDateTimestampNew), Integer.parseInt(redisSeconds));//微信公众号jsapi_ticket失效时间戳
                    } else {
                        parames.put("jsapiTicket", wechatJsapiTicket);
                        parames.put("appId", appId);
                    }
                    //如果重新请求回来的ticket和缓存的相同则说明这个ticket在微信公众平台未过期则不更新缓存
                } else {
                    logger.trace("=====重新请求=2=wechatJsapiTicket===token空值了=请检查公众号接口参数=");
                }

            } else {
                parames.put("jsapiTicket", wechatJsapiTicket);
                parames.put("appId", appId);
            }
        }
    }
}
