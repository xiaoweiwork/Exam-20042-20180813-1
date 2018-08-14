package com.hand.filter;

import com.hand.pojo.User;
import com.sun.deploy.net.HttpRequest;
import com.sun.jndi.toolkit.url.UrlUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class MyFilter implements Filter {

    //处理get请求

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进来了");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURL().toString();
        String servletPath=request.getServletPath();
        System.out.println(servletPath);
       // System.out.println(path);
   //     System.out.println(servletPath+"ssssssssssssssss");
     //String contextPath = request.getContextPath();
     //  System.out.println(contextPath);
//        System.out.println(url);
//        System.out.println(servletPath);
         HttpSession session=request.getSession();
        User user = (User)session.getAttribute("user");
      if(servletPath.equals("/index.jsp") || servletPath.equals("/login.jsp") || servletPath.equals("/user.do") ){
             filterChain.doFilter(request, response);
      }else if(user != null) {
          filterChain.doFilter(request, response);
      }else{
            response.sendRedirect("login.jsp");
        }



    }

    @Override
    public void destroy() {

    }
}