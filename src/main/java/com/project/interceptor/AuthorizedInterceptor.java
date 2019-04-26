package com.project.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class AuthorizedInterceptor extends HandlerInterceptorAdapter {
    /**
     *访问前拦截
     * 如果返回true 表示通行
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("open");
        return super.preHandle(request, response, handler);
    }

}
