package xh.app.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> t1 = new TreeSet<>();
        t1.add(1);
        t1.add(23);
        t1.add(11);
        t1.add(22);
        System.out.println(t1);

        Set<String> t2 = new TreeSet<>();
        t2.add("java");
        t2.add("c++");
        t2.add("c");
        t2.add("python");
        t2.add("java");
        t2.add("c++");
        System.out.println(t2);

        System.out.println("------------------");

        Student2 s1 = new Student2("zhai",12,98.2);
        Student2 s2 = new Student2("deui",15,88.9);
        Student2 s3 = new Student2("de",16,100);
        Student2 s4 = new Student2("deui",15,88.9);
        Set<Student2> t3 = new TreeSet<>((o1, o2) -> Double.compare(o2.getScore(),o1.getScore()));
        t3.add(s1);
        t3.add(s2);
        t3.add(s3);
        t3.add(s4);
        System.out.println(t3);


    }
}
