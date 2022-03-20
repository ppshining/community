package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author hpr
 * @date 2022-03-12 15:45
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTests {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTests.class); //以类名为logger的名字 不同类有不同的

    @Test
    public void testLogger() {
        System.out.println(logger.getName());
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }

}
