package com.neo.service;

/**
 * @Author :Administrator
 * @Date:Created by 19:48 on 2018/6/5.
 * @Description:
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);

     void sendHtmlMail(String to, String subject, String content);

    void sendAttachmentsMail(String to, String subject, String content, String filePath);

     void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
