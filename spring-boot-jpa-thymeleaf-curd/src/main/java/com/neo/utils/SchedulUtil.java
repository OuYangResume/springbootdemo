package com.neo.utils;

import com.neo.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author :Administrator
 * @Date:Created by 9:57 on 2018/6/6.
 * @Description:
 */
@Component
@EnableScheduling // 启用定时任务
public class SchedulUtil {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private MailService mailService;
//    @Scheduled(cron = "0/5 * * * * ?") // 每20秒执行一次
//    @Scheduled(fixedRate = 6000) //每6秒
    public void testSimpleMail() {
        logger.info("现在时间：" + dateFormat.format(new Date()));
        mailService.sendSimpleMail("15180191339@139.com","test simple mail"," hello this is simple mail");
    }
//    @Scheduled(fixedRate = 60000)
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "F:\\OuYangResume.github.io\\source\\_posts\\Vue优雅使用echarts\\bar.png";

        mailService.sendInlineResourceMail("zhangwenguang123@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
}
