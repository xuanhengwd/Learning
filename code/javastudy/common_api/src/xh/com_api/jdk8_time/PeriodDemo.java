package xh.com_api.jdk8_time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {
    public static void main(String[] args) {

        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        LocalDate myday = LocalDate.of(2000,5,22);
        System.out.println(myday);

        Period pd = Period.between(myday,ld);//第二个参数减去第一个参数
        System.out.println(pd.getYears());
        System.out.println(pd.getMonths());
        System.out.println(pd.getDays());

    }
}
