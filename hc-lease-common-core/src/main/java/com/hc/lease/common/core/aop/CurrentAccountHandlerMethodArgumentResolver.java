package com.hc.lease.common.core.aop;

import com.hc.lease.common.core.constant.AccountSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;

public class CurrentAccountHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> klass = parameter.getParameterType();
        if (klass.isAssignableFrom(AccountSession.class)) {
            Annotation[] as = parameter.getParameterAnnotations();
            for (Annotation a : as) {
                if (a.annotationType() == CurrentAccount.class) {
                    return true;
                }
            }
        }
        return false;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Class<?> klass = parameter.getParameterType();
        if (klass.isAssignableFrom(AccountSession.class)) {
            CurrentAccount annotation = parameter.getParameterAnnotation(CurrentAccount.class);
            return nativeWebRequest.getAttribute(annotation.value(), NativeWebRequest.SCOPE_REQUEST);
        }
        return null;
    }

}
