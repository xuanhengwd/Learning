package xh.com_api.jdk8_time;

import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        //获取本地日期对象
        LocalDate ld =LocalDate.now();
        System.out.println(ld);

        //获取年月日
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

        //当年的第几天
        int dayOfYear=ld.getDayOfYear();
        System.out.println(dayOfYear);

        //星期
        System.out.println(ld.getDayOfWeek());
        System.out.println(ld.getDayOfWeek().getValue());

        System.out.println("-----------------");
        //设置时间
        LocalDate ld1 = LocalDate.of(2000, 5,22);
        System.out.println(ld1);



    }
}
