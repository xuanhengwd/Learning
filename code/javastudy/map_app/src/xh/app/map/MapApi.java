package xh.app.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapApi {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("吃饭",2000);
        map.put("电话费",50);
        map.put("出去玩",500);
        map.put("衣服",500);
        map.put("购买物品",1000);
        map.put("电话费",80);//覆盖
        System.out.println(map);
        //清空
        //map.clear();

        System.out.println(map.isEmpty());

        //根据键值找对应值
        Integer value1 = map.get("吃饭");
        System.out.println(value1);
        System.out.println(map.get("打游戏"));//null

        //判断是否包含某个键
        System.out.println(map.containsKey("吃饭"));
        System.out.println(map.containsKey("打游戏"));

        //是否包含某个值
        System.out.println(map.containsValue(2000));
        System.out.println(map.containsValue(800000));
        System.out.println("----------------------");

        //获取全部键的集合
        Set<String> keys = map.keySet();
        System.out.println(keys);
        //获取全部值的集合
        Collection<Integer> values = map.values();
        System.out.println(values);

        System.out.println(map.size());

        //合并
        Map<String,Integer> m1 = new HashMap<>();
        m1.put("jaja",12);
        m1.put("jcrij",34);
        Map<String,Integer> m2 = new HashMap<>();
        m2.put("fr",12);
        m2.put("gtg",34);

        m1.putAll(m2);
        System.out.println(m1);

    }
}
