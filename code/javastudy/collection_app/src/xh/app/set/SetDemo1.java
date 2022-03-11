package xh.app.set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("c++");
        set.add("python");
        set.add("java");
        System.out.println(set.add("c++"));
        System.out.println(set);
    }
}
