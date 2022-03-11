package com.example.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class JdbcTemplateTest {

    @Test
    public void test2() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        //执行操作
        int row = jdbcTemplate.update("insert into account values (null,?,?)", "dadada", 10000);
        System.out.println(row);

    }
    @Test
    //测试Jdbc开发模板开发步骤
    public void test1() throws Exception {

        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://123.56.129.233/db1");
        dataSource.setUser("root");
        dataSource.setPassword("824320xh@XH");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //这是数据源对象 知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);

        //执行操作
        int row = jdbcTemplate.update("insert into account values (null,?,?)", "tom", 5000);
        System.out.println(row);
    }

}
