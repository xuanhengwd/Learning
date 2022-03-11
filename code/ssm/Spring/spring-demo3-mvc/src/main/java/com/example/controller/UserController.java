package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.domain.User;
import com.example.domain.VO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

//    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    @RequestMapping("/quick")
    public String save(){
        System.out.println("Controller save running...");
        return "success";
    }


    @RequestMapping("/quick2")
    public ModelAndView save2(){

        /*
         Model:模型 作用是封装数据
         View: 视图 作用是展示数据
         */
        ModelAndView modelAndView = new ModelAndView();

        //设置模型数据
        modelAndView.addObject("username","xuanheng");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }


    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","宣恒");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model){

        model.addAttribute("username","宣恒哈哈哈");
        return "success";
    }

    //不常用
    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","巴拉巴拉");
        return "success";
    }


    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
       response.getWriter().print("hello xuanheng");
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() {
        return "haowan";
    }

    @RequestMapping("/quick8")
    @ResponseBody //转成字符串
    public String save8() {

        User user = new User();
        user.setUsername("xuanheng");
        user.setAge(22);
        String s = JSON.toJSONString(user);
        return s;
    }

    //麻烦
//    @RequestMapping("/quick9")
//    @ResponseBody
//    public User save9() throws IOException{
//        User user = new User();
//        user.setUsername("xuanheng");
//        user.setAge(22);
//        return user;
//    }


    /**
     *自动返回json字符串
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/quick10")
    @ResponseBody
    //期望SpringMVC自动将User转换成json格式的字符串
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("lisi2");
        user.setAge(32);

        return user;
    }

    /**
     * 获取基本类型
     * @param username
     * @param age
     * @throws IOException
     */
    @RequestMapping(value="/quick11")
    @ResponseBody   //不进行页面跳转
    //期望SpringMVC自动将User转换成json格式的字符串
    public void save11(String username,int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    /**
     * 直接封装实体
     * @param user
     * @throws IOException
     */
    @RequestMapping(value="/quick12")
    @ResponseBody   //不进行页面跳转
    //期望SpringMVC自动将User转换成json格式的字符串
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    /**
     * 数组
     * @param strs
     * @throws IOException
     */
    @RequestMapping(value="/quick13")
    @ResponseBody   //不进行页面跳转
    //期望SpringMVC自动将User转换成json格式的字符串
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }


    /**
     * 集合
     * @param vo
     * @throws IOException
     */
    @RequestMapping(value="/quick14")
    @ResponseBody   //不进行页面跳转
    public void save14(VO vo) throws IOException {

        System.out.println(vo);
    }

    @RequestMapping(value="/quick15")
    @ResponseBody   //不进行页面跳转
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    @RequestMapping(value="/quick16")
    @ResponseBody   //不进行页面跳转
    //required属性为false 则不需要必须有name  defaultValue默认值
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "hhhhh") String username) throws IOException {
        System.out.println(username);
    }

    //restful
    @RequestMapping(value="/quick17/{username}")
    @ResponseBody   //不进行页面跳转
    //required属性为false 则不需要必须有name  defaultValue默认值
    public void save17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping(value="/quick18")
    @ResponseBody   //不进行页面跳转
    public void save18(Date date) throws IOException {
        System.out.println(date);
    }

    /**
     * 获取请求头
     * @param user_agent
     * @throws IOException
     */
    @RequestMapping(value="/quick19")
    @ResponseBody   //不进行页面跳转
    public void save19(@RequestHeader(value = "User-Agent",required = false) String user_agent) throws IOException {
        System.out.println(user_agent);

    }

    @RequestMapping(value="/quick20")
    @ResponseBody   //不进行页面跳转
    public void save20(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException {
        System.out.println(jsessionId);

    }


    /**
     * 文件上传存储文件
     * @param username
     * @param uploadFile
     * @throws IOException
     */
    @RequestMapping(value="/quick21")
    @ResponseBody   //不进行页面跳转
    public void save21(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("C:\\Users\\24564\\Desktop\\test\\"+originalFilename));//存储文件
    }

    /**
     * 多文件
     * @param username
     * @param uploadFile
     * @throws IOException
     */
    @RequestMapping(value="/quick22")
    @ResponseBody   //不进行页面跳转
    public void save22(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\Users\\24564\\Desktop\\test\\new\\"+originalFilename));//存储文件
        }



    }


}
