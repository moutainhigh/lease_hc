package hc.lease.common.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 * @author tong
 * @version 2017-5-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    public static Date getDateStart(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDateEnd(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
     * 当前日期后 addD 日
     */
    public static Date getPassDate(Date date, int addD) {
        return DateUtils.addDays(date, addD);
    }

    /**
     * 根据开始日期 ，需要的工作日天数 ，计算工作截止日期，并返回截止日期
     *
     * @param startDate 开始日期
     * @param workDay   工作日天数(周一到周五)
     * @return Date类型
     */
    public static Date getWorkDay(Date startDate, int workDay) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(startDate);
        for (int i = 0; i < workDay; i++) {
            c1.set(Calendar.DATE, c1.get(Calendar.DATE) + 1);
            if (Calendar.SATURDAY == c1.get(Calendar.SATURDAY) || Calendar.SUNDAY == c1.get(Calendar.SUNDAY)) {
                workDay = workDay + 1;
                c1.set(Calendar.DATE, c1.get(Calendar.DATE) + 1);
                continue;
            }
        }
        return c1.getTime();
    }

    /**
     * 两个时间比较 startDateTime 是否大于 endDateTime
     *
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    public static boolean after(DateTime startDateTime, DateTime endDateTime) {

        System.out.print("startDateTime=" + startDateTime);
        System.out.print("endDateTime=" + endDateTime);
        Date startDate = startDateTime.toDate();
        Date endDate = endDateTime.toDate();
        System.out.print("===" + startDate.after(endDate));
        return startDate.after(endDate);
    }

    /**
     * 日期运算
     *
     * @param date             需运算日期
     * @param calendarConstant 运算时间单位(java.util.Calendar )
     * @param timeNum          运算值（可正可负）
     * @return
     */
    public static Date dateCalculate(Date date, int calendarConstant, int timeNum) {
        Calendar calst = Calendar.getInstance();
        calst.setTime(date);
        switch (calendarConstant) {
            case Calendar.SECOND:
                calst.add(Calendar.SECOND, timeNum);
                break;
            case Calendar.MINUTE:
                calst.add(Calendar.MINUTE, timeNum);
                break;
            case Calendar.HOUR:
                calst.add(Calendar.HOUR, timeNum);
                break;
            case Calendar.DATE:
                calst.add(Calendar.DATE, timeNum);
                break;
            case Calendar.MONTH:
                calst.add(Calendar.MONTH, timeNum);
                break;
            case Calendar.YEAR:
                calst.add(Calendar.YEAR, timeNum);
                break;
        }
        return calst.getTime();
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        // System.out.println(formatDate(parseDate("2010/3/6")));
        // System.out.println(getDate("yyyy年MM月dd日 E"));
        // long time = new Date().getTime()-parseDate("2012-11-19").getTime();
        // System.out.println(time/(24*60*60*1000));
    }
}
