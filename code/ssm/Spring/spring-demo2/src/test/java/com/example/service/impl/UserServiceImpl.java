package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//    <bean id="userService" class="com.example.service.impl.UserServiceImpl"> </bean>
//@Component("userService")
@Service("userService")
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}")
    private  String driver;
    // <property name="userDao" ref="userDao"></property>
    @Autowired
    @Qualifier("userDao")//按照id从容器匹配
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {

        System.out.println(driver);
        userDao.save();
    }


    public void init(){

    }
    public void destory(){

    }



}
