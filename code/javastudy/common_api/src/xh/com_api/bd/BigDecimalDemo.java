package xh.com_api.bd;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double a=0.1;
        double b=0.2;
        System.out.println(a+b);

        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);

        BigDecimal c1 = a1.add(b1);
        System.out.println(c1);
        double rs=c1.doubleValue();
        System.out.println(rs);

        BigDecimal a11 = BigDecimal.valueOf(10.0);
        BigDecimal b11 = BigDecimal.valueOf(3.0);
        /**
         参数一：除数 参数二：保留小数位数  参数三：舍入模式
         */
        BigDecimal c11 = a11.divide(b11, 2, RoundingMode.UP ); // 3.3333333333
        System.out.println(c11);

    }
}
