package com.hc.lease.common.core.excel.poi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/21<br/>
 * 说明：
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CostCheckExcelCol {

    String value() default "";

}
