package hc.lease.common.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by Qiang on 2017/5/19.
 */
public class EncodingTool {

    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
