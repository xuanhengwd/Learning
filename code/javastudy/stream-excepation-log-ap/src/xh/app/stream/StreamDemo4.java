package xh.app.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    /**
     目标：收集Stream流的数据到 集合或者数组中去。
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        Stream<String> l1 = list.stream().filter(s -> s.startsWith("张"));
        List<String> list1 = l1.collect(Collectors.toList());
        System.out.println(list1);

        Stream<String> l2 = list.stream().filter(s -> s.startsWith("张"));
        Set<String> set1 = l2.collect(Collectors.toSet());
        System.out.println(set1);

        Stream<String> s3 = list.stream().filter(s -> s.startsWith("张"));
        Object[] objects = s3.toArray();
        System.out.println(Arrays.toString(objects));

    }
}
