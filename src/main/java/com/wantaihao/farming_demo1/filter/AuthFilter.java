package com.wantaihao.farming_demo1.filter;

import com.wantaihao.farming_demo1.domain.User;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName="urlFilter",urlPatterns= {"/api/*"})
@Order(1)
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1= (HttpServletRequest) request;
        HttpServletResponse response1= (HttpServletResponse) response;
        HttpSession session=request1.getSession();
        User user= (User) session.getAttribute("user");
        if(user==null) {

            response1.sendRedirect("/");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
