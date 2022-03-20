package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author hpr
 * @date 2022-03-17 21:18
 */
public class CommunityUtil {
    /**
     * 生成随机字符串（激活码、上传文件/头像的时候的随机名字）
     * @return
     */
    public static String generateUUID() {
        // 生成的是字母、数字、-，但只需要字母数字，所以repalace
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * MD5加密（在密码后面加随机字符串再加密）
     * hello -> abc123def456
     * hello + 3e4a8 -> abc123def456abc
     * @param key
     * @return
     */
    public static String md5(String key) {
        // key为null、空串、一个空格 都认为是空的
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
