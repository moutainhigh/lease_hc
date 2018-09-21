package com.hc.lease.common.core.aop;

import com.hc.lease.common.core.constant.Constants;

import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {

    String value() default Constants.USER_SESSION;
}
