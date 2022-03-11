package xh.com_api.jdk8_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DurationDemo {

    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        LocalDateTime myDay = LocalDateTime.of(2000,5,22,4,20,20);
        System.out.println(myDay);

        Duration du = Duration.between(myDay,today);
        System.out.println(du.toDays());
        System.out.println(du.toHours());
        System.out.println(du.toMinutes());
        System.out.println(du.toSeconds());
        System.out.println(du.toMillis());
    }
}
