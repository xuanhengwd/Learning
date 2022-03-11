package xh.app.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        //获取stream流

        //collection
        List<String> l1 = new ArrayList<>();
        Stream<String> ls = l1.stream();

        //map
        Map<String,Integer> m1 = new HashMap<>();

        //键流
        Stream<String> mks = m1.keySet().stream();

        //值流
        Stream<Integer> mvs = m1.values().stream();

        //键值对流
        Stream<Map.Entry<String, Integer>> mkvs = m1.entrySet().stream();

        //数组
        String[] s = new String[2];
        Stream<String> as = Arrays.stream(s);
        Stream<String> s1 = Stream.of(s);
    }
}
