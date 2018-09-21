package com.hc.lease.user.interceptor;

import com.hc.lease.common.core.constant.Constants;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.user.adapter.api.LeaseUserSessionAdapter;
import com.hc.lease.user.model.LeaseUserSession;
import hc.lease.common.util.DateUtils;
import hc.lease.common.util.MD5Util;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * 需登录接口拦截
 */
public class UserInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private LeaseUserSessionAdapter leaseUserSessionAdapter;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            response.setContentType("text/html;charset=UTF-8");

            //用token+时间戳+设备号ID
            String signature = request.getHeader("signature");
            String deviceId = request.getHeader("deviceId");
            String timestamp = request.getHeader("timestamp");
            if (signature == null) {
                signature = request.getParameter("signature");
                deviceId = request.getParameter("deviceId");
                timestamp = request.getParameter("timestamp");
            }
            if (StringUtils.isBlank(signature) || StringUtils.isBlank(deviceId) || StringUtils.isBlank(timestamp)) {
                throw new GMException(GMExceptionConstant.LOGIN_OBJECT_EXCEPTION);
            }

            /*
            //时间是否在上下5分钟误差范围/防止客户端请求接口太久到达服务器
            DateTime begin = new DateTime(Long.parseLong(timestamp));
            Interval i = new Interval(begin.minusMinutes(5), begin.plusMinutes(5));
            boolean isLegal = i.contains(DateTime.now());
            if (!isLegal) {
                throw new GMException(GMExceptionConstant.API_TIME_OUT);
            }
            //时间是否在上下5分钟误差范围/防止客户端请求接口太久到达服务器
            */

            //查询session对象
            LeaseUserSession leaseUserSession = leaseUserSessionAdapter.selectByDeviceId(deviceId);
            if (leaseUserSession == null) {//
                throw new GMException(GMExceptionConstant.USER_IS_LOGIN);//帐号已在其他设备登录,请重新登录
            }
            UserSession userSession = new UserSession();
            BeanUtils.copyProperties(userSession, leaseUserSession);
            String serverSignature = MD5Util.string2MD5(userSession.getSessionCurrent() + timestamp + deviceId);

            Date sessionLimitTime = leaseUserSession.getSessionLimitTime();
            DateTime sessionLimitTimeDateTime = new DateTime(sessionLimitTime);
            boolean ifExit = DateUtils.after(new DateTime(new Date()), sessionLimitTimeDateTime);//token是否过期
            if (ifExit) {
                throw new GMException(GMExceptionConstant.SIGNATURE_OVER_TIME);//签名已过期,请重新登录
            }

            //成功访问一次 则签名过期时间 修改为当前时间加120分钟
            DateTime nowDateTime = new DateTime(new Date());
            sessionLimitTimeDateTime = nowDateTime.plusMinutes(120);//签名120分钟后过期
            leaseUserSession.setSessionLimitTime(sessionLimitTimeDateTime.toDate());
            if (signature.equals(serverSignature)) {
                leaseUserSessionAdapter.updateByPrimaryKeySelective(leaseUserSession);
                userSession.setSessionLimitTime(sessionLimitTimeDateTime.toDate());
                request.setAttribute(Constants.USER_SESSION, userSession);//此处设置 给 @CurrentUser注解 拿到 UserSession
                return true;
            } else {
                throw new GMException(GMExceptionConstant.SIGNATURE_INVALID);//签名已失效
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new GMException(GMExceptionConstant.NO_FOUND);//系统忙
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new GMException(GMExceptionConstant.NO_FOUND);//系统忙
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new GMException(GMExceptionConstant.NO_FOUND);//系统忙
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
