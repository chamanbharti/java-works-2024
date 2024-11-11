package functional.java_8_date_time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdZonedDateTimeDemo {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZoneId la = ZoneId.of("America/Los_Angeles");
        System.out.println(la);
        ZonedDateTime zt = ZonedDateTime.now(la);
        System.out.println(zt);
        System.out.println(la.getId());
    }
}
