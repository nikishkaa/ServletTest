//package org.example.servlettest.filters;
//
//import org.example.servlettest.model.Role;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//@WebFilter(filterName = "LoggerFilter")
//public class LoggerFilter implements Filter {
//
//
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        System.out.println(new Date() + " -> Requested : " + request.getServletContext() + " / " + request.getServerName() + " / " + request.getServerPort());
//        System.out.println(new Date() + " -> Requested : " + httpServletRequest.getSession() + " / " + httpServletRequest.getRequestedSessionId() + " / " + request.getServerPort());
//        chain.doFilter(request, response);
//    }
//}
