package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        Boolean flag = service.register(user);

        //获得用户输入的checkcode
        String checkCode = request.getParameter("checkCode");
        //获得图片的
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        if(!checkCode.equalsIgnoreCase(checkCodeGen))
        {
            //验证码不相等
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        if (flag){
            //注册成功
            request.setAttribute("register_msg","注册成功！请登录");

            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","用户名已经存在");
            request.getRequestDispatcher("register.jsp").forward(request,response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
