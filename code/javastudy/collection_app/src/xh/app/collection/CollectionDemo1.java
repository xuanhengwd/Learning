package xh.app.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //有序 可重复 有索引
        Collection list = new ArrayList();
        list.add("dweu");
        list.add("de");
        list.add(123);
        list.add(false);
        System.out.println(list);

        Collection list2 = new HashSet();
        list2.add("12");
        list2.add(12);
        list2.add("java");
        list2.add("hhhh");
        list2.add("java");
        System.out.println(list2);


        System.out.println("------------------------");
        Collection<String> list3 = new ArrayList<>();
        list3.add("12");





    }
}
