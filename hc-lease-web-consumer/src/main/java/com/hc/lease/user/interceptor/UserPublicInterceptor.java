package com.hc.lease.user.interceptor;

import com.hc.lease.common.core.constant.Constants;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.user.adapter.api.LeaseUserSessionAdapter;
import com.hc.lease.user.model.LeaseUserSession;
import hc.lease.common.util.MD5Util;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * 公共接口拦截
 */
public class UserPublicInterceptor implements HandlerInterceptor {
    @Resource
    private LeaseUserSessionAdapter leaseUserSessionAdapter;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            response.setContentType("text/html;charset=UTF-8");
            String signature = request.getHeader("signature");
            String deviceId = request.getHeader("deviceId");
            String timestamp = request.getHeader("timestamp");

            if (StringUtils.isBlank(signature) || StringUtils.isBlank(deviceId) || StringUtils.isBlank(timestamp)) {
                return true;
            }

            /*
            //时间是否在上下5分钟误差范围/防止客户端请求接口太久到达服务器
            DateTime begin = new DateTime(Long.parseLong(timestamp));
            Interval i = new Interval(begin.minusMinutes(5), begin.plusMinutes(5));
            boolean isLegal = i.contains(DateTime.now());
            if (!isLegal) {
                return true;
            }
            //时间是否在上下5分钟误差范围/防止客户端请求接口太久到达服务器
            */

            LeaseUserSession leaseUserSession = leaseUserSessionAdapter.selectByDeviceId(deviceId);
            if (leaseUserSession == null) {
                return true;
            }
            UserSession userSession = new UserSession();
            BeanUtils.copyProperties(userSession, leaseUserSession);
            String serverSignature = MD5Util.string2MD5(userSession.getSessionCurrent() + timestamp + deviceId);
            if (signature.equals(serverSignature)) {
                request.setAttribute(Constants.USER_SESSION, userSession);
                return true;
            }

            return true;

        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new GMException(GMExceptionConstant.NO_FOUND);//系统忙
        } catch (GMException e) {
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
