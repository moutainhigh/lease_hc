package com.test;

import com.hc.lease.account.service.LeaseAccountService;
import com.hc.lease.common.core.exception.GMException;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MyTest {

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException, IllegalAccessException {

        /*
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring*//*.xml"});
        LeaseAccountService leaseAccountService = (LeaseAccountService) context.getBean("leaseAccountService");
        leaseAccountService.findPage(1, 2, null);
        */

        String a = "http:192.168.122.111";
        String b = "xxx";
        String c = a+b;

        System.out.println(c.substring(a.length(), c.length()));

    }
}
