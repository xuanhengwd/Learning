package com.example;

import com.alibaba.druid.sql.ast.expr.SQLUnaryExpr;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;


    //查询
    @Test
    void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }


    //批量查询 根据id
    @Test
    void testSelectBatchIds(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
        System.out.println(userList);
    }


    //条件查询
    @Test
    void testSelectOne(){
        //只能查询只有一条的数据
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","tony");
        userMapper.selectOne(wrapper);

    }

    //查询条数
    @Test
    void testSelectCount(){


        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","test");
        //Integer count = userMapper.selectCount(null);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);

    }


    //条件查询
    @Test
    void testSelectList(){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //wrapper.eq("name","test");
        wrapper.like("name","t");
        List<User> userList = userMapper.selectList(wrapper);
        //List<User> userList = userMapper.selectList(null);
        System.out.println(userList);

//        User user = userMapper.selectByName("tony");
//        System.out.println(user);
    }

    //分页
    @Test
    void testPage(){
        Page<User> page = new Page<>(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        List<User> userList = userPage.getRecords();
        System.out.println(userList);


    }
//
//    //分页1
//    @Test
//    void testPage1(){
//
//        PageHelper.startPage(1,3).doSelectPage(new ISelect() {
//            @Override
//            public void doSelect() {
//
//            }
//        });
//        List<User> userList = userMapper.selectList(null);
//        System.out.println(userList);
//
//
//    }
    //插入
    @Test
    void testInsert(){
        User user = new User();
        user.setUserName("testName1");
        user.setPassword("123131");
        int result = userMapper.insert(user);//返回为影响行数

        System.out.println(user.getId());
    }


    //根据id更新
    @Test
    void testUpdateById(){
        User user = new User();
        user.setId(1);
        user.setPassword("12121");
        userMapper.updateById(user);

    }

    //根据条件更新
    @Test
    void testUpdate(){
        User user = new User();

        //方法一
//        user.setPassword("33333");
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("name","tony");


        //方法二
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("password","555").eq("name","tony");
        userMapper.update(null,wrapper);
    }

    //根据id删除
    @Test
    void testDeleteById(){
        int result = userMapper.deleteById(15);
        System.out.println(result);
    }

    //条件删除
    @Test
    void testDeleteByMap(){

        Map<String ,Object> map = new HashMap<>();

        map.put("name","hhh");
        int result = userMapper.deleteByMap(map);
        System.out.println(result);

    }

    @Test
    void testDelete(){

        //方法一
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("name","hhh")
//                .eq("password","123");

        //方法二 推荐
        User user = new User();
        user.setUserName("hhh");
        user.setPassword("456");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        int result = userMapper.delete(wrapper);
        System.out.println(result);
    }

    //批量删除
    @Test
    void testDeleteBatchIds(){

        List<Integer> ids = new ArrayList<>();
        ids.add(18);
        ids.add(19);
        //userMapper.deleteBatchIds(Arrays.asList(18,19));
        int result = userMapper.deleteBatchIds(ids);

    }




}
