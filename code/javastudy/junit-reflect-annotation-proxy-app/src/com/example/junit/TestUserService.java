package com.example.junit;

import org.junit.*;

/**
 * 测试类
 */
public class TestUserService {

    @Before
    public void before(){
        System.out.println("before.....");
    }
    @After
    public void after(){
        System.out.println("after.....");
    }

    //修饰静态方法
    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass.....");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass.....");
    }
    /**
     * 测试方法
     * 1、公开的，无参数，无返回值
     * 2、测试方法必须用@Test注解标记
     */
    @Test
    public void testLoginName(){
        UserService userService = new UserService();
        String rs = userService.loginName("admin", "123456");

        //预期结果正确性测试 断言
        Assert.assertEquals("功能业务可能有问题","success",rs);

    }

    @Test
    public void testSelectNames(){
        UserService userService = new UserService();
        userService.selectNames();
    }
}
