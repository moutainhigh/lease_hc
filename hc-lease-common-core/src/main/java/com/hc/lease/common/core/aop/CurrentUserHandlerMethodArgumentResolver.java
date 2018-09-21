package com.hc.lease.common.core.aop;

import com.hc.lease.common.core.constant.UserSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;

/**
 * 参数解析器、可在controller方法里面通过注解拿到参数
 * 此处设置,给@CurrentUser注解,拿到 UserSession
 */
public class CurrentUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> klass = parameter.getParameterType();
        if (klass.isAssignableFrom(UserSession.class)) {
            Annotation[] as = parameter.getParameterAnnotations();
            for (Annotation a : as) {
                if (a.annotationType() == CurrentUser.class) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Class<?> klass = parameter.getParameterType();
        if (klass.isAssignableFrom(UserSession.class)) {
            CurrentUser annotation = parameter.getParameterAnnotation(CurrentUser.class);
            return nativeWebRequest.getAttribute(annotation.value(), NativeWebRequest.SCOPE_REQUEST);
        }
        return null;
    }

}
