package test;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.file.UploadFileUtil;
import hc.lease.common.util.DateUtils;
import hc.lease.common.util.ListUtil;
import org.apache.commons.fileupload.FileUploadBase;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException, IllegalAccessException, Exception {

        /*
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring*//*.xml"});
        LeaseAccountAdapter leaseAccountAdapter = (LeaseAccountAdapter) context.getBean("leaseAccountAdapter");
        //leaseAccountAdapter.findPage(1, 10, null);
        leaseAccountAdapter.deleteByPrimaryKey(26l);
        */

        /*
        DateTime dateTime = DateTime.now();
        DateTime limitDateTime = dateTime.plusMinutes(30);//2小时后过期
        System.out.print("limitDateTime==" + limitDateTime);
        */

        /*
        File file = new File("/data/web/lcedai/fileUpload/img/account/2017-07-08/8474b1e9-4dea-49c2-8224-e9e0463c4e56.jpg");
        // 创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        */

        /*
        SimpleDateFormat sdfFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = sdfFormat.parse("20170628203922");

        System.out.print("date==" + DateUtil.stampToDate("20170628203922"));
        */

        /*
        DateTime start = new DateTime(new Date());
        DateTime end = start.plusHours(2);//2小时后过期
        System.out.print("start="+start);
        System.out.print("end="+end);
        Date startDate = start.toDate();
        Date endDate = end.toDate();
        System.out.print("==="+startDate.after(endDate));
        */

        /*
        Date date = DateUtil.stampToDate("1497514006");
        System.out.print("date=="+date);
        */

        /*
        String base64Img = null;
        try {
            base64Img = GetUrlImageToBase64("http://192.168.122.111:8090/2017-06-14/bdd816d0-a45d-489d-b608-f7f4c7b2cc60.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(base64Img);
        */

        /*
        String y = DateUtil.formatDate(new Date(), "yyyy");
        System.out.println(y);
        String m = DateUtil.formatDate(new Date(), "MM");
        System.out.println(m);
        */

        /*
        System.out.println("=="+DateUtil.getCurrentYmdDate(5));
        System.out.println("===="+DateUtil.getDateYmdChina(DateUtil.getCurrentYmdDate(5)));
        */

        /*
        Map<String, Object> backMap = Maps.newHashMap();
        ArrayList repaymentDateList = new ArrayList();
        backMap = Maps.newHashMap();
        backMap.put("dayOne", DateUtil.getDateMdChina(DateUtil.getCurrentMdDate(Integer.parseInt("5"))));
        backMap.put("dayOneItem", 5);
        repaymentDateList.add(backMap);
        backMap = Maps.newHashMap();
        backMap.put("dayTwo", DateUtil.getDateMdChina(DateUtil.getCurrentMdDate(Integer.parseInt("15"))));
        backMap.put("dayTwoItem", 15);
        repaymentDateList.add(backMap);
        backMap = Maps.newHashMap();
        backMap.put("dayThree", DateUtil.getDateMdChina(DateUtil.getCurrentMdDate(Integer.parseInt("25"))));
        backMap.put("dayThreeItem", 25);
        repaymentDateList.add(backMap);
        */

        /*
        BigDecimal totlePriceF = new BigDecimal(49.42).add(new BigDecimal(49.43));//因为通联的金额用 分 做单位
        System.out.print(totlePriceF);
        */

        /*
        List<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        ids.add(2l);
        ids.add(3l);
        System.out.print(ListUtil.containsList(ids,"4"));
        */

        /*
        BigDecimal b1 = new BigDecimal(2569920);
        BigDecimal b2 = new BigDecimal(24);
        BigDecimal b3 = new BigDecimal(60);
        BigDecimal b4 = new BigDecimal(60);
        System.out.print(b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).divide(b3, 2, BigDecimal.ROUND_HALF_UP).divide(b4, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
        */

        /*
        Date d1 = new Date("2017-09-15");
        Date d2 = new Date("2017-09-17");
        long diff = d2.getTime() - d1.getTime();// 毫秒ms
        long diffSeconds = diff / 1000 % 60;//秒
        long diffMinutes = diff / (60 * 1000) % 60;//分钟
        long diffHours = diff / (60 * 60 * 1000) % 24;//小时
        long diffDays = diff / (24 * 60 * 60 * 1000);//天
        long totalSeconds = (diffDays * 24 * 60 * 60) + (diffHours * 60 * 60) + (diffMinutes * 60) + diffSeconds;//总秒数
        System.out.print("totalSeconds=" + totalSeconds);
        */

        /*
        System.out.print(DateUtils.getYear());
        */

        //if (1==1) if (2==3) System.out.print("==");


        /*
        BigDecimal total = new BigDecimal(222.32);
        System.out.print(total.setScale(2,BigDecimal.ROUND_HALF_UP));
        */


        Map<String, Object> map = Maps.newHashMap();
        map.put("11", 1);
        map.put("22", 2);
        System.out.print(map);

        //System.out.print(DateUtil.secondsToDate(1111111));

    }

    /**
     * 获取网络图片并转为Base64编码
     *
     * @param url 网络图片路径
     * @return base64编码
     * @throws Exception
     */
    public static String GetUrlImageToBase64(String url) throws Exception {
        if (url == null || "".equals(url.trim()))
            return null;
        URL u = new URL(url);
        // 打开图片路径
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        // 设置请求方式为GET
        conn.setRequestMethod("GET");
        // 设置超时响应时间为5秒
        conn.setConnectTimeout(5000);
        // 通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();
        // 读取图片字节数组
        byte[] data = new byte[inStream.available()];
        inStream.read(data);
        inStream.close();
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串


        UploadFileUtil.base64UploadFile(encoder.encode(data), null, "10240", "E:\\img", "test", null);


        return encoder.encode(data);
    }

}
