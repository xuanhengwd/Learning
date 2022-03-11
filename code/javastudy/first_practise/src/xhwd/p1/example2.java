package xhwd.p1;

import java.util.Random;

/*
定义方法实现随机产生一个5位的验证码，每位可能是数字、大写字母、小写字母
 */
public class example2 {
    public static void main(String[] args) {
        String code=creatCode(5);
        System.out.println(code);

    }

    public static String creatCode(int n)
    {
        String code="";
        Random ran=new Random();
        for(int i=0;i<n;i++)
        {
            //先随机生成是大写字母、小写字母、数字，，用0-2表示
            int type=ran.nextInt(3);
            switch (type){
                case 0://大写
                    char x=(char) (ran.nextInt(26)+65);
                    code+=x;
                    break;
                case 1://小写
                    char x1=(char)(ran.nextInt(26)+97);
                    code+=x1;
                    break;
                case 2://数字
                    int x2=ran.nextInt(10);
                    code+=x2;
                    break;
            }
        }

        return code;
    }
}
