package com.hc.lease.common.core.aop;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 限制IP访问频率
 * Created by tong on 2017/3/11.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface RequestLimitAnnotation {
    /**
     * 时间段内允许访问的次数，默认值MAX_VALUE
     */
    int count() default Integer.MAX_VALUE;

    /**
     * 时间段，单位为秒
     */
    int time() default 86400;

    /**
     * 每次访问的间隔，单位为秒
     */
    int nextTimeLimit() default 60;

    /**
     * 其他参数
     */
    String params() default "";

    /**
     * 是否受参数控制
     */
    boolean status() default false;

}
