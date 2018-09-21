/**
 * 作者：tong
 * 日期：2017-5-10
 * 功能说明：交易参数
 */
package com.hc.lease.common.core.constant;

/**
 * 通联支付 配置参数
 */
public class TranxConfig {

    public String acctName = "张国光";
    public String acctNo = "6225882516636351";
    public String amount = "1";//交易金额
    public String bankcode = "0105";//银行代码
    public String sum = "2";//交易总金额
    public String tel = "13434343434";

    ////////测试参数////////
    public Boolean isTLTFront = false;//是否发送至前置机（由前置机进行签名）如不特别说明，商户技术不要设置为true
    //代扣的数据
    public String cerPath = "/data/web/allinpay/20060400000044502.cer";
    public String merchantId = "200604000000445";//商户号
    public String userName = "20060400000044502";//用户
    public String password = "`12qwe";//用户密码
    public String pfxPath = "/data/web/allinpay/20058100000127904.p12";//私钥证书
    public String pfxPassword = "111111";//私钥密码
    public String tltcerPath = "/data/web/allinpay/allinpay-pds.cer";//通联公钥
    public String tranURL = "https://113.108.182.3/aipg/ProcessServlet";//通联接口域名
    //代扣的数据

    //协议支付的参数
    public String quickPay_merchantId = "200604000004805";//商户号
    public String quickPay_userName = "20060400000480504";//用户
    public String quickPay_password = "111111";//用户密码
    public String quickPay_pfxPath = "/data/web/allinpay/quickPay/20060400000480504.p12";//私钥证书
    public String quickPay_pfxPassword = "111111";//私钥密码
    public String quickPay_tltcerPath = "/data/web/allinpay/quickPay/allinpay-pds.cer";//通联公钥
    public String quickPay_tranURL = "https://113.108.182.3/debugaipg/quickpay";//通联接口域名
    //协议支付的参数
    ////////测试参数////////

    /*
    ////////生产参数////////
    public Boolean isTLTFront = false;//是否发送至前置机（由前置机进行签名）如不特别说明，商户技术不要设置为true
    //代扣的数据
    public String cerPath = "/data/web/allinpay/20060400000044502.cer";
    public String merchantId = "200581000010533";//商户号
    public String userName = "20058100001053304";//用户
    public String password = "111111";//用户密码
    public String pfxPath = "/data/web/allinpay/20058100001053304.p12";//私钥证书
    public String pfxPassword = "111111";//私钥密码
    public String tltcerPath = "/data/web/allinpay/allinpay-pds.cer";//通联公钥
    public String tranURL = "http://tlt.allinpay.com/aipg/ProcessServlet";//通联接口域名
    //代扣的数据

    //协议支付的参数
    public String quickPay_merchantId = "200581000010533";//商户号
    public String quickPay_userName = "20058100001053304";//用户
    public String quickPay_password = "111111";//用户密码
    public String quickPay_pfxPath = "/data/web/allinpay/quickPay/20058100001053304.p12";//私钥证书
    public String quickPay_pfxPassword = "111111";//私钥密码
    public String quickPay_tltcerPath = "/data/web/allinpay/quickPay/allinpay-pds.cer";//通联公钥
    public String quickPay_tranURL = "https://tlt.allinpay.com/aipg/quickpay";//通联接口域名
    //协议支付的参数
    ////////生产参数////////
    */

}
