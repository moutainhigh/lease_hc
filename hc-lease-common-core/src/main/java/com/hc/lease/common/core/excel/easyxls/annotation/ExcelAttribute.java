package com.hc.lease.common.core.excel.easyxls.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel属性配置注解自定义接口
 * Created by Lj
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ExcelAttribute {

    /**
     * Excel中的列名
     */
    String name();

    /**
     * 列名对应的A,B,C,D...,不指定按照默认顺序排序
     */
    String column() default "";

    /**
     * 提示信息
     */
    String prompt() default "";

    /**
     * 从字典表类型
     */
    String dictType() default "";

    /**
     * 下拉参数名称
     */
    String spinnerParamName() default "";

    /**
     * 是否导出数据
     */
    boolean isExport() default true;

}
