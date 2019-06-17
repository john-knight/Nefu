package com.example.nefucc;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Intercepeter implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        从request对象中获取session内的teacher对象，如果类型转换失败，可以考虑强转（object）
        Object user = request.getSession().getAttribute("teacher");
        Object manager = request.getSession().getAttribute("manager");
        if (user == null && manager==null) {
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        } else {
            return true;
        }
    }

}