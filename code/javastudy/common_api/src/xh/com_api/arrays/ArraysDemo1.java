package xh.com_api.arrays;

import java.util.Arrays;

public class ArraysDemo1 {
    public static void main(String[] args) {
        int[] arr={10,34,22,43,12,3,23};
        System.out.println(arr);

        System.out.println(Arrays.toString(arr));

        //排序 默认是升序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //二分搜索，前提是有序的
        int i = Arrays.binarySearch(arr, 22);
        System.out.println(i);


        //不存在的位置 返回应该插入的位置+1
        int i1 = Arrays.binarySearch(arr, 33);
        System.out.println(i1);



    }
}
