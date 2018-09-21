package com.hc.lease.common.core.excel.easyxls.common;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 重写DateUtil类
 *
 * @author tong
 */
public class DateUtil {

    public static final String Y_M_D = "yyyy-MM-dd";
    public static final String Y_M_D_HM = "yyyy-MM-dd HH:mm";
    public static final String Y_M_D_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD = "yyyyMMdd";
    public static final String YMDHM = "yyyyMMddHHmm";
    public static final String YMDHMS = "yyyyMMddHHmmss";
    public static final String ymd = "yyyy/MM/dd";
    public static final String ymd_HM = "yyyy/MM/dd HH:mm";
    public static final String ymd_HMS = "yyyy/MM/dd HH:mm:ss";

    public static final String Y_M_D_DOT = "yyyy.MM.dd";
    public static final String Y_M_D_HM_DOT = "yyyy.MM.dd HH:mm";
    public static final String Y_M_D_HMS_DOT = "yyyy.MM.dd HH:mm:ss";

    public static final String YMD_CHINA = "yyyy年MM月dd日";
    public static final String M_D = "MM-dd";
    public static final String MD_CHINA = "MM月dd日";
    public static final String YM_CHINA = "yyyy年MM月";
    public static final String Y_M = "yyyy-MM";

    /**
     * 智能转换日期
     *
     * @param date
     * @return
     */
    public static String smartFormat(Date date) {
        String dateStr = null;
        if (date == null) {
            dateStr = "";
        } else {
            try {
                dateStr = formatDate(date, Y_M_D_HMS);
                //时分秒
                if (dateStr.endsWith(" 00:00:00")) {
                    dateStr = dateStr.substring(0, 10);
                }
                //时分
                else if (dateStr.endsWith("00:00")) {
                    dateStr = dateStr.substring(0, 16);
                }
                //秒
                else if (dateStr.endsWith(":00")) {
                    dateStr = dateStr.substring(0, 16);
                }
            } catch (Exception ex) {
                throw new IllegalArgumentException("转换日期失败: " + ex.getMessage(), ex);
            }
        }
        return dateStr;
    }

    /**
     * 智能转换日期
     *
     * @param text
     * @return
     */
    public static Date smartFormat(String text) {
        Date date;
        try {
            if (text == null || text.length() == 0) {
                date = null;
            } else {
                int length = text.length();
                if (text.indexOf("-") > 0) {
                    if (length == 10 || length == 8 || length == 9) {
                        date = formatStringToDate(text, Y_M_D);
                    } else if (length == 16) {
                        date = formatStringToDate(text, Y_M_D_HM);
                    } else if (length == 19) {
                        date = formatStringToDate(text, Y_M_D_HMS);
                    } else {
//                        throw new IllegalArgumentException("日期长度不符合要求!");
                        return null;
                    }
                } else if (text.indexOf("/") > 0) {
                    if (length == 10 || length == 8 || length == 9) {
                        date = formatStringToDate(text, ymd);
                    } else if (length == 16) {
                        date = formatStringToDate(text, ymd_HM);
                    } else if (length == 19) {
                        date = formatStringToDate(text, ymd_HMS);
                    } else {
//                        throw new IllegalArgumentException("日期长度不符合要求!");
                        return null;
                    }
                } else if (text.indexOf(".") > 0) {
                    if (length == 10 || length == 8 || length == 9) {
                        date = formatStringToDate(text, Y_M_D_DOT);
                    } else if (length == 16) {
                        date = formatStringToDate(text, Y_M_D_HM_DOT);
                    } else if (length == 19) {
                        date = formatStringToDate(text, Y_M_D_HMS_DOT);
                    } else {
//                        throw new IllegalArgumentException("日期长度不符合要求!");
                        return null;
                    }
                } else {
                    if (length == 10) {
                        date = formatStringToDate(text, YMD);
                    } else if (length == 13) {
                        date = new Date(Long.parseLong(text));
                    } else if (length == 16) {
                        date = formatStringToDate(text, YMDHM);
                    } else if (length == 19) {
                        date = formatStringToDate(text, YMDHMS);
                    } else {
                        return null;
//                        throw new IllegalArgumentException("日期长度不符合要求!");
                    }
                }
            }
        } catch (Exception e) {
//            throw new IllegalArgumentException("日期格式错误!");
            return null;
        }
        return date;
    }

