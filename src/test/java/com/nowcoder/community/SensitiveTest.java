package com.nowcoder.community;

import com.nowcoder.community.util.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author hpr
 * @date 2022-03-21 23:50
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTest {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String text = "这里不可以赌博哦";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

        text = "这里不可以☆赌☆博☆哦";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
