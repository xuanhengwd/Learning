package xhwd.p1.gouwuche;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Goods[] shopCar=new Goods[100];//购物车
        //添加add，查询query，修改数量update，支付pay
        Scanner sc=new Scanner(System.in);

        while(true)
        {
            System.out.println("添加商品：add");
            System.out.println("查血：query");
            System.out.println("修改数量：update");
            System.out.println("支付金额：pay");
            System.out.println("退出：exist");
            System.out.println("请输入对应指令：");
            String command=sc.next();

            switch (command){
                case "add":
                    addGoods(shopCar,sc);
                    break;
                case "query":
                    queryGoods(shopCar);
                    break;
                case "update":
                    updateGoods(shopCar,sc);
                    break;
                case "pay":
                    pay(shopCar);
                    break;
                case "exist":
                    return;
                default:
                    System.out.println("输入错误！请重新输入！");
            }
        }


    }

    public static void pay(Goods[] shopCar) {
        double sum=0;
        for(int i=0;i<shopCar.length;i++)
        {
            if(shopCar[i]!=null)
            {
                sum+=(shopCar[i].getPrice()*shopCar[i].getNumber());
            }
        }

        System.out.println("您要支付的总价为："+sum);

    }

    public static void updateGoods(Goods[] shopCar,Scanner sc) {
        if(shopCar.length>0)
        {
            while (true)
            {
                System.out.println("请输入你想修改商品的id：");
                int id=sc.nextInt();
                Goods g=searchById(shopCar,id);
                if(g!=null)
                {
                    System.out.println("请输入修改数量：");
                    int number=sc.nextInt();
                    g.setNumber(number);
                    System.out.println("修改成功！");
                    queryGoods(shopCar);
                    break;
                }
                else {
                    System.out.println("您输入的id不存在！请重新输入！");
                }
            }


        }
        else {
            System.out.println("您的购物车是空滴！");
        }


    }
    public static Goods searchById(Goods[] shopCar,int id)
    {
        for(int i=0;i<shopCar.length;i++)
        {
            if(shopCar[i]!=null)
            {
                if(shopCar[i].getId()==id)
                    return shopCar[i];
            }
            else {
                break;
            }

        }
        return null;
    }

    public static void queryGoods(Goods[] shopCar) {
        if(shopCar.length>0)
        {
            for (int i = 0; i < shopCar.length; i++) {
                Goods g = shopCar[i];
                if (g != null) {
                    System.out.println("id:" + g.getId() + "\t"
                            + "name:" + g.getName() + "\t"
                            + "price:" + g.getPrice() + "\t"
                            + "number:" + g.getNumber()
                    );
                } else {
                    break;
                }

            }
        }
        else {
            System.out.println("您的购物车为空");
        }

    }

    public static void addGoods(Goods[] shopcCar,Scanner sc){
        Goods g=new Goods();
        System.out.println("输入商品的id：");
        int id=sc.nextInt();
        System.out.println("请输入商品的名称：");
        String name=sc.next();
        System.out.println("请输入商品的价格：");
        double price=sc.nextDouble();
        System.out.println("请输入商品的数量：");
        int number=sc.nextInt();

        g.setId(id);
        g.setName(name);
        g.setPrice(price);
        g.setNumber(number);

        for(int i=0;i<shopcCar.length;i++)
        {
            if(shopcCar[i]==null)
            {
                shopcCar[i]=g;
                break;
            }
        }

    }
}