    /**
     * 获取当前日期
     *
     * @param format
     * @return
     * @throws Exception
     */
    public static String getNow(String format) throws Exception {
        return formatDate(new Date(), format);
    }

    /**
     * 格式化日期格式
     *
     * @param argDate
     * @param argFormat
     * @return 格式化后的日期字符串
     */
    public static String formatDate(Date argDate, String argFormat) {
        if (StringUtils.isNoneEmpty(argFormat)) {
            if (argFormat == null || argFormat.length() == 0) {
                argFormat = Y_M_D;
            }
            SimpleDateFormat sdfFrom = new SimpleDateFormat(argFormat);
            return sdfFrom.format(argDate).toString();
        }
        return null;
    }

    /**
     * 把字符串格式化成日期
     *
     * @param argDateStr
     * @param argFormat
     * @return
     */
    public static Date formatStringToDate(String argDateStr, String argFormat) throws Exception {
        if (argDateStr == null || argDateStr.trim().length() < 1) {
            throw new Exception("参数[日期]不能为空!");
        }
        String strFormat = argFormat;
        if (strFormat == null || strFormat.length() == 0) {
            strFormat = Y_M_D;
            if (argDateStr.length() > 16) {
                strFormat = Y_M_D_HMS;
            } else if (argDateStr.length() > 10) {
                strFormat = Y_M_D_HM;
            } else if (argDateStr.length() > 1) {
                strFormat = M_D;
            }
        }
        SimpleDateFormat sdfFormat = new SimpleDateFormat(strFormat);
        //严格模式
        sdfFormat.setLenient(false);
        try {
            return sdfFormat.parse(argDateStr);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    public static String dateContent() {

        StringBuilder sb = new StringBuilder();

        try {

            DateTimeFormatter newFmt = DateTimeFormat.forPattern("yyyy-MM-dd");//自定义日期格式
            Date now = new Date();
            DateTime newDateTime = new DateTime(now);
            String limitStr1 = newDateTime.toString(newFmt) + " 11:00:00";//11点
            String limitStr2 = newDateTime.toString(newFmt) + " 14:00:00";//14点
            String limitStr3 = newDateTime.toString(newFmt) + " 16:00:00";//16点

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = format.parse(limitStr1);//11点
            Date d2 = format.parse(limitStr2);//14点
            Date d3 = format.parse(limitStr3);//16点

            DateTime dateEndTime1 = new DateTime(d1);//11点
            DateTime dateEndTime2 = new DateTime(d2);//14点
            DateTime dateEndTime3 = new DateTime(d3);//16点
            DateTime nowDate = DateTime.now();//当前时间

            long nowMillisTime = nowDate.getMillis();//当前时间
            long millisTime1 = dateEndTime1.getMillis();//11点
            long millisTime2 = dateEndTime2.getMillis();//14点
            long millisTime3 = dateEndTime3.getMillis();//16点

            Date nowTime = new Date();
            DateTime dateTime = new DateTime(nowTime);

            //int day = dateTime.getDayOfWeek();
            //int hour = dateTime.getHourOfDay();

            Integer item = isSaturdayOrSunday(nowTime);//是否是周六日

            DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");//自定义日期格式
            if (item == 6) {//周六
                dateTime = dateTime.plusDays(2);
                sb.append(dateTime.toString(fmt));
                sb.append(" (");
                sb.append(dateTime.dayOfWeek().getAsText(Locale.CHINA));
                sb.append(")");
                sb.append("上午");
            } else if (item == 7) {//周日
                dateTime = dateTime.plusDays(1);
                sb.append(dateTime.toString(fmt));
                sb.append(" (");
                sb.append(dateTime.dayOfWeek().getAsText(Locale.CHINA));
                sb.append(")");
                sb.append("上午");
            } else {
                if (nowDate.isBefore(millisTime1)) {//11点之前
                    sb.append(dateTime.toString(fmt));
                    sb.append(" (");
                    sb.append(dateTime.dayOfWeek().getAsText(Locale.CHINA));
                    sb.append(")");
                    sb.append("上午");
                } else if (dateEndTime1.isBefore(nowMillisTime) && nowDate.isBefore(millisTime3)) {//11点后  16点前
                    sb.append(dateTime.toString(fmt));
                    sb.append(" (");
                    sb.append(dateTime.dayOfWeek().getAsText(Locale.CHINA));
                    sb.append(")");
                    sb.append("下午");
                } else if (dateEndTime3.isBefore(nowMillisTime)) {//16点后
                    dateTime = dateTime.plusDays(1);
                    sb.append(dateTime.toString(fmt));
                    sb.append(" (");
                    sb.append(dateTime.dayOfWeek().getAsText(Locale.CHINA));
                    sb.append(")");
                    sb.append("上午");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String acceptPreliminaryDateContent() {
        StringBuilder sb = new StringBuilder();
        Date nowTime = new Date();
        DateTime dateTime = new DateTime(nowTime);
        Integer item = isSaturdayOrSunday(nowTime);//是否是周六日
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");//自定义日期格式
        if (item == 6) {//周六
            dateTime = dateTime.plusDays(2);
            sb.append(dateTime.toString(fmt));
        } else if (item == 7) {//周日
            dateTime = dateTime.plusDays(1);
            sb.append(dateTime.toString(fmt));
        } else {
            dateTime = dateTime.plusDays(1);
            sb.append(dateTime.toString(fmt));
        }
        System.out.print(sb.toString());
        return sb.toString();
    }

    /**
     * 是否是周六日
     *
     * @param bdate
     * @return
     * @throws Exception
     */
    public static Integer isSaturdayOrSunday(Date bdate) {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        //String bDate = "2016-12-19";
        //Date bdate = format1.parse(bDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(bdate);
        Integer item = 0;//
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {//周日
            item = 7;
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {//周一
            item = 1;
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {//周二
            item = 2;
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {//周三
            item = 3;
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {//周四
            item = 4;
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {//周五
            item = 5;
        } else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {//周六
            item = 6;
        }
        return item;
    }

    /**
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     * @Description: String类型毫秒数转换成日期
     */
    public static String stringToDate(String lo) {
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat(Y_M_D_HMS);
        return sd.format(date);
    }

    /**
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     * @Description: long类型转换成日期
     */
    public static SimpleDateFormat longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat(Y_M_D_HMS);
        return sd;
    }

    /**
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sd = new SimpleDateFormat(Y_M_D_HMS);
        return sd.format(date);
    }

    public static void main(String args[]) {
        acceptPreliminaryDateContent();
    }

    /**
     * 加秒数
     *
     * @param date
     * @return
     */
    public static Date addOneSecond(Date date, int addSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, addSecond);
        return calendar.getTime();
    }

    /**
     * 两个日期秒数相差
     *
     * @param d1
     * @param d2
     */
    public static long timeDifference(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();// 毫秒ms
        long diffSeconds = diff / 1000 % 60;//秒
        long diffMinutes = diff / (60 * 1000) % 60;//分钟
        long diffHours = diff / (60 * 60 * 1000) % 24;//小时
        long diffDays = diff / (24 * 60 * 60 * 1000);//天
        long totalSeconds = (diffDays * 24 * 60 * 60) + (diffHours * 60 * 60) + (diffMinutes * 60) + diffSeconds;//总秒数
        return totalSeconds;
    }

    /**
     * 两个日期秒数相差
     *
     * @param d1
     * @param d2
     */
    public static long timeDifferenceV1(long d1, long d2) {
        long diff = d2 - d1;// 毫秒ms
        long diffSeconds = diff / 1000 % 60;//秒
        long diffMinutes = diff / (60 * 1000) % 60;//分钟
        long diffHours = diff / (60 * 60 * 1000) % 24;//小时
        long diffDays = diff / (24 * 60 * 60 * 1000);//天
        long totalSeconds = (diffDays * 24 * 60 * 60) + (diffHours * 60 * 60) + (diffMinutes * 60) + diffSeconds;//总秒数
        return totalSeconds;
    }

    /**
     * 将时间戳转换为时间
     *
     * @param s
     * @return
     */
    public static Date stampToDate(String s) {
        if (StringUtils.isNoneEmpty(s)) {
            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long lt = new Long(s);
            Date date = new Date(lt);
            res = simpleDateFormat.format(date);
            return date;
        }
        return null;
    }

    /**
     * 用秒推算天
     *
     * @param s
     * @return
     */
    public static int secondsToDate(Integer s) {
        return new BigDecimal(s).divide(new BigDecimal(24), 2, BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP).intValue();
    }

    public static Date strToDate(String s) {
        Date date = null;
        if (StringUtils.isNoneEmpty(s)) {
            try {
                SimpleDateFormat sdfFormat = new SimpleDateFormat(YMDHMS);
                date = sdfFormat.parse(s);
            } catch (ParseException e) {
            }
        }
        return date;
    }

    /**
     * 当年 月 的第 s 号
     *
     * @param s
     * @return
     */
    public static Date getCurrentYmdDate(Integer s) {
        String y = DateUtil.formatDate(new Date(), "yyyy");
        String m = DateUtil.formatDate(new Date(), "MM");
        Date ymd = null;
        try {
            ymd = DateUtil.formatStringToDate(y + "-" + m + "-" + s, "yyyy-MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ymd;
    }

    /**
     * 当月 的第 s 号
     *
     * @param s
     * @return
     */
    public static Date getCurrentMdDate(Integer s) {
        String m = DateUtil.formatDate(new Date(), "MM");
        Date md = null;
        try {
            md = DateUtil.formatStringToDate(m + "-" + s, "MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md;
    }

    /**
     * xxxx年xx月xx日
     *
     * @param date
     * @return
     */
    public static String getDateYmdChina(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YMD_CHINA);
        String datestr = sdf.format(date);
        return datestr;
    }

    /**
     * xxxx年xx月
     *
     * @param date
     * @return
     */
    public static String getDateYmChina(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YM_CHINA);
        String datestr = sdf.format(date);
        return datestr;
    }

    /**
     * xx月xx日
     *
     * @param date
     * @return
     */
    public static String getDateMdChina(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(MD_CHINA);
        String datestr = sdf.format(date);
        return datestr;
    }

    /**
     * yyyy-mm-dd
     *
     * @param date
     * @return
     */
    public static String getDateYMDChina(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
        String datestr = sdf.format(date);
        return datestr;
    }

    /**
     * yyyy-mm
     *
     * @return
     */
    public static String getDateYMChina() {
        Date date = DateTime.now().toDate();
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M);
        String datestr = sdf.format(date);
        return datestr;
    }

    /**
     * yyyy-mm-dd
     *
     * @param date
     * @return
     */
    public static Date getDateYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
        Date date1 = null;
        try {
            date1 = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    /**
     * yyyymmdd
     *
     * @param date
     * @return
     */
    public static String getDateYmd(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YMD);
        String datestr = sdf.format(date);
        return datestr;
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static Date getDateY_M_D_HMS(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_HMS);
        Date date1 = null;
        try {
            date1 = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    /**
     * 时间戳
     *
     * @return
     */
    public static String getTime() {
        return String.valueOf(new Date().getTime());
    }


    /**
     * 智能截取日期
     *
     * @param text
     * @return
     */
    public static String interceptDate(String text) {
        String date = null;
        try {
            if (text == null || text.length() == 0) {
                date = null;
            } else {
                int length = text.length();
                if (text.indexOf("-") > 0 || text.indexOf("/") > 0 || text.indexOf(".") > 0) {
                    if (length == 10 || length == 8 || length == 9 || length == 16 || length == 19) {
                        date = text.substring(0, text.lastIndexOf(" "));
                    } else {
//                        throw new IllegalArgumentException("日期长度不符合要求!");
                        return null;
                    }
                } else {
                    if (length == 10 || length == 8 || length == 9 || length == 16 || length == 19) {
                        date = text.substring(0, text.lastIndexOf(" "));
                    } else {
                        return null;
//                        throw new IllegalArgumentException("日期长度不符合要求!");
                    }
                }
            }
        } catch (Exception e) {
//            throw new IllegalArgumentException("日期格式错误!");
            return null;
        }
        return date;
    }

    /**
     * 获取指定日期所在月份开始的时间戳
     *
     * @param date 指定日期
     * @return
     */
    public static Date getMonthBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return stampToDate(String.valueOf(c.getTimeInMillis()));
    }

    /**
     * 获取指定日期所在月份结束的时间戳
     *
     * @param date 指定日期
     * @return
     */
    public static Date getMonthEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND, 59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间戳
        return stampToDate(String.valueOf(c.getTimeInMillis()));
    }

    /**
     * 获取距离当日最近的扣款日
     *
     * @return
     */
    public static Date getNearDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        int payDate = calendar.get(Calendar.DAY_OF_MONTH);
        if (payDate > 0 && payDate <= 10) {
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 5);
        } else if (payDate >= 11 && payDate <= 20) {
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 15);
        } else {
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, 25);
        }
        Date time = calendar.getTime();
        return time;
    }

}
