package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author hpr
 * @date 2022-03-08 14:01
 */
@Configuration
public class AlphaConfig {

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        // @bean注解将方法返回的对象装配到容器里
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
