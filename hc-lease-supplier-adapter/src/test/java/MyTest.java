

import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.adapter.api.LeaseCarAdapter;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException, IllegalAccessException, Exception {


     /*   ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring*//*.xml"});
        LeaseCarAdapter leaseCarAdapter = (LeaseCarAdapter) context.getBean("leaseCarAdapter");

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("", "");
        leaseCarAdapter.findPage(0, 10, paramsMap);*/

     for(int i=1;i<99;i++) {
         NumberFormat format = new DecimalFormat("0000");
         String format1 = format.format(i);
         System.out.println("****string"+format1);
         Integer integer = Integer.valueOf(format1);
         System.out.println("****int"+integer);
     }

    }
}
