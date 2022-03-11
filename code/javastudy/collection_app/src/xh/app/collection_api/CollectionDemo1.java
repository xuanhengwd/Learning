package xh.app.collection_api;

import java.util.*;

public class CollectionDemo1 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(23);
        l1.add(22);
        l1.add(2);
        l1.add(56);
        l1.add(33);
        Collections.sort(l1, (o1, o2) -> o2-o1);
        System.out.println(l1);
        List<String> l2 = new ArrayList<>();
        Collections.addAll(l2,"dekjd","doeihde","dehyue","deihdue");
        System.out.println(l2);
        //打乱集合顺序
        Collections.shuffle(l1);
        System.out.println(l1);

    }
}
