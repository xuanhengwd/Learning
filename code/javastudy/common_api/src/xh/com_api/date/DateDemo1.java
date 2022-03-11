package xh.com_api.date;

import java.util.Date;

public class DateDemo1 {
    public static void main(String[] args) {
        //获取日期对象
        Date d=new Date();
        System.out.println(d);

        //获取毫秒值
        long time = d.getTime();
        System.out.println(time);

        System.out.println("----------------------------");

        Date d1 = new Date();
        System.out.println(d1);

        //当前时间往后走 1h 121s
        long time2 = System.currentTimeMillis();
        time2+=(60*60+121)*1000;

        Date d3 = new Date(time2);
        System.out.println(d3);

        //或者

        Date d4 = new Date();
        d4.setTime(time2);
        System.out.println(d4);



    }
}
