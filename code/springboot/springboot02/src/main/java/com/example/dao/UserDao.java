package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user where id=#{id}")
    User getById(Integer id);


    List<User> getAll();
}
