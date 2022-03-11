package xh.app.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        //有序 可重复 有索引
        List<String> l1 = new ArrayList<>();
        l1.add("java");
        l1.add("python");
        l1.add("python");
        l1.add("java");
        l1.add("c++");
        l1.add("c");
        l1.add("go");
        System.out.println(l1);

        //在某索引位置插入
        l1.add(3,"html");
        System.out.println(l1);

        //根据索引删除元素 返回删除元素
        System.out.println(l1.remove(3));
        System.out.println(l1);

        //根据索引查找
        System.out.println(l1.get(2));

        //修改某索引位置的元素
        System.out.println(l1.set(5,"java"));
        System.out.println(l1);

    }
}

