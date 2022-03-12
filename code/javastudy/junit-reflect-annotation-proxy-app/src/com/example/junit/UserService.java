package com.example.junit;

/*
*业务方法
*/
public class UserService {
    public String loginName(String loginName,String password){
        if("admin".equals(loginName)&&"123456".equals(password)){
            return "success";
        }else {
            return "error";
        }
    }


    public void selectNames(){
        System.out.println(10/2);
        System.out.println("查询全部用户名称成功");
    }
}
