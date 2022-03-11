package xh.app.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        //添加
        Collection<String> list = new ArrayList<>();
        list.add("java");
        list.add("c++");
        list.add("python");
        list.add("php");
        System.out.println(list.add("html"));
        System.out.println(list);
        //清空
//        list.clear();
//
//        System.out.println(list.isEmpty());

        //大小
        System.out.println(list.size());
        //是否包含
        System.out.println(list.contains("java"));
        System.out.println(list.contains("12"));

        //转换成数组
        Object[] listarr = list.toArray();
        System.out.println(Arrays.toString(listarr));


        System.out.println("-----------------------------------");
        //拼接

        Collection<String> l1 = new ArrayList<>();
        l1.add("java");
        l1.add("c++");
        Collection<String> l2 = new ArrayList<>();
        l2.add("php");
        l2.add("python");

        l1.addAll(l2);
        System.out.println(l1);
        System.out.println(l2);


    }
}
