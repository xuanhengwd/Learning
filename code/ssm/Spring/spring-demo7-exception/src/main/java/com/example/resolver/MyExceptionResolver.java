package com.example.resolver;

import com.example.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param ex 异常对象
     * @return ModelAndView 跳转的错误视图信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if(ex instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }else if(ex instanceof ClassCastException){
            modelAndView.addObject("info","类型转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
