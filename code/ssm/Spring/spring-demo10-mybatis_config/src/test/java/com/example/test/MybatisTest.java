package com.example.test;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    @Test
    public void test1() throws IOException {
        String resourse = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resourse);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setName("hhh");
        user.setPassword("123e");
        user.setBirthday(new Date());

        mapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        String resourse = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resourse);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findById(13);
        System.out.println("hhhh"+user.getBirthday());

        sqlSession.close();
    }
    @Test
    public void test3() throws IOException {
        String resourse = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resourse);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //???????????????????????? ??????????????????????????????
        PageHelper.startPage(1,3);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //???????????????????????????
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("?????????"+pageInfo.getPageNum());
        System.out.println("??????????????????"+pageInfo.getPageSize());
        System.out.println("?????????"+pageInfo.getTotal());
        System.out.println("?????????"+pageInfo.getPages());
        System.out.println("?????????"+pageInfo.getNextPage());
        System.out.println("??????????????????"+pageInfo.isIsFirstPage());

        sqlSession.close();
    }
}
