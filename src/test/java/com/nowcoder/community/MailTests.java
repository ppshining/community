package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author hpr
 * @date 2022-03-16 23:35
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("945327487@qq.com", "JavaMailSender邮件测试-文本", "一个小test");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "sunday");

        // 模板引擎作用主要是生成动态网页（在controller里直接返回模板路径 DispatcherServlet就会自动调）
        // 测试的时候则要主动去调thymeleaf模板引擎 核心类为TemplateEngine 该类被Spring容器管理了 需要的话可以直接注入使用
        String content = templateEngine.process("/mail/demo", context);
        // 直观看一下这个网页的内容
        System.out.println(content);

        mailClient.sendMail("945327487@qq.com", "JavaMailSender邮件测试-HTML", content);
    }

}
