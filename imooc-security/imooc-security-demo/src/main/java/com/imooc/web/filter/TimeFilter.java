package com.imooc.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/26.
 */
//@Component
public class TimeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filterConfig = [" + filterConfig + "]");
        System.out.println("time filter init ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("request = [" + request + "], response = [" + response + "], chain = [" + chain + "]");
        System.out.println("time filter start");
        long startTime=new Date().getTime();
        chain.doFilter(request,response);
        long endTime=new Date().getTime();
        System.out.println("time filter 耗时："+(endTime-startTime));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destory");
    }
}
