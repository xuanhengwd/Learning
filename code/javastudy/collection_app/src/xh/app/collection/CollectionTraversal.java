package xh.app.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class CollectionTraversal {
    public static void main(String[] args) {
        Collection<String> l1 = new ArrayList<>();
        l1.add("java");
        l1.add("c++");
        l1.add("python");
        l1.add("php");
        l1.add("html");
        System.out.println(l1);

        //迭代器
        Iterator<String> it = l1.iterator();
        while (it.hasNext()){
            String s= it.next();
            System.out.println(s);
        }
        System.out.println("-------------------");

        //foreach
        for (String s:l1) {
            System.out.println(s);
        }

        System.out.println("-------------------");
        //lambda
//        l1.forEach(s -> System.out.println(s));
        l1.forEach(System.out::println);
    }
}
