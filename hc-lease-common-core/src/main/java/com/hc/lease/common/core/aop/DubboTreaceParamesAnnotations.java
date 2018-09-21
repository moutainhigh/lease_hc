package com.hc.lease.common.core.aop;

import java.lang.annotation.*;

/**
 * 统一接口跟踪参数
 */
@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DubboTreaceParamesAnnotations {
    String interfaceName();//接口名称

    String methodName();//接口方法名称
}
