package xh.com_api.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo2 {
    public static void main(String[] args) {
        int[] arr={10,34,22,43,12,3,23};
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] arr1={10,34,22,43,12,3,23};

        Arrays.sort(arr1, (o1, o2) ->(o2-o1));  //lambda
        System.out.println(Arrays.toString(arr1));

        Student[] students = new Student[3];
        students[0] = new Student("hah", 22, 175.5);
        students[1] = new Student("dde", 25, 173.5);
        students[2] = new Student("def", 19, 180.5);
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getHeight(),o2.getHeight());
            }
        });

        System.out.println(Arrays.toString(students));
    }
}
