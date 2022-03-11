package xh.app.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        //无序，不重复，无索引，值不做要求
        Map<String,Integer> map = new HashMap<>();
        map.put("hdeuh",2112);
        map.put("de",2132);
        map.put("jde",2372);
        map.put("dede",2372);
        System.out.println(map);

    }
}
