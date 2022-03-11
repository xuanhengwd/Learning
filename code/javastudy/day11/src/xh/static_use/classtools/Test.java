package xh.static_use.classtools;

public class Test {
    public static void main(String[] args) {
        int[] a= {1,2,3,4,3};
        String s = ArraysUtils.toString(a);
        System.out.println(s);

        double[] b={10};
        double aerage = ArraysUtils.getAerage(b);
        System.out.println(aerage);
    }
}
