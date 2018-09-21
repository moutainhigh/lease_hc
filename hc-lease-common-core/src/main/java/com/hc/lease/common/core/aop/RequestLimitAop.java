package com.hc.lease.common.core.aop;

import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.HttpRequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Enumeration;

/**
 * 限制IP访问频率
 * Created by tong on 2017/3/11.
 */
@Aspect
@Component
public class RequestLimitAop {

    private static final Logger logger = LoggerFactory.getLogger(RequestLimitAop.class);
    @Autowired
    ShardedJedisTemplate shardedJedisTemplate;

    /**
     * 限制IP访问频率
     *
     * @param joinPoint
     * @param limit
     * @throws GMException
     */
    @Before("within(@org.springframework.stereotype.Controller *) && @annotation(limit)")
    public void requestLimit(final JoinPoint joinPoint, RequestLimitAnnotation limit) throws GMException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //请求头过滤恶意的访问
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String paramName = (String) e.nextElement();
            String value2 = request.getHeader(paramName);
            logger.debug(paramName + "=" + value2);
            if (value2.contains("Python") || value2.contains("python")) {
                throw new GMException(GMExceptionConstant.DATA_LOAD_SUCCESS);
            }
        }
        //请求头过滤恶意的访问

        String params = limit.params();

        String ip = HttpRequestUtil.getIpAddr(request);//访问者IP
        String url = request.getRequestURL().toString();//访问链接
        String key = "req_limit_".concat(params).concat(":").concat(url).concat(":").concat(ip);//
        String endkey = "req_limit_del_".concat(params).concat(":").concat(url).concat(":").concat(ip);//

        ////////////////////////////
        Date t1 = new Date();
        String t2 = shardedJedisTemplate.get(endkey);
        long tt2 = Long.parseLong(t2 == null ? "0" : t2);
        logger.debug("t1：" + t1.getTime());
        logger.debug("tt2：" + tt2);
        long totalSeconds = DateUtil.timeDifferenceV1(tt2, t1.getTime());//两个日期秒数相差
        logger.debug("totalSeconds：" + totalSeconds);

        //同一个IP访问间隔不能超限(60秒)
        if (totalSeconds < limit.nextTimeLimit()) {
            throw new GMException(GMExceptionConstant.REQUESTLIMIT);
        }

        if (totalSeconds > limit.time()) {
            shardedJedisTemplate.del(key);
            shardedJedisTemplate.del(endkey);
        }

        shardedJedisTemplate.expire(key, limit.time());
        shardedJedisTemplate.setex(endkey, t1.getTime() + "", limit.time());

    }

}
