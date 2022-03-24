package com.nowcoder.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author hpr
 * @date 2022-03-17 21:18
 */
public class CommunityUtil {
    /**
     * 生成随机字符串（激活码、上传文件/头像的时候的随机名字）
     * @return 随机字符串
     */
    public static String generateUUID() {
        // 生成的是字母、数字、-，但只需要字母数字，所以repalace
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * MD5加密（在密码后面加随机字符串再加密）
     * hello -> abc123def456
     * hello + 3e4a8 -> abc123def456abc
     * @param key 加过随机字符串的密码字符串
     * @return MD5加密后的字符串
     */
    public static String md5(String key) {
        // key为null、空串、一个空格 都认为是空的
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    /**
     * 转成JSON字符串
     * @param code 编号（0、1……代表某种意思）
     * @param msg 提示信息（返回给浏览器 成功/失败）
     * @param map 业务数据
     * @return JSON字符串
     */
    public static String getJSONString(int code, String msg, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if (map != null) {
            for (String key : map.keySet()) {
                json.put(key, map.get(key));
            }
        }
        return json.toString();
    }

    public static String getJSONString(int code, String msg) {
        return getJSONString(code, msg, null);
    }

    public static String getJSONString(int code) {
        return getJSONString(code, null, null);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 25);
        System.out.println(getJSONString(0, "ok", map));
    }
}
