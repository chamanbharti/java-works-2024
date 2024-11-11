package functional.java_8_optional;

import functional.java_8_optional.before8.House;
import functional.java_8_optional.before8.HouseLoan;
import functional.java_8_optional.before8.Person;

public class BeforeJava8OptionalTest {

    public static void main(String[] args) {
        // before java 8
        functional.java_8_optional.before8.Person person = new Person();
        if (person!=null){
            House house = person.getHouse();
            if (house!=null){
                HouseLoan houseLoan = house.getHouseLoan();
                if (houseLoan!=null){
                    System.out.println(houseLoan.getHouseLoanDetails());
                }
            }
        }
    }
}
