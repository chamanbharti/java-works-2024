package functional.java_8_map_vs_flatmap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlapMapDemo {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("10","15","90","77");
        List<Integer> integerList = myList.stream().map(Integer::valueOf).toList();
        System.out.println("integerList:"+integerList);
        List<Integer> evenList = integerList.stream().filter(i->i%2==0).toList();
        System.out.println("evenList:"+evenList);
        List<Integer> oddList = integerList.stream().filter(i->i%2!=0).toList();
        System.out.println("oddList:"+oddList);

        List<Integer> evens = Arrays.asList(2,4,6);
        List<Integer> odds = Arrays.asList(3,5,7);
        List<Integer> primes = Arrays.asList(2,3,5,7,11);
        //List<Integer> flattenedList = Stream.of(evens, odds, primes).flatMap(list -> list.stream()).toList();
        List<Integer> flattenedList = Stream.of(evens, odds, primes)
                //.peek(t->System.out.println(t))
                .peek(System.out::println)
                .flatMap(row -> row.stream())
                .peek(System.out::println)
                .toList();
              //.flatMap(Collection::stream).toList();
        System.out.println("flattenedList:"+flattenedList);

        List<String> stringList = List.of("a","b","c","d","e","f","g","h");
        stringList.stream().parallel().peek(t->{
            System.out.println("before");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).forEach(System.out::println);
    }
}
