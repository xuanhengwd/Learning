package xh.com_api.calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        //获取系统的日历对象
        Calendar cd =Calendar.getInstance();
        System.out.println(cd);
        //获取日历信息
        int year = cd.get(Calendar.YEAR);
        System.out.println(year);
        int month = cd.get(Calendar.MONTH)+1;
        System.out.println(month);
        int day = cd.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        System.out.println("----------------------");
        //修改
        cd.set(Calendar.DAY_OF_MONTH,10);
        int day1 = cd.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1);

        //增加值
        cd.add(Calendar.MONTH,3);
        int month1 = cd.get(Calendar.MONTH)+1;
        System.out.println(month1);

        //拿到此刻日期对象
        Date date = cd.getTime();
        System.out.println(date);

        //获取毫秒值
        long time=cd.getTimeInMillis();
        System.out.println(time);

    }
}
