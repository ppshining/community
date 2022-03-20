package com.nowcoder.community.util;

/**
 * @author hpr
 * @date 2022-03-18 14:42
 */
public interface CommunityConstant {
    /**
     * 激活成功
     */
    int ACTIVATION_SUCCESS = 0;

    /**
     * 重复激活
     */
    int ACTIVATION_REPEAT = 1;

    /**
     * 激活失败
     */
    int ACTIVATION_FAILURE = 2;

    /**
     * 默认状态的登录凭证的超时时间：3600s(1h) * 12 = 12h
     */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    /**
     * 记住状态的登录凭证的超时时间：3600s(1h) * 24 = 24h 再×100=100days
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;
}
