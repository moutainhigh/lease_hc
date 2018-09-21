import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import com.hc.lease.postlending.model.LeaseAllinpayLog;
import com.hc.lease.postlending.vo.TransBody;
import hc.lease.common.util.ConvertMap2Obj;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException, IllegalAccessException {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/*.xml"});

        MonthlyPaymentAdapter monthlyPaymentAdapter = (MonthlyPaymentAdapter) context.getBean("monthlyPaymentAdapter");

        ResultHashMap resultHashMap = monthlyPaymentAdapter.findQueryTradeNew(null, null);
        List leaseAllinpayLogList = (List) resultHashMap.get("result");
        if (leaseAllinpayLogList != null) {
            if (leaseAllinpayLogList.size() > 0) {
                TransBody transBody = new TransBody();
                for (int i = 0; i < leaseAllinpayLogList.size(); i++) {
                    HashMap hashMap = (HashMap) leaseAllinpayLogList.get(i);
                    LeaseAllinpayLog leaseAllinpayLog = ConvertMap2Obj.toBean(LeaseAllinpayLog.class, hashMap);
                    Long repaymentId = leaseAllinpayLog.getRepaymentId();
                    Integer isSendPayment = leaseAllinpayLog.getIsSendPayment();
                    Integer paymentResult = leaseAllinpayLog.getPaymentResult();
                    Long allinpayLogId = leaseAllinpayLog.getId();
                    String reqSn = leaseAllinpayLog.getReqSn();
                    Integer status = leaseAllinpayLog.getStatus();

                    //扣款结果 为 1扣款中 、是否已经操作扣款 为 1已操作、通联支付状态 为 已提交
                    if (isSendPayment == 1 && paymentResult == 1 && status == 0) {
                        transBody.setReqSn(reqSn);
                        transBody.setRepaymentId(repaymentId);
                    }

                }
            }
        }
    }
}
