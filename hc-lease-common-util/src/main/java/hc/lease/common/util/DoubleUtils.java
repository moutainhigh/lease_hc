package hc.lease.common.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class DoubleUtils {
    public static String getDoubleValue(Double value) {
        String returnValue = null;
        if (value != null && value > 0) {
            DecimalFormat df = new DecimalFormat("###############0.00");// 16位整数位，两小数位
            returnValue = df.format(value);
        }
        return returnValue;
    }

    /**
     * 求Map<K,V>中Value(值)的最小值
     *
     * @param map
     * @return
     */
    public static Object getMinValue(Map<Integer, Integer> map) {
        if (map == null) return null;
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return obj[0];
    }

    /**
     * 求Map<K,V>中Value(值)的最大值
     *
     * @param map
     * @return
     */
    public static Object getMaxValue(Map<Integer, Integer> map) {
        if (map == null) return null;
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return obj[obj.length - 1];
    }

}
