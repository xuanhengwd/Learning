package com.example.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.example.pojo.Brand;
import com.example.service.BrandService;
import com.example.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受品牌数据
        BufferedReader reader = request.getReader();

        String params = reader.readLine();//json字符串

        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);

        //响应
        response.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
