package com.hc.lease.common.core.constant;

/**
 * redis缓存 key
 * Created by Tong on 2017/4/26.
 */
public class RedisKey {
    //银行
    public static final String LEASE_BANK = "lease:bank:findAll";
    //地区
    public static final String LEASE_AREA_FINDAREABYENABLEANDMODEL = "lease:area:findAreaByEnableAndModel";
    //地区
    public static final String LEASE_AREA_FINDALL = "lease:area:findAll";
    //dubbo白名单IP
    public static final String DUBBO_WHITE_IP = "dubbo:white:ip";
    //是否启用dubbo白名单
    public static final String DUBBO_WHITE_IP_STATUS = "dubbo:white:ip:status";
    //微信公众号accessToken
    public static final String WECHAT_ACCESS_TOKEN = "wechat:accessToken";
    //微信公众号jsapi_ticket
    public static final String WECHAT_JSAPI_TICKET = "wechat:jsapiTicket";
    //微信公众号jsapi_ticket有效时间/秒
    public static final String WECHAT_JSAPI_TICKET_EXPIRESIN = "wechat:jsapiTicket:expiresIn";
    //微信公众号jsapi_ticket失效时间戳
    public static final String WECHAT_JSAPI_TICKET_INVALID_TIME = "wechat:jsapiTicket:invalidTime";
    //字典表数据Redis前缀
    public static final String DICT_REDIS_PREFIX = "lease:dict:";
    //规则表数据Redis前缀
    public static final String RULE_REDIS_PREFIX = "lease:rule:findAll";
}
