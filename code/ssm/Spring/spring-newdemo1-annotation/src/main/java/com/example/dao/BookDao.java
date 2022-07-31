package com.example.dao;


import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    public void save(){
        System.out.println("bookdao save-----");
    }


}
