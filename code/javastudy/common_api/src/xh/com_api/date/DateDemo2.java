package xh.com_api.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo2 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        //格式化日期对象
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");
        String sd=sdf1.format(d);
        System.out.println(sd);
        System.out.println("-------------------------------");

        //格式化时间毫秒值
        long time1=System.currentTimeMillis();
        System.out.println(time1);
        String sd3 = sdf1.format(time1);
        System.out.println(sd3);


    }

}
