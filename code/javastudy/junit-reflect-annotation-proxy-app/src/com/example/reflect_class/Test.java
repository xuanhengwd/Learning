package com.example.reflect_class;

/**
 * 反射
 * 获取class对象
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //1.Class类中的一个静态方法：forName(全限名：包名+类名)
        Class<?> c = Class.forName("com.example.reflect_class.Student");
        System.out.println(c);

        //2、类名.class
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);
        //3.对象.getClass() 获取对象对应的Class对象
        Student s = new Student();
        Class<? extends Student> aClass = s.getClass();
        System.out.println(aClass);
    }
}
