package xh.com_api.jdk8_time;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class InstantDemo {
    public static void main(String[] args) {
        Instant it = Instant.now();
        System.out.println(it);

        //系统此刻时间戳
        Instant instant1 = Instant.now();
        System.out.println(instant1.atZone(ZoneId.systemDefault()));

        //与Date转换
        Date dt=Date.from(instant1);
        System.out.println(dt);

        Instant it2=dt.toInstant();
        System.out.println(it2);
    }
}
