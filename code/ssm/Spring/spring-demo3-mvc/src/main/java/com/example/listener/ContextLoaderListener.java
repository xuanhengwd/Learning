package com.example.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

/*        ServletContext servletContext = sce.getServletContext();
        //读取xml全局参数
        String contextConfigLocation = servletContext.getInitParameter(Parameter"contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        //存储到存到servletContext域
        servletContext.setAttribute("app",app);
        System.out.println("spring 容器创建完毕");*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
