package com.score.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.score.util.Constant;

@WebFilter(filterName = "loginFilter", urlPatterns = "/*.html")
public class LoginFilter implements Filter {
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
 
        System.out.println("Filter is created.");
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String requestURI = request.getRequestURI();
        System.out.println("Filter -> url: "+requestURI);
        if(Constant.loginUrl.equals(requestURI)||requestURI.contains(Constant.AESSET)||Constant.TEACHER_LOGIN_URI.equals(requestURI)||Constant.STUDENT_LOGIN_URL.equals(requestURI)||Constant.TEACHER_SIGNUP_URI.equals(requestURI)||Constant.STUDENT_SIGNUP_URL.equals(requestURI)) {
         	  filterChain.doFilter(servletRequest, servletResponse);
        }else {
        	  if(Constant.STUDENT_INDEX.equals(requestURI)||
        			  Constant.STUDENT_logout_URL.equals(requestURI)||Constant.GET_MY_SCORE.equals(requestURI)||
                      Constant.SCORE.equals(requestURI)
        			  ) {
        		  Object obj=request.getSession().getAttribute("student");
                  if(obj==null){
                  	response.sendRedirect("/login.html");
                  }else {
                  	 filterChain.doFilter(servletRequest, servletResponse);
                  }
        	  }else {
        		  Object obj=request.getSession().getAttribute("teacher");
                  if(obj==null){
                  	response.sendRedirect("/login.html");
                  }else {
                  	 filterChain.doFilter(servletRequest, servletResponse);
                  }
        	  }
             
        }
    }
    @Override
    public void destroy() {
        System.out.println("Filter is destroyed.");
    }

}