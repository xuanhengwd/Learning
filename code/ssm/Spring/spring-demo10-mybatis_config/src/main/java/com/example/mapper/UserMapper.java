package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    void save(User user);


    User findById(@Param("id") int id);

    List<User> findAll();



}
