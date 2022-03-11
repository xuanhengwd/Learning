package com.example.test;

import com.example.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    //测试scope
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao1 = (UserDao) app.getBean("userDao");


        System.out.println(userDao1);


    }

}
