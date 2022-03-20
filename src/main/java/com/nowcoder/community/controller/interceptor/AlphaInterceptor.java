package com.nowcoder.community.controller.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hpr
 * @date 2022-03-19 23:53
 */
@Component
public class AlphaInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AlphaInterceptor.class);

    /**
     * 拦截请求时，在controller处理请求代码之前执行
     * @param request 请求
     * @param response 响应
     * @param handler 拦截目标（如com.nowcoder.community.controller.LoginController#getLoginPage()）
     * @return return false代表取消这个请求，程序不会往下执行，controller里的代码也不会执行，所以一般都return true（除非有特殊情况）
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如：preHandle: com.nowcoder.community.controller.LoginController#getLoginPage()
        logger.debug("preHandle: " + handler.toString());
        return true;
    }

    /**
     * 在controller之后执行
     * @param request 请求
     * @param response 响应
     * @param handler 拦截目标
     * @param modelAndView 模板引擎 给页面返回要渲染的内容（可能需要获取数据进一步处理）
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("postHandle: " + handler.toString());
    }

    /**
     * 在templateEngine之后执行
     * @param request 请求
     * @param response 响应
     * @param handler 拦截目标
     * @param ex 异常对象（在调用controller或者模板过程中出现异常 可以对异常处理）
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("afterCompletion: " + handler.toString());
    }
}
