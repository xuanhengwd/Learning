package com.example;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot02ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
//        User user = userDao.getById(1);
//        System.out.println(user);

        PageHelper.startPage(1,3);
        List<User> users = userDao.getAll();
        System.out.println(users);

    }

}
