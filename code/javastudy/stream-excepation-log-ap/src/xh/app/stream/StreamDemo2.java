package xh.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        //获得stream流
        //Stream<String> ls = list.stream();
        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        long count = list.stream().filter(s -> s.startsWith("张")).count();
        System.out.println(count);

        list.stream().filter(s->s.startsWith("张")).limit(2).forEach(s-> System.out.println(s));
        System.out.println("---------");
        list.stream().filter(s->s.startsWith("张")).skip(2).forEach(s-> System.out.println(s));

        // map加工方法: 第一个参数原材料  -> 第二个参数是加工后的结果。
        // 给集合元素的前面都加上一个：黑马的：
        list.stream().map(s->"hhh"+s).forEach(s-> System.out.println(s));

        list.stream().map(s->new Student(s)).forEach(s-> System.out.println(s));
        
        //合并流
        Stream<String> s1 = list.stream().filter(s -> s.startsWith("张"));
        Stream<String> s2 = Stream.of("jaa","deu");

        Stream<String> s3 = Stream.concat(s1, s2);

        s3.distinct().forEach(s-> System.out.println(s));//去重
    }
}
