package com.example.web_app1.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        //获取虚拟目录（项目访问路径）
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //获取url（统一资源定位符）
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());

        //获取URI（统一资源标识符）
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        //回去请求参数 （get方式）
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //-------------
        //获取请求头
        String header = req.getHeader("user-agent");
        System.out.println(header);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post请求体

        //获取字符输入流
        BufferedReader br = req.getReader();
        //获取数据
        String line = br.readLine();
        System.out.println(line);


    }
}
