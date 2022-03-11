package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = service.select(username, password);
        //获取remenber
        String remember = request.getParameter("remember");

        if(user!=null){

            //点击了保存按钮
            if("1".equals(remember)){

                Cookie c_username=new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                //设置时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                //发送
                response.addCookie(c_username);
                response.addCookie(c_password);

            }

            //用户对象存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");

        }
        else {

            request.setAttribute("login_msg","用户名或密码错误");

            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
