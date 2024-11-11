package functional.java_8_date_time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1984,03,15);
        LocalDate today = LocalDate.now();
        Period p = Period.between(birthday,today);
        System.out.printf(" Your age is %d years %d months and %d days",p.getYears(),p.getMonths(),p.getDays());
        LocalDate deathday = LocalDate.of(1989+60,8,28);
        p = Period.between(today,deathday);
        int d = p.getYears()*365+p.getMonths()*30+p.getDays();
        System.out.printf("\nyou will be on earth only %d days,hurry up to do more important things",d);
    }
}
