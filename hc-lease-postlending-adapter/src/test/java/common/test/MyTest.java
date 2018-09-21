package common.test;

import com.aipg.transquery.QTDetail;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.CallbackDealWay;
import com.hc.lease.common.core.constant.PaymentResult;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.vo.FindQueryTradeNewVo;
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import com.hc.lease.postlending.vo.TransBody;
import hc.lease.common.util.MD5Util;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.joda.time.DateTime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyTest {
    public static Integer item = 0;

    public static void main(String[] args) throws GMException, IOException, FileUploadBase.FileSizeLimitExceededException, IllegalAccessException, Exception {

        /*
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring*//*.xml"});
        MonthlyPaymentAdapter monthlyPaymentAdapter = (MonthlyPaymentAdapter) context.getBean("monthlyPaymentAdapter");
        TranxAdapter tranxAdapter = (TranxAdapter) context.getBean("tranxAdapter");

        List<String> repaymentDate= new ArrayList<String>();
        repaymentDate.add("2017-10-15");
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("repaymentDate", repaymentDate);//扣款日
        paramsMap.put("userI", 2l);//操作用户主键id
        monthlyPaymentAdapter.repaymentExcept(paramsMap);
        */

        /*
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentListNeed = new ArrayList<BatchPostlendingPaymentVo>();
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentListNoNeed = new ArrayList<BatchPostlendingPaymentVo>();
        BatchPostlendingPaymentVo batchPostlendingPaymentVo1 = new BatchPostlendingPaymentVo();
        batchPostlendingPaymentVo1.setId(1l);
        batchPostlendingPaymentListNeed.add(batchPostlendingPaymentVo1);
        batchPostlendingPaymentVo1.setId(2l);
        batchPostlendingPaymentListNeed.add(batchPostlendingPaymentVo1);
        BatchPostlendingPaymentVo batchPostlendingPaymentVo2 = new BatchPostlendingPaymentVo();
        batchPostlendingPaymentVo2.setId(3l);
        batchPostlendingPaymentListNoNeed.add(batchPostlendingPaymentVo2);
        batchPostlendingPaymentVo2.setId(4l);
        batchPostlendingPaymentListNoNeed.add(batchPostlendingPaymentVo2);
        batchPostlendingPaymentVo2.setId(5l);
        batchPostlendingPaymentListNoNeed.add(batchPostlendingPaymentVo2);
        System.out.println("batchPostlendingPaymentListNeed.size()==" + batchPostlendingPaymentListNeed.size());
        batchPostlendingPaymentListNeed = batchPostlendingPaymentListNoNeed;
        System.out.println("batchPostlendingPaymentListNeed.size()==" + batchPostlendingPaymentListNeed.size());
        */

        //postlendingJobQueryTradeNew(monthlyPaymentAdapter);

        /*
        List<Long> contractIds = new ArrayList<Long>();
        contractIds.add(157l);
        TransBody transBody = new TransBody();
        transBody.setRepaymentDate(DateUtil.getCurrentYmdDate(25));
        transBody.setContractIds(contractIds);
        transBody.setCreateBy(2l);
        transBody.setUpdateBy(2l);
        ResultHashMap resultHashMap = monthlyPaymentAdapter.dualBatchPostlendingPayment(transBody);
        */

        /*
        Date nowDate = DateTime.now().toDate();
        Integer timeDifference = Integer.parseInt(String.valueOf(DateUtil.timeDifference(DateUtil.smartFormat("2017-12-05"), DateUtil.smartFormat("2017-12-06"))));//两个日期秒数相差
        Integer overdueDayUp = DateUtil.secondsToDate(timeDifference);//逾期天数
        */

        /*
        //如果逾期不够一天则当做一天
        if (timeDifference > 0 && overdueDayUp == 0) {
            overdueDayUp = 1;
        }
        */

        //System.out.println("'1-1'".substring(1,"'1-1'".length()-1));

        /*
        System.out.println("=1=" + Math.pow(1 + 0.015, 36));
        System.out.println("=2=" + 0.015 *Math.pow(1 + 0.015, 36));
        System.out.println(Math.pow(1 + 0.015, 36) - 1);
        */
/*

        double perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterestAndBalancePayment(16400, 0.17, 36, 41800);
        System.out.println("每月还款本息4：" + perMonthPrincipalInterest);

        double comprehensiveQuote = AverageCapitalPlusInterestUtils.getComprehensiveQuote(perMonthPrincipalInterest, 0.17, 36, 41800);
        System.out.println("客户综合报价4：" + comprehensiveQuote);
*/

/*
        long createTime = new Date().getTime();
        System.out.println("createTime===" + createTime);
        long differ_time = DateUtil.timeDifferenceV1(1516434485062l, createTime);//时间差/秒
        System.out.println("differ_time===" + differ_time);
        if (differ_time > 7200) {
            System.out.println("======");
        }
        */

/*


        Date date = DateTime.now().toDate();
        Date date_1 = DateUtil.addOneSecond(date, 60);
        System.out.println("date_1==" + date_1);
        System.out.println("date_1.getTime()==" + date_1.getTime());
*/

        //getJsapiTicket();

        //System.out.println(DateUtil.interceptDate("2018-01-01 08:00:00"));

        /*
        List lists_1 = new ArrayList();
        List lists_2 = new ArrayList();
        lists_1.add(1);
        lists_1.add(2);
        lists_1.add(3);
        lists_1.add(4);

        lists_2.add(1);
        lists_2.add(2);

        System.out.println(lists_1.removeAll(lists_2));
        System.out.println(lists_1);
        */

        //System.out.println(3511%7);
        /*
        double x = 7;
        double y = 351;
        //向上取整
        double m = Math.ceil(y / x);
        //向下取整
        double n = Math.floor(y / x);
        //System.out.println("向上取整"+m+"\n向下取整"+n);
        //注意int/int结果是int，所以要把997变成997.0 变成double类型才能取值
        //System.out.println(Math.ceil(997.0/10));


        int a = 5610;
        int b = 5610;
        int c = a / b;
        int d = a % b;
        System.out.print(c + "\n" + d + "\n");
        int item = d == 0 ? c : c + 1;
        for (int i = 0; i < item; i++) {
            System.out.print("==" + i + "\n");
        }
        */

        /*
        BigDecimal amt = new BigDecimal(1525.21);
        BigDecimal[] results = amt.divideAndRemainder(BigDecimal.valueOf(5000));
        Integer merchant = results[0].setScale(0, RoundingMode.HALF_UP).intValue();//商
        BigDecimal remainder = results[1].setScale(2, RoundingMode.HALF_UP);//余数
        System.out.print(merchant.toString() + "\n");
        System.out.print(remainder.toString() + "\n");
        for (int i = 1; i <= merchant; i++) {
            System.out.print("==" + i + "\n");
        }
        */

        SimpleDateFormat sd = new SimpleDateFormat(DateUtil.Y_M_D);
        /*
        Calendar calendar = Calendar.getInstance();

        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
        Date time = calendar.getTime();
        System.out.print(sd.format(time));
        */

        //System.out.println(getDate(100));
        /*
        for (int i = 1; i <= 12; i++) {
            item = item + 1;
            Date nextDate = sd.parse(sd.format(DateUtils.dateCalculate(DateTime.now().toDate(), Calendar.DATE, i)));
            //System.out.println("nextDate=" + nextDate);
            System.out.println("item==" + item);
        }

        test();
        System.out.println("item=" + item);
        */

        /*
        byte[] by = hexToByteArray("000B");
        for (int i = 0; i < by.length; i++) {
            System.out.println("=---=" + by[i]);
        }
        */

        //initUserPassword();

        /*
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i" + i + ":j" + j + "--1--");
                if (j == 4) {
                    System.out.println("-continue=");
                    break;
                }
            }
            System.out.println("i" + i + "--2--");
        }
        System.out.println("--3--");
        */

        //dealNo();

        System.out.println(sd.format(DateUtil.getNearDate()));

    }

    /**
     * 生成有序编号
     */
    public static void dealNo() {

        String str_id = "C99999";
        char start = str_id.substring(0, 1).charAt(0);
        System.out.println("start=1=" + start);
        System.out.println("str_id.substring(1)=1=" + str_id.substring(1));
        int int_id = Integer.parseInt(str_id.substring(1));
        System.out.println("int_id=1=" + int_id);
        if (int_id == 99999) {
            int_id = 0;
            ++start;
        }
        System.out.println("start=2=" + start);
        System.out.println("int_id=2=" + int_id);
        String new_str_id = String.valueOf(++int_id);
        System.out.println("new_str_id=1=" + new_str_id);
        String append[] = new String[]{start + "00000", start + "0000", start + "000", start + "00", start + "0", start + ""};
        new_str_id = append[new_str_id.length()] + new_str_id;
        System.out.println("new_str_id=2=" + new_str_id);
        System.out.println(new_str_id);

    }

    /**
     * 初始化后台用户注册密码
     */
    public static void initUserPassword() {

        //初始化密码
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = randomNumberGenerator.nextBytes().toHex();
        String phone = "yangzhiqian";
        String password = "yangzhiqian";
        String credentialsSalt = phone + salt;
        String userPassword = MD5Util.string2MD5(password + phone + credentialsSalt);
        System.out.println("=salt=" + salt);
        System.out.println("=userPassword=" + userPassword);
        //初始化密码

    }

    /**
     * Hex字符串转byte
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte
     */
    public static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

    /**
     * hex字符串转byte数组
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte数组结果
     */
    public static byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            //奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            //偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    public static void test() {
        for (int i = 1; i <= 12; i++) {
            item = item + 1;
        }
    }

    public static String getDate(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime().getTime());
    }


    public static void getJsapiTicket() throws GMException {

        Date newDate = DateTime.now().toDate();
        String wechatJsapiTicket = "xxxx";//缓存的数据
        Date invalidDate = DateUtil.addOneSecond(newDate, 60);//微信公众号jsapi_ticket失效时间戳
        System.out.println("invalidDate==" + invalidDate);
        if (StringUtils.isEmpty(wechatJsapiTicket)) {

        } else {
            long invalidDateTimestampNew = 1516363067247l;//微信公众号jsapi_ticket失效时间戳
            long createTime = new Date().getTime();//当前时间戳
            long differ_time = DateUtil.timeDifferenceV1(createTime, invalidDateTimestampNew);//时间差/秒

            if (differ_time <= 30) {//失效时间戳和当前时间戳相差不大于30秒则判定是两个时间一样，即已失效
                System.out.println("======");
            } else {

            }

        }

    }


    public static void postlendingJobQueryTradeNew(MonthlyPaymentAdapter monthlyPaymentAdapter) throws GMException {

        ResultHashMap resultHashMap = monthlyPaymentAdapter.findQueryTradeNew(null, null);// 需要轮询通联 的 交易流水/状态为扣款中
        List leaseSchemeRepaymentStatusList = (List) resultHashMap.get("result");// 需要轮询通联 的 交易流水/状态为扣款中
        if (leaseSchemeRepaymentStatusList != null) {
            if (leaseSchemeRepaymentStatusList.size() > 0) {
                TransBody transBody = new TransBody();
                for (int i = 0; i < leaseSchemeRepaymentStatusList.size(); i++) {
                    FindQueryTradeNewVo findQueryTradeNewVo = (FindQueryTradeNewVo) leaseSchemeRepaymentStatusList.get(i);
                    //HashMap hashMap = (HashMap) leaseSchemeRepaymentStatusList.get(i);
                    //FindQueryTradeNewVo findQueryTradeNewVo = ConvertMap2Obj.toBean(FindQueryTradeNewVo.class, hashMap);
                    Long repaymentId = findQueryTradeNewVo.getRepaymentId();
                    Long contractId = findQueryTradeNewVo.getContractId();
                    Integer paymentResult = findQueryTradeNewVo.getPaymentResult();
                    String reqSn = findQueryTradeNewVo.getReqSn();
                    String sn = findQueryTradeNewVo.getSn();
                    Integer type = findQueryTradeNewVo.getType();
                    Long allinpayLogId = findQueryTradeNewVo.getAllinpayLogId();
                    Integer overdueType = findQueryTradeNewVo.getOverdueType();
                    Long repaymentStatusId = findQueryTradeNewVo.getId();
                    Integer singleOrBatch = findQueryTradeNewVo.getSingleOrBatch();

                    //支付状态 为 1扣款中
                    if (paymentResult == PaymentResult.TYPE_1) {
                        transBody.setReqSn(reqSn);
                        transBody.setSn(sn);
                        transBody.setRepaymentId(repaymentId);
                        transBody.setContractId(contractId);
                        transBody.setRepaymentStatusId(repaymentStatusId);
                        transBody.setPayType(type);
                        transBody.setOverdueType(overdueType);
                        transBody.setAllinpayLogId(allinpayLogId);
                        transBody.setSingleOrBatch(singleOrBatch);
                        queryTradeNew(transBody, monthlyPaymentAdapter);//交易查询/轮询
                    }
                }

                //monthlyPaymentAdapter.dualAllinpaySendSmsInfoInstall();//扣款发送短信提醒

            }
        }

    }

    /**
     * 交易查询/轮询
     *
     * @throws GMException
     */
    public static void queryTradeNew(TransBody transBody, MonthlyPaymentAdapter monthlyPaymentAdapter) throws GMException {
        ResultHashMap resultHashMap = monthlyPaymentAdapter.queryTradeNew(transBody, null);
        ReturnMessage returnMessage = (ReturnMessage) resultHashMap.get("result");
        returnMessage.setReqSn(transBody.getReqSn());
        returnMessage.setSn(transBody.getSn());
        returnMessage.setRepaymentId(transBody.getRepaymentId());
        returnMessage.setContractId(transBody.getContractId());
        returnMessage.setRepaymentStatusId(transBody.getRepaymentStatusId());
        returnMessage.setType(transBody.getPayType());
        returnMessage.setOverdueType(transBody.getOverdueType());
        returnMessage.setAllinpayLogId(transBody.getAllinpayLogId());
        returnMessage.setSingleOrBatch(transBody.getSingleOrBatch());
        changeSchemeRepaymentStatus(returnMessage, monthlyPaymentAdapter);
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 还款记录 状态
     *
     * @throws GMException
     */
    public static void changeSchemeRepaymentStatus(ReturnMessage returnMessage, MonthlyPaymentAdapter monthlyPaymentAdapter) throws GMException {
        TransBody transBody = new TransBody();
        transBody.setAipgrspRetCode(returnMessage.getAipgrspRetCode());
        transBody.setAipgrspErrMsg(returnMessage.getAipgrspErrmsg());
        transBody.setReqSn(returnMessage.getReqSn());
        transBody.setPayType(returnMessage.getType());
        transBody.setOverdueType(returnMessage.getOverdueType());

        List<QTDetail> qTDetailList = returnMessage.getQueryDetails();
        if (qTDetailList != null) {
            if (qTDetailList.size() > 0) {
                for (int i = 0; i < qTDetailList.size(); i++) {
                    QTDetail qTDetail = qTDetailList.get(i);
                    String QT_SN = qTDetail.getSN();
                    String BATCHID = qTDetail.getBATCHID();
                    if (BATCHID.equals(transBody.getReqSn())) {
                        if (returnMessage.getSingleOrBatch() == 1) {
                            if (QT_SN.equals(returnMessage.getSn())) {
                                dealChangeSchemeRepaymentStatus(transBody, returnMessage, qTDetail, monthlyPaymentAdapter);
                            }
                        } else {
                            dealChangeSchemeRepaymentStatus(transBody, returnMessage, qTDetail, monthlyPaymentAdapter);
                        }
                    }
                }
            }
        }
    }

    /**
     * @param transBody
     * @param returnMessage
     * @param qTDetail
     * @param monthlyPaymentAdapter
     * @throws GMException
     */
    public static void dealChangeSchemeRepaymentStatus(TransBody transBody, ReturnMessage returnMessage, QTDetail qTDetail, MonthlyPaymentAdapter monthlyPaymentAdapter) throws GMException {
        transBody.setSn(returnMessage.getSn());//批量代收才有此参数
        transBody.setRetCode(qTDetail.getRET_CODE());
        transBody.setErrMsg(qTDetail.getERR_MSG());
        transBody.setFinTime(qTDetail.getFINTIME());
        transBody.setRepaymentId(returnMessage.getRepaymentId());
        transBody.setContractId(returnMessage.getContractId());
        transBody.setRepaymentStatusId(returnMessage.getRepaymentStatusId());
        transBody.setAllinpayLogId(returnMessage.getAllinpayLogId());
        monthlyPaymentAdapter.changeSchemeRepaymentStatus(transBody, null);
    }

}
