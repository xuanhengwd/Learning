package xh.app.set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo2 {
    public static void main(String[] args) {
        Student s1 = new Student("zhaoxin",12,"男");
        Student s2 = new Student("zhaoyitong",22,"男");
        Student s3 = new Student("shusu",18,"女");
        Student s4 = new Student("shusu",18,"女");
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());


        //内容一样判断为重复  要重写HashCode和equals
        Set<Student> s = new HashSet<>();
        s.add(s1);
        s.add(s2);
        s.add(s3);
        s.add(s4);
        System.out.println(s);

        for (Student st :
                s) {
            System.out.println(st);
        }
    }
}
