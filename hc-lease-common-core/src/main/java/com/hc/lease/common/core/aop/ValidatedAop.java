package com.hc.lease.common.core.aop;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Validated 实体参数验证
 * Created by Tong on 2017/4/25.
 */
@Aspect
@Component
public class ValidatedAop {

    @Before("within(@org.springframework.stereotype.Controller *) && @annotation(validatedAnnotation)")
    public void validatedAnnotation(final JoinPoint joinPoint, ValidatedAnnotation validatedAnnotation) throws GMException {
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            if (joinPoint.getArgs()[i] instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) joinPoint.getArgs()[i];
                if (bindingResult.hasErrors()) {
                    List exceptionMessageList = new ArrayList();
                    Map<String, Object> exceptionMessageMap = new HashMap<String, Object>();
                    for (ObjectError objectError : bindingResult.getAllErrors()) {
                        //收集错误信息
                        exceptionMessageMap = new HashMap<String, Object>();
                        exceptionMessageMap.put("message", objectError.getDefaultMessage());
                        exceptionMessageList.add(exceptionMessageMap);
                    }
                    throw new GMException(GMExceptionConstant.OBJECT_NULL_EXCEPTION, exceptionMessageList);
                }
            }
        }

    }


}
