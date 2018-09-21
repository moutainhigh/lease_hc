package com.hc.lease.common.core.sms;

import com.google.common.collect.Lists;
import com.hc.lease.common.core.exception.GMException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Component
public class SmsApi {

    /**
     * @param mobile 接收短信的手机号码
     * @param msg    消息内容,格式:验证码：208812，请勿将此验证码发给任何号码及其他人!【良策网络】
     * @return
     * @throws Exception
     */
    public static String sendMsg(String mobile, String msg, boolean isBatch) throws GMException {

        final String password = "api:key-fd8856518de1b519adab9f91fc83ade8";
        CloseableHttpClient client = HttpClients.custom()
                .addInterceptorLast(new HttpRequestInterceptor() {
                    @Override
                    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                        request.addHeader("Accept-Encoding", "gzip");
                        request.addHeader("Authorization",
                                "Basic " + new Base64().encodeToString(password.getBytes("utf-8")));
                    }
                }).build();

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(30000)
                .setConnectTimeout(30000)
                .build();
        ByteArrayOutputStream bos;
        InputStream bis = null;
        byte[] buf = new byte[10240];

        String content = null;


        try {
            List<NameValuePair> params = Lists.newArrayList();
            params.add(new BasicNameValuePair("mobile", mobile));
            params.add(new BasicNameValuePair("message", msg));

            String requestUrl;
            if (isBatch) {
                params.add(new BasicNameValuePair("mobile_list", mobile));
                requestUrl = "http://sms-api.luosimao.com/v1/send_batch.json";
            } else {
                params.add(new BasicNameValuePair("mobile", mobile));
                requestUrl = "http://sms-api.luosimao.com/v1/send.json";
            }
            HttpPost request = new HttpPost(requestUrl);
            request.setConfig(requestConfig);
            request.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));

            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                bis = response.getEntity().getContent();
                Header[] gzip = response.getHeaders("Content-Encoding");

                bos = new ByteArrayOutputStream();
                int count;
                while ((count = bis.read(buf)) != -1) {
                    bos.write(buf, 0, count);
                }
                bis.close();

                if (gzip.length > 0 && gzip[0].getValue().equalsIgnoreCase("gzip")) {
                    GZIPInputStream gzin = new GZIPInputStream(new ByteArrayInputStream(bos.toByteArray()));
                    StringBuffer sb = new StringBuffer();
                    int size;
                    while ((size = gzin.read(buf)) != -1) {
                        sb.append(new String(buf, 0, size, "utf-8"));
                    }
                    gzin.close();
                    bos.close();

                    content = sb.toString();
                } else {
                    content = bos.toString();
                }
            } else {
                System.out.println("error code is " + response.getStatusLine().getStatusCode());
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();// 最后要关闭BufferedReader
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("content==" + content);
        return content;
    }

    public String getStatus() throws Exception {

        CloseableHttpClient client = HttpClients.custom()
                .addInterceptorLast(new HttpRequestInterceptor() {
                    @Override
                    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                        request.addHeader("Accept-Encoding", "gzip");
                        request.addHeader("Authorization", "Basic " + new Base64().encodeToString("api:b1353cf62f07dd09a2d561dcb2128045".getBytes("utf-8")));
                    }
                }).build();

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(30000)
                .setConnectTimeout(30000)
                .build();

        HttpGet request = new HttpGet("https://sms-api.luosimao.com/v1/status.json");
        request.setConfig(requestConfig);
        ByteArrayOutputStream bos;
        InputStream bis = null;
        byte[] buf = new byte[10240];

        String content = null;
        try {
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                bis = response.getEntity().getContent();
                Header[] gzip = response.getHeaders("Content-Encoding");

                bos = new ByteArrayOutputStream();
                int count;
                while ((count = bis.read(buf)) != -1) {
                    bos.write(buf, 0, count);
                }
                bis.close();

                if (gzip.length > 0 && gzip[0].getValue().equalsIgnoreCase("gzip")) {
                    GZIPInputStream gzin = new GZIPInputStream(new ByteArrayInputStream(bos.toByteArray()));
                    StringBuffer sb = new StringBuffer();
                    int size;
                    while ((size = gzin.read(buf)) != -1) {
                        sb.append(new String(buf, 0, size, "utf-8"));
                    }
                    gzin.close();
                    bos.close();

                    content = sb.toString();
                } else {
                    content = bos.toString();
                }

                System.out.println(content);
            } else {
                System.out.println("error code is " + response.getStatusLine().getStatusCode());
            }
            return content;

        } finally {
            if (bis != null) {
                bis.close();// 最后要关闭BufferedReader
            }
        }
    }

    public static void main(String args[]) {
        SmsApi s = new SmsApi();
        try {
            Long id=1223L;
            String msg = s.sendMsg("18379152911", "测试批量发送api:"+id+"【合创汽车金融】", false);
            System.out.println("**********" + msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
