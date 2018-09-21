package com.hc.lease.common.core.excel.easyxls.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel配置注解自定义接口
 * Created by Lj
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExcelSheet {

    /**
     * sheet名称
     */
    String sheetName();

    /**
     * sheet对应类
     */
    Class classObj();

    /**
     * 宿主关联键
     */
    String hostKey() default "";

    /**
     * 关联键
     */
    String connectKey() default "";

    /**
     * 是否导出数据
     */
    boolean isExport() default true;
}
