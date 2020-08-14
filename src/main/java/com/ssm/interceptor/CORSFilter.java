package com.ssm.interceptor;


import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhangRunKai
 * @date 2020/7/27 10:43
 */
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        System.out.println("***********************************************************");
        System.out.println("拦截请求: " + httpServletRequest.getServletPath());
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        // httpServletResponse.setHeader("Access-Control-Allow-Methods", "*"); // 表示所有请求都有效
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET");
        httpServletResponse.setHeader("Access-Control-Max-Age", "0");
        httpServletResponse.setHeader("Access-Control-Allow-Headers",
                "Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("XDomainRequestAllowed", "1");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
