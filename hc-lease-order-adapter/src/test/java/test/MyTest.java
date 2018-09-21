package test;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.service.api.LeaseContractService;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentService;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException, IllegalAccessException, Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/*.xml"});
        //LeaseContractService leaseContractService = (LeaseContractService) context.getBean("leaseContractService");
        LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService = (LeaseSchemeRepaymentStatusService) context.getBean("leaseSchemeRepaymentStatusService");


        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("contractId", 155l);
        Boolean status = leaseSchemeRepaymentStatusService.findByContractidAndStatus(paramsMap, null);
        System.out.println(status);

        //leaseAccountAdapter.findPage(1, 10, null);

        /*

        List<String> repaymentDateList = new ArrayList<String>();
        repaymentDateList.add("2017-9-5");
        paramsMap.put("branchCompanyId", null);//分公司主键id
        paramsMap.put("repaymentDate", repaymentDateList);//扣款日
        paramsMap.put("status", null);//月供状态/合同状态
        paramsMap.put("overdueStatus", null);//滞纳金状态
        paramsMap.put("overdue", null);//是否逾期
        leaseContractService.findPostLending(1, 10, paramsMap);
        */

    }

}
