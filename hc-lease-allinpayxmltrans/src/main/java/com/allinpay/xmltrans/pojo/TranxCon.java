/**
 * 作者：tong
 * 日期：2017-5-10
 * 功能说明：交易参数
 */
package com.allinpay.xmltrans.pojo;

public class TranxCon {

    public String acctName = "张国光";
    public String acctNo = "6225882516636351";
    public String amount = "1";//交易金额
    public String bankcode = "0105";//银行代码
    public String sum = "2";//交易总金额
    public String tel = "13434343434";


    ////////测试参数////////
    public String cerPath = "E:\\luomingtong\\allinpay-config\\test\\20060400000044502.cer";
    public String merchantId = "200604000000445";//商户号
    public String userName = "20060400000044502";//用户
    public String password = "`12qwe";//用户密码
    //商户证书信息
    public String pfxPath = "E:\\luomingtong\\allinpay-config\\test\\20058100000127904.p12";//私钥证书
    public String pfxPassword = "111111";//私钥密码
    //商户证书信息
    public String tltcerPath = "E:\\luomingtong\\allinpay-config\\test\\allinpay-pds.cer";//通联公钥
    ////////测试参数////////


/*
    ////////生产参数////////
    public String cerPath = "/data/web/allinpay/20060400000044502.cer";
    public String merchantId = "200581000010533";//商户号
    public String userName = "20058100001053304";//用户
    public String password = "111111";//用户密码
    //商户证书信息
    public String pfxPath = "/data/web/allinpay/20058100001053304.p12";//私钥证书
    public String pfxPassword = "111111";//私钥密码
    //商户证书信息
    public String tltcerPath = "/data/web/allinpay/allinpay-pds.cer";//通联公钥
    ////////生产参数////////
*/


    public String getAcctName() {
        return acctName;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public String getAmount() {
        return amount;
    }

    public String getBankcode() {
        return bankcode;
    }

    public String getCerPath() {
        return cerPath;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getPassword() {
        return password;
    }

    public String getPfxPassword() {
        return pfxPassword;
    }

    public String getPfxPath() {
        return pfxPath;
    }

    public String getSum() {
        return sum;
    }

    public String getTel() {
        return tel;
    }

    public String getTltcerPath() {
        return tltcerPath;
    }

    public String getUserName() {
        return userName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public void setCerPath(String cerPath) {
        this.cerPath = cerPath;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPfxPassword(String pfxPassword) {
        this.pfxPassword = pfxPassword;
    }

    public void setPfxPath(String pfxPath) {
        this.pfxPath = pfxPath;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setTltcerPath(String tltcerPath) {
        this.tltcerPath = tltcerPath;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
