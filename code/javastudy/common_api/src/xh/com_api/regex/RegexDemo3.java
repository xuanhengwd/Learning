package xh.com_api.regex;

import java.util.Scanner;

public class RegexDemo3 {
    public static void main(String[] args) {
        checkPhone();
        checkEmail();
        checkTel();

    }

    public static void checkPhone(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入你的手机号：");
            String phone = sc.next();
            System.out.println(phone);
            if(phone.matches("1[3-9]\\d{9}")){
                System.out.println("格式正确!");
                break;
            }
            else {
                System.out.println("输入错误！请重新输入");
            }
        }
    }

    public static void checkEmail(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你的邮箱：");
            String email=sc.next();
            if(email.matches("\\w{1,20}@[a-zA-Z0-9]{1,20}(\\.[a-zA-Z0-9]{1,20}){1,2}")){
                System.out.println("格式正确！");
                break;
            }
            else {
                System.out.println("输入错误！重新输入！");
            }
        }

    }

    public static void checkTel(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入电话号码");
            String tel = sc.next();
            if(tel.matches("0\\d{2,10}-?\\d{5,20}")){
                System.out.println("格式正确");
                break;
            }
            else {
                System.out.println("输入错误！重新输入！");
            }
        }
    }

}
