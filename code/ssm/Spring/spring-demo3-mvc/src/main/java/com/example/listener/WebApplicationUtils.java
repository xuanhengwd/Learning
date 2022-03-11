package com.example.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){

        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
