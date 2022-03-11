package xh.app.params;

public class ParamsDemo {
    public static void main(String[] args) {
        int sum1 = sum(1, 2, 3, 4);
        System.out.println(sum1);

    }
    public static int sum(int... nums){
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res+=nums[i];
        }
        return res;
    }
}
