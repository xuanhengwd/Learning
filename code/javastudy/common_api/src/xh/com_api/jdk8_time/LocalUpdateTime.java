package xh.com_api.jdk8_time;

import java.time.LocalDate;

public class LocalUpdateTime {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        System.out.println("--------------------");
        System.out.println(ld.plusDays(2));//+两天
        System.out.println(ld.plusMonths(2));//+两月
        System.out.println(ld.plusYears(1));//+两年
        System.out.println("----------------------");
        System.out.println(ld.minusDays(4));
        System.out.println(ld.minusMonths(1));
        System.out.println(ld.minusYears(3));

        LocalDate myDate=LocalDate.of(2000,3,12);
        System.out.println(ld.equals(myDate));//==
        System.out.println(ld.isAfter(myDate));//>
        System.out.println(ld.isBefore(myDate));//<
    }
}
