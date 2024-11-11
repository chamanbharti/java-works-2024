package functional.java_8_optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

// https://javaconceptoftheday.com/java-8-optional-class/
// https://mkyong.com/java8/java-8-optional-in-depth/
public class OptionalTest {

    public static void main(String[] args) {

        System.out.println("Optional.empty() : It creates an empty optional object.");
        Optional<House> house = Optional.empty();
        System.out.println("house:"+house);//house:Optional.empty
        //System.out.println("house:"+house.get());//NoSuchElementException: No value present

        System.out.println("Optional.of() : It creates an Optional object with specified non-null value.");
        Optional<House> house2 = Optional.of(new House());
        System.out.println("house2:"+house2.get());

        System.out.println("Optional.ofNullable() : " +
                "It creates an Optional object with specified value if the value is non-null. " +
                "If the value is null, it returns an empty Optional.");
        House house_ = new House();
        Optional<House> house3 = Optional.ofNullable(house_);
        System.out.println("house3:"+house3.get());

        System.out.println("Checking Value Presence: isPresent() and isEmpty()");
        Optional<String> empty = Optional.empty();
        System.out.println("empty:"+empty.isPresent());
        String name = "Chaman Bharti";
        Optional<String> opt = Optional.of(name);
        System.out.println("opt:"+opt.isPresent());
        opt = Optional.ofNullable(name);
        System.out.println("opt:"+opt.isPresent());

        System.out.println("before 8\nConditional Action With ifPresent()");
        if(name != null) {
            System.out.println(name.length());
        }
        System.out.println("after 8");
        Optional<String> ifPresentObject = Optional.of(name);
        ifPresentObject.ifPresent(name1 -> System.out.println(name1.length()));

        System.out.println("Default Value With orElse()");
        String nullName = null;
        String name1 = Optional.ofNullable(nullName).orElse("Chaman");
        System.out.println(name1);

        System.out.println("Default Value With orElseGet()");
        name1 = Optional.ofNullable(nullName).orElseGet( ()-> "Bharti");
        System.out.println(name1);

        System.out.println("Difference Between orElse and orElseGet()");
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.whenOrElseGetAndOrElseOverlap_thenCorrect();

        optionalTest.Exceptions_With_orElseThrow();

        System.out.println("Conditional Return With filter()");
        optionalTest.whenOptionalFilterWorks_thenCorrect();

        optionalTest.whenFiltersWithoutOptional_thenCorrect();
        optionalTest.whenFiltersWithOptional_thenCorrect();

        System.out.println("Transforming Value With map()");
        optionalTest.givenOptional_whenMapWorks_thenCorrect();
        optionalTest.givenOptional_whenMapWorksWithFilter_thenCorrect();

        System.out.println("Transforming Value With flatMap()");
        optionalTest.givenOptional_whenFlatMapWorks_thenCorrect2();

        System.out.println("Chaining Optionals in Java 8");
        optionalTest.givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned();
        optionalTest.givenTwoOptionalsReturnedByOneArgMethod_whenChaining_thenFirstNonEmptyIsReturned();
        optionalTest.givenTwoEmptyOptionals_whenChaining_thenDefaultIsReturned();

    }
    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet( ()-> getMyDefault());
//        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        System.out.println("Default Value:"+defaultText);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        System.out.println("Default Value:"+defaultText);
    }

    public void Exceptions_With_orElseThrow(){
        System.out.println("Exceptions With orElseThrow()");
        String nullName = null;
        //String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
        //System.out.println("name:"+name);
    }

    public void whenOptionalFilterWorks_thenCorrect() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println(is2017);
    }
    public void whenFiltersWithoutOptional_thenCorrect() {
        System.out.println(priceIsInRange1(new Modem(10.0)));
        System.out.println(priceIsInRange1(new Modem(9.9)));
        System.out.println(priceIsInRange1(new Modem(null)));
        System.out.println(priceIsInRange1(new Modem(15.5)));
        System.out.println(priceIsInRange1(null));
    }
    public void whenFiltersWithOptional_thenCorrect() {
        System.out.println(priceIsInRange2(new Modem(10.0)));
        System.out.println(priceIsInRange2(new Modem(9.9)));
        System.out.println(priceIsInRange2(new Modem(null)));
        System.out.println(priceIsInRange2(new Modem(15.5)));
        System.out.println(priceIsInRange2(null));
    }
    public boolean priceIsInRange1(Modem modem) {
        boolean isInRange = false;

        if (modem != null && modem.getPrice() != null
                && (modem.getPrice() >= 10 && modem.getPrice() <= 15)) {

            isInRange = true;
        }
        return isInRange;
    }
    public boolean priceIsInRange2(Modem modem) {
        return Optional.ofNullable(modem)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <=15)
                .isPresent();
    }
    public void givenOptional_whenMapWorks_thenCorrect() {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional.map(List::size).orElse(0);
        System.out.println("size:"+size);
    }

    public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
        String password = " password ";
        Optional<String> passOptional = Optional.of(password);
        boolean correctPassword = passOptional.filter(p -> p.equals("password")).isPresent();
        System.out.println("correctPassword:"+correctPassword);
        boolean correctPassword2 = passOptional.map(String::trim).filter(p->p.equals("password")).isPresent();
        System.out.println("correctPassword2:"+correctPassword2);
    }

    public void givenOptional_whenFlatMapWorks_thenCorrect2() {
        Person2 person2 = new Person2("Chaman",26);
        Optional<Person2> person2Optional = Optional.of(person2);
        Optional<Optional<String>> nameOptionalWrapper = person2Optional.map(Person2::getName);
        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name = nameOptional.orElse("");
        System.out.println("name:"+name);
        String name1 = person2Optional.flatMap(Person2::getName).orElse("");
        System.out.println("name1:"+name1);
    }

    public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned() {
        Optional<String> found = Stream.of(getEmpty(),getHello(),getBye())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
        System.out.println("found:"+found);
    }
    public void givenTwoOptionalsReturnedByOneArgMethod_whenChaining_thenFirstNonEmptyIsReturned() {
        Optional<String> found = Stream.<Supplier<Optional<String>>>of(
                ()-> createOptional("empty"),
                ()-> createOptional("hello")
        ).map(Supplier::get)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .findFirst();

        System.out.println("found:"+found);
    }
    public  void givenTwoEmptyOptionals_whenChaining_thenDefaultIsReturned(){
        String found = Stream.<Supplier<Optional<String>>>of(
                        ()-> createOptional(null),
                        ()-> createOptional(null)
                ).map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().orElse("default");
//                .findFirst().orElseGet(()->"default");
        System.out.println("found:"+found);
    }

    private Optional<String> getEmpty() {
        return Optional.empty();
    }

    private Optional<String> getHello() {
        return Optional.of("hello");
    }

    private Optional<String> getBye() {
        return Optional.of("bye");
    }

    private Optional<String> createOptional(String input) {
        if (input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }

}
