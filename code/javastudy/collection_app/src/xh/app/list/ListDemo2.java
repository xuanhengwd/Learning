package xh.app.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListDemo2 {
    public static void main(String[] args) {

        //遍历
        List<String> l1 = new ArrayList<>();
        l1.add("java");
        l1.add("python");
        l1.add("python");
        l1.add("java");

        System.out.println(l1);

        //迭代器
        Iterator<String> it = l1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("-----------------------");
        //for i
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }
        System.out.println("------------------");

        //foreach
        for (String s :
                l1) {
            System.out.println(s);
        }
        System.out.println("------------------");
        //lambda
        l1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        l1.forEach(s -> System.out.println(s));

        l1.forEach(System.out::println);
    }
}
