package functional.java_8_FI;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionDemo implements BiFunction<List<Integer>,List<Integer>,List<Integer>> {

    @Override
    public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
        return Stream.of(list1,list2)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        BiFunctionDemo biFunction = new BiFunctionDemo();
        List<Integer> list1 = Stream.of(1, 2, 3, 4, 5, 7, 8, 9, 19).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(1, 3, 11, 33, 6, 7, 19).toList();
        System.out.println("Output for BiFunction : " + biFunction.apply(list1, list2));

        System.out.println("using lambda function ");
        BiFunction<List<Integer>,List<Integer>,List<Integer>> biFunction2 =
                (l1,l2) -> Stream.of(list1,list2)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Output for BiFunction : " + biFunction2.apply(list1, list2));
        System.out.println("after sorting");
        Function<List<Integer>,List<Integer>> sortedFunction = lists -> lists.stream().sorted().collect(Collectors.toList());
        //Function<List<Integer>,List<Integer>> sortedFunction = lists -> lists.stream().sorted().toList();
        System.out.println(biFunction2.andThen(sortedFunction).apply(list1,list2));

    }


}