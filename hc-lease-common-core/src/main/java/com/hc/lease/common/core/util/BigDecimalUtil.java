package com.hc.lease.common.core.util;

import java.math.BigDecimal;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/10/30<br/>
 * 说明：BigDecimal工具类
 */
public class BigDecimalUtil {

    /**
     * 判断这个值是否为空、是否等于零、是否小于零
     * @param value 数值
     * @return true ：为空或者等于零或者小于零；false ：该值可用于计算
     */
    public static boolean isUse(BigDecimal value) {
        return value == null || value.compareTo(BigDecimal.ZERO) == 0 || value.compareTo(BigDecimal.ZERO) == -1;
    }
}
