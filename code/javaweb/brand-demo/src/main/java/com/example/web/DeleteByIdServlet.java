package com.example.web;

import com.example.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取
        String id = request.getParameter("id");
        //调用service方法 删除
        service.deleteById(Integer.parseInt(id));

        //返回selectAll
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
