package hc.lease.common.util;

import org.junit.Test;

import java.util.Random;

/**
 * Created by Administrator on 2018/5/21.
 */
public class StringUtil {

    /**
     * 返回长度为【strLength】的随机数，在前面补0
     *
     * @param strLength
     * @return
     */
    public static String getFixLenthString(int strLength) {
        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }

    @Test
    public void testCreateSerialNo() throws Exception {

        System.out.println(getFixLenthString(4));

    }

}
