package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/26.
 */
@Component
public class TimeInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request = [" + request + "], response = [" + response + "], handler = [" + handler + "]");
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        System.out.println("preHandle");
        request.setAttribute("startTime",new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("request = [" + request + "], response = [" + response + "], handler = [" + handler + "], modelAndView = [" + modelAndView + "]");
        System.out.println("postHandle");
        Long startTime= (Long) request.getAttribute("startTime");
        System.out.println("postHandle 耗时："+(new Date().getTime()-startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("request = [" + request + "], response = [" + response + "], handler = [" + handler + "], ex = [" + ex + "]");
        System.out.println("afterCompletion");
        Long startTime= (Long) request.getAttribute("startTime");
        System.out.println("afterCompletion 耗时："+(new Date().getTime()-startTime));
    }
}
