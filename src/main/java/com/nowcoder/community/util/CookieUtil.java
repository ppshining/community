package com.nowcoder.community.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hpr
 * @date 2022-03-20 9:57
 */
public class CookieUtil {

    /**
     * 从request中获取对应name的cookie值
     * @param request 请求
     * @param name cookie名
     * @return 对应name的cookie的value
     */
    public static String getValue(HttpServletRequest request, String name) {
        if (request == null || name == null) {
            throw new IllegalArgumentException("参数为空！");
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }
}
