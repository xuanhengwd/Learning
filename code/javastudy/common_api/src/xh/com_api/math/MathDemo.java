package xh.com_api.math;

public class MathDemo {
    public static void main(String[] args) {
// 1.取绝对值:返回正数
        System.out.println(Math.abs(10)); // 10
        System.out.println(Math.abs(-10.3)); // 10.3

        // 2.向上取整: 5
        System.out.println(Math.ceil(4.00000001)); // 5.0
        System.out.println(Math.ceil(4.0)); // 4.0
        // 3.向下取整：4
        System.out.println(Math.floor(4.99999999)); // 4.0
        System.out.println(Math.floor(4.0)); // 4.0

        // 4.求指数次方
        System.out.println(Math.pow(2 , 3)); // 2^3 = 8.0
        // 5.四舍五入 10
        System.out.println(Math.round(4.49999)); // 4
        System.out.println(Math.round(4.500001)); // 5

        System.out.println(Math.random());  // 0.0 - 1.0 （包前不包后）

        // 拓展： 3 - 9 之间的随机数  （0 - 6） + 3
        //  [0 - 6] + 3
        int data =  (int)(Math.random() * 7) + 3;
        System.out.println(data);
    }
}
