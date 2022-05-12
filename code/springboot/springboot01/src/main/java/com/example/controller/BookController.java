package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${country}")
    private String country;

    @Value("${user.age}")
    private String name1;
    //@GetMapping
    @RequestMapping
    public String getById(){
        System.out.println("springboot is running...");
        System.out.println(country);
        System.out.println(name1);
        return "srpingboot...";
    }



}
