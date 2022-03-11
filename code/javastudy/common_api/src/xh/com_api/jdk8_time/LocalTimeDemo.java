package xh.com_api.jdk8_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime lt = LocalTime.now();
        System.out.println(lt);

        //获取时分秒
        System.out.println(lt.getHour());
        System.out.println(lt.getMinute());
        System.out.println(lt.getSecond());
        System.out.println(lt.getNano());

        //设置
        System.out.println(LocalTime.of(12,20,33));

        System.out.println("----------------");

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.getYear());
        System.out.println(ldt.getHour());
        //转换
        LocalDate ld1 = ldt.toLocalDate();
        System.out.println(ld1);
        LocalTime lt1 = ldt.toLocalTime();
        System.out.println(lt1);

    }
}
