package com.example.config;


import org.springframework.context.annotation.*;



//标志spring的核心配置类
@Configuration
//  <context:component-scan base-package="com.example"></context:component-scan>
@ComponentScan("com.example")
//<import resource=""
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
