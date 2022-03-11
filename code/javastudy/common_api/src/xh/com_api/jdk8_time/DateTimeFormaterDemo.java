package xh.com_api.jdk8_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormaterDemo {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        //格式化
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //正向格式化
        System.out.println(dtf.format(ldt));
        //逆向
        System.out.println(ldt.format(dtf));

        //解析
        LocalDateTime ldt1 = LocalDateTime.parse("2000-11-11 11:22:22",dtf);
        System.out.println(ldt1);
    }
}
