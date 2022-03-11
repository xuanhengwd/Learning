package xh.atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        ArrayList<Accounts> accounts=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("================欢迎进入ATM系统====================");
            System.out.println("1.登录账户");
            System.out.println("2.注册开户");
            System.out.println("3.退出");
            System.out.println("请输入命令：");

            int order = sc.nextInt();

            switch (order){
                case 1://登录
                    login(accounts ,sc);
                    break;
                case 2://注册
                    register(accounts,sc);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("您输入的命令错误，请重新输入！");
            }
        }

    }

    /**
     * 登录操作
     * @param accounts
     * @param sc
     */
    private static void login(ArrayList<Accounts> accounts,Scanner sc) {

        if(accounts.size()==0)
        {
            System.out.println("当前系统账户数量为0，请注册账户！");
            return;
        }

        while (true) {
            System.out.println("请输入卡号：");
            String cardId=sc.next();

            Accounts acc=getAccountById(accounts,cardId);
            if(acc==null)
            {
                System.out.println("您输入的卡号不存在，请重新输入！");
            }

            else{

                while (true) {
                    System.out.println("请输入密码：");
                    String passWord=sc.next();
                    if(passWord.equals(acc.getPassWord()))
                    {

                        System.out.println("登录成功！欢迎进入用户操作界面！");
/*                        System.out.println("--------------------------------------------");
                        System.out.println("用户名："+acc.getUserName());
                        System.out.println("账户金额："+acc.getMoney());
                        System.out.println("当日限取额度："+acc.getLimit());
                        System.out.println("--------------------------------------------");*/
                        operation(acc,accounts,sc);//进入用户操作
                        return;
                    }
                    else {
                        System.out.println("您输入的密码错误请重新输入！");
                    }
                }

            }
        }


    }

    /**
     * 用户操作
     * @param acc
     * @param accounts
     * @param sc
     */
    private static void operation(Accounts acc,ArrayList<Accounts>accounts,Scanner sc) {

        while (true) {
            System.out.println("====================欢迎进入ATM用户操作面板==========================");
            System.out.println("1、查询");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销当前账户");

            System.out.println("请输入命令操作：");
            int order = sc.nextInt();
            switch (order){
                case 1://查询
                    query(acc);
                    break;
                case 2://存款
                    updateMoney(acc,sc);
                    break;
                case 3://取款
                    withdrawMoney(acc,sc);
                    break;
                case 4://转账
                    transferMoney(acc,accounts,sc);
                    break;
                case 5://修改密码
                    updatePassWord(acc,sc);
                    return;
                case 6://退出
                    return;
                case 7://注销
                    accounts.remove(acc);
                    return;
                default:
                    System.out.println("您输入的命令有误！请重新输入！");

            }
        }


    }

    /**
     * 修改密码
     * @param acc
     * @param sc
     */
    private static void updatePassWord(Accounts acc,Scanner sc) {
        while (true) {
            System.out.println("请输入要修改的密码：");
            String passWord=sc.next();
            System.out.println("请确认：");
            String okWord=sc.next();
            if(passWord.equals(okWord))
            {
                acc.setPassWord(passWord);
                System.out.println("修改成功！");
                return;
            }
            else {
                System.out.println("输入错误，请重新输入！");
            }
        }

    }

    /**
     * 转账
     * @param acc
     * @param sc
     */
    private static void transferMoney(Accounts acc, ArrayList<Accounts>accounts ,Scanner sc) {
        if(accounts.size()<2){
            System.out.println("该银行系统没有别的账户可以转账啦！");
            return;
        }

        double money;
        //判断输入的钱是否符合要求
        while (true) {
            System.out.println("请输入你要转账的金额");
            money=sc.nextDouble();
            if(money>acc.getMoney())
            {
                System.out.println("您没有那么多钱！");
            }
            else {
                if(money>acc.getLimit())
                {
                    System.out.println("超出限额啦！");
                }
                else {
                    break;
                }
            }
        }


        //卡号判断
        while (true) {
            System.out.println("请输入转账对象的卡号：");
            String cardId=sc.next();
            Accounts tacc=getAccountById(accounts,cardId);

            if(tacc==null||acc.getCardId().equals(tacc.getCardId())){
                System.out.println("您输入的卡号不存在或者输入的是自己的卡号，请重新输入");
            }
            else {
                System.out.println("您当前要为*"+tacc.getUserName().substring(1));
                while (true) {
                    System.out.println("请输入姓氏：");
                    String xing=sc.next();
                    if(tacc.getUserName().startsWith(xing)){
                        tacc.setMoney(tacc.getMoney()+money);
                        System.out.println("转账成功！");
                        return;

                    }
                    else{
                        System.out.println("输入有误，请重新输入");
                    }
                }
            }
        }

    }


    /**
     * 取款
     * @param acc
     * @param sc
     */
    private static void withdrawMoney(Accounts acc, Scanner sc) {
        if(acc.getMoney()==0)
        {
            System.out.println("您当前的账户没有钱咯！存钱再取吧！");
            return;
        }
        while (true) {
            System.out.println("请输入你要取出的金额：");
            double money=sc.nextDouble();

            if(money>acc.getLimit())
            {
                System.out.println("您超出了当日限额！取少点啦！");
            }
            else {

                if(money>acc.getMoney())
                {
                    System.out.println("您的账户没这么多钱啦，少点吧！");
                }
                else {
                    acc.setMoney(acc.getMoney()-money);
                    System.out.println("取款成功！");
                    return;
                }

            }
        }

    }


    /**
     * 存款
     * @param acc
     * @param sc
     */
    private static void updateMoney(Accounts acc, Scanner sc) {
        System.out.println("请输入你的存款金额：");
        double money=sc.nextDouble();

        acc.setMoney(acc.getMoney()+money);
        System.out.println("存款成功！");

    }

    /**
     * 查询
     * @param acc
     */
    private static void query(Accounts acc) {
        System.out.println("====================欢迎进入ATM用户详情页==========================");
        System.out.println("您的账户信息如下：");
        System.out.println("卡号："+acc.getCardId());
        System.out.println("姓名："+acc.getUserName());
        System.out.println("余额："+acc.getMoney());
        System.out.println("当日取现限额："+acc.getLimit());
    }

    /**
     * 注册账号
     * @param accounts
     */
    private static void register(ArrayList<Accounts> accounts,Scanner sc) {
        Accounts acc=new Accounts();
        System.out.println("请输入用户名：");
        String userName = sc.next();
        acc.setUserName(userName);

        while (true) {
            System.out.println("请输入密码：");
            String passWord = sc.next();
            System.out.println("请在次确认密码：");
            String okPassWord=sc.next();
            if(passWord.equals(okPassWord))
            {
                acc.setPassWord(passWord);
                break;
            }
            else {
                System.out.println("您输入的密码有误，请重新设置密码！");
            }

        }

        System.out.println("请输入当日取现额度：");
        double limit = sc.nextDouble();
        acc.setLimit(limit);

        //获取卡号 8位 不同
        String cardId= "";
        while (true) {
            cardId = createCardId();
            Accounts account = getAccountById(accounts, cardId);
            if(account==null)
            {
                acc.setCardId(cardId);
                break;
            }
        }

        accounts.add(acc);
        System.out.println(acc.getUserName()+"先生/女士,您的账户创建成功！卡号为："+acc.getCardId());



    }

    /**
     * 找用户
     * @param accounts
     * @param cardId
     */
    private static Accounts getAccountById(ArrayList<Accounts> accounts,String cardId) {

        for (Accounts acc : accounts) {
            if (acc.getCardId().equals(cardId))
                return acc;
        }
        return null;
    }

    private static String createCardId() {

        Random r=new Random();
        String code="";
        for (int i=0;i<8;i++)
        {
            int c=r.nextInt(10);

            code+=c;
        }

        return code;
    }
}
