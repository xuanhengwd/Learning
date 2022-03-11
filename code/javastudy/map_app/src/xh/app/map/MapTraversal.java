package xh.app.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapTraversal {
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("吃饭",2000);
        map.put("电话费",50);
        map.put("出去玩",500);
        map.put("衣服",500);
        map.put("购买物品",1000);
        System.out.println(map);

        //方式一：先获得键 在根据键找值
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key+map.get(key));
        }

        //方式二：键值对方式
        System.out.println("--------------");
        //先转成set集合
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);
        for(Map.Entry<String, Integer> entry: entries){
            System.out.println(entry.getKey()+entry.getValue());
        }

        System.out.println("--------------");
        //方式三：lambda
        map.forEach((s, integer) -> System.out.println(s+integer));
    }
}
