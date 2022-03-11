package xh.com_api.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        String startTime="2020年11月11日 0:0:0";
        String endTime="2020年11月11日 0:10:0";

        String xiaojia = "2020年11月11日 0:03:47";
        String xiaopi = "2020年11月11日 0:10:11";

        //解析
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date st = sdf.parse(startTime);
        Date et = sdf.parse(endTime);
        Date xj = sdf.parse(xiaojia);
        Date xp = sdf.parse(xiaopi);

        //判断
        judgeTime(st,et,xj);
        judgeTime(st,et,xp);


    }

    /**
     *
     * @param st 开始时间
     * @param et 结束时间
     * @param ut 用户秒杀时间
     */
    public static void judgeTime(Date st,Date et,Date ut)
    {
        if(ut.after(st)&&ut.before(et))
        {
            System.out.println("恭喜！！！秒杀成功！");
        }
        else {
            System.out.println("秒杀失败！！！");
        }
    }
}
