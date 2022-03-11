package xh.com_api.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormateDemo1 {
    public static void main(String[] args) throws ParseException {
        String time1 = "2021-12-24 12:20:30";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(time1);
        System.out.println(date);
    }
}
