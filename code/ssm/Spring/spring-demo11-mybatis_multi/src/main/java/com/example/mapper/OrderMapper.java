package com.example.mapper;

import com.example.pojo.Order;

import java.util.List;

public interface OrderMapper {

    //查找所有
    List<Order> findAll();
}
