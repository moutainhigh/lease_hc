package com.hc.lease.common.core.mail;

/**
 * Created by Tong on 2017/4/24.
 */
public interface EmailService {

    /**
     *
     * @param toEmails
     * @param contentBul
     * @param subject
     */
    void emailManage(String toEmails, StringBuilder contentBul, String subject);

    void sendEmail(EmailModel mail);

}
