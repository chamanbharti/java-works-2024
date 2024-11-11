package functional.java_8_streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamGenerate {
    public static void main(String[] args) {
     Stream<String> stringStream = Stream.of("Chaman","Roshan");
     stringStream.forEach(System.out::println);

     Stream.iterate(1,x->x*2)
             .limit(5)
             .forEach(System.out::println);

        System.out.println("Random");
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
