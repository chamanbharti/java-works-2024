package functional.java_8_date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;

public class LocalDateLocalTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        int dd = date.getDayOfMonth();
        System.out.println("date:"+dd);

        int mm = date.getMonthValue();
        System.out.println("month:"+mm);

        int yyyy = date.getYear();
        System.out.println("year:"+yyyy);
        System.out.printf("%d-%d-%d",dd,mm,yyyy);
        System.out.println();
        System.out.println("Day of Month using get:"+date.get(ChronoField.DAY_OF_MONTH));
        System.out.println("withYear:"+date.withYear(2019));
        System.out.println("with ChronoField:"+date.with(ChronoField.YEAR,2020));
        System.out.println("with ChronoField:"+date.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("Chrono Unit minus:"+date.minus(1, ChronoUnit.YEARS));

        LocalTime time = LocalTime.now();
        System.out.println(time);

        int h = time.getHour();
        System.out.println("hour:"+h);

        int m = time.getMinute();
        System.out.println("minute:"+m);

        int second = time.getSecond();
        System.out.println("second:"+second);
        int nanoSecond = time.getNano();
        System.out.println("nanoSecond:"+nanoSecond);
        System.out.printf("%d-%d-%d-%d",h,m,second,nanoSecond);
        System.out.println();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime:"+localDateTime);
        dd = localDateTime.getDayOfMonth();
        mm = localDateTime.getMonthValue();
        yyyy = localDateTime.getYear();
        System.out.printf("%d-%d-%d",dd,mm,yyyy);
        System.out.println("\ntime");
        h = localDateTime.getHour();
        m = localDateTime.getMinute();
        second = localDateTime.getSecond();
        nanoSecond = localDateTime.getNano();
        System.out.printf("%d-%d-%d-%d",h,m,second,nanoSecond);

        System.out.println("\nDOB");
        localDateTime = LocalDateTime.of(1989,02,12,12,12,12,12);
        System.out.println(localDateTime);
        System.out.println("after six months:"+localDateTime.plusMonths(6));
        System.out.println("before six months:"+localDateTime.minusMonths(6));
    }
}
