package com.example.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
        String url = req.getRequestURL().toString();

        for(String u : urls){
            if(url.contains(u)){
                filterChain.doFilter(request,response);
                return;

            }
        }

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if(user!=null){
            filterChain.doFilter(request,response);
        }
        else {
            //req.setAttribute("login_msg","您尚未登录");

            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
