package test;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.sms.SmsApi;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException, IllegalAccessException, Exception {
/*

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring*/
/*.xml"});
        SmsApi smsApi = (SmsApi) context.getBean("smsApi");
        String msg = smsApi.sendMsg("15876588460", "验证码为:888888【合创汽车金融】", false);
        System.out.println("螺丝帽短信发送返回报文==" + msg);
*/

        Map<String, Object> contentMap = Maps.newHashMap();
        contentMap.put("1111","{\"error\":0,\"msg\":\"ok\"}");
        if (contentMap != null) {
            if (contentMap.size() > 0) {
                for (Object obj : contentMap.keySet()) {
                    String content = (String) contentMap.get(obj);
                    JSONObject jsonObject = JSONObject.fromObject(content);
                    Iterator<String> keys = jsonObject.keys();//定义迭代器
                    String key = null;
                    Object value = null;
                    while (keys.hasNext()) {
                        key = keys.next();
                        value = jsonObject.get(key);
                        //map.put(key, value);
                    }
                }
            }
        }

    }

}
