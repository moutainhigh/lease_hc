package com.hc.lease.common.core.aop;

import com.hc.lease.common.core.constant.Constants;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.UserSession;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.UUID;

/**
 * 参数解析器、可在controller方法里面通过注解拿到参数
 * 此处设置,给@DubboTreaceParames注解,拿到 DubboTreaceParames
 */
public class DubboTreaceParamesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> klass = parameter.getParameterType();
        if (klass.isAssignableFrom(DubboTreaceParames.class)) {
            Annotation[] as = parameter.getParameterAnnotations();
            for (Annotation a : as) {
                if (a.annotationType() == DubboTreaceParamesAnnotations.class) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Class<?> klass = parameter.getParameterType();
        UserSession userSession = (UserSession) nativeWebRequest.getAttribute(Constants.USER_SESSION, NativeWebRequest.SCOPE_REQUEST);

        if (klass.isAssignableFrom(DubboTreaceParames.class)) {
            DubboTreaceParamesAnnotations annotation = parameter.getParameterAnnotation(DubboTreaceParamesAnnotations.class);
            String interfaceName = annotation.interfaceName();
            String methodName = annotation.methodName();

            //long time = System.currentTimeMillis();
            Date time = DateTime.now().toDate();
            DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
            dubboTreaceParames.setTreaceInterfaceName(interfaceName);//接口名称
            dubboTreaceParames.setTreaceMethodName(methodName);//接口方法名称
            dubboTreaceParames.setTreaceTime(time);//操作时间
            dubboTreaceParames.setTreaceUserId(userSession == null ? null : userSession.getUserId());//操作用户主键id
            dubboTreaceParames.setTreaceUserName(userSession == null ? null : userSession.getRealName());//操作用户名称
            dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

            return dubboTreaceParames;
        }
        return null;
    }

}
