package com.hc.lease.common.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hc.lease.common.core.annotation.UrlParam;
import hc.lease.common.util.ReflectionsUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/**
 * 自定义springWeb参数解析器
 */
public class RequestAttributeMethodResolver implements HandlerMethodArgumentResolver {

    /**
     * 检查控制层方法参数是否符合本解析器解析规则
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //参数是否
        return null != parameter.getParameterAnnotation(UrlParam.class);
    }

    /**
     * 自定义参数绑定实现
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //获取类包括所有父类的所有字段
        List<Field> list = ReflectionsUtil.getClassCoverAllSuperAllField(parameter.getParameterType());
        Object o = BeanUtils.instantiate(parameter.getParameterType());

        //注解类型
        JsonProperty annotation;
        //注解值、请求参数名
        String annotationValiue, paramName;

        //请求参数名 Iterator
        Iterator<String> itr = webRequest.getParameterNames();

        //参数注入处理逻辑
        while (itr.hasNext()) {
            paramName = itr.next();
            for (Field field : list) {
                annotation = field.getAnnotation(JsonProperty.class);
                annotationValiue = null != annotation ? annotation.value() : "";
                //将请求参数名与实体属性名或注解值匹配，匹配成功则进行赋值操作
                if (paramName.equals(annotationValiue) || paramName.equals(field.getName())) {
                    field.setAccessible(true);
                    field.set(o, webRequest.getParameter(paramName));
                }
            }
        }

        return o;
    }
}
