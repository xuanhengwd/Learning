package xh.app.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkHashCodeDemo {
    public static void main(String[] args) {
        //有序，不重复，无索引
        Set<String> s = new LinkedHashSet<>();
        s.add("java");
        s.add("c");
        s.add("python");
        s.add("java");
        System.out.println(s);
    }
}
