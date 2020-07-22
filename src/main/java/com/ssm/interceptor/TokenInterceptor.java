package com.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import com.ssm.bean.JwtUtil;

/**
 * @author ZhangRunKai
 * @date 2020/7/9 17:25
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        System.out.println("进入拦截器");
        String auth=request.getHeader("auth");
        System.out.println(auth);
        if(auth != null || JwtUtil.verify(auth)) return true;
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie =  cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }
    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
//
//    /**
//     * 返回信息给客户端
//     *
//     * @param response
//     * @param out
//     * @param apiResponse
//     */
//    private void responseMessage(HttpServletRequest request, HttpServletResponse response, PrintWriter out, ApiResponse apiResponse) throws IOException {
//        response.setContentType("application/json; charset=utf-8");
//        out.print(JSONObject.toJSONString(apiResponse));
//        out.flush();
//        out.close();
//    }
}
