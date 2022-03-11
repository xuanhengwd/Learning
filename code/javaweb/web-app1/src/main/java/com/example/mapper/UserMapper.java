package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 根据用户名密码查询
     * @param username
     * @param password
     * @return
     */
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

}
