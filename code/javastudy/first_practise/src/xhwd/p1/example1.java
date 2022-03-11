package xhwd.p1;

import java.util.Scanner;


/*
机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
按照如下规则计算机票价格：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。
 */
public class example1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入机票的原价：");
        double preCost=sc.nextDouble();
        System.out.println("请输入当前月份（1-12）：");
        int month=sc.nextInt();
        System.out.println("请输入机舱类型（a:头等 b：经济）：");
        String type=sc.next();
        double sum=cost(preCost,month,type);
        System.out.println("价格为："+sum);

    }

    public static double cost(double preCost,int month,String type)
    {
        double sum=0;
        if(month>=5&&month<=10)
        {
            switch (type)
            {
                case "a":
                    sum=preCost*0.9;
                    break;

                case "b":
                    sum=preCost*8.5;
                    break;
                default:
                    System.out.println("机舱输入错误！");
            }
        }
        else{
            switch (type)
            {
                case "a":
                    sum=preCost*0.7;
                    break;

                case "b":
                    sum=preCost*6.5;
                    break;
                default:
                    System.out.println("机舱输入错误！");
            }

        }
        return sum;
    }
}
