package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     *登录方法
     * @param username
     * @param password
     * @return
     */
    public User select(String username,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;


    }

    public Boolean register(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u = mapper.selectByUsername(user.getUsername());
        if(u==null){
            //用户名 不存在 注册
            mapper.add(user);
            sqlSession.commit();

        }

        sqlSession.close();
        return u==null;
    }
}
