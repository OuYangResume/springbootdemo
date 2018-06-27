package com.neo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @Author :Administrator
 * @Date:Created by 20:27 on 2018/6/5.
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableScheduling
public class MailServiceTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testSimpleMail() throws Exception {
        logger.info("定时任务已启动---------------- ");
        mailService.sendSimpleMail("zhangwenguang123@qq.com","你™真的是个小天才"," 一路顺丰，发财了记得叫上我。告辞");
    }
    @Test
    @Scheduled(cron = "0 0 8 ? * *"  )
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "<img src=\"https://wpimg.wallstcn.com/0e03b7da-db9e-4819-ba10-9016ddfdaed3\" alt=\"\">"+
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("974818429@qq.com","test simple mail",content);
    }
    @Test
    public void sendAttachmentsMail() {
        String filePath="e:\\tmp\\application.log";
        mailService.sendAttachmentsMail("952437594@126.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "F:\\OuYangResume.github.io\\source\\_posts\\Vue优雅使用echarts\\bar.png";

        mailService.sendInlineResourceMail("zhangwenguang123@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("ityouknow@126.com","主题：这是模板邮件",emailContent);
    }
}
