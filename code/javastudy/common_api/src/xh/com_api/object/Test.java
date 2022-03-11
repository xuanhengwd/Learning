package xh.com_api.object;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        Student s1= new Student("zhaosan",12,"男");
        Student s2= new Student("zhaosan",11,"男");
        String s = s1.toString();
        System.out.println(s);
        System.out.println(s1.equals(s2));


        String a1="123";
        String a2="1233";
        System.out.println(Objects.equals(a1,a2));
    }
}
