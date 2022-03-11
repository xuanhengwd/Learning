package xh.app.run;

import xh.app.bean.Business;
import xh.app.bean.Customer;
import xh.app.bean.Movie;
import xh.app.bean.User;

import java.util.*;

public class MovieSystem {

    public static final List<User> ALL_USERS = new ArrayList<>();//存储用户

    public static final Map<Business,List<Movie>> ALL_MOVIES = new HashMap<>();

    public static final Scanner SC = new Scanner(System.in);

    public static User loginUser;


    //测试数据
    static {
        Customer c = new Customer();
        c.setLoginName("zyf888");
        c.setPassWord("123456");
        c.setUserName("黑马刘德华");
        c.setSex('男');
        c.setMoney(10000);
        c.setPhone("110110");
        ALL_USERS.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("gzl888");
        c1.setPassWord("123456");
        c1.setUserName("黑马关之琳");
        c1.setSex('女');
        c1.setMoney(2000);
        c1.setPhone("111111");
        ALL_USERS.add(c1);

        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassWord("123456");
        b.setUserName("黑马包租公");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("110110");
        b.setAddress("火星6号2B二层");
        b.setShopName("甜甜圈国际影城");
        ALL_USERS.add(b);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b , movies); // b = []

        Business b2 = new Business();
        b2.setLoginName("baozupo888");
        b2.setPassWord("123456");
        b2.setUserName("黑马包租婆");
        b2.setMoney(0);
        b2.setSex('女');
        b2.setPhone("110110");
        b2.setAddress("火星8号8B八层");
        b2.setShopName("巧克力国际影城");
        ALL_USERS.add(b2);
        // 注意，商家一定需要加入到店铺排片信息中去
        List<Movie> movies3 = new ArrayList<>();
        ALL_MOVIES.put(b2 , movies3); // b2 = []
    }


    public static void main(String[] args) {
        showMain();

    }

    private static void showMain() {
        while (true) {
            System.out.println("===============黑马电影首页=================");
            System.out.println("1、登录");
            System.out.println("2、用户注册");
            System.out.println("3、商家注册");

            System.out.println("请输入操作命令：");
            String command = SC.nextLine();
            switch (command){
                case "1":
                    login();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("输入有误请重新输入");
            }
        }
    }

    private static void login() {
        while (true) {
            System.out.println("请输入登录名称：");
            String loginName = SC.nextLine();
            System.out.println("请输入登录密码：");
            String passWord = SC.nextLine();

            User u = getUserByLoginname(loginName);
            if(u!=null){
                if(u.getPassWord().equals(passWord)){
                    loginUser = u;
                    if(u instanceof Customer){
                        showCustomerMain();
                    }else{
                        showBussinessMain();
                    }
                    return;

                }else {
                    System.out.println("密码有错误！");
                }

            }else {
                System.out.println("登录名错误！请重新输入");
            }
        }


    }

    private static void showBussinessMain() {
        while (true) {
            System.out.println("============黑马电影商家界面===================");
            System.out.println(loginUser.getUserName()+(loginUser.getSex()=='男'? "先生":"女士")+"欢迎您进入系统！");
            System.out.println("1、展示详情:");
            System.out.println("2、上架电影:");
            System.out.println("3、下架电影:");
            System.out.println("4、修改电影:");
            System.out.println("5、退出:");

            System.out.println("请输入您要操作的命令：");
            String command = SC.nextLine();
            switch (command) {
                case "1":
                    // 展示全部排片信息
                    showBussinessInfos();
                    break;
                case "2":
                    // 上架电影信息

                    break;
                case "3":
                    // 下架电影信息

                    break;
                case "4":
                    // 修改电影信息

                    break;
                case "5":
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }

        }
    }

    private static void showBussinessInfos() {

    }

    private static void showCustomerMain() {
        System.out.println("============黑马电影客户界面===================");
        System.out.println(loginUser.getUserName()+(loginUser.getSex()=='男'? "先生":"女士")+"欢迎您进入系统！");
        System.out.println("请您选择要操作的功能：");
        System.out.println("1、展示全部影片信息功能:");
        System.out.println("2、根据电影名称查询电影信息:");
        System.out.println("3、评分功能:");
        System.out.println("4、购票功能:");
        System.out.println("5、退出系统:");
        while (true) {
            System.out.println("请输入您要操作的命令：");
            String command = SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部排片信息

                    break;
                case "2":
                    break;
                case "3":
                    // 评分功能
                    break;
                case "4":
                    // 购票功能

                    break;
                case "5":
                    return; // 干掉方法
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    public static User getUserByLoginname(String loginName){
        for (User user : ALL_USERS) {
            if(user.getLoginName().equals(loginName)){
                return user;
            }
        }

        return null;
    }
}
