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

        //设置分页相关参数 当前页每页显示的条数
        PageHelper.startPage(1,3);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页"+pageInfo.getPageNum());
        System.out.println("每页显示条数"+pageInfo.getPageSize());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("是否是第一页"+pageInfo.isIsFirstPage());

        sqlSession.close();
    }
}
