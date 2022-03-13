package com.example.web.servlet;

import com.alibaba.fastjson.JSON;
import com.example.pojo.Brand;
import com.example.pojo.PageBean;
import com.example.service.BrandService;
import com.example.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<Brand> brands = brandService.selectAll();

        String s = JSON.toJSONString(brands);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);

    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //接受品牌数据
        BufferedReader reader = request.getReader();

        String params = reader.readLine();//json字符串

        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);

        //响应
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //接受数据 [1,2,3]
        BufferedReader reader = request.getReader();

        String params = reader.readLine();//json字符串

        //转换成数组
        int[] ids = JSON.parseObject(params, int[].class);


        brandService.deleteByIds(ids);

        //响应
        response.getWriter().write("success");
    }

    /**
     * 单个 删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //接受数据 1
        BufferedReader reader = request.getReader();

        String params = reader.readLine();//json字符串

        //转换成数组
        int id = JSON.parseObject(params, int.class);


        brandService.deleteById(id);

        //响应
        response.getWriter().write("success");
    }

    /**
     * 修改
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //接受数据 1
        BufferedReader reader = request.getReader();
        String params = reader.readLine();//json字符串
        //转换成数组
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);
        brandService.updateById(brand);
        //响应
        response.getWriter().write("success");

    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        String s = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);

    }

    /**
     * 分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取条件查询对象
        BufferedReader reader = request.getReader();
        String params = reader.readLine();//json字符串
        //转换成Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);

        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);

        String s = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);

    }
}
