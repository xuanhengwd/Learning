package com.example.web_app1.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 解决乱码
 */
@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post getReader()
        //request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        //get： 乱码原因：
        //tomact进行url编码 默认是用的ISO_8859_1
        //同样可以用于post
        System.out.println("乱码前："+username);
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        username = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("乱码后："+username);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
